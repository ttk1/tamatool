package net.ttk1.tamatool.commands;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import net.ttk1.tamatool.command.AbstractCommand;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
            try {
                String world_name = args[1];
                int x = Integer.parseInt(args[2]);
                int y = Integer.parseInt(args[3]);
                int z = Integer.parseInt(args[4]);

                World world = plugin.getServer().getWorld(world_name);
                if (world != null) {
                    Block block = world.getBlockAt(x, y, z);
                    sender.sendMessage(block.toString());
                } else {
                    sender.sendMessage("The world does not exist.");
                }
            } catch (Exception e) {
                sender.sendMessage("error!");
            }
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
            } else if (args.length == 2 && NAME.equals(args[0])) {
                candidates.addAll(plugin.getServer().getWorlds().stream()
                                .map(World::getName)
                                .filter(world_name -> world_name.startsWith(args[1]))
                                .collect(Collectors.toSet()));
            }
        }
        return candidates;
    }
}