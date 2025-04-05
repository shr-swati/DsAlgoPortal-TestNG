package dsAlgo_TestClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_PageFactory.Tree_PageFactory;
import dsAlgo_Utilities.DataProviderClass;
import dsAlgo_Utilities.LoggerReader;

@Listeners(dsAlgo_Utilities.ListenersReporter.class)

public class Tree_TestClass extends BaseClass{
	private String username;
	private String password;
	private String input;
	private String expectedOutput;
	
	WebDriver driver;
	Home_PageFactory homePage;
	Login_PageFactory loginPage;
	Tree_PageFactory treePage;
	
	
	@BeforeMethod
	public void initPageObjects() {
		homePage = new Home_PageFactory();
		loginPage = new Login_PageFactory();
		homePage.launchUrl();
		homePage.getStartedHomeBtnClick();
	}
	
	public Tree_TestClass(String username, String password) throws IOException {
		
		
		this.username = username;
        this.password = password;
	}
	
	 @Factory(dataProvider = "validLoginData", dataProviderClass = DataProviderClass.class)
	public static Object[] loginData(String username, String password) throws IOException {
        return new Object[] { new Tree_TestClass(username, password) };
    }
	
	
	@Test(priority=1)
	public void callValidLog() throws InterruptedException, IOException {
		 treePage = new Tree_PageFactory();		   
		 loginData( username, password);
		 loginPage.signInClick();
			loginPage.userName.sendKeys(username);
			loginPage.passWord.sendKeys(password);
			loginPage.LoginBtnClick();
	}


	@Test(priority=2)
	public void treeGetStarted() throws InterruptedException, IOException {
		callValidLog();
		LoggerReader.info("User is navigate to tree page after clicking on tree get started button ");
		treePage.ClickGetStarted();
	}
	
	@Test(priority=3)
	public void treeIntreePage() throws InterruptedException, IOException {
		treeGetStarted();
	
		String pgTitle = treePage.tree_main_getTitle();
		Assert.assertEquals("Tree", pgTitle);
		LoggerReader.info("User is navigate to Tree page after clicking on Tree get started button ");
	}

