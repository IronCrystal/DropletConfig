package me.IronCrystal.DropletConfig.commands;

import me.IronCrystal.DropletConfig.DropletConfig;

import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Command;
import org.spout.api.command.annotated.NestedCommand;
import org.spout.api.exception.CommandException;

public class DropletCommand {
	
	private final DropletConfig plugin;

	/**
	 * We must pass in an instance of our plugin's object for the annotation to register under the factory.
	 * @param instance
	 */
	public DropletCommand(DropletConfig instance) {
		plugin = instance;
	}

	// This is the command. Will detail all the options later.
	@Command(aliases = {"c", "config"}, usage = "", desc = "Access droplet config commands")
	// This is the class with all subcommands under /config
	@NestedCommand(DropletCommands.class)
	public void config(CommandContext args, CommandSource source) throws CommandException {
	}
}

//[14:33] <Afforess> Iron_Crystal: hmm
//[14:34] <Afforess> Iron_Crystal: to use the default injector, you need to have the plugin variable as the constructor for the command class
//[14:34] <Afforess> right?
//[14:34] <Afforess> it's commented it
//[14:34] <Afforess> https://github.com/IronCrystal/DropletConfig/blob/master/src/me/IronCrystal/DropletConfig/commands/DropletCommand.java#L15
//[14:34] <Zidane> Affy he says if he uncomments that
//[14:34] <Zidane> exception
//[14:34] <Zidane> (atleast he said above)
//[14:35] <Afforess> oh
//[14:35] <Afforess> when he sets up the SimpleInjector, he needs to pass the plugin variable
//[14:35] <Afforess> the injector needs to know what to inject
//[14:36] <Afforess> btw, this whole thing is called class injection and it's an interesting feature/design pattern
//[14:36] <Zidane> I know. I've read over it a bit and its pretty cool
//[14:36] <Afforess> Play framework uses it with controllers too
//[14:36] <Afforess> it's coo
//[14:36] <Zidane> Yeah I see that now, didn't catch it earlier
//[14:36] <Zidane> He forgot a "this" for the SimpleInjector
//[14:38] <Afforess> well assuming he wanted to access the plugin variable, yeah
//[14:38] <Afforess> he could use any combo of variables to inject
//[14:38] <Zidane> Correct, that is what is cool about it.