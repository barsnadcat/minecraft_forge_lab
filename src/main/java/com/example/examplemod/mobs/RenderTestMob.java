package com.example.examplemod.mobs;

import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTestMob extends RenderLiving<EntityTestMob>
{
    private static final ResourceLocation COW_TEXTURES = new ResourceLocation("textures/entity/cow/cow.png");

    public RenderTestMob(RenderManager p_i47210_1_) {
        super(p_i47210_1_, new ModelCow(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityTestMob entity) {
        return COW_TEXTURES;
    }
}
