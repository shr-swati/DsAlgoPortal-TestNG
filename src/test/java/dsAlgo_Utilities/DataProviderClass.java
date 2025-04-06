package dsAlgo_Utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;


public class DataProviderClass {
	
	@DataProvider(name = "invalidLoginDataBothFeilds")
	public static String[][] invalidLoginDataBothFeilds() throws IOException {
	String sheetName = "Login";
	int rowCount = 2;
	String[][] userData = new String[rowCount][2];
	for (int i = 0; i < rowCount; i++) {
		userData[i] = ExcelReader.excelDataRead(sheetName, i + 1);
	}
	return userData;
}
	@DataProvider(name = "invalidLoginDataBlankFeild")
	public static String[][] invalidLoginDataBlankFeild() throws IOException {
	String sheetName = "Login";
	int rowCount = 2;
	String[][] userData = new String[rowCount][2];
	for (int i = 0; i < rowCount; i++) {
		userData[i] = ExcelReader.excelDataRead(sheetName, i + 3);
	}
	return userData;
}

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
	
		
	}