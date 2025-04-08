package dsAlgo_TestClasses;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Graph_PageFactory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_Utilities.DataProviderClass;
import dsAlgo_Utilities.LoggerReader;

@Listeners(dsAlgo_Utilities.ListenersReporter.class)

public class Graph_TestClass extends BaseClass{
private String username;
private String password;
private String input;
private String expectedOutput;



WebDriver driver;
Home_PageFactory homePage;
Login_PageFactory loginPage;
Graph_PageFactory graphPage;


@BeforeMethod
public void initPageObjects() {
homePage = new Home_PageFactory();
loginPage = new Login_PageFactory();
homePage.launchUrl();
homePage.getStartedHomeBtnClick();
}

public Graph_TestClass(String username, String password) throws IOException {


this.username = username;
        this.password = password;
}

@Factory(dataProvider = "validLoginData", dataProviderClass = DataProviderClass.class)
public static Object[] loginData(String username, String password) throws IOException {
        return new Object[] { new Graph_TestClass(username, password) };
    }


@Test(priority=1)
public void callValidLog() throws InterruptedException, IOException {
graphPage = new Graph_PageFactory();  
loginData( username, password);
loginPage.signInLoginBtnClick();
loginPage.userName.sendKeys(username);
loginPage.passWord.sendKeys(password);
loginPage.LoginBtnClick();
}


@Test(priority=2)
public void graphGetStarted() throws InterruptedException, IOException {
callValidLog();
graphPage.ClickGetStarted();
String pgTitle = graphPage.graph_main_getTitle();
Assert.assertEquals("Graph", pgTitle);
LoggerReader.info("User is navigate to graph page after clicking on graph get started button ");
}
@Test(priority=3)
public void Clickgraph_link() throws InterruptedException, IOException {
graphGetStarted();
graphPage.Clickgraph();

String GraphPgTitle = graphPage.pgTitle.getText();
Assert.assertEquals("Graph", GraphPgTitle);
LoggerReader.info("User entered in Graph linkin Graph page");
}

@Test(priority=4)
public void Clickgraph_link_TryHere() throws InterruptedException, IOException {
Clickgraph_link();
graphPage.ClickTry_here();
Assert.assertEquals(graphPage.Run_btnDisplayed(), true);
LoggerReader.info("User clicked on tryhere button and now in tryeditor page");

}


@Test(priority =5, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
public void validPython_Graph(String input, String expectedOutput) throws InterruptedException, IOException {
Clickgraph_link_TryHere();

graphPage.code_txtarea.sendKeys(input);
graphPage.ClickRun();
String actualOutput = graphPage.getResultText();
        Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
        LoggerReader.info("User ran the valid Python code in the TryEditor.");
}

@Test(priority = 6, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
public void invalidPython_Graph(String input, String expectedOutput) throws InterruptedException, IOException {
Clickgraph_link_TryHere();

graphPage.code_txtarea.sendKeys(input);
graphPage.ClickRun();

String actualOutput = graphPage.runButtonWithAlert();
Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
LoggerReader.info("User ran the invalid Python code in the TryEditor.");


}
@Test(priority=7)
public void back_ClickGraph() throws InterruptedException, IOException {
Clickgraph_link_TryHere();

graphPage.navigateback();
//Thread.sleep(2000);
String GraphPgTitle = graphPage.pgTitle.getText();
Assert.assertEquals("Graph", GraphPgTitle);
LoggerReader.info("User entered in Graph page using navigate.back");

}

@Test(priority=8)
public void Click_graph_representations() throws InterruptedException, IOException {
graphGetStarted();
graphPage.Clickgraph_representations();

String GraphPgTitle = graphPage.pgTitle.getText();
Assert.assertEquals("Graph Representations", GraphPgTitle);
LoggerReader.info("User entered in Graph Representations in Graph page");
}

@Test(priority=9)
public void Clickgraph_representations_TryHere() throws InterruptedException, IOException {
Click_graph_representations();
graphPage.ClickTry_here();
Assert.assertEquals(graphPage.Run_btnDisplayed(), true);
LoggerReader.info("User clicked on tryhere button and now in tryeditor page");

}


@Test(priority = 10, dataProvider = "validPythonCode", dataProviderClass = DataProviderClass.class)
public void validPython_graph_representations(String input, String expectedOutput) throws InterruptedException, IOException {
Clickgraph_representations_TryHere();

graphPage.code_txtarea.sendKeys(input);
graphPage.ClickRun();
String actualOutput = graphPage.getResultText();
        Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
        LoggerReader.info("User ran the valid Python code in the TryEditor.");
}

@Test(priority = 11, dataProvider = "invalidPythonCode", dataProviderClass = DataProviderClass.class)
public void invalidPython_graph_representations(String input, String expectedOutput) throws InterruptedException, IOException {
Clickgraph_representations_TryHere();

graphPage.code_txtarea.sendKeys(input);
graphPage.ClickRun();

String actualOutput = graphPage.runButtonWithAlert();
Assert.assertEquals(actualOutput, expectedOutput, "Output doesn't match the expected value.");
LoggerReader.info("User ran the invalid Python code in the TryEditor.");


}
@Test(priority=12)
public void back_ClickGraph_representations() throws InterruptedException, IOException {
Clickgraph_representations_TryHere();

graphPage.navigateback();
//Thread.sleep(2000);
String GraphPgTitle = graphPage.pgTitle.getText();
Assert.assertEquals("Graph Representations", GraphPgTitle);
LoggerReader.info("User entered in Graph Representations page using navigate.back");

}
@Test(priority=13)
public void ClickPractice_Questions() throws InterruptedException, IOException {
graphGetStarted();
graphPage.Clickgraph();
graphPage.ClickPractice_Questions();

String GraphPgTitle = graphPage.practice_content.getText();
Assert.assertEquals("Practice Questions", GraphPgTitle);
LoggerReader.info("User entered in Practice questions in Graph page");
}
@Test(priority=14)
public void visibleContentInPracticeQuestions() throws InterruptedException, IOException {
ClickPractice_Questions();
graphPage.clickvisibleQuestions();
String GraphPgTitle = graphPage.practice_content.getText();
Assert.assertEquals("Practice Questions", GraphPgTitle);
LoggerReader.info("check content is visible in Practice questions page");
}

}