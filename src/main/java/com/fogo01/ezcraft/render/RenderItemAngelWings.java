package com.fogo01.ezcraft.render;

import com.fogo01.ezcraft.models.ModelAngelWings;
import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderItemAngelWings implements IItemRenderer {
    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/models/Generator.png");

    private ModelAngelWings model;

    public RenderItemAngelWings() {
        this.model = new ModelAngelWings();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return type == ItemRenderType.EQUIPPED;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();
        //GL11.glTranslatef((float)X + 0.5F, (float)Y + 1.5F, (float)Z + 0.5F);
        GL11.glRotatef(180, 0F, 0F, 1F);

        //this.bindTexture(texture);

        GL11.glPushMatrix();
        this.model.renderModel(0F);
        GL11.glPopMatrix();

        GL11.glPopMatrix();
    }
}
