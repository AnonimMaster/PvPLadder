package io.github.AnonimMaster.PvPLadder.commands;

import io.github.AnonimMaster.PvPLadder.DAL.LanguageSupport;
import io.github.AnonimMaster.PvPLadder.events.LanguageSwitchEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class StatsCommand implements CommandExecutor, Listener {
    private final JavaPlugin plugin;
    private final LanguageSupport languageSupport;
    
    private String KillsText = "Kills";
    private String DeathsText= "Deaths";
    private String WinsText= "Wins";
    private String LossesText= "Losses";
    private String RatingText= "Rating";

    public StatsCommand(JavaPlugin plugin, LanguageSupport languageSupport) {
        this.plugin = plugin;
        this.languageSupport = languageSupport;

        var command = plugin.getCommand("stats");
        command.setExecutor(this);
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        commandSender.sendMessage(KillsText + ": " + 0);
        commandSender.sendMessage(DeathsText + ": " + 0);
        commandSender.sendMessage(WinsText + ": " + 0);
        commandSender.sendMessage(LossesText + ": " + 0);
        commandSender.sendMessage(RatingText + ": " + 0);
        return true;
    }

    @EventHandler
    public void switchLanguage(LanguageSwitchEvent event) {
        plugin.getCommand("stats").setDescription(this.languageSupport.getString("Stats.DescriptionCommand"));
        KillsText = languageSupport.getString("Stats.Kills");
        DeathsText = languageSupport.getString("Stats.Deaths");
        WinsText = languageSupport.getString("Stats.Wins");
        LossesText = languageSupport.getString("Stats.Losses");
        RatingText = languageSupport.getString("Stats.Rating");
    }
}
