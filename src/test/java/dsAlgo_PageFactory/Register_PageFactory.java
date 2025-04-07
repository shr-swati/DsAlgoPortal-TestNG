package dsAlgo_PageFactory;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import dsAlgo_DriverFactory.DriverFactory;
	import dsAlgo_Utilities.ConfigReader;

	public class Register_PageFactory {

		WebDriver driver = DriverFactory.getDriver();
		ConfigReader configFileReader = DriverFactory.configReader();

		@FindBy(xpath = "//a[normalize-space()='Register']")
		WebElement registerLink;
		@FindBy(id = "id_username")
		public WebElement userNm;
		@FindBy(id = "id_password1")
		public WebElement pwd;
		@FindBy(id = "id_password2")
		public WebElement pwdConfm;
		@FindBy(xpath = "//input[@type='submit']")
		WebElement registerBtn;
		@FindBy(xpath = "//div[contains(text(),'Account Created')]")
		WebElement successMessage;
		@FindBy(xpath = "//div[contains(text(),'password_mismatch')]")
		WebElement invalidMessage;

		public Register_PageFactory() {
			PageFactory.initElements(driver, this);
		}

		public boolean registerLinkDisplayed() {
			return registerLink.isDisplayed();
		}

		public void registerLinkClick() {
			registerLink.click();
		}

		public void registerBtnClick() {
			registerBtn.click();
		}

		public boolean registerBtnDisplayed() {
			return registerBtn.isDisplayed();
		}

		public void enterusername(String username) {
			userNm.sendKeys(username);
		}

		/*public boolean isUsernameEnteredCorrectly() {
			// Example: Check if the username is non-empty and matches a pattern
			return userNameRegisterBtn != null && !((CharSequence) userNameRegisterBtn).isEmpty();
		}*/

		public void enterpassword(String password) {
			pwd.sendKeys(password);;
		}

		/*public boolean isPasswordEnteredCorrectly() {
			// Example: Check if the username is non-empty and matches a pattern
			return passwordRegisterBtn != null && !((CharSequence) passwordRegisterBtn).isEmpty();
		}
       */
		public void enterpwdConfirm(String confirmpwd) {
			pwdConfm.sendKeys(confirmpwd);
		}

		public String invalidMsg() {
			return invalidMessage.getText();
		}
		
		public String getPopUpMessage() {
			WebElement activeElement = driver.switchTo().activeElement();
			String actualMessage = activeElement.getDomProperty("validationMessage").trim();
			return actualMessage;
		}

		public String successMessageDisplayed() {
			String homeSuccessMessage = successMessage.getText();
			return homeSuccessMessage;
		}
		
		public void closebrowser() {
			driver.quit();
		}
	}