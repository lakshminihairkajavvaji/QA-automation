package com.crm.config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Configuration {
	
	private static Logger log = Logger.getLogger(Configuration.class.getName());
	public static WebDriver wd = null;
	public Properties prop = null;
	public FileInputStream fis = null;
	public void invokeBrowser() {
		try {
			PropertyConfigurator.configure("src//test//resources//log4j.properties");
			fis = new FileInputStream("src//test//resources//config.properties");
			prop = new Properties();	prop.load(fis);
			String br = prop.getProperty("browser");
			if(br.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\ScriptDrivers\\chromedriver.exe");
				wd = new ChromeDriver();
				log.info("Browser opened Successfully");
			}
			else if(br.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\ScriptDrivers\\geckodriver.exe");
				wd =  new FirefoxDriver();
			}
			else if (br.equalsIgnoreCase("iexplore")) {
				System.setProperty("webdriver.ie.driver", "C:\\ScriptDrivers\\IEDriverServer.exe");
				wd = new InternetExplorerDriver();
			}
			wd.navigate().to(prop.getProperty("qa_url"));
			wd.manage().window().maximize();
//			String Implicit_wait = prop.getProperty("implicitly_wait");
//			int impwait = Integer.parseInt(Implicit_wait);
//			wd.manage().timeouts().implicitlyWait(impwait, TimeUnit.SECONDS);
			log.info("page opened successfully");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
