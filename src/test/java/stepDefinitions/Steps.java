package stepDefinitions;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseinit.Base;

import framework.Elements;
import framework.GenericActions;
import framework.Waits;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.pageObjects;
import pageObjects.pageObjects2;

public class Steps {
	
	SoftAssertions sft = new SoftAssertions();
	
	static String count;
	static String DCN;
	
	@Given("navigate to given URL {string}")
	public void navigate_to_given_URL(String string) {
	    
		Base.driver.navigate().to(string);
		pageObjects obj = new pageObjects(Base.driver);
		pageObjects2 obj2 = new pageObjects2(Base.driver);
		for(int i=0;i<=120;i++)
		{
		List<WebElement> spinner =Base.driver.findElements(By.xpath("//div[@class='loading-wrap']//div"));
		try
		{
		if(spinner.size()==0)
		{
			break;
		}else
		{
			Thread.sleep(1000);
			//System.out.println(spinner.size());
		}
		}catch(Exception e)
		{
			
		}
		}
		
		for(int i=0;i<=60;i++)
		{
		List<WebElement> spinner =Base.driver.findElements(By.xpath("//div[@class='loading-wrap']//div[@class='sk-fading-circle loading-icon']"));
		
		try
		{
		if(spinner.size()==0)
		{
			break;
		}else
		{
			Thread.sleep(1000);
			//System.out.println(spinner.size());
		}
		}catch(Exception e)
		{
			
		}
		}
	    
	}
	

	@Then("enter username as {string}")
	public void enter_username_as(String string) throws InterruptedException {
	    
		
		Waits.waitUntilElementLocated(30,pageObjects.UserName);
		Elements.TypeText(pageObjects.UserName, string);
		Thread.sleep(1500);
	    
	}

	@Then("click on next button")
	public void click_on_next_button() throws InterruptedException {
		//Thread.sleep(300);
		Waits.waitUntilElementToClick(30,pageObjects.Next_btn);
		Elements.click(pageObjects.Next_btn);
	}

	@Then("enter Password as {string}")
	public void enter_Password_as(String string) throws InterruptedException {
	    
		Waits.waitUntilElementLocated(30,pageObjects.Password);
		Elements.TypeText(pageObjects.Password, string);
		
		Thread.sleep(3000);
	}

	@Then("click on signin button")
	public void click_on_signin_button() throws InterruptedException {
		Thread.sleep(1500);
		Waits.waitUntilElementToClick(30,pageObjects.SignInButton);
		Elements.click(pageObjects.SignInButton);
		
	}

	@Then("titile of the page should be {string}")
	public void titile_of_the_page_should_be(String string) {
		Assert.assertEquals(Elements.getTitle(), string);
	    
	}

	@When("{string} graph should be displayed")
	public void graph_should_be_displayed(String string) {
	    Waits.waitUntilElementLocated(30, pageObjects.graphName(string));
	    Assert.assertEquals(string, Elements.getText(pageObjects.graphName(string)));
	}
	
	@Then("Click on profile picture")
	public void click_on_profile_picture() throws InterruptedException {
		//Thread.sleep(15000);
		Waits.waitUntilElementToClick(30,pageObjects.Profile_Pic);
		Elements.click(pageObjects.Profile_Pic);
	    
	}

	@Then("logout")
	public void logout() {
		Waits.waitUntilElementToClick(30,pageObjects.Logout);
		Elements.click(pageObjects.Logout);
	    
	}

	@Then("System should throw a toggle message as {string}")
	public void system_should_throw_a_toggle_message_as(String string) {
		Waits.waitUntilElementLocated(30, pageObjects.AlertMsg);
		//Elements.VerifyTextEquals(pageObjects.AlertMsg, string);
		
		Assert.assertEquals(string, Elements.getText(pageObjects.AlertMsg));
	    
	}

	@Then("Click on show password icon")
	public void click_on_show_password_icon() {
		Waits.waitUntilElementToClick(30,pageObjects.ShowPasswordIcon);
		Elements.click(pageObjects.ShowPasswordIcon);
	    
	}

	@Then("password should be visible")
	public void password_should_be_visible() {
	    
		Waits.waitUntilElementLocated(30, pageObjects.ShowPasswordIcon);
		Elements.VerifyTextEquals(pageObjects.ShowPasswordIcon, "visibility");
	}

