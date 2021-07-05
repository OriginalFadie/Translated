package net.ureshi.translated;

import net.ureshi.translated.ChatListener.ChatEventFree;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Translated extends JavaPlugin {

    private FileConfiguration customConfig;
    public static String lastChar;
    public static String auth;
    public String ss;
    public String pf;
    public static String  en;
    public String li;
    public String fo;
    public static String originalText;
    public static String translatedText;
    public static String split;
    public static String format;
    public static String formal;
    public static String storage;
    public static String host;
    public static String port;
    public static String database;
    public static String username;
    public static String password;


    public void read() {
        auth = getCustomConfig().getString("authkey");
        ss = getCustomConfig().getString("options.splitsentences");
        pf = getCustomConfig().getString("options.preserveformatting");
        en = getCustomConfig().getString("options.logchat.enabled");
        li = getCustomConfig().getString("options.limiter.limit");
        fo = getCustomConfig().getString("options.formality");
        lastChar = auth.substring(auth.length()-3);
        storage = getCustomConfig().getString("options.storage");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Read Event Called!");
    }

    public void database() {
        host = getCustomConfig().getString("options.storage.host");
        port = getCustomConfig().getString("options.storage.port");
        database = getCustomConfig().getString("options.storage.database");
        username = getCustomConfig().getString("options.storage.username");
        password = getCustomConfig().getString("options.storage.password");
    }


    public void parameters() {

        switch (ss) {

            case "0":
                split = "&split_sentences=0";
                break;

            case "1":
                split = "";
                break;

            case "nonewlines":
                split = "&split_sentences=nonewlines";
                break;

            default:
                split = "";
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Split Sentenaces formatting error, reverting to default");
        }


        switch (pf) {

            case "0":
                format = "";
                break;

            case "1":
                format = "&preserve_formatting=1";
                break;

            default:
                format = "";
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Preserve Formatting formatting error, reverting to default");
        }

        switch (fo) {
            case "default":
                formal = "";
                break;

            case "0":
                formal = "&formality=less";
                break;

            case "1":
                formal = "&formality=more";
                break;

            default:
                formal = "";
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Formality formatting error, reverting to default");
        }
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        createCustomConfig();
        read();
        parameters();
        database();
        Bukkit.getPluginManager().registerEvents(new ChatEventFree(), this);
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Translation Enabled!");
    }

    public FileConfiguration getCustomConfig() { return this.customConfig; }

    private void createCustomConfig() {
        File customConfigFile = new File(getDataFolder(), "settings.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdir();
            saveResource("settings.yml", false);
        }

        customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Translation Disabled!");
    }

}
