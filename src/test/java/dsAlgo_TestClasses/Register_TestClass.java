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
	
	@Test(priority = 2, dataProvider = "registerUnameBlank", dataProviderClass = DataProviderClass.class)
	public void callregisterUnameBlank(String username, String password, String confirmpwd, String message) throws InterruptedException, IOException {
		
		registerPage.registerLinkClick();
		registerPage.enterusername(username);
		registerPage.enterpassword(password);
		registerPage.enterpwdConfirm(confirmpwd);
		registerPage.registerBtnClick();
		String InvalidMsg = registerPage.getPopUpMessage();
		Assert.assertEquals(InvalidMsg, message);
		LoggerReader.info("Please fill out this field.");

	}
	
	@Test(priority = 3, dataProvider = "registerOnePwdBlank", dataProviderClass = DataProviderClass.class)
	public void callregisterOnePwdBlank(String username, String password, String confirmpwd, String message) throws InterruptedException, IOException {
		
		registerPage.registerLinkClick();
		registerPage.enterusername(username);
		registerPage.enterpassword(password);
		registerPage.enterpwdConfirm(confirmpwd);
		registerPage.registerBtnClick();
		String InvalidMsg = registerPage.getPopUpMessage();
		Assert.assertEquals(InvalidMsg, message);
		LoggerReader.info("Please fill out this field.");

	}
	
	@Test(priority = 4, dataProvider = "registerInvalidUname", dataProviderClass = DataProviderClass.class)
	public void callregisterInvalidUname(String username, String password, String confirmpwd, String message) throws InterruptedException, IOException {
		
		registerPage.registerLinkClick();
		registerPage.enterusername(username);
		registerPage.enterpassword(password);
		registerPage.enterpwdConfirm(confirmpwd);
		registerPage.registerBtnClick();
		String InvalidMsg = registerPage.invalidMsg();
		Assert.assertEquals(InvalidMsg, message);
		LoggerReader.info("Please fill out this field.");

	}
	
	// Fail - Incorrect user name message not displayed
	
	@Test(priority = 5, dataProvider = "registerPwdLessLength", dataProviderClass = DataProviderClass.class)
	public void callregisterPwdLessLength(String username, String password, String confirmpwd, String message) throws InterruptedException, IOException {
		
		registerPage.registerLinkClick();
		registerPage.enterusername(username);
		registerPage.enterpassword(password);
		registerPage.enterpwdConfirm(confirmpwd);
		registerPage.registerBtnClick();
		String InvalidMsg = registerPage.invalidMsg();
		Assert.assertEquals(InvalidMsg, message);
		LoggerReader.info("Please fill out this field.");

	}
	
	// Fail - Incorrect message
	
	@Test(priority = 6, dataProvider = "registerPwdNumeric", dataProviderClass = DataProviderClass.class)
	public void callregisterPwdNumeric(String username, String password, String confirmpwd, String message) throws InterruptedException, IOException {
		
		registerPage.registerLinkClick();
		registerPage.enterusername(username);
		registerPage.enterpassword(password);
		registerPage.enterpwdConfirm(confirmpwd);
		registerPage.registerBtnClick();
		String InvalidMsg = registerPage.invalidMsg();
		Assert.assertEquals(InvalidMsg, message);
		LoggerReader.info("Please fill out this field.");

	} //Fail - Incorrect Message

	@Test(priority = 7, dataProvider = "registerCommonPwd", dataProviderClass = DataProviderClass.class)
	public void callregisterCommonPwd(String username, String password, String confirmpwd, String message) throws InterruptedException, IOException {
		
		registerPage.registerLinkClick();
		registerPage.enterusername(username);
		registerPage.enterpassword(password);
		registerPage.enterpwdConfirm(confirmpwd);
		registerPage.registerBtnClick();
		String InvalidMsg = registerPage.invalidMsg();
		Assert.assertEquals(InvalidMsg, message);
		LoggerReader.info("Please fill out this field.");

	} //Fail -Incorrect message displayed
	
	/*@Test(priority = 8, dataProvider = "registerValidData", dataProviderClass = DataProviderClass.class)
	public void callregisterValidData(String username, String password, String confirmpwd, String message) throws InterruptedException, IOException {
		
		registerPage.registerLinkClick();
		registerPage.enterusername(username);
		registerPage.enterpassword(password);
		registerPage.enterpwdConfirm(confirmpwd);
		registerPage.registerBtnClick();
		String InvalidMsg = registerPage.invalidMsg();
		Assert.assertEquals(InvalidMsg, message);
		LoggerReader.info("Please fill out this field.");

	}*/ //  This is code for valid login
	
	
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
