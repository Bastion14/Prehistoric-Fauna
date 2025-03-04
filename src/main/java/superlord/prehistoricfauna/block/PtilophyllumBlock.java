package superlord.prehistoricfauna.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SixWayBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.init.BlockInit;

import java.util.Random;

public class PtilophyllumBlock extends SixWayBlock {
   public PtilophyllumBlock(Block.Properties builder) {
      super(0.3125F, builder);
      this.setDefaultState(this.stateContainer.getBaseState().with(NORTH, Boolean.valueOf(false)).with(EAST, Boolean.valueOf(false)).with(SOUTH, Boolean.valueOf(false)).with(WEST, Boolean.valueOf(false)).with(UP, Boolean.valueOf(false)).with(DOWN, Boolean.valueOf(false)));
   }

   public BlockState getStateForPlacement(BlockItemUseContext context) {
      return this.makeConnections(context.getWorld(), context.getPos());
   }

   public BlockState makeConnections(IBlockReader blockReader, BlockPos pos) {
      Block block = blockReader.getBlockState(pos.down()).getBlock();
      Block block1 = blockReader.getBlockState(pos.up()).getBlock();
      Block block2 = blockReader.getBlockState(pos.north()).getBlock();
      Block block3 = blockReader.getBlockState(pos.east()).getBlock();
      Block block4 = blockReader.getBlockState(pos.south()).getBlock();
      Block block5 = blockReader.getBlockState(pos.west()).getBlock();
      return this.getDefaultState().with(DOWN, Boolean.valueOf(block == this || block == BlockInit.PTILOPHYLLUM_BASE || block == BlockInit.SILT || block == BlockInit.HARDENED_SILT)).with(UP, Boolean.valueOf(block1 == this || block1 == BlockInit.PTILOPHYLLUM_BASE)).with(NORTH, Boolean.valueOf(block2 == this || block2 == BlockInit.PTILOPHYLLUM_BASE)).with(EAST, Boolean.valueOf(block3 == this || block3 == BlockInit.PTILOPHYLLUM_BASE)).with(SOUTH, Boolean.valueOf(block4 == this || block4 == BlockInit.PTILOPHYLLUM_BASE)).with(WEST, Boolean.valueOf(block5 == this || block5 == BlockInit.PTILOPHYLLUM_BASE));
   }

   @SuppressWarnings("deprecation")
   public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
      if (!stateIn.isValidPosition(worldIn, currentPos)) {
         worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
         return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
      } else {
         Block block = facingState.getBlock();
         boolean flag = block == this || block == BlockInit.PTILOPHYLLUM_BASE || facing == Direction.DOWN && block == BlockInit.SILT || facing == Direction.DOWN && block == BlockInit.HARDENED_SILT;
         return stateIn.with(FACING_TO_PROPERTY_MAP.get(facing), Boolean.valueOf(flag));
      }
   }

   public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
      if (!state.isValidPosition(worldIn, pos)) {
         worldIn.destroyBlock(pos, true);
      }

   }

   @SuppressWarnings("deprecation")
   public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
      BlockState blockstate = worldIn.getBlockState(pos.down());
      boolean flag = !worldIn.getBlockState(pos.up()).isAir() && !blockstate.isAir();

      for(Direction direction : Direction.Plane.HORIZONTAL) {
         BlockPos blockpos = pos.offset(direction);
         Block block = worldIn.getBlockState(blockpos).getBlock();
         if (block == this) {
            if (flag) {
               return false;
            }

            Block block1 = worldIn.getBlockState(blockpos.down()).getBlock();
            if (block1 == this || block1 == BlockInit.SILT || block1 == BlockInit.HARDENED_SILT) {
               return true;
            }
         }
      }

      Block block2 = blockstate.getBlock();
      return block2 == this || block2 == BlockInit.SILT || block2 == BlockInit.HARDENED_SILT;
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
   }

   public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
      return false;
   }
}