package fr.sumomod;

import net.minecraft.block.BlockStainedGlass;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = "sumomod", useMetadata=true)
public class SumoMod {
    double [][] positions;
    Minecraft mc = Minecraft.getMinecraft();
    public int ticks = 0;
    public boolean fencesbuilt = true;
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event){
        if (ticks>80){
            ticks = 0;
            fencesbuilt = false;
        }
        if (mc.currentScreen == null && !fencesbuilt){
            if (Keyboard.isKeyDown(Keyboard.KEY_G)){
                EnumFacing facing = mc.thePlayer.getHorizontalFacing();
                //mc.thePlayer.addChatMessage(new ChatComponentText("printed"));
                for (int i = 0; i < 10; i++) {
                    buildBlock(mc.thePlayer.posX, mc.thePlayer.posY+i, mc.thePlayer.posZ, facing);
                }
            }
            fencesbuilt = true;
        }
        if (fencesbuilt){
            ticks++;
        }
    }
    public void buildBlock(double posX, double posY, double posZ, EnumFacing facing){
        mc.theWorld.setBlockState(new BlockPos(0, 100, 0), Blocks.bedrock.getDefaultState());
        double[][] southPos = {{posX, posY, posZ-2}, {posX+1, posY, posZ-2}, {posX+2, posY, posZ-2}, {posX-1, posY, posZ-2}, {posX-2, posY, posZ-2},
                {posX+3, posY, posZ-1}, {posX-3, posY, posZ-1}, {posX-4, posY, posZ-1}, {posX+4, posY, posZ-1},
                {posX+4, posY, posZ}, {posX-4, posY, posZ}, {posX+5, posY, posZ}, {posX-5, posY, posZ},
                {posX+5, posY, posZ+1}, {posX-5, posY, posZ+1},
                {posX+6, posY, posZ+2}, {posX-6, posY, posZ+2},
                {posX+6, posY, posZ+3}, {posX-6, posY, posZ+3},
                {posX+6, posY, posZ+4}, {posX-6, posY, posZ+4},
                {posX+6, posY, posZ+5}, {posX-6, posY, posZ+5},
                {posX+6, posY, posZ+6}, {posX-6, posY, posZ+6},
                {posX+5, posY, posZ+7}, {posX-5, posY, posZ+7},
                {posX+5, posY, posZ+8}, {posX-5, posY, posZ+8}, {posX+4, posY, posZ+8}, {posX-4, posY, posZ+8},
                {posX+4, posY, posZ+9}, {posX-4, posY, posZ+9}, {posX+3, posY, posZ+9}, {posX-3, posY, posZ+9},
                {posX+2, posY, posZ+10}, {posX-2, posY, posZ+10},
                {posX+1, posY, posZ+10}, {posX-1, posY, posZ+10}, {posX, posY, posZ+10}
        };
        if (facing == EnumFacing.SOUTH){
            positions = southPos;
        }

        try {
            for (double[] i : positions) {
                mc.theWorld.setBlockState(new BlockPos(i[0], i[1], i[2]), Blocks.stained_glass.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.GRAY));
            }
        } catch (Exception e){
            chatLog(String.valueOf(e));
        }
    }
    public void chatLog(String s){
        mc.thePlayer.addChatMessage(new ChatComponentText(s));
    }
}
