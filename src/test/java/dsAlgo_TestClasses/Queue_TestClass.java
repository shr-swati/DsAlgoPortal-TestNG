package dsAlgo_TestClasses;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_PageFactory.Home_PageFactory;

import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_PageFactory.Queue_Page;
import dsAlgo_Utilities.DataProviderClass;
import dsAlgo_Utilities.ExcelReader;
import dsAlgo_Utilities.LoggerReader;

public class Queue_TestClass {

	WebDriver driver;
	Home_PageFactory homePage;
	Queue_Page queuePage;
	Login_PageFactory loginPage;

	@BeforeClass
	@Parameters("browser")
	public void initPageObjects(@Optional("chrome") String browser) throws IOException {
		DriverFactory driverFactory = new DriverFactory();
		driverFactory.setUp(browser);
		driver = DriverFactory.getDriver();
		homePage = new Home_PageFactory();
		loginPage = new Login_PageFactory();
		homePage.launchUrl();
		homePage.getStartedHomeBtnClick();
		login();
		queuePage = new Queue_Page();

	}

	private void login() throws IOException {
		String[] credentials = ExcelReader.excelDataRead("Valid_Login", 1);
		loginPage.signInClick();
		loginPage.userName.sendKeys(credentials[0]);
		loginPage.passWord.sendKeys(credentials[1]);
		loginPage.LoginBtnClick();
	}

	@Test(priority = 1)
	public void validateGetStarted() {
		queuePage.goToQueuePage();
		String pageTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals(pageTitle, "Queue");
		LoggerReader.info("validateGetStarted Completed");
	}

	@Test(priority = 2)
	public void validateImplementationOfQueueInPythonClick() {
		queuePage.clickImplementationOfQueueInPython();
		String implementationOfQueueInPythonPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Implementation of Queue in Python", implementationOfQueueInPythonPgTitle);
		LoggerReader.info("validateImplementationOfQueueInPythonClick Completed");

	}

	@Test(priority = 3, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForValidInputViaImplementationOfQueueInPython(String input,
			String expectedOutput) {
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Assert.assertEquals(queuePage.resultOutput(), expectedOutput);

	}

	@Test(priority = 4, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaImplementationOfQueueInPython(String input,
			String expectedOutput) throws InterruptedException {
		driver.navigate().back();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 5, dataProvider = "blankRow", dataProviderClass = DataProviderClass.class)
	public void blankRowViaImplementationOfQueueInPython(String input, String expectedOutput) {
		driver.navigate().back();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 6, dataProvider = "numericCode", dataProviderClass = DataProviderClass.class)
	public void numericCodeViaImplementationOfQueueInPython(String input, String expectedOutput) {
		driver.navigate().back();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 7)
	public void validateImplementationUsingCollectionsDequeClick() {
		driver.navigate().back();
		queuePage.clickImplementationUsingCollectionsDeque();
		String implementationUsingCollectionsDequePgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Implementation using collections.deque", implementationUsingCollectionsDequePgTitle);
		LoggerReader.info("validateImplementationUsingCollectionsDequeClick Completed");

	}

	@Test(priority = 8, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForValidInputViaImplementationUsingCollectionsDeque(String input,
			String expectedOutput) {
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Assert.assertEquals(queuePage.resultOutput(), expectedOutput);

	}

	@Test(priority = 9, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaImplementationUsingCollectionsDeque(String input,
			String expectedOutput) throws InterruptedException {
		driver.navigate().back();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 10, dataProvider = "blankRow", dataProviderClass = DataProviderClass.class)
	public void blankRowViaImplementationUsingCollectionsDeque(String input, String expectedOutput) {
		driver.navigate().back();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 11, dataProvider = "numericCode", dataProviderClass = DataProviderClass.class)
	public void numericCodeViaImplementationUsingCollectionsDeque(String input, String expectedOutput) {
		driver.navigate().back();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 12)
	public void validateImplementationUsingArrayClick() {
		driver.navigate().back();
		queuePage.clickImplementationUsingArray();
		String implementationUsingArrayPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Implementation using array", implementationUsingArrayPgTitle);
		LoggerReader.info("validateImplementationUsingArrayClick Completed");

	}

	@Test(priority = 13, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForImplementationUsingArray(String input, String expectedOutput) {
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Assert.assertEquals(queuePage.resultOutput(), expectedOutput);

	}

	@Test(priority = 14, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaImplementationUsingArray(String input, String expectedOutput)
			throws InterruptedException {
		driver.navigate().back();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 15, dataProvider = "blankRow", dataProviderClass = DataProviderClass.class)
	public void blankRowViaImplementationUsingArray(String input, String expectedOutput) {
		driver.navigate().back();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 16, dataProvider = "numericCode", dataProviderClass = DataProviderClass.class)
	public void numericCodeViaImplementationUsingArray(String input, String expectedOutput) {
		driver.navigate().back();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 17)
	public void validateQueueOperationsClick() {
		driver.navigate().back();
		queuePage.clickQueueOperations();
		String queueOperationsPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Queue Operations", queueOperationsPgTitle);
		LoggerReader.info("validateQueueOperationsClick Completed");

	}

	@Test(priority = 18, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForQueueOperations(String input, String expectedOutput) {
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Assert.assertEquals(queuePage.resultOutput(), expectedOutput);

	}

	@Test(priority = 19, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaQueueOperations(String input, String expectedOutput)
			throws InterruptedException {
		driver.navigate().back();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 20, dataProvider = "blankRow", dataProviderClass = DataProviderClass.class)
	public void blankRowViaQueueOperations(String input, String expectedOutput) {
		driver.navigate().back();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 21, dataProvider = "numericCode", dataProviderClass = DataProviderClass.class)
	public void numericCodeViaQueueOperations(String input, String expectedOutput) {
		driver.navigate().back();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 22)
	public void validatePracticeQuestionsClick() {
		driver.navigate().back();
		queuePage.clickPracticeQuestions();
		String practiceQuestionsPage = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Practice Questions", practiceQuestionsPage);
		LoggerReader.info("validatePracticeQuestionsClick Completed");
	}

	@Test(priority = 23)
	public void logOut() {
		queuePage.clickSignOut();
		String loggedOutMsg = loginPage.loggedOutMessage.getText();
		Assert.assertEquals(loggedOutMsg, "Logged out successfully");
		LoggerReader.info("User logs out");
	}

}
