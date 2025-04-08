package dsAlgo_TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_PageFactory.StackPageFactory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.DataProviderClass;
import dsAlgo_Utilities.ListenersReporter;
import dsAlgo_Utilities.LoggerReader;
import org.testng.Assert;
import org.testng.ITestResult;

@Listeners(dsAlgo_Utilities.ListenersReporter.class)
public class StackTest extends BaseClass {

	private String username;
	private String password;

	String ExpectedOutput;

	StackPageFactory stackPageFactory;
	Home_PageFactory homePageFactory;
	Login_PageFactory loginPageFactory;

	public ConfigReader config = new ConfigReader();
	WebDriver driver;
	String pagetitle;

	@BeforeMethod
	public void initPageObjects() {
		homePageFactory = new Home_PageFactory();
		loginPageFactory = new Login_PageFactory();
		homePageFactory.launchUrl();
		homePageFactory.getStartedHomeBtnClick();

	}

	public StackTest(String username, String password) throws IOException {
		this.username = username;
		this.password = password;

	}

	@Factory(dataProvider = "validLoginData", dataProviderClass = DataProviderClass.class)

	public static Object[] loginData(String username, String password) throws IOException {

		return new Object[] { new StackTest(username, password) };

	}

	@Test(priority = 1)
	public void toLoginpage() throws IOException {
		loginPageFactory = new Login_PageFactory();
		loginPageFactory.signInLoginBtnClick();
		stackPageFactory = new StackPageFactory();

	}

	@Test(priority = 2)
	public void callvalidLogin() throws InterruptedException, IOException {

		toLoginpage();
		loginPageFactory.enterusername(username);
		loginPageFactory.enterpassword(password);
		loginPageFactory.LoginBtnClick();
		// String loggedInMsg = loginPageFactory.loginMsg();
		// Assert.assertEquals(loggedInMsg, "You are logged in");
		LoggerReader.info("User logs in");

	}

	@Test(priority = 2)
	public void operationsInStack() throws IOException, InterruptedException {
		callvalidLogin();
		stackPageFactory.stackGetStarted();
		stackPageFactory.operationInStack();
		stackPageFactory.assertLogging("Operations in Stack", stackPageFactory.getTitle());
		LoggerReader.info("On Operation in Stack Page");
	}

	@Test(priority = 3)
	public void operationsInStackTryEditor() throws IOException, InterruptedException {
		operationsInStack();
		stackPageFactory.tryHereBtn();
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());
		LoggerReader.info("On Operation in Stack Page Try Editor");
	}

	@Test(priority = 4)
	public void stackTryEditor() throws IOException, InterruptedException {
		operationsInStackTryEditor();
		stackPageFactory.tryEditorWindow("TryEditor", 1);
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());
		LoggerReader.info("On Operation in Stack Page Try Editor row 1 ");
	}

	@Test(priority = 5)
	public void stackTryEditorInvalid() throws IOException, InterruptedException {
		stackTryEditor();
		stackPageFactory.tryEditorWindow("TryEditor", 2);
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());
		LoggerReader.info("On Operation in Stack Page Try Editor row 2 ");
	}

	@Test(priority = 6)
	public void implementation() throws IOException, InterruptedException {
		callvalidLogin();
		stackPageFactory.stackGetStarted();
		stackPageFactory.Implementation();
		stackPageFactory.assertLogging("Implementation", stackPageFactory.getTitle());
		LoggerReader.info("On Implementation Page");
	}

	@Test(priority = 7)
	public void implementationTryEditor() throws IOException, InterruptedException {
		implementation();
		stackPageFactory.tryHereBtn();
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());
		LoggerReader.info("On implementation Page Try Editor");
	}

	@Test(priority = 8)
	public void implementationTryEditorValid() throws IOException, InterruptedException {
		implementationTryEditor();
		stackPageFactory.tryEditorWindow("TryEditor", 1);
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());
		LoggerReader.info("On implementationTryEditor Page Try Editor row 1 ");
	}

	@Test(priority = 9)
	public void implementationTryEditorInvalid() throws IOException, InterruptedException {
		implementationTryEditorValid();
		stackPageFactory.tryEditorWindow("TryEditor", 2);
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());
		LoggerReader.info("On implementationTryEditor Page Try Editor row 2 ");
	}

	@Test(priority = 10)
	public void applications() throws IOException, InterruptedException {
		callvalidLogin();
		stackPageFactory.stackGetStarted();
		stackPageFactory.Applications();
		stackPageFactory.assertLogging("Applications", stackPageFactory.getTitle());
		LoggerReader.info("On Applications Page");
	}

	@Test(priority = 11)
	public void applicationsTryEditor() throws IOException, InterruptedException {
		applications();
		stackPageFactory.tryHereBtn();
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());
		LoggerReader.info("On applications Page Try Editor");
	}

	@Test(priority = 12)
	public void applicationsTryEditorValid() throws IOException, InterruptedException {
		applicationsTryEditor();
		stackPageFactory.tryEditorWindow("TryEditor", 1);
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());
		LoggerReader.info("On applicationsTryEditor Page Try Editor row 1 ");
	}

	@Test(priority = 13)
	public void applicationsTryEditorInvalid() throws IOException, InterruptedException {
		applicationsTryEditorValid();
		stackPageFactory.tryEditorWindow("TryEditor", 2);
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());
		LoggerReader.info("On applicationsTryEditor Page Try Editor row 2 ");
	}

	@Test(priority = 14)
	public void PracticeQuestions() throws IOException, InterruptedException {
		operationsInStack();
		stackPageFactory.PracticeQuestions();
		stackPageFactory.assertLogging("Practice Questions", stackPageFactory.getTitle());
		Assert.assertFalse(stackPageFactory.htmlBodyContent().trim().isEmpty(),
				"Page body is blank instead of none black page! ");
		LoggerReader
				.error("Test failed: Found the page blank! Expected to navigate to Stack Module Practice Questions");
		LoggerReader.info("On PracticeQuestions Page");
	}

	// Fail - Blank Page

	@AfterClass(alwaysRun = true)
	public void teardown() {
		stackPageFactory.closebrowser();
	}

	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE && driver != null) {
			LoggerReader.info("Test failed: " + result.getName() + ". Attaching screenshot to Allure.");
			ListenersReporter.attachScreenshotToAllure(driver);
		}

	}

}
