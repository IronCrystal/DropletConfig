package me.IronCrystal.DropletConfig.config;

import java.io.File;

import org.spout.api.exception.ConfigurationException;
import org.spout.api.util.config.ConfigurationHolder;
import org.spout.api.util.config.ConfigurationHolderConfiguration;
import org.spout.api.util.config.yaml.YamlConfiguration;

public class DropletConfigFile extends ConfigurationHolderConfiguration {
	
	public static final ConfigurationHolder STRINGLIST = new ConfigurationHolder("", "String List");
	public static final ConfigurationHolder INT = new ConfigurationHolder(0, "Int");
	public static final ConfigurationHolder STRING = new ConfigurationHolder("Example", "String");

	public DropletConfigFile(File dataFolder) {
		super(new YamlConfiguration(new File(dataFolder, "config.yml")));
	}
	
	@Override
	public void load() throws ConfigurationException {
		super.load();
		super.save();
	}
	
	@Override
	public void save() throws ConfigurationException {
		super.save();
	}
}
