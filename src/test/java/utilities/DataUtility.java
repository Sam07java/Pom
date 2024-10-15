package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataUtility 
{
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;		
	String path;
	
		public DataUtility(String path)
		{
			this.path=path;
		}

		
public int getRowCount(String sheetName) throws IOException
{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetName);
	int rowcount=sheet.getLastRowNum();
	workbook.close();
	fi.close();
	return rowcount;			
}

public int getCellCount(String sheetName,int rownum) throws IOException
{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetName);
	
	row=sheet.getRow(rownum);
	int cellcount=row.getLastCellNum();
	workbook.close();
	fi.close();
	return cellcount;
}
	
public String getCellData(String sheetName , int rownum,int column) throws IOException
{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetName);
	
	row=sheet.getRow(rownum);
	cell=row.getCell(column);
	
	DataFormatter formatter=new DataFormatter();
	String Data;
		try
		{
		Data=formatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
		Data="";
		}
		
	workbook.close();
	fi.close();
	return Data;
}

public void setCellData(String sheetName,int rownum,int column,String data) throws IOException
{	
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.createCell(column);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		workbook.close();
		fi.close();
		fo.close();
}
	
public static void CellToAnyData()
{
			String user;
			String pss;
		if(cell!=null&&cell.getCellType()==CellType.STRING)
		{
			user=cell.getStringCellValue();
			System.out.println(user);
		}
			
		if(cell!=null&&cell.getCellType()==CellType.STRING)
		{
			pss=cell.getStringCellValue();
			System.out.println(pss);
		}
}


}

