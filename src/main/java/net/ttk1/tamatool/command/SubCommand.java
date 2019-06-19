package net.ttk1.tamatool.command;

import org.bukkit.command.CommandSender;

import java.util.Set;

public interface SubCommand {
    boolean match(String[] args);
    void execute(CommandSender sender, String[] args);
    Set<String> tabComplete(CommandSender sender, String[] args);
}