package net.ttk1.tamatool.command;

import com.google.inject.Inject;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class TabCompleterImpl implements TabCompleter {
    private CommandManager commandManager;

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        Set<String> candidates = new HashSet<>();
        for (SubCommand subCommand: commandManager.getCommands().values()) {
            candidates.addAll(subCommand.tabComplete(sender, args));
        }
        return new ArrayList<>(candidates);
    }

    @Inject
    private void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }
}