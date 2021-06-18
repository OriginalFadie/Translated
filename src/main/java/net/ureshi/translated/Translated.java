package net.ureshi.translated;

import net.ureshi.translated.configSetup.SetupEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Translated extends JavaPlugin {

    private File customConfigFile;
    private FileConfiguration customConfig;

    @Override
    public void onEnable() {
        // Plugin startup logic
        createCustomConfig();
        Bukkit.getPluginManager().callEvent(new SetupEvent());
    }

    public FileConfiguration getCustomConfig() {
        return this.customConfig;

    }

    private void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "src/settings.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("src/settings.yml", false);
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
