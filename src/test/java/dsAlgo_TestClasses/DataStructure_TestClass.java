package dsAlgo_TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.DataStructure_PageFactory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.DataProviderClass;
import dsAlgo_Utilities.LoggerReader;

@Listeners(dsAlgo_Utilities.ListenersReporter.class)
public class DataStructure_TestClass extends BaseClass {

	public ConfigReader config = new ConfigReader();
	DataStructure_PageFactory dspf;
	Home_PageFactory homePage;
	Login_PageFactory loginPage;
	private String username;
	private String password;
	WebDriver driver;
	String pagetitle;

	@BeforeMethod
	public void initPageObjects() {
		homePage = new Home_PageFactory();
		loginPage = new Login_PageFactory();
		homePage.launchUrl();
		homePage.getStartedHomeBtnClick();

	}

	public DataStructure_TestClass(String username, String password) throws IOException {
		this.username = username;

		this.password = password;

	}

	@Factory(dataProvider = "validLoginData", dataProviderClass = DataProviderClass.class)

	public static Object[] loginData(String username, String password) throws IOException {

		return new Object[] { new DataStructure_TestClass(username, password) };

	}

	@Test(priority = 1)
	public void callValidLog() throws InterruptedException, IOException {

		dspf = new DataStructure_PageFactory();
		//loginData(username, password);
		loginPage.signInLoginBtnClick();
		loginPage.enterusername(username);
		loginPage.enterpassword(password);
		loginPage.LoginBtnClick();
		
	}

	@Test(priority = 2)
	public void testnocodeTimeComplexity() throws InterruptedException, IOException {
		callValidLog();
		dspf.DataStructurepage();
		dspf.TimeComplexityLink();
		dspf.tryhere();
		dspf.clickrun();
	}

	@Test(priority = 3, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void testwithinvalidcodeTimeComplexity(String tryherecode, String expectedalertmessage) throws InterruptedException, IOException {
		callValidLog();
		dspf.DataStructurepage();
		dspf.TimeComplexityLink();
		invalidcodetest(tryherecode, expectedalertmessage);
		//dspf.navigateback();
		
	}
	
	 @Test(priority=4, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class) 
	 public void testwithvalidcodeTimeComplexity(String tryherecode, String expectedconsoleoutput) throws InterruptedException, IOException { 
	 callValidLog();
	 dspf.DataStructurepage();
	 dspf.TimeComplexityLink();
	 validcodetest(tryherecode,expectedconsoleoutput); 
	 String actualOutput = dspf.getoutput();
	 Assert.assertEquals(actualOutput, expectedconsoleoutput, "Output doesn't match the expected value.");
	
	 }
	 
	 @Test(priority=5)
	 public void testpracticecode() throws InterruptedException, IOException { 
	 callValidLog();
	 dspf.DataStructurepage();
	 dspf.TimeComplexityLink();
	 dspf.PracticeQuestion(); boolean checkcontent =
	 dspf.PracticeQuestioncontentcheck(); Assert.assertTrue(checkcontent, "No content displayed."); }
	 
	
	 /*public void nocodetest() { pagetitle = dspf.tryhere(); dspf.clickrun();
	 * boolean ifalertdisplayed = dspf.isAlertPresent();
	 * Assert.assertTrue(ifalertdisplayed, "No alert displayed."); }
	 */

	public void invalidcodetest(String code, String expectedalertmessage) {
		pagetitle = dspf.tryhere();
		dspf.entercode(code);
		dspf.clickrun();
		boolean ifalertdisplayed = dspf.isAlertPresent();
		Assert.assertEquals(ifalertdisplayed, true, "No alert displayed.");
		String alertmessage = dspf.handlealert();
		LoggerReader.info(alertmessage);
		Assert.assertEquals(alertmessage, expectedalertmessage, "Incorrect alert message displayed.");
	}

	
	 public void validcodetest(String code,String expectedconsoleoutput) {
	 pagetitle = dspf.tryhere(); 
	 dspf.entercode(code);
	 dspf.clickrun();
	 String output = dspf.getoutput(); Assert.assertEquals(output,
	 expectedconsoleoutput, "Incorrect output displayed.");
	 LoggerReader.info("Output is "+output); }
	 
	 
	@AfterClass(alwaysRun = true)
	public void teardown() {
		dspf.closebrowser();
	}

}