package com.guardianexpansion.Items;

import com.guardianexpansion.Projectiles.GuardianStaffProjectile;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ElderGuardianBeamItem extends Item {

    public ElderGuardianBeamItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            ItemStack stack = user.getStackInHand(hand);
            if (stack.getDamage() >= stack.getMaxDamage()) {
                // Put item on cooldown when it reaches 0 durability
                user.getItemCooldownManager().set(this, 600);
                stack.setDamage(0);
            } else {
                stack.setDamage(stack.getDamage() + 1);

                GuardianStaffProjectile proj = new GuardianStaffProjectile(world, user);
                proj.setDamage(8);
                proj.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 2.5f, 1.0f);
                world.spawnEntity(proj);

                world.playSound(null, user.getBlockPos(), SoundEvents.BLOCK_BUBBLE_COLUMN_WHIRLPOOL_INSIDE, SoundCategory.PLAYERS, 1f, 1.5f);

                user.getItemCooldownManager().set(this, 20);
            }
        }

        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}
