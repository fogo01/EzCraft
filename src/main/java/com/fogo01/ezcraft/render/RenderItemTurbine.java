package com.fogo01.ezcraft.render;

import com.fogo01.ezcraft.models.ModelFlameThrower;
import com.fogo01.ezcraft.models.ModelTurbine;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderItemTurbine implements IItemRenderer {
    private ModelTurbine model;

    public RenderItemTurbine() {
        this.model = new ModelTurbine();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return type == ItemRenderType.EQUIPPED_FIRST_PERSON;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();
        //GL11.glTranslatef((float)X + 0.5F, (float)Y + 1.5F, (float)Z + 0.5F);
        GL11.glRotatef(180, 0F, 1F, 0F);

        //this.bindTexture(texture);

        GL11.glPushMatrix();
        this.model.renderModel(0.0625F);
        GL11.glPopMatrix();

        GL11.glPopMatrix();
    }
}
