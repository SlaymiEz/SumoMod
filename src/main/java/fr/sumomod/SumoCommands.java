package fr.sumomod;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class SumoCommands extends CommandBase {
    String prefix = EnumChatFormatting.AQUA + "[SumoHelper] " + EnumChatFormatting.WHITE;
    @Override
    public String getCommandName() {
        return "fences";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "Ez";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 1){
            if (args[0].equals("load10")){
                SumoMod.buildFences(10);
               if (!SumoMod.safeMode) chatLog("Fences Loaded !");
            } else if (args[0].equals("reset")) {
                SumoMod.cd = 0;
                if (!SumoMod.safeMode) chatLog("Fences Reset !");
            } else if (args[0].equals("load12")) {
                SumoMod.buildFences(12);
                if (!SumoMod.safeMode) chatLog("Fences Loaded !");
            } else if (args[0].equals("stream")){
                if (SumoMod.safeMode == false){
                    SumoMod.safeMode = true;
                    chatLog("Streaming mode -> " + EnumChatFormatting.GREEN + "ON");
                } else if (SumoMod.safeMode == true){
                    SumoMod.safeMode = false;
                    chatLog("Streaming mode -> " + EnumChatFormatting.RED + "OFF");
                }
            }
            else {
                throw new CommandException("Command doesn't exist");
            }
        }
    }
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender){
        return true;
    }
    private void chatLog(String str){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(prefix + str));
    }
}
