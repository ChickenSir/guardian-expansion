package com.guardianexpansion.Items;

import java.util.List;

import com.guardianexpansion.Collections.ItemsCollection;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class ElderGuardianArmorItem extends ArmorItem {
    
    public ElderGuardianArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.of(""));
        tooltip.add(Text.translatable("tooltip.guardianexpansion.generic.when_full_set").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.guardianexpansion.elder_guardian_armor.status_buff").formatted(Formatting.BLUE));
        tooltip.add(Text.translatable("tooltip.guardianexpansion.elder_guardian_armor.status_buff2").formatted(Formatting.BLUE));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient) {
            if (entity instanceof PlayerEntity player) {
                if (isWearingFullSet(player) && player.isSubmergedInWater()) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1, 0, false, false, true));
                }
                if (isWearingFullSet(player) && player.isInsideWaterOrBubbleColumn()) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1, 0, false, false, true));
                }
            }
        }
    }

    public boolean isWearingFullSet(PlayerEntity player) {
        ItemStack headStack = player.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack chestStack = player.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack legStack = player.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack bootsStack = player.getEquippedStack(EquipmentSlot.FEET);
        
        return headStack.isOf(ItemsCollection.ELDER_GUARDIAN_HELMET) &&
            chestStack.isOf(ItemsCollection.ELDER_GUARDIAN_CHESTPLATE) &&
            legStack.isOf(ItemsCollection.ELDER_GUARDIAN_LEGGINGS) &&
            bootsStack.isOf(ItemsCollection.ELDER_GUARDIAN_BOOTS);
    }
}
