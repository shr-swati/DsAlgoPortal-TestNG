package dsAlgo_TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.DataProviderClass;
import dsAlgo_Utilities.LoggerReader;

@Listeners(dsAlgo_Utilities.ListenersReporter.class)

public class Login_TestClass extends BaseClass {

	public ConfigReader config = new ConfigReader();
	Home_PageFactory homePage;
	Login_PageFactory loginPage;
	WebDriver driver;
	String pagetitle;

	@BeforeMethod
	public void initPageObjects() {
		homePage = new Home_PageFactory();
		loginPage = new Login_PageFactory();
		homePage.launchUrl();
		homePage.getStartedHomeBtnClick();

	}

	@Test(priority = 1, dataProvider = "validLoginData", dataProviderClass = DataProviderClass.class)
	public void callvalidLogin(String username, String password) throws InterruptedException, IOException {

		loginPage.signInLoginBtnClick();
		loginPage.enterusername(username);
		loginPage.enterpassword(password);
		loginPage.LoginBtnClick();
		String loggedInMsg = loginPage.loginMsg();
		Assert.assertEquals(loggedInMsg, "You are logged in");
		LoggerReader.info("User logs in");

	}

	@Test(priority = 2, dataProvider = "validLoginData", dataProviderClass = DataProviderClass.class)
	public void loginLogOut(String username, String password) throws InterruptedException, IOException {

		loginPage.signInLoginBtnClick();
		loginPage.enterusername(username);
		loginPage.enterpassword(password);
		loginPage.LoginBtnClick();
		loginPage.signOutBtnClick();
		String loggedOutMsg = loginPage.logoutMsg();
		Assert.assertEquals(loggedOutMsg, "Logged out successfully");
		LoggerReader.info("User logged out");
	}

	@Test(priority = 3)
	public void loginBlankFields() throws InterruptedException, IOException {

		loginPage.signInLoginBtnClick();
		loginPage.LoginBtnClick();
		String actualmessage = loginPage.getPopUpMessage();
		Assert.assertEquals(actualmessage, "Please fill out this field.");
		LoggerReader.info("User gets a pop-up to fill blank feilds");
	}

	@Test(priority = 4, dataProvider = "invalidLoginDataBothFeilds", dataProviderClass = DataProviderClass.class)
	public void invalidLoginbothfeilds(String username, String password, String message)
			throws InterruptedException, IOException {

		loginPage.signInLoginBtnClick();
		loginPage.signInLoginBtnClick();
		loginPage.enterusername(username);
		loginPage.enterpassword(password);
		loginPage.LoginBtnClick();
		String invalidMsg = loginPage.invalidMsg.getText();
		Assert.assertEquals(invalidMsg, message);
		LoggerReader.info("User enter invalid login credentials");
	}

	@Test(priority = 5, dataProvider = "invalidLoginDataBlankFeild", dataProviderClass = DataProviderClass.class)
	public void invalidLoginblank(String username, String password, String message)
			throws InterruptedException, IOException {

		loginPage.signInLoginBtnClick();
		loginPage.signInLoginBtnClick();
		loginPage.enterusername(username);
		loginPage.enterpassword(password);
		loginPage.LoginBtnClick();
		String invalidMsg = loginPage.getPopUpMessage();
		;
		Assert.assertEquals(invalidMsg, message);
		LoggerReader.info("User leaves a feild blank");
	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		loginPage.closebrowser();
	}
}
