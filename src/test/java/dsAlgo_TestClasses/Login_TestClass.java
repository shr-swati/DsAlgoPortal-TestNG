package dsAlgo_TestClasses;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
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
	private String username;
	private String password;
	WebDriver driver;
	String pagetitle;
	
	@BeforeMethod
	public void initPageObjects() {
		homePage = new Home_PageFactory();
		loginPage = new Login_PageFactory();
		homePage.launchUrl();
		homePage.getStartedHomeBtnClick();

	}

	public Login_TestClass(String username, String password) throws IOException {
		this.username = username;
		this.password = password;

	}

	@Factory(dataProvider = "validLoginData", dataProviderClass = DataProviderClass.class)

	public static Object[] loginData(String username, String password) throws IOException {

		return new Object[] { new Login_TestClass(username, password) };

	}
	@Test(priority=1)
	public void toLoginpage() throws IOException {
		loginPage = new Login_PageFactory();
		loginPage.signInLoginBtnClick();
		
	}
	
	@Test(priority = 2)
	public void callvalidLogin() throws InterruptedException, IOException {

		toLoginpage();
		loginPage.enterusername(username);
		loginPage.enterpassword(password);
		loginPage.LoginBtnClick();
		String loggedInMsg = loginPage.loginMsg();
		Assert.assertEquals(loggedInMsg, "You are logged in");
		LoggerReader.info("User logs in");
		
	}

	@Test(priority = 3)
	public void loginLogOut() throws InterruptedException, IOException {
		callvalidLogin();
		loginPage.signOutBtnClick();
		String loggedOutMsg = loginPage.logoutMsg();
		Assert.assertEquals(loggedOutMsg, "Logged out successfully");
		LoggerReader.info("User logged out");
	}
	@Test(priority = 4)
	public void loginBlankFields() throws InterruptedException, IOException {
		loginPage.signInLoginBtnClick();
		loginPage.LoginBtnClick();
		String actualmessage = loginPage.getPopUpMessage();
		//Assert.assertEquals(actualmessage, message,"message dont match");
		LoggerReader.info("User enter blank credentials");
	}
	
	/*@Test(priority = 5, dataProvider = "invalidLoginData", dataProviderClass = DataProviderClass.class)
		public void callinvalidLogin() throws InterruptedException, IOException {
		toLoginpage();
		loginPage.enterusername(username);
		loginPage.enterpassword(password);
		loginPage.LoginBtnClick(); 
		
		
	}*/
	
	 
		@AfterClass(alwaysRun = true)
		public void teardown() {
			loginPage.closebrowser();
		}
}