package com.incendium.client.render.entity;

import com.incendium.Inmodium;
import com.incendium.entity.projectile.SentryProjectileEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SkullEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class SentryProjectileEntityRenderer extends EntityRenderer<SentryProjectileEntity> {
    private static final Identifier TEXTURE = Inmodium.id("textures/entity/projectiles/sentryprojectile.png");
    private final SkullEntityModel model;

    public SentryProjectileEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new SkullEntityModel(context.getPart(EntityModelLayers.WITHER_SKULL));
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 35).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 64, 64);
    }

    protected int getBlockLight(SentryProjectileEntity sentryProjectileEntity, BlockPos blockPos) {
        return 15;
    }

    public void render(SentryProjectileEntity sentryProjectileEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.scale(-1.0F, -1.0F, 1.0F);
        float lerpAngle = MathHelper.lerpAngle(sentryProjectileEntity.prevYaw, sentryProjectileEntity.getYaw(), g);
        float lerp = MathHelper.lerp(g, sentryProjectileEntity.prevPitch, sentryProjectileEntity.getPitch());
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(this.getTexture(sentryProjectileEntity)));
        this.model.setHeadRotation(0.0F, lerpAngle, lerp);
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(sentryProjectileEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    public Identifier getTexture(SentryProjectileEntity sentryProjectileEntity) {
        return TEXTURE;
    }
}
