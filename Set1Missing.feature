
Feature: Verify different functionalities for Client Admin login
Background: User is Logged In
 	Given navigate to given URL "https://dmr-qa.exela.global/#/login"
	Then enter username as "septclient"
	Then click on next button
	Then enter Password as "Pa$$w0rd"
	And click on signin button
@Yes
Scenario: Verify client admin is able to add role and Edit role functionality for Client Admin
	Then click on toggle menu
	Then click on left pane menu "Role Setup"
	
	When   click on add role button
	When   Enter Rolename as "TestRole" 
	
	When click on drop down arrow "Role Type*" 
	When   select drop down option as "Mail User"
	When click on drop down arrow "Product*" 
	When   select drop down option as "DMR"
	When   click on save button 
	Then User should get succesThen filter the role name "TestRole"
	And delete its msg as "Role has been added successfully"
	Then filter the role name "TestRole"
	When   click on edit.
	When click on edit role headers "Role-Menu Assignment"
	When    check the checkbox of menus from  Role menu assignment tab as "Dashboard (dmr-dashboard)" and "Inbox (mail-user-inbox)"
	When   Click on assign button
    	Then User should get Success msg as "Menus has been added Successfully"
    	When click on edit role headers "Role-Project Assignment"
   	 #When click on "Role-Project Assignment" role option
   	When click on drop down arrow "Select Project*" 
	When   select drop down option as "septClient_project"
	When    check the project queue as "PD"
	When   click on assign
    	Then User should get success msg as "Project queue access updated Successfully"
    	When click on edit role headers "Role-Shared-Mailbox Assignment"
	When   Check the shared mail box as "Test123" from role shared mailbox assignment tab.
	Then User should get success msg as "Shared Mailbox assigned to role"
	Then filter the role name "TestRole"
	And delete it
@Yes
Scenario: Add Retention period by user	
	Then click on toggle menu
	Then click on left pane menu "Project Setup"
	Then filter the project name " septClient_project "
	When click on edit.
	#When click on add project
	Then click on doctype setup
	Then filter the name "Doc123"
	And delete it
	Then click on adddoc type
	When Enter on DocType Name as "Doc123"
	When Enter DocType Description as "Doc123"
	When Enter Retention period
	|Rperiod|
	|2|
	|3|
	When Enter Notify me Before as "1" 
	When click on ADD button
	Then User should get success msg as "DocType added successfully !"
	Then filter the name "Doc123"
	And delete it
@Yes
Scenario: Add multiple notify me in days while setting up retention	
	Then click on toggle menu
	Then click on left pane menu "Project Setup"
	Then filter the project name "septClient_project"
	When click on edit.
	Then click on doctype setup
	Then filter the name "DocTest1"
	And delete it
	Then click on adddoc type
	When Enter on DocType Name as "DocTest1"
	When Enter DocType Description as "DocTest1"
	When Enter Retention period as "6"
	When Enter Notify me Before as "2"
	When Enter Spacebar
	When Enter Notify me Before as "1"
	When click on ADD button
	Then User should get success msg as "DocType added successfully !"
	Then filter the name "DocTest1"
	And delete it
@Yes
Scenario: Validate Notify me is working fine
	Then click on toggle menu
	Then click on left pane menu "Project Setup"
	Then filter the project name "septClient_project"
	When click on edit.
	Then click on doctype setup
	Then filter the name "TAX"
	And delete it
	Then click on adddoc type
	When Enter on DocType Name as "TAX"
	When Enter DocType Description as "TAX"
	When Enter Retention period as "5"
	When Enter Notify me Before as "1"
	When click on ADD button
	Then User should get success msg as "DocType added successfully !"
	Then filter the name "TAX"
	And delete it
	Then Click on profile picture
        And logout
	
@Yes
Scenario: Validate Cancel Button is working fine
	Then click on toggle menu
	Then click on left pane menu "Project Setup"
	Then filter the project name "septClient_project"
	When click on edit.
	When Select Doctype Setup
	Then click on doctype setup
	Then click on adddoc type
	When Enter on Add DocType as "Doc1234"
	When Enter DocType Description as "DOcDesc"
	When Enter Retention period as "5"
	And click on Cancel 
	Then User should see Add doctype button enabled.
@Yes
Scenario Outline: Add doctype name with blank and Alphanumeric value
Then click on toggle menu
	Then click on left pane menu "Project Setup"
	Then filter the project name "septClient_project"
When click on edit.
Then click on doctype setup
	Then filter the name "<value>"
	And delete it
Then click on adddoc type
When Enter value "<value>"
When click on ADD button
Then User should get success msg as "DocType added successfully !"
Then filter the name "<value>"
	And delete it
Examples:
|value|
| |
|A123|


@Yes
Scenario Outline: Add doctype description with blank and Alphanumeric value
Then click on toggle menu
Then click on left pane menu "Project Setup"
Then filter the project name "septClient_project"
When click on edit.
Then click on doctype setup
Then filter the name "Doc1"
And delete it
Then click on adddoc type
When Enter on Add DocType as "Doc1"
When Enter DocType Description as "<DOcDesc>"
When click on ADD button
Then User should get success msg as "DocType added successfully !"
Then filter the name "Doc1"
And delete it
	
Examples:
|DOcDesc|
|  |
|DocDesc123|

@Yes
Scenario Outline: Add blank value in retention period

