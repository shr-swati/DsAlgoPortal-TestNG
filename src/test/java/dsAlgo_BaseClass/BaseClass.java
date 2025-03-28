package dsAlgo_BaseClass;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.ExcelReader;
import dsAlgo_Utilities.ListenersReporter;

import dsAlgo_Utilities.LoggerReader;
import com.aventstack.chaintest.plugins.ChainTestListener;


public class BaseClass {

	public WebDriver driver;
	Home_PageFactory homePage;
	Login_PageFactory loginPage;

	@BeforeMethod
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) {
		DriverFactory driverFactory = new DriverFactory();
		driverFactory.setUp(browser);
		driver = DriverFactory.getDriver();
		ChainTestListener.log("Browser factory setup");
	}

	@DataProvider(name = "validLoginDataBaseClass")
	public static Object[][] validLoginDataBaseClass() throws IOException {
		String sheetName = "Login_Valid";
		int rowCount = 1;
		Object[][] userData = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			userData[i] = ExcelReader.excelDataRead(sheetName, i + 1);
		}
		return userData;
	}

	@Test(dataProvider = "validLoginDataBaseClass")
	public void validLoginDataBase(String username, String password) {
		homePage = new Home_PageFactory();
		loginPage = new Login_PageFactory();

		homePage.launchUrl();
		homePage.getStartedHomeBtnClick();
		loginPage.signInClick();
		loginPage.userNameLoginBtn.sendKeys(username);
		loginPage.passwordLoginBtn.sendKeys(password);
		loginPage.LoginBtnClick();

	}

	@DataProvider(name = "pythoncode_tryeditor")
	public Object[][] getData() {
		return new Object[][] { { "TryEditor", 1 }, { "TryEditor", 2 }, { "TryEditor", 3 } };
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
