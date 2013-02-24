package me.IronCrystal.DropletConfig;

import java.util.logging.Level;

import me.IronCrystal.DropletConfig.commands.DropletCommand;
import me.IronCrystal.DropletConfig.config.DropletConfigFile;

import org.spout.api.UnsafeMethod;
import org.spout.api.command.CommandRegistrationsFactory;
import org.spout.api.command.annotated.AnnotatedCommandRegistrationFactory;
import org.spout.api.command.annotated.SimpleAnnotatedCommandExecutorFactory;
import org.spout.api.command.annotated.SimpleInjector;
import org.spout.api.exception.ConfigurationException;
import org.spout.api.plugin.CommonPlugin;

public class DropletConfig extends CommonPlugin {

	public DropletConfigFile configFile;

	@Override
	public void onDisable() {
		getLogger().log(Level.INFO, "disabled");
	}

	@Override
	@UnsafeMethod
	public void onEnable() {
		/**
		 * Initialize file
		 */
		try {
			configFile.load();
		} catch (ConfigurationException e) {
			getLogger().log(Level.WARNING, "Error loading Config", e);
		}

		getLogger().log(Level.INFO, getDescription().getVersion() + " enabled");

		/**
		 * Commands
		 */
		CommandRegistrationsFactory<Class<?>> commandRegFactory = new AnnotatedCommandRegistrationFactory(new SimpleInjector(this), new SimpleAnnotatedCommandExecutorFactory());
		getEngine().getRootCommand().addSubCommands(this, DropletCommand.class, commandRegFactory);		
	}

	@Override
	public void onLoad() {
		configFile = new DropletConfigFile(getDataFolder());
	}

	public DropletConfigFile getConfig() {
		return configFile;
	}
}
