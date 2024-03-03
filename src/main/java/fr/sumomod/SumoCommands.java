package fr.sumomod;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class SumoCommands extends CommandBase {
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
            if (args[0].equals("load")){
                SumoMod.buildFences();
                chatLog("Fences Loaded !");
            } else if (args[0].equals("reset")) {
                SumoMod.cd = 0;
                chatLog("Fences Reset !");
            } else {
                throw new CommandException("Command doesn't exist");
            }
        }
    }
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender){
        return true;
    }
    private void chatLog(String str){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(str));
    }
}
