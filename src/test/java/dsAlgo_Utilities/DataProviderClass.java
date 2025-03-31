package dsAlgo_Utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;
//import dsAlgo_Utilities.ExcelReader;
//import dsAlgo_Utilities.TryEditor;

public class DataProviderClass {
	/*
	 * @DataProvider(name = "registerUserName") public static String[][]
	 * registerUserName() throws IOException { String sheetName = "Register"; int
	 * rowCount = 4; String[][] userData = new String[rowCount][4]; for (int i = 0;
	 * i < rowCount; i++) { userData[i] = ExcelReader.excelDataRead(sheetName, i +
	 * 1); } return userData; }
	 * 
	 * @DataProvider(name = "registerPassword") public static String[][]
	 * registerPassword() throws IOException { String sheetName = "Register"; int
	 * rowCount = 4; String[][] userData = new String[rowCount][4]; for (int i = 0;
	 * i < rowCount; i++) { userData[i] = ExcelReader.excelDataRead(sheetName, i +
	 * 5); } return userData; }
	 * 
	 * @DataProvider(name = "registerInvalidUserName") public static String[][]
	 * registerInvalidUserName() throws IOException { String sheetName = "Register";
	 * int rowCount = 2; String[][] userData = new String[rowCount][4]; for (int i =
	 * 0; i < rowCount; i++) { userData[i] = ExcelReader.excelDataRead(sheetName, i
	 * + 9); } return userData; }
	 * 
	 * @DataProvider(name = "registerInvalidPassword") public static String[][]
	 * registerInvalidPassword() throws IOException { String sheetName = "Register";
	 * int rowCount = 3; String[][] userData = new String[rowCount][4]; for (int i =
	 * 0; i < rowCount; i++) { userData[i] = ExcelReader.excelDataRead(sheetName, i
	 * +11); } return userData; }
	 * 
	 * @DataProvider(name = "registerBlankFields") public static String[][]
	 * registerBlankFields() throws IOException { String sheetName = "Register"; int
	 * rowCount = 3; String[][] userData = new String[rowCount][4]; for (int i = 0;
	 * i < rowCount; i++) { userData[i] = ExcelReader.excelDataRead(sheetName, i
	 * +14); } return userData; }
	 * 
	 * @DataProvider(name = "registerValidData") public static String[][]
	 * registerValidData() throws IOException { String sheetName = "Register"; int
	 * rowCount = 1; String[][] userData = new String[rowCount][4]; for (int i = 0;
	 * i < rowCount; i++) { userData[i] = ExcelReader.excelDataRead(sheetName, i
	 * +17); } return userData; }
	 * 
	 * @DataProvider(name = "registerBugPassword") public static String[][]
	 * registerBugPassword() throws IOException { String sheetName = "Register"; int
	 * rowCount = 1; String[][] userData = new String[rowCount][4]; for (int i = 0;
	 * i < rowCount; i++) { userData[i] = ExcelReader.excelDataRead(sheetName, i
	 * +18); } return userData; }
	 * 
	 * @DataProvider(name = "invalidLoginData") public static String[][]
	 * invalidLoginData() throws IOException { String sheetName = "Login"; int
	 * rowCount = 2; String[][] userData = new String[rowCount][3]; for (int i = 0;
	 * i < rowCount; i++) { userData[i] = ExcelReader.excelDataRead(sheetName, i +
	 * 1); } return userData; }
	 * 
	 * @DataProvider(name ="loginBlank") public static String[][] loginBlank()
	 * throws IOException { String sheetName = "Login"; int rowCount = 2; String[][]
	 * userData = new String[rowCount][3]; for (int i = 0; i < rowCount; i++) {
	 * userData[i] = ExcelReader.excelDataRead(sheetName, i + 3); } return userData;
	 * }
	 */
	@DataProvider(name = "validLoginData")
	public static String[][] loginData() throws IOException {
		String sheetName = "Valid_Login";
		int rowCount = 1;
		String[][] userData = new String[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			userData[i] = ExcelReader.excelDataRead(sheetName, i + 1);
		}
		return userData;
	}

	@DataProvider(name = "logOutData")
	public static String[][] logOutData() throws IOException {
		String sheetName = "Valid_Login";
		int rowCount = 1;
		String[][] userData = new String[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			userData[i] = ExcelReader.excelDataRead(sheetName, i + 1);
		}
		return userData;
	}

	@DataProvider(name = "validPythonCode")
	public static String[][] validPythonCode() throws IOException {
		String sheetName = "TryEditor";
		int rowCount = 1;
		String[][] userData = new String[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			userData[i] = ExcelReader.excelDataRead(sheetName, i + 1);
		}
		return userData;
	}

	@DataProvider(name = "invalidPythonCode")
	public static String[][] invalidPythonCode() throws IOException {
		String sheetName = "TryEditor";
		int rowCount = 5;
		String[][] userData = new String[rowCount][2];
		for (int i = 0; i <rowCount; i++) {
			userData[i] = ExcelReader.excelDataRead(sheetName, i+2);
		}
		return userData;
	}
	
	
	
	
	@DataProvider(name = "blankRow")
	public static String[] blankRow () throws IOException {
		String sheetName = "TryEditor";
		int rowCount = 7;
		String[] userData;
	    userData = ExcelReader.excelDataRead(sheetName, rowCount);
		
		return userData;
	}
	
	@DataProvider(name = "numericCode")
	public static String[] numericCode () throws IOException {
		String sheetName = "TryEditor";
		int rowCount = 8;
		String[] userData;
	    userData = ExcelReader.excelDataRead(sheetName, rowCount);
		
		return userData;
	
	
	
	}

}