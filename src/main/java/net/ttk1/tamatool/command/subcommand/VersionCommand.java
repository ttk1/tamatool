package net.ttk1.tamatool.command.subcommand;

import net.ttk1.tamatool.TamaTool;

import org.bukkit.command.CommandSender;

import java.util.HashSet;
import java.util.Set;

public class VersionCommand implements SubCommand {
    private final String SUB_COMMAND = "version";
    private final String PERMISSION = "tamatool.version";

    private TamaTool plugin;

    public VersionCommand(TamaTool plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean match(String[] args) {
        return args.length == 1 && args[0].equals(SUB_COMMAND);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission(PERMISSION)) {
            sender.sendMessage(plugin.getDescription().getVersion());
        } else {
            sender.sendMessage("You don't hove permission to perform this command.");
        }
    }

    @Override
    public Set<String> tabComplete(CommandSender sender, String[] args) {
        HashSet<String> candidates = new HashSet<>();
        if (sender.hasPermission(PERMISSION)) {
            if (args.length == 0) {
                candidates.add(SUB_COMMAND);
            } else if (args.length == 1 && SUB_COMMAND.startsWith(args[0])) {
                candidates.add(SUB_COMMAND);
            }
        }
        return candidates;
    }
}