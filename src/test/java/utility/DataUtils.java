package utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import base.BaseTest;

public class DataUtils extends BaseTest {

	@DataProvider(name="Data")
	public Object[][] getData(Method m){
		
		
		String sheetName=m.getName();
		int noOfRows = excel.getRowCount(sheetName);//3
		int noOfCols = excel.getColumnCount(sheetName);//2
		
		Object[][] credentials = new Object[noOfRows-1][noOfCols];
		
		for(int row=2;row<=noOfRows;row++) {//3
			for(int col = 0;col<noOfCols;col++) {
				credentials[row-2][col] = excel.getCellData(sheetName, col,row);//0,2
			}
		}
		return credentials;
	}
}
