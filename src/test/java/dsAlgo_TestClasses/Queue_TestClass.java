package dsAlgo_TestClasses;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_PageFactory.Home_PageFactory;

import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_PageFactory.Queue_Page;
import dsAlgo_Utilities.DataProviderClass;
import dsAlgo_Utilities.ExcelReader;
import dsAlgo_Utilities.LoggerReader;

public class Queue_TestClass extends BaseClass {
	private String username;
	private String password;
	private String input;
	private String expectedOutput;
	
	Home_PageFactory homePage;
	Queue_Page queuePage;
	Login_PageFactory loginPage;

	@BeforeMethod
	
	public void initPageObjects()  {
	
		homePage = new Home_PageFactory();
		loginPage = new Login_PageFactory();
		homePage.launchUrl();
		homePage.getStartedHomeBtnClick();
		

	}
public  Queue_TestClass(String username, String password) {
		
		this.username = username;
		this.password = password;
		
	}

	 @Factory(dataProvider = "validLoginData", dataProviderClass = DataProviderClass.class)

		public static Object[] loginData(String username, String password) throws IOException {

	        return new Object[] { new Queue_TestClass(username, password) };

	    }

		

		@Test(priority=1)

		public void callValidLog() throws InterruptedException, IOException {

					   
            loginData( username, password);
            loginPage.signInLoginBtnClick();
            loginPage.userName.sendKeys(username);
            loginPage.passWord.sendKeys(password);
            loginPage.LoginBtnClick();
            queuePage = new Queue_Page();
            queuePage.clickGetStartedButton();
           

		}
		@Test(priority=2)
		public void goToQueuePage() throws InterruptedException, IOException {
			
		callValidLog();
		LoggerReader.info("user is navigate to queue page after clicking get started button");
		
		}
	

	
	
	@Test(priority = 3)
	public void validateImplementationOfQueueInPythonClick() throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickImplementationOfQueueInPython();
		String implementationOfQueueInPythonPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Implementation of Queue in Python", implementationOfQueueInPythonPgTitle);
		LoggerReader.info("validateImplementationOfQueueInPythonClick Completed");

	}

	@Test(priority = 4, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForValidInputViaImplementationOfQueueInPython(String input,
			String expectedOutput) throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickImplementationOfQueueInPython();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Assert.assertEquals(queuePage.resultOutput(), expectedOutput);

	}

	@Test(priority = 5, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaImplementationOfQueueInPython(String input,
			String expectedOutput) throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickImplementationOfQueueInPython();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 6)
	public void testnocodeImplementationOfQueueInPython() throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickImplementationOfQueueInPython();
		queuePage.tryHereBtn();
		queuePage.runButtonClick();

	}

	@Test(priority = 7)
	public void validateImplementationUsingCollectionsDequeClick() throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickImplementationUsingCollectionsDeque();
		String implementationUsingCollectionsDequePgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Implementation using collections.deque", implementationUsingCollectionsDequePgTitle);
		LoggerReader.info("validateImplementationUsingCollectionsDequeClick Completed");

	}

	@Test(priority = 8, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForValidInputViaImplementationUsingCollectionsDeque(String input,
			String expectedOutput) throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickImplementationUsingCollectionsDeque();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Assert.assertEquals(queuePage.resultOutput(), expectedOutput);

	}

	@Test(priority = 9, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaImplementationUsingCollectionsDeque(String input,
			String expectedOutput) throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickImplementationUsingCollectionsDeque();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}
	@Test(priority = 10)
public void testnocodeImplementationUsingCollectionsDeque() throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickImplementationUsingCollectionsDeque();
		queuePage.tryHereBtn();
		queuePage.runButtonClick();

	}

	@Test(priority = 11)
	public void validateImplementationUsingArrayClick() throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickImplementationUsingArray();
		String implementationUsingArrayPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Implementation using array", implementationUsingArrayPgTitle);
		LoggerReader.info("validateImplementationUsingArrayClick Completed");

	}

	@Test(priority = 12, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForImplementationUsingArray(String input, String expectedOutput) throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickImplementationUsingArray();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Assert.assertEquals(queuePage.resultOutput(), expectedOutput);

	}

	@Test(priority = 13, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaImplementationUsingArray(String input, String expectedOutput)
			throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickImplementationUsingArray();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}

	@Test(priority = 14)
public void testnocodeImplementationUsingArray() throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickImplementationUsingArray();
		queuePage.tryHereBtn();
		queuePage.runButtonClick();
}

	@Test(priority = 15)
	public void validateQueueOperationsClick() throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickQueueOperations();
		String queueOperationsPgTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Queue Operations", queueOperationsPgTitle);
		LoggerReader.info("validateQueueOperationsClick Completed");

	}

	@Test(priority = 16, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForQueueOperations(String input, String expectedOutput) throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickQueueOperations();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Assert.assertEquals(queuePage.resultOutput(), expectedOutput);

	}

	@Test(priority = 17, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void validateTryHereButtonForinvalidInputViaQueueOperations(String input, String expectedOutput)
			throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickQueueOperations();
		queuePage.tryHereBtn();
		queuePage.textAreaSendKey(input);
		queuePage.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();

	}
	@Test(priority = 18)
public void testnocodeQueueOperations() throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickQueueOperations();
		queuePage.tryHereBtn();
		queuePage.runButtonClick();
}

	
	@Test(priority = 19)
	public void validatePracticeQuestionsClick() throws InterruptedException, IOException {
		callValidLog();
		queuePage.clickImplementationOfQueueInPython();
		queuePage.clickPracticeQuestions();
		String practiceQuestionsPage = DriverFactory.getDriver().getTitle();
		Assert.assertEquals("Practice Questions", practiceQuestionsPage);
		LoggerReader.info("validatePracticeQuestionsClick Completed");
	}
	@Test(priority = 20)
public void visibleContentOfPracticeQuestionsLink() throws InterruptedException, IOException {
		
		callValidLog();
		queuePage.clickImplementationOfQueueInPython();
		queuePage.clickPracticeQuestions();
		queuePage.clickVisibleQuestions();
	}
	@Test(priority = 21)
	@AfterClass(alwaysRun = true)
	public void teardown() {
		queuePage.closebrowser();
	}

}


