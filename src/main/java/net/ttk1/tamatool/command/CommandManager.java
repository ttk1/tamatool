package net.ttk1.tamatool.command;

import com.google.inject.Singleton;

import java.util.Map;
import java.util.HashMap;

@Singleton
public class CommandManager {
    private Map<String, SubCommand> subCommands;

    CommandManager() {
        subCommands = new HashMap<>();
    }

    public void registerCommand(SubCommand subCommand) {
        subCommands.put(subCommand.getName(), subCommand);
    }

    Map<String, SubCommand> getCommands() {
        return subCommands;
    }
}