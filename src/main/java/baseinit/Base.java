package baseinit;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.JavascriptExecutor;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.service.ExtentService;

import config.ConfigurationReader;
import config.PropertyFileReader;

import framework.Browser;
import framework.GenericActions;
import framework.Waits;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import util.PathHelper;
import util.Xls_Reader;


public class Base {
	
	public static Logger log=Logger.getLogger(Base.class);
	public static String mainWindowHandle;
	public static WebDriver driver;
	public static String scenarioName;
	public static Boolean firstIterationRun;
	public static ConfigurationReader reader;
	public static Xls_Reader suiteXLS = new Xls_Reader(PathHelper.getBasePath()+"/test-output/ExcelReport/ExcelReport.xlsx");
	public static int rowcount = suiteXLS.getRowCount("TestSuite");
	
	@Before
	public void BrowsersetUp(Scenario browser){
		
		log.info("Scenario Started: "+browser.getName());
		Base.reader=new PropertyFileReader();
		Browser.startBrowser();
		Browser.maximize();
		mainWindowHandle=driver.getWindowHandle();
		scenarioName=browser.getName().trim();
		for(int i=1;i<=rowcount;i++)
		{
			if(suiteXLS.getCellData("TestSuite", "TestCaseDescription", i).trim().equalsIgnoreCase(scenarioName))
			{
				GenericActions.date(suiteXLS, "TestStartedTime", i);
				suiteXLS.setCellData("TestSuite", "Investigations", i, "");
				suiteXLS.setCellData("TestSuite", "Product", i, PropertyFileReader.properties.getProperty("Product"));
				suiteXLS.setCellData("TestSuite", "Browser", i, PropertyFileReader.properties.getProperty("browser"));
				suiteXLS.setCellData("TestSuite", "URL", i, PropertyFileReader.properties.getProperty("url").replace("https://", "").replace("http://", ""));
				suiteXLS.setCellData("TestSuite", "Environment", i, PropertyFileReader.properties.getProperty("Environment"));
				GenericActions.date(suiteXLS, "TestStartedTime", i);
				break;
			}
		}
	}
	
	@AfterStep
	public void waitToPageRender(Scenario scenario) throws InterruptedException
	{
		//((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete|loaded|interactive");
		
		
		for(int i=1;i<=60;i++)
		{
			if(Waits.isPageLoaded())
			{
				break;
			}
			
			Thread.sleep(1000);
		}
		
		Thread.sleep(1500);
		
		if(PropertyFileReader.properties.getProperty("ScreenShotforEachSteps").toLowerCase().equalsIgnoreCase("yes"))
		{
			scenario.embed(Browser.takeScreenshot(scenario), "image/png");
		}
		
	long navigationStart =	(long)((JavascriptExecutor)driver).executeScript("return window.performance.timing.navigationStart");
	long responseStart  =	(long)((JavascriptExecutor)driver).executeScript("return window.performance.timing.responseStart");
	long domComplete  =	(long)((JavascriptExecutor)driver).executeScript("return window.performance.timing.domComplete");
	
	long backendPerformance_calc = responseStart - navigationStart;
			long frontendPerformance_calc = domComplete - responseStart;
			
			System.out.println(backendPerformance_calc);
			System.out.println(frontendPerformance_calc);
	}
	
	@After
	
