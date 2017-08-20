package org.cipo;

import java.io.IOException;

import org.cipo.executor.IExecutor;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Application implements IApplication {
	
	private IExecutor executor;

	public Application() {
		
	}
	
	@Inject
	public void setExecutor(IExecutor executor) {
		this.executor=executor;
	}

	@Override
	public void RunScript(String code) {
		
	
		
	}

	@Override
	public void RunScriptFromFile(String file) {
		try {
			this.executor.execFromFile(file);
					
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
