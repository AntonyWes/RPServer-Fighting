package net.lil_requiem.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lil_requiem.RPServerFighting;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup WEAPONS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RPServerFighting.MODID, "weapons"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.weapons"))
                    .icon(() -> new ItemStack(ModItems.SCEPTER)).entries((displayContext, entries) -> {
                        entries.add(ModItems.SCEPTER);


                    }).build());


    public static void registerItemGroups() {
        RPServerFighting.LOGGER.info("Registering Item Groups for " + RPServerFighting.MODID);
    }
}