	public void closeBrowser(Scenario scenario) throws ParseException, IOException{
		
		if(scenario.isFailed()){
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmSSSss");
			LocalDateTime now = LocalDateTime.now();
			String dummyy = dtf.format(now).toString();
			String dummy = dummyy.substring(0, 15);
			scenario.embed(Browser.takeScreenshot(scenario), "image/png");
			
			/*for(int i=1;i<=rowcount;i++)
			{
				if(suiteXLS.getCellData("TestSuite", "TestCaseDescription", i).equalsIgnoreCase(scenario.getName()))
				{
					suiteXLS.setCellData("TestSuite", "Investigations", i, "Unable to locate the element");
					break;
				}
			}*/
			//Browser.takeScreenshot(scenario);
		}
		
		for(int i=1;i<=rowcount;i++)
		{
			if(suiteXLS.getCellData("TestSuite", "TestCaseDescription", i).trim().equalsIgnoreCase(scenario.getName().trim()))
			{
				suiteXLS.setCellData("TestSuite", "Result", i, String.valueOf(scenario.getStatus()));
				GenericActions.date(suiteXLS, "TestEndedTime", i);
				String startdate= suiteXLS.getCellData("TestSuite", "TestStartedTime", i);
				String Enddate= suiteXLS.getCellData("TestSuite", "TestEndedTime", i);
				GenericActions.datediff(startdate, Enddate, suiteXLS, i);
				break;
			}
		}
		//GenericActions.deleteFiles(new File(System.getProperty("user.dir")+"/"+"ProcessedXML"));
		log.info("Scenario Completed: "+scenario.getName());
		log.info("Scenario Status is: "+scenario.getStatus());
		
		System.out.println("Scenario Completed: "+scenario.getName());
		System.out.println("Scenario Status is: "+scenario.getStatus());
		
		Base.driver.quit();
		Browser.chromeDriverService.stop();
		
		try
		 {
			 if (PropertyFileReader.properties.getProperty("OS").toLowerCase().
					  equalsIgnoreCase("windows"))
			    { 
				 	Runtime.getRuntime().exec("taskkill /F /PID "+Browser.chromeDriverProcessID);
				 	Runtime.getRuntime().exec("taskkill /F /PID "+Browser.chromeProcessID);
				 	
			    }else if(PropertyFileReader.properties.getProperty("OS").toLowerCase().
						  equalsIgnoreCase("linux"))
			    {
			    	Runtime.getRuntime().exec("sudo kill "+Browser.chromeProcessID);
			    	Runtime.getRuntime().exec("sudo kill "+Browser.chromeDriverProcessID);
			    	//Runtime.getRuntime().exec("sudo pkill -TERM -u exela -f "+System.getProperty("user.dir")+"/drivers/Linux/Chrome/chromedriver");
			    }
		 }catch(Exception e)
		 {
			 
		 }
		
		//Creating the input file to SFTP 
		//GenericActions.CopyContentOneWorkbookToOther(PathHelper.getBasePath()+"/test-output/ExcelReport/ExcelReport.xlsx",System.getProperty("user.dir")+"/Uploadfiles/ArchiveFileStartDate/"+"Input"+".xlsx");
		//Creating the Archive file to SFTP
		//GenericActions.OneWorkbookToOtherArchive(PathHelper.getBasePath()+"/test-output/ExcelReport/ExcelReport.xlsx",System.getProperty("user.dir")+"/Uploadfiles/ArchiveFileStartDate/"+"Archive"+".xlsx");
		
		String inputfilename = "Selenium_"+PropertyFileReader.properties.getProperty("Product")+"_"+PropertyFileReader.properties.getProperty("Environment")+".csv";
		
		String outfilename = "Selenium_"+PropertyFileReader.properties.getProperty("Product")+"_"+PropertyFileReader.properties.getProperty("Environment")+"_Archive"+".csv";
		
		util.FileConversionXLSXToCSV2.conversionStart(PathHelper.getBasePath()+"/test-output/ExcelReport/ExcelReport.xlsx",System.getProperty("user.dir")+"/Uploadfiles/FilesToArchive/"+"Selenium_"+PropertyFileReader.properties.getProperty("Product")+"_"+PropertyFileReader.properties.getProperty("Environment")+"_Archive"+".csv");
		 
		 util.FileConversionXLSXToCSV2.conversionStart(PathHelper.getBasePath()+"/test-output/ExcelReport/ExcelReport.xlsx",System.getProperty("user.dir")+"/Uploadfiles/FilesToInput/"+"Selenium_"+PropertyFileReader.properties.getProperty("Product")+"_"+PropertyFileReader.properties.getProperty("Environment")+".csv");
		 
		FileUtils.copyFile(new File(System.getProperty("user.dir")+"/Uploadfiles/FilesToInput/"+inputfilename), Paths.get(PropertyFileReader.properties.getProperty("InputFilePathToR14")+inputfilename).toFile());
		 
		 FileUtils.copyFile(new File(System.getProperty("user.dir")+"/Uploadfiles/FilesToArchive/"+outfilename), Paths.get(PropertyFileReader.properties.getProperty("OutPutFilePathToR14")+outfilename).toFile());
		}
	
	 
	}


