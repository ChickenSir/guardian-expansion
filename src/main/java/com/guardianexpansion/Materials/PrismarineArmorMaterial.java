package com.guardianexpansion.Materials;

import net.minecraft.item.ArmorItem.Type;

import com.guardianexpansion.GuardianExpansion;

import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class PrismarineArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {16, 25, 20, 18};
    private static final int[] PROTECTION_VALUES = new int[] {2, 7, 6, 2};
    private static final int durabilityMultiplier = 15;
    private static final int enchantability = 12;
    private static final String name = "prismarine";
    private static final float toughness = 0f;
    private static float knockbackResistance = 0.5f;

    @Override
    public int getDurability(Type type) {
        return BASE_DURABILITY[type.ordinal()] * durabilityMultiplier;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_TURTLE;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }

    @Override
    public String getName() {
        return GuardianExpansion.modID + ":" + name;
    }

    @Override
    public int getProtection(Type type) {
        return PROTECTION_VALUES[type.ordinal()];
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.PRISMARINE);
    }

    @Override
    public float getToughness() {
        return toughness;
    }
    
}
