package dsAlgo_DriverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import dsAlgo_Utilities.LoggerReader;
import dsAlgo_Utilities.ConfigReader;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static WebDriver driver;
	public static  ConfigReader configFileReader = new ConfigReader();
	private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>() ;

	@BeforeClass
	@Parameters("browser")
	public static WebDriver setUp(@Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			LoggerReader.info("Testing on firefox");
			tldriver.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("chrome")) {
			LoggerReader.info("Testing on chrome");
			tldriver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("edge")) {
			LoggerReader.info("Testing on Edge");
			tldriver.set(new EdgeDriver());
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return getDriver();
	}
	
	
	//@BeforeClass
	//@Parameters("browser")
	/*public void setUp(@Optional("chrome")  String browser ) {
		System.out.println("Browser received from TestNG: " + browser);
		if (getDriver() == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				tldriver.set(new ChromeDriver());
			} else if (		browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				tldriver.set(new FirefoxDriver());
			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				tldriver.set(new EdgeDriver());
			}
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
	}*/

	public static WebDriver getDriver() {
		return tldriver.get();
	}

	@AfterMethod
	public void tearDown() {
		if (getDriver() != null) {
			getDriver().quit();
			tldriver.remove();
		}
	}
	
	public static ConfigReader configReader() {
		return configFileReader;
	}
}