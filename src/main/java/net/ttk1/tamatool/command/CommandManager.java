package net.ttk1.tamatool.command;

import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class CommandManager {
    private List<SubCommand> subCommands;

    CommandManager() {
        subCommands = new ArrayList<>();
    }

    public void registerCommand(SubCommand subCommand) {
        subCommands.add(subCommand);
    }

    List<SubCommand> getCommands() {
        return subCommands;
    }
}