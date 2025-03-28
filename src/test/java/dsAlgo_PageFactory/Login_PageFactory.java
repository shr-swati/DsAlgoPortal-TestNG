package dsAlgo_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.TryEditor;

public class Login_PageFactory  {
	
	WebDriver driver= DriverFactory.getDriver();
	ConfigReader configFileReader=DriverFactory.configReader();
	TryEditor readTryEditor = new TryEditor();
	
	@FindBy ( linkText = "Sign in") WebElement signInLoginBtn;
	@FindBy ( xpath = "//input[@id='id_username']") public WebElement userNameLoginBtn;
	@FindBy ( xpath = "//input[@id='id_password']") public WebElement passwordLoginBtn;
	@FindBy ( xpath = "//input[@value='Login']") WebElement LoginBtn;
	@FindBy ( xpath = "//div[contains(text(),'logged in')]") public WebElement loggedInMessage;
	@FindBy ( xpath = "//div[contains(text(),'successfully')]") public WebElement loggedOutMessage;
	@FindBy ( xpath = "//div[contains(text(),'Invalid')]") public WebElement invalidMessage;
	@FindBy ( xpath = "//a[text()='Sign out']") WebElement signOutBtn;
			
	public Login_PageFactory() {
		PageFactory.initElements(driver, this);
	}
	
	public void signInClick() {
		signInLoginBtn.click();
	}
	
	public void LoginBtnClick() {
		LoginBtn.click();
	}
	
	public void signOutBtnClick() {
		signOutBtn.click();
	}
	
	public String getPopUpMessage() {
		WebElement activeElement = driver.switchTo().activeElement();
		String actualMessage = activeElement.getDomProperty("validationMessage").trim();
		return actualMessage;
	}
}