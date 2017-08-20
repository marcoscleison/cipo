package org.cipo.command.commands;

import org.cipo.command.Command;

public class TestCommand extends Command {
	
	public TestCommand() {
		super();
	}
	
	@Override
	public void handle() {
		
		this.term().infoln("Executing teste");
		
		String file = this.getArgument(0);
		//this.term().infoln("Opening ", file);
		
		//this.term().commentln(this.App());
		this.App().RunScriptFromFile(file);		

	}

	@Override
	public void help() {
		
		this.term().infoln("test");
		
		this.term().comment("\t script - runs the script");

	}

}
