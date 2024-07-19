package io.github.AnonimMaster.PvPLadder;

import io.github.AnonimMaster.PvPLadder.events.LanguageSwitchEvent;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Map;

public class LanguageSupport {
    private final JavaPlugin plugin;
    private String currentLanguage;
    private Map<String, Object> locale;

    public LanguageSupport(JavaPlugin plugin) {
        this.plugin = plugin;
        InitLanguages();
    }

    public String getString(String key) {
        return (String) locale.get(key);
    }
    
    public void SwitchLanguages(String language){
        new LanguageSwitchEvent().callEvent();
        SetLanguage(language);
    }

    private void saveDefaultConfig() {
        var languagesFolder = new File(plugin.getDataFolder()+"/languages");
        if(!languagesFolder.exists()) {
            languagesFolder.mkdir();
        }
        
        var ru = new File(languagesFolder, "ru.yml");
        if(!ru.exists()) {
            plugin.saveResource("languages/ru.yml", false);
        }

        var en = new File(languagesFolder, "en.yml");
        if(!en.exists()) {
            plugin.saveResource("languages/en.yml", false);
        }
    }
    
    private void SetLanguage(String language) {
        plugin.getConfig().set("locale",language);
        currentLanguage = language;
        var file = new File(plugin.getDataFolder()+"/languages", String.format("%s.yml",currentLanguage));
        plugin.getLogger().info(file.toPath().toString());
        var messages = YamlConfiguration.loadConfiguration(file);
        locale = messages.getValues(true);
    }

    private void InitLanguages(){
        saveDefaultConfig();
        SetLanguage(plugin.getConfig().getString("locale"));
    }
}
