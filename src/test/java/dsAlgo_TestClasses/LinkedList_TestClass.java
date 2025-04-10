package dsAlgo_TestClasses;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.LinkedList_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_Utilities.DataProviderClass;

import dsAlgo_Utilities.LoggerReader;

public class LinkedList_TestClass extends BaseClass {
	private String username;
	private String password;

	Home_PageFactory homePage;
	LinkedList_PageFactory linkedListPage;
	Login_PageFactory loginPage;

	@BeforeMethod

	public void initPageObjects() {

		homePage = new Home_PageFactory();
		loginPage = new Login_PageFactory();
		homePage.launchUrl();
		homePage.getStartedHomeBtnClick();
		linkedListPage = new LinkedList_PageFactory();
		loginPage.signInLoginBtnClick();
		loginPage.userName.sendKeys(username);
		loginPage.passWord.sendKeys(password);
		loginPage.LoginBtnClick();
	}

	public LinkedList_TestClass(String username, String password) {

		this.username = username;
		this.password = password;

	}

	@Factory(dataProvider = "validLoginData", dataProviderClass = DataProviderClass.class)

	public static Object[] loginData(String username, String password) throws IOException {

		return new Object[] { new LinkedList_TestClass(username, password) };

	}

	@Test(priority = 1)
	public void goToLinkedListPage() throws InterruptedException, IOException {
		linkedListPage.clickGetStartedButton();

		LoggerReader.info("user is navigate to linked list page after clicking get started button");

	}
	
	// Introduction
	@Test(priority = 2)
	public void validateIntroductionLinkClick() throws InterruptedException, IOException {
		linkedListPage.clickGetStartedButton();
		linkedListPage.clickIntroductionLink();
		String introductionPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Introduction", introductionPgTitle);
		LoggerReader.info("user is redirected to Introduction Page");

	}

	@Test(priority = 3, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForValidInputViaIntroduction(String input, String expectedOutput)
			throws InterruptedException, IOException {
		linkedListPage.clickGetStartedButton();
		linkedListPage.clickIntroductionLink();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);
		LoggerReader.info("user enters and click run button for valid python code");

	}

	@Test(priority = 4, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaIntroduction(String input, String expectedOutput)
			throws InterruptedException, IOException {
		linkedListPage.clickGetStartedButton();
		linkedListPage.clickIntroductionLink();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = DriverFactory.getDriver().switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 5)
	public void testnocodeIntroduction() throws InterruptedException, IOException {
		linkedListPage.clickGetStartedButton();
		linkedListPage.clickIntroductionLink();
		linkedListPage.tryHereButton();
		linkedListPage.runButtonClick();

	}

	// Creating Linked List
	@Test(priority = 6)
	public void validateCreatingLinkedLIstClick() throws InterruptedException, IOException {
		linkedListPage.clickGetStartedButton();
		linkedListPage.clickCreatingLinkedLIst();
		String creatingLinkedListPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Creating Linked LIst", creatingLinkedListPgTitle);
		LoggerReader.info("user is redirected to Creating Linked List Page");

	}

	@Test(priority = 7, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForValidInputViaCreatingLinkedList(String input, String expectedOutput)
			throws InterruptedException, IOException {
		linkedListPage.clickGetStartedButton();
		linkedListPage.clickCreatingLinkedLIst();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 8, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaCreatingLinkedList(String input, String expectedOutput)
			throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickCreatingLinkedLIst();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = DriverFactory.getDriver().switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 9)
	public void testnocodeCreatingLinkedList() throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickCreatingLinkedLIst();
		linkedListPage.tryHereButton();
		linkedListPage.runButtonClick();

	}

	// Types Of Linked List
	@Test(priority = 10)
	public void validateTypesOfLinkedListClick() throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickTypesOfLinkedList();
		String typesOfLinkedListPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Types of Linked List", typesOfLinkedListPgTitle);
		LoggerReader.info("user is redirected to TypesOfLinkedList ");

	}

