package me.IronCrystal.DropletConfig.commands;

import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Command;
import org.spout.api.command.annotated.NestedCommand;
import org.spout.api.exception.CommandException;

public class DropletCommand {
//
//	/**
//	 * We must pass in an instance of our plugin's object for the annotation to register under the factory.
//	 * @param instance
//	 */
//	public DropletCommand(DropletConfig instance) {
//		plugin = instance;
//	}

	// This is the command. Will detail all the options later.
	@Command(aliases = {"c", "config"}, usage = "", desc = "Access droplet config commands")
	// This is the class with all subcommands under /config
	@NestedCommand(DropletCommands.class)
	public void config(CommandContext args, CommandSource source) throws CommandException {
	}
}