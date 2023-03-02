package dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	@DataProvider(name = "loginDataSet")
	public static Object[][] getData() {

		Object arr[][] = ExcelReader.getDataFromSheet("login");
		return arr;
	}

}
