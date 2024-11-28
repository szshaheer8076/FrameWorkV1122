package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	/// data provider 1
	@DataProvider(name="LoginData")
	
	public String [] [] getData() throws IOException{
		
		String path=".\\testData\\LoginData.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrows = ExcelUtility.getRowCount("Sheet1");
		int totalrcols = xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String[totalrows][totalrcols];
		
		for(int i=1;i<totalrows;i++) {
			
			for(int j=0;j<totalrcols;j++) {
				
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i,j);
				
				
			}
		}
		
		return logindata;

		
	}
}
