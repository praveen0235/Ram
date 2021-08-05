package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseinit.Base;

public class pageObjects2 {
	
	public pageObjects2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='My Profile']")
	public static WebElement My_Profile;
	
	@FindBy(xpath="//input[@aria-label='ACTION NAMEFilter']")
	public static WebElement ACTION_NAMEFilter;
	
	@FindBy(xpath="//input[@aria-label='ACTIONFilter']")
	public static WebElement ACTION_Filter;
	
	@FindBy(xpath="//a[contains(text(),'Settings')]")
	public static WebElement Settings;
	
	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	public static WebElement Delete;
	
	@FindBy(xpath="//input[@placeholder='Start Date']")
	public static WebElement Start_DateIn;
	
	@FindBy(xpath="//input[@placeholder='End Date']")
	public static WebElement End_Datein;
	
	public static WebElement Settings_Options(String data)
	{
		String Xpath = "//input[@title='$']//following-sibling::span";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement Settings_Option(String data)
	{
		String Xpath = "//input[@formcontrolname='receiveOutOfOfficeNotification' and @title='$']//following-sibling::span";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement Settings_Setting_Options(String data)
	{
		String Xpath = "//a[@aria-label='$']/i";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement YopmailSettingValue(String data)
	{
		String Xpath = "//span[contains(text(),'$')]//following::td[2]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="(//button[@aria-label='Open calendar'])[1]")
	public static WebElement FromCalender;
	
	@FindBy(xpath="//li//button[@id='nextButton']/i")
	public static WebElement rignhtArrow;
	
	@FindBy(xpath="//li[@class='annotationError']/a")
	public static WebElement annotationAndRedectionMsg;
	
	@FindBy(xpath="//li//button[@id='previousButton']/i")
	public static WebElement previousButton;
	
	@FindBy(xpath="//a[@title='Total Pages']")
	public static WebElement Total_Pages;
	
	@FindBy(xpath="(//button[@aria-label='Open calendar'])[2]")
	public static WebElement ToCalender;
	
	@FindBy(xpath="//span[text()='Save']")
	public static WebElement Save;
	
	@FindBy(xpath="//span[text()='SAVE']")
	public static WebElement SAVE;
	
	@FindBy(xpath="//input[@placeholder='End Date']//parent::div//following-sibling::div//span")
	public static WebElement End_Date;
	
	@FindBy(xpath="//input[@placeholder='Start Date']//parent::div//following-sibling::div//span")
	public static WebElement Start_Date;
	
	@FindBy(xpath="//button[@aria-label='Save Rule Condition']//span[text()='Save']")
	public static WebElement Save_RuleCondition;
	
	@FindBy(xpath="//input[@aria-label='RULE NAMEFilter']")
	public static WebElement RULE_NAMEFilter;
	
	@FindBy(xpath="//input[@aria-label='LOGIN NAMEFilter']")
	public static WebElement LOGIN_NAMEFilter;
	
	@FindBy(xpath="//input[@aria-label='ROLE NAMEFilter']")
	public static WebElement ROLE_NAMEFilter;
	
	@FindBy(xpath="//input[@placeholder='Select client']")
	public static WebElement SelectclientSearch;
	
	@FindBy(xpath="//span[text()='Look Up']")
	public static WebElement Look_Up;
	
	@FindBy(xpath="//span[text()='OK']")
	public static WebElement OK_btn;
	
	@FindBy(xpath="//input[@placeholder='Graph Name*']")
	public static WebElement Graph_Name;
	
	public static WebElement FolderOptions(String data)
	{
		String Xpath = "(//mat-dialog-container[contains(@id,'mat-dialog')]//*[contains(@class,'ng-star-inserted') and contains(text(),'$')])[1]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement dropdownArrow(String data)
	{
		String Xpath = "//mat-select[@aria-label='$']//div[@class='mat-select-arrow-wrapper']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	
	@FindBy(xpath="//mat-select[@aria-label='Select Project']//span/span")
	public static List<WebElement> SelectProjectOptions;
	
	
	public static WebElement dropdownArrowa(String data)
	{
		String Xpath = "//div[@class='mat-select-trigger']//span[contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement Select_your_delivery_preference(String data)
	{
		String Xpath = "//strong[text()='Select your delivery preference']/parent::p/following-sibling::mat-radio-group/mat-radio-button//div[@class='mat-radio-label-content' and contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//a[@title='Role-Menu Assignment']")
	public static WebElement Role_Menu_Assignment;
	
	@FindBy(xpath="//div[contains(@class,'ng-trigger ng-trigger-transformPanel mat-select-panel mat-primary')]//span")
	public static List<WebElement> ActionList;
	
	@FindBy(xpath="//span[text()='Select client']")
	public static WebElement Select_client;
	
	@FindBy(xpath="(//td[@data-title='User Name'])[1]/span/span")
	public static WebElement UserRecordInTable;
	
	@FindBy(xpath="//input[@aria-label='CLIENT CODEFilter']")
	public static WebElement CLIENT_CODEFilter;
	
	@FindBy(xpath="//th[@id='fname']")
	public static WebElement UserNameHeader;
	
	@FindBy(xpath="//a[@aria-label='Assign Action']")
	public static WebElement Assign_Action;
	
	@FindBy(xpath="//input[@placeholder='Search User']")
	public static WebElement Search_User;
	
	@FindBy(xpath="//div[text()='Sub Menu of no-link']//parent::div//li//label//span/span[2]")
	public static List<WebElement> DMRSubMenuOptions;
	
	@FindBy(xpath="//li//span[@aria-label]")
	public static List<WebElement> DMRMenuOptions;

	
			
			@FindBy(xpath="(//a/span/strong)[1]")
			public static WebElement selectclientsearchselect;
	
	
	public static WebElement Search_User_Selection(String data)
	{
		String Xpath = "//div[@title='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement Assign_Action_Options(String data)
	{
		String Xpath = "//input[@aria-checked='false']//parent::div//following-sibling::span[text()='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement EditRoles_Headers(String data)
	{
		String Xpath = "//a[@title='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement EditRoles_SubOptions(String data)
	{
		String Xpath = "//span[text()='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement Delivery_Priority(String data)
	{
		String Xpath = "//strong[text()='Delivery Priority']/parent::p/following-sibling::mat-radio-group/mat-radio-button//div[@class='mat-radio-label-content' and contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement DMRMenusSelections(String data)
	{
		String Xpath = "(//li//span[@aria-label='$' or contains(text(),'$')])[1]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement DMRSubMenusSelections(String data)
	{
		String Xpath = "//div[text()='Sub Menu of no-link']//parent::div//li//label//span/span[contains(text()='$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement ClientSetUpSubMenu(String data)
	{
		String Xpath = "//a[@aria-label='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement CoustamizeOption(String data)
	{
		String Xpath = "//mat-pseudo-checkbox[@class='mat-option-pseudo-checkbox mat-pseudo-checkbox ng-star-inserted']//following::span[text()='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement CoustamizeOptiondelect(String data)
	{
		String Xpath = "//mat-pseudo-checkbox[@class='mat-option-pseudo-checkbox mat-pseudo-checkbox ng-star-inserted mat-pseudo-checkbox-checked']//following::span[text()='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//a[text()='Manage Address']")
	public static WebElement Manage_Address;
	
	@FindBy(xpath="//h3[text()='Do you want to save this preference for next login?']")
	public static WebElement Custom_Msg_ACK;
	
	@FindBy(xpath="//a[@aria-label='Save Preference']")
	public static WebElement Save_Preference;
	
	
	@FindBy(xpath="//div[@class='action-wrap']//span[text()='Next']")
	public static WebElement Trigger_Next;
	
	@FindBy(xpath="//span[text()='Create']")
	public static WebElement Create_btn;
	
	@FindBy(xpath="//div[@class='action-wrap row']//span[text()='Next']")
	public static WebElement ruleCondition_Next;
	
	@FindBy(xpath="//a[text()='Routing Rule']")
	public static WebElement Routing_Rule;
	
	@FindBy(xpath="//input[@placeholder='Value*']")
	public static WebElement Rule_Value;
	
	@FindBy(xpath="//button//span[contains(text(),'Add')]")
	public static WebElement Add;
	
	@FindBy(xpath="//button//span[contains(text(),'ADD')]")
	public static WebElement ADD;
	
	@FindBy(xpath="//span[contains(text(),'Add New')]")
	public static WebElement Add_New;
	
	@FindBy(xpath="//span[contains(text(),'Add Role')]")
	public static WebElement Add_Role;
	
	@FindBy(xpath="//input[@aria-label='ROLE NAMEFilter']")
	public static WebElement ROLE_NAMEFilter1;
	
	@FindBy(xpath="//i[@class='fa fa-pencil']")
	public static WebElement Edit_Icon;
	
	@FindBy(xpath="//input[@placeholder='Max. Retention Period (In Days)']")
	public static WebElement Max_Retention_Period_In_Days;
	
	@FindBy(xpath="//input[@placeholder='Retention Period (In Days) For deleted Items']")
	public static WebElement Retention_Period_In_Days_For_deleted_Items;
	
	
	@FindBy(xpath="//input[@placeholder='Role Name*']")
	public static WebElement Role_Name;
	
	@FindBy(xpath="//input[@aria-label='RECEIVED DATEFilter']")
	public static WebElement RECEIVED_DATEFilter;
	
	@FindBy(xpath="//td[@data-title='RECEIVED DATE/TIME']/span/span")
	public static WebElement RECEIVED_DATE_TIME;
	
	@FindBy(xpath="//td[@data-title='VOLUME RECEIVED']/span/span")
	public static WebElement VOLUME_RECEIVED_Count;
	
	@FindBy(xpath="(//td[@data-title='VOLUME']/span/span)[1]")
	public static WebElement filtered_Total_Volume;
	
	@FindBy(xpath="//span[@aria-label='Forgot password']")
	public static WebElement Forgot_Password;
	
	@FindBy(xpath="//tr//p[2]//span/span")
	public static WebElement OTP_Text;
	
	@FindBy(xpath="//td[@class='whc bordfin_gbd alt']//iframe[@class='whc']")
	public static WebElement YopmailBodyIframe;
	
	@FindBy(xpath="//button[@aria-label='Submit']")
	public static WebElement OTP_SubmitBtn;
	
	@FindBy(xpath="//input[@id='EnterOTP']")
	public static WebElement OTP_Textbox;
	
	@FindBy(xpath="//input[@id='password']")
	public static WebElement forgotpassword_Passwordtxtbox;
	
	@FindBy(xpath="//input[@id='confirmPassword']")
	public static WebElement forgotpassword_confirmPasswordtxtbox;
	
	@FindBy(xpath="//button[@title='Change Password']")
	public static WebElement Change_Password_btn;

	@FindBy(xpath="//td[@data-title='PROCESSED']/span/span")
	public static WebElement PROCESSED_Count;
	
	@FindBy(xpath="//select[@aria-label='Number Of Pages']")
	public static WebElement Number_Of_Pages;
	
	@FindBy(xpath="//a[@title='Next']")
	public static WebElement Next_btn;
	
	@FindBy(xpath="//div[@class='table-info ng-star-inserted']")
	public static WebElement Pagination_Number_Of_Records;
	
	@FindBy(xpath="//input[@placeholder='Enter Address 1*']")
	public static WebElement Enter_Address_1;
	
	@FindBy(xpath="//input[@placeholder='City *']")
	public static WebElement City;
	
	@FindBy(xpath="//input[@placeholder='State *']")
	public static WebElement State;
	
	@FindBy(xpath="//input[@placeholder='Email Subject*']")
	public static WebElement Email_Subject;
	
	@FindBy(xpath="(//i[@class='fa fa-pencil'])[1]")
	public static WebElement clientsetup_EditIcon;
	
	@FindBy(xpath="//span[text()='Assign']")
	public static WebElement Assigns;
	
	public static WebElement MailTemplete_Options(String data)
	{
		String Xpath = "//span[@title='$']//parent::td//following-sibling::td//i";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//button[@aria-label='Add New Project DocType']//span")
	public static WebElement AddDocType;
	
	@FindBy(xpath="//span[@aria-label='Mail Template']")
	public static WebElement MailTemplete;
	
	@FindBy(xpath="//a[@title='DocType Setup']")
	public static WebElement DocTypeSetup;
	
	@FindBy(xpath="//input[@aria-label='PROJECT NAMEFilter']")
	public static WebElement PROJECT_NAMEFilter;
	
	@FindBy(xpath="//input[@aria-label='NAMEFilter']")
	public static WebElement NAMEFilter;
	
	@FindBy(xpath="//a[contains(text(),' Assign Templates ')]")
	public static WebElement Assign_Templates;
	
	public static WebElement Assign_Templates_Options(String data)
	{
		String Xpath = "//mat-checkbox[@class='mat-checkbox mat-accent']//span[contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//input[@placeholder='Code']")
	public static WebElement Code;
	
	@FindBy(xpath="//input[@placeholder='Phone Number']")
	public static WebElement Phone_Number;
	
	@FindBy(xpath="//input[@placeholder='Country *']")
	public static WebElement Country;
	
	@FindBy(xpath="//input[@placeholder='Enter Zipcode*']")
	public static WebElement Enter_Zipcode;
	
	@FindBy(xpath="//span[text()='Send']")
	public static WebElement Send_btn;
	
	@FindBy(xpath="//input[@placeholder='Rule Name*']")
	public static WebElement Rule_Name;
	
	@FindBy(xpath="//span[contains(text(),'Delegate Other User')]")
	public static WebElement Delegate_Other_User;
	
	@FindBy(xpath="//li[@class='ui-autocomplete-input-token']/input")
	public static WebElement DelegateInbox_Recipienttxtbox;
	
	@FindBy(xpath="//input[contains(@class,'ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted')]")
	public static WebElement DelegateInbox_Recipienttxtbox1;
	
	@FindBy(xpath="//div[@class='recipientEmail' and @title='$']")
	public static WebElement Recipient_Selection;
	
	@FindBy(xpath="//span[@class='igif lmenudelfl']")
	public static WebElement YopMail_DeletedrpArrow;
	
	@FindBy(xpath="//a[text()='Empty Inbox']")
	public static WebElement Empty_Inbox;
	
	@FindBy(xpath="//input[@placeholder='Enter Address Name*']")
	public static WebElement Enter_Address_Name;
	
	@FindBy(xpath="//input[@aria-label='TYPE OF ADDRESSFilter']")
	public static WebElement TYPE_OF_ADDRESSFilter;
	
	@FindBy(xpath="//input[@aria-label='GRAPH TITLEFilter']")
	public static WebElement GRAPH_TITLEFilter;
	
	@FindBy(xpath="//mat-option//span")
	public static List<WebElement> RuleFieldList;
	
	@FindBy(xpath="//div[contains(text(),'Advanced Search')]")
	public static WebElement Advanced_Search;
	
	@FindBy(xpath="//input[@aria-label='Sender Name']")
	public static WebElement Sender_Name;
	
	@FindBy(xpath="//input[@aria-label='Sender Company']")
	public static WebElement Sender_Company;
	
	public static WebElement textbox_filteroptions(String data)
	{
		String Xpath = "//input[@aria-label='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement textbox_filteroptions1(String data)
	{
		String Xpath = "//input[@placeholder='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement dropdown_filteroptions(String data)
	{
		String Xpath = "//div[@class='mat-select-value']//span[text()='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement dropdown_filteroptions1(String data)
	{
		String Xpath = "//mat-select[@aria-label='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//th/span/span")
	public static List<WebElement> tableHeaders;
	
	@FindBy(xpath="//a[text()='Return To Volume Report']")
	public static WebElement Return_To_Volume_Report;
	
	@FindBy(xpath="//input[@aria-label='SCAN DATEFilter']")
	public static WebElement SCAN_DATEFilter;
	
	@FindBy(xpath="//input[@aria-label='DCNFilter']")
	public static WebElement DCNFilter;
	
	@FindBy(xpath="//div[@class='mat-select-value']//span[text()='Document Type']")
	public static WebElement Document_Type;
	
	@FindBy(xpath="//div[@class='mat-select-value']//span[text()='Location/Site']")
	public static WebElement Location_Site;
	
	@FindBy(xpath="//mat-select[@aria-label='Project']")
	public static WebElement Project;
	
	@FindBy(xpath="//div[@class='table-info ng-star-inserted']")
	public static WebElement tableInfoCount;
	
	@FindBy(xpath="//div[@class='rectangle']")
	public static WebElement DrawnRedaction;
	
	@FindBy(xpath="//div[@id='rectangle-2']")
	public static WebElement DrawnRedaction2;
	
	@FindBy(xpath="//div[@class='rectangle']")
	public static List<WebElement> ListDrawnRedaction;
	
	@FindBy(xpath="//div[@class='to-draw-rectangle']")
	public static WebElement redaction;
	
	@FindBy(xpath="//span[text()='Search']")
	public static WebElement Search_btn;
	
	@FindBy(xpath="//i[@class='fa fa-check']")
	public static WebElement redactionsave;
	
	@FindBy(xpath="//h2[contains(text(),'Total')]/a")
	public static WebElement totalCount;
	
	@FindBy(xpath="//div[contains(@class,'table-info')]")
	public static WebElement tableinfo_totalcount;
	
	@FindBy(xpath="(//td[@data-title='DCN']/span/span)[1]")
	public static WebElement DCNValue;
	
	@FindBy(xpath="(//i[contains(@class,'drag-handle fa fa-arrows-alt ')])[1]")
	public static WebElement DoubleClickArrow;
	
	@FindBy(xpath="//div/i[@class='fa fa-times']")
	public static WebElement redactionDelete;
	
	@FindBy(xpath="//div/i[@class='fa fa-times']")
	public static List<WebElement> ListredactionDelete;
	
	public static WebElement volumeReportsTableData(String data)
	{
		String Xpath = "//td[@data-title='$']//span/span";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement PDFPageheaders(String data)
	{
		String Xpath = "//a[@title='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement reportpageheaders(String data)
	{
		String Xpath = "//h2[contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement citydropdwnSelection(String data)
	{
		String Xpath = "(//span[text()='$'])[1]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//span[@title='Completed']")
	public static WebElement CompletedFolder;
	
	@FindBy(xpath="//div//span[@title='Not My Mail']")
	public static WebElement Not_My_Mail_Folder;
	
	@FindBy(xpath="//a[@title='Open Mail']")
	public static WebElement Open_Mail;
	
	
	@FindBy(xpath="//span[@class='mat-option-text']")
	public static List<WebElement> FieldOptionsList;
	
	@FindBy(xpath="//ul[@id='steps-bar']//li//span")
	public static List<WebElement> Addruleoptions;
	
	@FindBy(xpath="//div[@class='full-width-input-wrap select-box-wrap addressList']//div[@class='mat-radio-label-content']")
	public static WebElement ManageDeliveryAddress;
	
	@FindBy(xpath="//input[@aria-label='USERFilter']")
	public static WebElement USERFilter;
	
	@FindBy(xpath="//input[@aria-label='EVENTFilter']")
	public static WebElement EVENTFilter;
	
	@FindBy(xpath="(//td[@data-title='STATUS']//span/span)[1]")
	public static WebElement STATUSValue;
	
	@FindBy(xpath="//span[@title='Undeliverable Mail']")
	public static WebElement Undeliverable_Mail;
	
	@FindBy(xpath="(//td[@data-title='EVENT']//span/span)[1]")
	public static WebElement EVENTName;
	
	@FindBy(xpath="(//td[@data-title='USER']//span/span)[1]")
	public static WebElement UsernameValue;
	
	@FindBy(xpath="//div[@class='flatpickr-calendar animate showTimeInput arrowTop open']//span[@class='flatpickr-day selected' or @class='flatpickr-day today selected']")
	public static WebElement Selecteddate;
	
	
	//********//
	
	public static WebElement InboxTableDataValid(String data)
	{
		String Xpath = "//table/tbody//tr[1]//*[contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//table/tbody")
	public static WebElement Table_Valid;
	
	
	@FindBy(xpath="//table/thead//span/span")
	public static List<WebElement> TableHeaders_Valid;
	
	@FindBy(xpath="//div[@class='client-setup-tabs']//li/a")
	public static List<WebElement> EditRole_Headers;
	
	public static WebElement MainMenuArrow(String data)
	{
		String Xpath = "//span[text()='$']//ancestor::span/following-sibling::i[@class='fa fa-angle-right side-arrow']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//div[contains(text(),'Sub Menu of ')]/following::span[@class='mat-checkbox-label']")
	public static List<WebElement> SubMenu_Options;
	
	
	public static WebElement MainMenuCheckbox_Check(String data)
	{
		String Xpath = "//span[text()='$']//ancestor::mat-checkbox[contains(@class,'mat-accent')]//following::span[text()='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	
	@FindBy(xpath="//div[@class='main-dmr-dashboard-container']//h4")
	public static List<WebElement> DashboardContainer_Options;
	

	public static WebElement DashboardContainerData_Valid(String data)
	{
		String Xpath = "//h4[contains(text(),'$')]/preceding-sibling::h1";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//mat-select[@aria-label='Select Engagement']//span/span")
	public static WebElement SelectEngagement_DefaultValue;
	
	
	@FindBy(xpath="//mat-select[@id='mat-select-5']//span/span")
	public static WebElement LastDayRecords;
	
	
	
	@FindBy(xpath="//a[@aria-label='Reports']/following::a//span[@class='label-txt']")
	public static List<WebElement> ReportsSubMenu_options;
	
	@FindBy(xpath="//input[@aria-label='dcn']")
	public static WebElement DCN_TextBox;
	
	
	@FindBy(xpath="//select[@aria-label='Number Of Pages']")
	public static WebElement NoOfPages_DropDown;
	
	public static WebElement DisplayingPages_Valid(String data)
	{
		String Xpath = "//td[@data-title='No. of unique Users']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}

	
	@FindBy(xpath="//h2[contains(text(),'Total Active Users: ')]/a")
	public static WebElement TotalActiveUser_Link;
	
	
	@FindBy(xpath="//input[@aria-label='DATE/TIMEFilter']")
	public static WebElement DateTimeFilter;
	
	public static WebElement TabsLink(String data)
	{
		String Xpath = "//a[text()='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	
	@FindBy(xpath="//input[@aria-label='FIRST NAMEFilter']")
	public static WebElement FirstNameFilter;
	
	@FindBy(xpath="//span[contains(text(),'Add Recipients')]")
	public static WebElement AddRecipients_btn;
	
	public static WebElement AddRecipients_Options(String data)
	{
		String Xpath = "//li/a[contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement ReachoutOption(String data)
	{
		String Xpath = "//span[@aria-label='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//input[@formcontrolname='firstname']")
	public static WebElement AddRecipients_FirstName;
	
	@FindBy(xpath="//input[@formcontrolname='lastname']")
	public static WebElement AddRecipients_LastName;
	
	@FindBy(xpath="//input[@formcontrolname='email']")
	public static WebElement AddRecipients_Email;
	
	@FindBy(xpath="//button/span[text()='ADD']")
	public static WebElement AddRecipients_ADD;
	
	@FindBy(xpath="//input[@aria-label='User NameFilter']")
	public static WebElement UserNameFilter;
	
	@FindBy(xpath="//input[@aria-label='ModuleFilter']")
	public static WebElement ModuleFilter;
	
	@FindBy(xpath="//input[@aria-label='RECIPIENT NAMEFilter']")
	public static WebElement RecipientNameFilter;
	
	
	
	@FindBy(xpath="//input[@aria-label='DateFilter']")
	public static WebElement DateFilter;
	
	@FindBy(xpath="//span[@style='display:block' and text()='Metadata']//following::tree-node-content/span[@style='display:block']")
	public static List<WebElement> MetadataOptions;
	
	@FindBy(xpath="//span[text()='Metadata']//parent::tree-node-content//parent::div//ancestor::tree-node-wrapper//span/span")
	public static WebElement Metadata;
	
	@FindBy(xpath="//span[text()='Extended Info']//parent::tree-node-content//parent::div//ancestor::tree-node//span/span")
	public static WebElement Extended_Info;
	
	public static WebElement HeaderAscending(String data)
	{
		String Xpath = "//thead/tr[1]/th//span[text()='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//span[@class='icon-arrow_left']")
	public static WebElement AddFields_LeftArrow;
	
	@FindBy(xpath="//div[@id='signer-1']")
	public static WebElement Name;
	
	@FindBy(xpath="//div[@id='signer-2']")
	public static WebElement Date;
	
	@FindBy(xpath="//div[@id='signer-3']")
	public static WebElement Signature;
	
			@FindBy(xpath="(//a[contains(@class,'btn btn-default btn-select name')]/span[@class='btn-select-arrow fa fa-angle-down'])[1]")
			public static WebElement NameDropDown;
	
			
	
					public static WebElement NameOptions()
					{
						String Xpath = "(//a[contains(@class,'btn btn-default btn-select name')]//li[text()])[1]";
						WebElement element = Base.driver.findElement(By.xpath(Xpath));
						return element;
					}
					
					
	@FindBy(xpath="(//a[contains(@class,'btn btn-default btn-select date')]/span[@class='btn-select-arrow fa fa-angle-down'])[1]")
	public static WebElement DateDropdown;
	
	@FindBy(xpath="//div[@class='drop ui-droppable'][1]")
	public static WebElement droptarget;	
			
	@FindBy(xpath="(//a[contains(@class,'btn btn-default btn-select signature')]/span[@class='btn-select-arrow fa fa-angle-down'])[1]")
	public static WebElement signaturedropdown;
	
	@FindBy(xpath="(//a[contains(@class,'btn btn-default btn-select signature')]//li[text()])[1]")
	public static WebElement SignatureOption;
	
	@FindBy(xpath="//button[text()='Submit']")
	public static WebElement Submitbtn;
	
	@FindBy(xpath="//a[@title='Reset Password']")
	public static WebElement Reset_Password;
	
	@FindBy(xpath="//input[@aria-label='password']")
	public static WebElement Reset_Password_textbox;
	
	@FindBy(xpath="//p[2]/span/span")
	public static WebElement Reset_Password_mail_text;
	
	
	
	
	
}
