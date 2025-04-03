package dsAlgo_TestClasses;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.ArrayPageFactory;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_Utilities.LoggerReader;

@Listeners(dsAlgo_Utilities.ListenersReporter.class)

public class ArrayTest extends BaseClass {
	
	private String username;
    private String password;
	String ExpectedOutput;
	
	ArrayPageFactory arrayPage;
	Home_PageFactory homePageFactory;
	Login_PageFactory loginPageFactory;

	
	public ArrayTest() throws IOException {
		Object[][] userLoginData = validLoginDataBaseClass();
	     this.username = userLoginData[0][0].toString();
        this.password = userLoginData[0][1].toString();
	
	}
	
	@Test(priority=1)
	public void LogIn() throws IOException, InterruptedException {
		arrayPage = new ArrayPageFactory();
		validLogin(username, password);
		 LoggerReader.info("User is logged in into Dsalgo portal");
		}
	
	@Test(priority=2)
	public void arrayGetStarted() throws InterruptedException, IOException {
		LogIn();
		LoggerReader.info("User is navigate to Array page after clicking on Array get started button 2");
	}
	
	@Test(priority=3)
	public void arrayInArrayPage() throws InterruptedException, IOException {
		arrayGetStarted();
		arrayPage.getStartedArray();
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Array", pgTitle);
		LoggerReader.info("User is navigate to Array page after clicking on Array get started button 3");
	}
	
	@Test(priority=4)
	public void arrayInPython() throws InterruptedException, IOException {
		arrayInArrayPage();
		arrayPage.clickArrayInPython();
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Arrays in Python", pgTitle);
	}
		
	@Test(priority=5)
	public void arrayTryEditor() throws InterruptedException, IOException {
		arrayInPython();
		arrayPage.tryHereBtnArrayInPython();
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}	

	@Test(priority=6)
	public void arrayTryEditorSendValidOne() throws InterruptedException, IOException {
		arrayTryEditor();
		arrayPage.readExcelRun("Array", 1);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}		
	@Test(priority=7)
	public void arrayTryEditorSendInvalidOne() throws InterruptedException, IOException {
		arrayTryEditor();
		arrayPage.readExcelRun("Array", 2);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}
	
	@Test(priority=8)
	public void tryEditorArrayUsingList() throws InterruptedException, IOException {
		arrayInArrayPage();
		arrayPage.arrayUsingList();
		arrayPage.tryEditorArrayUsingList();
	}		
	@Test(priority=9)
	public void tryEditorArrayUsingListValid() throws InterruptedException, IOException {
		tryEditorArrayUsingList();
		arrayPage.readExcelRun("Array", 3);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}			

	@Test(priority=10)
	public void tryEditorArrayUsingListInValid() throws InterruptedException, IOException {
		tryEditorArrayUsingList();
		arrayPage.readExcelRun("Array", 4);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}	
	
	@Test(priority=11)
	public void tryEditorBasicOperationsInLists() throws InterruptedException, IOException {
		arrayInArrayPage();
		arrayPage.basicOperationInList();
		arrayPage.tryEditorBasicOperationInList();
	}	

	@Test(priority=12)
	public void tryEditorBasicOperationsInListsValid() throws InterruptedException, IOException {
		tryEditorBasicOperationsInLists();
		arrayPage.readExcelRun("Array", 5);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}			

	@Test(priority=13)
	public void tryEditorBasicOperationsInListsInValid() throws InterruptedException, IOException {
		tryEditorBasicOperationsInLists();
		arrayPage.readExcelRun("Array", 6);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}
	
	
	@Test(priority=14)
	public void tryEditorApplicationsOfArray() throws InterruptedException, IOException {
		arrayInArrayPage();
		arrayPage.applicationOfArray();
		arrayPage.applicationOfArrayTryEditor();
	}	
	
	@Test(priority=15)
	public void tryEditorApplicationsOfArrayValid() throws InterruptedException, IOException {
		tryEditorApplicationsOfArray();
		arrayPage.readExcelRun("Array", 7);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}			

	@Test(priority=16)
	public void tryEditorApplicationsOfArrayInValid() throws InterruptedException, IOException {
		tryEditorApplicationsOfArray();
		arrayPage.readExcelRun("Array", 8);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}
	
