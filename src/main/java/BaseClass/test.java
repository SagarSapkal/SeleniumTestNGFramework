package BaseClass;

import java.io.IOException;

public class test {
	
	  public static String[][] loginTestData() throws IOException {
		  String path = "C:\\Users\\Sagar Sapkal\\eclipse-workspace\\2022_TestNGFramework\\src\\test\\resources\\DataProvider.xlsx";
		ExcelUtility util = new ExcelUtility(path );
		int cellCount= util.getcellCount("sheet1", 1);
		int rowCount = util.getRowCount("sheet1");
		
		String loginData[][] = new String[rowCount][cellCount];
		
		for(int i=1; i<rowCount; i++) {
			
			for(int j=0; j<cellCount; j++) {
				
				loginData[i-1][j] =  util.getcellData("sheet1",i,j);
				System.out.println(loginData[i-1][j]+" ");
				
			}
		}
		return loginData;

		 
	  }

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		
		loginTestData();

		
		
		
	}

}
