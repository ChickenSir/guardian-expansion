package com.example.guardianexpansion.Collections;

import com.example.guardianexpansion.Materials.PrismarineToolMaterial;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.item.ToolItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;

public class ItemsCollection {
    // Mod Tools
    public static final ToolItem PRISMARINE_SWORD = new SwordItem(PrismarineToolMaterial.INSTANCE, 0, 0f, new FabricItemSettings());
    public static final ToolItem PRISMARINE_PICKAXE = new PickaxeItem(PrismarineToolMaterial.INSTANCE, 0, 0f, new FabricItemSettings());
    public static final ToolItem PRISMARINE_AXE = new AxeItem(PrismarineToolMaterial.INSTANCE, 0, 0f, new FabricItemSettings());
    public static final ToolItem PRISMARINE_SHOVEL = new ShovelItem(PrismarineToolMaterial.INSTANCE, 0, 0f, new FabricItemSettings());
    public static final ToolItem PRISMARINE_HOE = new HoeItem(PrismarineToolMaterial.INSTANCE, 0, 0f, new FabricItemSettings());
}