	@Test(priority=17)
	public void tryEditorPracticeQuestion() throws InterruptedException, IOException {
		arrayInPython();
		arrayPage.practiceQuestions();
		arrayPage.practiceQuestionsSearchTheArray();
	}	
	
	@Test(priority=18)
	public void tryEditorPracticeQuestionSearchTheArrayValid() throws InterruptedException, IOException {
		tryEditorPracticeQuestion();
		arrayPage.readExcelRun("Array", 9);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}
	
	@Test(priority=20)
	public void tryEditorPracticeQuestionSearchTheArraySubmit() throws InterruptedException, IOException {
		tryEditorPracticeQuestion();
		arrayPage.readExcelSubmit("Array", 10);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}	
	
	@Test(priority=19)
	public void tryEditorPracticeQuestionSearchTheArrayInValid() throws InterruptedException, IOException {
		tryEditorPracticeQuestion();
		arrayPage.readExcelRun("Array", 11);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}	
	
	@Test(priority=20)
	public void tryEditorPracticeQuestionFindMaxConsecutive() throws InterruptedException, IOException {
		arrayInPython();
		arrayPage.practiceQuestions();
		arrayPage.maxConsecutiveOnes();
	}
	
	@Test(priority=21)
	public void tryEditorPracticeQuestionFindMaxConsecutiveValid() throws InterruptedException, IOException {
		tryEditorPracticeQuestionFindMaxConsecutive();
		arrayPage.readExcelRun("Array", 12);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}
	
	@Test(priority=22)
	public void tryEditorPracticeQuestionFindMaxConsecutiveSubmit() throws InterruptedException, IOException {
		tryEditorPracticeQuestionFindMaxConsecutive();
		arrayPage.readExcelSubmit("Array", 13);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}	
	
	@Test(priority=23)
	public void tryEditorPracticeQuestionFindMaxConsecutiveInValid() throws InterruptedException, IOException {
		tryEditorPracticeQuestionFindMaxConsecutive();
		arrayPage.readExcelRun("Array", 14);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}
	
	@Test(priority=24)
	public void tryEditorPracticeQuestionFindNumber() throws InterruptedException, IOException {
		arrayInPython();
		arrayPage.practiceQuestions();
		arrayPage.findEvennumberDigits();
	}
	
	@Test(priority=25)
	public void tryEditorPracticeQuestionFindNumberValid() throws InterruptedException, IOException {
		tryEditorPracticeQuestionFindNumber();
		arrayPage.readExcelRun("Array", 15);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}
	
	@Test(priority=26)
	public void tryEditorPracticeQuestionFindNumberSubmit() throws InterruptedException, IOException {
		tryEditorPracticeQuestionFindNumber();
		arrayPage.readExcelSubmit("Array", 16);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}	
	
	@Test(priority=27)
	public void tryEditorPracticeQuestionFindNumberInValid() throws InterruptedException, IOException {
		tryEditorPracticeQuestionFindNumber();
		arrayPage.readExcelRun("Array", 17);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}	

	@Test(priority=28)
	public void tryEditorPracticeQuestionSortedSquare() throws InterruptedException, IOException {
		arrayInPython();
		arrayPage.practiceQuestions();
		arrayPage.squareSortedArray();
	}
	
	@Test(priority=29)
	public void tryEditorPracticeQuestionSortedSquareValid() throws InterruptedException, IOException {
		tryEditorPracticeQuestionSortedSquare();
		arrayPage.readExcelRun("Array", 18);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}
	
	@Test(priority=30)
	public void tryEditorPracticeQuestionSortedSquareSubmit() throws InterruptedException, IOException {
		tryEditorPracticeQuestionSortedSquare();
		arrayPage.readExcelSubmit("Array", 19);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}	
	
	@Test(priority=31)
	public void tryEditorPracticeQuestionSortedSquareInValid() throws InterruptedException, IOException {
		tryEditorPracticeQuestionSortedSquare();
		arrayPage.readExcelRun("Array", 20);
		String pgTitle = arrayPage.getTitle();
		Assert.assertEquals("Assessment", pgTitle);
	}	
	
	
}
