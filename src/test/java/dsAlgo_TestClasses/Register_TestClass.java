package dsAlgo_TestClasses;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Register_PageFactory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.DataProviderClass;
import dsAlgo_Utilities.ListenersReporter;
import dsAlgo_Utilities.LoggerReader;

@Listeners(dsAlgo_Utilities.ListenersReporter.class)

public class Register_TestClass extends BaseClass {

	public ConfigReader config = new ConfigReader();
	Home_PageFactory homePage;
	Register_PageFactory registerPage;
	WebDriver driver;
	
	@BeforeMethod
	public void initPageObjects() {
		homePage = new Home_PageFactory();
		registerPage = new Register_PageFactory();
		homePage.launchUrl();
		homePage.getStartedHomeBtnClick();

	}

	@Test(priority = 1, dataProvider = "registerBothPwdBlank", dataProviderClass = DataProviderClass.class)
	public void callregisterBothPwdBlank(String username, String password, String confirmpwd, String message) throws InterruptedException, IOException {
		
		registerPage.registerLinkClick();
		registerPage.enterusername(username);
		registerPage.enterpassword(password);
		registerPage.enterpwdConfirm(confirmpwd);
		registerPage.registerBtnClick();
		String InvalidMsg = registerPage.getPopUpMessage();
		Assert.assertEquals(InvalidMsg, message);
		LoggerReader.info("Please fill out this field.");

	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		registerPage.closebrowser();
	}

	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE && driver != null) {
			LoggerReader.info("Test failed: " + result.getName() + ". Attaching screenshot to Allure.");
			ListenersReporter.attachScreenshotToAllure(driver);
		}

	}
}
