package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	@DataProvider(name="LoginData")
	public String [] [] getData() throws IOException
	{
		//String path=".\\testData\\login_data.xlsx";
		
		String path="C:\\New folder\\Pom\\testData\\login_data.xlsx";
		DataUtility xlult=new DataUtility(path);
		int totalrows=xlult.getRowCount("Sheet1");
		int totalclos=xlult.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String [totalrows][totalclos];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalclos;j++)
			{
				logindata[i-1][j]=xlult.getCellData("Sheet1", i, j);
				//array index value start from zero. i value initial start from 1, if we don't use -1, memory space of array index value=0 
				//we can't use that memory space in loop, so we shouldn't waste memory positin. sometime we facing excaptional case also.
			}
		}
	return logindata;
	}

}
