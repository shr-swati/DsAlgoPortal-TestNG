package dsAlgo_TestClasses;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Graph_PageFactory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_PageFactory.Tree_PageFactory;
import dsAlgo_Utilities.DataProviderClass;
import dsAlgo_Utilities.ListenersReporter;
import dsAlgo_Utilities.LoggerReader;

@Listeners(dsAlgo_Utilities.ListenersReporter.class)

public class Tree_TestClass extends BaseClass {
	private String username;
	private String password;
	
	WebDriver driver;
	Home_PageFactory homePage;
	Login_PageFactory loginPage;
	Tree_PageFactory treePage;

	@BeforeMethod
	public void initPageObjects() throws InterruptedException, IOException {
		homePage = new Home_PageFactory();
		loginPage = new Login_PageFactory();
		homePage.launchUrl();
		homePage.getStartedHomeBtnClick();
        treePage = new Tree_PageFactory();
		
		loginPage.signInLoginBtnClick();
		loginPage.userName.sendKeys(username);
		loginPage.passWord.sendKeys(password);
		loginPage.LoginBtnClick();
	}

	public Tree_TestClass(String username, String password) throws IOException {

		this.username = username;
		this.password = password;
	}

	@Factory(dataProvider = "validLoginData", dataProviderClass = DataProviderClass.class)
	public static Object[] loginData(String username, String password) throws IOException {
		return new Object[] { new Tree_TestClass(username, password) };
	}


	@Test(priority = 2)
	public void treeGetStarted() throws InterruptedException, IOException {
	
		LoggerReader.info("User is navigate to tree page after clicking on tree get started button ");
		treePage.ClickGetStarted();
	}

	@Test(priority = 3)
	public void treeIntreePage() throws InterruptedException, IOException {
		treeGetStarted();

		String pgTitle = treePage.tree_main_getTitle();
		Assert.assertEquals("Tree", pgTitle);
		LoggerReader.info("User is navigate to Tree page after clicking on Tree get started button ");
	}

	@Test(priority = 4)
	public void ClickOverviewOFTrees() throws InterruptedException, IOException {
		treeGetStarted();
		treePage.ClickOverview_of_Trees();
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Overview of Trees", TreePgTitle);
		LoggerReader.info("User entered in Overview of Trees page");
	}

	@Test(priority = 5)
	public void ClickOverviewOFTrees_TryHere() throws InterruptedException, IOException {
		ClickOverviewOFTrees();
		treePage.ClickTry_here();
		Assert.assertEquals(treePage.Run_btnDisplayed(), true);
		LoggerReader.info("User clicked on tryhere button and now in tryeditor page");

	}

