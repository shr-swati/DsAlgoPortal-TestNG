package dsAlgo_Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	static ConfigReader configFileReader = new ConfigReader();

	private static Properties properties;
	private final static String propertyFilePath = "src/test/resources/Config/config.properties";

	public ConfigReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public static String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public static String getBrowser() {
		String browser = properties.getProperty("browser");
		if (browser != null) {
			return browser;
		} else {
			throw new RuntimeException("Browser not specified in the Configuration.properties file.");
		}
	}
	
	public String getExcelPath() {
        String testDataPath = properties.getProperty("excelPath");
        if (testDataPath != null) {
            return testDataPath;
        } else {
            throw new RuntimeException("Test Data not specified in the Configuration.properties file.");
        }
    }

}