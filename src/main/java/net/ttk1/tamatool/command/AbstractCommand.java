package net.ttk1.tamatool.command;

import org.bukkit.command.CommandSender;

import java.util.HashSet;
import java.util.Set;

abstract public class AbstractCommand implements Command {
    protected final String NAME;
    protected final String PERMISSION;

    protected AbstractCommand(String name, String permission) {
        this.NAME = name;
        this.PERMISSION = permission;
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