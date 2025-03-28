package dsAlgo_TestClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_Utilities.ListenersReporter;
import dsAlgo_Utilities.LoggerReader;

@Listeners(dsAlgo_Utilities.ListenersReporter.class)

public class Home_TestClass {
	
	WebDriver driver;
	Home_PageFactory homePage;
	public static final String expectedHomeMessage = "You are not logged in";

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        DriverFactory driverFactory = new DriverFactory();
        driverFactory.setUp(browser); 
        driver = DriverFactory.getDriver();
        
        homePage = new Home_PageFactory();
		homePage.launchUrl();
		LoggerReader.info("=========URL is launched========");
		homePage.getStartedHomeBtnClick();
    }

	@Test(priority = 1)
	public void arraysClick() {
		homePage.dataStructureDropDownClick();
		homePage.arraysBtnClick();
		assertMessage();
		LoggerReader.info("Arrays option under Data Structures drop-down is clicked in HomePage");
	}

	@Test(priority = 2)
	public void linkedListClick() {
		homePage.dataStructureDropDownClick();
		homePage.linkedListBtnClick();
		assertMessage();
		LoggerReader.info("Linked List option under Data Structures drop-down is clicked in HomePage");
	}

	@Test(priority = 3)
	public void stackClick() {
		homePage.dataStructureDropDownClick();
		homePage.stackBtnClick();
		assertMessage();
		LoggerReader.info("Stack option under Data Structures drop-down is clicked in HomePage");
	}

	@Test(priority = 4)
	public void queueClick() {
		homePage.dataStructureDropDownClick();
		homePage.queueBtnClick();
		assertMessage();
		LoggerReader.info("Queue option under Data Structures drop-down is clicked in HomePage");
	}

	@Test(priority = 5)
	public void treeClick() {
		homePage.dataStructureDropDownClick();
		homePage.treeBtnClick();
		assertMessage();
		LoggerReader.info("Tree option under Data Structures drop-down is clicked in HomePage");
	}

	@Test(priority = 6)
	public void graphClick() {
		homePage.dataStructureDropDownClick();
		homePage.graphBtnClick();
		assertMessage();
		LoggerReader.info("Graph option under Data Structures drop-down is clicked in HomePage");
	}

	public void assertMessage() {
		String homeText = homePage.getHomeLogMessage();
		Assert.assertEquals(homeText, expectedHomeMessage);
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