package io.github.AnonimMaster.PvPLadder.commands;

import io.github.AnonimMaster.PvPLadder.LanguageSupport;
import io.github.AnonimMaster.PvPLadder.events.LanguageSwitchEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class LanguageCommand implements CommandExecutor, Listener {
    private final JavaPlugin plugin;
    private final LanguageSupport languageSupport;
    private String SuccessCommand = "You have set the language";

    public LanguageCommand(JavaPlugin plugin, LanguageSupport languageSupport) {
        this.plugin = plugin;
        this.languageSupport = languageSupport;
        var command = plugin.getCommand("language");
        command.setExecutor(this);
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        this.languageSupport.SwitchLanguages(strings[0]);
        commandSender.sendMessage(SuccessCommand + ": " + strings[0]);
        return true;
    }

    @EventHandler
    public void switchLanguage(LanguageSwitchEvent event) {
        plugin.getCommand("language").setDescription(this.languageSupport.getString("Stats.DescriptionCommand"));
        SuccessCommand = this.languageSupport.getString("");
    }
}
