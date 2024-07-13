package com.example.guardianexpansion.Collections;

import com.example.guardianexpansion.Items.GuardianBeamItem;
import com.example.guardianexpansion.Materials.ElderGuardianArmorMaterial;
import com.example.guardianexpansion.Materials.GuardianArmorMaterial;
import com.example.guardianexpansion.Materials.PrismarineArmorMaterial;
import com.example.guardianexpansion.Materials.PrismarineToolMaterial;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;

public class ItemsCollection {
    // Mod Items
    public static final Item ELDER_PRISMARINE_SHARD = new Item(new FabricItemSettings());
    public static final Item OCEAN_UPGRADE_TEMPLATE = new Item(new FabricItemSettings());

    // Mod Tools
    public static final ToolItem PRISMARINE_SWORD = new SwordItem(PrismarineToolMaterial.INSTANCE, -1, -2.2f, new FabricItemSettings());
    public static final ToolItem PRISMARINE_PICKAXE = new PickaxeItem(PrismarineToolMaterial.INSTANCE, -3, -2.2f, new FabricItemSettings());
    public static final ToolItem PRISMARINE_AXE = new AxeItem(PrismarineToolMaterial.INSTANCE, 1, -3.1f, new FabricItemSettings());
    public static final ToolItem PRISMARINE_SHOVEL = new ShovelItem(PrismarineToolMaterial.INSTANCE, -3, -2.2f, new FabricItemSettings());
    public static final ToolItem PRISMARINE_HOE = new HoeItem(PrismarineToolMaterial.INSTANCE, -4, -2.2f, new FabricItemSettings());

    // Mod Armor
    public static final ArmorMaterial PRISMARINE_ARMOR_MATERIAL = new PrismarineArmorMaterial();
    public static final Item PRISMARINE_HELMET = new ArmorItem(PRISMARINE_ARMOR_MATERIAL, Type.HELMET, new Item.Settings());
    public static final Item PRISMARINE_CHESTPLATE = new ArmorItem(PRISMARINE_ARMOR_MATERIAL, Type.CHESTPLATE, new Item.Settings());
    public static final Item PRISMARINE_LEGGINGS = new ArmorItem(PRISMARINE_ARMOR_MATERIAL, Type.LEGGINGS, new Item.Settings());
    public static final Item PRISMARINE_BOOTS = new ArmorItem(PRISMARINE_ARMOR_MATERIAL, Type.BOOTS, new Item.Settings());

    public static final ArmorMaterial GUARDIAN_ARMOR_MATERIAL = new GuardianArmorMaterial();
    public static final Item GUARDIAN_HELMET = new ArmorItem(GUARDIAN_ARMOR_MATERIAL, Type.HELMET, new Item.Settings());
    public static final Item GUARDIAN_CHESTPLATE = new ArmorItem(GUARDIAN_ARMOR_MATERIAL, Type.CHESTPLATE, new Item.Settings());
    public static final Item GUARDIAN_LEGGINGS = new ArmorItem(GUARDIAN_ARMOR_MATERIAL, Type.LEGGINGS, new Item.Settings());
    public static final Item GUARDIAN_BOOTS = new ArmorItem(GUARDIAN_ARMOR_MATERIAL, Type.BOOTS, new Item.Settings());

    public static final ArmorMaterial ELDER_GUARDIAN_ARMOR_MATERIAL = new ElderGuardianArmorMaterial();
    public static final Item ELDER_GUARDIAN_HELMET = new ArmorItem(ELDER_GUARDIAN_ARMOR_MATERIAL, Type.HELMET, new Item.Settings());
    public static final Item ELDER_GUARDIAN_CHESTPLATE = new ArmorItem(ELDER_GUARDIAN_ARMOR_MATERIAL, Type.CHESTPLATE, new Item.Settings());
    public static final Item ELDER_GUARDIAN_LEGGINGS = new ArmorItem(ELDER_GUARDIAN_ARMOR_MATERIAL, Type.LEGGINGS, new Item.Settings());
    public static final Item ELDER_GUARDIAN_BOOTS = new ArmorItem(ELDER_GUARDIAN_ARMOR_MATERIAL, Type.BOOTS, new Item.Settings());

    // Mod Weapons
    public static final Item GUARDIAN_BEAM = new GuardianBeamItem(new FabricItemSettings().maxCount(1));
    public static final Item ELDER_GUARDIAN_BEAM = new Item(new FabricItemSettings().maxCount(1));

    public static void Register(String modID) {
        // Register Items
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_prismarine_shard"), ELDER_PRISMARINE_SHARD);
        Registry.register(Registries.ITEM, new Identifier(modID, "ocean_upgrade_template"), OCEAN_UPGRADE_TEMPLATE);

        // Register Tools
        Registry.register(Registries.ITEM, new Identifier(modID, "prismarine_sword"), PRISMARINE_SWORD);
        Registry.register(Registries.ITEM, new Identifier(modID, "prismarine_pickaxe"), PRISMARINE_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(modID, "prismarine_axe"), PRISMARINE_AXE);
        Registry.register(Registries.ITEM, new Identifier(modID, "prismarine_shovel"), PRISMARINE_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(modID, "prismarine_hoe"), PRISMARINE_HOE);

        // Register Armor
        Registry.register(Registries.ITEM, new Identifier(modID, "prismarine_helmet"), PRISMARINE_HELMET);
        Registry.register(Registries.ITEM, new Identifier(modID, "prismarine_chestplate"), PRISMARINE_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(modID, "prismarine_leggings"), PRISMARINE_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(modID, "prismarine_boots"), PRISMARINE_BOOTS);

        Registry.register(Registries.ITEM, new Identifier(modID, "guardian_helmet"), GUARDIAN_HELMET);
        Registry.register(Registries.ITEM, new Identifier(modID, "guardian_chestplate"), GUARDIAN_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(modID, "guardian_leggings"), GUARDIAN_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(modID, "guardian_boots"), GUARDIAN_BOOTS);

        Registry.register(Registries.ITEM, new Identifier(modID, "elder_guardian_helmet"), ELDER_GUARDIAN_HELMET);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_guardian_chestplate"), ELDER_GUARDIAN_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_guardian_leggings"), ELDER_GUARDIAN_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_guardian_boots"), ELDER_GUARDIAN_BOOTS);

        // Mod Weapons
        Registry.register(Registries.ITEM, new Identifier(modID, "guardian_beam"), GUARDIAN_BEAM);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_guardian_beam"), ELDER_GUARDIAN_BEAM);
    }
}
