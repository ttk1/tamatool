package net.ttk1.tamatool.command;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import net.ttk1.tamatool.TamaTool;
import net.ttk1.tamatool.command.subcommand.*;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class SubCommandManager {
    private List<SubCommand> subCommands;

    @Inject
    public SubCommandManager(TamaTool plugin) {
        subCommands = new ArrayList<>();
        subCommands.add(new VersionCommand(plugin));
    }

    public List<SubCommand> getSubCommands() {
        return subCommands;
    }
}