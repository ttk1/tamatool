package net.ttk1.tamatool.command;

import com.google.inject.Inject;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.stream.Collectors;

public class CommandExecutorImpl implements CommandExecutor {
    private CommandManager commandManager;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<SubCommand> matchedCommands = commandManager.getCommands()
                .stream().filter(subCommand -> subCommand.match(args)).collect(Collectors.toList());
        if (matchedCommands.size() == 1) {
            SubCommand matchedCommand = matchedCommands.get(0);
            matchedCommand.execute(sender, args);
        } else {
            sender.sendMessage("Command not found.");
        }
        return true;
    }

    @Inject
    private void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }
}