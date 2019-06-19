package net.ttk1.tamatool;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import net.ttk1.tamatool.command.TamaToolCommandExecutor;
import net.ttk1.tamatool.command.TamaToolTabCompleter;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

public class PluginModule extends AbstractModule {

    private final TamaTool plugin;

    PluginModule(TamaTool plugin) {
        this.plugin = plugin;
    }

    Injector createInjector() {
        return Guice.createInjector(this);
    }

    @Override
    protected void configure() {
        bind(TamaTool.class).toInstance(plugin);
        bind(CommandExecutor.class).to(TamaToolCommandExecutor.class);
        bind(TabCompleter.class).to(TamaToolTabCompleter.class);
    }
}