package testnglearning;

import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelReader;

public class TestParameterizationDataPRovider {

	

	@Test(dataProvider = "getData")
	public void doLogin(String username, String password) throws InterruptedException {

		Date d = new Date();
		System.out.println(d);
	System.out.println(username+"----"+password);
	Thread.sleep(2000);
	}

	@DataProvider(parallel=true)
	public Object[][] getData() {

		ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");

		String sheetName = "LoginTest";

		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);

		System.out.println(excel.getCellData(sheetName, 0, 2));

		Object[][] data = new Object[rowNum - 1][colNum];

		System.out.println("Total rows are : " + rowNum + "---Total cols are : " + colNum);

		for (int rows = 2; rows <= rowNum; rows++) {

			for (int cols = 0; cols < colNum; cols++) {
				// 0 2
				// 0 0
				// 0 1
				// 1
				data[rows - 2][cols] = excel.getCellData(sheetName, cols, rows);

			}

		}

		/*
		 * data[0][0] = excel.getCellData(sheetName, 0, 2); data[0][1] =
		 * excel.getCellData(sheetName, 1, 2);
		 * 
		 * 
		 * data[1][0] = excel.getCellData(sheetName, 0, 3); data[1][1] =
		 * excel.getCellData(sheetName, 1, 3);
		 * 
		 * 
		 * data[2][0] = excel.getCellData(sheetName, 0, 4); data[2][1] =
		 * excel.getCellData(sheetName, 1, 4);
		 */
		return data;
	}

}
