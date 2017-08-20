package org.cipo.executor;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.cipo.tui.ITerminal;
import org.cipo.utils.FileUtil;

import com.google.inject.Inject;

import groovy.lang.GroovyRuntimeException;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

public class GroovyExecutor implements IExecutor {

	private ITerminal term;
	final private GroovyShell shell;
	
	public GroovyExecutor() {
		this.shell = new GroovyShell();
		
	}
	
	@Inject
	public void setTerminal(ITerminal terminal) {
		this.term = terminal;
	}
	


	@Override
	public boolean loadKernel() {
		// TODO Auto-generated method stub
		
		try {
			String kernel = FileUtil.loadFromResource("script/kernel.groovy");
			//shell.evaluate(kernel,"kernel.groovy");
			
		Script script =	shell.parse(kernel);
			//shell.run(kernel, "kernel.groov", new ArrayList<String>());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}catch (GroovyRuntimeException e) {
			this.term.error( e.getMessage());
		}
		
		
		
		return false;
	}
	@Override
	public void execFromResource(String filename) {
		
		try {
			String kernel = FileUtil.loadFromResource(filename);
			Script script =	shell.parse(kernel, filename);
			//shell.run(kernel, filename, new ArrayList<String>());
			script.run();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		
		}catch (GroovyRuntimeException e) {
			this.term.error( e.getMessage());
		}
		
	
		
	}

	@Override
	public void execFromFile(String filepath)  {
		
		try {
			String content = FileUtil.loadFileContent(filepath);
			Script script =	shell.parse(content, filepath);
			script.run();
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (GroovyRuntimeException e) {
			this.term.error( e.getMessage());
		}
		
		
		
	}
	
	
}
