package fr.sumomod;

import net.minecraft.block.BlockStainedGlass;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = "sumomod", useMetadata=true)
public class SumoMod {
    static double [][] positions;
    static Minecraft mc = Minecraft.getMinecraft();
    static int cd = 0;
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new SumoCommands());
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent e){
        if (Keyboard.isKeyDown(Keyboard.KEY_G)) {
            ClientCommandHandler.instance.executeCommand(mc.thePlayer, "/fences load");
            cd = 1;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_R)){
            ClientCommandHandler.instance.executeCommand(mc.thePlayer, "/fences reset");
        }
    }
    public static void buildBlock(double posX, double posY, double posZ, EnumFacing facing){
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
        double[][] northPos = {{posX, posY + 10, posZ}};
        double[][] westPos = {{posX, posY + 10, posZ}};
        double[][] eastPos = {{posX, posY + 10, posZ}};

        if (facing == EnumFacing.SOUTH){
            positions = southPos;
        } else if (facing == EnumFacing.NORTH){
            positions = northPos;
        } else if (facing == EnumFacing.EAST){
            positions = eastPos;
        } else if (facing == EnumFacing.WEST){
            positions = westPos;
        }

        for (double[] i : positions) {
            mc.theWorld.setBlockState(new BlockPos(i[0], i[1], i[2]), Blocks.stained_glass.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.GRAY));
        }
    }

    public static void chatLog(String s){
        mc.thePlayer.addChatMessage(new ChatComponentText(s));
    }

    public static void buildFences(){
        EnumFacing facing = mc.thePlayer.getHorizontalFacing();
        for (int i = 0; i < 10; i++) {
            buildBlock(mc.thePlayer.posX, mc.thePlayer.posY+i, mc.thePlayer.posZ, facing);
        }
    }
}
