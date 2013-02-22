package me.IronCrystal.DropletConfig.commands;

import me.IronCrystal.DropletConfig.DropletConfig;
import me.IronCrystal.DropletConfig.config.DropletConfigFile;

import org.spout.api.chat.ChatArguments;
import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Command;
import org.spout.api.command.annotated.CommandPermissions;
import org.spout.api.exception.ConfigurationException;

public class DropletCommands {

	DropletConfig plugin = new DropletConfig();

	public DropletCommands(DropletConfig instance) {
		plugin = instance;
	}

	@Command(aliases = {"i", "int"}, usage = "<integer>", desc = "Edits the integer portion of the config.")
	@CommandPermissions("droplet.command.int")
	public void i(CommandContext args, CommandSource source) {
		//DropletConfigFile config = plugin.getConfig();
		int value = args.getInteger(0);
		DropletConfigFile.INT.setValue(value);
//		try {
//			plugin.configFile.save();
//			plugin.getConfig().save();
//		} catch (ConfigurationException e) {
//			e.printStackTrace();
//		}
//		try {
//			config.save();
//		} catch (ConfigurationException e) {
//			e.printStackTrace();
//		}
		
		source.sendMessage(new ChatArguments(value, " was added to the integer config file."));
		source.sendMessage(new ChatArguments("The new value is ", DropletConfigFile.INT.getValue()));
	}

	@Command(aliases = {"s", "string"}, usage = "<string>", desc = "Edits the string portion of the config.")
	@CommandPermissions("droplet.command.int")
	public void s(CommandContext args, CommandSource source) {
		//DropletConfigFile config = plugin.getConfig();
		String value = args.getString(0);
		DropletConfigFile.STRING.setValue(value);
//		try {
//			config.save();
//		} catch (ConfigurationException e) {
//			e.printStackTrace();
//		}
		source.sendMessage(new ChatArguments(value, " was added to the string config file."));
	}

	@Command(aliases = {"sl", "stringlist"}, usage = "<stringlist>", desc = "Adds the string to the string list portion of the config.")
	@CommandPermissions("droplet.command.int")
	public void sl(CommandContext args, CommandSource source) {
		//DropletConfigFile config = plugin.getConfig();
		String value = args.getString(0);
		DropletConfigFile.STRINGLIST.getStringList().add(value);
//		try {
//			config.save();
//		} catch (ConfigurationException e) {
//			e.printStackTrace();
//		}
		source.sendMessage(new ChatArguments(value, " was added to the string list config file."));
	}
}
