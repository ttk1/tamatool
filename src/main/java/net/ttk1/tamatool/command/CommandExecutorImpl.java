package net.ttk1.tamatool.command;

import com.google.inject.Inject;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.stream.Collectors;

public class CommandExecutorImpl implements CommandExecutor {
    private CommandManager commandManager;

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command bukkitCommand, String label, String[] args) {
        List<Command> matchedCommands = commandManager.getCommands().values().stream()
                .filter(command -> command.match(args)).collect(Collectors.toList());
        if (matchedCommands.size() == 1) {
            Command matched = matchedCommands.get(0);
            matched.execute(sender, args);
        } else if (sender.hasPermission("tamatool.help")) {
            Command command = args.length > 0 ? commandManager.getCommands().get(args[0]) : null;
            if (command != null) {
                sender.sendMessage(command.help());
            } else {
                sender.sendMessage("usage: /tamatool <command> [OPTION]...");
            }
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