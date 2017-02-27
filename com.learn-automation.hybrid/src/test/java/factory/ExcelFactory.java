package factory;

import dataProvider.ExcelDataProvider;

public class ExcelFactory {
	
	public static ExcelDataProvider setExcel()
	{
		ExcelDataProvider excelObj = new ExcelDataProvider();
		return excelObj;
	}

}
