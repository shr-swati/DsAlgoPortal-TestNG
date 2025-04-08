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
import org.openqa.selenium.interactions.Actions;
import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.LoggerReader;
import dsAlgo_Utilities.TryEditor;

public class ArrayPageFactory {
	WebDriver driver = DriverFactory.getDriver();
	ConfigReader configFileReader = DriverFactory.configReader();
	TryEditor readTryEditor = new TryEditor();

	String get_alert_msg;
	String expectedOutput;
	String errorMsg;

	String ExpectedFromTestcaseOne;
	String output;
	String input ;
	
	public ArrayPageFactory() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h4[text()='Array']") WebElement arrayDisplayTitle;
	
	@FindBy(xpath="//a[@href='array']") WebElement arrayGetStartedBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Try here>>>']") WebElement tryHereArrayInPython;
    
    @FindBy(xpath="//a[normalize-space()='Arrays in Python']") WebElement arrayInPython;
        
    @FindBy (xpath="//form[@id='answer_form']/div/div/div/textarea") WebElement text_area;
    
    @FindBy (xpath="//button[text()='Run']") WebElement RunButton;
    
    @FindBy (xpath="//pre[@id='output']") WebElement result;
    
    @FindBy (xpath="//a[normalize-space()='Arrays Using List']") WebElement arrayUsingList;
    
    @FindBy (xpath="//a[normalize-space()='Try here>>>']") WebElement tryEditorArrayUsingList;
    
    @FindBy (xpath="//a[normalize-space()='Basic Operations in Lists']") WebElement basicOperationInList;
    
    @FindBy (xpath="//a[normalize-space()='Try here>>>']") WebElement tryEditorBasicOperationInList;
    
    @FindBy (xpath="//a[normalize-space()='Applications of Array']") WebElement applicationOfArray;
    
    @FindBy (xpath="//a[normalize-space()='Try here>>>']") WebElement applicationOfArrayTryEditor;
    
    @FindBy (xpath="//a[normalize-space()='Practice Questions']") WebElement practiceQuestions;
    
    @FindBy (xpath="//a[normalize-space()='Search the array']") WebElement practiceQuestionsSearchTheArray;
    
    @FindBy (xpath="//div[@class='CodeMirror cm-s-default']") WebElement searchTheArray;
    
    @FindBy (name="code") WebElement textBoxEditor; 
    
	@FindBy(xpath = "//button[text()='Run']") WebElement arrayRunButton;
	
	@FindBy(xpath = "//input[@value='Submit']") WebElement SubmitBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Max Consecutive Ones']") WebElement maxConsecutiveOnes;
	
	@FindBy(xpath = "//a[normalize-space()='Find Numbers with Even Number of Digits']") WebElement findEvennumberDigits;
	
	@FindBy(xpath = "//a[contains(text(),'Squares of')]") WebElement squareSortedArray;
	
	
	public String getTitle() {
	       return driver.getTitle();
			
	    }
	
	public boolean arrayDisplayTitle() {
		return arrayDisplayTitle.isDisplayed();
	}
	
	public void getStartedArray() {
		arrayGetStartedBtn.click();
		
    }
	
	public void clickArrayInPython() {
		arrayInPython.click();
    }
	
	public void tryHereBtnArrayInPython() {
		tryHereArrayInPython.click();
	}
	
	public void textAreaSendKey() {
		
		System.out.println("inside textAreaSendKey");
		text_area.sendKeys(input);
	}
	
	public void textAreaClear() {
		text_area.clear();
	}
	
	public void runButtonClick() {
		RunButton.click();
	}
	
	
	public void arrayUsingList() {
		arrayUsingList.click();
	}
	
	public void tryEditorArrayUsingList() {
		tryEditorArrayUsingList.click();
	}
	
	public void basicOperationInList() {
		basicOperationInList.click();
	}
	
	public void tryEditorBasicOperationInList() {
		tryEditorBasicOperationInList.click();
	}
	
	public void applicationOfArray() {
		applicationOfArray.click();
	}
	
	public void applicationOfArrayTryEditor() {
		applicationOfArrayTryEditor.click();
	}
	public void practiceQuestions() {
		practiceQuestions.click();
	}
	
	public void practiceQuestionsSearchTheArray() {
		practiceQuestionsSearchTheArray.click();
	}
	
	public void textBoxEditor() {
		textBoxEditor.clear();
	}
	
	public boolean NavigateToTryHereBtn() {
		return arrayRunButton.isDisplayed();
	}
	
	public void SubmitBtn() {
		SubmitBtn.click();
	}
	
	public void maxConsecutiveOnes() {
		maxConsecutiveOnes.click();
	}
	
	public void findEvennumberDigits() {
		findEvennumberDigits.click();
	}
	
	public void squareSortedArray() {
		squareSortedArray.click();
	}
	
	public String getOutput() {
		return output;
	}
	
	
	
	public void readExcelRun(String sheetName, int rowNumber) throws IOException, InterruptedException {

		try {
			String[] editor = readTryEditor.excelTryEditor(sheetName, rowNumber);
			output = editor[1];
			WebElement codeMirror = driver.findElement(
					By.xpath("//div[contains(@class, 'CodeMirror') and contains(@class, 'cm-s-default')]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(codeMirror).click().perform();
			WebElement textArea = codeMirror.findElement(By.xpath(".//textarea"));
			enterCodePractice(editor[0], textArea);
			arrayRunButton.click();

			try {
				Alert alert = driver.switchTo().alert();
				String get_alert_msg = alert.getText();
				alert.accept();
				LoggerReader.info("Alert Is:" + get_alert_msg);
				assertTrue(get_alert_msg.contains(output));
			} catch (NoAlertPresentException e) {
				LoggerReader.info("No alert present:");
			} catch (UnhandledAlertException e) {
				LoggerReader.info("Unhandled alert exception: " + e.getMessage());
			}
		} finally {
			LoggerReader.info("ALert handled###");
		}
	}
	
	
	
	
	public void readExcelSubmit(String sheetName, int rowNumber) throws IOException, InterruptedException {

		try {
			String[] editor = readTryEditor.excelTryEditor(sheetName, rowNumber);
			output = editor[1];
			WebElement codeMirror = driver.findElement(
					By.xpath("//div[contains(@class, 'CodeMirror') and contains(@class, 'cm-s-default')]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(codeMirror).click().perform();
			WebElement textArea = codeMirror.findElement(By.xpath(".//textarea"));
			enterCodePractice(editor[0], textArea);
			SubmitBtn.click();

			try {
				Alert alert = driver.switchTo().alert();
				String get_alert_msg = alert.getText();
				alert.accept();
				LoggerReader.info("Alert Is:" + get_alert_msg);
				assertTrue(get_alert_msg.contains(output));
			} catch (NoAlertPresentException e) {
				LoggerReader.info("No alert present:");
			} catch (UnhandledAlertException e) {
				LoggerReader.info("Unhandled alert exception: " + e.getMessage());
			}
		} finally {
			LoggerReader.info("ALert handled###");
		}
	}
	

	public void enterCodePractice(String code, WebElement textArea) {
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").sendKeys(Keys.DELETE).keyUp(Keys.CONTROL).perform();
		String[] str1 = code.split("\n");
		for (int i = 0; i < str1.length; i++) {
			if (str1[i].equalsIgnoreCase("\\b")) {
				textArea.sendKeys(Keys.BACK_SPACE);
			} else {
				textArea.sendKeys(str1[i]);
				textArea.sendKeys(Keys.RETURN);
			}
			
		}
	}

	public void closebrowser() {
		driver.quit();
	}

}
