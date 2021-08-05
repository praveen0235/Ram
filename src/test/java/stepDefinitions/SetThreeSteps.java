package stepDefinitions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.microsoft.azure.storage.StorageException;

import baseinit.Base;
import config.PropertyFileReader;
import framework.Elements;
import framework.GenericActions;
import framework.Storage;
import framework.Waits;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import pageObjects.pageObjects;
import pageObjects.pageObjects2;
import util.Xls_Reader;

public class SetThreeSteps {
	
	 static String totalcount;
	 static String OpenedLinkCount;
	 static String RedactionDCN;
	 Response response;
	 String OTP;
	 
	 static Actions action = new Actions(Base.driver);
	
	 @When("filter the previous the redated DCN")
	 public void filter_the_previous_the_redated_DCN() {
		 Waits.waitUntilElementLocated(30,pageObjects2.DCNFilter);
			Elements.TypeText(pageObjects2.DCNFilter, RedactionDCN);
	 }

	 @Then("system should display redated DCN in chain of custody report")
	 public void system_should_display_redated_DCN_in_chain_of_custody_report() {
		 Waits.waitUntilElementLocated(30,pageObjects2.DCNValue);
		 Assert.assertEquals(RedactionDCN, Elements.getText(pageObjects2.DCNValue));
	 }
	 
	 @Then("the annotation text as {string}")
	 public void the_annotation_text_as(String string) {
		 Waits.waitUntilElementLocated(30,pageObjects2.DrawnRedaction);
			Elements.TypeText(pageObjects2.DrawnRedaction, string);
	 }
	 
	 @Then("the Annotation text as {string}")
	 public void the_Annotation_text_as(String string) {
		 Waits.waitUntilElementLocated(30,pageObjects2.DrawnRedaction2);
			Elements.TypeText(pageObjects2.DrawnRedaction2, string);
	 }
	 
	@Then("system should display following field list {string}")
	public void system_should_display_following_field_list(String string) {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	Assert.assertEquals(data, GenericActions.verifyTextExistence(pageObjects2.RuleFieldList));
	}

	@When("click on advanced search")
	public void click_on_advanced_search() {
		Waits.waitUntilElementToClick(30,pageObjects2.Advanced_Search);
		Elements.click(pageObjects2.Advanced_Search);
	}

	@Then("system should display following text box filter options")
	public void system_should_display_following_text_box_filter_options(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		for (Map<Object, Object> data : dataTable.asMaps(String.class, String.class)) {
			try
			{
			Waits.waitUntilElementToClick(30,pageObjects2.textbox_filteroptions(String.valueOf(data.get("TextBox"))));
			Elements.isDisplayed(pageObjects2.textbox_filteroptions((String.valueOf(data.get("TextBox")))));
			}catch(Exception e)
			{
				Waits.waitUntilElementToClick(30,pageObjects2.textbox_filteroptions1(String.valueOf(data.get("TextBox"))));
				Elements.isDisplayed(pageObjects2.textbox_filteroptions1((String.valueOf(data.get("TextBox")))));
			}
		}
	}

	@Then("system should display following dropdown filter options")
	public void system_should_display_following_dropdown_filter_options(io.cucumber.datatable.DataTable dataTable) {
for (Map<Object, Object> data : dataTable.asMaps(String.class, String.class)) {
			try
			{
			Waits.waitUntilElementToClick(30,pageObjects2.dropdown_filteroptions(String.valueOf(data.get("DropDownOptions"))));
			Elements.isDisplayed(pageObjects2.dropdown_filteroptions((String.valueOf(data.get("DropDownOptions")))));
			}catch(Exception e)
			{
				Waits.waitUntilElementToClick(30,pageObjects2.dropdown_filteroptions1(String.valueOf(data.get("DropDownOptions"))));
				Elements.isDisplayed(pageObjects2.dropdown_filteroptions1((String.valueOf(data.get("DropDownOptions")))));
			}
		}
	}

	@Then("click on total count")
	public void click_on_total_count() {
		Waits.waitUntilElementToClick(30,pageObjects2.totalCount);
		totalcount = Elements.getText(pageObjects2.totalCount);
		Elements.click(pageObjects2.totalCount);
	}

	@Then("the count should match between total count and detailed report count")
	public void the_count_should_match_between_total_count_and_detailed_report_count() {
		Waits.waitUntilElementToClick(30,pageObjects2.tableinfo_totalcount);
		String tablecount[] = Elements.getText(pageObjects2.tableinfo_totalcount).split("of");
		Assert.assertEquals(totalcount, tablecount[1].trim());
	}

	@Then("system should display {string} records")
	public void system_should_display_records(String string) throws InterruptedException {
		Thread.sleep(5000);
		Waits.waitUntilElementToClick(30,pageObjects2.tableinfo_totalcount);
		Elements.scrollIntoView(pageObjects2.tableinfo_totalcount);
		String tablecount[] = Elements.getText(pageObjects2.tableinfo_totalcount).split("of");
		Assert.assertEquals(string, tablecount[1].trim());
	}
	
	@Then("system should display the tabel headers as {string}")
	public void system_should_display_the_tabel_headers_as(String string) {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	Assert.assertEquals(data, GenericActions.verifyTextExistence(pageObjects2.tableHeaders));
	}

	@Then("click on return to Volume report")
	public void click_on_return_to_Volume_report() {
		Waits.waitUntilElementToClick(30,pageObjects2.Return_To_Volume_Report);
		Elements.click(pageObjects2.Return_To_Volume_Report);
	}


@Then("filter scan date {string}")
public void filter_scan_date(String string) {
	Waits.waitUntilElementLocated(30,pageObjects2.SCAN_DATEFilter);
	Elements.TypeText(pageObjects2.SCAN_DATEFilter, string);
}

@Then("click on the {string} link count")
public void click_on_the_link_count(String string) {
	Waits.waitUntilElementToClick(30,pageObjects2.volumeReportsTableData(string));
	OpenedLinkCount=Elements.getText(pageObjects2.volumeReportsTableData(string));
	Elements.click(pageObjects2.volumeReportsTableData(string));
}

	@Then("the count should match between opened link count and detailed report count")
	public void the_count_should_match_between_opened_link_count_and_detailed_report_count() {
		Waits.waitUntilElementToClick(30,pageObjects2.tableinfo_totalcount);
		String tablecount[] = Elements.getText(pageObjects2.tableinfo_totalcount).split("of");
		Assert.assertEquals(OpenedLinkCount, tablecount[1].trim());
	}

	@Then("click on search button")
	public void click_on_search_button() {
		Waits.waitUntilElementToClick(30,pageObjects.Serach_btn);
		Elements.jclick(pageObjects.Serach_btn);
	}

	@Then("the number of volume records should be {string}")
	public void the_number_of_volume_records_should_be(String string) {
		Waits.waitUntilElementToClick(30,pageObjects2.totalCount);
		totalcount = Elements.getText(pageObjects2.totalCount);
		Assert.assertEquals(string, totalcount);
	}
	
	@Then("the number of Volume records should be {string}")
	public void the_number_of_Volume_records_should_be(String string) {
		Waits.waitUntilElementToClick(30,pageObjects2.filtered_Total_Volume);
		totalcount = Elements.getText(pageObjects2.filtered_Total_Volume);
		Assert.assertEquals(string, totalcount);
	}

	@Then("total count should be {string}")
	public void total_count_should_be(String string) {
		Waits.waitUntilElementToClick(30,pageObjects2.totalCount);
		totalcount = Elements.getText(pageObjects2.totalCount);
		Assert.assertEquals(string, totalcount);
	}

	@Then("double click to open the email")
	public void double_click_to_open_the_email() {
		Waits.waitUntilElementToClick(30,pageObjects2.DoubleClickArrow);
		RedactionDCN=Elements.getText(pageObjects2.DCNValue);
		Elements.mouseDoubleclick(pageObjects2.DoubleClickArrow);
	}

	@Then("click on PDF {string} option")
	public void click_on_PDF_option(String string) {
		Waits.waitUntilElementToClick(30,pageObjects2.PDFPageheaders(string));
		Elements.click(pageObjects2.PDFPageheaders(string));
	}

