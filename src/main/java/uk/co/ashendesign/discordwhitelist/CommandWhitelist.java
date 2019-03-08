package uk.co.ashendesign.discordwhitelist;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWhitelist implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        boolean whitelistEnabled = Main.getInstance().getConfig().getBoolean("enabled");

        if(sender instanceof Player){

            if(args.length == 0){
                sender.sendMessage("You haven't specified a sub-command!");
            }else {
                if(args[0].equalsIgnoreCase("whitelist") && args.length < 2){
                    sender.sendMessage("Please specify on/off");
                } else {
                    if(args[1].equalsIgnoreCase("on") && !whitelistEnabled){
                        Main.getInstance().getConfig().set("enabled", true);
                        sender.sendMessage("Whitelist enabled.");
                    }else if(args[1].equalsIgnoreCase("on") && whitelistEnabled){
                        sender.sendMessage("The whitelist is already enabled!");
                    }else if(args[1].equalsIgnoreCase("off") && whitelistEnabled){
                        Main.getInstance().getConfig().set("enabled", false);
                        sender.sendMessage("Whitelist disabled.");
                    }else if(args[1].equalsIgnoreCase("off") && !whitelistEnabled){
                        sender.sendMessage("The whitelist is already disabled!");
                    }else {
                        sender.sendMessage("Command not recognised!");
                    }
                }
            }
        }
        return true;
    }
}