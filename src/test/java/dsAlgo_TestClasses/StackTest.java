package dsAlgo_TestClasses;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import dsAlgo_BaseClass.BaseClass;
import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_PageFactory.StackPageFactory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.DataProviderClass;
import dsAlgo_Utilities.LoggerReader;
import org.testng.Assert;

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
		driver = DriverFactory.getDriver();

	}
	
	public StackTest(String username, String password) throws IOException {
		this.username = username;
		this.password = password;

	}

	@Factory(dataProvider = "validLoginData", dataProviderClass = DataProviderClass.class)

	public static Object[] loginData(String username, String password) throws IOException {

		return new Object[] { new StackTest(username, password) };

	}
	@Test(priority=1)
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
		LoggerReader.info("User logs in");	
	}
	
	@Test (priority=3)
	public void operationsInStack() throws IOException,InterruptedException { 
		callvalidLogin();
		stackPageFactory.stackGetStarted();
		stackPageFactory.operationInStack();
		stackPageFactory.assertLogging("Operations in Stack", stackPageFactory.getTitle());
		LoggerReader.info("On Operation in Stack Page");
	}

	@Test (priority=4)
	public void operationsInStackTryEditor() throws IOException,InterruptedException { 
		operationsInStack();
		stackPageFactory.tryHereBtn();		
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());		
		LoggerReader.info("On Operation in Stack Page Try Editor");
	}	
	
	@Test(priority = 5, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void stackTryEditor(String input, String expectedOutput) throws IOException,InterruptedException { 
		operationsInStackTryEditor();
		stackPageFactory.textAreaSendKey(input);
		stackPageFactory.runButtonClick();
		Assert.assertEquals(stackPageFactory.resultOutput(), expectedOutput);	
		LoggerReader.info("On Operation in Stack Page Try Editor Valid Code ");
	}
	
	@Test(priority = 6, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void stackTryEditorInvalid(String input, String expectedOutput) throws IOException,InterruptedException { 
		
		operationsInStackTryEditor();
		stackPageFactory.textAreaSendKey(input);
		stackPageFactory.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
		LoggerReader.info("On Operation in Stack Page Try Editor Invalid Code ");
	}
	
	@Test (priority=7)
	public void implementation() throws IOException,InterruptedException { 
		callvalidLogin();
		stackPageFactory.stackGetStarted();
		stackPageFactory.Implementation();
		stackPageFactory.assertLogging("Implementation", stackPageFactory.getTitle());
		LoggerReader.info("On Implementation Page");
	}
	
	@Test (priority=8)
	public void implementationTryEditor() throws IOException,InterruptedException { 
		implementation();
		stackPageFactory.tryHereBtn();		
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());		
		LoggerReader.info("On implementation Page Try Editor");
	}
	
	
	@Test(priority = 9, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void implementationTryEditorValid(String input, String expectedOutput) throws IOException,InterruptedException { 
		implementationTryEditor();
		stackPageFactory.textAreaSendKey(input);
		stackPageFactory.runButtonClick();
		Assert.assertEquals(stackPageFactory.resultOutput(), expectedOutput);	
		LoggerReader.info("Stack Page implementation Try Editor Valid Code ");	
	
	}	
	
	@Test(priority = 10, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void implementationTryEditorInvalid(String input, String expectedOutput) throws IOException,InterruptedException { 
		
		implementationTryEditor();
		stackPageFactory.textAreaSendKey(input);
		stackPageFactory.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
		LoggerReader.info("Stack Page Implementation Try Editor Invalid Code ");
	}
	@Test (priority=11)
	public void applications() throws IOException,InterruptedException { 
		callvalidLogin();
		stackPageFactory.stackGetStarted();
		stackPageFactory.Applications();
		stackPageFactory.assertLogging("Applications", stackPageFactory.getTitle());
		LoggerReader.info("On Applications Page");
	}
	
	@Test (priority=12)
	public void applicationsTryEditor() throws IOException,InterruptedException { 
		applications();
		stackPageFactory.tryHereBtn();		
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());		
		LoggerReader.info("On applications Page Try Editor");
	}
	
	@Test(priority = 13, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void applicationsTryEditorValid(String input, String expectedOutput) throws IOException,InterruptedException { 
		applicationsTryEditor();
		stackPageFactory.textAreaSendKey(input);
		stackPageFactory.runButtonClick();
		Assert.assertEquals(stackPageFactory.resultOutput(), expectedOutput);	
		LoggerReader.info("Stack Page Applications Try Editor Valid Code ");	
	
	}	
	
	@Test(priority = 14, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void applicationsTryEditorInvalid(String input, String expectedOutput) throws IOException,InterruptedException { 
		
		applicationsTryEditor();
		stackPageFactory.textAreaSendKey(input);
		stackPageFactory.runButtonClick();
		Alert alert_box = driver.switchTo().alert();
		Assert.assertEquals(alert_box.getText(), expectedOutput);
		alert_box.accept();
		LoggerReader.info("Stack Page Applications Try Editor Invalid Code ");
	}
	
	
    
	@Test (priority=15)
	public void PracticeQuestions() throws IOException,InterruptedException { 
		operationsInStack();
		stackPageFactory.PracticeQuestions();
		stackPageFactory.assertLogging("Practice Questions", stackPageFactory.getTitle());
		Assert.assertFalse(stackPageFactory.htmlBodyContent().trim().isEmpty(), "Page body is blank instead of none black page! ");
		LoggerReader.error("Test failed: Found the page blank! Expected to navigate to Stack Module Practice Questions");
		LoggerReader.info("On PracticeQuestions Page");
	}
}
