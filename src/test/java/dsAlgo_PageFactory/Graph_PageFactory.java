package dsAlgo_PageFactory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_Utilities.ConfigReader;

public class Graph_PageFactory {

	WebDriver driver = DriverFactory.getDriver();
	ConfigReader configFileReader = DriverFactory.configReader();

	@FindBy(xpath = "//a[text()='Data Structures']")
	@CacheLookup
	WebElement Data_structure;

	@FindBy(xpath = "//*[@id=\"navbarCollapse\"]/div[1]/div/div/a[6]")
	@CacheLookup
	WebElement ds_graph;

	@FindBy(xpath = "/html/body/div[2]")
	@CacheLookup
	WebElement login_msg;

	@FindBy(xpath = "//a[text()='Sign in']")
	@CacheLookup
	WebElement signin;

	@FindBy(xpath = "//a[@href='graph']")
	@CacheLookup
	WebElement graph_getStarted_btn;

	@FindBy(xpath = "/html/body/div[2]/ul[2]/a")
	@CacheLookup
	WebElement graph;

	@FindBy(xpath = "/html/body/div[2]/ul[3]/a")
	@CacheLookup
	WebElement graph_representations;

	@FindBy(xpath = "//*[@id='content']/a")
	@CacheLookup
	WebElement practice_question;

	@FindBy(xpath = "/html/body/div[2]/div/div[2]/a")
	@CacheLookup
	WebElement try_here;

	@FindBy(xpath = "//*[@id='answer_form']/div/div/div[1]/textarea")
	@CacheLookup
	public WebElement code_txtarea;

	@FindBy(xpath = "//*[@id='answer_form']/button")
	@CacheLookup
	WebElement run_button;

	@FindBy(xpath = "//*[@id=\"output\"]")
	@CacheLookup
	WebElement run_txtarea;

	@FindBy(xpath = "/html/body/div[2]/div/div[2]/strong/p")
	@CacheLookup
	public WebElement pgTitle;

	@FindBy(xpath = "/html/body/div[2]/h4")
	@CacheLookup
	WebElement graph_main_title;

	@FindBy(xpath = "/html/body/div[2]/div")
	@CacheLookup
	public WebElement practice_content;

	public Graph_PageFactory() {
		PageFactory.initElements(driver, this);
	}

	public void ClickDS() {
		Data_structure.click();
	}

	public void ClickDS_Graph() {
		ds_graph.click();

	}

	public String getmsg() {
		return login_msg.getText();
	}

	public void ClickGetStarted() {
		graph_getStarted_btn.click();

	}

	public void Clickgraph() {
		graph.click();
	}

	public void Clickgraph_representations() {
		graph_representations.click();

	}

	public void ClickPractice_Questions() {
		practice_question.click();

	}

	public String getContentText() {
		return practice_content.getText();
	}

	public void ClickSignin() {
		signin.click();
	}

	public void ClickTry_here() {
		try_here.click();

	}

	public String getResultText() {
		return run_txtarea.getText();
	}

	public void ClickRun() {
		run_button.click();
	}

	public boolean Run_btnDisplayed() {
		return run_button.isDisplayed();
	}

	public boolean PgTitleDiaplayed() {
		return pgTitle.isDisplayed();
	}

	public String runButtonWithAlert() {

		Alert alert = driver.switchTo().alert();
		String get_alert_msg = alert.getText();

		alert.accept();
		return get_alert_msg;
	}

	public String getTitle() {
		return driver.getTitle();

	}

	public String graph_main_getTitle() {
		return graph_main_title.getText();
	}

	public void navigateback() {
		driver.navigate().back();
	}

	public void closebrowser() {
		driver.quit();
	}

	@SuppressWarnings("null")
	public void clickvisibleQuestions() {
		WebElement visibleQuestions = null;
		visibleQuestions.click();
	}

}