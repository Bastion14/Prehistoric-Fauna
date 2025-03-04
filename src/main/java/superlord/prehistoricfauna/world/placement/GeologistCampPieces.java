package superlord.prehistoricfauna.world.placement;

import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.merchant.villager.VillagerData;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.villager.IVillagerType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PrehistoricProfessionInit;
import superlord.prehistoricfauna.world.PrehistoricFeature;
import superlord.prehistoricfauna.world.PrehistoricLootTables;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class GeologistCampPieces {
	
	private static final ResourceLocation PART_1 = new ResourceLocation(PrehistoricFauna.MODID, "geologist_camp");
	private static final PlacementSettings OVERWRITE = (new PlacementSettings()).setIgnoreEntities(true).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
	private static final PlacementSettings INSERT = (new PlacementSettings()).setIgnoreEntities(true).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK);
	private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.of(PART_1, new BlockPos(0, 1, 0));
	
	public static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> pieceList, Random random) {
		int x = pos.getX();
		int z = pos.getZ();
		BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
		BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
		pieceList.add(new GeologistCampPieces.Piece(templateManager, PART_1, blockpos, rotation, true));
	}
	
	public static class Piece extends TemplateStructurePiece
	{
		private boolean villager;
		private ResourceLocation resourceLocation;
		private Rotation rotation;
		private final boolean overwrite;


		public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotationIn, boolean overwrite)
		{
			super(PrehistoricFeature.GEOLOGIST_CAMP_PIECE, 0);
			this.resourceLocation = resourceLocationIn;
			BlockPos blockpos = GeologistCampPieces.OFFSET.get(resourceLocation);
			this.templatePosition = pos.add(blockpos.getX(), blockpos.getY(), blockpos.getZ());
			this.rotation = rotationIn;
			this.overwrite = overwrite;
			this.setupPiece(templateManagerIn);
		}


		public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound)
		{
			super(PrehistoricFeature.GEOLOGIST_CAMP_PIECE, tagCompound);
			this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
			this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
			this.overwrite = tagCompound.getBoolean("OW");
			this.villager = tagCompound.getBoolean("Villager");
			this.setupPiece(templateManagerIn);
		}


		private void setupPiece(TemplateManager templateManager)
		{
			Template template = templateManager.getTemplateDefaulted(this.resourceLocation);
			PlacementSettings placementsettings = (this.overwrite ? GeologistCampPieces.OVERWRITE : GeologistCampPieces.INSERT).copy().setRotation(this.rotation).setMirror(Mirror.NONE);
			this.setup(template, this.templatePosition, placementsettings);
		}

		@Override
		protected void readAdditional(CompoundNBT tagCompound)
		{
			super.readAdditional(tagCompound);
			tagCompound.putBoolean("Villager", this.villager);
			tagCompound.putString("Template", this.resourceLocation.toString());
			tagCompound.putString("Rot", this.rotation.name());
			tagCompound.putBoolean("OW", this.overwrite);
		}

		@Override
		protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand, MutableBoundingBox sbb)
		{
			if (function.startsWith("chest")) {
	            BlockPos blockpos = pos.down();
	            if (sbb.isVecInside(blockpos)) {
	               LockableLootTileEntity.setLootTable(worldIn, rand, blockpos, PrehistoricLootTables.GEOLOGIST_CAMP_LOOT_TABLE);
	            }
	         }
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 0);
		}
 
		// create
		@Override
		public boolean create(IWorld worldIn, ChunkGenerator<?> chunkGeneratorIn, Random randomIn, MutableBoundingBox structureBoundingBoxIn, ChunkPos chunkPos)
		{
			PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE);
			BlockPos blockpos = GeologistCampPieces.OFFSET.get(this.resourceLocation);
			this.templatePosition.add(Template.transformedBlockPos(placementsettings, new BlockPos(0 - blockpos.getX(), 0, 0 - blockpos.getZ())));

			if(!this.villager) {
				int l = this.getXWithOffset(2, 5);
	            int i1 = this.getYWithOffset(1);
	            int k = this.getZWithOffset(2, 5);
	            if (structureBoundingBoxIn.isVecInside(new BlockPos(l, i1, k))) {
	            	this.villager = true;
	            	VillagerEntity villagerEntity = EntityType.VILLAGER.create(worldIn.getWorld());
	            	VillagerData villagerData = new VillagerData(IVillagerType.PLAINS, PrehistoricProfessionInit.GEOLOGIST, 0);
	            	villagerEntity.enablePersistence();
	            	villagerEntity.setLocationAndAngles((double) l + 0.5D, (double) i1, (double) k + 0.5D, 0.0F, 0.0F);
	            	villagerEntity.onInitialSpawn(worldIn, worldIn.getDifficultyForLocation(new BlockPos(l, i1, k)), SpawnReason.STRUCTURE, (ILivingEntityData) null, (CompoundNBT) null);
                    worldIn.addEntity(villagerEntity);
	            	villagerEntity.setVillagerData(villagerData);
	            }
			}
			
			return super.create(worldIn, chunkGeneratorIn, randomIn, structureBoundingBoxIn, chunkPos);
		}
	}
	
}
