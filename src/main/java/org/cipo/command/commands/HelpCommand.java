package org.cipo.command.commands;

import org.cipo.command.Command;
import org.cipo.command.ICommand;
import org.cipo.tui.ITerminal;
import org.cipo.tui.Terminal;

public class HelpCommand  extends Command {
    private String[] args;
    public HelpCommand() {
    	super();
    }
    
	@Override
	public void handle() {
		
		this.info("Information");
		this.warn("Warning");
		this.error("error");
		this.comment("comments");
				
		this.printArgs();
		

	}

	@Override
	public void help() {
		
		System.out.println("\t help - show helper of files");

	}

	
	
}
