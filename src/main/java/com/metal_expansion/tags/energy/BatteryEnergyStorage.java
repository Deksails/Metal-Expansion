package com.metal_expansion.tags.energy;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.energy.EnergyHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

public class BatteryEnergyStorage implements EnergyHandler {
    private final ItemAccess itemAccess;
    private final Item validItem;

    public BatteryEnergyStorage(ItemAccess itemAccess) {
        this.itemAccess = itemAccess;
        this.validItem = itemAccess.getResource().getItem();
    }

    @Override
    public long getAmountAsLong() {
        int itemCount = this.itemAccess.getAmount();
        if (itemCount == 0 || !this.itemAccess.getResource().is(this.validItem)) {
            return 0;
        }

        return (long) itemCount * Battery.get(this.itemAccess.getResource().toStack());
    }

    @Override
    public long getCapacityAsLong() {
        int itemCount = this.itemAccess.getAmount();
        if (itemCount == 0 || !this.itemAccess.getResource().is(this.validItem)) {
            return 0;
        }

        return (long) itemCount * Battery.MAX;
    }

    @Override
    public int insert(int maxAmount, TransactionContext transaction) {
        if (maxAmount <= 0) {
            return 0;
        }

        int itemCount = this.itemAccess.getAmount();
        if (itemCount == 0) {
            return 0;
        }

        ItemResource currentResource = this.itemAccess.getResource();
        if (!currentResource.is(this.validItem)) {
            return 0;
        }

        int amountPerItem = maxAmount / itemCount;
        if (amountPerItem <= 0) {
            return 0;
        }

        int energy = Battery.get(currentResource.toStack());
        int insertedPerItem = Math.min(Battery.MAX - energy, amountPerItem);
        if (insertedPerItem <= 0) {
            return 0;
        }

        ItemResource filledResource = withEnergy(currentResource, energy + insertedPerItem);
        try (Transaction nestedTransaction = Transaction.open(transaction)) {
            int changedItems = this.itemAccess.exchange(filledResource, itemCount, nestedTransaction);
            if (changedItems > 0) {
                nestedTransaction.commit();
                return insertedPerItem * changedItems;
            }
        }

        return 0;
    }

    @Override
    public int extract(int maxAmount, TransactionContext transaction) {
        if (maxAmount <= 0) {
            return 0;
        }

        int itemCount = this.itemAccess.getAmount();
        if (itemCount == 0) {
            return 0;
        }

        ItemResource currentResource = this.itemAccess.getResource();
        if (!currentResource.is(this.validItem)) {
            return 0;
        }

        int amountPerItem = maxAmount / itemCount;
        if (amountPerItem <= 0) {
            return 0;
        }

        int energy = Battery.get(currentResource.toStack());
        int extractedPerItem = Math.min(energy, amountPerItem);
        if (extractedPerItem <= 0) {
            return 0;
        }

        ItemResource emptiedResource = withEnergy(currentResource, energy - extractedPerItem);
        try (Transaction nestedTransaction = Transaction.open(transaction)) {
            int changedItems = this.itemAccess.exchange(emptiedResource, itemCount, nestedTransaction);
            if (changedItems > 0) {
                nestedTransaction.commit();
                return extractedPerItem * changedItems;
            }
        }

        return 0;
    }

    private static ItemResource withEnergy(ItemResource resource, int energy) {
        ItemStack stack = resource.toStack();
        Battery.set(stack, energy);
        return ItemResource.of(stack);
    }
}
