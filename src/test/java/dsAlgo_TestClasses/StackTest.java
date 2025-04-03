package dsAlgo_TestClasses;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_PageFactory.StackPageFactory;
import dsAlgo_Utilities.LoggerReader;

@Listeners(dsAlgo_Utilities.ListenersReporter.class)
public class StackTest extends BaseClass {

	Home_PageFactory homePage;
	Login_PageFactory loginPage;
	StackPageFactory stackPageFactory;

	private String username;
	private String password;
	
	public StackTest() throws IOException {
		Object[][] userLoginData = validLoginDataBaseClass();
	     this.username = userLoginData[0][0].toString();
        this.password = userLoginData[0][1].toString();
	
	}


	@Test (priority=1)
	public void callValidLogInData() throws InterruptedException {
		stackPageFactory = new StackPageFactory();
		validLogin(username, password);
		LoggerReader.info("Logging Clicked on GetStarted button under Stack section");
	}

	@Test (priority=2)
	public void operationsInStack() throws IOException,InterruptedException { 
		callValidLogInData();
		stackPageFactory.stackGetStarted();
		stackPageFactory.operationInStack();
		stackPageFactory.assertLogging("Operations in Stack", stackPageFactory.getTitle());
		LoggerReader.info("On Operation in Stack Page");
	}

	@Test (priority=3)
	public void operationsInStackTryEditor() throws IOException,InterruptedException { 
		operationsInStack();
		stackPageFactory.tryHereBtn();		
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());		
		LoggerReader.info("On Operation in Stack Page Try Editor");
	}	
	
	@Test (priority=4)
	public void stackTryEditor() throws IOException,InterruptedException { 
		operationsInStackTryEditor();
		stackPageFactory.tryEditorWindow("TryEditor", 1);	
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());		
		LoggerReader.info("On Operation in Stack Page Try Editor row 1 ");
	}	
	
	@Test (priority=5)
	public void stackTryEditorInvalid() throws IOException,InterruptedException { 
		stackTryEditor();
		stackPageFactory.tryEditorWindow("TryEditor", 2);	
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());		
		LoggerReader.info("On Operation in Stack Page Try Editor row 2 ");
	}	
	
	@Test (priority=6)
	public void implementation() throws IOException,InterruptedException { 
		callValidLogInData();
		stackPageFactory.stackGetStarted();
		stackPageFactory.Implementation();
		stackPageFactory.assertLogging("Implementation", stackPageFactory.getTitle());
		LoggerReader.info("On Implementation Page");
	}
	
	@Test (priority=7)
	public void implementationTryEditor() throws IOException,InterruptedException { 
		implementation();
		stackPageFactory.tryHereBtn();		
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());		
		LoggerReader.info("On implementation Page Try Editor");
	}
	@Test (priority=8)
	public void implementationTryEditorValid() throws IOException,InterruptedException { 
		implementationTryEditor();
		stackPageFactory.tryEditorWindow("TryEditor", 1);	
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());		
		LoggerReader.info("On implementationTryEditor Page Try Editor row 1 ");
	}	
	@Test (priority=9)
	public void implementationTryEditorInvalid() throws IOException,InterruptedException { 
		implementationTryEditorValid();
		stackPageFactory.tryEditorWindow("TryEditor", 2);	
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());		
		LoggerReader.info("On implementationTryEditor Page Try Editor row 2 ");
	}	
	@Test (priority=10)
	public void applications() throws IOException,InterruptedException { 
		callValidLogInData();
		stackPageFactory.stackGetStarted();
		stackPageFactory.Applications();
		stackPageFactory.assertLogging("Applications", stackPageFactory.getTitle());
		LoggerReader.info("On Applications Page");
	}
	@Test (priority=11)
	public void applicationsTryEditor() throws IOException,InterruptedException { 
		applications();
		stackPageFactory.tryHereBtn();		
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());		
		LoggerReader.info("On applications Page Try Editor");
	}
	@Test (priority=12)
	public void applicationsTryEditorValid() throws IOException,InterruptedException { 
		applicationsTryEditor();
		stackPageFactory.tryEditorWindow("TryEditor", 1);	
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());		
		LoggerReader.info("On applicationsTryEditor Page Try Editor row 1 ");
	}	
	@Test (priority=13)
	public void applicationsTryEditorInvalid() throws IOException,InterruptedException { 
		applicationsTryEditorValid();
		stackPageFactory.tryEditorWindow("TryEditor", 2);	
		stackPageFactory.assertLogging("Assessment", stackPageFactory.getTitle());		
		LoggerReader.info("On applicationsTryEditor Page Try Editor row 2 ");
	}	 
    
	@Test (priority=14)
	public void PracticeQuestions() throws IOException,InterruptedException { 
		operationsInStack();
		stackPageFactory.PracticeQuestions();
		stackPageFactory.assertLogging("Practice Questions", stackPageFactory.getTitle());
		LoggerReader.info("On PracticeQuestions Page");
	}
}
