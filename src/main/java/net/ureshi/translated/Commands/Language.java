package net.ureshi.translated.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static net.ureshi.translated.Translated.lang;

public class Language implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {


        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Please Write a Valid Language to change to!");
        }else {
            switch (args[0]){
                case "en":
                    lang = "en";
                    break;

                case ""
            }
        }
        return false;
    }
}
