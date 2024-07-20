package io.github.AnonimMaster.PvPLadder.commands;

import io.github.AnonimMaster.PvPLadder.DAL.LanguageSupport;
import io.github.AnonimMaster.PvPLadder.domain.arenas.Arena;
import io.github.AnonimMaster.PvPLadder.events.LanguageSwitchEvent;
import io.github.AnonimMaster.PvPLadder.gui.GuiManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class ArenasCommand implements CommandExecutor, Listener {
    private final JavaPlugin plugin;
    private final LanguageSupport languageSupport;

    public ArenasCommand(JavaPlugin plugin, LanguageSupport languageSupport) {
        this.plugin = plugin;
        this.languageSupport = languageSupport;
        var command = plugin.getCommand("arenas");
        command.setExecutor(this);
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player) {
            GuiManager.getArenaEditMenu((Player) commandSender, new Arena());
        }
        return true;
    }

    @EventHandler
    public void switchLanguage(LanguageSwitchEvent event) {
        plugin.getCommand("arenas").setDescription(this.languageSupport.getString("Arenas.DescriptionCommand"));
    }
}
