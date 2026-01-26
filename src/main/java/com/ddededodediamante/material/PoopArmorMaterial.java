package com.ddededodediamante.material;

import java.util.Map;

import com.ddededodediamante.ddepoopmodMod;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class PoopArmorMaterial {
    public static final int BASE_DURABILITY = 30;

    public static final RegistryKey<EquipmentAsset> POOP_ARMOR_MATERIAL_KEY = RegistryKey.of(
            RegistryKey.ofRegistry(Identifier.of("minecraft", "equipment_asset")),
            Identifier.of(ddepoopmodMod.MOD_ID, "poop"));

    public static final TagKey<Item> REPAIRS_POOP_ARMOR = TagKey.of(
            RegistryKeys.ITEM,
            Identifier.of(ddepoopmodMod.MOD_ID, "repairs_poop_armor"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 1,
                    EquipmentType.CHESTPLATE, 2,
                    EquipmentType.LEGGINGS, 2,
                    EquipmentType.BOOTS, 1),
            7,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
            0.0F,
            0.0F,
            REPAIRS_POOP_ARMOR,
            POOP_ARMOR_MATERIAL_KEY);
}
