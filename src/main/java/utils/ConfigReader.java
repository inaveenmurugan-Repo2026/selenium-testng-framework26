package utils;
import java.io.FileInputStream;
import java.util.Properties;
public class ConfigReader {

	private Properties prop; //Stores key-value pairs: browser = chrome
	
	public ConfigReader() { // constructor ----Runs automatically when object is created // Loads config file once
		
	        try {
	            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
	            prop = new Properties();
	            prop.load(fis);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

		public String getBrowser() {
	        return prop.getProperty("browser");
	    }

	    public String getURL() {
	        return prop.getProperty("url");
	    }

	    public int getTimeout() {
	        return Integer.parseInt(prop.getProperty("timeout"));
	    }
	}
