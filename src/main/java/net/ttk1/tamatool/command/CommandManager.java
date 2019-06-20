package net.ttk1.tamatool.command;

import com.google.inject.Singleton;

import java.util.Map;
import java.util.HashMap;

@Singleton
public class CommandManager {
    private Map<String, Command> commands;

    CommandManager() {
        commands = new HashMap<>();
    }

    public void registerCommand(Command command) {
        commands.put(command.getName(), command);
    }

    Map<String, Command> getCommands() {
        return commands;
    }
}