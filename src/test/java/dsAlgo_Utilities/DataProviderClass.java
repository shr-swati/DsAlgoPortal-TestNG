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

	@DataProvider(name = "registerBothPwdBlank")
	public static String[][] registerBothPwdBlank() throws IOException {
		String sheetName = "Register";
		int rowCount = 4;
		String[][] userData = new String[rowCount][4];
		for (int i = 0; i < rowCount; i++) {
			userData[i] = ExcelReader.excelDataRead(sheetName, i + 1);
		}
		return userData;
	}

	@DataProvider(name = "registerUnameBlank")
	public static String[][] RegisterUnameBlank() throws IOException {
		String sheetName = "Register";
		int rowCount = 2;
		String[][] userData = new String[rowCount][3];
		for (int i = 0; i < rowCount; i++) {
			userData[i] = ExcelReader.excelDataRead(sheetName, i + 5);
		}
		return userData;
	}

	@DataProvider(name = "registerOnePwdBlank")
	public static String[][] RegisterOnePwdBlank() throws IOException {
		String sheetName = "Register";
		int rowCount = 2;
		String[][] userData = new String[rowCount][3];
		for (int i = 0; i < rowCount; i++) {
			userData[i] = ExcelReader.excelDataRead(sheetName, i + 7);
		}
		return userData;
	}

	@DataProvider(name = "registerInvalidUname")
	public static String[][] RegisterInvalidUname() throws IOException {
		String sheetName = "Register";
		int rowCount = 2;
		String[][] userData = new String[rowCount][3];
		for (int i = 0; i < rowCount; i++) {
			userData[i] = ExcelReader.excelDataRead(sheetName, i + 9);
		}
		return userData;
	}

	@DataProvider(name = "registerPwdLessLength")
	public static String[][] RegisterPwdLessLength() throws IOException {
		String sheetName = "Register";
		int rowCount = 1;
		String[][] userData = new String[rowCount][3];
		for (int i = 0; i < rowCount; i++) {
			userData[i] = ExcelReader.excelDataRead(sheetName, i + 11);
		}
		return userData;
	}

	@DataProvider(name = "registerPwdNumeric")
	public static String[][] RegisterPwdNumeric() throws IOException {
		String sheetName = "Register";
		int rowCount = 1;
		String[][] userData = new String[rowCount][3];
		for (int i = 0; i < rowCount; i++) {
			userData[i] = ExcelReader.excelDataRead(sheetName, i + 12);
		}
		return userData;
	}

	@DataProvider(name = "registerCommonPwd")
	public static String[][] RegisterCommonPwd() throws IOException {
		String sheetName = "Register";
		int rowCount = 1;
		String[][] userData = new String[rowCount][3];
		for (int i = 0; i < rowCount; i++) {
			userData[i] = ExcelReader.excelDataRead(sheetName, i + 13);
		}
		return userData;
	}

	@DataProvider(name = "registerValidData")
	public static String[][] RegisterValidData() throws IOException {
		String sheetName = "Register";
		int rowCount = 1;
		String[][] userData = new String[rowCount][3];
		for (int i = 0; i < rowCount; i++) {
			userData[i] = ExcelReader.excelDataRead(sheetName, i + 14);
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
		for (int i = 0; i < rowCount; i++) {
			userData[i] = ExcelReader.excelDataRead(sheetName, i + 2);
		}
		return userData;
	}

}