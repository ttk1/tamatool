package net.ttk1.tamatool.commands;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandSender;

import net.ttk1.tamatool.command.SubCommand;

import java.util.HashSet;
import java.util.Set;

public class VersionCommand implements SubCommand {
    private final String NAME = "version";
    private final String PERMISSION = "tamatool.version";
    private final String version;

    public VersionCommand(JavaPlugin plugin) {
        this.version = plugin.getDescription().getVersion();
    }

    @Override
    public boolean match(String[] args) {
        return args.length == 1 && args[0].equals(NAME);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission(PERMISSION)) {
            sender.sendMessage(version);
        } else {
            sender.sendMessage("You don't hove permission to perform this command.");
        }
    }

    @Override
    public Set<String> tabComplete(CommandSender sender, String[] args) {
        HashSet<String> candidates = new HashSet<>();
        if (sender.hasPermission(PERMISSION)) {
            if (args.length == 0) {
                candidates.add(NAME);
            } else if (args.length == 1 && NAME.startsWith(args[0])) {
                candidates.add(NAME);
            }
        }
        return candidates;
    }
}