Then click on toggle menu
Then click on left pane menu "Project Setup"
Then filter the project name "septClient_project"
When click on edit.
Then click on doctype setup
Then filter the name "Doc1234"
And delete it
Then click on adddoc type
When Enter on Add DocType as "Doc1234"
When Enter DocType Description as "DOcDesc"
When Enter Retention period "<Rperiod>"
When click on ADD button
Then User should get error msg as "Input maximum 4 digit number."

Examples:
|Rperiod|
|  |

@Yes
Scenario: Edit DocType
Then click on toggle menu
	Then click on left pane menu "Project Setup"
	Then filter the project name "septClient_project"
	When click on edit.
	Then click on doctype setup
	Then filter the name "TAX"
	And delete it
	Then click on adddoc type
	When Enter on DocType Name as "TAX"
	When Enter DocType Description as "TAX"
	When Enter Retention period as "5"
	When Enter Notify me Before as "1"
	When click on ADD button
	Then User should get success msg as "DocType added successfully !"
	Then filter the name "TAX"
	When click on edit.
	When Enter DocType Description as "Testing"
	When click on SAVE button
	Then filter the name "TAX"
	And delete it
	Then Click on profile picture
        And logout


@Yes
Scenario: Delete DocType
Then click on toggle menu
	Then click on left pane menu "Project Setup"
	Then filter the project name "septClient_project"
	When click on edit.
	Then click on doctype setup
	Then filter the name "TAX"
	And delete it
	Then click on adddoc type
	When Enter on DocType Name as "TAX"
	When Enter DocType Description as "TAX"
	When Enter Retention period as "5"
	When Enter Notify me Before as "1"
	When click on ADD button
	Then User should get success msg as "DocType added successfully !"
	Then filter the name "TAX"
	And delete it
	Then Click on profile picture
        And logout

@Yes
Scenario: Add SLA days
Then click on toggle menu
	Then click on left pane menu "Project Setup"
	Then filter the project name "septClient_project"
When click on edit.
	Then click on doctype setup
	Then filter the name "Doc123435"
	And delete it
	Then click on adddoc type
When Enter on Add DocType as "Doc123435"
When Enter DocType Description as "DOcDesc"
When Enter Retention period "5"
When Enter SLA in days as "3"
When   click on ADD button
Then User should get success msg as "DocType added successfully !"
Then filter the name "Doc123435"
	And delete it
	
@Yes
Scenario: Validate Junk mail action is working
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then select action as "Junk Mail"
Then click on Yes button
Then User should get success msg as "Action applied to selected mail items"
Then click on Deleted Items folder
Then check whether same email is present in Deleted Items folder
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "CLIENTADMIN"
Then click OK button
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Action Summary Report"
Then filter the action "Junk Mail"
Then click on count that is showing
Then the junk mail count and total detailed count should be equal

@Yes
Scenario: Validate Not my mail Action is working
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then select action as "Not My Mail"
Then Enter Email id as  "mailuserauto@yopmail.com" in Do_you_want_to_suggest_any_other_user_name?
Then click on Yes button
Then User should get success msg as "Digital mail rerouted successfully"
Then Click on profile picture
And logout
Then navigate to given URL "http://www.yopmail.com/en/"
Then enter yopmail id as "mailuserauto@yopmail.com"
When click on check inbox
Then system should display "Digital Mail - Re-Route Notification" email

@Yes
Scenario: Validate Delete mail Action is working
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then select action as "Delete"
Then User should get success msg as "Action applied to selected mail items" 
Then click on Deleted Items folder
Then check whether same email is present in Deleted Items folder

@Yes
Scenario: Validate Physical delivery Action is working
Then Click on profile picture
When Click on Manage Address
Then filter the address "Office"
And delete it
When   Click on Add button
When click on drop down arrow "Address Type" 
When select drop down option as "Office" 
When Add Address Name as "S B ROAD Pune", Desk Number as "209" , Floor number as "9" ,mobileno. as "8099685985" ,city as "Pune" ,state as "Maharastra" ,country as "India" ,zip code as "411057"
When click on save button
Then User should successfully add Office address and get success msg as "Address saved successfully"
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then select action as "Manage Physical delivery"
Then click on Create button
Then User should get success msg as "Action applied to selected mail items"
Then Click on profile picture
When Click on Manage Address
Then filter the address "Office"
And delete it

@Yes
Scenario: Validate Completed Action is working
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then filter status email as "New"
Then select an email
Then select action as "Completed"
Then click on Yes Button
Then User should get success msg as "Action applied to selected mail items"
Then click on Completed folder
Then check whether same email is present in Completed folder

@praveen
Scenario: Open Report Scheduler
Then click on toggle menu  
Then click on left pane menu "Reports"
Then click on the report "Report Scheduler"
Then click on Add Scheduler button
Then filter the report name "Volume Report"
And delete it
Then select start date as tomorrow
#Then select Scheduler Type as "Daily"
When click on drop down arrow "Scheduler Type*" 
When   select drop down option as "Daily"
#Then select Scheduler Time as "1:00"
When click on drop down arrow "Scheduler Time*" 
When   select drop down option as "1:00"
#Then select Report Name as "Volume Report"
When click on drop down arrow "Report Name*" 
When   select drop down option as "Volume Report"
Then enter Select the person(s) to whom you want to send report as "testclient006@yopmail.com" and select it
When   click on save button
Then System should throw a toggle message as "Report scheduler updated successfully"
Then filter the report name "Volume Report"
And delete it

