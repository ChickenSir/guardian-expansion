package com.guardianexpansion.Materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class PrismarineToolMaterial implements ToolMaterial {
    public static final PrismarineToolMaterial INSTANCE = new PrismarineToolMaterial();

    private int durability = 550;
    private float miningSpeed = 6f;
    private float attackDamage = 6.5f;
    private int miningLevel = 2;
    private int enchantability = 12;

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public int getMiningLevel() {
        return miningLevel;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return miningSpeed;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.PRISMARINE);
    }
}
