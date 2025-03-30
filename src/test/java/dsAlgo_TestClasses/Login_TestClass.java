package dsAlgo_TestClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_Utilities.DataProviderClass;
import dsAlgo_Utilities.LoggerReader;

@Listeners(dsAlgo_Utilities.ListenersReporter.class)

public class Login_TestClass extends BaseClass {

	Home_PageFactory homePage;
	Login_PageFactory loginPage;

	@BeforeMethod
	public void initPageObjects() {
		homePage = new Home_PageFactory();
		loginPage = new Login_PageFactory();
		homePage.launchUrl();
		homePage.getStartedHomeBtnClick();
	}
	
	@Test(priority = 1, dataProvider = "validLoginData", dataProviderClass = DataProviderClass.class)
	public void validLogInData(String username, String password) {
		loginPage.signInClick();
		loginPage.userName.sendKeys(username);
		loginPage.passWord.sendKeys(password);
		loginPage.LoginBtnClick();
		String loggedInMsg = loginPage.loggedInMessage.getText();
		Assert.assertEquals(loggedInMsg, "You are logged in");
		LoggerReader.info("User enter valid login credentials");
	} 

	@Test(priority = 2, dataProvider = "logOutData", dataProviderClass = DataProviderClass.class)
	public void loginLogOut(String username, String password) {
		loginPage.signInClick();
		loginPage.userName.sendKeys(username);
		loginPage.passWord.sendKeys(password);
		loginPage.LoginBtnClick();
		loginPage.signOutBtnClick();
		String loggedOutMsg = loginPage.loggedOutMessage.getText();
		Assert.assertEquals(loggedOutMsg, "Logged out successfully");
		LoggerReader.info("User logs out");
	}
	/*
	@Test(priority = 3, dataProvider = "invalidLoginData", dataProviderClass = DataProviderClass.class)
	public void invalidLogIn(String username, String password, String message) {
		loginPage.signInClick();
	    loginPage.userNameLoginBtn.sendKeys(username);
		loginPage.passwordLoginBtn.sendKeys(password);
		loginPage.LoginBtnClick(); 
		String invalidMsg = loginPage.invalidMessage.getText();
		Assert.assertEquals(invalidMsg, message);
		LoggerReader.info("User enter invalid login credentials");
	}
	
	@Test(priority = 4, dataProvider = "loginBlank", dataProviderClass = DataProviderClass.class)
	public void loginBlankFields(String username, String password, String message) throws InterruptedException {
		loginPage.signInClick();
	    loginPage.userNameLoginBtn.sendKeys(username);
		loginPage.passwordLoginBtn.sendKeys(password);
		loginPage.LoginBtnClick(); 
		String actualmessage = loginPage.getPopUpMessage();
		Assert.assertEquals(actualmessage, message,"message dont match");
		LoggerReader.info("User enter blank credentials");
	}*/

}