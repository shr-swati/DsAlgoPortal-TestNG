package dsAlgo_TestClasses;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.LinkedList_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_Utilities.DataProviderClass;
import dsAlgo_Utilities.ExcelReader;
import dsAlgo_Utilities.LoggerReader;
import dsAlgo_Utilities.TryEditor;

public class LinkedList_TestClass extends BaseClass {
	private String username;
	private String password;
	private String input;
	private String expectedOutput;
	
	
	Home_PageFactory homePage;
	LinkedList_PageFactory linkedListPage;
	Login_PageFactory loginPage;

	@BeforeMethod
	
	public void initPageObjects()  {
		
		homePage = new Home_PageFactory();
		loginPage = new Login_PageFactory();
		homePage.launchUrl();
		homePage.getStartedHomeBtnClick();
		

	}

	public  LinkedList_TestClass(String username, String password) {
		
		this.username = username;
		this.password = password;
		
	}

	 @Factory(dataProvider = "validLoginData", dataProviderClass = DataProviderClass.class)

		public static Object[] loginData(String username, String password) throws IOException {

	        return new Object[] { new LinkedList_TestClass(username, password) };

	    }

		

		@Test(priority=1)

		public void callValidLog() throws InterruptedException, IOException {

					   
            loginData( username, password);
            loginPage.signInLoginBtnClick();
            loginPage.userName.sendKeys(username);
            loginPage.passWord.sendKeys(password);
            loginPage.LoginBtnClick();
            linkedListPage = new LinkedList_PageFactory();
            linkedListPage.clickGetStartedButton();
            linkedListPage = new LinkedList_PageFactory();

		}
		@Test(priority=2)
		public void goToLinkedListPage() throws InterruptedException, IOException {
			
		callValidLog();
		LoggerReader.info("user is navigate to linked list page after clicking get started button");
		
		}
		//Introduction
	@Test(priority = 3)
	public void validateIntroductionLinkClick() throws InterruptedException, IOException {
		callValidLog();
		linkedListPage.clickIntroductionLink();
		String introductionPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals( "Introduction", introductionPgTitle);
		LoggerReader.info("user is redirected to Introduction Page");

	}

	@Test(priority = 4, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForValidInputViaIntroduction(String input, String expectedOutput) throws InterruptedException, IOException {
		callValidLog();
		linkedListPage.clickIntroductionLink();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);
		LoggerReader.info("user enters and click run button for valid python code");

	}

	@Test(priority = 5, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaIntroduction(String input, String expectedOutput)
			throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickIntroductionLink();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = DriverFactory.getDriver().switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}
	@Test(priority = 6)
	public void testnocodeIntroduction() throws InterruptedException, IOException {
		callValidLog();
		linkedListPage.clickIntroductionLink();
		linkedListPage.tryHereButton();
		linkedListPage.runButtonClick();

	}
	
	//Creating Linked List
	@Test(priority = 7)
	public void validateCreatingLinkedLIstClick() throws InterruptedException, IOException {
		callValidLog();
		linkedListPage.clickCreatingLinkedLIst();
		String creatingLinkedListPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Creating Linked LIst", creatingLinkedListPgTitle);
		LoggerReader.info("user is redirected to Creating Linked List Page");

	}

	@Test(priority = 8, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForValidInputViaCreatingLinkedList(String input, String expectedOutput) throws InterruptedException, IOException {
		callValidLog();
		linkedListPage.clickCreatingLinkedLIst();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 9, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaCreatingLinkedList(String input, String expectedOutput)
			throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickCreatingLinkedLIst();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = DriverFactory.getDriver().switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 10)
	public void testnocodeCreatingLinkedList() throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickCreatingLinkedLIst();
		linkedListPage.tryHereButton();
		linkedListPage.runButtonClick();

	}
	
	
	
	//Types Of Linked List
	@Test(priority = 11)
	public void validateTypesOfLinkedListClick() throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickTypesOfLinkedList();
		String typesOfLinkedListPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Types of Linked List", typesOfLinkedListPgTitle);
		LoggerReader.info("user is redirected to TypesOfLinkedList ");

	}

	@Test(priority = 12, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForValidInputViaTypesOfLinkedList(String input, String expectedOutput) throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickTypesOfLinkedList();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 13, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaTypesOfLinkedList(String input, String expectedOutput)
			throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickTypesOfLinkedList();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = DriverFactory.getDriver().switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}
