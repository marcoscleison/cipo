package org.cipo.di.modules;

import org.cipo.Application;
import org.cipo.IApplication;
import org.cipo.executor.GroovyExecutor;
import org.cipo.executor.IExecutor;
import org.cipo.tui.ITerminal;
import org.cipo.tui.Terminal;

import com.google.inject.AbstractModule;

public class ApplicationModule extends AbstractModule {

	@Override
	protected void configure() {
	
		this.bind(IApplication.class).to(Application.class);
		this.bind(ITerminal.class).to(Terminal.class);
		this.bind(IExecutor.class).to(GroovyExecutor.class);
		
	}
}
