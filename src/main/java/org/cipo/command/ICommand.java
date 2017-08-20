package org.cipo.command;

import org.cipo.IApplication;
import org.cipo.tui.ITerminal;

public interface ICommand {
	
	public void handle();
	public void help();
	public void setArgs(String[] args);
	public void setApp(IApplication app);
	public ITerminal term();

}