@Test(priority = 14)
	public void testnocodeTypesOfLinkedList() throws InterruptedException, IOException {
		callValidLog();
		linkedListPage.clickTypesOfLinkedList();
		linkedListPage.tryHereButton();
		linkedListPage.runButtonClick();
	
}
//ImpLinkedList
	@Test(priority = 15)
	public void validateImplementLinkedListInPythonClick() throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickImplementLinkedListInPython();
		String implementLinkedListInPythonPage = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Implement Linked List in Python", implementLinkedListInPythonPage);
		LoggerReader.info("user is redirected to ImplementLinkedListInPython");

	}

	@Test(priority = 16, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForImplementLinkedListInPython(String input, String expectedOutput) throws InterruptedException, IOException {
		callValidLog();
		linkedListPage.clickImplementLinkedListInPython();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 17, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaImplementLinkedListInPython(String input, String expectedOutput)
			throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickImplementLinkedListInPython();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = DriverFactory.getDriver().switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}

	@Test(priority = 18)
	public void testnocodeImplementLinkedListInPython() throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickImplementLinkedListInPython();
		linkedListPage.tryHereButton();
		linkedListPage.runButtonClick();
	}
	
//Traversal
	@Test(priority = 19)
	public void validateTraversalClick() throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickTraversal();
		String traversalPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Traversal", traversalPgTitle);
		LoggerReader.info("user is redirected to Traversal Page");

	}

	@Test(priority = 20, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForTraversal(String input, String expectedOutput) throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickTraversal();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 21, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaTraversal(String input, String expectedOutput)
			throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickTraversal();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = DriverFactory.getDriver().switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}
	@Test(priority = 22)
	
	public void testnocodeTraversal1() throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickTraversal();
		linkedListPage.tryHereButton();
		linkedListPage.runButtonClick();
	
	
	
	}
//Insertion
	@Test(priority = 23)
	public void validateInsertionClick() throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickInsertion();
		String insertionPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Insertion", insertionPgTitle);
		LoggerReader.info("validateInsertionClick Completed");

	}

	@Test(priority = 24, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForInsertion(String input, String expectedOutput) throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickInsertion();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 25, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaInsertion(String input, String expectedOutput)
			throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickInsertion();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = DriverFactory.getDriver().switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}
	@Test(priority = 26)
	public void testnocodeInsertion() throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickInsertion();
		linkedListPage.tryHereButton();
		linkedListPage.runButtonClick();
	
	}
	
	
//Deletion
	@Test(priority = 27)
	public void validateDeletionClick() throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickDeletion();
		String deletionPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Deletion", deletionPgTitle);
		LoggerReader.info("user is redirected to Deletion Page");

	}

	@Test(priority = 28, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForDeletion(String input, String expectedOutput) throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickDeletion();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Assert.assertEquals(linkedListPage.resultOutput(), expectedOutput);

	}

	@Test(priority = 29, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaDeletion(String input, String expectedOutput)
			throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickDeletion();
		linkedListPage.tryHereButton();
		linkedListPage.textAreaSendKey(input);
		linkedListPage.runButtonClick();
		Alert alert_box = DriverFactory.getDriver().switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
	}
	@Test(priority = 30)
	public void testnocodeDeletion() throws InterruptedException, IOException {
		
		callValidLog();
		linkedListPage.clickDeletion();
		linkedListPage.tryHereButton();
		linkedListPage.runButtonClick();
	
	}
	
	
	@Test(priority = 31)
	public void validatePracticeQuestionsClick() throws InterruptedException, IOException {
		callValidLog();
		linkedListPage.clickIntroductionLink();
		linkedListPage.clickPracticeQuestions();
		String practiceQuestionsPage = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Practice Questions", practiceQuestionsPage);
		LoggerReader.info("validatePracticeQuestionsClick Completed");
	}

	@Test(priority = 32)
	@AfterClass(alwaysRun = true)
	public void teardown() {
		linkedListPage.closebrowser();
	}

}
