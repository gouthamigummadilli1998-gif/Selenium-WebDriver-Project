package com.adactinhotelapp.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	 @DataProvider(name = "loginData")
	    public Object[][] getLoginData() throws IOException {

	        String filePath =
	                "src\\test\\resources\\testdata\\excels\\MasterTest1.xlsx";//taking xl file from the test data

	        ExcelUtils.setExcelFile(filePath, "Sheet1");//creating an object for XLUtility

	        int rowCount = ExcelUtils.getRowCount();
	        int columnCount = ExcelUtils.getColumnCount();

	        // -1 because first row contains column headers
	        Object[][] data = new Object[rowCount - 1][columnCount];

	        for (int i = 1; i < rowCount; i++) {

	            for (int j = 0; j < columnCount; j++) {

	                data[i - 1][j] =
	                        ExcelUtils.getCellData(i, j);
	            }
	        }

	        ExcelUtils.closeExcel();

	        return data;
	    }

}

