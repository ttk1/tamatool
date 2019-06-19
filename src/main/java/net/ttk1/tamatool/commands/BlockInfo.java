package net.ttk1.tamatool.commands;

import net.ttk1.tamatool.command.AbstractCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public class BlockInfo extends AbstractCommand {
    private final JavaPlugin plugin;

    public BlockInfo(JavaPlugin plugin) {
        super("blockinfo", "tamatool.blockinfo");
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String help() {
        return "usage: /tamatool blockinfo world_name x y z";
    }

    @Override
    public boolean match(String[] args) {
        return args.length == 5 && args[0].equals(NAME);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission(PERMISSION)) {
            sender.sendMessage("");
        } else {
            sender.sendMessage("You don't hove permission to perform this command.");
        }
    }
}