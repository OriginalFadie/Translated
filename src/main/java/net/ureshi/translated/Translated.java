package net.ureshi.translated;

import net.ureshi.translated.deepl.request.Free;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Translated extends JavaPlugin {

    private FileConfiguration customConfig;
    private static Translated instance;
    public String auth;
    public String ss;
    public String pf;
    public String en;
    public String la;
    public String li;



    public void read() {
        auth = getCustomConfig().getString("authkey");
        ss = getCustomConfig().getString("options.splitsentences");
        pf = getCustomConfig().getString("options.preserveformatting");
        en = getCustomConfig().getString("options.logchat.enabled");
        la = getCustomConfig().getString("options.logchat.lang");
        li = getCustomConfig().getString("options.limiter.limit");
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        createCustomConfig();
        read();
        try {
            Bukkit.getPluginManager().callEvent(new Free(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    }
}
