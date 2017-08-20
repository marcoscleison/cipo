package org.cipo.command;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.cipo.IApplication;
import org.cipo.tui.ITerminal;
import org.cipo.tui.Terminal;

public class Command implements ICommand{
	
	private ITerminal term;
	private String[] args;
	private String command_name;
	private ArrayList<String> arguments;
	
	private IApplication app;
	
	
	public Command() {
		this.term=new Terminal();
		
	}

	@Override
	public void handle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void help() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setArgs(String[] args) {
		this.args = args;
		this.arguments =new ArrayList<String>(Arrays.asList(this.args));
		this.command_name = this.arguments.get(0);
		this.arguments.remove(0);
		
	}
	
	public String getArgument(int idx) {
		
		if(this.argsExists(idx)) {
			return this.arguments.get(idx);	
		}else {
			
			return "";
		}
		
		
	}
	public boolean argsExists(int idx) {
		if(this.arguments.isEmpty()) {
			return false;
		}
		
		try {
			this.arguments.get(idx);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		
	}
	
	
	public void info(Object... obj) {
		this.term.infoln();
		this.term.color("WHITE");
		
	}
	public void warn(String... strs) {
		this.term.color("YELLOW");
		for (String str : strs) {
			System.out.print(str);
		}
		System.out.println("");
		this.term.color("WHITE");
		
	}
	public void error(String... strs) {
		this.term.color("RED");
		for (String str : strs) {
			System.out.print(str);
		}
		System.out.println("");
		this.term.color("WHITE");
		
	}
	public void comment(String... strs) {
		this.term.color("BLUE");
		for (String str : strs) {
			System.out.print(str);
		}
		System.out.println("");
		this.term.color("WHITE");
		
	}
	public void printArgs() {
		for (String str : args) {
			System.out.print(str+" ");
		}
		System.out.println("");
	}

	@Override
	public ITerminal term() {
		// TODO Auto-generated method stub
		return this.term;
	}

	@Override
	public void setApp(IApplication app) {
		// TODO Auto-generated method stub
		this.info("Setting app ",app);
		this.app = app;
		
	}
	public IApplication App() {
		
		return this.app;
	}
	

}
