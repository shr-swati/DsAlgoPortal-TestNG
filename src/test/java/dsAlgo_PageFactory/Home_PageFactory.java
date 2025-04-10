package dsAlgo_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.TryEditor;

public class Home_PageFactory {

	WebDriver driver = DriverFactory.getDriver();
	ConfigReader configFileReader = DriverFactory.configReader();
	TryEditor readTryEditor = new TryEditor();

	@FindBy(xpath = "//button[normalize-space()='Get Started']")
	WebElement getStartedHomeBtn;
	@FindBy(xpath = "//a[normalize-space()='Data Structures']")
	WebElement dataStructureDropDown;
	@FindBy(xpath = "//a[normalize-space()='Arrays']")
	WebElement arraysBtn;
	@FindBy(xpath = "//a[normalize-space()='Linked List']")
	WebElement linkedListBtn;
	@FindBy(xpath = "//a[normalize-space()='Stack']")
	WebElement stackBtn;
	@FindBy(xpath = "//a[normalize-space()='Queue']")
	WebElement queueBtn;
	@FindBy(xpath = "//a[normalize-space()='Tree']")
	WebElement treeBtn;
	@FindBy(xpath = "//a[normalize-space()='Graph']")
	WebElement graphBtn;
	@FindBy(xpath = "//div[@role='alert']")
	WebElement homeLogMessage;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement logInMessage;

	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement dataStructureGetStartedBtn;
	@FindBy(xpath = "//a[@href='array']")
	WebElement arrayGetStartedBtn;
	@FindBy(xpath = "//a[@href='linked-list']")
	WebElement linkedListGetStartedBtn;
	@FindBy(xpath = "//a[@href='stack']")
	WebElement stackGetStartedBtn;
	@FindBy(xpath = "//a[@href='queue']")
	WebElement queueGetStartedBtn;
	@FindBy(xpath = "//a[@href='tree']")
	WebElement treeGetStartedBtn;
	@FindBy(xpath = "//a[@href='graph']")
	WebElement graphGetStartedBtn;

	public Home_PageFactory() {
		PageFactory.initElements(driver, this);
	}

	public void launchUrl() {
		if (driver != null) {
			driver.get(ConfigReader.getApplicationUrl());
		} else {
			throw new RuntimeException("Driver is not initialized in Home_PageFactory!");
		}
	}

	public void getStartedHomeBtnClick() {
		getStartedHomeBtn.click();
	}

	public boolean dataStructureDropDownDisplayed() {
		return dataStructureDropDown.isDisplayed();
	}

	public void dataStructureDropDownClick() {
		dataStructureDropDown.click();
	}

	public String getHomeLogMessage() {
		return homeLogMessage.getText();
	}

	public void arraysBtnClick() {
		arraysBtn.click();
	}

	public void linkedListBtnClick() {
		linkedListBtn.click();
	}

	public void stackBtnClick() {
		stackBtn.click();
	}

	public void queueBtnClick() {
		queueBtn.click();
	}

	public void treeBtnClick() {
		treeBtn.click();
	}

	public void graphBtnClick() {
		graphBtn.click();
	}

	public boolean dataStructureGetStartedBtn() {
		return dataStructureGetStartedBtn.isDisplayed();
	}

	public void dataStructureGetStartedBtnClick() {
		dataStructureGetStartedBtn.click();
	}

	public void arraysGetStartedClick() {
		arrayGetStartedBtn.click();
	}

	public void linkedListGetStartedBtnClick() {
		linkedListGetStartedBtn.click();
	}

	public void stackGetStartedBtnClick() {
		stackGetStartedBtn.click();
	}

	public void queueGetStartedBtn() {
		queueGetStartedBtn.click();
	}

	public void treeGetStartedBtn() {
		treeGetStartedBtn.click();
	}

	public void graphGetStartedBtn() {
		graphGetStartedBtn.click();
	}

}
