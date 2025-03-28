package dsAlgo_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static ConfigReader configFileReader = new ConfigReader();
	public static String[] excelDataRead(String sheetName, int rowNumber) throws IOException {
	
	String path = configFileReader.getExcelPath();
	File excelFile = new File(path);
	
	FileInputStream Fis = new FileInputStream(excelFile);
	XSSFWorkbook workbook = new XSSFWorkbook(Fis);
	XSSFSheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rowNumber); 
        

	int columnCount = row.getLastCellNum();
    String[] credentials = new String[columnCount];

    for (int i = 0; i < columnCount; i++) {
        credentials[i] = getCellValue(row, i); 
    }
    
    workbook.close();
    Fis.close();
    return credentials;  
	}

	private static String getCellValue(Row row, int cellIndex) {

	    Cell cell = row.getCell(cellIndex);
	    if (cell == null || cell.getCellType() == CellType.BLANK) {
	        return ""; 
	    }
	    if (cell.getCellType() == CellType.NUMERIC) {
	        return String.valueOf(cell.getNumericCellValue());
	    }
	    if (cell.getCellType() == CellType.STRING) {
	        return cell.getStringCellValue();
	    }
	    return "";
	}
}