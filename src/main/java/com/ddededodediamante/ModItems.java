package com.ddededodediamante;

import java.lang.reflect.Field;
import java.util.function.Function;

import com.ddededodediamante.item.PoopPiece;
import com.ddededodediamante.material.PoopArmorMaterial;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item POOP_PIECE = register(
            "poop_piece",
            PoopPiece::new,
            new Item.Settings().food(
                    new FoodComponent.Builder().nutrition(1).saturationModifier(0.2f).build()));

    public static final Item POOP_HELMET = register(
            "poop_helmet",
            Item::new,
            new Item.Settings()
                    .armor(PoopArmorMaterial.INSTANCE, EquipmentType.HELMET)
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(PoopArmorMaterial.BASE_DURABILITY)));

    public static final Item POOP_CHESTPLATE = register(
            "poop_chestplate",
            Item::new,
            new Item.Settings()
                    .armor(PoopArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE)
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(PoopArmorMaterial.BASE_DURABILITY)));

    public static final Item POOP_LEGGINGS = register(
            "poop_leggings",
            Item::new,
            new Item.Settings()
                    .armor(PoopArmorMaterial.INSTANCE, EquipmentType.LEGGINGS)
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(PoopArmorMaterial.BASE_DURABILITY)));

    public static final Item POOP_BOOTS = register(
            "poop_boots",
            Item::new,
            new Item.Settings()
                    .armor(PoopArmorMaterial.INSTANCE, EquipmentType.BOOTS)
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(PoopArmorMaterial.BASE_DURABILITY)));

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.ROTTEN_FLESH, ModItems.POOP_PIECE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.addBefore(Items.LEATHER_HELMET,
                    ModItems.POOP_HELMET,
                    ModItems.POOP_CHESTPLATE,
                    ModItems.POOP_LEGGINGS,
                    ModItems.POOP_BOOTS);
        });

        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.DDES_ITEM_GROUP_KEY).register(entries -> {
            for (Field field : ModItems.class.getDeclaredFields()) {
                try {
                    Object value = field.get(null);
                    if (value instanceof Item item) {
                        entries.add(item);
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
