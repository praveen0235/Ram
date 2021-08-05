package runner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.runner.JUnitCore;

import com.google.common.io.Files;

import baseinit.Base;
import config.PropertyFileReader;
import framework.GenericActions;
import framework.GenericActions2;
import util.EmailUtil;
import util.PathHelper;

public class externalCucumberOptions {

	
	
	public static void loadPropertiesFile() throws IOException{
		PropertyConfigurator.configure(PathHelper.getResourcePath("/src/main/resources/ConfigurationFile/log4j.properties"));
		PropertyFileReader prop = new PropertyFileReader();
	    }
	public static String createAndGetCucumberOption(){       
	     StringBuilder sb = new StringBuilder();
	     String featureFilesPath = 
	    PropertyFileReader.properties.getProperty("cucumber.options.feature");
	     Base.log.info(" featureFilesPath: " +featureFilesPath);
	     sb.append(featureFilesPath);
	     return sb.toString();
	    }

	 public static void setOptions(){
	   String value = createAndGetCucumberOption();
	   Base.log.info(" Value: " +value);
	   System.setProperty("cucumber.options", value);
	   }

	public static void main(String[] args) throws IOException, ParseException {
			
			System.out.println("Execution process Started....");
			
			GenericActions.hitoryReports();
			GenericActions.filesDeletion();
			JUnitCore junitRunner = new JUnitCore();
	        loadPropertiesFile();
	        //setOptions();
	        for(int i=2;i<=Base.rowcount;i++)
			{
	        	Base.suiteXLS.setCellData("TestSuite", "TestStartedTime", i, "");
	        	Base.suiteXLS.setCellData("TestSuite", "Result", i, "");
			}
	        Base.firstIterationRun=true;
	        
	        junitRunner.run(runner.Runner.class);
	        
	       /* if(args[0].equalsIgnoreCase("false"))
	        {
	        	//System.out.println(args[0]);
	        junitRunner.run(runner.Runner.class);
	        }*/
			
			  Base.firstIterationRun=false;
			  
			  if(args[0].equalsIgnoreCase("true"))
		        {
				  //System.out.println(args[0]);
			  junitRunner.run(runner.failedScenariosRunner.class);
		        }
	       
	        try
	        {
	        GenericActions.issueUpdate(PathHelper.getBasePath()+"/test-output/cucumber-JSON-report/JSONReport.json");
	        }catch(Exception e)
	        {
	        	
	        }
	      //Creating the input file to SFTP 
			
			
			
			  GenericActions2.CopyContentOneWorkbookToOther(PathHelper.getBasePath()+
			  "/test-output/ExcelReport/ExcelReport.xlsx",System.getProperty("user.dir")+
			  "/Uploadfiles/ArchiveFileStartDate/"+"Input"+".xlsx"); //Creating the Archive
			  //file to SFTP
			  GenericActions2.OneWorkbookToOtherArchive(PathHelper.getBasePath()+
			  "/test-output/ExcelReport/ExcelReport.xlsx",System.getProperty("user.dir")+
			  "/Uploadfiles/ArchiveFileStartDate/"+"Archive"+".xlsx");
			  
			  String inputfilename
			  ="Selenium_"+PropertyFileReader.properties.getProperty("Product")+"_"+
			  PropertyFileReader.properties.getProperty("Environment")+".csv";
			  
			  String outfilename
			  ="Selenium_"+PropertyFileReader.properties.getProperty("Product")+"_"+
			  PropertyFileReader.properties.getProperty("Environment")+"_Archive"+".csv";
			   
				
				  FileUtils.copyFile(new
				  File(System.getProperty("user.dir")+"/Uploadfiles/FilesToInput/"+
				  inputfilename),
				  Paths.get(PropertyFileReader.properties.getProperty("InputFilePathToR14")+
				  inputfilename).toFile());
				  
				  FileUtils.copyFile(new
				  File(System.getProperty("user.dir")+"/Uploadfiles/FilesToArchive/"+
				  outfilename),
				  Paths.get(PropertyFileReader.properties.getProperty("OutPutFilePathToR14")+
				  outfilename).toFile());
				 
			  
			  //EmailUtil.sendEmailAfterLogs();
			 
	        
	        
			System.out.println("Execution process Completed");
	}

}
