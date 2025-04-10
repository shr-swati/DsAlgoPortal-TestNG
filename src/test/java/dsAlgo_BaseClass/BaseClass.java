package dsAlgo_BaseClass;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.ListenersReporter;

import dsAlgo_Utilities.LoggerReader;
import com.aventstack.chaintest.plugins.ChainTestListener;

public class BaseClass {

	public WebDriver driver;
	Login_PageFactory loginpf;
	ConfigReader config = new ConfigReader();

	@BeforeMethod
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) {
		DriverFactory.setUp(browser);
		driver = DriverFactory.getDriver();
		ChainTestListener.log("Browser factory setup");
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory driverFactory = new DriverFactory();
		driverFactory.tearDown();
	}

	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE && driver != null) {
			LoggerReader.info("Test failed: " + result.getName() + ". Attaching screenshot to Allure.");
			ListenersReporter.attachScreenshotToAllure(driver);
		}
	}

}
