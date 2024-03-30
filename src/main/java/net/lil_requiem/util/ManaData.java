package net.lil_requiem.util;

import net.minecraft.nbt.NbtCompound;

public class ManaData {
    public static int addMana(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int mana = nbt.getInt("mana");
        if(mana + amount >= 10) {
            mana = 10;
        } else {
            mana += amount;
        }

        nbt.putInt("mana", mana);
        // sync the data
        return mana;
    }

    public static int removeMana(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int mana = nbt.getInt("mana");
        if(mana - amount < 0) {
            mana = 0;
        } else {
            mana -= amount;
        }

        nbt.putInt("mana", mana);
        // syncThirst(thirst, (ServerPlayerEntity) player);
        return mana;
    }

}
