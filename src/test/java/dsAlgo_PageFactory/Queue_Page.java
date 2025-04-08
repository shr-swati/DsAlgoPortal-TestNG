package dsAlgo_PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_Utilities.ConfigReader;

public class Queue_Page {
	
	
	WebDriver driver= DriverFactory.getDriver();
	ConfigReader configFileReader=DriverFactory.configReader();
	

	@FindBy(xpath = "//a[@href='queue']")
	@CacheLookup
	WebElement getStartedButton;

	@FindBy(xpath = "//a[@href='implementation-lists']")
	@CacheLookup
	WebElement implementationOfQueueInPython;

	@FindBy(xpath = "//a[normalize-space()='Try here>>>']")
	WebElement tryHereBtn;

	@FindBy(xpath = "//button[text()='Run']")
	WebElement RunButton;

	@FindBy(xpath = "//a[text()='Sign out']")
	WebElement signOut;

	@FindBy(xpath = "//pre[@id='output']")
	WebElement result;

	@FindBy(xpath = "//a[@href='implementation-collections']")
	WebElement implementationUsingCollectionsDeque;

	@FindBy(xpath = "//a[@href='Implementation-array']")
	WebElement implementationUsingArray;

	@FindBy(xpath = "//a[@href='QueueOp']")
	WebElement queueOperations;

	@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea")
	WebElement text_area;

	@FindBy(xpath = "//a[@href='/queue/practice']")
	WebElement practiceQuestions;

	// Constructor
	public Queue_Page() {
		PageFactory.initElements(driver, this);

	}
	
	

	public void clickGetStartedButton() {
		getStartedButton.click();

	}

	public void clickImplementationOfQueueInPython() {
		implementationOfQueueInPython.click();

	}

	public void clickImplementationUsingCollectionsDeque() {
		implementationUsingCollectionsDeque.click();
	}

	public void clickImplementationUsingArray() {
		implementationUsingArray.click();
	}

	public void clickQueueOperations() {
		queueOperations.click();
	}

	public void goToQueuePage() {
		clickGetStartedButton();

	}

	public void tryHereBtn() {

		tryHereBtn.click();

	}

	public void textAreaSendKey(String input) {
		System.out.println("inside textAreaSendKey");
		text_area.sendKeys(input);
	}

	public void clickPracticeQuestions() {
		practiceQuestions.click();
	}

	public void runButtonClick() {
		RunButton.click();

	}

	public String resultOutput() {
		return result.getText();

	}

	public void clickSignOut() {
		signOut.click();
	}



	
	public void clickVisibleQuestions() {
		WebElement visibleQuestions = null;
		visibleQuestions.click();	
	

	}

	public void closebrowser() {
		driver.quit();
		
		
	}

	
		
	}

		

	
