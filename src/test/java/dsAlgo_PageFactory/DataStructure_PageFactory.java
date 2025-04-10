package dsAlgo_PageFactory;

import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_Utilities.ConfigReader;

import dsAlgo_Utilities.TryEditor;

public class DataStructure_PageFactory {

	WebDriver driver = DriverFactory.getDriver();
	ConfigReader configFileReader = DriverFactory.configReader();
	TryEditor readTryEditor = new TryEditor();
	String pagetitle;
	protected boolean practicequestioncontent;

	@FindBy(xpath = "(//a[@href='data-structures-introduction'])[1]")
	@CacheLookup
	public WebElement ds_Getstarted;
	@FindBy(xpath = "//a[normalize-space()='Time Complexity']")
	WebElement TimeComplexity;
	@FindBy(xpath = "//h4[normalize-space()='Data Structures-Introduction']")
	WebElement pageTitle;
	@FindBy(xpath = "//*[@id=\"content\"]/li/a")
	WebElement practiceques;
	@FindBy(xpath = "//*[@id=\"content\"]/a")
	WebElement practicequescontent;
	@FindBy(linkText = "Try here>>>")
	WebElement Tryhere;
	@FindBy(xpath = "//div[@class='CodeMirror-scroll']")
	WebElement codetextarea;
	@FindBy(xpath = "//button[normalize-space()='Run']")
	WebElement runbutton;
	@FindBy(xpath = "//pre[@id='output']")
	WebElement consoleoutput;
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/strong/p")
	@CacheLookup
	WebElement pgTitle;

	public String DataStructurepage() {
		PageFactory.initElements(driver, this);
		ds_Getstarted.click();
		pagetitle = driver.getTitle();
		return pagetitle;
	}

	public void navigateback() {
		driver.navigate().back();
	}

	public String checkpageTitle() {
		String currentpagetitle = driver.getTitle();
		return currentpagetitle;
	}

	public boolean PgTitleDiaplayed() {
		return pgTitle.isDisplayed();
	}

	public boolean DSPgTitleDiaplayed() {
		return ds_Getstarted.isDisplayed();
	}

	public boolean Run_btnDisplayed() {
		return runbutton.isDisplayed();
	}

	public String TimeComplexityLink() {
		TimeComplexity.click();
		pagetitle = driver.getTitle();
		return pagetitle;
	}

	public void clearCodeArea() {
		codetextarea.clear();
	}

	public String getCodeAreaContent() {
		return codetextarea.getText();
	}

	public void PracticeQuestion() {
		practiceques.click();
	}

	public boolean PracticeQuestioncontentcheck() {
		try {
			practicequescontent.getText();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public String tryhere() {
		Tryhere.click();
		pagetitle = driver.getTitle();
		return pagetitle;
	}

	public void clickrun() {
		runbutton.click();
	}

	public void entercode(String code) {
		Actions actions = new Actions(driver);
		actions.sendKeys(code).perform();
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	public String handlealert() {
		Alert alert = driver.switchTo().alert();
		String get_alert_msg = alert.getText();

		alert.accept();
		return get_alert_msg;
	}

	public String getoutput() {
		String output = consoleoutput.getText();
		return output;
	}

	public void closebrowser() {
		driver.quit();
	}
}