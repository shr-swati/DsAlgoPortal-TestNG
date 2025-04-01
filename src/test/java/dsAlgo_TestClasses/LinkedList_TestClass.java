package dsAlgo_TestClasses;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.LinkedList_Page;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_Utilities.DataProviderClass;
import dsAlgo_Utilities.ExcelReader;
import dsAlgo_Utilities.LoggerReader;
import dsAlgo_Utilities.TryEditor;

public class LinkedList_TestClass {
	WebDriver driver;
	Home_PageFactory homePage;
	LinkedList_Page linkedListPage;
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
		linkedListPage = new LinkedList_Page();

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
		linkedListPage.goToLinkedListPage();
		String pageTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals(pageTitle, "Linked List");
		LoggerReader.info("validateGetStarted Completed");
	}

	@Test(priority = 2)
	public void validateIntroductionLinkClick() {
		linkedListPage.clickIntroductionLink();
		String introductionPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals(introductionPgTitle, "Introduction");
		LoggerReader.info("validateIntroductionLinkClick Completed");

	}

	@Test(priority = 3, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForValidInputViaIntroduction(String input, String expectedOutput) {
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 4, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaIntroduction(String input, String expectedOutput)
			throws InterruptedException {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 5, dataProvider = "blankRow", dataProviderClass = DataProviderClass.class)
	public void blankRowViaIntroduction(String input, String expectedOutput) {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 6, dataProvider = "numericCode", dataProviderClass = DataProviderClass.class)
	public void numericCodeViaIntroduction(String input, String expectedOutput) {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 7)
	public void validateCreatingLinkedLIstClick() {
		driver.navigate().back();
		linkedListPage.clickCreatingLinkedLIst();
		String creatingLinkedListPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Creating Linked LIst", creatingLinkedListPgTitle);
		LoggerReader.info("validateCreatingLinkedLIstClick Completed");

	}

	@Test(priority = 8, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForValidInputViaCreatingLinkedList(String input, String expectedOutput) {
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 9, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaCreatingLinkedList(String input, String expectedOutput)
			throws InterruptedException {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 10, dataProvider = "blankRow", dataProviderClass = DataProviderClass.class)
	public void blankRowViaCreatingLinkedList(String input, String expectedOutput) {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 11, dataProvider = "numericCode", dataProviderClass = DataProviderClass.class)
	public void numericCodeViaCreatingLinkedList(String input, String expectedOutput) {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 12)
	public void validateTypesOfLinkedListClick() {
		driver.navigate().back();
		linkedListPage.clickTypesOfLinkedList();
		String typesOfLinkedListPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Types of Linked List", typesOfLinkedListPgTitle);
		LoggerReader.info("validateTypesOfLinkedListClick Completed");

	}

	@Test(priority = 13, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForValidInputViaTypesOfLinkedList(String input, String expectedOutput) {
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 14, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaTypesOfLinkedList(String input, String expectedOutput)
			throws InterruptedException {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 15, dataProvider = "blankRow", dataProviderClass = DataProviderClass.class)
	public void blankRowViaTypesOfLinkedList(String input, String expectedOutput) {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 16, dataProvider = "numericCode", dataProviderClass = DataProviderClass.class)
	public void numericCodeViaTypesOfLinkedList(String input, String expectedOutput) {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 17)
	public void validateImplementLinkedListInPythonClick() {
		driver.navigate().back();
		linkedListPage.clickImplementLinkedListInPython();
		String implementLinkedListInPythonPage = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Implement Linked List in Python", implementLinkedListInPythonPage);
		LoggerReader.info("validateImplementLinkedListInPythonClick Completed");

	}

	@Test(priority = 18, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForImplementLinkedListInPython(String input, String expectedOutput) {
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 19, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaImplementLinkedListInPython(String input, String expectedOutput)
			throws InterruptedException {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 20, dataProvider = "blankRow", dataProviderClass = DataProviderClass.class)
	public void blankRowViaImplementLinkedListInPython(String input, String expectedOutput) {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 21, dataProvider = "numericCode", dataProviderClass = DataProviderClass.class)
	public void numericCodeViaImplementLinkedListInPython(String input, String expectedOutput) {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 22)
	public void validateTraversalClick() {
		driver.navigate().back();
		linkedListPage.clickTraversal();
		String traversalPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Traversal", traversalPgTitle);
		LoggerReader.info("validateTraversalClick Completed");

	}

	@Test(priority = 23, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForTraversal(String input, String expectedOutput) {
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 24, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaTraversal(String input, String expectedOutput)
			throws InterruptedException {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 25, dataProvider = "blankRow", dataProviderClass = DataProviderClass.class)
	public void blankRowViaTraversal(String input, String expectedOutput) {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 26, dataProvider = "numericCode", dataProviderClass = DataProviderClass.class)
	public void numericCodeViaTraversal(String input, String expectedOutput) {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 27)
	public void validateInsertionClick() {
		driver.navigate().back();
		linkedListPage.clickInsertion();
		String insertionPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Insertion", insertionPgTitle);
		LoggerReader.info("validateInsertionClick Completed");

	}

	@Test(priority = 28, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForInsertion(String input, String expectedOutput) {
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 29, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaInsertion(String input, String expectedOutput)
			throws InterruptedException {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 30, dataProvider = "blankRow", dataProviderClass = DataProviderClass.class)
	public void blankRowViaInsertion(String input, String expectedOutput) {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 31, dataProvider = "numericCode", dataProviderClass = DataProviderClass.class)
	public void numericCodeViaInsertion(String input, String expectedOutput) {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 32)
	public void validateDeletionClick() {
		driver.navigate().back();
		linkedListPage.clickDeletion();
		String deletionPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Deletion", deletionPgTitle);
		LoggerReader.info("validateDeletionClick Completed");

	}

	@Test(priority = 33, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForDeletion(String input, String expectedOutput) {
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 34, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaDeletion(String input, String expectedOutput)
			throws InterruptedException {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 35, dataProvider = "blankRow", dataProviderClass = DataProviderClass.class)
	public void blankRowViaDeletion(String input, String expectedOutput) {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 36, dataProvider = "numericCode", dataProviderClass = DataProviderClass.class)
	public void numericCodeViaDeletion(String input, String expectedOutput) {
		driver.navigate().back();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 37)
	public void validatePracticeQuestionsClick() {
		driver.navigate().back();
		linkedListPage.clickPracticeQuestions();
		String practiceQuestionsPage = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Practice Questions", practiceQuestionsPage);
		LoggerReader.info("validatePracticeQuestionsClick Completed");
	}

	@Test(priority = 38)
	public void logOut() {
		linkedListPage.clickSignOut();
		String loggedOutMsg = loginPage.loggedOutMessage.getText();
		Assert.assertEquals(loggedOutMsg, "Logged out successfully");
		LoggerReader.info("User logs out");
	}

}
