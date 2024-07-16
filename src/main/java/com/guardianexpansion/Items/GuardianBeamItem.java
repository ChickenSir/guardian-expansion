package com.guardianexpansion.Items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GuardianBeamItem extends Item {
    private boolean isRecharging = false;

    public GuardianBeamItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            ItemStack stack = user.getStackInHand(hand);
            if (stack.getDamage() >= stack.getMaxDamage() - 1) {
                isRecharging = true;
            }
            if (!isRecharging) {
                stack.setDamage(stack.getDamage() + 1);

                world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_GUARDIAN_ATTACK, SoundCategory.PLAYERS, 1f, 1f);
            }
        }

        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (isRecharging) {
                stack.setDamage(stack.getDamage() - 1);
                if (stack.getDamage() == 0) {
                    isRecharging = false;
                }
            }
        }
    }
}
