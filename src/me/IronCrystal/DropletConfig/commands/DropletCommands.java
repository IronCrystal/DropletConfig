package me.IronCrystal.DropletConfig.commands;

import java.util.List;

import me.IronCrystal.DropletConfig.DropletConfig;
import me.IronCrystal.DropletConfig.config.DropletConfigFile;

import org.spout.api.chat.ChatArguments;
import org.spout.api.chat.style.ChatStyle;
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
		if (args.length() == 1) {
			int value = args.getInteger(0);
			DropletConfigFile.INT.setValue(value);
			try {
				plugin.configFile.save();
			} catch (ConfigurationException e) {
				e.printStackTrace();
			}
			source.sendMessage(new ChatArguments(value, " was added to the integer config file."));
		}else{
			source.sendMessage(new ChatArguments("Syntax: /c <int/i> <integer>"));
		}
	}

	@Command(aliases = {"s", "string"}, usage = "<string>", desc = "Edits the string portion of the config.")
	@CommandPermissions("droplet.command.int")
	public void s(CommandContext args, CommandSource source) {
		if (args.length() >= 1) {
			String value = "";
			for (int i = 0; i < args.length(); i++) {
				if (value.equalsIgnoreCase("")) {
					value = args.getString(i);
				}else{
					value = value + " " + args.getString(i);
				}
			}
			DropletConfigFile.STRING.setValue(value);
			try {
				plugin.configFile.save();
			} catch (ConfigurationException e) {
				e.printStackTrace();
			}
			source.sendMessage(new ChatArguments(value, " was added to the string config file."));
		}else{
			source.sendMessage(new ChatArguments("Syntax: /c <string/s> <string>"));
		}
	}

	@Command(aliases = {"sl", "stringlist"}, usage = "<stringlist>", desc = "Adds the string to the string list portion of the config.")
	@CommandPermissions("droplet.command.int")
	public void sl(CommandContext args, CommandSource source) {
		if (args.length() >= 1) {
			String value = "";
			for (int i = 0; i < args.length(); i++) {
				if (value.equalsIgnoreCase("")) {
					value = args.getString(i);
				}else{
					value = value + " " + args.getString(i);
				}
			}
			List<String> stringList = DropletConfigFile.STRINGLIST.getStringList();
			stringList.add(value);
			DropletConfigFile.STRINGLIST.setValue(stringList);
			try {
				plugin.configFile.save();
			} catch (ConfigurationException e) {
				e.printStackTrace();
			}
			source.sendMessage(new ChatArguments(ChatStyle.RED, value, ChatStyle.WHITE, " was added to the string list config file."));
		}else{
			source.sendMessage(new ChatArguments("Syntax: /c <stringlist/sl> <string>"));
		}
	}
}