	@Test(priority=4)
	public void ClickOverviewOFTrees() throws InterruptedException, IOException {
		treeGetStarted();
		treePage.ClickOverview_of_Trees();
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Overview of Trees", TreePgTitle);
		LoggerReader.info("User entered in Overview of Trees page");
	}
	@Test(priority=5)
	public void ClickOverviewOFTrees_TryHere() throws InterruptedException, IOException {
		ClickOverviewOFTrees();
		treePage.ClickTry_here();
		Assert.assertEquals(treePage.Run_btnDisplayed(), true);
		LoggerReader.info("User clicked on tryhere button and now in tryeditor page");
		
	}
	
	
	@Test(priority = 6, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validPython(String input, String expectedOutput) throws InterruptedException, IOException {
		ClickOverviewOFTrees_TryHere();
		
		treePage.code_txtarea.sendKeys(input); 
		treePage.ClickRun();
		String actualOutput = treePage.getResultText();
        Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
        LoggerReader.info("User ran the valid Python code in the TryEditor.");
	}

	@Test(priority = 7, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void invalidPython(String input, String expectedOutput) throws InterruptedException, IOException {
		ClickOverviewOFTrees_TryHere();
		
		treePage.code_txtarea.sendKeys(input); 
		treePage.ClickRun();
				Thread.sleep(2000);
		 String actualOutput = treePage.runButtonWithAlert();
		 Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		 LoggerReader.info("User ran the invalid Python code in the TryEditor.");

		 
}
	

}


//	
//	@Test(priority = 6)
//	public void ClickingTerminologies() throws InterruptedException {
//		
//		 driver.navigate().back();
//		String TreePgTitle = treePage.TreeMainTitle.getText();
//		Assert.assertEquals("Tree", TreePgTitle);
//		treePage.ClickTerminologies();
//		Assert.assertTrue(treePage.PgTitleDisplayed()); 
//
//	}
//	@Test(priority = 7)
//	public void TryHere_Terminologies() {
//		
//		treePage.ClickTry_here();
//		Assert.assertEquals(treePage.Run_btnDisplayed(), true);
//	}
//}
//	public void ClickingTypes_of_Trees() {
//		treePage.ClickTypes_of_Trees();
//		String TreePgTitle = treePage.pgTitle.getText();
//		Assert.assertEquals("Types of Trees", TreePgTitle);
//		LoggerReader.info("User entered in Types of Trees page");
//}
//	public void ClickingTree_Traversals() {
//		treePage.ClickTree_Traversals();
//		String TreePgTitle = treePage.pgTitle.getText();
//		Assert.assertEquals("Tree Traversals", TreePgTitle);
//		LoggerReader.info("User entered in Tree Traversals page");
//	}
//	public void ClickingTraversals_Illustration() {
//		treePage.ClickTraversals_Illustration();
//		String TreePgTitle = treePage.pgTitle.getText();
//		Assert.assertEquals("Traversals-Illustration", TreePgTitle);
//		LoggerReader.info("User entered in Traversals-Illustration page");
//	}
//	public void ClickingBinary_Trees() {
//		treePage.ClickBinary_Trees();
//		String TreePgTitle = treePage.pgTitle.getText();
//		Assert.assertEquals("Binary Trees", TreePgTitle);
//		LoggerReader.info("User entered in Binary Trees page");
//	}
//	public void ClickingTypes_of_Binary_Trees() {
//		treePage.ClickTypes_of_Binary_Trees();
//		String TreePgTitle = treePage.pgTitle.getText();
//		Assert.assertEquals("Types of Binary Trees", TreePgTitle);
//		LoggerReader.info("User entered in Types of Binary Trees page");
//	}
//	public void ClickingImplementation_in_Python() {
//		treePage.ClickImplementation_in_Python();
//		String TreePgTitle = treePage.pgTitle.getText();
//		Assert.assertEquals("Implementation in Python", TreePgTitle);
//		LoggerReader.info("User entered in Implementation in Python page");
//	}
//	public void ClickingBinary_Tree_Traversals() {
//		treePage.ClickBinary_Tree_Traversals();
//		String TreePgTitle = treePage.pgTitle.getText();
//		Assert.assertEquals("Binary Tree Traversals", TreePgTitle);
//		LoggerReader.info("User entered in Binary Tree Traversals page");
//	}
//	public void ClickingImplementation_of_Binary_Trees() {
//		treePage.ClickImplementation_of_Binary_Trees();
//		String TreePgTitle = treePage.pgTitle.getText();
//		Assert.assertEquals("Implementation of Binary Trees", TreePgTitle);
//		LoggerReader.info("User entered in Implementation of Binary Trees page");
//	}
//	public void ClickingApplications_of_Binary_trees() {
//		treePage.ClickApplications_of_Binary_trees();
//		String TreePgTitle = treePage.pgTitle.getText();
//		Assert.assertEquals("Applications of Binary trees", TreePgTitle);
//		LoggerReader.info("User entered in Applications of Binary trees page");
//	}
//	public void ClickingBinary_Search_Trees() {
//		treePage.ClickBinary_Search_Trees();
//		String TreePgTitle = treePage.pgTitle.getText();
//		Assert.assertEquals("Binary Search Trees", TreePgTitle);
//		LoggerReader.info("User entered in Binary Search Trees page");
//	}
//	public void ClickingImplementation_Of_BST() {
//		treePage.ClickImplementation_Of_BST();
//		String TreePgTitle = treePage.pgTitle.getText();
//		Assert.assertEquals("Implementation Of BST", TreePgTitle);
//		LoggerReader.info("User entered in Implementation Of BST page");
//	}
//	public void ClickingPractice_Questions() {
//		treePage.ClickPractice_Questions();
//		String TreePgTitle = treePage.pgTitle.getText();
//		Assert.assertEquals("Practice Questions", TreePgTitle);
//		LoggerReader.info("User entered in Practice Questions page");
//	}
//	
//	
//}
