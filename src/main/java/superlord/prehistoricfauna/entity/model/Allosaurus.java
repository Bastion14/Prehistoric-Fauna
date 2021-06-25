package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.AllosaurusEntity;

/**
 * AllosaurusModel - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class Allosaurus extends EntityModel<AllosaurusEntity> {
    public ModelRenderer Body1;
    public ModelRenderer LeftLeg1;
    public ModelRenderer RightLeg1;
    public ModelRenderer Body2;
    public ModelRenderer Tail1;
    public ModelRenderer Neck;
    public ModelRenderer LeftArm;
    public ModelRenderer RightArm;
    public ModelRenderer Head1;
    public ModelRenderer Snout;
    public ModelRenderer Jaw1;
    public ModelRenderer Snout2;
    public ModelRenderer CrestLeft;
    public ModelRenderer CrestRight;
    public ModelRenderer UpperTeeth;
    public ModelRenderer Jaw2;
    public ModelRenderer Jaw3;
    public ModelRenderer LowerTeeth;
    public ModelRenderer Tail2;
    public ModelRenderer LeftLeg2;
    public ModelRenderer LeftFoot;
    public ModelRenderer RightLeg2;
    public ModelRenderer RightFoot;

    public Allosaurus() {
        this.textureWidth = 250;
        this.textureHeight = 250;
        this.LeftLeg2 = new ModelRenderer(this, 163, 212);
        this.LeftLeg2.setRotationPoint(5.0F, 17.0F, 6.0F);
        this.LeftLeg2.addBox(-4.5F, 0.0F, -3.0F, 8.0F, 24.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.NeckSpine = new ModelRenderer(this, 100, -9);
        this.NeckSpine.setRotationPoint(0.0F, -25.0F, -10.0F);
        this.NeckSpine.addBox(0.0F, -2.0F, 0.0F, 0.0F, 30.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw1 = new ModelRenderer(this, 0, 119);
        this.Jaw1.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.Jaw1.addBox(-5.0F, -1.0F, -12.0F, 10.0F, 5.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.UpperTeeth_1 = new ModelRenderer(this, 5, 203);
        this.UpperTeeth_1.setRotationPoint(3.3F, 5.0F, 0.0F);
        this.UpperTeeth_1.addBox(0.0F, -4.01F, -13.8F, 0.0F, 6.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, -25.0F, 9.0F);
        this.Body1.addBox(-9.5F, -5.0F, -43.0F, 19.0F, 22.0F, 51.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw2 = new ModelRenderer(this, 47, 119);
        this.Jaw2.setRotationPoint(0.0F, 0.0F, -11.8F);
        this.Jaw2.addBox(-3.0F, -1.0F, -14.0F, 6.0F, 4.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.BackSpine = new ModelRenderer(this, 140, -30);
        this.BackSpine.setRotationPoint(0.0F, -8.0F, -33.0F);
        this.BackSpine.addBox(0.0F, -2.0F, 0.0F, 0.0F, 5.0F, 40.0F, 0.0F, 0.0F, 0.0F);
        this.RightClaw = new ModelRenderer(this, 131, 121);
        this.RightClaw.setRotationPoint(-1.0F, 12.0F, 0.1F);
        this.RightClaw.addBox(-4.0F, -2.0F, -3.0F, 5.0F, 14.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.UpperTeeth = new ModelRenderer(this, 5, 203);
        this.UpperTeeth.setRotationPoint(-3.3F, 5.0F, 0.0F);
        this.UpperTeeth.addBox(0.0F, -4.01F, -13.8F, 0.0F, 6.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg2 = new ModelRenderer(this, 196, 212);
        this.RightLeg2.setRotationPoint(-5.0F, 17.0F, 6.0F);
        this.RightLeg2.addBox(-4.5F, 0.0F, -3.0F, 8.0F, 24.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.UpperTeeth_2 = new ModelRenderer(this, 5, 203);
        this.UpperTeeth_2.setRotationPoint(0.0F, 4.0F, -14.1F);
        this.UpperTeeth_2.addBox(-3.0F, -4.01F, 0.2F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg1 = new ModelRenderer(this, 148, 173);
        this.RightLeg1.setRotationPoint(-1.0F, -20.0F, 8.0F);
        this.RightLeg1.addBox(-10.0F, -3.0F, -6.0F, 10.0F, 22.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 47, 94);
        this.Snout.setRotationPoint(0.0F, -3.0F, -12.0F);
        this.Snout.addBox(-3.5F, -3.0F, -14.0F, 7.0F, 8.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.CrestLeft = new ModelRenderer(this, 0, 191);
        this.CrestLeft.setRotationPoint(3.0F, -4.0F, 1.0F);
        this.CrestLeft.addBox(-0.5F, -2.0F, -3.0F, 2.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(CrestLeft, 0.3127630032889644F, 0.0F, 0.5082398928281348F);
        this.Tail2 = new ModelRenderer(this, 92, 91);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 31.0F);
        this.Tail2.addBox(-3.0F, -4.0F, 0.0F, 6.0F, 9.0F, 70.0F, 0.0F, 0.0F, 0.0F);
        this.LowerTeeth = new ModelRenderer(this, 47, 203);
        this.LowerTeeth.setRotationPoint(0.0F, -1.01F, -0.5F);
        this.LowerTeeth.addBox(-2.5F, -2.0F, -13.0F, 5.0F, 5.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg1 = new ModelRenderer(this, 86, 173);
        this.LeftLeg1.setRotationPoint(1.0F, -20.0F, 8.0F);
        this.LeftLeg1.addBox(0.0F, -3.0F, -6.0F, 10.0F, 22.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw3 = new ModelRenderer(this, 0, 149);
        this.Jaw3.setRotationPoint(0.0F, 1.0F, 0.5F);
        this.Jaw3.addBox(-4.0F, -7.99F, -11.0F, 8.0F, 7.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 1);
        this.Neck.setRotationPoint(0.0F, 9.0F, -34.0F);
        this.Neck.addBox(-4.5F, -24.0F, -14.0F, 9.0F, 27.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.TailSpine = new ModelRenderer(this, 130, -10);
        this.TailSpine.setRotationPoint(0.0F, -7.0F, -1.0F);
        this.TailSpine.addBox(0.0F, -2.0F, 0.0F, 0.0F, 5.0F, 31.0F, 0.0F, 0.0F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 101, 91);
        this.LeftArm.setRotationPoint(6.0F, 11.0F, -37.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -3.0F, 5.0F, 16.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 110, 43);
        this.Tail1.setRotationPoint(0.0F, -1.0F, 8.0F);
        this.Tail1.addBox(-7.0F, -4.0F, 0.0F, 14.0F, 14.0F, 31.0F, 0.0F, 0.0F, 0.0F);
        this.RightFoot = new ModelRenderer(this, 106, 232);
        this.RightFoot.setRotationPoint(0.0F, 23.0F, 2.0F);
        this.RightFoot.addBox(-5.0F, 0.0F, -13.0F, 9.0F, 4.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.LeftClaw = new ModelRenderer(this, 101, 121);
        this.LeftClaw.setRotationPoint(1.0F, 12.0F, 0.1F);
        this.LeftClaw.addBox(-1.0F, -2.0F, -3.0F, 5.0F, 14.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.RightArm = new ModelRenderer(this, 133, 91);
        this.RightArm.setRotationPoint(-6.0F, 11.0F, -37.0F);
        this.RightArm.addBox(-4.0F, -2.0F, -3.0F, 5.0F, 16.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.LeftFoot = new ModelRenderer(this, 60, 232);
        this.LeftFoot.setRotationPoint(0.0F, 23.0F, 2.0F);
        this.LeftFoot.addBox(-5.0F, 0.0F, -13.0F, 9.0F, 4.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2Spine = new ModelRenderer(this, 100, -35);
        this.Tail2Spine.setRotationPoint(0.0F, -7.0F, -1.0F);
        this.Tail2Spine.addBox(0.0F, -2.0F, 0.0F, 0.0F, 5.0F, 70.0F, 0.0F, 0.0F, 0.0F);
        this.Head1 = new ModelRenderer(this, 0, 94);
        this.Head1.setRotationPoint(0.0F, -18.1F, -9.0F);
        this.Head1.addBox(-5.0F, -7.0F, -12.0F, 10.0F, 9.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.CrestRight = new ModelRenderer(this, 16, 191);
        this.CrestRight.setRotationPoint(-3.0F, -4.0F, 1.0F);
        this.CrestRight.addBox(-1.5F, -2.0F, -3.0F, 2.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(CrestRight, 0.3127630032889644F, 0.0F, -0.5082398928281348F);
        this.LeftLeg1.addChild(this.LeftLeg2);
        this.Neck.addChild(this.NeckSpine);
        this.Head1.addChild(this.Jaw1);
        this.Snout.addChild(this.UpperTeeth_1);
        this.Jaw1.addChild(this.Jaw2);
        this.Body1.addChild(this.BackSpine);
        this.RightArm.addChild(this.RightClaw);
        this.Snout.addChild(this.UpperTeeth);
        this.RightLeg1.addChild(this.RightLeg2);
        this.Snout.addChild(this.UpperTeeth_2);
        this.Head1.addChild(this.Snout);
        this.Snout.addChild(this.CrestLeft);
        this.Tail1.addChild(this.Tail2);
        this.Jaw2.addChild(this.LowerTeeth);
        this.Jaw1.addChild(this.Jaw3);
        this.Body1.addChild(this.Neck);
        this.Tail1.addChild(this.TailSpine);
        this.Body1.addChild(this.LeftArm);
        this.Body1.addChild(this.Tail1);
        this.RightLeg2.addChild(this.RightFoot);
        this.LeftArm.addChild(this.LeftClaw);
        this.Body1.addChild(this.RightArm);
        this.LeftLeg2.addChild(this.LeftFoot);
        this.Tail2.addChild(this.Tail2Spine);
        this.Neck.addChild(this.Head1);
        this.Snout.addChild(this.CrestRight);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body1, this.RightLeg1, this.LeftLeg1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }
    
    @Override
    public void setRotationAngles(AllosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float speed = 1.0f;
    	float degree = 1.0f;
    	this.Neck.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount + 0.35F;
    	this.Body2.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.01F * limbSwingAmount;
    	this.Body1.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
    	this.Tail1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.05F;
    	this.Tail2.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.05F;
    	this.Tail1.rotateAngleY = MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.6F * limbSwingAmount;
    	this.Tail2.rotateAngleY = MathHelper.cos(limbSwing * speed * 0.15F) * degree * 1.0F * limbSwingAmount;
    	this.Head1.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.25F * limbSwingAmount - 0.2F;
    	this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.15F;
    	this.RightArm.rotateAngleX = MathHelper.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.15F;
    	this.LeftLeg1.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount - 0.05F;
    	this.LeftLeg2.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.05F;
    	this.LeftFoot.rotateAngleX = MathHelper.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
    	this.RightLeg1.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount - 0.05F;
    	this.RightLeg2.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + 0.05F;
    	this.RightFoot.rotateAngleX = MathHelper.cos(2.0F + limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
    }
    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
