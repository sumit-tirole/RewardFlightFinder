package com.flightfinder.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String readFromPropertyFile(String key) throws IOException
	{
		String osName = System.getProperty("os.name");
		FileInputStream fis;

        if (osName.contains("Windows")) {
            fis = new FileInputStream(".\\src\\test\\resources\\TestData.properties");
        } else {
            fis = new FileInputStream("./src/test/resources/TestData.properties");
        }
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
}
