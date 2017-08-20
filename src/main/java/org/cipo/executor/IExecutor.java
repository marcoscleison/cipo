package org.cipo.executor;

import java.io.IOException;

public interface IExecutor {
	
	public boolean loadKernel();
	public void execFromResource(String filename);
	public void execFromFile(String filepath)throws IOException;

}
