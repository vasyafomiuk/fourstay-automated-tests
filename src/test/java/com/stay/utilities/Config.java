package com.stay.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {
	static Properties configFile;
	public static String getProperty(String key){
		try{
		String path = "./src/test/resources/com/stay/test-data/confiduration.properties";
		FileInputStream input = new FileInputStream(path);
		configFile = new Properties();
		configFile.load(input);
		input.close();
		}catch(Exception e){
			System.out.println("File not found. Please contact support");
		}
		return configFile.getProperty(key);
	}
}
