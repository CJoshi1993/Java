package testscript;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;







public class ExecuteLeadTest {
	
	
	
	@SuppressWarnings({ "resource", "deprecation", "unchecked", "rawtypes" })
	@Test
	public  void LeadTest() throws Exception {
		Keywords key=new Keywords();
		ArrayList data=new ArrayList();
		FileInputStream file=new FileInputStream("D://LeadSuite1.xlsx");
		XSSFWorkbook wbks=new XSSFWorkbook(file);
		Sheet sheet=wbks.getSheet("Sheet2");
		
        Iterator itr=sheet.iterator();
		
		while(itr.hasNext()){
			Row rowitr=(Row)itr.next();
			
		Iterator cellitr=rowitr.cellIterator();
		while(cellitr.hasNext()){
			Cell celldata=(Cell)cellitr.next();
			switch(celldata.getCellType()){
			case Cell.CELL_TYPE_STRING:
				data.add(celldata.getStringCellValue());
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				data.add(celldata.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				data.add(celldata.getNumericCellValue());
				break;
				
			}
			}
			    
				
			}
		for(int i=0;i<data.size();i++){
			if(data.get(i).equals("openbrowser")){
				String keyword=(String)data.get(i);
				System.out.println(keyword);
	            key.openbrowser();
		}
			if(data.get(i).equals("navigate")){
				String keyword=(String)data.get(i);
				String testdata=(String)data.get(i+1);
				System.out.println(keyword);
		    	System.out.println(testdata);
				key.navigate(testdata);
			}
	 
		    if(data.get(i).equals("input")){
		    	String keyword=(String)data.get(i);
		    	String testdata=(String)data.get(i+1);
		    	String objectName=(String)data.get(i+2);
		    	System.out.println(keyword);
		    	System.out.println(testdata);
		    	System.out.println(objectName);
		    	key.input(testdata,objectName);
		    }
		    if(data.get(i).equals("click")){
		    	String keyword=(String)data.get(i);
		    	String testdata=(String)data.get(i+1);
		    	String objectName=(String)data.get(i+2);
		    	System.out.println(keyword);
		    	System.out.println(testdata);
		    	System.out.println(objectName);
		    	key.click(objectName);
		    }
		
		if (data.get(i).equals("verifyTitle")){
			String keyword=(String)data.get(i);
			String testdata=(String)data.get(i+1);
			String objectName=(String)data.get(i+2);
			 System.out.println(keyword);
			 System.out.println(testdata);
			 System.out.println(objectName);
			 
			 String av=key.verifyTitle();
			 Assert.assertEquals(testdata, av);
		}
		
		if(data.get(i).equals("verifyPageText")){
			String keyword=(String)data.get(i);
			String testdata=(String)data.get(i+1);
			String objectName=(String)data.get(i+2);
			 System.out.println(keyword);
			 System.out.println(testdata);
			 System.out.println(objectName);
			 
			 String av=key.verifyPageText(objectName);
			 Assert.assertEquals(testdata, av);
		}
		
		if(data.get(i).equals("verifyEditBox")){
			String keyword=(String)data.get(i);
			String testdata=(String)data.get(i+1);
			String objectName=(String)data.get(i+2);
			 System.out.println(keyword);
			 System.out.println(testdata);
			 System.out.println(objectName);
			 
			 String av=key.verifyEditBox(objectName);
			 Assert.assertEquals(testdata, av);
		}
			
		}
		
		
		
		
		}
		
    }


	
