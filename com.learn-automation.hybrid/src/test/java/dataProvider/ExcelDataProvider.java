package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	FileOutputStream fout;
	File src;
	
	
	/*@AfterClass
	public void closeExcel()
	{
		try {
			wb.close();
			System.out.println("here close excel method is executed");
		} catch (IOException e) {
			System.out.println("unable to close excel file");
		}
	}
	*/
	
	
	
	
	@Test
	public ExcelDataProvider()
	{
		 src = new File(System.getProperty("user.dir")+"/TestData/Data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb= new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("unable to load excel Data file");
			System.out.println("error in loading excel data file is ** "+e.getMessage());
		
		}
		
		
	}

	public String getStringData(String sheetName,int row,int col)
	{
		String myData = wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		return myData;
	}

	
	
	public void writeData(String sheetName,int row,int col,String mydata)
	{
		try {
			fout= new FileOutputStream(src);
		} catch (FileNotFoundException e) {
			System.out.println("unable to load excel file for writing");
			
		}
		wb.getSheet(sheetName).getRow(row).createCell(col).setCellValue(mydata);
		try {
			wb.write(fout);
			wb.close();
			

		} catch (IOException e) {
			System.out.println("unable to save excel file "+e.getMessage());
			
		}
		
	}

	

	}



