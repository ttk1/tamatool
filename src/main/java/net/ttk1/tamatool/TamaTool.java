package net.ttk1.tamatool;

import com.google.inject.Inject;
import com.google.inject.Injector;

import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;

import net.ttk1.tamatool.command.CommandManager;
import net.ttk1.tamatool.commands.*;

public class TamaTool extends JavaPlugin {
    private CommandExecutor commandExecutor;
    private TabCompleter tabCompleter;
    private CommandManager commandManager;

    @Override
    public void onEnable() {
        ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(getClassLoader());

        PluginModule module = new PluginModule(this);
        Injector injector = module.createInjector();
        injector.injectMembers(this);

        PluginCommand command = getCommand("tamatool");
        if (command != null) {
            command.setExecutor(commandExecutor);
            command.setTabCompleter(tabCompleter);
            registerCommands();
            getLogger().info("TamaTool enabled.");
        } else {
            getLogger().info("Initialization failed.");
        }

        Thread.currentThread().setContextClassLoader(currentClassLoader);
    }

    @Override
    public void onDisable() {
        getLogger().info("TamaTool disabled.");
    }

    private void registerCommands() {
        commandManager.registerCommand(new Version(this));
        commandManager.registerCommand(new BlockInfo(this));
    }

    @Inject
    private void setCommandExecutor(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Inject
    private void setTabCompleter(TabCompleter tabCompleter) {
        this.tabCompleter = tabCompleter;
    }

    @Inject
    private void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }
}
