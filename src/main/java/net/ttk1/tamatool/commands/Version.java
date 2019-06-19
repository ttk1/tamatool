package net.ttk1.tamatool.commands;


import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandSender;

import net.ttk1.tamatool.command.AbstractCommand;

import java.util.HashSet;
import java.util.Set;

public class Version extends AbstractCommand {
    private final String version;

    public Version(JavaPlugin plugin) {
        super("version", "tamatool.version");
        this.version = plugin.getDescription().getVersion();
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String help() {
        return "usage: /tamatool version";
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
}