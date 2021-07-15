package net.ureshi.translated;

import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.ureshi.translated.ChatListener.ChatEventFree;
import net.ureshi.translated.ChatListener.ChatEventPro;
import net.ureshi.translated.Commands.Language;
import net.ureshi.translated.PlayerProfile.JoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Translated extends JavaPlugin {

    private static Translated instance;
    private BukkitAudiences adventure;
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
    public static String lang;

    //Sets Variables to the set values in the config file
    public void read() {
        auth = getCustomConfig().getString("authkey");
        ss = getCustomConfig().getString("splitsentences");
        pf = getCustomConfig().getString("preserveformatting");
        en = getCustomConfig().getString("logchat.enabled");
        li = getCustomConfig().getString("limiter.limit");
        fo = getCustomConfig().getString("formality");
        if (auth == null) {
            Bukkit.getConsoleSender().sendMessage("Don't forget to add your auth key! It is required for the plugin to work!");
        }else {
            lastChar = auth.substring(auth.length()-3);
        }
        storage = getCustomConfig().getString("storage");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Read Event Called!");
    }

    //Sets Database Values to the set Values in the config file
    public void database() {
        host = getCustomConfig().getString("host");
        port = getCustomConfig().getString("port");
        database = getCustomConfig().getString("database");
        username = getCustomConfig().getString("username");
        password = getCustomConfig().getString("password");
    }

    //Sets the variables for the url building in the Free and Pro files
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

    //Selects the Chat Listener to call
    public void chat() {

        if (lastChar.equals(":fx")) {
            Bukkit.getPluginManager().registerEvents(new ChatEventFree(), this);
        } else {
            Bukkit.getPluginManager().registerEvents(new ChatEventPro(), this);
        }
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        this.saveDefaultConfig();
        createCustomConfig();
        read();
        parameters();
        database();
        chat();
        getCommand("lang").setExecutor(new Language());
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Translation Enabled!");
    }


    public FileConfiguration getCustomConfig() { return this.customConfig; }

    //Creates Custom Configuration File
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

    public static Translated getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Translation Disabled!");
    }

}
