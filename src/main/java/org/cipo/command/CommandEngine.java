package org.cipo.command;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.cipo.IApplication;
import org.cipo.command.commands.HelpCommand;
import org.cipo.command.commands.TestCommand;
import org.cipo.tui.ITerminal;

import com.google.inject.Inject;

public class CommandEngine {
	private String[] args;
	private Map<String, ICommand> commands;
	private ITerminal term;
	private IApplication app;
	
	public CommandEngine() {
		this.commands = new HashMap<String, ICommand>();
		this.setup();
	//	this.setupApp();
	}
	
	@Inject
	public void setTerminal(ITerminal terminal) {
		this.term = terminal;
	}
	
	@Inject
	public void setApp(IApplication app) {
		this.app = app;
	}
	public void setArgs(String[] args) {
		this.args = args;
	}
	
	
	public void setup() {
		this.AddCommand("help", new HelpCommand());
		this.AddCommand("test", new TestCommand());
		
	}
	
	public void setupApp() {
		
		Iterator it = this.commands.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        ICommand cmd =  (ICommand)pair.getValue();
	        cmd.setApp(this.app);
	    }		
	}
	
	public void AddCommand(String name, ICommand cmd) {
		this.commands.put(name, cmd);
		//this.term.info("setting app ", this.app);
		//cmd.setApp(this.app);
		
	}
	public void run() {
		//this.term.bgcolor(ITerminal.CYAN);
		//this.term.println("Running ", "A ", "Variadic ",1,2,3);
		//this.term.println("Running ", "A ", "Variadic ",1,2,3);
		//this.term.bgcolor(ITerminal.WHITE);
		boolean executed = false;
		for (String cmd_name : args) {
			ICommand cmd = this.commands.get(cmd_name);
			if(cmd != null) {
				cmd.setArgs(args);
				cmd.setApp(this.app);
				cmd.handle();
				executed = true;
			}
		}
		
		if(!executed) {
			 Iterator it = this.commands.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        //System.out.println(pair.getKey());
			        ICommand cmd =  (ICommand)pair.getValue();
			        if(cmd!=null) {
						cmd.setApp(this.app);
						
						cmd.setArgs(args);
			        	cmd.help();
			        }
			        it.remove(); // avoids a ConcurrentModificationException
			    }
		}
		
	}
	
}
