package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseinit.Base;

public class pageObjects {
	
	public pageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='loginName' or @name='loginName']")
	public static WebElement UserName;
	
	@FindBy(xpath="//input[@name='loginName']")
	public static WebElement ExelaAppUserName;
	
	@FindBy(xpath="//input[@name='loginPassword']")
	public static WebElement Password;
	
	@FindBy(xpath="//span[@title='Deleted Items']")
	public static WebElement Deleted_Items;
	
	@FindBy(xpath="//button[text()='LOGIN']")
	public static WebElement SignInButton;
	
	@FindBy(xpath="//div[@class='loading-wrap']//div[@class='sk-fading-circle loading-icon']")
	public static WebElement spinner;
	
	@FindBy(xpath="//button[text()='Next']")
	public static WebElement Next_btn;
	
	@FindBy(xpath="//td[@data-title='COUNT']//span/span")
	public static WebElement Count;
	
	@FindBy(xpath="//mat-error[@class='mat-error ng-star-inserted']")
	public static WebElement Alerterror;
	
	@FindBy(xpath="//app-toast[@class='ng-star-inserted']//span")
	public static WebElement AlertMsg;
	
	@FindBy(xpath="//i[@alt='visibilityIcon']")
	public static WebElement ShowPasswordIcon; 
	
	@FindBy(xpath="//span[contains(text(),'Forgot password')]")
	public static WebElement ForgotPassword;
	
	public static WebElement DropDownOptions(String data)
	{
		String otp = "//span[@class='mat-option-text' and contains(text(),'$')]";
		WebElement OTP = Base.driver.findElement(By.xpath(otp.replace("$", data)));
		return OTP;
	}
	
	public static WebElement DropDownOptionsa(String data)
	{
		String otp = "//md-option[contains(text(),'$')]";
		WebElement OTP = Base.driver.findElement(By.xpath(otp.replace("$", data)));
		return OTP;
	}
	
	@FindBy(xpath="//*[@class='mat-option-text' or @title='User/Shared MailBox'] ")
	public static List<WebElement> DropDownList;
	
	public static WebElement DropDwnArrow(String data)
	{
		String Xpath = "//mat-select[@aria-label='$']//div[@class='mat-select-arrow-wrapper']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement LeftPaneMenu(String data)
	{
		String Xpath = "//a[contains(@aria-label,'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement LeftPaneMenua(String data)
	{
		String Xpath = "//a//span[@class='label-txt' and contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement graphName(String data)
	{
		String Xpath = "//li//h3[text()='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//mat-nav-list[@class='mat-nav-list mat-list-base']//span/span/following-sibling::span[1]")
	public static List<WebElement> LeftPaneMenuList;
	
	@FindBy(xpath="//span[contains(text(),'Add Role')]")
	public static WebElement AddRole;
	
	@FindBy(xpath="//td[@data-title='DCN']//span/span")
	public static WebElement DCNValue;
	
	public static WebElement DCNValue(String data)
	{
		String Xpath = "//td[@data-title='DCN']//span/span[contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//textarea[@id='deliveryInstructions']")
	public static WebElement deliveryInstructions;
	
	@FindBy(xpath="//td[@class='no-records ng-star-inserted']")
	public static WebElement no_records_available;
	
	@FindBy(xpath="//input[@id='mat-input-0']")
	public static WebElement RoleName;
	
	@FindBy(xpath="//span[text()='Save']")
	public static WebElement Save;
	
	@FindBy(xpath="//input[@id='searchTableData']")
	public static WebElement Search;
	
	@FindBy(xpath="//i[@class='fa fa-pencil']")
	public static WebElement EditIcon;
	
	public static WebElement ProjectSetUpSbHeaders(String data)
	{
		String Xpath = "//div[@class='client-setup-tabs']//a[contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//span[contains(text(),'Add DocType')]")
	public static WebElement AddDocType;
	
	@FindBy(xpath="//form[@class='ng-untouched ng-pristine ng-invalid']//input")
	public static WebElement AddDocHeaders;
	
	@FindBy(xpath="//span[contains(text(),'DocType Name*')]/ancestor::span/parent::div/input")
	public static WebElement DocTypeName;
	
	@FindBy(xpath="//span[contains(text(),'DocType Description')]/ancestor::span/parent::div/input")
	public static WebElement DocDescription;
	
	@FindBy(xpath="//span[contains(text(),'Retention Period(In Days)')]/ancestor::span/parent::div/input")
	public static WebElement RetentionPeriod;
	
	@FindBy(xpath="//span[contains(text(),'Notify me Before(In Days)')]/ancestor::span/parent::div/input")
	public static WebElement NotifymeBeforeInDays;
	
	@FindBy(xpath="//span[contains(text(),'SLA(In Days)')]/ancestor::span/parent::div/input")
	public static WebElement SLAInDays;
	
	@FindBy(xpath="//span[text()='ADD']")
	public static WebElement AddButton;
	
	@FindBy(xpath="//mat-error[@class='mat-error ng-star-inserted']")
	public static WebElement MandatoryFielderror;
	
	@FindBy(xpath="//span[text()='Cancel']")
	public static WebElement CancelBtn;
	
	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	public static WebElement DeleteBtn;
	
	@FindBy(xpath="//span[text()='Routing Rule']")
	public static WebElement RoutingRule;
	
	@FindBy(xpath="//span[contains(text(),'Add')]")
	public static WebElement Addbtn;
	
	@FindBy(xpath="//input[@id='mat-input-27']")
	public static WebElement RuleName;
	
	@FindBy(xpath="//span[text()='Next']")
	public static WebElement PaginationNext;
	
	@FindBy(xpath="//input[@id='mat-input-29']")
	public static WebElement OperatorValue;
	
	@FindBy(xpath="(//span[text()='Save'])[2]")
	public static WebElement RuleSaveBtn;
	
	@FindBy(xpath="//span[@aria-label='User Profile Photo']/i")
	public static WebElement Profile_Pic;
	
	@FindBy(xpath="//a[text()='Logout']")
	public static WebElement Logout;
	
	@FindBy(xpath="//ul//a[@title='Home']")
	public static WebElement Profile_Home;
	
	@FindBy(xpath="//img[@title='DMR']")
	public static WebElement ClientAdmin_DMR;
	
	@FindBy(xpath="//h3[contains(text(),'$')]/parent::li/following-sibling::li//div[@class='mat-select-arrow']")
	public static WebElement DashBoardGraphDropDownArrow;
	
	public static WebElement DashBoardGraphDropDownArrow(String data)
	{
		String Xpath = "//h5[contains(text(),'$')]/parent::li/following-sibling::li//div[@class='mat-select-arrow']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement DashBoardGraphDropDownArrowa(String data)
	{
		String Xpath = "//div[@class='mat-select-trigger']//span[contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement ReportsOption(String data)
	{
		String Xpath = "//span[@aria-label='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement routingruleheaders(String data)
	{
		String Xpath = "//span[text()='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	
			
			public static WebElement disabledDates(String data)
			{
				String Xpath = "(//div[@class='flatpickr-calendar animate arrowTop open']//span[@aria-label='$'])[1]";
				WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
				return element;
			}
	
	public static WebElement selectedAddressOption(String data)
	{
		String Xpath = "//span[text()='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//div[contains(@class,'ng-star-inserted')]//label/span")
	public static WebElement ReportFilterOptionsList;
	
	@FindBy(xpath="//i[@class='fa fa-download']")
	public static WebElement DownloadIcon;
	
	@FindBy(xpath="//div[contains(text(),'Advanced Search')]")
	public static WebElement AdvancedSearch;
	
	@FindBy(xpath="//span[@title='Previous']")
	public static WebElement Pagination_Previous;
	
	@FindBy(xpath="//span[@title='Next']")
	public static WebElement Pagination_Next;
	
	@FindBy(xpath="//input[@aria-label='STATUSFilter']")
	public static WebElement StatusFilter;
	
	@FindBy(xpath="//td[2]/input[@id='checkbox0']")
	public static WebElement Mail_Selection;
	
	@FindBy(xpath="//td[2]/input[@id='checkbox0']")
	public static List<WebElement> Mail_SelectionList;
	
	@FindBy(xpath="(//span[text()='Select Action' and contains(@class , 'ng-star-inserted')])[1]")
	public static WebElement Action_drpdwn;
	
	
	
	public static WebElement Action_Selection(String data)
	{
		String Xpath = "//div[contains(@class,'ng-trigger ng-trigger-transformPanel mat-select-panel mat-primary')]//span[contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//span[text()='Create']")
	public static WebElement Create_btn;
	
	public static WebElement Select_your_delivery_preference(String data)
	{
		String Xpath = "//strong[text()='Select your delivery preference']/parent::p/following-sibling::mat-radio-group/mat-radio-button//div[@class='mat-radio-label-content' and contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public static WebElement Delivery_Priority(String data)
	{
		String Xpath = "//strong[text()='Delivery Priority']/parent::p/following-sibling::mat-radio-group/mat-radio-button//div[@class='mat-radio-label-content' and contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//input[@id='fromDate']")
	public static WebElement FromDate;
	
	@FindBy(xpath="//mat-icon[text()='menu']")
	public static WebElement Menu;
	
	@FindBy(xpath="//input[@id='toDate']")
	public static WebElement ToDate;
	
	public static WebElement ActionOptionsSelections(String data)
	{
		String Xpath = "//div[@id='cdk-overlay-1']//span[contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//input[contains(@class,'ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted')]")
	public static WebElement Lookup_RecipentTextbox;
	
	@FindBy(xpath="//li[@class='ui-autocomplete-input-token']/input")
	public static WebElement Lookup_SendTo_RecipentTextbox;
	
	@FindBy(xpath="//div[@class='popup-heading']")
	public static WebElement PopUpWindowLabel;
	
	@FindBy(xpath="//input[@aria-label='STATUSFilter']")
	public static WebElement STATUSFilter;
	
	public static WebElement ReceipentSelection(String data)
	{
		String Xpath = "//li//div[contains(@class, 'ng-star-inserted')]//div[@title='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	
			
			@FindBy(xpath="(//a[@aria-label='Inbox'])[2]")
			public static WebElement Inbox2;	
	
	@FindBy(xpath="(//td[5]/span/span)[1]")
	public static WebElement Mail_Status;
	
	@FindBy(xpath="//span[contains(text(), 'Send')]")
	public static WebElement Sendbtn;
	
	@FindBy(xpath="//th/span/span")
	public static WebElement ReportTableFilters;
	
	@FindBy(xpath="//h2[contains(text(),'Total Volume:')]/a")
	public static WebElement TotalVolume;
	
	public static WebElement Return_To_Report(String data)
	{
		String Xpath = "//a[contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//input[@id='senderName']")
	public static WebElement SenderName;
	
	@FindBy(xpath="//input[@id='senderCompany']")
	public static WebElement SenderCompany;
	
	@FindBy(xpath="//input[@id='recipient']")
	public static WebElement Recipient;
	
	@FindBy(xpath="//span[text()='Search']")
	public static WebElement Serach_btn;
	
	@FindBy(xpath="//input[@id='filter1']")
	public static WebElement ClientNameFilter;
	
	@FindBy(xpath="//div[@class='fabContent']//span[contains(text(),'TOTAL MAIL')]")
	public static WebElement TOTAL_MAIL;
	
	@FindBy(xpath="//div[@class='fabContent']//span[text()='OPENED MAIL']")
	public static WebElement OPENED_MAIL;
	
	@FindBy(xpath="//div[@class='fabContent']//span[text()='UNOPENED MAIL']")
	public static WebElement UNOPENED_MAIL;
	
	@FindBy(xpath="//input[@id='mat-input-26']")
	public static WebElement ClientSetUp_MaxRetentionPeriodDays;
	
	@FindBy(xpath="//input[@id='mat-input-27']")
	public static WebElement ClientSetUp_RetentionPeriodDaysForDeletedIteams;
	
	@FindBy(xpath="//input[@id='filter0']")
	public static WebElement Mail_DCNFilter;
	
	@FindBy(xpath="//li[@class='ui-autocomplete-input-token']/input")
	public static WebElement EnterRecipient;
	
	public static WebElement Recipent_Selection(String data)
	{
		String Xpath = "//div[contains(@class,'ui-helper-clearfix')]//div[@title='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//button//span[contains(text(),'Send')]")
	public static WebElement Send_btn;
	
	@FindBy(xpath="//a[text()='Send Mail']")
	public static WebElement SendMail;
	
	@FindBy(xpath="//a[text()='Send Mail With Comment']")
	public static WebElement SendMailWithComment;
	
	@FindBy(xpath="//input[@id='filter1']")
	public static WebElement VolumeRecivedFilterTxtBx;
	
	@FindBy(xpath="(//td[2]//span[@aria-label='link'])[1]")
	public static WebElement CountLink;
	
	@FindBy(xpath="//a[@title='Switch Role']")
	public static WebElement SwitchToRole;
	
	public static WebElement SwitchToRole_Radiobtn(String data)
	{
		String Xpath = "//div[contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//span[contains(text(),'Yes')]")
	public static WebElement Yes_btn;
	
	@FindBy(xpath="//button[@aria-label='Open calendar']/span")
	public static WebElement startdate;
	
	@FindBy(xpath="//span[contains(text(),'YES')]")
	public static WebElement YES_btn;
	
	@FindBy(xpath="//span[text()='NO']")
	public static WebElement NO_btn;
	
	@FindBy(xpath="//button[@aria-label='Add Scheduler']/span")
	public static WebElement Add_Scheduler;
	
	@FindBy(xpath="//button[@aria-label='Add New Project']/span")
	public static WebElement Add_Project;
	
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	public static WebElement Yes_bn;
	
	@FindBy(xpath="//button[contains(text(),'No')]")
	public static WebElement No_btn;
	
	@FindBy(xpath="//input[contains(@class,'ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted')]")
	public static WebElement Do_you_want_to_suggest_any_other_user_name;
	
	@FindBy(xpath="//textarea[@id='extraComment']")
	public static WebElement Comment;
	
	public static WebElement EnvelopeViewScreen_PageTabs(String data)
	{
		String Xpath = "//a[@title='$']";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//span[contains(text(),'Show all pages')]")
	public static WebElement ShowAllPages;
	
	@FindBy(xpath="//span[text()='OK']")
	public static WebElement OK_btn;
	
	@FindBy(xpath="//tr[1]//td[1]//i[@class='drag-handle fa fa-arrows-alt ']")
	public static WebElement DoubleClick_OpenMail;
	
	@FindBy(xpath="//div[@class='to-draw-rectangle']")
	public static WebElement Area_to_redact;
	
	@FindBy(xpath="//div[@class='to-draw-rectangle']//div")
	public static WebElement DrawnRectangle;
	
	@FindBy(xpath="//div[@class='js-popper popper jsPopper']//i[@class='fa fa-times']")
	public static WebElement Redact_Delete_option;
	
	@FindBy(xpath="//div[@class='js-popper popper jsPopper']//i[@class='fa fa-check']")
	public static WebElement Redact_Save_Option;
	
	@FindBy(xpath="(//td[1]/span/span)[1]")
	public static WebElement FilteredDCNRecord;
	
	public static WebElement LabelSelection(String data)
	{
		String Xpath = "//td[@class='table-data']//span[contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//span[contains(@class,'ui-autocomplete ui-widget')]/input")
	public static WebElement DrySignRecipientTxtBox;
	
	public static WebElement FolderOptions(String data)
	{
		String Xpath = "//mat-dialog-container[contains(@id,'mat-dialog')]//*[contains(@class,'ng-star-inserted') and contains(text(),'$')]";
		WebElement element = Base.driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//span[contains(text(),'ASSIGN LABEL ')]")
	public static WebElement AssignLabel;
	
	@FindBy(xpath="//span[contains(text(),'CLOSE ')]")
	public static WebElement Close_btn;
	
	@FindBy(xpath="//input[@id='login']")
	public static WebElement YOPMail_Emailtxt_box;
	
	@FindBy(xpath="//input[@type='submit']")
	public static WebElement YOPMail_CheckInbox;
	
	@FindBy(xpath="(//span[@class='lms'])[1]")
	public static WebElement MailVerification;
	
	@FindBy(xpath="//iframe[@id='ifinbox']")
	public static WebElement YopMailFrame;
	
	@FindBy(xpath="//a[contains(text(),'Delete')]")
	public static WebElement YopDelete;
	
	@FindBy(xpath="//a[contains(text(),'Empty Inbox')]")
	public static WebElement YopEmpty_Inbox;
	
	@FindBy(xpath="//iframe[@id='ifmail']")
	public static WebElement YopMailFrame2;
	
	@FindBy(xpath="//span[@title='DMR_CORE']/parent::td//following-sibling::td[3]/span/span")
	public static WebElement DMR_CORE_Status;
	
	@FindBy(xpath="//span[@title='DMR_CORE']/parent::td//following-sibling::td[2]/span/span")
	public static WebElement DMR_CORE_DBStatus;
	
	@FindBy(xpath="//span[@title='Ingester']/parent::td//following-sibling::td[3]/span/span")
	public static WebElement Ingester_Status;
	
	@FindBy(xpath="//span[contains(@title,'eFirst-Archive')]/parent::td//following-sibling::td[3]/span/span")
	public static WebElement eFirst_Archive_DEMO_Status;
	
	@FindBy(xpath="//span[@title='EXELA_AUTH']/parent::td//following-sibling::td[3]/span/span")
	public static WebElement Exela_Auth_Status;
	
	@FindBy(xpath="//span[@title='AutoSharedBox']")
	public static WebElement DeactvatedUser;
	
	@FindBy(xpath="//span[@title='Inbox']")
	public static WebElement Inbox;
	
	@FindBy(xpath="//tr[1]//td[1]//i[@class='drag-handle fa fa-arrows-alt ']")
	public static WebElement SourceEmail;
	
	@FindBy(xpath="//span[@title='EXELA_AUTH']/parent::td//following-sibling::td[2]/span/span")
	public static WebElement Exela_Auth_DBStatus;
	
	
	
}
