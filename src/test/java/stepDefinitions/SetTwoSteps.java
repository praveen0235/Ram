package stepDefinitions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import baseinit.Base;
import framework.Elements;
import framework.GenericActions;
import framework.Waits;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.pageObjects;
import pageObjects.pageObjects2;

public class SetTwoSteps {
	
	@When("click on My Profile")
	public void click_on_My_Profile() {
		
		Waits.waitUntilElementToClick(30,pageObjects2.My_Profile);
		Elements.click(pageObjects2.My_Profile);
	}
	
	@Then("enter action name as {string}")
	public void enter_action_name_as(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.ACTION_NAMEFilter);
		Elements.TypeText(pageObjects2.ACTION_NAMEFilter, string);
	}
	
	@When("select from date as today and to date is additional of two days of today")
	public void select_from_date_as_today_and_to_date_is_additional_of_two_days_of_today() throws InterruptedException {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
    	String StartDate = ft.format(dNow);
    	
    	@SuppressWarnings("static-access")
		Date dt = new DateUtils().addDays(dNow, 2);
    	String EndDate = ft.format(dt);
    	
    	Thread.sleep(7000);
		GenericActions.CalenderSelection(pageObjects.FromDate,StartDate);
		Thread.sleep(3000);
		GenericActions.CalenderSelectionto(pageObjects.ToDate,EndDate);
	}

	@When("click on Settings")
	public void click_on_Settings() {
		Waits.waitUntilElementToClick(30,pageObjects2.Settings);
		Elements.click(pageObjects2.Settings);
	}

	@When("Off the toggle of {string}")
	public void off_the_toggle_of(String string) {
		Waits.waitUntilElementToClick(30,pageObjects2.Settings_Options(string));
		Elements.click(pageObjects2.Settings_Options(string));
	}
	
	@When("Off the toggle of {string} Not My Mail Notification option")
	public void off_the_toggle_of_Not_My_Mail_Notification_option(String string) throws InterruptedException {
		try{
			Waits.waitUntilElementToClick(30,pageObjects2.Settings_Options(string));
			Elements.jclick(pageObjects2.Settings_Options(string));
			
			
			}catch(Exception e)
			{
				Waits.waitUntilElementToClick(30,pageObjects2.Settings_Options("Not My Mail Notification Deactive"));
				Elements.jclick(pageObjects2.Settings_Options("Not My Mail Notification Deactive"));
				
				Thread.sleep(2000);
				
				Waits.waitUntilElementToClick(30,pageObjects2.Settings_Options(string));
				Elements.jclick(pageObjects2.Settings_Options(string));
			}

	}
	
	@When("Off the toggle of {string} Re-route Notification option")
	public void off_the_toggle_of_Re_route_Notification_option(String string) throws InterruptedException {
		try{
			Waits.waitUntilElementToClick(30,pageObjects2.Settings_Options(string));
			Elements.jclick(pageObjects2.Settings_Options(string));
			
			
			}catch(Exception e)
			{
				Waits.waitUntilElementToClick(30,pageObjects2.Settings_Options("Re-route Notification Deactive"));
				Elements.jclick(pageObjects2.Settings_Options("Re-route Notification Deactive"));
				
				Thread.sleep(2000);
				
				Waits.waitUntilElementToClick(30,pageObjects2.Settings_Options(string));
				Elements.jclick(pageObjects2.Settings_Options(string));
			}
	}
	
	@When("Off the toggle of {string} New Mail Notification option")
	public void off_the_toggle_of_New_Mail_Notification_option(String string) throws InterruptedException {
		try{
			Waits.waitUntilElementToClick(30,pageObjects2.Settings_Options(string));
			Elements.jclick(pageObjects2.Settings_Options(string));
			
			
			}catch(Exception e)
			{
				Waits.waitUntilElementToClick(30,pageObjects2.Settings_Options("New Mail Notification Deactive"));
				Elements.jclick(pageObjects2.Settings_Options("New Mail Notification Deactive"));
				
				Thread.sleep(2000);
				
				Waits.waitUntilElementToClick(30,pageObjects2.Settings_Options(string));
				Elements.jclick(pageObjects2.Settings_Options(string));
			}
	}

	@Then("User should not receive the Notification")
	public void user_should_not_receive_the_Notification() {
	    
	}

	@When("on the toggle of {string}")
	public void on_the_toggle_of(String string) {
		Waits.waitUntilElementToClick(30,pageObjects2.Settings_Options(string));
		Elements.click(pageObjects2.Settings_Options(string));
	}
	
	@When("on the toggle of {string} option")
	public void on_the_toggle_of_option(String string) throws InterruptedException {
		try{
		Waits.waitUntilElementToClick(30,pageObjects2.Settings_Option(string));
		Elements.jclick(pageObjects2.Settings_Option(string));
		
		
		}catch(Exception e)
		{
			Waits.waitUntilElementToClick(30,pageObjects2.Settings_Option("Re-route Notification Active"));
			Elements.jclick(pageObjects2.Settings_Option("Re-route Notification Active"));
			
			Thread.sleep(2000);
			
			Waits.waitUntilElementToClick(30,pageObjects2.Settings_Option(string));
			Elements.jclick(pageObjects2.Settings_Option(string));
		}
		
	}

	@When("Select start date as {string} aand end date as {string}")
	public void select_start_date_as_aand_end_date_as(String string, String string2) throws InterruptedException {
		//Thread.sleep(5000);
		//Elements.jTypeText(pageObjects2.Start_DateIn,string);
		Thread.sleep(5000);
		//Elements.jTypeText(pageObjects2.End_Datein,string2);
		GenericActions.startDate(pageObjects2.Start_Date,string);
		//Thread.sleep(15000);
		GenericActions.startDate(pageObjects2.End_Date,string2);
	}

	@When("click on save button")
	public void click_on_save_button() {
		try
		{
		Waits.waitUntilElementToClick(10,pageObjects2.Save);
		Elements.Mouseclick(pageObjects2.Save);
		}catch(Exception e)
		{
			Waits.waitUntilElementToClick(10,pageObjects2.Save_RuleCondition);
			Elements.click(pageObjects2.Save_RuleCondition);
		}
	}
	
	@When("click on SAVE button")
	public void click_on_SAVE_button() {
		Waits.waitUntilElementToClick(10,pageObjects2.SAVE);
		Elements.jclick(pageObjects2.SAVE);
		
	}
	
	@When("select delivery prference as {string}")
	public void select_delivery_prference_as(String string) {
		Waits.waitUntilElementToClick(10,pageObjects2.Select_your_delivery_preference(string));
		Elements.jclick(pageObjects2.Select_your_delivery_preference(string));
	}
	
	@Then("User should get success msg as {string}")
	public void user_should_gt_success_msg_as(String string) {
		Waits.waitUntilElementLocated(30, pageObjects.AlertMsg);
		//Elements.VerifyTextEquals(pageObjects.AlertMsg, string);
		
		Assert.assertEquals(string, pageObjects.AlertMsg);
	}
	
	@Then("Sender should get out of office msg.")
	public void sender_should_get_out_of_office_msg() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("Click on Myprofile")
	public void click_on_Myprofile() {
		Waits.waitUntilElementToClick(30,pageObjects2.My_Profile);
		Elements.click(pageObjects2.My_Profile);
	}

	@When("on the toggle setting of {string}")
	public void on_the_toggle_setting_of(String string) {
		Waits.waitUntilElementToClick(30,pageObjects2.Settings_Setting_Options(string));
		Elements.click(pageObjects2.Settings_Setting_Options(string));
	}

	@When("select from date as {string} and to date as {string}")
	public void select_from_date_as_and_to_date_as(String string, String string2) throws InterruptedException {
		Thread.sleep(8000);
		Waits.waitUntilElementToClick(3000, pageObjects.FromDate);
		GenericActions.CalenderSelection(pageObjects.FromDate,string);
		Thread.sleep(1500);
		GenericActions.CalenderSelectionto(pageObjects.ToDate,string2);
	}
	
	@When("select from date as {string} and To date as {string}")
	public void select_from_date_as_and_To_date_as(String string, String string2) throws InterruptedException {
		Thread.sleep(8000);
		Waits.waitUntilElementToClick(3000, pageObjects.FromDate);
		GenericActions.CalenderSelection(pageObjects.FromDate,string);
		Thread.sleep(1500);
		GenericActions.CalenderSelectionto2(pageObjects.ToDate,string2);
	}

	@When("enter email id as {string} to whom you want to delegate the inbox")
	public void enter_email_id_as_to_whom_you_want_to_delegate_the_inbox(String string) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects.Lookup_SendTo_RecipentTextbox);
		Elements.TypeText(pageObjects.Lookup_SendTo_RecipentTextbox, string);
		
		Thread.sleep(5000);
		
		Waits.waitUntilElementToClick(30,pageObjects.ReceipentSelection(string));
		Elements.click(pageObjects.ReceipentSelection(string));
	}

	@When("click on save button and get success msg as {string}")
	public void click_on_save_button_and_get_success_msg_as(String string) {
		Waits.waitUntilElementToClick(30,pageObjects2.Save);
		Elements.click(pageObjects2.Save);
		
		Waits.waitUntilElementLocated(30, pageObjects.AlertMsg);
		Elements.VerifyTextEquals(pageObjects.AlertMsg, string);
	}

	@Then("the other person VarshaDighe310891@yopmail.com  whom we delegate the inbox should be copied in emails .")
	public void the_other_person_VarshaDighe_yopmail_com_whom_we_delegate_the_inbox_should_be_copied_in_emails(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("Checked the delegate other user inbox checkbox")
	public void checked_the_delegate_other_user_inbox_checkbox() {
		Waits.waitUntilElementToClick(30,pageObjects2.Delegate_Other_User);
		Elements.click(pageObjects2.Delegate_Other_User);
	}
	
	@Then("click on yopmail delete dropdown")
	public void click_on_yopmail_delete_dropdown() {
		try
		{
		Elements.switchToFrame(pageObjects.YopMailFrame);
		Waits.waitUntilElementToClick(30,pageObjects2.YopMail_DeletedrpArrow);
		Elements.click(pageObjects2.YopMail_DeletedrpArrow);
		}catch(Exception e)
		{
			
		}
	}
	
	@Then("Check the {string} value is {string}")
	public void check_the_value_is(String string, String string2) throws InterruptedException {
		Elements.switchToFrame(pageObjects.YopMailFrame2);
	    String value = Elements.getText(pageObjects2.YopmailSettingValue(string));
	    Assert.assertEquals(string2, value);
	    Elements.switchTodefaultContent();
	}
	
	@When("select From date as today and to date is additional of two days of today")
	public void select_From_date_as_today_and_to_date_is_additional_of_two_days_of_today() throws InterruptedException {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
    	String StartDate = ft.format(dNow);
    	
    	@SuppressWarnings("static-access")
		Date dt = new DateUtils().addDays(dNow, 2);
    	String EndDate = ft.format(dt);
    	
    	Thread.sleep(10000);
		GenericActions.startDate(pageObjects2.FromCalender,StartDate);
		Thread.sleep(1500);
		GenericActions.startDate(pageObjects2.ToCalender,EndDate);
	}


	@Then("click on Empty Inbox")
	public void click_on_Empty_Inbox() throws InterruptedException {
		try
		{
		Waits.waitUntilElementToClick(30,pageObjects2.Empty_Inbox);
		Elements.click(pageObjects2.Empty_Inbox);
		Elements.switchTodefaultContent();
		}catch(Exception e)
		{
			
		}
	}

	@Then("navigate to {string}")
	public void navigate_to(String string) {
		Base.driver.navigate().to(string);
	}

	@When("Enter the User one's mail id as {string} whose inbox you want to delegate")
	public void enter_the_User_one_s_mail_id_as_whose_inbox_you_want_to_delegate(String string) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects2.DelegateInbox_Recipienttxtbox1);
		Elements.TypeText(pageObjects2.DelegateInbox_Recipienttxtbox1, string);
		
		Thread.sleep(2000);
		
		Waits.waitUntilElementToClick(30,pageObjects.ReceipentSelection(string));
		Elements.click(pageObjects.ReceipentSelection(string));
	}

	@When("enter email id as {string} of User two you want to delegate the inbox")
	public void enter_email_id_as_of_User_two_you_want_to_delegate_the_inbox(String string) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects2.DelegateInbox_Recipienttxtbox);
		Elements.TypeText(pageObjects2.DelegateInbox_Recipienttxtbox, string);
		
		Thread.sleep(5000);
		
		Waits.waitUntilElementToClick(30,pageObjects.ReceipentSelection(string));
		Elements.click(pageObjects.ReceipentSelection(string));
	}

	@Then("User two mailadminauto@yopmail.com  whom we delegate the inbox should be copied in emails of User one mailuserauto@yopmail.com.")
	public void user_two_mailadminauto_yopmail_com_whom_we_delegate_the_inbox_should_be_copied_in_emails_of_User_one_mailuserauto_yopmail_com() throws InterruptedException {
		Elements.switchToFrame(pageObjects.YopMailFrame);
		Elements.VerifyTextnotEquals(pageObjects.MailVerification, "Delegate Inbox Notification");
		Elements.switchTodefaultContent();
	}
	
	@Then("filter the role name {string}")
	public void filter_the_role_name(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.ROLE_NAMEFilter);
		Elements.TypeText(pageObjects2.ROLE_NAMEFilter, string);
	}


	@When("click on Routing rule")
	public void click_on_Routing_rule() {
		Waits.waitUntilElementToClick(30,pageObjects2.Routing_Rule);
		Elements.click(pageObjects2.Routing_Rule);
	}

	@When("click on add button")
	public void click_on_add_button() {
		Waits.waitUntilElementToClick(30,pageObjects2.Add);
		Elements.jclick(pageObjects2.Add);
		//Elements.Mouseclick(pageObjects2.Add);
	}
	
	@When("click on ADD button")
	public void click_on_ADD_button() {
		Waits.waitUntilElementToClick(30,pageObjects2.ADD);
		Elements.jclick(pageObjects2.ADD);
		//Elements.Mouseclick(pageObjects2.Add);
	}

	@When("click on drop down arrow {string}")
	public void click_on_drop_down_arrow(String string) {
		Waits.waitUntilElementToClick(300,pageObjects2.dropdownArrow(string));
		Elements.click(pageObjects2.dropdownArrow(string));
	}
	
	@When("click on drop down Arrow {string}")
	public void click_on_drop_down_Arrow(String string) {
		Waits.waitUntilElementToClick(300,pageObjects2.dropdownArrowa(string));
		Elements.click(pageObjects2.dropdownArrowa(string));
	}
	
	@When("click on trigger next button")
	public void click_on_trigger_next_button() {
		Waits.waitUntilElementToClick(30,pageObjects2.Trigger_Next);
		Elements.click(pageObjects2.Trigger_Next);
	}



	@When("select drop down option as {string}")
	public void select_drop_down_option_as(String string) {
		Waits.waitUntilElementToClick(30,pageObjects.DropDownOptions(string));
		Elements.click(pageObjects.DropDownOptions(string));
		if(string.contains("label")||string.contains("SCAN")||string.contains("Completed")||string.contains("LABEL"))
		{
		Actions action = new Actions(Base.driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		}
	}
	
	@When("select drop down Option as {string}")
	public void select_drop_down_Option_as(String string) {
		Waits.waitUntilElementToClick(30,pageObjects.DropDownOptionsa(string));
		Elements.click(pageObjects.DropDownOptionsa(string));
		if(string.contains("label")||string.contains("SCAN")||string.contains("Completed"))
		{
		Actions action = new Actions(Base.driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		}
	}


	@When("enter rule name as {string}")
	public void enter_rule_name_as(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.Rule_Name);
		Elements.TypeText(pageObjects2.Rule_Name, string);
	}

	@When("Enter value as {string}")
	public void enter_value_as(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.Rule_Value);
		Elements.TypeText(pageObjects2.Rule_Value, string);
	}

	@When("click on trigger Next button")
	public void click_on_Next_button() {
		Waits.waitUntilElementToClick(30,pageObjects2.Trigger_Next);
		Elements.click(pageObjects2.Trigger_Next);
	}
	
	@When("click on rule Next button")
	public void click_onrule_Next_button() {
		Waits.waitUntilElementToClick(30,pageObjects2.ruleCondition_Next);
		Elements.click(pageObjects2.ruleCondition_Next);
	}

	@When("click on lookup")
	public void click_on_lookup() {
		Waits.waitUntilElementToClick(30,pageObjects2.Look_Up);
		Elements.click(pageObjects2.Look_Up);
	}

	@When("select folder as {string}")
	public void select_folder_as(String string) {
		Waits.waitUntilElementToClick(30,pageObjects2.FolderOptions(string));
		Elements.click(pageObjects2.FolderOptions(string));
	}

	@Then("filter the graph name {string}")
	public void filter_the_graph_name(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.GRAPH_TITLEFilter);
		Elements.TypeText(pageObjects2.GRAPH_TITLEFilter, string);
	}

	@Then("filter the rule name {string}")
	public void filter_the_rule_name(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.RULE_NAMEFilter);
		Elements.TypeText(pageObjects2.RULE_NAMEFilter, string);
	}
	
	@Then("filter login name {string}")
	public void filter_login_name(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.LOGIN_NAMEFilter);
		Elements.TypeText(pageObjects2.LOGIN_NAMEFilter, string);
	}

	@Then("left pane should consists of {string}")
	public void left_pane_should_consists_of(String string) {
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	Assert.assertEquals(data, GenericActions.verifyTextExistence(pageObjects.LeftPaneMenuList));
	}
	
	@Then("filter the address {string}")
	public void filter_the_address(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.TYPE_OF_ADDRESSFilter);
		Elements.TypeText(pageObjects2.TYPE_OF_ADDRESSFilter, string);
	}
	
	@When("enter address name as {string}")
	public void enter_address_name_as(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.Enter_Address_Name);
		Elements.TypeText(pageObjects2.Enter_Address_Name, string);
	}

	@Then("delete it")
	public void delete_it() throws InterruptedException {
		
		try
		{
		Waits.waitUntilElementToClick(10,pageObjects2.Delete);
		Elements.click(pageObjects2.Delete);
		
		Thread.sleep(300);
		
		Waits.waitUntilElementToClick(15,pageObjects.Yes_bn);
		Elements.click(pageObjects.Yes_bn);
		}catch(Exception e)
		{
			
		}
	}

	@When("click on Send")
	public void click_on_Send() {
		Waits.waitUntilElementToClick(30,pageObjects2.Send_btn);
		Elements.click(pageObjects2.Send_btn);
	}

	@Then("enter re-route recepient as {string} and select it")
	public void enter_re_route_recepient_as_and_select_it(String string) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects2.DelegateInbox_Recipienttxtbox1);
		Elements.TypeText(pageObjects2.DelegateInbox_Recipienttxtbox1, string);
		
		Thread.sleep(5000);
		
		Waits.waitUntilElementToClick(30,pageObjects.ReceipentSelection(string));
		Elements.click(pageObjects.ReceipentSelection(string));
	}

	@When("click on rule save")
	public void click_on_rule_save() {
		Waits.waitUntilElementToClick(30,pageObjects2.Save);
		Elements.click(pageObjects2.Save);
	}
	
	@When("click on create button")
	public void click_on_create_save() {
		Waits.waitUntilElementToClick(30,pageObjects2.Create_btn);
		Elements.jclick(pageObjects2.Create_btn);
	}

	@Then("User should get success msg  as {string}")
	public void user_should_get_success_msg_as(String string) {
		Waits.waitUntilElementLocated(30, pageObjects.AlertMsg);
		Elements.VerifyTextEquals(pageObjects.AlertMsg, string);
	}

	@When("Click on Manage Address")
	public void click_on_Manage_Address() {
		Waits.waitUntilElementToClick(30,pageObjects2.Manage_Address);
		Elements.click(pageObjects2.Manage_Address);
	}

	@When("Click on Add button")
	public void click_on_Add_button() {
		Waits.waitUntilElementToClick(30,pageObjects2.Add);
		Elements.click(pageObjects2.Add);
	}

	@When("Add Address Name as {string}, Desk Number as {string} , Floor number as {string} ,mobileno. as {string} ,city as {string} ,state as {string} ,country as {string} ,zip code as {string}")
	public void add_Address_Name_as_Desk_Number_as_Floor_number_as_mobileno_as_city_as_state_as_country_as_zip_code_as(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
		Waits.waitUntilElementLocated(30,pageObjects2.Enter_Address_1);
		Elements.TypeText(pageObjects2.Enter_Address_1, string);
		
		Waits.waitUntilElementLocated(30,pageObjects2.Phone_Number);
		Elements.TypeText(pageObjects2.Phone_Number, string4);
		
		Waits.waitUntilElementLocated(30,pageObjects2.City);
		Elements.TypeText(pageObjects2.City, string5);
		
		Waits.waitUntilElementLocated(30,pageObjects2.State);
		Elements.TypeText(pageObjects2.State, string6);
		
		Waits.waitUntilElementLocated(30,pageObjects2.Country);
		Elements.TypeText(pageObjects2.Country, string7);
		
		Waits.waitUntilElementLocated(30,pageObjects2.Enter_Zipcode);
		Elements.TypeText(pageObjects2.Enter_Zipcode, string8);
	}

	

	@Then("User should successfully add Office address and get success msg as {string}")
	public void user_should_successfully_add_Office_address_and_get_success_msg_as(String string) {
		Waits.waitUntilElementLocated(30, pageObjects.AlertMsg);
		Elements.VerifyTextEquals(pageObjects.AlertMsg, string);
	}

	@When("add Address Name {string} ,mobileno as {string} ,city as {string} ,state as {string} ,country {string} ,zip code as {string}")
	public void add_Address_Name_mobileno_as_city_as_state_as_country_zip_code_as(String string, String string2, String string3, String string4, String string5, String string6) {
		Waits.waitUntilElementLocated(30,pageObjects2.Enter_Address_1);
		Elements.TypeText(pageObjects2.Enter_Address_1, string);
		
		Waits.waitUntilElementLocated(30,pageObjects2.Phone_Number);
		Elements.TypeText(pageObjects2.Phone_Number, string2);
		
		Waits.waitUntilElementLocated(30,pageObjects2.City);
		Elements.TypeText(pageObjects2.City, string3);
		
		Waits.waitUntilElementLocated(30,pageObjects2.State);
		Elements.TypeText(pageObjects2.State, string4);
		
		Waits.waitUntilElementLocated(30,pageObjects2.Country);
		Elements.TypeText(pageObjects2.Country, string5);
		
		Waits.waitUntilElementLocated(30,pageObjects2.Enter_Zipcode);
		Elements.TypeText(pageObjects2.Enter_Zipcode, string6);
	}

	@Then("User should successfully add Home address and get success msg as {string}")
	public void user_should_successfully_add_Home_address_and_get_success_msg_as(String string) {
		Waits.waitUntilElementLocated(30, pageObjects.AlertMsg);
		Elements.VerifyTextEquals(pageObjects.AlertMsg, string);
	}

	@Then("User should successfully add Custom address and get success msg as {string}")
	public void user_should_successfully_add_Custom_address_and_get_success_msg_as(String string) {
		Waits.waitUntilElementLocated(30, pageObjects.AlertMsg);
		Elements.VerifyTextEquals(pageObjects.AlertMsg, string);
	}

	@When("click on {string} nQube options")
	public void click_on_nQube_options(String string) {
		Elements.scrollIntoView(pageObjects.ReportsOption(string));
		Waits.waitUntilElementToClick(30,pageObjects.ReportsOption(string));
		Elements.click(pageObjects.ReportsOption(string));
	}

	@When("click on Save")
	public void click_on_Save() {
		Waits.waitUntilElementToClick(30,pageObjects2.Save);
		Elements.click(pageObjects2.Save);
	}

	@When("click edit button")
	public void click_edit_button() {
		Waits.waitUntilElementToClick(30,pageObjects2.Edit_Icon);
		Elements.click(pageObjects2.Edit_Icon);
	}

	@When("click Assign template")
	public void click_Assign_template() {
		// Waits.waitUntilElementToClick(30,pageObjects2.Assign_Templates);
		Elements.jclick(pageObjects2.Assign_Templates);
	}

	@When("select one template checkbox as {string}")
	public void select_one_template_checkbox_as(String string) {
		try {
		Waits.waitUntilElementToClick(10,pageObjects2.Assign_Templates_Options(string));
		Elements.click(pageObjects2.Assign_Templates_Options(string));
		}catch(Exception e)
		{
			
		}
	}

	@When("click Mail Tempalte")
	public void click_Mail_Tempalte() {
		Waits.waitUntilElementToClick(30,pageObjects2.MailTemplete);
		Elements.jclick(pageObjects2.MailTemplete);
	}

	@When("User should see selected templates as {string}")
	public void user_should_see_selected_templates_as(String string) {
		Waits.waitUntilElementToClick(30,pageObjects2.MailTemplete_Options(string));
		Elements.jclick(pageObjects2.MailTemplete_Options(string));
	}

	@When("click on edit button")
	public void click_on_edit_button() {
		Waits.waitUntilElementToClick(30,pageObjects2.Edit_Icon);
		Elements.click(pageObjects2.Edit_Icon);
	}

	@When("edit content subject as {string}")
	public void edit_content_subject_as(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.Email_Subject);
		Elements.TypeText(pageObjects2.Email_Subject, string);
	}
	
	@When("click on assign button")
	public void click_on_assgn_button() {
		Waits.waitUntilElementToClick(30,pageObjects2.Assigns);
		Elements.click(pageObjects2.Assigns);
	}

	@When("click on Add new")
	public void click_on_Add_new() {
		Waits.waitUntilElementToClick(30,pageObjects2.Add_New);
		Elements.click(pageObjects2.Add_New);
	}

	@When("enter Graph name as {string}")
	public void enter_Graph_name_as(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.Graph_Name);
		Elements.TypeText(pageObjects2.Graph_Name, string);
	}

	@When("click on add")
	public void click_on_add() {
		Waits.waitUntilElementToClick(30,pageObjects2.Add);
		Elements.click(pageObjects2.Add);
	}
	
	@When("click on pulse setup add")
	public void click_on_add_Pule() {
		Waits.waitUntilElementToClick(30,pageObjects2.ADD);
		Elements.click(pageObjects2.ADD);
	}

	@Then("client admin should  get success msg as {string}")
	public void client_admin_should_get_success_msg_as(String string) {
		Waits.waitUntilElementLocated(30, pageObjects.AlertMsg);
		Elements.VerifyTextEquals(pageObjects.AlertMsg, string);
	}

	@When("click on add role button")
	public void click_on_add_role_button() {
		Waits.waitUntilElementToClick(30,pageObjects2.Add_Role);
		Elements.click(pageObjects2.Add_Role);
	}

	@When("Enter Rolename as {string}")
	public void enter_Rolename_as(String string) {
		Waits.waitUntilElementLocated(30,pageObjects2.Role_Name);
		Elements.TypeText(pageObjects2.Role_Name, string);
	}

	@When("click on edit.")
	public void click_on_edit() {
		Waits.waitUntilElementToClick(30,pageObjects2.Edit_Icon);
		Elements.click(pageObjects2.Edit_Icon);
	}

	@When("check the checkbox of menus from  Role menu assignment tab as {string} and {string}")
	public void check_the_checkbox_of_menus_from_Role_menu_assignment_tab_as_and(String string, String string2) {
		Waits.waitUntilElementToClick(30,pageObjects2.EditRoles_SubOptions(string));
		Elements.jclick(pageObjects2.EditRoles_SubOptions(string));
		
		Waits.waitUntilElementToClick(30,pageObjects2.EditRoles_SubOptions(string2));
		Elements.jclick(pageObjects2.EditRoles_SubOptions(string2));
	}
	
	@When("click on edit role headers {string}")
	public void click_on_edit_role_headers(String string) {
		Waits.waitUntilElementToClick(30,pageObjects2.EditRoles_Headers(string));
		Elements.click(pageObjects2.EditRoles_Headers(string));
	}

	@When("Click on below add role headers and check the checkbox")
	public void click_on_below_add_role_headers_and_check_the_checkbox(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		for (Map<Object, Object> data : dataTable.asMaps(String.class, String.class)) {
			
			Waits.waitUntilElementToClick(30,pageObjects2.EditRoles_Headers(String.valueOf(data.get("Header"))));
			Elements.click(pageObjects2.EditRoles_Headers(String.valueOf(data.get("Header"))));
			
			Thread.sleep(300);
			
			Waits.waitUntilElementToClick(30,pageObjects2.EditRoles_SubOptions(String.valueOf(data.get("checkbox"))));
			Elements.click(pageObjects2.EditRoles_SubOptions(String.valueOf(data.get("checkbox"))));
		}
	}

	@When("Click on assign button")
	public void click_on_assign_button() {
		Waits.waitUntilElementToClick(30,pageObjects2.Assigns);
		Elements.click(pageObjects2.Assigns);
	}

	@Then("User should get Success msg as {string}")
	public void user_should_get_Success_msg_as(String string) {
		Waits.waitUntilElementLocated(30, pageObjects.AlertMsg);
		Elements.VerifyTextEquals(pageObjects.AlertMsg, string);
	}

	@When("click on {string} role option")
	public void click_on_role_option(String string) {
		Waits.waitUntilElementToClick(30,pageObjects2.EditRoles_SubOptions(string));
		Elements.click(pageObjects2.EditRoles_SubOptions(string));
	}

	@When("check the project queue as {string}")
	public void check_the_project_queue_as(String string) {
		Waits.waitUntilElementToClick(30,pageObjects2.EditRoles_SubOptions(string));
		Elements.click(pageObjects2.EditRoles_SubOptions(string));
	}

	@When("click on assign")
	public void click_on_assign() {
		Waits.waitUntilElementToClick(30,pageObjects2.Assigns);
		Elements.click(pageObjects2.Assigns);
	}

	@When("Check the shared mail box as {string} from role shared mailbox assignment tab.")
	public void check_the_shared_mail_box_as_from_role_shared_mailbox_assignment_tab(String string) {
		Waits.waitUntilElementToClick(30,pageObjects2.EditRoles_SubOptions(string));
		Elements.click(pageObjects2.EditRoles_SubOptions(string));
	}

	@When("click on save")
	public void click_on_save() {
		Waits.waitUntilElementToClick(30,pageObjects2.Save);
		Elements.click(pageObjects2.Save);
	}

	@Then("succes msg should display. {string}")
	public void succes_msg_should_display(String string) {
		Waits.waitUntilElementLocated(30, pageObjects.AlertMsg);
		Elements.VerifyTextEquals(pageObjects.AlertMsg, string);
	}

	@When("login by newly created user to DMR aplication by entering username as {string} and password as {string}")
	public void login_by_newly_created_user_to_DMR_aplication_by_entering_username_as_and_password_as(String string, String string2) throws InterruptedException {
		Waits.waitUntilElementLocated(30,pageObjects.UserName);
		Elements.TypeText(pageObjects.UserName, string);
		Thread.sleep(3000);
		Waits.waitUntilElementToClick(30,pageObjects.Next_btn);
		Elements.click(pageObjects.Next_btn);
		Thread.sleep(1500);
		Waits.waitUntilElementLocated(30,pageObjects.Password);
		Elements.TypeText(pageObjects.Password, string);
		Thread.sleep(3000);
		Waits.waitUntilElementToClick(30,pageObjects.SignInButton);
		Elements.click(pageObjects.SignInButton);
	}

	@When("verify the menus on landing page as {string} and {string}")
	public void verify_the_menus_on_landing_page_as_and(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("User should see the menus  wch are assigned  by client admin  as {string} and {string}")
	public void user_should_see_the_menus_wch_are_assigned_by_client_admin_as_and(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("click on edit When")
	public void click_on_edit_When() {
		Waits.waitUntilElementToClick(30,pageObjects.EditIcon);
		Elements.click(pageObjects.EditIcon);
	}

	@When("click on assign action tab")
	public void click_on_assign_action_tab() {
		Waits.waitUntilElementToClick(30,pageObjects2.Assign_Action);
		Elements.click(pageObjects2.Assign_Action);
	}


	@When("select the action as {string}")
	public void select_the_action_as(String string) {
	    String[] splittedstring = string.split(",");
	    
	    for(int i=0;i<=splittedstring.length-1;i++)
	    {
	    	try
	    	{
	    	Waits.waitUntilElementToClick(30,pageObjects2.Assign_Action_Options(splittedstring[i]));
			Elements.click(pageObjects2.Assign_Action_Options(splittedstring[i]));
	    	}catch(Exception e)
	    	{
	    		
	    	}
	    }
	}

	@Then("User should get success msg {string}")
	public void user_should_get_success_msg(String string) {
		Waits.waitUntilElementLocated(30, pageObjects.AlertMsg);
		Elements.VerifyTextEquals(pageObjects.AlertMsg, string);
	}

	@When("click on actions dropdown")
	public void click_on_actions_dropdown() throws InterruptedException {
		Base.driver.navigate().refresh();
		Thread.sleep(3000);
		Waits.waitUntilElementToClick(30,pageObjects.Action_drpdwn);
		Elements.jclick(pageObjects.Action_drpdwn);
	}

	@Then("User should see selected action present the actions dropdown as {string}")
	public void user_should_see_selected_action_present_the_actions_dropdown_as(String string) {
		
		List<String> data = new ArrayList<String>();
		String[] exceldata = string.split(",");
	    	for(int i=0;i<=exceldata.length-1;i++)
	    	{
	    		data.add(exceldata[i].trim());
	    	}
	    	Collections.sort(data);
	    	Assert.assertEquals(data, GenericActions.verifyTextExistence(pageObjects2.ActionList));
	}


}