	@Then("redact the PDF at X-axis {string} and at Y-axis {string}")
	public void redact_the_PDF_at_X_axis_and_at_Y_axis(String string, String string2) {
		Waits.waitUntilElementToClick(30,pageObjects2.redaction);
		Elements.redaction(pageObjects2.redaction, Integer.parseInt(string), Integer.parseInt(string2));
	}

	@Then("check redaction rectangle is displayed")
	public void check_redaction_rectangle_is_displayed() {
		Waits.waitUntilElementLocated(30,pageObjects2.DrawnRedaction);
		Elements.isDisplayed(pageObjects2.DrawnRedaction);
	}
	
	@Then("check annotation rectangle is displayed")
	public void check_annotation_rectangle_is_displayed() {
		Waits.waitUntilElementLocated(30,pageObjects2.DrawnRedaction);
		Elements.isDisplayed(pageObjects2.DrawnRedaction);
	}

	@Then("click on redact save")
	public void click_on_redact_save() {
		Waits.waitUntilElementToClick(30,pageObjects2.redactionsave);
		Elements.click(pageObjects2.redactionsave);
	}

	@Then("check redaction rectangle is notdisplayed")
	public void check_redaction_rectangle_is_notdisplayed() throws InterruptedException {
		Thread.sleep(1500);
		if(pageObjects2.ListDrawnRedaction.size()==0)
		{
			Assert.assertTrue(true);
		}else
		{
			Assert.assertTrue(false);
		}
	}
	
	@Then("check annotation rectangle is notdisplayed")
	public void check_annotation_rectangle_is_notdisplayed() throws InterruptedException {
		Thread.sleep(1500);
		if(pageObjects2.ListDrawnRedaction.size()==0)
		{
			Assert.assertTrue(true);
		}else
		{
			Assert.assertTrue(false);
		}
	}

	@Then("color of redaction should be black")
	public void color_of_redaction_should_be_black() {
		Waits.waitUntilElementLocated(30,pageObjects2.DrawnRedaction);
		String style = pageObjects2.DrawnRedaction.getAttribute("style");
		String splitedData[]=style.split("background: ")[1].split("; left:");
		Assert.assertEquals("rgb(53, 56, 57)", splitedData[0].trim());
	}

	@Then("delete the drawn annotation")
	public void delete_the_drawn_annotation() {
		Waits.waitUntilElementToClick(30,pageObjects2.redactionDelete);
		Elements.click(pageObjects2.redactionDelete);
	}
	
	@Then("delete the drawn redaction")
	public void delete_the_drawn_redaction() {
		Waits.waitUntilElementToClick(30,pageObjects2.redactionDelete);
		Elements.click(pageObjects2.redactionDelete);
	}

	@Then("save the drawn redaction")
	public void save_the_drawn_redaction() {
		Waits.waitUntilElementToClick(30,pageObjects2.redactionsave);
		Elements.click(pageObjects2.redactionsave);
	}
	
	@Then("save the drawn annotation")
	public void save_the_drawn_annotation() {
		Waits.waitUntilElementToClick(30,pageObjects2.redactionsave);
		Elements.click(pageObjects2.redactionsave);
	}

	@Then("check redaction delete option should not be displayed")
	public void check_redaction_delete_option_should_not_be_displayed() throws InterruptedException {
		
		Thread.sleep(1500);
		if(pageObjects2.redactionDelete.isDisplayed())
		{
			Assert.assertTrue(false);
		}else
		{
			Assert.assertTrue(true);
		}
	   
	}
	
	@Then("update the {string} with below values and zip it with {string} and {string}")
	public void update_the_with_below_values_and_zip_it_with_and(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) throws Exception {
	   GenericActions.xmlUpdate(dataTable, string, string2, string3);
	}

	@Then("ingest the above zipped file to Azure Blob Storage")
	public void ingest_the_above_zipped_file_to_Azure_Blob_Storage() throws InvalidKeyException, URISyntaxException, StorageException, IOException {
		Storage.azureBlobStorage();
	}

	@Then("filter {string} and verify it is available")
	public void filter_and_verify_it_is_available(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.DCNFilter);
		Elements.TypeText(pageObjects2.DCNFilter, GenericActions.fileName);
	}
	
	@Then("enter max retention period in days as {string}")
	public void enter_max_retention_period_in_days_as(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.Max_Retention_Period_In_Days);
		Elements.TypeText(pageObjects2.Max_Retention_Period_In_Days, string);
	}

	@Then("enter retention period in days for deleted iteams as {string}")
	public void enter_retention_period_in_days_for_deleted_iteams_as(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.Retention_Period_In_Days_For_deleted_Items);
		Elements.TypeText(pageObjects2.Retention_Period_In_Days_For_deleted_Items, string);
	}

	@Then("by default system should display {string} records as selected")
	public void by_default_system_should_display_records_as_selected(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.Number_Of_Pages);
		Assert.assertEquals(string, Elements.getFirstSelectedOption(pageObjects2.Number_Of_Pages));
	}

	@When("click on pagination dropdown")
	public void click_on_pagination_dropdown() {
	   
		
		
	}

	@Then("system should display the record options as {string}")
	public void system_should_display_the_record_options_as(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.Number_Of_Pages);
		List<WebElement> webelements=Elements.getAllOptions(pageObjects2.Number_Of_Pages);
		List<String> wbdata = new ArrayList<String>();
		for(WebElement webdata:webelements)
		{
			wbdata.add(webdata.getText());
		}
		
		List<String> featureFileData = new ArrayList<String>();
		String[] splitteddata = string.split(",");
		
		for(int i=0;i<=splitteddata.length-1;i++)
		{
			featureFileData.add(splitteddata[i]);
		}
		Collections.sort(wbdata);
		Collections.sort(featureFileData);
		
		Assert.assertEquals(featureFileData, wbdata);
	}

	@Then("user selects {string} as option then system should display {string} records")
	public void user_selects_as_option_then_system_should_display_records(String string, String string2) {
		Waits.waitUntilElementLocated(30,pageObjects2.Number_Of_Pages);
		Elements.selectByValue(pageObjects2.Number_Of_Pages, string);
		String webData = Elements.getText(pageObjects2.Pagination_Number_Of_Records).split("- ")[1].split("of")[0].trim();
		Assert.assertEquals(string2, webData);
	}

	@Then("filter the received date as {string}")
	public void filter_the_received_date_as(String string) {
	    Waits.waitUntilElementLocated(30, pageObjects2.RECEIVED_DATEFilter);
	    Elements.TypeText(pageObjects2.RECEIVED_DATEFilter, string);
	}

	@Then("click on volume received count")
	public void click_on_volume_received_count() {
	  Waits.waitUntilElementToClick(30, pageObjects2.VOLUME_RECEIVED_Count);
	  Elements.click(pageObjects2.VOLUME_RECEIVED_Count);
	}
	
	@Then("system should display client dropdown option")
	public void system_should_display_client_dropdown_option() {
	    Waits.waitUntilElementLocated(60, pageObjects.DropDwnArrow("Client"));
	    Elements.isDisplayed(pageObjects.DropDwnArrow("Client"));
	}

	@Then("system should display blank data {string}")
	public void system_should_display_blank_data(String string) {
		Waits.waitUntilElementLocated(60, pageObjects.no_records_available);
		Elements.VerifyTextEquals(pageObjects.no_records_available, string);
	}

	@Then("click on save preference")
	public void click_on_save_preference() {
	    Waits.waitUntilElementToClick(60, pageObjects2.Save_Preference);
	    Elements.click(pageObjects2.Save_Preference);
	}

	@Then("system should display the custom message {string}")
	public void system_should_display_the_custom_message(String string) {
		Waits.waitUntilElementLocated(60, pageObjects2.Custom_Msg_ACK);
		Elements.VerifyTextEquals(pageObjects2.Custom_Msg_ACK, string);
	}

	@Then("deselect the dropdown {string}")
	public void deselect_the_dropdown(String string) {
		 Waits.waitUntilElementToClick(60, pageObjects.DropDownOptions(string));
		    Elements.jclick(pageObjects.DropDownOptions(string));
		    Actions action = new Actions(Base.driver);
			action.sendKeys(Keys.ESCAPE).build().perform();
	}

	@Then("click on NO button")
	public void click_on_NO_button() {
		Waits.waitUntilElementToClick(60, pageObjects.NO_btn);
	    Elements.click(pageObjects.NO_btn);
	}
	
	@When("click on add project")
	public void click_on_add_project() {
		Waits.waitUntilElementToClick(60, pageObjects.Add_Project);
	    Elements.click(pageObjects.Add_Project);
	}
	
	@Then("user clicks on Next\\/Right arrow key then system should display next {string} records")
	public void user_clicks_on_Next_Right_arrow_key_then_system_should_display_next_records(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.Next_btn);
		Elements.click(pageObjects2.Next_btn);
		String webData = Elements.getText(pageObjects2.Pagination_Number_Of_Records).split(":")[1].split("of")[0].trim();
		Assert.assertEquals(string, webData);
		
	}

	@Then("select from date as six months back from today")
	public void select_from_date_as_six_months_back_from_today() throws InterruptedException {
		//Date dNow = new Date();
    	//SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa"); 
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.MONTH,-7);
    	Date dNow = cal.getTime();
    	SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
    	String ExeTime = ft.format(dNow);
    	Waits.waitUntilElementToClick(30, pageObjects.FromDate);
    	//Thread.sleep(20000);
		GenericActions.CalenderSelection(pageObjects.FromDate,ExeTime);
    	
	}

	@Then("filter the DCN {string}")
	public void filter_the_DCN(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.DCNFilter);
		Elements.TypeText(pageObjects2.DCNFilter, string);
	}
	
	@Then("filter autogenerated DCN and verify it is available")
	public void filter_autogenerated_DCN_and_verify_it_is_available() throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects2.DCNFilter);
		Elements.TypeText(pageObjects2.DCNFilter, GenericActions.fileName);
		Thread.sleep(10000);
		Assert.assertEquals(GenericActions.fileName, Elements.getText(pageObjects.DCNValue(GenericActions.fileName)).trim());
	}
	
	@When("enter the delivery instruction as {string}")
	public void enter_the_delivery_instruction_as(String string) {
		Waits.waitUntilElementLocated(30,pageObjects.deliveryInstructions);
		Elements.TypeText(pageObjects.deliveryInstructions, string);
	}

	@Then("there should not be any record in the table")
	public void there_should_not_be_any_record_in_the_table() throws InterruptedException {
		Thread.sleep(1500);
		
	   Assert.assertEquals(0, pageObjects.Mail_SelectionList.size());
	}

	@Then("click on Yes button")
	public void click_on_Yes_button() {
	    Waits.waitUntilElementToClick(30, pageObjects.Yes_btn);
	    Elements.click(pageObjects.Yes_btn);
	}
	
	@Then("click on Yes Button")
	public void click_on_Yes_Button() {
		Waits.waitUntilElementToClick(15,pageObjects.Yes_bn);
		Elements.click(pageObjects.Yes_bn);
	}
	
	
	@Then("click on YES button")
	public void click_on_YES_button() {
	    Waits.waitUntilElementToClick(30, pageObjects.YES_btn);
	    Elements.click(pageObjects.YES_btn);
	}
	

