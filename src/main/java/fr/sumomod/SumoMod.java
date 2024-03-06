package fr.sumomod;

import net.minecraft.block.BlockStainedGlass;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = "sumomod", useMetadata=true)
public class SumoMod {
    public static boolean safeMode;
    static double [][] positions;
    static Minecraft mc = Minecraft.getMinecraft();
    static int cd = 0;
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new SumoCommands());
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent event){
        if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_AIR || event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK){
            ItemStack heldItem = event.entityPlayer.getHeldItem();
            if (heldItem != null && heldItem.getItem() == Items.paper){
                cd = 0;
                if (!safeMode) chatLog(EnumChatFormatting.AQUA + "[SumoHelper] " + EnumChatFormatting.WHITE + "Fences Reset !");
            }
        }
    }
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent e){
        if (Keyboard.isKeyDown(Keyboard.KEY_G) && cd == 0) {
            ClientCommandHandler.instance.executeCommand(mc.thePlayer, "/fences load10");
            cd = 1;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_H) && cd == 0){
            ClientCommandHandler.instance.executeCommand(mc.thePlayer, "/fences load12");
            cd = 1;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_R) && cd == 1){
            ClientCommandHandler.instance.executeCommand(mc.thePlayer, "/fences reset");
        }
    }
    public static void buildBlock10(double posX, double posY, double posZ, EnumFacing facing){
        double[][] DefNorth10 = {{posX, posY, posZ + 2}, {posX + 1, posY, posZ + 2}, {posX - 1, posY, posZ + 2}, {posX + 2, posY, posZ + 2}, {posX - 2, posY, posZ + 2},
                {posX + 3, posY, posZ + 1}, {posX - 3, posY, posZ + 1}, {posX + 4, posY, posZ + 1}, {posX - 4, posY, posZ + 1},
                {posX + 5, posY, posZ}, {posX - 5, posY, posZ},
                {posX + 5, posY, posZ - 1}, {posX - 5, posY, posZ - 1},
                {posX + 6, posY, posZ - 2}, {posX - 6, posY, posZ - 2},
                {posX + 6, posY, posZ - 3}, {posX - 6, posY, posZ - 3},
                {posX + 6, posY, posZ - 4}, {posX - 6, posY, posZ - 4},
                {posX + 6, posY, posZ - 5}, {posX - 6, posY, posZ - 5},
                {posX + 6, posY, posZ - 6}, {posX - 6, posY, posZ - 6},
                {posX + 5, posY, posZ - 7}, {posX - 5, posY, posZ - 7},
                {posX + 5, posY, posZ - 8}, {posX - 5, posY, posZ - 8},
                {posX + 4, posY, posZ - 9}, {posX - 4, posY, posZ - 9},
                {posX + 3, posY, posZ - 9}, {posX - 3, posY, posZ - 9},
                {posX + 2, posY, posZ - 10}, {posX - 2, posY, posZ - 10}, {posX + 1, posY, posZ - 10}, {posX - 1, posY, posZ - 10}, {posX, posY, posZ - 10}};
        double[][] DefSouth10 = {{posX, posY, posZ - 2}, {posX + 1, posY, posZ - 2}, {posX - 1, posY, posZ - 2}, {posX + 2, posY, posZ - 2}, {posX - 2, posY, posZ - 2},
                {posX + 3, posY, posZ - 1}, {posX - 3, posY, posZ - 1}, {posX + 4, posY, posZ - 1}, {posX - 4, posY, posZ - 1},
                {posX + 5, posY, posZ}, {posX - 5, posY, posZ},
                {posX + 5, posY, posZ + 1}, {posX - 5, posY, posZ + 1},
                {posX + 6, posY, posZ + 2}, {posX - 6, posY, posZ + 2},
                {posX + 6, posY, posZ + 3}, {posX - 6, posY, posZ + 3},
                {posX + 6, posY, posZ + 4}, {posX - 6, posY, posZ + 4},
                {posX + 6, posY, posZ + 5}, {posX - 6, posY, posZ + 5},
                {posX + 6, posY, posZ + 6}, {posX - 6, posY, posZ + 6},
                {posX + 5, posY, posZ + 7}, {posX - 5, posY, posZ + 7},
                {posX + 5, posY, posZ + 8}, {posX - 5, posY, posZ + 8},
                {posX + 4, posY, posZ + 9}, {posX - 4, posY, posZ + 9},
                {posX + 3, posY, posZ + 9}, {posX - 3, posY, posZ + 9},
                {posX + 2, posY, posZ + 10}, {posX - 2, posY, posZ + 10}, {posX + 1, posY, posZ + 10}, {posX - 1, posY, posZ + 10}, {posX, posY, posZ + 10}};
        double[][] DefEast10 = {{posX-2, posY, posZ}, {posX-2, posY, posZ+1}, {posX-2, posY, posZ-1},{posX-2, posY, posZ+2}, {posX-2, posY, posZ-2},
                {posX-1, posY, posZ+3}, {posX-1, posY, posZ-3}, {posX-1, posY, posZ+4}, {posX-1, posY, posZ-4},
                {posX, posY, posZ+5}, {posX, posY, posZ-5},
                {posX+1, posY, posZ+5}, {posX+1, posY, posZ-5},
                {posX+2, posY, posZ+6}, {posX+2, posY, posZ-6},
                {posX+3, posY, posZ+6}, {posX+3, posY, posZ-6},
                {posX+4, posY, posZ+6}, {posX+4, posY, posZ-6},
                {posX+5, posY, posZ+6}, {posX+5, posY, posZ-6},
                {posX+6, posY, posZ+6}, {posX+6, posY, posZ-6},
                {posX+7, posY, posZ+5}, {posX+7, posY, posZ-5},
                {posX+8, posY, posZ+5}, {posX+8, posY, posZ-5},
                {posX+9, posY, posZ+4}, {posX+9, posY, posZ-4},
                {posX+9, posY, posZ+3}, {posX+9, posY, posZ-3},
                {posX+10, posY, posZ+2}, {posX+10, posY, posZ-2}, {posX+10, posY, posZ+1}, {posX+10, posY, posZ-1}, {posX+10, posY, posZ}};
        double[][] DefWest10 = {{posX+2, posY, posZ}, {posX+2, posY, posZ+1}, {posX+2, posY, posZ-1},{posX+2, posY, posZ+2}, {posX+2, posY, posZ-2},
                {posX+1, posY, posZ+3}, {posX+1, posY, posZ-3}, {posX+1, posY, posZ+4}, {posX+1, posY, posZ-4},
                {posX, posY, posZ+5}, {posX, posY, posZ-5},
                {posX-1, posY, posZ+5}, {posX-1, posY, posZ-5},
                {posX-2, posY, posZ+6}, {posX-2, posY, posZ-6},
                {posX-3, posY, posZ+6}, {posX-3, posY, posZ-6},
                {posX-4, posY, posZ+6}, {posX-4, posY, posZ-6},
                {posX-5, posY, posZ+6}, {posX-5, posY, posZ-6},
                {posX-6, posY, posZ+6}, {posX-6, posY, posZ-6},
                {posX-7, posY, posZ+5}, {posX-7, posY, posZ-5},
                {posX-8, posY, posZ+5}, {posX-8, posY, posZ-5},
                {posX-9, posY, posZ+4}, {posX-9, posY, posZ-4},
                {posX-9, posY, posZ+3}, {posX-9, posY, posZ-3},
                {posX-10, posY, posZ+2}, {posX-10, posY, posZ-2}, {posX-10, posY, posZ+1}, {posX-10, posY, posZ-1}, {posX-10, posY, posZ}};
        if (facing == EnumFacing.SOUTH){
            positions = DefSouth10;
        } else if (facing == EnumFacing.NORTH){
            positions = DefNorth10;
        } else if (facing == EnumFacing.EAST){
            positions = DefEast10;
        } else if (facing == EnumFacing.WEST){
            positions = DefWest10;
        }

        for (double[] i : positions) {
            if (!SumoMod.safeMode) {
                mc.theWorld.setBlockState(new BlockPos(i[0], i[1], i[2]), Blocks.stained_glass.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.GRAY));
            } else {
                mc.theWorld.setBlockState(new BlockPos(i[0], i[1], i[2]), Blocks.barrier.getDefaultState());
            }
        }
    }
    public static void buildBlock12(double posX, double posY, double posZ, EnumFacing facing){
        double[][] DefWest12 = {{posX+2, posY, posZ}, {posX+2, posY, posZ+1}, {posX+2, posY, posZ-1}, {posX+2, posY, posZ+2}, {posX+2, posY, posZ-2},
                {posX+1, posY, posZ+3}, {posX+1, posY, posZ-3},
                {posX+1, posY, posZ+4}, {posX+1, posY, posZ-4},
                {posX, posY, posZ+5}, {posX, posY, posZ-5},
                {posX-1, posY, posZ+6}, {posX-1, posY, posZ-6},
                {posX-2, posY, posZ+6}, {posX-2, posY, posZ-6},
                {posX-3, posY, posZ+7}, {posX-3, posY, posZ-7},
                {posX-4, posY, posZ+7}, {posX-4, posY, posZ-7},
                {posX-5, posY, posZ+7}, {posX-5, posY, posZ-7},
                {posX-6, posY, posZ+7}, {posX-6, posY, posZ-7},
                {posX-7, posY, posZ+7}, {posX-7, posY, posZ-7},
                {posX-8, posY, posZ+6}, {posX-8, posY, posZ-6},
                {posX-9, posY, posZ+6}, {posX-9, posY, posZ-6},
                {posX-10, posY, posZ+5}, {posX-10, posY, posZ-5},
                {posX-11, posY, posZ+4}, {posX-11, posY, posZ-4},
                {posX-11, posY, posZ+3}, {posX-11, posY, posZ-3},
                {posX-12, posY, posZ+2}, {posX-12, posY, posZ-2}, {posX-12, posY, posZ+1}, {posX-12, posY, posZ-1},{posX-12, posY, posZ}};
        double[][] DefEast12 = {{posX-2, posY, posZ}, {posX-2, posY, posZ+1}, {posX-2, posY, posZ-1}, {posX-2, posY, posZ+2}, {posX-2, posY, posZ-2},
                {posX-1, posY, posZ+3}, {posX-1, posY, posZ-3},
                {posX-1, posY, posZ+4}, {posX-1, posY, posZ-4},
                {posX, posY, posZ+5}, {posX, posY, posZ-5},
                {posX+1, posY, posZ+6}, {posX+1, posY, posZ-6},
                {posX+2, posY, posZ+6}, {posX+2, posY, posZ-6},
                {posX+3, posY, posZ+7}, {posX+3, posY, posZ-7},
                {posX+4, posY, posZ+7}, {posX+4, posY, posZ-7},
                {posX+5, posY, posZ+7}, {posX+5, posY, posZ-7},
                {posX+6, posY, posZ+7}, {posX+6, posY, posZ-7},
                {posX+7, posY, posZ+7}, {posX+7, posY, posZ-7},
                {posX+8, posY, posZ+6}, {posX+8, posY, posZ-6},
                {posX+9, posY, posZ+6}, {posX+9, posY, posZ-6},
                {posX+10, posY, posZ+5}, {posX+10, posY, posZ-5},
                {posX+11, posY, posZ+4}, {posX+11, posY, posZ-4},
                {posX+11, posY, posZ+3}, {posX+11, posY, posZ-3},
                {posX+12, posY, posZ+2}, {posX+12, posY, posZ-2}, {posX+12, posY, posZ+1}, {posX+12, posY, posZ-1},{posX+12, posY, posZ}};
        double[][] DefNorth12 = {{posX, posY, posZ+2}, {posX+1, posY, posZ+2}, {posX-1, posY, posZ+2}, {posX-2, posY, posZ+2}, {posX+2, posY, posZ+2},
                {posX+3, posY, posZ+1}, {posX-3, posY, posZ+1},{posX+4, posY, posZ+1}, {posX-4, posY, posZ+1},
                {posX+5, posY, posZ}, {posX-5, posY, posZ},
                {posX+6, posY, posZ-1}, {posX-6, posY, posZ-1},
                {posX+6, posY, posZ-2}, {posX-6, posY, posZ-2},
                {posX+7, posY, posZ-3}, {posX-7, posY, posZ-3},
                {posX+7, posY, posZ-4}, {posX-7, posY, posZ-4},
                {posX+7, posY, posZ-5}, {posX-7, posY, posZ-5},
                {posX+7, posY, posZ-6}, {posX-7, posY, posZ-6},
                {posX+7, posY, posZ-7}, {posX-7, posY, posZ-7},
                {posX+6, posY, posZ-8}, {posX-6, posY, posZ-8},
                {posX+6, posY, posZ-9}, {posX-6, posY, posZ-9},
                {posX+5, posY, posZ-10}, {posX-5, posY, posZ-10},
                {posX+4, posY, posZ-11}, {posX-4, posY, posZ-11},
                {posX+3, posY, posZ-11}, {posX-3, posY, posZ-11},
                {posX+2, posY, posZ-12}, {posX-2, posY, posZ-12},{posX+1, posY, posZ-12}, {posX-1, posY, posZ-12},{posX, posY, posZ-12}};
        double[][] DefSouth12 = {{posX, posY, posZ-2}, {posX+1, posY, posZ-2}, {posX-1, posY, posZ-2}, {posX-2, posY, posZ-2}, {posX+2, posY, posZ-2},
                {posX+3, posY, posZ-1}, {posX-3, posY, posZ-1},{posX+4, posY, posZ-1}, {posX-4, posY, posZ-1},
                {posX+5, posY, posZ}, {posX-5, posY, posZ},
                {posX+6, posY, posZ+1}, {posX-6, posY, posZ+1},
                {posX+6, posY, posZ+2}, {posX-6, posY, posZ+2},
                {posX+7, posY, posZ+3}, {posX-7, posY, posZ+3},
                {posX+7, posY, posZ+4}, {posX-7, posY, posZ+4},
                {posX+7, posY, posZ+5}, {posX-7, posY, posZ+5},
                {posX+7, posY, posZ+6}, {posX-7, posY, posZ+6},
                {posX+7, posY, posZ+7}, {posX-7, posY, posZ+7},
                {posX+6, posY, posZ+8}, {posX-6, posY, posZ+8},
                {posX+6, posY, posZ+9}, {posX-6, posY, posZ+9},
                {posX+5, posY, posZ+10}, {posX-5, posY, posZ+10},
                {posX+4, posY, posZ+11}, {posX-4, posY, posZ+11},
                {posX+3, posY, posZ-11}, {posX-3, posY, posZ-11},
                {posX+2, posY, posZ+12}, {posX-2, posY, posZ+12},{posX+1, posY, posZ+12}, {posX-1, posY, posZ+12},{posX, posY, posZ+12}};
        if (facing == EnumFacing.SOUTH){
            positions = DefSouth12;
        } else if (facing == EnumFacing.NORTH){
            positions = DefNorth12;
        } else if (facing == EnumFacing.EAST){
            positions = DefEast12;
        } else if (facing == EnumFacing.WEST){
            positions = DefWest12;
        }
        for (double[] i : positions) {
            if (!SumoMod.safeMode) {
                mc.theWorld.setBlockState(new BlockPos(i[0], i[1], i[2]), Blocks.stained_glass.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.GRAY));
            } else {
                mc.theWorld.setBlockState(new BlockPos(i[0], i[1], i[2]), Blocks.barrier.getDefaultState());
            }
        }
    }

    public static void chatLog(String s){
        mc.thePlayer.addChatMessage(new ChatComponentText(s));
    }

    public static void buildFences(int j){
        EnumFacing facing = mc.thePlayer.getHorizontalFacing();
        if (j == 10) {
            for (int i = 0; i < 4; i++) { // The number after < is the Y level of the wall
                if (i != 1) { // Allows you to hit the player by skipping the second layer
                    buildBlock10(mc.thePlayer.posX, mc.thePlayer.posY + i, mc.thePlayer.posZ, facing);
                }
            }
        } else if (j == 12){
            for (int i = 0; i < 4; i++) { // The number after < is the Y level of the wall
                if (i != 1) { // Allows you to hit the player by skipping the second layer
                    buildBlock12(mc.thePlayer.posX, mc.thePlayer.posY + i, mc.thePlayer.posZ, facing);
                }
            }
        }
    }
}