	@Then("click on left pane menu {string}")
	public void click_on_left_pane_menu(String string) {
		Waits.waitUntilElementToClick(30,pageObjects.LeftPaneMenu(string));
		Elements.click(pageObjects.LeftPaneMenu(string));
	    
	}
	
	@Then("click on Left pane menu {string}")
	public void click_on_Left_pane_menu(String string) {
		Waits.waitUntilElementToClick(30,pageObjects.LeftPaneMenua(string));
		Elements.click(pageObjects.LeftPaneMenua(string));
	    
	}

	@When("click on {string} dropdown option")
	public void click_on_dropdown_option(String string) {
		Waits.waitUntilElementToClick(30,pageObjects.DashBoardGraphDropDownArrow(string));
		Elements.click(pageObjects.DashBoardGraphDropDownArrow(string));
	    
	}

	@Then("system should display graph filter options as {string}")
	public void system_should_display_graph_filter_options_as(String string) {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	Assert.assertEquals(data, GenericActions.verifyTextExistence(pageObjects.DropDownList));
	    	
	    Actions action = new Actions(Base.driver);
	    action.sendKeys(Keys.TAB).build().perform();
	}

	@Then("Click on SwitchTo option")
	public void click_on_SwitchTo_option() {
	    
		Waits.waitUntilElementToClick(30,pageObjects.SwitchToRole);
		Elements.click(pageObjects.SwitchToRole);
	}

	@Then("Switch to {string}")
	public void switch_to(String string) throws InterruptedException {
		Waits.waitUntilElementToClick(30,pageObjects.SwitchToRole_Radiobtn(string));
		Elements.click(pageObjects.SwitchToRole_Radiobtn(string));
	    
	}

	@Then("click OK button")
	public void click_OK_button() throws InterruptedException {
	    
		Waits.waitUntilElementToClick(30,pageObjects.OK_btn);
		Elements.click(pageObjects.OK_btn);
		
		for(int i=0;i<=60;i++)
		{
		List<WebElement> spinner =Base.driver.findElements(By.xpath("//td[@data-title='DCN']//span/span"));
		try
		{
		if(spinner.size()!=0)
		{
			break;
		}else
		{
			Thread.sleep(1000);
			//System.out.println(spinner.size());
		}
		}catch(Exception e)
		{
			
		}
		}
		
		for(int i=1;i<=60;i++)
		{
			if(Waits.isJQueryDone())
			{
				break;
			}
			
			Thread.sleep(1000);
		}
	    
	}

	@Then("select an email")
	public void select_an_email() throws InterruptedException {
		Thread.sleep(1500);
		Waits.waitUntilElementToClick(30,pageObjects.Mail_Selection);
		
		DCN = Elements.getText(pageObjects.DCNValue);
		
		Elements.Mouseclick(pageObjects.Mail_Selection);
	}

	@Then("select action as {string}")
	public void select_action_as(String string) throws InterruptedException {
		
		Waits.waitUntilElementToClick(30,pageObjects.Action_drpdwn);
		Elements.Mouseclick(pageObjects.Action_drpdwn);
		Thread.sleep(2000);
		Waits.waitUntilElementToClick(30,pageObjects.Action_Selection(string));
		Elements.Mouseclick(pageObjects.Action_Selection(string));
	    
	}