	@Test(priority = 11, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForValidInputViaTypesOfLinkedList(String input, String expectedOutput)
			throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickTypesOfLinkedList();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 12, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaTypesOfLinkedList(String input, String expectedOutput)
			throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickTypesOfLinkedList();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = DriverFactory.getDriver().switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 13)
	public void testnocodeTypesOfLinkedList() throws InterruptedException, IOException {
		linkedListPage.clickGetStartedButton();
		linkedListPage.clickTypesOfLinkedList();
		linkedListPage.tryHereButton();
		linkedListPage.runButtonClick();

	}

    //ImpLinkedList
	@Test(priority = 14)
	public void validateImplementLinkedListInPythonClick() throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickImplementLinkedListInPython();
		String implementLinkedListInPythonPage = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Implement Linked List in Python", implementLinkedListInPythonPage);
		LoggerReader.info("user is redirected to ImplementLinkedListInPython");

	}

	@Test(priority = 15, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForImplementLinkedListInPython(String input, String expectedOutput)
			throws InterruptedException, IOException {
		linkedListPage.clickGetStartedButton();
		linkedListPage.clickImplementLinkedListInPython();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 16, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaImplementLinkedListInPython(String input, String expectedOutput)
			throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickImplementLinkedListInPython();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = DriverFactory.getDriver().switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 17)
	public void testnocodeImplementLinkedListInPython() throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickImplementLinkedListInPython();
		linkedListPage.tryHereButton();
		linkedListPage.runButtonClick();
	}

    //Traversal
	@Test(priority = 18)
	public void validateTraversalClick() throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickTraversal();
		String traversalPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Traversal", traversalPgTitle);
		LoggerReader.info("user is redirected to Traversal Page");

	}

	@Test(priority = 19, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForTraversal(String input, String expectedOutput)
			throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickTraversal();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 20, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaTraversal(String input, String expectedOutput)
			throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickTraversal();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = DriverFactory.getDriver().switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 21)

	public void testnocodeTraversal1() throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickTraversal();
		linkedListPage.tryHereButton();
		linkedListPage.runButtonClick();
	}

    //Insertion
	@Test(priority = 22)
	public void validateInsertionClick() throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickInsertion();
		String insertionPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Insertion", insertionPgTitle);
		LoggerReader.info("validateInsertionClick Completed");

	}

	@Test(priority = 23, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForInsertion(String input, String expectedOutput)
			throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickInsertion();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 24, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaInsertion(String input, String expectedOutput)
			throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickInsertion();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = DriverFactory.getDriver().switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 25)
	public void testnocodeInsertion() throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickInsertion();
		linkedListPage.tryHereButton();
		linkedListPage.runButtonClick();

	}

    //Deletion
	@Test(priority = 26)
	public void validateDeletionClick() throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickDeletion();
		String deletionPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Deletion", deletionPgTitle);
		LoggerReader.info("user is redirected to Deletion Page");

	}

	@Test(priority = 27, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForDeletion(String input, String expectedOutput)
			throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickDeletion();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 28, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaDeletion(String input, String expectedOutput)
			throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickDeletion();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = DriverFactory.getDriver().switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 29)
	public void testnocodeDeletion() throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickDeletion();
		linkedListPage.tryHereButton();
		linkedListPage.runButtonClick();
	}

	@Test(priority = 30)
	public void validatePracticeQuestionsClick() throws InterruptedException, IOException {
		linkedListPage.clickGetStartedButton();
		linkedListPage.clickIntroductionLink();
		linkedListPage.clickPracticeQuestions();
		String practiceQuestionsPage = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Practice Questions", practiceQuestionsPage);
		LoggerReader.info("validatePracticeQuestionsClick Completed");
	}

	@Test(priority = 31)
	public void visibleContentOfPracticeQuestionsLink() throws InterruptedException, IOException {

		linkedListPage.clickGetStartedButton();
		linkedListPage.clickIntroductionLink();
		linkedListPage.clickPracticeQuestions();
		linkedListPage.clickVisibleQuestions();
	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		linkedListPage.closebrowser();
	}

}
