package framework;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.codehaus.plexus.util.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import baseinit.Base;
import config.PropertyFileReader;
import util.PathHelper;
import util.Xls_Reader;

public class GenericActions {
	public static Date firtDatefrmExecl;
	public static int temprowcountdummy =2;
	public static int temprowcount =2;
	public static String fileName;
	public static byte[] filesToByte(String filepath) throws IOException
	{
		File file = new File(filepath);
		//init array with file length
		byte[] bytesArray = new byte[(int) file.length()];

		FileInputStream fis = new FileInputStream(file);
		fis.read(bytesArray); //read file into bytes[]
		fis.close();

		return bytesArray;
	}
	
		
public static String partialfilename(String fileName)
{
	File dir = new File(System.getProperty("user.dir")+"/"+"DownloadedFiles");

	// list the files using a anonymous FileFilter
	File[] files = dir.listFiles(new FileFilter() {

	    @Override
	    public boolean accept(File file) {
	        return file.getName().startsWith(fileName);
	    }
	});
	
	return files[0].toString();
}

public static void draganddrop(WebElement element) throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait(Base.driver, 10);
	wait.until(ExpectedConditions.visibilityOf(element));
	
	Actions action = new Actions(Base.driver);
	
	WebElement source =element;
	Point point = source.getLocation();
	int source_xcord = point.getX();
	int source_ycord = point.getY();
	
	action.moveToElement(source);
	WebElement target2 = Base.driver.findElement(By.xpath("//div[@class='drop ui-droppable'][1]"));
//	System.out.println(source);
//	System.out.println(Targetloc);
	Thread.sleep(2000);
	action.clickAndHold(source).build().perform();
	action.dragAndDrop(source, target2).build().perform();
}

