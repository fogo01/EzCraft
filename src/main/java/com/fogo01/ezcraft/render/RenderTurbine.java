package com.fogo01.ezcraft.render;


import com.fogo01.ezcraft.models.ModelTurbine;
import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderTurbine extends TileEntitySpecialRenderer {

    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/models/Turbine.png");

    private ModelTurbine model;

    public RenderTurbine() {
        this.model = new ModelTurbine();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double X, double Y, double Z, float f) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)X + 0.5F, (float)Y + 1.5F, (float)Z + 0.5F);
        GL11.glRotatef(180, 0F, 0F, 1F);

        this.bindTexture(texture);

        GL11.glPushMatrix();
        this.model.renderModel(0.0625F);
        GL11.glPopMatrix();

        GL11.glPopMatrix();
    }
}