	@Test(priority = 6, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validPython_OverviewOFTrees(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickOverviewOFTrees_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();
		String actualOutput = treePage.getResultText();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the valid Python code in the TryEditor.");
	}

	@Test(priority = 7, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void invalidPython_OverviewOFTrees(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickOverviewOFTrees_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();

		String actualOutput = treePage.runButtonWithAlert();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the invalid Python code in the TryEditor.");

	}

	@Test(priority = 8)
	public void back_ClickOverviewOFTrees() throws InterruptedException, IOException {
		ClickOverviewOFTrees_TryHere();

		treePage.navigateback();
		// Thread.sleep(2000);
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Overview of Trees", TreePgTitle);
		LoggerReader.info("User entered in Overview of Trees page using navigate.back");

	}

	@Test(priority = 9)
	public void ClickingTerminologies() throws InterruptedException, IOException {
		treeGetStarted();
		treePage.ClickTerminologies();
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Terminologies", TreePgTitle);
		LoggerReader.info("User entered in Terminologies of Trees page");
	}

	@Test(priority = 10)
	public void ClickingTerminologies_TryHere() throws InterruptedException, IOException {
		ClickingTerminologies();
		treePage.ClickTry_here();
		Assert.assertEquals(treePage.Run_btnDisplayed(), true);
		LoggerReader.info("User clicked on tryhere button and now in tryeditor page");

	}

	@Test(priority = 11, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validPython_Treminologies(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingTerminologies_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();
		String actualOutput = treePage.getResultText();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the valid Python code in the TryEditor.");
	}

	@Test(priority = 12, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void invalidPython_Terminologies(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingTerminologies_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();

		String actualOutput = treePage.runButtonWithAlert();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the invalid Python code in the TryEditor.");

	}

	@Test(priority = 13)
	public void back_ClickTerminologies() throws InterruptedException, IOException {
		ClickingTerminologies_TryHere();

		treePage.navigateback();
		// Thread.sleep(2000);
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Terminologies", TreePgTitle);
		LoggerReader.info("User entered in Terminologies of Trees page");

	}

	@Test(priority = 14)
	public void ClickingTypes_of_Trees() throws InterruptedException, IOException {
		treeGetStarted();
		treePage.ClickTypes_of_Trees();
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Types of Trees", TreePgTitle);
		LoggerReader.info("User entered in Types of Trees page");
	}

	@Test(priority = 15)
	public void ClickingTypes_of_Trees_TryHere() throws InterruptedException, IOException {
		ClickingTypes_of_Trees();
		treePage.ClickTry_here();
		Assert.assertEquals(treePage.Run_btnDisplayed(), true);
		LoggerReader.info("User clicked on tryhere button and now in tryeditor page");

	}

	@Test(priority = 16, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validPython_Types_of_Trees(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingTypes_of_Trees_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();
		String actualOutput = treePage.getResultText();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the valid Python code in the TryEditor.");
	}

	@Test(priority = 17, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void invalidPython_Types_of_Trees(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingTypes_of_Trees_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();

		String actualOutput = treePage.runButtonWithAlert();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the invalid Python code in the TryEditor.");

	}

	@Test(priority = 18)
	public void back_ClickTypes_of_Trees() throws InterruptedException, IOException {
		ClickingTypes_of_Trees_TryHere();

		treePage.navigateback();
		// Thread.sleep(2000);
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Types of Trees", TreePgTitle);
		LoggerReader.info("User entered in Types of Trees page");

	}

	@Test(priority = 19)
	public void ClickingTree_Traversals() throws InterruptedException, IOException {
		treeGetStarted();
		treePage.ClickTree_Traversals();
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Tree Traversals", TreePgTitle);
		LoggerReader.info("User entered in Tree Traversals page");
	}

	@Test(priority = 20)
	public void ClickingTree_Traversals_TryHere() throws InterruptedException, IOException {
		ClickingTree_Traversals();
		treePage.ClickTry_here();
		Assert.assertEquals(treePage.Run_btnDisplayed(), true);
		LoggerReader.info("User clicked on tryhere button and now in tryeditor page");

	}

	@Test(priority = 21, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validPython_Tree_Traversals(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingTree_Traversals_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();
		String actualOutput = treePage.getResultText();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the valid Python code in the TryEditor.");
	}

	@Test(priority = 22, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void invalidPython_Tree_Traversals(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingTree_Traversals_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();

		String actualOutput = treePage.runButtonWithAlert();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the invalid Python code in the TryEditor.");

	}

	@Test(priority = 23)
	public void back_ClickingTree_Traversals() throws InterruptedException, IOException {
		ClickingTree_Traversals_TryHere();

		treePage.navigateback();
		// Thread.sleep(2000);
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Tree Traversals", TreePgTitle);
		LoggerReader.info("User entered in Tree Traversals page");

	}

	@Test(priority = 24)
	public void ClickingTraversals_Illustration() throws InterruptedException, IOException {
		treeGetStarted();
		treePage.ClickTraversals_Illustration();
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Traversals-Illustration", TreePgTitle);
		LoggerReader.info("User entered in Traversals-Illustration page");
	}

	@Test(priority = 25)
	public void ClickingTraversals_Illustration_TryHere() throws InterruptedException, IOException {
		ClickingTraversals_Illustration();
		treePage.ClickTry_here();
		Assert.assertEquals(treePage.Run_btnDisplayed(), true);
		LoggerReader.info("User clicked on tryhere button and now in tryeditor page");

	}

	@Test(priority = 26, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validPython_Traversals_Illustration(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingTraversals_Illustration_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();
		String actualOutput = treePage.getResultText();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the valid Python code in the TryEditor.");
	}

	@Test(priority = 27, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void invalidPython_Traversals_Illustration(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingTraversals_Illustration_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();

		String actualOutput = treePage.runButtonWithAlert();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the invalid Python code in the TryEditor.");

	}

	@Test(priority = 28)
	public void back_ClickingTraversals_Illustration() throws InterruptedException, IOException {
		ClickingTraversals_Illustration_TryHere();

		treePage.navigateback();
		// Thread.sleep(2000);
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Traversals-Illustration", TreePgTitle);
		LoggerReader.info("User entered in Traversals-Illustration page");

	}

	@Test(priority = 29)
	public void ClickingBinary_Trees() throws InterruptedException, IOException {
		treeGetStarted();
		treePage.ClickBinary_Trees();
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Binary Trees", TreePgTitle);
		LoggerReader.info("User entered in Binary Trees page");
	}

	@Test(priority = 30)
	public void ClickingBinary_Trees_TryHere() throws InterruptedException, IOException {
		ClickingBinary_Trees();
		treePage.ClickTry_here();
		Assert.assertEquals(treePage.Run_btnDisplayed(), true);
		LoggerReader.info("User clicked on tryhere button and now in tryeditor page");

	}

	@Test(priority = 31, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validPython_Binary_Trees(String input, String expectedOutput) throws InterruptedException, IOException {
		ClickingBinary_Trees_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();
		String actualOutput = treePage.getResultText();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the valid Python code in the TryEditor.");
	}

	@Test(priority = 32, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void invalidPython_Binary_Trees(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingBinary_Trees_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();

		String actualOutput = treePage.runButtonWithAlert();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the invalid Python code in the TryEditor.");
	}

	@Test(priority = 33)
	public void back_ClickingBinary_Trees() throws InterruptedException, IOException {
		ClickingBinary_Trees_TryHere();

		treePage.navigateback();
		// Thread.sleep(2000);
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Binary Trees", TreePgTitle);
		LoggerReader.info("User entered in Binary Trees page");

	}

	@Test(priority = 34)
	public void ClickingTypes_of_Binary_Trees() throws InterruptedException, IOException {
		treeGetStarted();
		treePage.ClickTypes_of_Binary_Trees();
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Types of Binary Trees", TreePgTitle);
		LoggerReader.info("User entered in Types of Binary Trees page");
	}

	@Test(priority = 35)
	public void ClickingTypes_of_Binary_Trees_TryHere() throws InterruptedException, IOException {
		ClickingTypes_of_Binary_Trees();
		treePage.ClickTry_here();
		Assert.assertEquals(treePage.Run_btnDisplayed(), true);
		LoggerReader.info("User clicked on tryhere button and now in tryeditor page");

	}

	@Test(priority = 36, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validPython_Types_of_Binary_Trees(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingTypes_of_Binary_Trees_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();
		String actualOutput = treePage.getResultText();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the valid Python code in the TryEditor.");
	}

	@Test(priority = 37, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void invalidPython_Types_of_Binary_Trees(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingTypes_of_Binary_Trees_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();

		String actualOutput = treePage.runButtonWithAlert();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the invalid Python code in the TryEditor.");
	}

	@Test(priority = 38)
	public void back_ClickingTypes_of_Binary_Trees() throws InterruptedException, IOException {
		ClickingTypes_of_Binary_Trees_TryHere();

		treePage.navigateback();
		// Thread.sleep(2000);
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Types of Binary Trees", TreePgTitle);
		LoggerReader.info("User entered in Types of Binary Trees page");

	}

	@Test(priority = 39)
	public void ClickingImplementation_in_Python() throws InterruptedException, IOException {
		treeGetStarted();
		treePage.ClickImplementation_in_Python();
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Implementation in Python", TreePgTitle);
		LoggerReader.info("User entered in Implementation in Python page");
	}

	@Test(priority = 40)
	public void ClickingImplementation_in_Python_TryHere() throws InterruptedException, IOException {
		ClickingImplementation_in_Python();
		treePage.ClickTry_here();
		Assert.assertEquals(treePage.Run_btnDisplayed(), true);
		LoggerReader.info("User clicked on tryhere button and now in tryeditor page");

	}

	@Test(priority = 41, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validPython_Implementation_in_Python(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingImplementation_in_Python_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();
		String actualOutput = treePage.getResultText();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the valid Python code in the TryEditor.");
	}

	@Test(priority = 42, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void invalidPython_Implementation_in_Python(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingImplementation_in_Python_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();

		String actualOutput = treePage.runButtonWithAlert();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the invalid Python code in the TryEditor.");
	}

	@Test(priority = 43)
	public void back_ClickingImplementation_in_Python() throws InterruptedException, IOException {
		ClickingImplementation_in_Python_TryHere();

		treePage.navigateback();
		// Thread.sleep(2000);
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Implementation in Python", TreePgTitle);
		LoggerReader.info("User entered in Implementation in Python page");

	}

	@Test(priority = 44)
	public void ClickingBinary_Tree_Traversals() throws InterruptedException, IOException {
		treeGetStarted();
		treePage.ClickBinary_Tree_Traversals();
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Binary Tree Traversals", TreePgTitle);
		LoggerReader.info("User entered in Binary Tree Traversals page");
	}

	@Test(priority = 45)
	public void ClickingBinary_Tree_Traversals_TryHere() throws InterruptedException, IOException {
		ClickingBinary_Tree_Traversals();
		treePage.ClickTry_here();
		Assert.assertEquals(treePage.Run_btnDisplayed(), true);
		LoggerReader.info("User clicked on tryhere button and now in tryeditor page");

	}

	@Test(priority = 46, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validPython_Binary_Tree_Traversals(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingBinary_Tree_Traversals_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();
		String actualOutput = treePage.getResultText();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the valid Python code in the TryEditor.");
	}

	@Test(priority = 47, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void invalidPython_Binary_Tree_Traversals(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingBinary_Tree_Traversals_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();

		String actualOutput = treePage.runButtonWithAlert();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the invalid Python code in the TryEditor.");
	}

	@Test(priority = 48)
	public void back_ClickingBinary_Tree_Traversals() throws InterruptedException, IOException {
		ClickingBinary_Tree_Traversals_TryHere();

		treePage.navigateback();
		// Thread.sleep(2000);
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Binary Tree Traversals", TreePgTitle);
		LoggerReader.info("User entered in Binary Tree Traversals page");

	}

	@Test(priority = 49)
	public void ClickingImplementation_of_Binary_Trees() throws InterruptedException, IOException {
		treeGetStarted();
		treePage.ClickImplementation_of_Binary_Trees();
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Implementation of Binary Trees", TreePgTitle);
		LoggerReader.info("User entered in Implementation of Binary Trees page");
	}

	@Test(priority = 50)
	public void ClickingImplementation_of_Binary_Trees_TryHere() throws InterruptedException, IOException {
		ClickingImplementation_of_Binary_Trees();
		treePage.ClickTry_here();
		Assert.assertEquals(treePage.Run_btnDisplayed(), true);
		LoggerReader.info("User clicked on tryhere button and now in tryeditor page");

	}

	@Test(priority = 51, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validPython_Implementation_of_Binary_Trees(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingImplementation_of_Binary_Trees_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();
		String actualOutput = treePage.getResultText();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the valid Python code in the TryEditor.");
	}

	@Test(priority = 52, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void invalidPython_Implementation_of_Binary_Trees(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingImplementation_of_Binary_Trees_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();

		String actualOutput = treePage.runButtonWithAlert();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the invalid Python code in the TryEditor.");
	}

	@Test(priority = 53)
	public void back_ClickingImplementation_of_Binary_Trees() throws InterruptedException, IOException {
		ClickingImplementation_of_Binary_Trees_TryHere();

		treePage.navigateback();
		// Thread.sleep(2000);
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Implementation of Binary Trees", TreePgTitle);
		LoggerReader.info("User entered in Implementation of Binary Trees page");

	}

	@Test(priority = 54)
	public void ClickingApplications_of_Binary_trees() throws InterruptedException, IOException {
		treeGetStarted();
		treePage.ClickApplications_of_Binary_trees();
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Applications of Binary trees", TreePgTitle);
		LoggerReader.info("User entered in Applications of Binary trees page");
	}

	@Test(priority = 55)
	public void ClickingApplications_of_Binary_trees_TryHere() throws InterruptedException, IOException {
		ClickingApplications_of_Binary_trees();
		treePage.ClickTry_here();
		Assert.assertEquals(treePage.Run_btnDisplayed(), true);
		LoggerReader.info("User clicked on tryhere button and now in tryeditor page");

	}

	@Test(priority = 56, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validPython_Applications_of_Binary_trees(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingApplications_of_Binary_trees_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();
		String actualOutput = treePage.getResultText();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the valid Python code in the TryEditor.");
	}

	@Test(priority = 57, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void invalidPython_Applications_of_Binary_trees(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingApplications_of_Binary_trees_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();

		String actualOutput = treePage.runButtonWithAlert();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the invalid Python code in the TryEditor.");
	}

	@Test(priority = 58)
	public void back_ClickingApplications_of_Binary_trees() throws InterruptedException, IOException {
		ClickingApplications_of_Binary_trees_TryHere();

		treePage.navigateback();
		// Thread.sleep(2000);
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Applications of Binary trees", TreePgTitle);
		LoggerReader.info("User entered in Applications of Binary trees page");

	}

	@Test(priority = 59)
	public void ClickingBinary_Search_Trees() throws InterruptedException, IOException {
		treeGetStarted();
		treePage.ClickBinary_Search_Trees();
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Binary Search Trees", TreePgTitle);
		LoggerReader.info("User entered in Binary Search Trees page");
	}

	@Test(priority = 60)
	public void ClickingBinary_Search_Trees_TryHere() throws InterruptedException, IOException {
		ClickingBinary_Search_Trees();
		treePage.ClickTry_here();
		Assert.assertEquals(treePage.Run_btnDisplayed(), true);
		LoggerReader.info("User clicked on tryhere button and now in tryeditor page");

	}

	@Test(priority = 61, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validPython_Binary_Search_Trees(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingBinary_Search_Trees_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();
		String actualOutput = treePage.getResultText();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the valid Python code in the TryEditor.");
	}

	@Test(priority = 62, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void invalidPython_Binary_Search_Trees(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingBinary_Search_Trees_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();

		String actualOutput = treePage.runButtonWithAlert();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the invalid Python code in the TryEditor.");
	}

	@Test(priority = 63)
	public void back_ClickingBinary_Search_Trees() throws InterruptedException, IOException {
		ClickingBinary_Search_Trees_TryHere();

		treePage.navigateback();
		// Thread.sleep(2000);
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Binary Search Trees", TreePgTitle);
		LoggerReader.info("User entered in Binary Search Trees page");

	}

	@Test(priority = 64)
	public void ClickingImplementation_Of_BST() throws InterruptedException, IOException {
		treeGetStarted();
		treePage.ClickImplementation_Of_BST();
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Implementation Of BST", TreePgTitle);
		LoggerReader.info("User entered in Implementation Of BST page");
	}

	@Test(priority = 65)
	public void ClickingImplementation_Of_BST_TryHere() throws InterruptedException, IOException {
		ClickingImplementation_Of_BST();
		treePage.ClickTry_here();
		Assert.assertEquals(treePage.Run_btnDisplayed(), true);
		LoggerReader.info("User clicked on tryhere button and now in tryeditor page");

	}

	@Test(priority = 66, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
	public void validPython_Implementation_Of_BST(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingImplementation_Of_BST_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();
		String actualOutput = treePage.getResultText();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the valid Python code in the TryEditor.");
	}

	@Test(priority = 67, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
	public void invalidPython_Implementation_Of_BST(String input, String expectedOutput)
			throws InterruptedException, IOException {
		ClickingImplementation_Of_BST_TryHere();

		treePage.code_txtarea.sendKeys(input);
		treePage.ClickRun();

		String actualOutput = treePage.runButtonWithAlert();
		Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
		LoggerReader.info("User ran the invalid Python code in the TryEditor.");
	}

	@Test(priority = 68)
	public void back_ClickingImplementation_Of_BST() throws InterruptedException, IOException {
		ClickingImplementation_Of_BST_TryHere();

		treePage.navigateback();
		String TreePgTitle = treePage.pgTitle.getText();
		Assert.assertEquals("Implementation Of BST", TreePgTitle);
		LoggerReader.info("User entered in Implementation Of BST page");

	}

	@Test(priority=69)
	public void ClickPractice_Questions() throws InterruptedException, IOException {
	treeGetStarted();
	treePage.ClickOverview_of_Trees();
	treePage.ClickPractice_Questions();

	String TreePgTitle = treePage.practice_content.getText();
	Assert.assertEquals("Practice Questions", TreePgTitle);
	LoggerReader.info("User entered in Practice questions in Graph page");
	}
	@Test(priority=70)
	public void visibleContentInPracticeQuestions() throws InterruptedException, IOException {
	ClickPractice_Questions();
	treePage.clickvisibleQuestions();
	String TreePgTitle = treePage.practice_content.getText();
	Assert.assertEquals("Practice Questions", TreePgTitle);
	LoggerReader.info("check content is visible in Practice questions page");
	}
	
	
	//Fail

	@AfterClass(alwaysRun = true)
	public void teardown() {
		treePage.closebrowser();
	}

	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE && driver != null) {
			LoggerReader.info("Test failed: " + result.getName() + ". Attaching screenshot to Allure.");
			ListenersReporter.attachScreenshotToAllure(driver);
		}

	}
}
