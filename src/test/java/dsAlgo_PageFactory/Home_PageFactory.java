package dsAlgo_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.TryEditor;

public class Home_PageFactory{

	WebDriver driver= DriverFactory.getDriver();
	ConfigReader configFileReader=DriverFactory.configReader();
	TryEditor readTryEditor = new TryEditor();
		
		@FindBy ( xpath ="//button[@class='btn']") WebElement getStartedHomeBtn;
		@FindBy ( xpath = "//h1[text()='Preparing for the Interviews']") WebElement randomClick;
		@FindBy ( xpath = "//a[text()='Data Structures']") WebElement dataStructureDropDown;
		@FindBy ( xpath = "//a[text()='Arrays']") WebElement arraysBtn;
		@FindBy ( xpath = "//a[text()='Linked List']") WebElement linkedListBtn;
		@FindBy ( xpath = "//a[text()='Stack']") WebElement stackBtn;
		@FindBy ( xpath = "//a[text()='Queue']") WebElement queueBtn;
		@FindBy ( xpath = "//a[text()='Tree']") WebElement treeBtn;
		@FindBy ( xpath = "//a[text()='Graph']") WebElement graphBtn;
		@FindBy ( xpath = "//div[contains(text(),'logged in')]") WebElement homeLogMessage;
		
		@FindBy ( xpath = "//div[h5[text()='Data Structures-Introduction']]//a[text()='Get Started']") WebElement dataStructureGetStartedBtn;
		@FindBy ( xpath = "//div[h5[text()='Array']]//a[text()='Get Started']") WebElement arrayGetStartedBtn;
		@FindBy ( xpath = "//div[h5[text()='Linked List']]//a[text()='Get Started']") WebElement linkedListGetStartedBtn;
		@FindBy ( xpath = "//div[h5[text()='Stack']]//a[text()='Get Started']") WebElement stackGetStartedBtn;
		@FindBy ( xpath = "//div[h5[text()='Queue']]//a[text()='Get Started']") WebElement queueGetStartedBtn;
		@FindBy ( xpath = "//div[h5[text()='Tree']]//a[text()='Get Started']") WebElement treeGetStartedBtn;
		@FindBy ( xpath = "//div[h5[text()='Graph']]//a[text()='Get Started']") WebElement graphGetStartedBtn;

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
			
		public String getHomeLogMessage() {
		    return homeLogMessage.getText();    
		}
		
		public void dataStructureDropDownClick() {
			dataStructureDropDown.click();
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
}