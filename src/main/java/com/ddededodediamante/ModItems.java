package com.ddededodediamante;

import java.lang.reflect.Field;
import java.util.function.Function;

import com.ddededodediamante.item.PoopPiece;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item POOP_PIECE = register("poop_piece", PoopPiece::new,
            new Item.Settings().food(
                    new FoodComponent.Builder().nutrition(1).saturationModifier(0.2f).build()));

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> {
                    itemGroup.add(ModItems.POOP_PIECE);
                });

        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.DDES_ITEM_GROUP_KEY).register((itemGroup) -> {
            for (Field field : ModItems.class.getDeclaredFields()) {
                try {
                    Object value = field.get(null);
                    if (value instanceof Item item) {
                        itemGroup.add(item);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM,
                Identifier.of(ddepoopmodMod.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
}