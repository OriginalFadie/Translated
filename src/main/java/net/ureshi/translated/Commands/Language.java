package net.ureshi.translated.Commands;

import net.ureshi.translated.Translated;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static net.ureshi.translated.Translated.lang;

public class Language implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            String uuid = p.getUniqueId().toString();
            switch (s) {

                case ("BG"):
                    lang = "BG";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Bulgarian");
                    break;
                case ("CS"):
                    lang = "CS";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Czech");
                    break;
                case ("DA"):
                    lang = "DA";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Danish");
                    break;
                case ("EL"):
                    lang = "EL";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Greek");
                    break;
                case ("EN"):
                    lang = "EN-GB";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to English");
                    break;
                case ("ES"):
                    lang = "ES";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Spanish");
                    break;
                case ("ET"):
                    lang = "ET";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Estonian");
                    break;
                case ("FI"):
                    lang = "FI";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Finnish");
                    break;
                case ("FR"):
                    lang = "FR";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to French");
                    break;
                case ("HU"):
                    lang = "HU";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Hungarian");
                    break;
                case ("IT"):
                    lang = "IT";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Italian");
                    break;
                case ("JA"):
                    lang = "JA";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Japanese");
                    break;
                case ("LT"):
                    lang = "LT";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Lithuanian");
                    break;
                case ("LV"):
                    lang = "LV";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Latvian");
                    break;
                case ("NL"):
                    lang = "NL";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Dutch");
                    break;
                case ("PL"):
                    lang = "PL";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Polish");
                    break;
                case ("PT-PT"):
                    lang = "PT-PT";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Portuguese");
                    break;
                case ("PT-BR"):
                    lang = "PT-BR";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Portuguese (Brazilian)");
                    break;
                case ("RO"):
                    lang = "RO";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Romanian");
                    break;
                case ("RU"):
                    lang = "RU";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Russian");
                    break;
                case ("SK"):
                    lang = "SK";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Slovak");
                    break;
                case ("SL"):
                    lang = "SL";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Slovenian");
                    break;
                case ("SV"):
                    lang = "SV";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Swedish");
                    break;
                case ("ZH"):
                    lang = "ZH";
                    Translated.getInstance().getConfig().set("player." + uuid + ".lang", lang);
                    Translated.getInstance().saveConfig();
                    p.sendRawMessage(ChatColor.GREEN + "Language Set to Chinese");
                    break;
                default:
                    p.sendRawMessage(ChatColor.RED + "Please enter a valid option!");
                    break;
            }
        }
        return true;
    }
}
