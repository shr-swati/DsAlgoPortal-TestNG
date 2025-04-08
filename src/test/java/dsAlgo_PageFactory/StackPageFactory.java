package dsAlgo_PageFactory;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.LoggerReader;
import dsAlgo_Utilities.TryEditor;

public class StackPageFactory {
	
	WebDriver driver = DriverFactory.getDriver();
	ConfigReader configFileReader = DriverFactory.configReader();
	TryEditor readTryEditor = new TryEditor();

	String get_alert_msg;
	String expectedOutput;
	String errorMsg;

	String ExpectedFromTestcaseOne;
	String output;
	String input ;
	
	public StackPageFactory() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
	       return driver.getTitle();
			
	    }

	
	 @FindBy (xpath="//a[@href='stack']") WebElement stackGetStarted;	
	 
	 @FindBy (xpath="//a[normalize-space()='Operations in Stack']") WebElement operationInStack;
	 
	 @FindBy (xpath="//a[normalize-space()='Try here>>>']") WebElement try_here;
	 
	 @FindBy (xpath="//form[@id='answer_form']/div/div/div/textarea") WebElement StackTryEditor;
	 
	 @FindBy (xpath="//button[normalize-space()='Run']") WebElement runButton;
	 
	@FindBy ( linkText = "Implementation") WebElement ImplementationLink;

	@FindBy ( linkText = "Applications") WebElement ApplicationLink;

	@FindBy (xpath="//a[normalize-space()='Implementation']")WebElement Implementation;

	@FindBy (xpath="//a[normalize-space()='Applications']")WebElement Application;

	@FindBy (xpath = "//div[contains(@class, 'CodeMirror') and contains(@class, 'cm-s-default')]") WebElement codeMirror;

	@FindBy (id="output") WebElement OutputWindow;

	@FindBy (xpath="//a[text()='Search the Stack']")WebElement PracticeQuestionsStack;

	@FindBy(xpath="//a[normalize-space()='Practice Questions']")WebElement PracticeQuestions;

	@FindBy (xpath="//pre[@id='output']") WebElement result;
	
	@FindBy(tagName = "body") WebElement htmlBodyContent;
	
	@FindBy (xpath=".//textarea") WebElement text_area;
		
	public void stackGetStarted() {
		stackGetStarted.click();
	}

	public void operationInStack() {
		operationInStack.click();
	}
	public void tryHereBtn() {
		try_here.click();
	}
	public void stackTryEditor() {
		StackTryEditor.click();
	}
	public void runButton() {
		runButton.click();
	}	
	public void Implementation() {
		Implementation.click();
		     
		   }
	public void Applications() {
		     Application.click();	
	}
	public void PracticeQuestions() {
		 PracticeQuestions.click();
	}
	public boolean OperationsinStacklinkEnabled() {
		 return operationInStack.isEnabled();
	  }
	  public boolean ImplementationLinkEnabled() {
		 return ImplementationLink.isEnabled();
	  }
	  public boolean ApplicationLinkEnabled() {
		 return ApplicationLink.isEnabled();
	  }
	  public boolean OutputWindowDisplayed() {
			 return OutputWindow.isDisplayed();
		   }
	  public boolean PracticeQuestionsStackDisplayed() {
			 return PracticeQuestionsStack.isDisplayed();
	  }
	  public String htmlBodyContent() {
			String htmlBodyText = htmlBodyContent.getText();
			return htmlBodyText;
		}
	  
	  public void textAreaSendKey(String input) {
			System.out.println("inside textAreaSendKey  :  " +input);
			//text_area.sendKeys(input);
			
			WebElement textArea = codeMirror.findElement(By.xpath(".//textarea"));
			   textArea.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			   textArea.sendKeys(input);
			
			
			
		}
	  
	  public void runButtonClick() {
		  runButton.click();

		}
	  
	  public String resultOutput() {
			return result.getText();

		}
	  
	  public void assertLogging(String pageTitleExpected, String pageTitleActual) {
		  Assert.assertEquals(pageTitleExpected, pageTitleActual);
	  }
	  
}