public static void hitoryReports() throws IOException
{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss a");
	File f = new File(System.getProperty("user.dir")+"/test-output/Spark/DMR.html");
	
	String foldername = sdf.format(f.lastModified());
	
	File theDir = new File(System.getProperty("user.dir")+"\\"+"ReportsArchive\\"+foldername);
	if(!theDir.exists())
	{
		theDir.mkdir();
	}
	File src = new File(System.getProperty("user.dir")+"\\test-output");
	FileUtils.copyDirectoryStructure(src, theDir);
}

	public static void xmlUpdate(io.cucumber.datatable.DataTable dataTable,String filepath,String UploadFileName1,String UploadFileName2) throws Exception
	{
		try
		{
		Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmss");
    	 fileName = ft.format(dNow)+"T";
    	 
		//String filepath = "C:\\Users\\praveenrajn\\Downloads\\Uploadit-GnyYdN8P9yTPKgdn\\201142001P001389999\\201142001P001389999\\201142001P001389999.xml";
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(System.getProperty("user.dir")+"\\Uploadfiles\\"+filepath);
        
        doc.getElementsByTagName("Document").item(0).getAttributes().getNamedItem("DocumentIdentifier").setNodeValue(fileName);
        
        doc.getElementsByTagName("Document").item(0).getAttributes().getNamedItem("DocumentFilename").setNodeValue(fileName+".xml");
        
        NodeList ACNodeList = doc.getElementsByTagName("Field");
        for (Map<Object, Object> data : dataTable.asMaps(String.class, String.class)) {
		
			String fieldName = String.valueOf(data.get("FieldName"));
			String capturedValue = String.valueOf(data.get("CapturedValue"));
			String Value = String.valueOf(data.get("Value"));
        for(int i=0;i<ACNodeList.getLength();i++)
        {
        	String nodevalue = ACNodeList.item(i).getAttributes().getNamedItem("FieldName").getNodeValue();
        	
        	if(nodevalue.equals(fieldName))
        	{
        		NodeList nodelist = ACNodeList.item(i).getChildNodes();
        	
        		nodelist.item(1).getAttributes().getNamedItem("CapturedValue").setNodeValue(capturedValue);
        		
        		nodelist.item(1).getChildNodes().item(1).getAttributes().getNamedItem("Value").setNodeValue(Value);
        		
        		break;
        			
        	}
        	
        }
        }
        
        
    	 File dir = new File(System.getProperty("user.dir")+"\\ProcessedXML\\"+fileName);
    	 if(!dir.exists())
    	 {
    		 dir.mkdir();
    		 File dir1 = new File(System.getProperty("user.dir")+"\\ProcessedXML\\"+fileName+"\\"+fileName);
    		if(!dir1.exists()) {
    			 dir1.mkdir();
    		 }
    		 
    	 }
    	 
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(System.getProperty("user.dir")+"\\ProcessedXML\\"+fileName+"\\"+fileName+"\\"+fileName+".xml"));
        transformer.transform(source, result);
        
        fileCopy(System.getProperty("user.dir")+"\\Uploadfiles\\"+UploadFileName1,System.getProperty("user.dir")+"\\ProcessedXML\\"+fileName+"\\"+fileName+"\\",UploadFileName1);
        
        fileCopy(System.getProperty("user.dir")+"\\Uploadfiles\\"+UploadFileName2,System.getProperty("user.dir")+"\\ProcessedXML\\"+fileName+"\\"+fileName+"\\","merged.pdf");
        
        ZipDirectory.ZipDirectoryMaker(System.getProperty("user.dir")+"\\ProcessedXML\\"+fileName);
        
        FileUtils.deleteDirectory(new File(System.getProperty("user.dir")+"\\ProcessedXML\\"+fileName));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void fileCopy(String sourcePath,String destinationPath,String fileName) throws Exception
    {
    	try
    	{
    		
    		File sourceFile = new File(sourcePath);
    		File destinationFile = new File(destinationPath + fileName);

    		FileInputStream fileInputStream = new FileInputStream(sourceFile);
    		FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);

    		int bufferSize;
    		byte[] bufffer = new byte[512];
    		while ((bufferSize = fileInputStream.read(bufffer)) > 0) {
    		    fileOutputStream.write(bufffer, 0, bufferSize);
    		}
    		fileInputStream.close();
    		fileOutputStream.close();
    	}catch(Exception e)
    	{
    		throw(e);
    	}
    }
	
	 public static void startDate(WebElement ele,String tData) throws InterruptedException
	    {
					Thread.sleep(2000);
					
		    		String[] sliptedfromdate = tData.split("/");
		    		
		    		char[] ch = sliptedfromdate[1].toCharArray();
		    		
		    		if(ch[0]=='0')
		    		{
		    			sliptedfromdate[1] = sliptedfromdate[1].substring(1, sliptedfromdate[1].length());
		    		}
		    		
		    		ele.click();
		    		
		    		List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
		    		
		    		List<String> monthList2 = Arrays.asList("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC");
		    		
		    		
		    		boolean whileIteration = true;
		    		
		    		while(whileIteration)
	    			{
		    			WebElement element =Base.driver.findElement(By.xpath("//button[@class='mat-calendar-period-button mat-button mat-button-base']/span"));
			    		
			    		//String month = monthList2.get(Integer.parseInt(sliptedfromdate[0])-1);
			    		
			    		String WebData=element.getText();
		    		
			    		String test = monthList2.get(Integer.parseInt(sliptedfromdate[0])-1);
			    		
		    			if(WebData.contains(test))
		    			{
		    				if(WebData.contains(sliptedfromdate[2]))
		    	    		{
		    					//Thread.sleep(5000);
		    				String loct ="//td[@aria-label='"+monthList.get(Integer.parseInt(sliptedfromdate[0])-1)+" "+sliptedfromdate[1]+", "+sliptedfromdate[2]+"']/div";
		    				Base.driver.findElement(By.xpath(loct)).click();
		    				 
		    				whileIteration = false;	
		    			}else {
		    				element.click();
		    				
		    				List<WebElement> eleYear = Base.driver.findElements(By.xpath("//td[contains(@class,'mat-calendar-body-cell')]/div"));
		    				
		    				for(int i=0;i<=eleYear.size()-1;i++)
		    				{	
		    					if(eleYear.get(i).getText().equalsIgnoreCase(sliptedfromdate[0]))
		    					{
		    						eleYear.get(i).click();
		    					}
		    				}
		    				List<WebElement> elemonth = Base.driver.findElements(By.xpath("//td[contains(@class,'mat-calendar-body-cell')]/div"));
		    				for(int i=0;i<=elemonth.size()-1;i++)
		    				{	
		    					if(elemonth.get(i).getText().equalsIgnoreCase(monthList2.get(Integer.parseInt(sliptedfromdate[0])-1)))
		    					{
		    						elemonth.get(i).click();
		    					}
		    				}
			    		}
		    			
		    		}
		    					
		    	}	
	    }
	 
	 public static void endDate(WebElement ele,String tData) throws InterruptedException
	    {
					Thread.sleep(3000);
					
		    		String[] sliptedfromdate = tData.split("/");
		    		
		    		char[] ch = sliptedfromdate[1].toCharArray();
		    		
		    		if(ch[0]=='0')
		    		{
		    			sliptedfromdate[1] = sliptedfromdate[1].substring(1, sliptedfromdate[1].length());
		    		}
		    		
		    		ele.click();
		    		
		    		List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
		    		
		    		List<String> monthList2 = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
		    		
		    		
		    		boolean whileIteration = true;
		    		
		    		while(whileIteration)
	    			{
		    			WebElement element =Base.driver.findElement(By.xpath("(//span[@class='flatpickr-day '])[1]"));
			    		
			    		//String month = monthList2.get(Integer.parseInt(sliptedfromdate[0])-1);
			    		
			    		String WebData=element.getAttribute("aria-label");
		    		
		    			if(WebData.contains(monthList.get(Integer.parseInt(sliptedfromdate[0])-1)))
		    			{
		    				if(WebData.contains(sliptedfromdate[2]))
		    	    		{
		    					//Thread.sleep(5000);
		    				String loct ="(//span[contains(@class,'flatpickr-day') and text()='"+sliptedfromdate[1].trim()+"'])[2]";
		    				Base.driver.findElement(By.xpath(loct)).click();
		    				 
		    				whileIteration = false;	
		    			}else {
		    				if(Integer.parseInt(WebData.split(",")[1].trim())>Integer.parseInt(sliptedfromdate[2]))
		    				{
			    			Base.driver.findElement(By.xpath("(//span[@class='arrowDown'])[2]")).click();
			    			Thread.sleep(500);
		    				}else
		    				{
		    					Base.driver.findElement(By.xpath("(//span[@class='arrowUp'])[2]")).click();
		    					Thread.sleep(500);
		    				}
			    		}
		    			
		    		}else
		    		{
		    			Base.driver.findElement(By.xpath("(//span[@class='flatpickr-prev-month'])[2]")).click();
		    			Thread.sleep(2000);
		    		}
		    					
		    	}	
	    }
	
	
	 public static void CalenderSelection(WebElement ele,String tData) throws InterruptedException
	    {
					Thread.sleep(3000);
					
		    		String[] sliptedfromdate = tData.split("/");
		    		
		    		char[] ch = sliptedfromdate[1].toCharArray();
		    		
		    		if(ch[0]=='0')
		    		{
		    			sliptedfromdate[1] = sliptedfromdate[1].substring(1, sliptedfromdate[1].length());
		    		}
		    		
		    		ele.click();
		    		
		    		List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
		    		
		    		List<String> monthList2 = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
		    		
		    		
		    		boolean whileIteration = true;
		    		
		    		while(whileIteration)
	    			{
		    			WebElement element =Base.driver.findElement(By.xpath("(//span[@class='flatpickr-day today' or @class='flatpickr-day '])[1]"));
			    		
			    		//String month = monthList2.get(Integer.parseInt(sliptedfromdate[0])-1);
			    		
			    		String WebData=element.getAttribute("aria-label");
		    		
		    			if(WebData.contains(monthList.get(Integer.parseInt(sliptedfromdate[0])-1)))
		    			{
		    				if(WebData.contains(sliptedfromdate[2]))
		    	    		{
		    					//Thread.sleep(5000);
		    				String loct ="//span[@aria-label='"+monthList.get(Integer.parseInt(sliptedfromdate[0])-1)+" "+sliptedfromdate[1]+", "+sliptedfromdate[2]+"']";
		    				//Base.driver.findElement(By.xpath(loct)).click();
		    				
		    				Elements.Mouseclick(Base.driver.findElement(By.xpath(loct)));
		    				 
		    				whileIteration = false;	
		    			}else {
		    				if(Integer.parseInt(WebData.split(",")[1].trim())>Integer.parseInt(sliptedfromdate[2]))
		    				{
			    			Base.driver.findElement(By.xpath("(//span[@class='arrowDown'])[1]")).click();
			    			Thread.sleep(500);
		    				}else
		    				{
		    					Base.driver.findElement(By.xpath("(//span[@class='arrowUp'])[1]")).click();
		    					Thread.sleep(500);
		    				}
			    		}
		    			
		    		}else
		    		{
		    			Base.driver.findElement(By.xpath("(//span[@class='flatpickr-prev-month'])[1]")).click();
		    			Thread.sleep(2000);
		    		}
		    					
		    	}	
	    }
	 
	 public static void CalenderSelectionto(WebElement ele,String tData) throws InterruptedException
	    {
					Thread.sleep(3000);
					
		    		String[] sliptedfromdate = tData.split("/");
		    		
		    		char[] ch = sliptedfromdate[1].toCharArray();
		    		
		    		if(ch[0]=='0')
		    		{
		    			sliptedfromdate[1] = sliptedfromdate[1].substring(1, sliptedfromdate[1].length());
		    		}
		    		
		    		ele.click();
		    		
		    		List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
		    		
		    		List<String> monthList2 = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
		    		
		    		
		    		boolean whileIteration = true;
		    		
		    		while(whileIteration)
	    			{
		    			WebElement element =Base.driver.findElement(By.xpath("(//div[@class='flatpickr-calendar animate arrowTop open' or @class='flatpickr-calendar animate arrowTop rightMost open' or @class='flatpickr-calendar animate showTimeInput open arrowTop rightMost' or @class='flatpickr-calendar animate showTimeInput arrowTop open']//span[@class='flatpickr-day today' or @class='flatpickr-day '])[1]"));
			    		
			    		//String month = monthList2.get(Integer.parseInt(sliptedfromdate[0])-1);
			    		
			    		String WebData=element.getAttribute("aria-label");
		    		
		    			if(WebData.contains(monthList.get(Integer.parseInt(sliptedfromdate[0])-1)))
		    			{
		    				if(WebData.contains(sliptedfromdate[2]))
		    	    		{
		    					//Thread.sleep(5000);
		    				String loct ="//div[@class= 'arrowTop open' or @class='flatpickr-calendar animate arrowTop open'or @class='flatpickr-calendar animate arrowTop rightMost open' or @class='flatpickr-calendar animate showTimeInput arrowTop open' or @class='flatpickr-calendar animate showTimeInput open arrowTop rightMost']//span[@aria-label='"+monthList.get(Integer.parseInt(sliptedfromdate[0])-1)+" "+sliptedfromdate[1]+", "+sliptedfromdate[2]+"']";
		    				
		    				 Elements.Mouseclick(Base.driver.findElement(By.xpath(loct)));
		    				whileIteration = false;	
		    			}else {
		    				if(Integer.parseInt(WebData.split(",")[1].trim())>Integer.parseInt(sliptedfromdate[2]))
		    				{
			    			Base.driver.findElement(By.xpath("(//span[@class='arrowDown'])[2]")).click();
			    			Thread.sleep(500);
		    				}else
		    				{
		    					Base.driver.findElement(By.xpath("(//span[@class='arrowUp'])[2]")).click();
		    					Thread.sleep(500);
		    				}
			    		}
		    			
		    		}else
		    		{
		    			try
		    			{
		    			Base.driver.findElement(By.xpath("(//span[@class='flatpickr-prev-month'])[2]")).click();
		    			Thread.sleep(2000);
		    			}catch(Exception e)
		    			{
		    				Base.driver.findElement(By.xpath("(//span[@class='flatpickr-next-month'])[2]")).click();
			    			Thread.sleep(2000);
		    			}
		    		}
		    					
		    	}	
	    }
	 
	 public static void CalenderSelectionto2(WebElement ele,String tData) throws InterruptedException
	    {
					Thread.sleep(3000);
					
		    		String[] sliptedfromdate = tData.split("/");
		    		
		    		char[] ch = sliptedfromdate[1].toCharArray();
		    		
		    		if(ch[0]=='0')
		    		{
		    			sliptedfromdate[1] = sliptedfromdate[1].substring(1, sliptedfromdate[1].length());
		    		}
		    		
		    		ele.click();
		    		Thread.sleep(10000);
		    		List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
		    		
		    		//Base.driver.switchTo().frame(Base.driver.findElement(By.xpath("//iframe[@id='ssIFrame_google']")));
		    		boolean whileIteration = true;
		    		
		    		while(whileIteration)
	    			{
		    			Waits.waitUntilElementLocated(10, Base.driver.findElement(By.xpath("(//div[contains(@class,'open arrowTop rightMost')]//span[@class='flatpickr-day '])[1]")));
		    			WebElement element =Base.driver.findElement(By.xpath("(//div[contains(@class,'open arrowTop rightMost')]//span[@class='flatpickr-day '])[1]"));
			    		
			    		//String month = monthList2.get(Integer.parseInt(sliptedfromdate[0])-1);
			    		
			    		String WebData=element.getAttribute("aria-label");
		    		
		    			if(WebData.contains(monthList.get(Integer.parseInt(sliptedfromdate[0])-1)))
		    			{
		    				if(WebData.contains(sliptedfromdate[2]))
		    	    		{
		    					//Thread.sleep(5000);
		    				String loct ="//div[@class= 'arrowTop open' or @class='flatpickr-calendar animate arrowTop open'or @class='flatpickr-calendar animate arrowTop rightMost open' or @class='flatpickr-calendar animate showTimeInput arrowTop open' or @class='flatpickr-calendar animate showTimeInput open arrowTop rightMost']//span[@aria-label='"+monthList.get(Integer.parseInt(sliptedfromdate[0])-1)+" "+sliptedfromdate[1]+", "+sliptedfromdate[2]+"']";
		    				
		    				 Elements.Mouseclick(Base.driver.findElement(By.xpath(loct)));
		    				whileIteration = false;	
		    			}else {
		    				if(Integer.parseInt(WebData.split(",")[1].trim())>Integer.parseInt(sliptedfromdate[2]))
		    				{
			    			Base.driver.findElement(By.xpath("(//span[@class='arrowDown'])[2]")).click();
			    			Thread.sleep(500);
		    				}else
		    				{
		    					Base.driver.findElement(By.xpath("(//span[@class='arrowUp'])[2]")).click();
		    					Thread.sleep(500);
		    				}
			    		}
		    			
		    		}else
		    		{
		    			try
		    			{
		    			Base.driver.findElement(By.xpath("(//span[@class='flatpickr-prev-month'])[2]")).click();
		    			Thread.sleep(2000);
		    			}catch(Exception e)
		    			{
		    				Base.driver.findElement(By.xpath("(//span[@class='flatpickr-next-month'])[2]")).click();
			    			Thread.sleep(2000);
		    			}
		    		}
		    					
		    	}	
		    		//Base.driver.switchTo().defaultContent();
	    }
	
	 
	 public static void CalenderSelection2(WebElement ele,String tData) throws InterruptedException
	    {
					Thread.sleep(3000);
					
		    		String[] sliptedfromdate = tData.split("/");
		    		
		    		ele.click();
		    		
		    		List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
		    		
		    		List<String> monthList2 = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
		    				    		
		    		boolean whileIteration = true;
		    		
		    		while(whileIteration)
	    			{
		    			WebElement element =Base.driver.findElement(By.xpath("(//span[@class='flatpickr-day '])[1]"));
			    		
			    		//String month = monthList2.get(Integer.parseInt(sliptedfromdate[0])-1);
			    		
			    		String WebData=element.getAttribute("aria-label");
		    		
		    			if(WebData.contains(monthList.get(Integer.parseInt(sliptedfromdate[0])-1)))
		    			{
		    				if(WebData.contains(sliptedfromdate[2]))
		    	    		{
		    					//Thread.sleep(5000);
		    				String loct ="(//span[contains(@class,'flatpickr-day') and text()='"+sliptedfromdate[1].replaceFirst("0", "").trim()+"'])[1]";
		    				Base.driver.findElement(By.xpath(loct)).click();
		    				 
		    				whileIteration = false;	
		    			}else {
		    				if(Integer.parseInt(WebData.split(",")[1].trim())>Integer.parseInt(sliptedfromdate[2]))
		    				{
			    			Base.driver.findElement(By.xpath("(//span[@class='arrowDown'])[1]")).click();
			    			Thread.sleep(1000);
		    				}else
		    				{
		    					Base.driver.findElement(By.xpath("(//span[@class='arrowUp'])[1]")).click();
		    					Thread.sleep(1000);
		    				}
			    		}
		    			
		    		}else
		    		{
		    			try
		    			{
		    			Base.driver.findElement(By.xpath("(//span[@class='flatpickr-prev-month'])[1]")).click();
		    			Thread.sleep(2000);
		    			}catch(Exception e)
		    			{
		    				Base.driver.findElement(By.xpath("(//span[@class='flatpickr-next-month'])[1]")).click();
			    			Thread.sleep(2000);
		    			}
		    		}
		    					
		    	}	
		    
		
	    }
	 
	 
	
		
	 public static boolean multiDataComparision(List<WebElement> webelement,String ExpectedData)
	 {
		 List<String> webelementData = new ArrayList<String>();
		 List<String> featurefileData = new ArrayList<String>();
		 
		 for(WebElement ele:webelement)
			{
				String text = ele.getText().trim();
				webelementData.add(text);
			}
 	
 	String[] data = ExpectedData.split(",");
 	for(int i=0;i<=data.length-1;i++)
 	{
 		featurefileData.add(data[i].trim());
 	}
 	
 	Collections.sort(webelementData);
 	Collections.sort(featurefileData);
 	
 	boolean bvalue1= webelementData.equals(featurefileData);
 	
 	return bvalue1;
		 
	 }
	
	public static  List<String> verifyTextExistence(List<WebElement> WebElements) 
	     {
	 		List<String> WebElementdata = new ArrayList<String>();
	 		
	 		
	 		    		List<WebElement> Webelement = WebElements;
	 			    	
	 			    	for(WebElement ele:Webelement)
	 					{
	 			    		Elements.scrollIntoView(ele);
	 						String text = ele.getText().trim();
	 						WebElementdata.add(text);
	 					}
	 		    	
	 		    	Collections.sort(WebElementdata);
	 		    	
	 		    	return WebElementdata;
	 		}
	
	public static void issueUpdate(String path) throws IOException
	{
		String JSONString = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
    	 JSONString = JSONString.substring(4);
    	 JSONString = JSONString.substring(0, JSONString.length() - 1) + "";
    	JSONObject json = new JSONObject(JSONString);
        JSONArray arr = json.getJSONArray("elements");
        
     for(int j=0;j<arr.length();j++)   
     {
    	 String scenarioname = arr.getJSONObject(j).getString("name");
    	 //System.out.println(scenarioname);
    	 for(int h=0;h<=Base.rowcount;h++)
    	 {
    	 String[] EM = null;
         String stepName = null;
    		 String test = Base.suiteXLS.getCellData("TestSuite", "TestCaseDescription", h).trim();
    	if(test.equalsIgnoreCase(scenarioname.trim()))
    	{		
    	 JSONArray d= arr.getJSONObject(j).getJSONArray("steps");
    	 for(int i = 0; i < d.length(); i++){
        	try{
        		JSONObject position = d.getJSONObject(i).getJSONObject("result");
        		String errorMessage =   position.getString("error_message");
        		EM = errorMessage.split(":",2)[1].split("}",2);
        		stepName = d.getJSONObject(i).getString("name");
               // System.out.println(EM[0]+"}");
               }catch(Exception e)
               {
            	   
               }
            
           // System.out.println(stepName);  
        } 
    	 if(EM !=null)
    	 {
    		 String msg =EM[0].replace("\r\n", "").replace("\r", "").replace("\n", "");
    		 msg = msg.replace(",", "");
    	 Base.suiteXLS.setCellData("TestSuite", "Investigations", h, "FailedStep: "+stepName.replace(",", "")+"--->ErrorDescription: " + msg +"}" );
    	 Base.suiteXLS.setCellData("TestSuite", "Result", h, "Failed" );
    	 }
    	} 
    }
    }

	}
	
	public static void deleteFiles(File folder) {
	    File[] files = folder.listFiles();
	    if(files!=null) { //some JVMs return null for empty dirs
	        for(File f: files) {
	                f.delete();
	        }
	    }
	}
	
	public static void filesDeletion()
    {
		deleteFiles(new File(System.getProperty("user.dir")+"/"+"DownloadedFiles"));
    	deleteFiles(new File(System.getProperty("user.dir")+"/"+"test-output"));
    	deleteFiles(new File(System.getProperty("user.dir")+"/"+"Uploadfiles/FilesToInput"));
    	deleteFiles(new File(System.getProperty("user.dir")+"/"+"Uploadfiles/FilesToArchive"));
    }
	
	public static void date(Xls_Reader suite,String testCasedate,int rownum)
	{
		Date dNow = new Date();
    	//SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa"); 
    	
    	SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");
    	String ExeTime = ft.format(dNow);
    	
    	SimpleDateFormat ft1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");
    	String ExeTime1 = ft1.format(dNow);
    	suite.setCellData("TestSuite", testCasedate, rownum, ExeTime);
    	//suite.setCellDataasDate("TestSuite", testCasedate, rownum, ExeTime);
    	//suite.setCellData("RoughSheet", testCasedate, 2, ExeTime1);
	}
		public static void datediff(String testcasestart,String testcaseend,Xls_Reader suite,int rownum) throws ParseException
		{
			DateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");
	    	Date startdate=ft.parse(testcasestart);
	    	Date enddate=ft.parse(testcaseend);
			long diff = enddate.getTime() - startdate.getTime();
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000);
			
			String diffdate = String.format("%02d:%02d:%02d", diffHours, diffMinutes, diffSeconds);
			
			//String diffdate =diffHours+":"+diffMinutes+":"+diffSeconds;
			suite.setCellData("TestSuite", "Timetakentofinish", rownum, diffdate);
		}

		public static void CopyContentOneWorkbookToOther(String inputSheet,String archiveSheet) throws IOException, ParseException 
		{
					  Xls_Reader insuite = new Xls_Reader(inputSheet);
					  
	                  Xls_Reader outsuite = new Xls_Reader(archiveSheet);
	                  
	                  //Xls_Reader archivedatesuite = new Xls_Reader(archiveDateSheet);
	                  
	                  XSSFSheet inputSheetName=insuite.getSheet("TestSuite");
	                  
	                  XSSFSheet outputSheet=outsuite.getSheet("TestSuite");
	                	                                  
	                 copySheet(inputSheetName,outputSheet,insuite,outsuite,archiveSheet); 
	                 util.FileConversionXLSXToCSV.conversionStart(archiveSheet,System.getProperty("user.dir")+"/Uploadfiles/FilesToInput/"+"Selenium_"+PropertyFileReader.properties.getProperty("Product")+"_"+PropertyFileReader.properties.getProperty("Environment")+".csv");
	          }

		
		   public static void copySheet(XSSFSheet inputSheet,XSSFSheet outputSheet,Xls_Reader insuite,Xls_Reader outsuite,String archiveSheet) throws ParseException, IOException 
           { 
			   LocalDateTime dNow =  LocalDateTime.now();
              	
               LocalDateTime dthen = dNow.minusDays(6);
               
               DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy-MM-dd");
               
               DateFormat ft2 = new SimpleDateFormat("yyyy-MM-dd");
               
               Date dthen2 = ft2.parse(ft.format(dthen));
               
               //Date firtDatefrmExec1 = new Date(outsuite.getCellData("TestSuite", "TestStartedTime", 2));
               int outputSheetrowCount=outputSheet.getLastRowNum();
               
               if(outputSheetrowCount!=0)
               {
            	   firtDatefrmExecl = ft2.parse(outsuite.getCellData("TestSuite", "TestStartedTime", 2));
               }
        	   
              int inputSheetrowCount=inputSheet.getLastRowNum();
              
              int inputSheetcoulmnCount=inputSheet.getRow(0).getLastCellNum();
              
              String outputSheetName = outputSheet.getSheetName();
              
              String inputSheetName = inputSheet.getSheetName();
               try 
               {     
                if(inputSheetrowCount>0)
                {
                	if(outputSheetrowCount==0)
                	{                			
                			if(!insuite.getCellData("TestSuite", "TestStartedTime", 2).isEmpty())
            				{
                			for(int celliteration =0;celliteration<=inputSheetcoulmnCount-1;celliteration++)
                			{
                				String colname =insuite.getCellData(inputSheetName, celliteration , 1);
                				
                				String data = insuite.getCellData(inputSheetName, celliteration , 2);
                				
                				outsuite.setCellData(outputSheetName, colname, 2, data);
                			}
                			temprowcount++;
            				
                		}
                	
                	}else if(firtDatefrmExecl.before(dthen2))
                	{
                	
                	List<String> rowCount = new ArrayList<String>();
                 	
                	for(int j=2;j<=outputSheetrowCount;j++)
                	{
                		 Date ExecutionStartDate = ft2.parse(outsuite.getCellData("TestSuite", "TestStartedTime", j));
               		
                		if(ExecutionStartDate.before(dthen2))
                		{
                			rowCount.add(String.valueOf(j));
                		}else
                		{
                			break;
                		}
                		
                	}
                	
                    //specify the row index from where to delete
                    int rowIndex =1;
                	//deleting the rows
                    if (rowIndex >= 0 && rowIndex < rowCount.size()) {
                    	
                    	for(int i=2;i<=rowCount.size()+1;i++)
                    	{
                    	outputSheet.shiftRows(rowIndex+1, outputSheetrowCount, -1, true,true);
                    	}
                    }        
                    
                    FileOutputStream outFile = new FileOutputStream(new File(PathHelper.getBasePath()+"/Uploadfiles/ArchiveFileStartDate/"+"Input"+".xlsx"));
                    outsuite.workbook.write(outFile);
                    outFile.close();
                	
                    Xls_Reader changedoutsuite = new Xls_Reader(archiveSheet);
                    
                    int changedoutputSheetrowCount= changedoutsuite.getSheet("TestSuite").getLastRowNum();
                    
                    for(int k = 1;k<=changedoutputSheetrowCount;k++)
                    {
                    	String coln =insuite.getCellData(inputSheetName, 0 , 1);
            			
                    	changedoutsuite.setCellData(outputSheetName,coln , k+1, String.valueOf(k));
                    }
                    
                    int rowcount =2;
            		
            		for(int i=changedoutputSheetrowCount;i<=(changedoutputSheetrowCount+inputSheetrowCount)-1;i++)
            		{
            			String coln =insuite.getCellData(inputSheetName, 0 , 1);
            			
            			changedoutsuite.setCellData(outputSheetName,coln , i+2, String.valueOf(i+1));
            			
            			for(int celliteration =1;celliteration<=inputSheetcoulmnCount-1;celliteration++)
            			{
            				String colname =insuite.getCellData(inputSheetName, celliteration , 1);
            				
            				String data1 = insuite.getCellData(inputSheetName, celliteration , rowcount);
            				
            				changedoutsuite.setCellData(outputSheetName, colname, i+2, data1);
            			}
            			rowcount++;
            		}
                    
                	}else
                	{
                		
                		
                		for(int i=outputSheetrowCount;i<=(outputSheetrowCount+inputSheetrowCount)-1;i++)
                		{
                			if(!insuite.getCellData("TestSuite", "TestStartedTime", temprowcount).isEmpty())
            				{
                			String coln =insuite.getCellData(inputSheetName, 0 , 1);
                			
                			outsuite.setCellData(outputSheetName,coln , i+2, String.valueOf(i+1));
                			
                			for(int celliteration =1;celliteration<=inputSheetcoulmnCount-1;celliteration++)
                			{
                				String colname =insuite.getCellData(inputSheetName, celliteration , 1);
                				
                				String data = insuite.getCellData(inputSheetName, celliteration , temprowcount);
                				
                				outsuite.setCellData(outputSheetName, colname, i+2, data);
                			}
                			temprowcount++;
            				}
                			break;
                		}
                		
                	}
                	
                }}catch(Exception e)
               {
                	
               }
	}

    
           public static void OneWorkbookToOtherArchive(String inputSheet,String archiveSheet) throws IOException, ParseException 
   		{
   					  Xls_Reader insuite = new Xls_Reader(inputSheet);
   					  
   	                  Xls_Reader outsuite = new Xls_Reader(archiveSheet);
   	                  
   	                  //Xls_Reader archivedatesuite = new Xls_Reader(archiveDateSheet);
   	                  
   	                  XSSFSheet inputSheetName=insuite.getSheet("TestSuite");
   	                  
   	                  XSSFSheet outputSheet=outsuite.getSheet("TestSuite");
   	                  
   	                                    
   	             copySheetArchive(inputSheetName,outputSheet,insuite,outsuite,archiveSheet);
   	             util.FileConversionXLSXToCSV.conversionStart(archiveSheet,System.getProperty("user.dir")+"/Uploadfiles/FilesToArchive/"+"Selenium_"+PropertyFileReader.properties.getProperty("Product")+"_"+PropertyFileReader.properties.getProperty("Environment")+"_Archive"+".csv");
   	          }

   	           public static void copySheetArchive(XSSFSheet inputSheet,XSSFSheet outputSheet,Xls_Reader insuite,Xls_Reader outsuite,String archiveSheet) throws ParseException, IOException 
   	           { 
   	        	   
   	              int inputSheetrowCount=inputSheet.getLastRowNum();
   	              
   	              int outputSheetrowCount=outputSheet.getLastRowNum();
   	              
   	              int inputSheetcoulmnCount=inputSheet.getRow(0).getLastCellNum();
   	              
   	              String outputSheetName = outputSheet.getSheetName();
   	              
   	              String inputSheetName = inputSheet.getSheetName();
   	                    
   	                if(inputSheetrowCount>0)
   	                {
   	                	if(outputSheetrowCount==0)
   	                	{
   	                		for(int i=1;i<=inputSheetrowCount;i++)
   	                		{
   	                			for(int celliteration =0;celliteration<=inputSheetcoulmnCount-1;celliteration++)
   	                			{
   	                				String colname =insuite.getCellData(inputSheetName, celliteration , 1);
   	                				
   	                				String data = insuite.getCellData(inputSheetName, celliteration , i+1);
   	                				
   	                				outsuite.setCellData(outputSheetName, colname, i+1, data);
   	                			}
   	                		}
   	                	}else
   	                	{
   	                		int rowcount =2;
   	                		
   	                		for(int i=outputSheetrowCount;i<=(outputSheetrowCount+inputSheetrowCount)-1;i++)
   	                		{
   	                			String coln =insuite.getCellData(inputSheetName, 0 , 1);
   	                			
   	                			outsuite.setCellData(outputSheetName,coln , i+2, String.valueOf(i+1));
   	                			
   	                			for(int celliteration =1;celliteration<=inputSheetcoulmnCount-1;celliteration++)
   	                			{
   	                				String colname =insuite.getCellData(inputSheetName, celliteration , 1);
   	                				
   	                				String data = insuite.getCellData(inputSheetName, celliteration , rowcount);
   	                				
   	                				outsuite.setCellData(outputSheetName, colname, i+2, data);
   	                			}
   	                			rowcount++;
   	                		}
   	                		
   	                	}
   	                	
   	                }
   		}  
   	           
   	           

}
