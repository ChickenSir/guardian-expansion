package com.guardianexpansion.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class PrismarineConverter extends Block {
    public static final VoxelShape BlockShape = Block.createCuboidShape(0, 0, 0, 16, 12, 16);
    public static final TagKey<Item> CONVERTABLE_BLOCKS = TagKey.of(RegistryKeys.ITEM, new Identifier("guardianexpansion", "convertable_blocks"));

    public PrismarineConverter(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return BlockShape;
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return super.getPlacementState(context).with(Properties.HORIZONTAL_FACING, context.getHorizontalPlayerFacing().getOpposite());
    }
    
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
        if (!world.isClient()) {

            ItemStack playerHand = player.getMainHandStack();

            if (playerHand.isIn(CONVERTABLE_BLOCKS)) {
                int itemAmount = player.getInventory().getMainHandStack().getCount();
                
                player.getInventory().getMainHandStack().decrement(itemAmount);

                world.playSound(null, pos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }
}
