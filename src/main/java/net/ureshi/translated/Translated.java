package net.ureshi.translated;

import net.ureshi.translated.ChatListener.ChatEventFree;
import net.ureshi.translated.ChatListener.ChatEventPro;
import net.ureshi.translated.deepl.request.Free;
import net.ureshi.translated.deepl.request.Pro;
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
    private static Translated instance;
    private String lastchar;
    public static String auth;
    public String ss;
    public String pf;
    public String en;
    public String la;
    public String li;
    public static String originaltext;
    public static String translatedtext;

    public void read() {
        auth = getCustomConfig().getString("authkey");
        ss = getCustomConfig().getString("options.splitsentences");
        pf = getCustomConfig().getString("options.preserveformatting");
        en = getCustomConfig().getString("options.logchat.enabled");
        la = getCustomConfig().getString("options.logchat.lang");
        li = getCustomConfig().getString("options.limiter.limit");
        lastchar = auth.substring(auth.length()-3);
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Read Event Called!");
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        createCustomConfig();
        read();
        if(lastchar.equals(":fx")){
            Bukkit.getPluginManager().registerEvents(new ChatEventFree(), this);
            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Free Event Registered!");
        }else{
            Bukkit.getPluginManager().registerEvents(new ChatEventPro(), this);
            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Pro Event Registered!");
        }
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Translation Enabled!");
    }

    public static Translated getInstance() {
        return instance;
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

    public void Please() throws IOException {
        if(lastchar.equals(":fx")){
            Bukkit.getPluginManager().callEvent(new Free());
        }else{
            Bukkit.getPluginManager().callEvent(new Pro());
        }
    }
}
