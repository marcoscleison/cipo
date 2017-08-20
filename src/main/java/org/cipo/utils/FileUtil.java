package org.cipo.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.cipo.Cipo;

public class FileUtil {

	public static String loadFromResource(String fileName) throws IOException {

		String result = "";

		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		
		result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
	
	
		return result;
	  }
	
	public static String loadFileContent(String filepath) throws IOException{
		
		String result ="";
		File file = new File(filepath);
		result = FileUtils.readFileToString(file);	
		return result;
	}
}
