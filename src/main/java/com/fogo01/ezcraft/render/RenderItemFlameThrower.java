package com.fogo01.ezcraft.render;

import com.fogo01.ezcraft.models.ModelAngelWings;
import com.fogo01.ezcraft.models.ModelFlameThrower;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;


public class RenderItemFlameThrower implements IItemRenderer {
    private ModelFlameThrower model;

    public RenderItemFlameThrower() {
        this.model = new ModelFlameThrower();
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
    public void renderItem(ItemRenderType type, ItemStack itemStack, Object... data) {
        GL11.glPushMatrix();
        //GL11.glTranslatef((float)X + 0.5F, (float)Y + 1.5F, (float)Z + 0.5F);
        GL11.glRotatef(180, 0F, 0F, 1F);

        //this.bindTexture(texture);

        GL11.glPushMatrix();
        this.model.renderModel(0.0625F);
        GL11.glPopMatrix();

        GL11.glPopMatrix();
    }
}