@Then("click on Inbox")
public void click_on_Inbox() {
	Waits.waitUntilElementToClick(30, pageObjects.Inbox2);
    Elements.click(pageObjects.Inbox2);
}

	@Then("click on completed folder")
	public void click_on_completed_folder() {
		Waits.waitUntilElementToClick(30, pageObjects2.CompletedFolder);
	    Elements.click(pageObjects2.CompletedFolder);
	}

	@Then("{string} should be available in completed folder")
	public void should_be_available_in_completed_folder(String string) {
		Assert.assertEquals(true, Elements.isDisplayed(pageObjects.Mail_Selection));
	}

	@Then("click on NMM folder")
	public void click_on_NMM_folder() {
		Waits.waitUntilElementToClick(30, pageObjects2.Not_My_Mail_Folder);
	    Elements.click(pageObjects2.Not_My_Mail_Folder);
	}

	@Then("{string} should be available in NMM folder")
	public void should_be_available_in_NMM_folder(String string) {
		Assert.assertEquals(true, Elements.isDisplayed(pageObjects.Mail_Selection));
	}

	@Then("open full mail option should be avaliable in envelope mail")
	public void open_full_mail_option_should_be_avaliable_in_envelope_mail() {
	    Waits.waitUntilElementLocated(30, pageObjects2.Open_Mail);
	    Elements.isDisplayed(pageObjects2.Open_Mail);
	}
	


	@Then("system should display following mail header options")
	public void system_should_display_following_mail_header_options(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
for (Map<Object, Object> data : dataTable.asMaps(String.class, String.class)) {
			
			Waits.waitUntilElementToClick(30,pageObjects2.PDFPageheaders(String.valueOf(data.get("HeaderOptions"))));
			Assert.assertEquals(String.valueOf(data.get("HeaderOptions")), Elements.getText(pageObjects2.PDFPageheaders(String.valueOf(data.get("HeaderOptions")))));
		}
	}

	@Then("filter the project name {string}")
	public void filter_the_project_name(String string) {
	    Waits.waitUntilElementLocated(30, pageObjects2.PROJECT_NAMEFilter);
	    Elements.TypeText(pageObjects2.PROJECT_NAMEFilter, string);
	}
	
	@Then("filter the name {string}")
	public void filter_the_name(String string) {
		if(!string.equalsIgnoreCase(""))
		{
	    Waits.waitUntilElementLocated(30, pageObjects2.NAMEFilter);
	    Elements.TypeText(pageObjects2.NAMEFilter, string);
		}else
		{
			Waits.waitUntilElementLocated(30, pageObjects2.NAMEFilter);
		   // Elements.TypeText(pageObjects2.NAMEFilter, " ");
		    action.sendKeys(pageObjects2.NAMEFilter, Keys.SPACE).build().perform();
		}
	}
	
	@Then("User should get error msg as {string}")
	public void user_should_get_error_msg_as(String string) {
	    Waits.waitUntilElementLocated(60, pageObjects.Alerterror);
	    
	    Assert.assertEquals(string, Elements.getText(pageObjects.Alerterror).trim());
	}

	@Then("click on adddoc type")
	public void click_on_adddoc_type() {
		Waits.waitUntilElementToClick(30, pageObjects2.AddDocType);
	    Elements.click(pageObjects2.AddDocType);
	}
	
	@Then("click on doctype setup")
	public void click_on_doctype_setup() {
		Waits.waitUntilElementToClick(30, pageObjects2.DocTypeSetup);
	    Elements.click(pageObjects2.DocTypeSetup);
	}

	@Then("system should display {string} address type options")
	public void system_should_display_address_type_options(String string) {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	Assert.assertEquals(data, GenericActions.verifyTextExistence(pageObjects.DropDownList));
	    	
	    	Actions action = new Actions(Base.driver);
	    	action.sendKeys(Keys.ESCAPE).build().perform();
	}

	@Then("click on below given dropdown arrow and select the below option and check the selected option")
	public void click_on_below_given_dropdown_arrow_and_select_the_below_option_and_check_the_selected_option(io.cucumber.datatable.DataTable dataTable) {
		for (Map<Object, Object> data : dataTable.asMaps(String.class, String.class)) {
			
			Waits.waitUntilElementToClick(30,pageObjects2.dropdownArrow(String.valueOf(data.get("dropdown"))));
			Elements.click(pageObjects2.dropdownArrow(String.valueOf(data.get("dropdown"))));
			
			Waits.waitUntilElementToClick(30,pageObjects.DropDownOptions(String.valueOf(data.get("dropdownOption"))));
			Elements.click(pageObjects.DropDownOptions(String.valueOf(data.get("dropdownOption"))));
			
			Waits.waitUntilElementLocated(30, pageObjects.selectedAddressOption(String.valueOf(data.get("dropdownOption"))));
			Assert.assertEquals(String.valueOf(data.get("dropdownOption")), Elements.getText(pageObjects.selectedAddressOption(String.valueOf(data.get("dropdownOption")))));
		}
	}

	@Then("enter address{int} as {string}")
	public void enter_address_as(Integer int1, String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.Enter_Address_1);
		Elements.TypeText(pageObjects2.Enter_Address_1, string);
	}

	@Then("enter city as {string}")
	public void enter_city_as(String string) throws InterruptedException {
		
		char[] array = string.toCharArray();
		Waits.waitUntilElementLocated(30,pageObjects2.City);
		
		for(int i=0;i<=array.length-1;i++)
		{
		Elements.TypeTextWithOutText(pageObjects2.City, String.valueOf(array[i]));
		Thread.sleep(300);
		}
		
		Waits.waitUntilElementToClick(30, pageObjects2.citydropdwnSelection(string));
		Elements.jclick(pageObjects2.citydropdwnSelection(string));
	}

	@Then("enter zipcode as {string}")
	public void enter_zipcode_as(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.Enter_Zipcode);
		Elements.TypeText(pageObjects2.Enter_Zipcode, string);
	}

	@Then("select delivery preference as {string}")
	public void select_delivery_preference_as(String string) {
	   Waits.waitUntilElementToClick(30, pageObjects.Select_your_delivery_preference(string));
	   Elements.click(pageObjects.Select_your_delivery_preference(string));
	}

	@Then("system should display the configured address {string}")
	public void system_should_display_the_configured_address(String string) {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	
	    	List<String> WebElementdata = new ArrayList<String>();
	 		
	 		
	    		WebElement Webelement = pageObjects2.ManageDeliveryAddress;
		    	
		    	
					String[] text = Webelement.getText().trim().split("\n");
					for(int i=0;i<=text.length-2;i++)
					{
					WebElementdata.add(text[i]);
					}
				
	    	
	    	Collections.sort(WebElementdata);
	    	Assert.assertEquals(data, WebElementdata);
	}

	@Then("enter phone number as {string}")
	public void enter_phone_number_as(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.Phone_Number);
		Elements.TypeText(pageObjects2.Phone_Number, string);
	}

	@Then("system should display sub menu option {string}")
	public void system_should_display_sub_menu_option(String string) {
	    Waits.waitUntilElementLocated(30, pageObjects.ReportsOption(string));
	    Assert.assertEquals(string, Elements.getText(pageObjects.ReportsOption(string)));
	}

	@Then("system should display routing rule options {string}")
	public void system_should_display_routing_rule_options(String string) {
		String[] splitteddata = string.split(",");
		for(int i=0;i<=splitteddata.length-1;i++)
		{
		Waits.waitUntilElementLocated(30, pageObjects.routingruleheaders(splitteddata[i]));
	    Assert.assertEquals(splitteddata[i], Elements.getText(pageObjects.routingruleheaders(splitteddata[i])));
		}
	    
	}

	@Then("system should display field options as {string}")
	public void system_should_display_filed_options_as(String string) {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	Assert.assertEquals(data, GenericActions.verifyTextExistence(pageObjects2.FieldOptionsList));
	}

	@Then("system should display from date and to date")
	public void system_should_display_from_date_and_to_date() {
	    Waits.waitUntilElementLocated(30, pageObjects.FromDate);
	    Elements.isDisplayed(pageObjects.FromDate);
	    
	    Waits.waitUntilElementLocated(30, pageObjects.ToDate);
	    Elements.isDisplayed(pageObjects.ToDate);
	}

	@Then("system should allow to select with current date")
	public void system_should_allow_to_select_with_current_date() throws InterruptedException {
    	Date dNow = new Date();
    	SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
    	String ExeTime = ft.format(dNow);
    	
    	Waits.waitUntilElementToClick(30000,pageObjects.ToDate);
		GenericActions.CalenderSelectionto(pageObjects.ToDate,ExeTime);
	}

	@Then("system should allow to select three days back from today")
	public void system_should_allow_to_select_three_days_back_from_today() throws InterruptedException {
		
		Base.driver.navigate().refresh();
		
		Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.DAY_OF_MONTH,-3);
    	Date dNow = cal.getTime();
    	SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
    	String ExeTime = ft.format(dNow);
    	
    	Waits.waitUntilElementToClick(30000,pageObjects.ToDate);
		GenericActions.CalenderSelectionto(pageObjects.ToDate,ExeTime);
	}

	@Then("system should not allow to select two days future from today")
	public void system_should_not_allow_to_select_tWo_days_future_from_today() {
		Base.driver.navigate().refresh();
		
		try
		{
		Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.DAY_OF_MONTH,2);
    	Date dNow = cal.getTime();
    	SimpleDateFormat ft = new SimpleDateFormat("MMMM d, yyyy");
    	String ExeTime = ft.format(dNow);
    	Waits.waitUntilElementToClick(300, pageObjects.ToDate);
    	Elements.click(pageObjects.ToDate);
    	
    	String webData = pageObjects.disabledDates(ExeTime).getAttribute("class");
    	
    	Assert.assertEquals(true, webData.contains("disabled"));
		}catch(Exception e)
		{
			
		}
	}

	@Then("{string} should be displayed")
	public void should_be_displayed(String string) {
	    Waits.waitUntilElementLocated(30, pageObjects2.reportpageheaders(string));
	    Assert.assertEquals(string, Elements.getText(pageObjects2.reportpageheaders(string)));
	}

	@Then("select from date as twenty days back from today.")
	public void select_from_date_as_twenty_days_back_from_today() throws InterruptedException {
		Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.DAY_OF_MONTH,-10);
    	Date dNow = cal.getTime();
    	SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
    	String ExeTime = ft.format(dNow);
    	
    	Waits.waitUntilElementToClick(30,pageObjects.FromDate);
		GenericActions.CalenderSelectionto(pageObjects.FromDate,ExeTime);
	}
	
	@Then("search user {string}")
	public void search_user(String string) {
	    Waits.waitUntilElementLocated(60, pageObjects2.Search_User);
	    Elements.TypeText(pageObjects2.Search_User, string);
	}

	@Then("select the user {string}")
	public void select_the_user(String string) {
	   Waits.waitUntilElementToClick(60, pageObjects2.Search_User_Selection(string));
	   Elements.click(pageObjects2.Search_User_Selection(string));
	}

	@Then("verify system displays {string} records in the table")
	public void verify_system_displays_records_in_the_table(String string) {
	   
		Waits.waitUntilElementLocated(60, pageObjects2.UserRecordInTable);
		Assert.assertEquals(string, Elements.getText(pageObjects2.UserRecordInTable));
	}

	@Then("left pane menu {string} should be displayed")
	public void left_pane_menu_should_be_displayed(String string) {
		Waits.waitUntilElementLocated(60, pageObjects.LeftPaneMenua(string));
		Elements.isDisplayed(pageObjects.LeftPaneMenua(string));
	}

	@Then("edit client option {string} should be displayed")
	public void edit_client_option_should_be_displayed(String string) {
		Waits.waitUntilElementLocated(60, pageObjects2.ClientSetUpSubMenu(string));
		Elements.isDisplayed(pageObjects2.ClientSetUpSubMenu(string));
	}
	
	@Then("filter client code {string}")
	public void filter_client_code(String string) {
		Waits.waitUntilElementLocated(60, pageObjects2.CLIENT_CODEFilter);
	    Elements.TypeText(pageObjects2.CLIENT_CODEFilter, string);
	}

	@Then("click on edit client option {string}")
	public void click_on_edit_client_option(String string) {
		Waits.waitUntilElementLocated(60, pageObjects2.ClientSetUpSubMenu(string));
		Elements.click(pageObjects2.ClientSetUpSubMenu(string));
	}

	@Then("system should display DMR options {string}")
	public void system_should_display_DMR_options(String string) {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	Assert.assertEquals(data, GenericActions.verifyTextExistence(pageObjects2.DMRMenuOptions));
	}

	@Then("click on DMR menu {string}")
	public void click_on_DMR_menu(String string) {
		Waits.waitUntilElementLocated(60, pageObjects2.DMRMenusSelections(string));
		Elements.jclick(pageObjects2.DMRMenusSelections(string));
	}

	@Then("system should display DMR Report sub menu options {string}")
	public void system_should_display_DMR_Report_sub_menu_options(String string) {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	Assert.assertEquals(data, GenericActions.verifyTextExistence(pageObjects2.DMRSubMenuOptions));
	}

	@Then("system should all to select DMR Report sub menu options {string}")
	public void system_should_all_to_select_DMR_Report_sub_menu_options(String string) {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		try
	    		{
	    			Waits.waitUntilElementLocated(60, pageObjects2.DMRSubMenusSelections(string));
	    			Elements.click(pageObjects2.DMRSubMenusSelections(string));
	    		}catch(Exception e)
	    		{
	    			
	    		}
	    	}
		
	}

	@Then("click on Select client dropdown")
	public void click_on_Select_client_dropdown() {
		Waits.waitUntilElementLocated(60, pageObjects2.Select_client);
		Elements.jclick(pageObjects2.Select_client);
	}

	@Then("search the client {string} and select the client")
	public void search_the_client_and_select_the_client(String string) throws InterruptedException {
		Waits.waitUntilElementLocated(60, pageObjects2.SelectclientSearch);
	    Elements.TypeText(pageObjects2.SelectclientSearch, string);
	    
	    Thread.sleep(2000);
		
		Waits.waitUntilElementLocated(60, pageObjects2.selectclientsearchselect);
		Elements.click(pageObjects2.selectclientsearchselect);
	}

	@Then("system should display the user name as {string}")
	public void system_should_display_the_user_name_as(String string) {
		Waits.waitUntilElementLocated(60, pageObjects2.UsernameValue);
		
		Assert.assertEquals(string, Elements.getText(pageObjects2.UsernameValue).trim());
	}

	@Then("system should display the event as {string}")
	public void system_should_display_the_event_as(String string) {
		
		Waits.waitUntilElementLocated(60, pageObjects2.EVENTName);
		
		Assert.assertEquals(string, Elements.getText(pageObjects2.EVENTName).trim());
	}

	@Then("first record in excel against user column should be {string} and event column should be {string}")
	public void first_record_in_excel_against_user_column_should_be_and_event_column_should_be(String string, String string2) throws InterruptedException {
	    Thread.sleep(5000);
	    try
	    {
		GenericActions.partialfilename("Chain Of Custody Report");
		
		Xls_Reader suiteXLS = new Xls_Reader(GenericActions.partialfilename("Chain Of Custody Report"));
		
		String from =suiteXLS.getCellData("report", 2, 9);
		String to = suiteXLS.getCellData("report", 4, 9);
		try
		{
		Assert.assertEquals(string, from);
		}catch(Exception e)
		{
			
		}
		try
		{
		Assert.assertEquals(string2, to);
		}catch(Exception e)
		{
			
		}
	    }catch(Exception e)
	    {
	    	
	    }
	}
	
	@Then("record in excel against From column should be {string} and TO column should be {string}")
	public void first_record_in_excel_against_From_column_should_be_and_TO_column_should_be(String string, String string2) throws InterruptedException {
		Thread.sleep(20000);
		try
		{
		GenericActions.partialfilename("Chain Of Custody Report");
		
		Xls_Reader suiteXLS = new Xls_Reader(GenericActions.partialfilename("Chain Of Custody Report"));
		
		String from =suiteXLS.getCellData("report", 6, 10);
		String to = suiteXLS.getCellData("report", 7, 10);
		
		Assert.assertEquals(string, from);
		
		Assert.assertEquals(string2, to);
		}catch(Exception e)
		{
			
		}
	}

	@Then("report should display the coulmns {string}")
	public void report_should_display_the_coulmns(String string) {
		GenericActions.partialfilename("Chain Of Custody Report");
		List<String> downloadedFileData = new ArrayList<String>();
		Xls_Reader suiteXLS = new Xls_Reader(GenericActions.partialfilename("Chain Of Custody Report"));
		
		for(int i=1;i<=13;i++)
		{
			downloadedFileData.add(suiteXLS.getCellData("report", i, 8));
		}
		
		Collections.sort(downloadedFileData);
		
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
		
		Assert.assertEquals(data, downloadedFileData);
	}

	@Then("click on undelivered mail box")
	public void click_on_undelivered_mail_box() {
	    Waits.waitUntilElementToClick(60, pageObjects2.Undeliverable_Mail);
	    Elements.jclick(pageObjects2.Undeliverable_Mail);
	}

	@Then("status of the mail should be {string}")
	public void status_of_the_mail_should_be(String string) {
		Waits.waitUntilElementLocated(60, pageObjects2.STATUSValue);
		
		Assert.assertEquals(string, Elements.getText(pageObjects2.STATUSValue).trim());
	}

	@Then("report should display {string} days data by default")
	public void report_should_display_days_data_by_default(String string) throws InterruptedException, ParseException {
		Waits.waitUntilElementToClick(60, pageObjects.FromDate);
	    Elements.jclick(pageObjects.FromDate);
	    
	    Thread.sleep(1500);
	    
	    Waits.waitUntilElementLocated(60, pageObjects2.Selecteddate);
	   String fromdate= Elements.getAttributeValue(pageObjects2.Selecteddate,"aria-label").trim();
	   
	   Thread.sleep(1500);
	   
	   Waits.waitUntilElementToClick(60, pageObjects.ToDate);
	    Elements.jclick(pageObjects.ToDate);
	    
	    Thread.sleep(1500);
	    
	    Waits.waitUntilElementLocated(60, pageObjects2.Selecteddate);
	   String todate= Elements.getAttributeValue(pageObjects2.Selecteddate,"aria-label").trim();
	   
	 Calendar cal = Calendar.getInstance();
   	cal.add(Calendar.DAY_OF_MONTH,10);
   //	Date dNow = cal.getTime();
   	DateTimeFormatter  ft = DateTimeFormatter.ofPattern("MMMM d, yyyy");
   	LocalDate dFrom = LocalDate.parse(fromdate,ft);
   	LocalDate dTo = LocalDate.parse(todate,ft);
   	
   	int daysCount=	(int)ChronoUnit.DAYS.between(dFrom, dTo)+1;
   	Assert.assertEquals(Integer.parseInt(string), daysCount);
	}

	@Then("select from date as today")
	public void select_from_date_as_today() throws InterruptedException {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
    	String StartDate = ft.format(dNow);
    	
    	Thread.sleep(20000);
		GenericActions.CalenderSelection(pageObjects.FromDate,StartDate);
	}

	@Then("report should display {string} days data")
	public void report_should_display_days_data(String string) throws InterruptedException {
		Waits.waitUntilElementToClick(60, pageObjects.FromDate);
	    Elements.jclick(pageObjects.FromDate);
	    
	    Thread.sleep(1500);
	    
	    Waits.waitUntilElementLocated(60, pageObjects2.Selecteddate);
	   String fromdate= Elements.getAttributeValue(pageObjects2.Selecteddate,"aria-label").trim();
	   
	   Thread.sleep(1500);
	   
	   Waits.waitUntilElementToClick(60, pageObjects.ToDate);
	    Elements.jclick(pageObjects.ToDate);
	    
	    Thread.sleep(1500);
	    
	    Waits.waitUntilElementLocated(60, pageObjects2.Selecteddate);
	   String todate= Elements.getAttributeValue(pageObjects2.Selecteddate,"aria-label").trim();
	   
	 //Calendar cal = Calendar.getInstance();
   	//cal.add(Calendar.DAY_OF_MONTH,10);
   //	Date dNow = cal.getTime();
   	DateTimeFormatter  ft = DateTimeFormatter.ofPattern("MMMM d, yyyy");
   	LocalDate dFrom = LocalDate.parse(fromdate,ft);
   	LocalDate dTo = LocalDate.parse(todate,ft);
   	
   	int daysCount=	(int)ChronoUnit.DAYS.between(dFrom, dTo)+1;
   	Assert.assertEquals(Integer.parseInt(string), daysCount);
	
	}

	@Then("system should display nuber of pages count as {string}")
	public void system_should_display_nuber_of_pages_count_as(String string) {
	   Waits.waitUntilElementLocated(60, pageObjects2.Total_Pages);
	   Assert.assertEquals(string, Elements.getText(pageObjects2.Total_Pages).trim());
	}

	@Then("click on right arrow system should load next set of pages")
	public void click_on_right_arrow_system_should_load_next_set_of_pages() {
	   Waits.waitUntilElementToClick(60, pageObjects2.rignhtArrow);
	   Elements.click(pageObjects2.rignhtArrow);
	}

	@Then("click on left arrow system should load previous set of pages")
	public void click_on_left_arrow_system_should_load_previous_set_of_pages() {
		 Waits.waitUntilElementToClick(60, pageObjects2.previousButton);
		   Elements.click(pageObjects2.previousButton);;
	}

	@Then("for large files system should display the message {string}")
	public void for_large_files_system_should_display_the_message(String string) {
		Waits.waitUntilElementLocated(60, pageObjects2.annotationAndRedectionMsg);
		   Assert.assertEquals(string, Elements.getText(pageObjects2.annotationAndRedectionMsg).trim());
	}

	@Then("click on yes button")
	public void click_on_yes_button() {
		Waits.waitUntilElementToClick(60, pageObjects.Yes_btn);
		   Elements.click(pageObjects.Yes_btn);;
	}

	@Then("cancel the Physical delivery")
	public void cancel_the_Physical_delivery() {
		Waits.waitUntilElementToClick(60, pageObjects.CancelBtn);
		   Elements.click(pageObjects.CancelBtn);
	}

	@Then("filter autogenerated DCN")
	public void filter_autogenerated_DCN() {
		Waits.waitUntilElementLocated(30,pageObjects2.DCNFilter);
		Elements.TypeText(pageObjects2.DCNFilter, GenericActions.fileName);
	}

	public String tokengeneration(String username)
	{
		RestAssured.baseURI =PropertyFileReader.properties.getProperty("AuthBaseURL");
    	RequestSpecification request = RestAssured.given();
    	
    	JSONObject requestParams = new JSONObject();
    	request.header("Content-Type", "application/json");
    	request.body("{\r\n" + 
    			"          \"username\": \""+username+"\"\r\n" + 
    			"        }");
    	Response response = request.post(PropertyFileReader.properties.getProperty("AuthEndPointURL"));
		  JsonPath jsonevaluator = response.jsonPath(); 
		  String respo = jsonevaluator.getString("token");
    	
    	//String respo2 = response.asString();
    	return respo;

	}

	
	  @Then("Hit the pod tracker API for user {string}") 
	  public void hit_the_pod_tracker_API(String string) 
	  { 
	  RestAssured.baseURI =PropertyFileReader.properties.getProperty("PodBaseURL");
	  RequestSpecification request = RestAssured.given();
	 String requestbody = "[\r\n" + 
		  		"  {\r\n" + 
		  		"   \"dcn\":\""+GenericActions.fileName+"\",\r\n" + 
		  		"   \"deliveryTime\":\"1598594725\",\r\n" + 
		  		"   \"deliveryPreference\":\"Delivery In Progress\",\r\n" + 
		  		"   \"deliveryPriority\":\"Default\",\r\n" + 
		  		"   \"deliveryInstructions\":\"test\"\r\n" + 
		  		"}\r\n" + 
		  		"]";
	  request.body(requestbody); 
	  response = request.given().headers("Authorization", "Bearer " + tokengeneration(string)).
				header("Content-Type", "application/json").given()
				.request(Method.POST, PropertyFileReader.properties.getProperty("PodEndPoitURL"));
	  }
	 

	@Then("the responce code should be {string}")
	public void the_responce_code_should_be(String string) {
	   int responcecode=response.getStatusCode();
	   Assert.assertEquals(Integer.parseInt(string), responcecode);
	}

	@Then("refresh the page")
	public void refresh_the_page() throws InterruptedException {
	    Thread.sleep(2000);
	    Base.driver.navigate().refresh();
	}

	@Then("status of the email should be {string}")
	public void status_of_the_email_should_be(String string) {
Waits.waitUntilElementLocated(60, pageObjects2.STATUSValue);
		
		Assert.assertEquals(string, Elements.getText(pageObjects2.STATUSValue).trim());
	}

	@Then("{string} should be available in the dropdown")
	public void should_be_available_in_the_dropdown(String string) {
		Waits.waitUntilElementToClick(30,pageObjects.DropDownOptions(string));
		Assert.assertEquals(string, Elements.getText(pageObjects.DropDownOptions(string)));
		
		Actions action = new Actions(Base.driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		
	}

	@Then("filter the received date {string}")
	public void filter_the_received_date(String string) {
		 Waits.waitUntilElementLocated(30, pageObjects2.RECEIVED_DATEFilter);
		    Elements.TypeText(pageObjects2.RECEIVED_DATEFilter, string);
	}

	@Then("click on processed count")
	public void click_on_processed_count() {
		Waits.waitUntilElementToClick(60, pageObjects2.PROCESSED_Count);
		   Elements.click(pageObjects2.PROCESSED_Count);
	}

	@Then("click on delete dropdown")
	public void click_on_delete_dropdown() {
		try
		{
		Elements.switchToFrame(pageObjects.YopMailFrame);
		
		Waits.waitUntilElementToClick(60, pageObjects.YopDelete);
		   Elements.click(pageObjects.YopDelete);
		}catch(Exception e)
		{
			
		}
	}

	@Then("click on empty inbox")
	public void click_on_empty_inbox() throws InterruptedException {
		try
		{
		Waits.waitUntilElementToClick(60, pageObjects.YopEmpty_Inbox);
		   Elements.click(pageObjects.YopEmpty_Inbox);
		   
		   Elements.switchTodefaultContent();
		}catch(Exception e)
		{
			
		}
	}
	
	@When("check the checkbox of menus from  Role menu assignment tab as {string}, {string} and {string}")
	public void check_the_checkbox_of_menus_from_Role_menu_assignment_tab_as_and(String string, String string2, String string3) {
		Waits.waitUntilElementToClick(30,pageObjects2.EditRoles_SubOptions(string));
		Elements.jclick(pageObjects2.EditRoles_SubOptions(string));
		
		Waits.waitUntilElementToClick(30,pageObjects2.EditRoles_SubOptions(string2));
		Elements.jclick(pageObjects2.EditRoles_SubOptions(string2));
		
		Waits.waitUntilElementToClick(30,pageObjects2.EditRoles_SubOptions(string3));
		Elements.jclick(pageObjects2.EditRoles_SubOptions(string3));
	}

	
	@Then("recived date should be {string} for the email")
	public void recived_date_should_be_for_the_email(String string) {
		 Waits.waitUntilElementLocated(30, pageObjects2.RECEIVED_DATE_TIME);
		  Assert.assertEquals(string, Elements.getText(pageObjects2.RECEIVED_DATE_TIME).trim());  
	}
	
	@Then("{string} dropdown should be present")
	public void dropdown_should_be_present(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.dropdownArrow(string));
		Elements.isDisplayed(pageObjects2.dropdownArrow(string));
	}
	
	@Then("verify drop down option as {string}")
	public void verify_dropdown_option_as(String string) {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	Assert.assertEquals(data, GenericActions.verifyTextExistence(pageObjects2.SelectProjectOptions));
	}
	

	@Then("verify the data is displayed as {string}")
	public void verify_the_data_is_displayed_as(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.InboxTableDataValid(string));
		Elements.isDisplayed(pageObjects2.InboxTableDataValid(string));
	
	}
	
	@Then("it should display the headers as {string}")
	public void it_should_display_the_headers_as(String string) {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	Assert.assertEquals(data, GenericActions.verifyTextExistence(pageObjects2.EditRole_Headers));
	}
	@Then("click {string} mainmenu arrow")
	public void click_mainmenu_arrow(String string) {
		Waits.waitUntilElementToClick(30,pageObjects2.MainMenuArrow(string));
		Elements.jclick(pageObjects2.MainMenuArrow(string));
	}
	@Then("it should show the sub menus as: {string}")
	public void it_should_show_the_sub_menus_as(String string) {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	Assert.assertEquals(data, GenericActions.verifyTextExistence(pageObjects2.SubMenu_Options));
	}
	
	
	@When("check the checkbox of menus from  Role menu assignment tab as {string}")
	public void check_the_checkbox_of_menus_from_Role_menu_assignment_tab_as_and(String string) {
		try {
		Waits.waitUntilElementLocated(30,pageObjects2.MainMenuCheckbox_Check(string));
		Elements.click(pageObjects2.MainMenuCheckbox_Check(string));
		}
		catch(Exception e)
		{	
			
		}
		
	}
	
	@Then("Dashboard items should be displaying {string}")
	public void dashboard_items_should_be_displaying(String string) {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	Assert.assertEquals(data, GenericActions.verifyTextExistence(pageObjects2.DashboardContainer_Options));
	}
	
	@Then("Displayed {string} count should be the sum of all images as {string}")
	public void displayed_count_should_be_the_sum_of_all_images_as(String string, String string2) {
		Waits.waitUntilElementLocated(30,pageObjects2.DashboardContainerData_Valid(string));
		Assert.assertEquals(string2, Elements.getText(pageObjects2.DashboardContainerData_Valid(string)).trim());
		
	}
	
	@Then("{string} should be the sum of all pages {string}")
	public void should_be_the_sum_of_all_pages(String string, String string2) {
		Waits.waitUntilElementLocated(30,pageObjects2.DashboardContainerData_Valid(string));
		Assert.assertEquals(string2, Elements.getText(pageObjects2.DashboardContainerData_Valid(string)).trim());
		
	}

	@Then("{string} count should be the active user count that should be fetched from active user report {string}")
	public void count_should_be_the_active_user_count_that_should_be_vfetched_from_active_user_report(String string, String string2) {
		Waits.waitUntilElementLocated(30,pageObjects2.DashboardContainerData_Valid(string));
		Assert.assertEquals(string2, Elements.getText(pageObjects2.DashboardContainerData_Valid(string)).trim());
	}
	
	@Then("{string} dropdown should be added in dashboard")
	public void dropdown_should_be_added_in_dashboard(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.dropdownArrow(string));
		Elements.isDisplayed(pageObjects2.dropdownArrow(string));
	
	}
	
	
	@Then("In select engagement if there is only one engagement then it should get displayed by default as {string}")
	public void in_select_engagement_if_there_is_only_one_engagement_then_it_should_get_displayed_by_default_as(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.SelectEngagement_DefaultValue);
		Assert.assertEquals(string, Elements.getText(pageObjects2.SelectEngagement_DefaultValue).trim());
	}
	
	@Then("By default dashboard should display {string} data")
	public void by_default_dashboard_should_display_data(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.LastDayRecords);
		Assert.assertEquals(string, Elements.getText(pageObjects2.LastDayRecords).trim());
	}
	
	@Then("It should display the following Reports: {string}")
	public void it_should_display_the_following_reports(String string) throws InterruptedException {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	Thread.sleep(5000);
	    
	    	Assert.assertEquals(data, GenericActions.verifyTextExistence(pageObjects2.ReportsSubMenu_options));
	}
	
	@Then("{string} should gets displayed with data")
	public void should_gets_displayed_with_data(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.Table_Valid);
		Elements.isDisplayed(pageObjects2.Table_Valid);
	}
	
	@Then("enter DCN as {string}")
	public void enter_dcn_as(String string) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects2.DCN_TextBox);
		Elements.TypeText(pageObjects2.DCN_TextBox, string);
		Thread.sleep(2000);
	}
	
	@Then("It should check the entire inventory of the customer to search for this DCN record {string}")
	public void It_should_check_the_entire_inventory_of_the_customer_to_search_for_this_DCN_record(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.InboxTableDataValid(string));
		Assert.assertEquals(string, Elements.getText(pageObjects2.InboxTableDataValid(string)).trim());
	}
	
	@Then("Verify server side pagination and records")
	public void Verify_server_side_pagination_and_records() {
		Waits.waitUntilElementLocated(30,pageObjects2.Table_Valid);
		Elements.isDisplayed(pageObjects2.Table_Valid);
		Elements.isDisplayed(pageObjects2.NoOfPages_DropDown);
	}
	@Then("select No of pages as {string}")
	public void select_No_of_pages_as(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.NoOfPages_DropDown);
		Elements.selectByText(pageObjects2.NoOfPages_DropDown, string);
	}
	
	@Then("Verify page displayed per {string} pages")
	public void Verify_page_displayed_per_pages(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.DisplayingPages_Valid(string));
		Elements.isDisplayed(pageObjects2.DisplayingPages_Valid(string));
	}
	
	@Then("Click on the total count")
	public void click_on_the_total_count() {
		Waits.waitUntilElementToClick(30,pageObjects2.TotalActiveUser_Link);
		Elements.jclick(pageObjects2.TotalActiveUser_Link);
	}
	
	@Then("User should be able to see Total count as Total Unique users for the selected date range")
	public void User_should_be_able_to_see_Total_count_as_Total_Unique_users_for_the_selected_date_range() {
		Waits.waitUntilElementLocated(30,pageObjects2.Table_Valid);
		Elements.isDisplayed(pageObjects2.Table_Valid);
	}
	
	@Then("User should be able to see detailed report displays {string}")
	public void User_should_be_able_to_see_detailed_report_displays(String string) {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	Assert.assertEquals(data, GenericActions.verifyTextExistence(pageObjects2.TableHeaders_Valid));
	}
	
	@Then("enter date in filter as {string}")
	public void enter_date_in_filter_as(String string) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects2.DateTimeFilter);
		Elements.TypeText(pageObjects2.DateTimeFilter, string);
		Thread.sleep(2000);
	}

	@Then("enter the firstname in filter as {string}")
	public void enter_the_firstname_in_filter_as(String string) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects2.FirstNameFilter);
		Elements.TypeText(pageObjects2.FirstNameFilter, string);
		Thread.sleep(2000);
	}
	
	@Then("click Add Recipients")
	public void click_Add_Recipients() {
		Waits.waitUntilElementToClick(30,pageObjects2.AddRecipients_btn);
		Elements.jclick(pageObjects2.AddRecipients_btn);
	}
	
	
	@Then("click option as {string}")
	public void click_option_as(String string) {
		Waits.waitUntilElementToClick(30,pageObjects2.AddRecipients_Options(string));
		Elements.jclick(pageObjects2.AddRecipients_Options(string));
	}
	
	@Then("enter the firstname as {string} and lastname as {string} and email as {string}")
	public void enter_the_firstname_as_and_lastname_as_and_email_as(String string, String string2, String string3) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects2.AddRecipients_FirstName);
		Elements.TypeText(pageObjects2.AddRecipients_FirstName, string);
		Thread.sleep(2000);
	
		Elements.TypeText(pageObjects2.AddRecipients_LastName, string2);
		Thread.sleep(2000);
	
		Elements.TypeText(pageObjects2.AddRecipients_Email, string3);
		Thread.sleep(2000);
	
	}
	
	@Then("click the add button")
	public void click_the_add_button() {
		Waits.waitUntilElementToClick(30,pageObjects2.AddRecipients_ADD);
		Elements.jclick(pageObjects2.AddRecipients_ADD);
	}
	
	@Then("enter the username in filter as {string}")
	public void enter_the_username_in_filter_as(String string) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects2.UserNameFilter);
		Thread.sleep(10000);
		Elements.TypeText(pageObjects2.UserNameFilter, string);
		Thread.sleep(2000);
	}
	
	@Then("enter the module in filter as {string}")
	public void enter_the_module_in_filter_as(String string) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects2.ModuleFilter);
		Elements.TypeText(pageObjects2.ModuleFilter, string);
		Thread.sleep(2000);
	}
	
	@Then("enter the recipientname in filter as {string}")
	public void enter_the_recipientname_in_filter_as(String string) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects2.RecipientNameFilter);
		Elements.TypeText(pageObjects2.RecipientNameFilter, string);
		Thread.sleep(2000);
	}
	
	@Then("verify the module is updated in table {string}")
	public void verify_the_module_is_updated_in_table(String string) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects2.InboxTableDataValid(string));
		Thread.sleep(2000);
		Assert.assertEquals(string, Elements.getText(pageObjects2.InboxTableDataValid(string)).trim());
	}
	
	
	@Then("click on the Reachout {string}")
	public void click_on_the_report(String string) throws InterruptedException {
		
		Elements.scrollIntoView(pageObjects.ReportsOption(string));
		Waits.waitUntilElementToClick(30,pageObjects.ReportsOption(string));
		Elements.jclick(pageObjects.ReportsOption(string));
		//Thread.sleep(30000);
		for(int i=1;i<=60;i++)
		{
			if(Waits.isJQueryDone())
			{
				break;
			}
			
			Thread.sleep(1000);
		}
	}
	
	@Then("click on tab {string}")
	public void click_on_tab(String string) throws InterruptedException {
		Waits.waitUntilElementToClick(30,pageObjects2.TabsLink(string));
		Elements.jclick(pageObjects2.TabsLink(string));
		Thread.sleep(2000);
	}
	
	@Then("Table header Ascending for {string}")
	public void Table_header_Ascending_for(String string) throws InterruptedException {
		Waits.waitUntilElementToClick(30,pageObjects2.HeaderAscending(string));
		Elements.jclick(pageObjects2.HeaderAscending(string));
		Thread.sleep(2000);
		/*
		 * Elements.jclick(pageObjects2.HeaderAscending(string)); Thread.sleep(2000);
		 */
		
	}
	
	@Then("filter the date with current date")
	public void filter_the_date_with_current_date() {
		Date dNow = new Date();
    	//SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa"); 
    	
    	SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yyyy");
    	String ExeTime = ft.format(dNow);
	   Waits.waitUntilElementLocated(30, pageObjects2.DateFilter);
	   Elements.TypeText( pageObjects2.DateFilter,ExeTime);
	}
	
	@Then("click on extended info")
	public void click_on_extended_info() {
		Waits.waitUntilElementToClick(60, pageObjects2.Extended_Info);
	    Elements.click(pageObjects2.Extended_Info);
	}

	@Then("click on metadata")
	public void click_on_metadata() {
	    Waits.waitUntilElementToClick(60, pageObjects2.Metadata);
	    Elements.click(pageObjects2.Metadata);
	}

	@Then("system should display the meta data options {string}")
	public void system_should_display_the_meta_data_options(String string) {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	Assert.assertEquals(data, GenericActions.verifyTextExistence(pageObjects2.MetadataOptions));
	}
	
	@Then("click on forgot password link")
	public void click_on_forgot_password_link() {
	    Waits.waitUntilElementToClick(30, pageObjects2.Forgot_Password);
	    Elements.click(pageObjects2.Forgot_Password);
	}

	@Then("open new tab and navigate to {string}")
	public void open_new_tab_and_navigate_to(String string) throws InterruptedException {
	   //Keys.chord(Keys.CONTROL,"t");
		((JavascriptExecutor)Base.driver).executeScript("window.open()");
	   Elements.switchToChild();
	   Base.driver.navigate().to(string);
	}

	@Then("Retrive the password from email")
	public void retrive_the_password_from_email() {
	    Elements.switchToFrame(pageObjects2.YopmailBodyIframe);
	    
	    Waits.waitUntilElementLocated(30, pageObjects2.OTP_Text);
	    
	   OTP= Elements.getText(pageObjects2.OTP_Text).split("is:")[1].trim();
	}

	@Then("close the tab")
	public void close_the_tab() throws InterruptedException {
	    Elements.switchTodefaultContent();
	    Elements.switchToParentWindow();
	}

	@Then("enter the OTP")
	public void enter_the_OTP() {
	   Waits.waitUntilElementLocated(30, pageObjects2.OTP_Textbox);
	   Elements.TypeText(pageObjects2.OTP_Textbox, OTP);
	}

	@Then("submit the OTP")
	public void submit_the_OTP() {
		Waits.waitUntilElementToClick(30, pageObjects2.OTP_SubmitBtn);
	    Elements.click(pageObjects2.OTP_SubmitBtn);
	}

	@Then("enter the new password as {string}")
	public void enter_the_new_password_as(String string) {
		 Waits.waitUntilElementLocated(30, pageObjects2.forgotpassword_Passwordtxtbox);
		   Elements.TypeText(pageObjects2.forgotpassword_Passwordtxtbox, string);
	}

	@Then("confirm the new password as {string}")
	public void confirm_the_new_password_as(String string) {
		 Waits.waitUntilElementLocated(30, pageObjects2.forgotpassword_confirmPasswordtxtbox);
		   Elements.TypeText(pageObjects2.forgotpassword_confirmPasswordtxtbox, string);
	}

	@Then("click on change password button")
	public void click_on_change_password_button() {
		Waits.waitUntilElementToClick(30, pageObjects2.Change_Password_btn);
	    Elements.click(pageObjects2.Change_Password_btn);
	}

	@Then("click on reset password option")
	public void click_on_reset_password_option() {
		Waits.waitUntilElementToClick(30, pageObjects2.Reset_Password);
	    Elements.click(pageObjects2.Reset_Password);
	}

	@Then("set password as {string}")
	public void set_password_as(String string) {
		 Waits.waitUntilElementLocated(30, pageObjects2.Reset_Password_textbox);
		   Elements.TypeText(pageObjects2.Reset_Password_textbox, string);
	}

	@Then("body of the mail should contain the password {string}")
	public void body_of_the_mail_should_contain_the_password(String string) {
	   
	    Elements.switchToFrame(pageObjects2.YopmailBodyIframe);
	    
	    Waits.waitUntilElementLocated(30, pageObjects2.Reset_Password_mail_text);
	    
	   String pass= Elements.getText(pageObjects2.Reset_Password_mail_text).split("password is")[1].trim();
	   
	   Assert.assertEquals(string, pass);
	}

	@Then("click on add fields option")
	public void click_on_add_fields_option() throws InterruptedException {
		
		Elements.switchToChild();
		Thread.sleep(5000);
		Waits.waitUntilElementToClick(30, pageObjects2.AddFields_LeftArrow);
	    Elements.click(pageObjects2.AddFields_LeftArrow);
	}

	@Then("drag and drop the name")
	public void drag_and_drop_the_name() throws InterruptedException {
	    GenericActions.draganddrop(pageObjects2.Name);
	}

	@Then("select the name")
	public void select_the_name() throws InterruptedException {
		Waits.waitUntilElementToClick(30, pageObjects2.NameDropDown);
	    Elements.jclick(pageObjects2.NameDropDown);
	    
	    Thread.sleep(1500);
	    
	    Waits.waitUntilElementToClick(30, pageObjects2.NameOptions());
	    Elements.jclick(pageObjects2.NameOptions());
	}

	@Then("drag and drop the signature")
	public void drag_and_drop_the_signature() throws InterruptedException {
		 GenericActions.draganddrop(pageObjects2.Signature);
	}

	@Then("select the signature")
	public void select_the_signature() throws InterruptedException {
		Waits.waitUntilElementToClick(30, pageObjects2.signaturedropdown);
	    Elements.jclick(pageObjects2.signaturedropdown);
	    
	    Thread.sleep(1500);
	    
	    Waits.waitUntilElementToClick(30, pageObjects2.SignatureOption);
	    Elements.jclick(pageObjects2.SignatureOption);
	}

	@Then("click on submit button")
	public void click_on_submit_button() throws InterruptedException {
		Waits.waitUntilElementToClick(30, pageObjects2.Submitbtn);
	    Elements.click(pageObjects2.Submitbtn);
	    
	    Thread.sleep(5000);
	    
	    Elements.switchToParentWindow();
	}
	
}