	@Then("enter receipient as {string} and select it")
	public void enter_receipient_as_and_select_it(String string) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects.Lookup_RecipentTextbox);
		Elements.TypeText(pageObjects.Lookup_RecipentTextbox, string);
		
		Thread.sleep(5000);
		
		Waits.waitUntilElementToClick(30,pageObjects.ReceipentSelection(string));
		Elements.click(pageObjects.ReceipentSelection(string));
	    
	}
	
	@Then("enter recepient as {string} and select it")
	public void enter_recepient_as_and_select_it(String string) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects.Lookup_SendTo_RecipentTextbox);
		Elements.TypeText(pageObjects.Lookup_SendTo_RecipentTextbox, string);
		
		Thread.sleep(5000);
		
		Waits.waitUntilElementToClick(30,pageObjects.ReceipentSelection(string));
		Elements.click(pageObjects.ReceipentSelection(string));
	    
	}

	@When("click on send button")
	public void click_on_send_button() {
	    
		Waits.waitUntilElementToClick(30,pageObjects.Send_btn);
		Elements.click(pageObjects.Send_btn);
	}

	@Then("navigate to yopmail URL {string}")
	public void navigate_to_yopmail_URL(String string) {
		Base.driver.navigate().to(string);
	    
	}

	@Then("enter yopmail id as {string}")
	public void enter_yopmail_id_as(String string) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects.YOPMail_Emailtxt_box);
		Elements.TypeText(pageObjects.YOPMail_Emailtxt_box, string);
	    
	}

	@When("click on check inbox")
	public void click_on_check_inbox() {
		Waits.waitUntilElementToClick(30,pageObjects.YOPMail_CheckInbox);
		Elements.click(pageObjects.YOPMail_CheckInbox);
	    
	}

	@Then("system should display {string} email")
	public void system_should_display_email(String string) throws InterruptedException {
		Elements.switchToFrame(pageObjects.YopMailFrame);
		Elements.VerifyTextEquals(pageObjects.MailVerification, string);
		Elements.switchTodefaultContent();
	    
	}
	
	@Then("system should not display {string} email")
	public void system_should_not_display_email(String string) throws InterruptedException {
		Elements.switchToFrame(pageObjects.YopMailFrame);
		Elements.VerifyTextnotEquals(pageObjects.MailVerification, string);
		Elements.switchTodefaultContent();
	    
	}

	@When("click on send butn")
	public void click_on_send_butn() {
	    
		Waits.waitUntilElementToClick(30,pageObjects.Send_btn);
		Elements.click(pageObjects.Send_btn);
	}

	@Then("click on send mail button")
	public void click_on_send_mail_button() {
		Waits.waitUntilElementToClick(30,pageObjects.SendMail);
		Elements.click(pageObjects.SendMail);
	    
	}

	@Then("select label {string}")
	public void select_label(String string) {
		Waits.waitUntilElementToClick(30,pageObjects.LabelSelection(string));
		Elements.click(pageObjects.LabelSelection(string));
	    
	}

	@When("click on Assign Label")
	public void click_on_Assign_Label() {
	    
		Waits.waitUntilElementToClick(30,pageObjects.AssignLabel);
		Elements.click(pageObjects.AssignLabel);
		
		
	}
	
	@Then("click on close button")
	public void click_on_close_button() {
		Waits.waitUntilElementToClick(30,pageObjects.Close_btn);
		Elements.click(pageObjects.Close_btn);
	}

	@Then("click on toggle menu")
	public void click_on_toggle_menu() throws InterruptedException {
		Thread.sleep(1000);
		Waits.waitUntilElementToClick(30,pageObjects.Menu);
		Elements.click(pageObjects.Menu);
	    
	}

	@Then("click on the report {string}")
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

	@Then("select from date as {string}")
	public void select_from_date_as(String string) throws InterruptedException {
		//Thread.sleep(30000);
	    Waits.waitUntilElementToClick(50000,pageObjects.FromDate);
		GenericActions.CalenderSelection(pageObjects.FromDate,string);
		//Thread.sleep(30000);
	}
	
	@Then("select to date as {string}")
	public void select_to_date_as(String string) throws InterruptedException {
		Waits.waitUntilElementToClick(50000,pageObjects.ToDate);
		GenericActions.CalenderSelectionto(pageObjects.ToDate,string);
	}
	
	@Then("redirect the page to {string}")
	public void redirect_the_page_to(String URL) throws InterruptedException {
		Thread.sleep(2000);
		Base.driver.navigate().to(URL);
	
	}

	@Then("DMR core & DB, Ingester ,Exela auth & DB and eFirst-Archive status should be in {string} status")
	public void dmr_core_status_should_be_and_DMR_db_status_should_be(String status) throws InterruptedException {
		Thread.sleep(2000);
		String test = Elements.getText(pageObjects.DMR_CORE_Status);
		sft.assertThat(test).isEqualTo(status);
		sft.assertThat(Elements.getText(pageObjects.DMR_CORE_DBStatus)).isEqualTo(status);
		sft.assertThat(Elements.getText(pageObjects.Ingester_Status)).isEqualTo(status);
		sft.assertThat(Elements.getText(pageObjects.eFirst_Archive_DEMO_Status)).isEqualTo(status);
		sft.assertThat(Elements.getText(pageObjects.Exela_Auth_Status)).isEqualTo(status);
		sft.assertThat(Elements.getText(pageObjects.Exela_Auth_DBStatus)).isEqualTo(status);
		sft.assertAll();	
	}

	@Then("click on download icon")
	public void click_on_download_icon() throws InterruptedException {
		//Thread.sleep(15000);
		GenericActions.deleteFiles(new File(System.getProperty("user.dir")+"/"+"DownloadedFiles"));
		Waits.waitUntilElementToClick(15000,pageObjects.DownloadIcon);
		Elements.jclick(pageObjects.DownloadIcon);
		Thread.sleep(15000);
	}
	
	@Then("total mail should be enabled")
	public void total_mail_should_be_enabled() {
	  Assert.assertEquals(true, Elements.isEnabled(pageObjects.TOTAL_MAIL));  
	}

	@Then("opened mail should be enabled")
	public void opened_mail_should_be_enabled() {
		Assert.assertEquals(true,Elements.isEnabled(pageObjects.OPENED_MAIL));
	}

	@Then("un opened mail should be enabled")
	public void un_opened_mail_should_be_enabled() {
		Assert.assertEquals(true,Elements.isEnabled(pageObjects.UNOPENED_MAIL));
	}
	
	@Then("Move the document from Inbox to AutoSharedBox user box")
	public void move_the_document_from_Inbox_to_Deactivated_user_box() throws InterruptedException {
		Thread.sleep(3000);
		Waits.waitUntilElementToClick(30,pageObjects.Mail_Selection);
		Elements.Mouseclick(pageObjects.Mail_Selection);
		
		Waits.waitUntilElementToClick(30,pageObjects.Action_drpdwn);
		Elements.Mouseclick(pageObjects.Action_drpdwn);
		//Thread.sleep(3000);
		Waits.waitUntilElementToClick(30,pageObjects.Action_Selection("Move To Folder"));
		Elements.Mouseclick(pageObjects.Action_Selection("Move To Folder"));
		//Thread.sleep(4000);
		
		//Elements.scrollIntoView(pageObjects.FolderOptions("AutoSharedBox"));
		
		Thread.sleep(3000);
		
		Waits.waitUntilElementToClick(30,pageObjects.FolderOptions("AutoSharedBox"));
		Elements.Mouseclick(pageObjects.FolderOptions("AutoSharedBox"));
		
		Waits.waitUntilElementToClick(30,pageObjects.OK_btn);
		Elements.Mouseclick(pageObjects.OK_btn);
		
	    //Elements.dragAndDrop(pageObjects.SourceEmail, pageObjects.DeactvatedUser);
	}

	@Then("click on AutoSharedBox user box")
	public void click_on_Deactivated_user_box() throws InterruptedException {
		Thread.sleep(3000);
		Waits.waitUntilElementToClick(30,pageObjects.DeactvatedUser);
		Elements.click(pageObjects.DeactvatedUser);
	}

	@Then("Move the document from AutoSharedBox box to Inbox box")
	public void move_the_document_from_Deactivated_user_box_to_Inbox_box() throws InterruptedException {
		Waits.waitUntilElementToClick(30,pageObjects.Mail_Selection);
		Elements.Mouseclick(pageObjects.Mail_Selection);
		
		Waits.waitUntilElementToClick(30,pageObjects.Action_drpdwn);
		Elements.Mouseclick(pageObjects.Action_drpdwn);
		//Thread.sleep(3000);
		Waits.waitUntilElementToClick(30,pageObjects.Action_Selection("Move To Folder"));
		Elements.Mouseclick(pageObjects.Action_Selection("Move To Folder"));
		
		/*
		 * Waits.waitUntilElementToClick(30,pageObjects.FolderOptions("Deactivated User"
		 * )); Elements.Mouseclick(pageObjects.Mail_Selection);
		 */
		Thread.sleep(5000);
		Waits.waitUntilElementToClick(30,pageObjects.OK_btn);
		Elements.click(pageObjects.OK_btn);
		
		//Elements.dragAndDrop(pageObjects.SourceEmail,pageObjects.Inbox);
	}
	
	@When("Enter on DocType Name as {string}")
	public void enter_on_DocType_Name_as(String string) {
	   Waits.waitUntilElementLocated(60, pageObjects.DocTypeName);
	   Elements.TypeText(pageObjects.DocTypeName, string);
	}

	@When("Enter DocType Description as {string}")
	public void enter_DocType_Description_as(String string) {
		if(!string.equalsIgnoreCase(""))
		{
		Waits.waitUntilElementLocated(60, pageObjects.DocDescription);
		   Elements.TypeText(pageObjects.DocDescription, string);
		}else
		{
			Waits.waitUntilElementLocated(60, pageObjects.DocDescription);
			   //Elements.TypeText(pageObjects.DocDescription, " ");
			   SetThreeSteps.action.sendKeys(pageObjects.DocDescription, Keys.SPACE).build().perform();
		}
	}

	@When("Enter Retention period")
	public void enter_Retention_period(io.cucumber.datatable.DataTable dataTable) {
		for (Map<Object, Object> data : dataTable.asMaps(String.class, String.class)) {
			
			Waits.waitUntilElementToClick(30,pageObjects.RetentionPeriod);
			Elements.TypeText(pageObjects.RetentionPeriod,String.valueOf(data.get("Rperiod")));
			
		}
	}

	@When("Enter Notify me Before as {string}")
	public void enter_Notify_me_Before_as(String string) {
		Waits.waitUntilElementLocated(60, pageObjects.NotifymeBeforeInDays);
		   Elements.TypeText(pageObjects.NotifymeBeforeInDays, string);
	}

	@When("Enter Retention period as {string}")
	public void enter_Retention_period_as(String string) {
		Waits.waitUntilElementLocated(60, pageObjects.RetentionPeriod);
		   Elements.TypeText(pageObjects.RetentionPeriod, string);
	}

	@When("Enter Spacebar")
	public void enter_Spacebar() {
		Actions action = new Actions(Base.driver);
		
		Waits.waitUntilElementLocated(60, pageObjects.NotifymeBeforeInDays);
		   Elements.TypeText(pageObjects.NotifymeBeforeInDays, String.valueOf(action.sendKeys(Keys.SPACE)));
	}

	@When("Select Doctype Setup")
	public void select_Doctype_Setup() {
	    
	}

	@When("Enter on Add DocType as {string}")
	public void enter_on_Add_DocType_as(String string) {
		 Waits.waitUntilElementLocated(60, pageObjects.DocTypeName);
		   Elements.TypeText(pageObjects.DocTypeName, string);
	}

	@When("click on Cancel")
	public void click_on_Cancel() {
	 Waits.waitUntilElementToClick(60, pageObjects.CancelBtn);   
	 Elements.click(pageObjects.CancelBtn);
	}

	@Then("User should see Add doctype button enabled.")
	public void user_should_see_Add_doctype_button_enabled() {
		Waits.waitUntilElementLocated(60, pageObjects.AddDocType);
		Elements.isEnabled(pageObjects.AddDocType);
	}

	@When("Enter value {string}")
	public void enter_value(String string) {
		//Actions action = new Actions(Base.driver);
		if(!string.equalsIgnoreCase(""))
		{
		 Waits.waitUntilElementLocated(60, pageObjects.DocTypeName);
		   Elements.TypeText(pageObjects.DocTypeName, string);
		}else
		{
			Waits.waitUntilElementLocated(60, pageObjects.DocTypeName);
			   //Elements.TypeText(pageObjects.DocTypeName, " ");
			   SetThreeSteps.action.sendKeys(pageObjects.DocTypeName, Keys.SPACE).build().perform();
		}
	}

	@When("and click on save")
	public void and_click_on_save() {
		Waits.waitUntilElementToClick(60, pageObjects.Save);   
		 Elements.click(pageObjects.Save);
	}

	@When("Enter Retention period {string}")
	public void enter_Retention_period(String string) {
		if(!string.equalsIgnoreCase(""))
		{
		Waits.waitUntilElementLocated(60, pageObjects.RetentionPeriod);
		   Elements.TypeText(pageObjects.RetentionPeriod, string);
		}else
		{
			Waits.waitUntilElementLocated(60, pageObjects.RetentionPeriod);
			   Elements.TypeText(pageObjects.RetentionPeriod, string);
			   SetThreeSteps.action.sendKeys(pageObjects.RetentionPeriod, Keys.SPACE).build().perform();
		}
	}

	@When("Enter SLA in days as {string}")
	public void enter_SLA_in_days_as(String string) {
		Waits.waitUntilElementLocated(60, pageObjects.SLAInDays);
		   Elements.TypeText(pageObjects.SLAInDays, string);
	}

	@Then("click on Deleted Items folder")
	public void click_on_Deleted_Items_folder() {
		 Waits.waitUntilElementToClick(30, pageObjects.Deleted_Items);
		 Elements.click(pageObjects.Deleted_Items);
	}

	@Then("check whether same email is present in Deleted Items folder")
	public void check_whether_same_email_is_present_in_Deleted_Items_folder() {
		 Waits.waitUntilElementLocated(30, pageObjects2.DCNFilter);
		    Elements.TypeText(pageObjects2.DCNFilter, DCN);
		    
		    Assert.assertEquals(DCN, Elements.getText(pageObjects.DCNValue));
	}

	@Then("Enter Email id as  {string} in Do_you_want_to_suggest_any_other_user_name?")
	public void enter_Email_id_as_in_Do_you_want_to_suggest_any_other_user_name(String string) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects.Lookup_RecipentTextbox);
		Elements.TypeText(pageObjects.Lookup_RecipentTextbox, string);
		
		Thread.sleep(5000);
		
		Waits.waitUntilElementToClick(30,pageObjects.ReceipentSelection(string));
		Elements.click(pageObjects.ReceipentSelection(string));
	}

	@Then("click on Create button")
	public void click_on_Create_button() {
		Waits.waitUntilElementToClick(60, pageObjects.Create_btn);   
		 Elements.click(pageObjects.Create_btn);
	}

	@Then("click on Completed folder")
	public void click_on_Completed_folder() {
		Waits.waitUntilElementToClick(60, pageObjects2.CompletedFolder);   
		 Elements.click(pageObjects2.CompletedFolder);
	}

	@Then("check whether same email is present in Completed folder")
	public void check_whether_same_email_is_present_in_Completed_folder() {
	    Waits.waitUntilElementLocated(30, pageObjects2.DCNFilter);
	    Elements.TypeText(pageObjects2.DCNFilter, DCN);
	    
	    Assert.assertEquals(DCN, Elements.getText(pageObjects.DCNValue));
	}

	@Then("click on Add Scheduler button")
	public void click_on_Add_Scheduler_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("select Scheduler Type as {string}")
	public void select_Scheduler_Type_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("select Scheduler Time as {string}")
	public void select_Scheduler_Time_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("select Report Name as {string}")
	public void select_Report_Name_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("enter Select the person\\(s) to whom you want to send report as {string} and select it")
	public void enter_Select_the_person_s_to_whom_you_want_to_send_report_as_and_select_it(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("click on count that is showing")
	public void click_on_count_that_is_showing() {
		Waits.waitUntilElementLocated(30, pageObjects.Count);
		count = Elements.getText(pageObjects.Count).trim();
		Elements.click(pageObjects.Count);
	}

	@Then("the junk mail count and total detailed count should be equal")
	public void the_junk_mail_count_and_total_detailed_count_should_be_equal() {
		Waits.waitUntilElementLocated(30, pageObjects2.tableinfo_totalcount);
		String tablecount[] = Elements.getText(pageObjects2.tableinfo_totalcount).split("of");
		Assert.assertEquals(count, tablecount[1].trim());
	}
	
	@Then("filter the action {string}")
	public void filter_the_action(String string) {
		Waits.waitUntilElementLocated(30, pageObjects2.ACTION_Filter);
		Elements.TypeText(pageObjects2.ACTION_Filter, string);
	}
	
	@Then("filter status email as {string}")
	public void filter_status_email_as(String string) {
		Waits.waitUntilElementLocated(30, pageObjects.StatusFilter);
		Elements.TypeText(pageObjects.StatusFilter, string);
	}
	
	}
