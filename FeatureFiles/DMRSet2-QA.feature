Feature: DMR Regression Suite Set2
Background: User is Logged In
 	Given navigate to given URL "https://dmr-qa.exela.global/#/login"
	Then enter username as "septclient"
	Then click on next button
	Then enter Password as "Pa$$w0rd"
	And click on signin button

@Yes
Scenario: Verify functionality of Delegate Inbox for client admin
	Then Click on profile picture
	Then   Click on Myprofile 
	When   click on Settings
	When   on the toggle setting of "Delegate Inbox"
	When   select from date as today and to date is additional of two days of today
	When   enter email id as "varshadighe310891@yopmail.com" to whom you want to delegate the inbox 
	When   click on save button and get success msg as "Delegate user information saved successfully"
	Then Click on profile picture
    And logout
    Then navigate to yopmail URL "http://www.yopmail.com/en/"
	Then enter yopmail id as "VarshaDighe310891@yopmail.com"
	When click on check inbox
	Then system should display "Delegate Inbox Notification" email
@Yes
Scenario: Verify User is able to create routing rule on move to folder action
	Then Click on profile picture
	When click on Routing rule
	Then filter the rule name "TestRule1"
	And delete it
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "septClient_project"
	When   enter rule name as "TestRule1"
	When   click on trigger next button
	When   click on add button
	When click on drop down arrow "Field*" 
	When   select drop down option as "Batch Priority"
	When click on drop down arrow "Condition*" 
	When   select drop down option as "Equal"
	When    Enter value as "2"
	When   click on save button
	When   click on rule Next button
	When click on drop down arrow "Action*" 
	When   select drop down option as "Move To Folder"
	When   click on lookup
	When   select folder as "Not My Mail"
	Then click OK button
	When   click on save button
	Then User should get success msg as "Auto routing details added successfully"
	Then filter the rule name "TestRule1"
	And delete it
@Yes
Scenario: Verify User is able to create routing rule on Send To action
	Then Click on profile picture
	When click on Routing rule
	Then filter the rule name "TestRule12"
	And delete it
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "septClient_project"
	When   enter rule name as "TestRule12"
	When   click on trigger next button
	When   click on add button
	When click on drop down arrow "Field*" 
	When   select drop down option as "Batch Priority"
	When click on drop down arrow "Condition*" 
	When   select drop down option as "Equal"
	When    Enter value as "2"
	When   click on save button
	When   click on rule Next button
	When click on drop down arrow "Action*" 
	When   select drop down option as "Send To"
	When   click on lookup
	Then enter recepient as "varshadighe310891@yopmail.com" and select it
	When   click on Send
	When   click on save button
	Then User should get success msg as "Auto routing details added successfully"
	Then filter the rule name "TestRule12"
	And delete it
@Yes
Scenario: Verify User is able to create routing rule on Re-route action
	Then Click on profile picture
	When click on Routing rule
	Then filter the rule name "TestRule13"
	And delete it
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "septClient_project"
	When   enter rule name as "TestRule13"
	When   click on trigger next button
	When   click on add button
	When click on drop down arrow "Field*" 
	When   select drop down option as "Batch Priority"
	When click on drop down arrow "Condition*" 
	When   select drop down option as "Equal"
	When    Enter value as "2"
	When   click on save button
	When  click on rule Next button
	When click on drop down arrow "Action*" 
	When   select drop down option as "Re-Route"
    When   click on lookup
	Then enter re-route recepient as "varshadighe310891@yopmail.com" and select it
	When   click on Send
	When   click on save button
	Then User should get success msg as "Auto routing details added successfully"
	Then filter the rule name "TestRule13"
	And delete it
@Yes
Scenario: Verify User is able to create routing rule on Delete action
	Then Click on profile picture
	When click on Routing rule
	Then filter the rule name "TestRule14"
	And delete it
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "septClient_project"
	When   enter rule name as "TestRule14"
	When   click on trigger next button
	When   click on add button
	When click on drop down arrow "Field*" 
	When   select drop down option as "Batch Priority"
	When click on drop down arrow "Condition*" 
	When   select drop down option as "Equal"
	When    Enter value as "2"
	When   click on save button
	When   click on rule Next button
	When click on drop down arrow "Action*" 
	When   select drop down option as "Delete"
	
	When click on rule save
	Then User should get success msg  as "Auto routing details added successfully"
	Then filter the rule name "TestRule14"
	And delete it
@Yes
Scenario: Verify User is able to create routing rule on Assign label action
	Then Click on profile picture
	When click on Routing rule
	Then filter the rule name "TestRule15"
	And delete it
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "septClient_project"
	When   enter rule name as "TestRule15"
	When   click on trigger next button
	When   click on add button
	When click on drop down arrow "Field*" 
	When   select drop down option as "Batch Priority"
	When click on drop down arrow "Condition*" 
	When   select drop down option as "Equal"
	When    Enter value as "2"
	When   click on save button
	When   click on rule Next button
	When click on drop down arrow "Action*" 
	When   select drop down option as "Assign a Label"
	When click on drop down arrow "Select Label*"
	When   select drop down option as "label 1"
	When click on rule save
	Then User should get success msg as "Auto routing details added successfully"
	Then filter the rule name "TestRule15"
	And delete it
@Yes
Scenario: Verify User is able to create routing rule on Deliver Physicallly and Digitally action
	Then Click on profile picture
	When click on Routing rule
	Then filter the rule name "TestRule17"
	And delete it
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "septClient_project"
	When   enter rule name as "TestRule17"
	When   click on trigger next button
	When   click on add button
	When click on drop down arrow "Field*" 
	When   select drop down option as "Batch Priority"
	When click on drop down arrow "Condition*" 
	When   select drop down option as "Equal"
	When    Enter value as "2"
	When   click on save button
	When   click on rule Next button
	When click on drop down arrow "Action*" 
	When   select drop down option as "Deliver Physically & Digitally"
	When select delivery prference as "Hold for Pick-up"
	When click on create button
	When click on rule save
	Then User should get success msg as "Auto routing details added successfully"
	Then filter the rule name "TestRule17"
	And delete it
@Yes
Scenario: Verify User is able to create routing rule on mark as junk action
	Then Click on profile picture
	When click on Routing rule
	Then filter the rule name "TestRule16"
	And delete it
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "septClient_project"
	When   enter rule name as "TestRule16"
	When   click on trigger next button
	When   click on add button
	When click on drop down arrow "Field*" 
	When   select drop down option as "Batch Priority"
	When click on drop down arrow "Condition*" 
	When   select drop down option as "Equal"
	When    Enter value as "2"
	When   click on save button
	When   click on rule Next button
	When click on drop down arrow "Action*" 
	When   select drop down option as "Mark as Junk"
	When   click on save button
	Then User should get success msg as "Auto routing details added successfully"
	Then filter the rule name "TestRule16"
	And delete it
@Yes
Scenario: Verify User is able to add Office address in manage address
	Then Click on profile picture
	When    Click on Manage Address
	Then filter the address "Office"
	And delete it
	When    Click on Add button
	When click on drop down arrow "Address Type" 
	When   select drop down option as "Office" 
	When    Add Address Name as "S B ROAD Pune", Desk Number as "209" , Floor number as "9" ,mobileno. as "8099685985" ,city as "Pune" ,state as "Maharastra" ,country as "India" ,zip code as "411057"
	When   click on save button
	Then User should successfully add Office address and get success msg as "Address saved successfully"
	Then filter the address "Office"
	And delete it
@Yes
Scenario: Verify User is able to add Home address in manage address
	Then Click on profile picture
	When   Click on Manage Address
	Then filter the address "Home"
	And delete it
	When   Click on Add button
	When click on drop down arrow "Address Type" 
	When   select drop down option as "Home"
	When   add Address Name "Dhanori Pune" ,mobileno as "8055935935" ,city as "Pune" ,state as "Maharastra" ,country "India" ,zip code as "411057"
	When   click on save button
	Then User should successfully add Home address and get success msg as "Address saved successfully"
	Then filter the address "Home"
	And delete it

@Yes
Scenario: Verify User is able to add Custom  address in manage address
	Then Click on profile picture
	When   Click on Manage Address
	Then filter the address "Custom"
	And delete it
	When   Click on Add button
	When click on drop down arrow "Address Type" 
	When   select drop down option as "Custom"
	When enter address name as "testing"
	When   add Address Name "Dhanori Pune" ,mobileno as "8055935935" ,city as "Pune" ,state as "Maharastra" ,country "India" ,zip code as "411057"
	When   click on save button
	Then User should successfully add Custom address and get success msg as "Address saved successfully"
	Then filter the address "Custom"
	And delete it
@Yes
Scenario:  Verify Client admin is able to create routing rule via NQube-routing rule
	Then click on toggle menu
	Then click on left pane menu "nQube"
	When click on "Routing Rule" nQube options
	Then filter the rule name "TestRule16"
	And delete it
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "septClient_project"
	When   enter rule name as "TestRule16"
	When click on drop down arrow "invocationTrigger value" 
	When   select drop down option as "On Ingestion"
	When   click on trigger next button
	When   click on add button
	When click on drop down arrow "Field*" 
	When   select drop down option as "Batch Priority"
	When click on drop down arrow "Condition*" 
	When   select drop down option as "Equal"
	When    Enter value as "2"
	When   click on save button
	When   click on rule Next button
	When click on drop down arrow "Action*" 
	When   select drop down option as "Deliver To"
	Then enter re-route recepient as "varshadighe3108@yopmail.com" and select it
	When   click on save button
	Then User should get success msg as "Auto routing details added successfully"
	Then filter the rule name "TestRule16"
	And delete it

@Yes
Scenario:  Verify changes done in client setup- assign templates should be reflected in ReachOut-Mail template option
	Then click on toggle menu
	Then click on left pane menu "Client Setup"
	When    click edit button
	When   click Assign template
	When    select one template checkbox as "Not My mail"
	When   click on assign button
	Then User should get success msg as "Template assignment updated successfully"
	Then click on left pane menu "ReachOut"
	When    click Mail Tempalte
	When    User should see selected templates as "Not My Mail"
	When    edit content subject as "Edited Digital Mail - Re-Route Notification"
	When   click on save button
	Then User should get success msg as "Action Template updated successfully"
@Yes
Scenario: Verify client admin is able to add the pulse set up
	Then click on toggle menu
	Then click on left pane menu "Pulse Setup"
	Then filter the graph name "TestGraph"
	And delete it	
	When   click on Add new
	When   enter Graph name as "TestGraph"
	When click on drop down arrow "Service Name*" 
	When   select drop down option as "Volume by Location/Site"
	 When click on drop down arrow "Graph Type*" 
	When   select drop down option as "Donut Chart"
	When click on drop down arrow "Animation Name*" 
	When   select drop down option as "easeInQuad"
	When   click on pulse setup add
	Then   client admin should  get success msg as "Added successfully!"
	Then filter the graph name "TestGraph"
	And delete it
@Yes
Scenario: Verify client admin is able to add roles and newly created roles should see assinged menus after login.
	Then click on toggle menu
	Then click on left pane menu "Role Setup"
	Then filter the role name "TestRole"
	And delete it
	When   click on add role button
	When   Enter Rolename as "TestRole" 
	When click on drop down arrow "Role Type*" 
	When   select drop down option as "Mail User"
	When click on drop down arrow "Product*" 
	When   select drop down option as "DMR"
	When   click on save button 
	Then User should get success msg as "Role has been added successfully"
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
	When    check the project queue as "Default"
	When   click on assign
    Then User should get success msg as "Project queue access updated Successfully"
    When click on edit role headers "Role-Shared-Mailbox Assignment"
	When   Check the shared mail box as "Testing shared mailbox" from role shared mailbox assignment tab.
	Then click on left pane menu "User Setup"
	Then filter login name "varsha001"
	When   click on edit.
	When click on drop down arrow "Assign Roles*" 
	When   select drop down option as "TestRole"
	When   click on SAVE button
	Then Click on profile picture
	And logout
	Then refresh the page
	Given navigate to given URL "https://dmr-qa.exela.global/#/login"
	Then enter username as "varsha001"
	Then click on next button
	Then enter Password as "Pa$$w0rd"
	And click on signin button
	Then click on toggle menu
	Then left pane should consists of "Dashboard,Inbox"
	Then Click on profile picture
	And logout
	Given navigate to given URL "https://dmr-qa.exela.global/#/login"
	Then enter username as "septclient"
	Then click on next button
	Then enter Password as "Pa$$w0rd"
	And click on signin button
	Then click on toggle menu
	Then click on left pane menu "Role Setup"
	Then filter the role name "TestRole"
	And delete it
	

@Yes
Scenario: Verify Client admin is able to Assign the actions and that assigned actions only to be seen in the Actions drop down of user
	Then click on toggle menu
	Then click on left pane menu "Client Setup" 
	When    click on edit When   
	When   click on assign action tab
	When click on drop down arrow "Select Product*" 
	When   select drop down option as "DMR"
	When   select the action as "Completed, Delete, Junk Mail, Manage Label, Manage Physical delivery, Move To Folder, Not My Mail, Re-Route, Select Action, Send For Drysign, Send To"
	When   click on assign
    Then User should get success msg "Action assignment updated successfully"
	Then Click on profile picture
	Then Click on SwitchTo option
  Then Switch to "Mail Admin(Mail User)"
  Then click OK button
	When   click on actions dropdown
	Then User should see selected action present the actions dropdown as "Completed, Delete, Junk Mail, Manage Label, Manage Physical delivery, Move To Folder, Not My Mail, Re-Route, Select Action, Send For DrySign, Send To"
	
	@Yes
Scenario: Verify functionality of toggle of New Mail notification
	
	Then Click on profile picture
	When    click on My Profile
	When   click on Settings
	When   Off the toggle of "New Mail Notification Active" New Mail Notification option
	Then navigate to given URL "http://www.yopmail.com/en/"
	Then enter yopmail id as "VarshaDighe3108@yopmail.com"
	When click on check inbox
	Then Check the "New Mail Notification" value is "false"
	
@Yes
Scenario: Verify functionality of toggle of Not My Mail notification
	Then Click on profile picture
	When   click on My Profile
	When   click on Settings
	When   Off the toggle of "Not My Mail Notification Active" Not My Mail Notification option
	Then navigate to given URL "http://www.yopmail.com/en/"
	Then enter yopmail id as "VarshaDighe3108@yopmail.com"
	When click on check inbox
	Then Check the "Not My Mail Notification" value is "false"
	
@Yes
Scenario: Verify functionality of toggle of Re-route notification
 	Then Click on profile picture
	When   click on My Profile
	When   click on Settings
	When   Off the toggle of "Re-route Notification Active" Re-route Notification option
	Then navigate to given URL "http://www.yopmail.com/en/"
	Then enter yopmail id as "VarshaDighe3108@yopmail.com"
	When click on check inbox
	Then Check the "Reroute Notification" value is "false"
	
@Yes
Scenario: Verify functionality of Out of office for client admin
	Then Click on profile picture
	When   click on My Profile
	When   click on Settings
	When   on the toggle of "Re-route Notification Deactive" option
	When   select From date as today and to date is additional of two days of today
 	When   click on save button
	Then System should throw a toggle message as "Out of office settings saved successfully."
	Then Click on profile picture
	And logout
	
@Yes
Scenario: Verify client admin is able to Delegate Other User's Inbox 
	Then Click on profile picture
	Then  Click on Myprofile 
	When  click on Settings
	When   on the toggle setting of "Delegate Inbox"
	When   Checked the delegate other user inbox checkbox
	When   Enter the User one's mail id as "mailuserauto@yopmail.com" whose inbox you want to delegate 
	When   select from date as today and to date is additional of two days of today
	When   enter email id as "mailadminauto@yopmail.com" of User two you want to delegate the inbox 
	When   click on save button
	Then navigate to given URL "http://www.yopmail.com/en/"
	Then enter yopmail id as "mailadminauto@yopmail.com"
	When click on check inbox
	Then User two mailadminauto@yopmail.com  whom we delegate the inbox should be copied in emails of User one mailuserauto@yopmail.com.
	
@Yes
Scenario: Check whether the fields like sender company,Department,Keyword,scanning location  are available while creating rule condition in routing rule.
Then Click on profile picture
	When click on Routing rule
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "septClient_project"
	When   enter rule name as "TestRule1"
	When   click on trigger next button
	When   click on add button
	When click on drop down arrow "Field*" 
	Then system should display following field list "Document Type,Batch Class,Batch Priority,Sender Name,Recipient Name,Sender Email,Courier Name,Sender Company,Department,Keyword,Location/Site,Scanning Location,Recipient City,Recipient State,Recipient Email"
@Yes
Scenario: Check whether the user is able to see the new filters added on doing advanced search in volume report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Volume Report"
When click on advanced search
Then system should display following text box filter options
|TextBox|
|Sender Name|
|Sender Company|
|Recipient|
And system should display following dropdown filter options
|DropDownOptions|
|Document Type|
|Location/Site|
|Project|
Then Click on profile picture
And logout
@Yes
Scenario: Check whether the  volume report is displayed  when clicked on total count
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Volume Report"
Then select from date as "09/01/2020"
Then click on total count
Then the count should match between total count and detailed report count
Then system should display the tabel headers as "SCAN DATE,INGESTION DATE,RECIPIENT,SENDER NAME,SENDER COMPANY,STATUS,CURRENT USER,SOURCE,PAGE COUNT,IMAGE COUNT,BATCH CLASS,LOCATION/SITE,DOC TYPE,SCANNING LOCATION,DCN"
Then Click on profile picture
And logout
@Yes
Scenario: Check whether the volume report is displayed when clicked on return to Volume report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Volume Report"
Then select from date as "09/01/2020"
Then click on total count
Then system should display the tabel headers as "SCAN DATE,INGESTION DATE,RECIPIENT,SENDER NAME,SENDER COMPANY,STATUS,CURRENT USER,SOURCE,PAGE COUNT,IMAGE COUNT,BATCH CLASS,LOCATION/SITE,DOC TYPE,SCANNING LOCATION,DCN"
Then the count should match between total count and detailed report count
Then click on return to Volume report
Then system should display the tabel headers as "SCAN DATE,VOLUME,OPENED,UNOPENED"
Then Click on profile picture
And logout
@Yes
Scenario: Check whether the volume report is displayed when user clicks on opned or unopened mail
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Volume Report"
Then select from date as "09/01/2020"
Then filter scan date "09-14-2020"
Then click on the "OPENED" link count
Then system should display the tabel headers as "SCAN DATE,INGESTION DATE,RECIPIENT,SENDER NAME,SENDER COMPANY,STATUS,CURRENT USER,SOURCE,PAGE COUNT,IMAGE COUNT,BATCH CLASS,LOCATION/SITE,DOC TYPE,SCANNING LOCATION,DCN"
Then the count should match between opened link count and detailed report count
Then Click on profile picture
And logout
@Yespraveen
Scenario: Check whether the user is able to see the new filters added in Volume Report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Volume Report"
When click on advanced search
Then select from date as "09/01/2020"
When click on drop down arrow "Source" 
When  select drop down option as "SCAN"
Then click on search button
Then filter scan date "09-14-2020"
Then the number of Volume records should be "79"
Then Click on profile picture
And logout
@Yes
Scenario: Check whether the user is able to see the new filters added when clicked on download report 
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Volume Report"
When click on advanced search
Then select from date as "09/01/2020"
When click on drop down arrow "Source" 
When  select drop down option as "SCAN"
Then click on search button
Then click on download icon
Then Click on profile picture
And logout
@Yes
Scenario: Check whether the user is able to see the new filters added on doing advanced search in Action Summary Report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Action Summary Report"
When click on advanced search
Then system should display following text box filter options
|TextBox|
|Search User|
And system should display following dropdown filter options
|DropDownOptions|
|Source|
|Action|
|Location/Site|
|Project|
Then Click on profile picture
And logout
@Yes
Scenario: Check whether the  Action Summary report is displayed  when clicked on total count
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Action Summary Report"
Then select from date as "04/01/2020"
Then click on total count
Then the count should match between total count and detailed report count
Then system should display the tabel headers as "ACTION, ACTION DATE, BATCH CLASS, BOX NUMBER, DCN, DELIVERY INSTRUCTIONS, DELIVERY PRIORITY, DOC TYPE, IMAGE COUNT, INGESTION DATE, LOCATION/SITE, PAGE COUNT, RECIPIENT, SCANNING LOCATION, SENDER, SENDER COMPANY, SOURCE, STATUS, USER"
Then Click on profile picture
And logout
@Yes
Scenario: Check whether the user is able to see the action summary report with action name and total count
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Action Summary Report"
Then select from date as "01/01/2021"
Then select to date as "02/22/2021"
Then total count should be "209"
Then Click on profile picture
And logout
@Yes
Scenario: Check whether the user is able to see action summary report with selected action name
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Action Summary Report"
Then select from date as "01/01/2021"
Then select to date as "02/22/2021"
When click on advanced search
When click on drop down arrow "Action" 
When select drop down option as "All"
When select drop down option as "Completed"
Then total count should be "17"
Then Click on profile picture
And logout

@Yes
Scenario: To verify whether the user can add the retention period for a specific Client
Then click on toggle menu
Then click on left pane menu "Client Setup"
When   click on edit.
Then enter max retention period in days as "15"
Then enter retention period in days for deleted iteams as "15"
When   click on save button
Then System should throw a toggle message as "Client has been updated successfully"
Then Click on profile picture
And logout

@Yes
Scenario: To check whether error toaster appears when user select To date more than 31 days
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Volume Report"
When select from date as "01/01/2021" and to date as "02/15/2021"
Then System should throw a toggle message as "Date Range cannot be more than 31 days period"
Then Click on profile picture
And logout

@Yes
Scenario: To check whether error toaster appears when user select To date more than 31 days
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Reconciliation Report"
When select from date as "01/01/2021" and to date as "02/15/2021"
Then System should throw a toggle message as "Date Range cannot be more than 31 days period"
Then Click on profile picture

@Yes
Scenario: To check whether user is able to see appropriate records when clicks on the total count on recon report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Reconciliation Report"
Then click on total count
Then the count should match between total count and detailed report count
Then system should display the tabel headers as "BATCH CLASS, CLIENT CODE, COMMENT, DCN, DMR INGESTION TIME, DOC TYPE, FILE NAME, IMAGE COUNT, LOCATION/SITE, MAIL SORTER UID, PAGE COUNT, PROJECT CODE, RECEIVED DATE/TIME, SCAN DATE/TIME, SCANNING LOCATION, SORTER DATE/TIME, SOURCE, STATUS, TAT (HOURS), UNIQUE BARCODE"
Then Click on profile picture
And logout
@Yes
Scenario: To check that user should be able to go back only up to 6 months from current month to check and generate Recon Report 
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Reconciliation Report"
Then select from date as six months back from today
Then System should throw a toggle message as "You can only go back upto 6 months"
Then Click on profile picture
And logout
@Yes
Scenario: To check Download Recon Report Functionality when user clicks on Download button on Recon Report  and Recon Report Details Page.
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Reconciliation Report"
Then click on download icon
Then Click on profile picture
And logout

@Yes
Scenario: To check whether the Envelope view screen should have a button on the File Tab section named Open Full Mail
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then open full mail option should be avaliable in envelope mail
Then Click on profile picture
And logout
@Yes
Scenario: To check whether When I click on this button it should open the full mail like when I double click to open the mail
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then double click to open the email
Then Click on profile picture
And logout

@Yes
Scenario: To check whether user is able to click on nQube and see routing rule
Then click on toggle menu
Then click on left pane menu "nQube"
Then system should display sub menu option "Routing Rule"
Then Click on profile picture
And logout
@Yes
Scenario: To check whether user is able to click on routing rule and see the Invocation trigger, Rule condition and Rule execution
Then Click on profile picture
When click on Routing rule
When   click on add button
Then system should display routing rule options "Invocation Trigger,Rule Condition,Rule Execution"
Then Click on profile picture
And logout
@Yes
Scenario: To check whether user is able to add rule condition by selecting data for Field , Condition and  Value from dropdown
Then Click on profile picture
	When click on Routing rule
	Then filter the rule name "TestRule17"
	And delete it
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "septClient_project"
	When   enter rule name as "TestRule17"
	When   click on trigger next button
	When   click on add button
	When click on drop down arrow "Field*" 
	When   select drop down option as "Batch Priority"
	When click on drop down arrow "Condition*" 
	When   select drop down option as "Equal"
	When    Enter value as "2"
	When   click on save button
	When   click on rule Next button
	When click on drop down arrow "Action*" 
	When   select drop down option as "Deliver Physically & Digitally"
	When select delivery prference as "Hold for Pick-up"
	When click on create button
	When click on rule save
	Then User should get success msg as "Auto routing details added successfully"
	Then filter the rule name "TestRule17"
	And delete it
@Yes
Scenario: To check whether field dropdown must comprise of additional dropdown items along with current dropdown items :Recipient City and Recipient state, Recipient Email.
Then Click on profile picture
	When click on Routing rule
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "septClient_project"
	When   enter rule name as "TestRule17"
	When   click on trigger next button
	When   click on add button
	When click on drop down arrow "Field*"
	Then system should display field options as "Document Type,Batch Class,Batch Priority,Sender Name,Recipient Name,Sender Email,Courier Name,Sender Company,Department,Keyword ,Location/Site,Scanning Location,Recipient City,Recipient State,Recipient Email"
@Yes
Scenario: To check whether user is able to see To dropdown on the screen in Action summary report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Action Summary Report"
Then system should display from date and to date
Then Click on profile picture
And logout
@Yes
Scenario: To check whether when clicked on To, calendar should appear with current and past dates not with future dates in Action summary report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Action Summary Report"
Then system should allow to select with current date
Then system should allow to select three days back from today
Then system should not allow to select two days future from today
Then Click on profile picture
And logout
@Yes
Scenario: To check whether user see a new report in the Reports Menu named Audit Log Report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Audit Log Report"
Then "Audit logs Report" should be displayed
Then Click on profile picture
And logout
@Yes
Scenario: To check whether user is able to see the dropdown option for client by default in Audit Log Report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Audit Log Report"
When click on drop down arrow "Client" 
When   select drop down option as "septClient"
Then Click on profile picture
And logout
@Yes
Scenario: To check whether user is able to see the data when from and to date is selected in Audit Log Report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Audit Log Report"
Then select from date as "12/01/2020"
Then Click on profile picture
And logout

@Yes
Scenario: To check whether user can see 7 days data by default when clicked on volume report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Volume Report"
Then report should display "7" days data by default
Then Click on profile picture
And logout
@Yes
Scenario: To check whether user can select data of only 1 month or 31 days period
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Volume Report"
Then select from date as today
Then report should display "31" days data
Then Click on profile picture
And logout
@Yes
Scenario: To check whether To Date field is auto populated
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Volume Report"
Then select from date as today
Then report should display "31" days data
Then Click on profile picture
And logout
@Yes
Scenario: To check whether user can see 7 days data by default when clicked on Recon report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Reconciliation Report"
Then report should display "7" days data by default
Then Click on profile picture
And logout
@Yes
Scenario: To check whether user is able to see from date and to date getting displayed for 7 days by default in Action summary report 
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Action Summary Report"
Then report should display "7" days data by default
Then Click on profile picture
And logout
@Yespraveen
Scenario: The Chain of custody report must show all the details which are visible on report page when I download the report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Chain of Custody Report"
Then click on download icon
Then report should display the coulmns "DATE, DCN, DELIVERY INSTRUCTIONS, DELIVERY PRIORITY, DOC TYPE, EVENT, FIELD, FROM, QUEUE, RECIPIENT, SOURCE, TO, USER"
Then Click on profile picture
And logout
@Yes
Scenario: To check whether user is able see Active user report in the dropdown
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Active User Report"
Then "Active User Report" should be displayed
Then Click on profile picture
And logout
@Yes
Scenario: To check whether user is able to see  filter options for Client name, From and To Date , Project and Location/Site as filter options in Active User Report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Active User Report"
Then system should display from date and to date
Then system should display client dropdown option
Then Click on profile picture
And logout
@Yes
Scenario: To check whether user is able to see blank by default and When I select a From date the To date should be selected to current date by default in Active User Report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Active User Report"
Then system should display blank data "No data available"
Then Click on profile picture
And logout
@Yes
Scenario: To check whether user should be able to change the To date to any date till today's date in Active User Report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Active User Report"
Then system should allow to select three days back from today
Then Click on profile picture
And logout
@Yes
Scenario: To check whether fields should display Date,  no. of unique User's logged in to the DMR system, Project and Location/Site .
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Active User Report"
Then system should display the tabel headers as "DATE/TIME, NO. OF UNIQUE USERS"
Then Click on profile picture
And logout
@Yes
Scenario: To check whether all the fields are displayed under the report in Audit Log Report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Audit Log Report"
Then system should display the tabel headers as "ACTION, CHANGE, DATE, IP ADDRESS, MODULE, USER NAME"
Then Click on profile picture
And logout
@Yes
Scenario: To check whether user is able to download the report in Audit Log Report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Audit Log Report"
Then click on download icon
Then Click on profile picture
And logout
@Yes
Scenario: To check that popup is showing on page when user preferences selection is over using Customize drop down
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
When click on drop down arrow "Customize" 
When   select drop down option as "LABEL"
Then click on save preference
Then system should display the custom message "Do you want to save this preference for next login?"
Then click on NO button
Then Click on profile picture
And logout
@Yes
Scenario: To check whether preferences are saved when 'Yes' button is clicked which is in popup which is showing on page when user preferences selection is over using Customize drop down
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
When click on drop down arrow "Customize" 
When   select drop down option as "LABEL"
Then click on save preference
Then system should display the custom message "Do you want to save this preference for next login?"
Then click on YES button
Then system should display the tabel headers as "DCN,STATUS,TIME STAMP,SENDER,LABEL"
When click on drop down arrow "Customize" 
Then deselect the dropdown "LABEL"
Then click on save preference
Then click on YES button
Then Click on profile picture
And logout
@Yes
Scenario: To check preferences are saved when 'No' button is clicked which is in popup which is showing on page when user preferences selection is over using Customize drop down
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
When click on drop down arrow "Customize" 
When   select drop down option as "LABEL"
Then click on save preference
Then system should display the custom message "Do you want to save this preference for next login?"
Then click on NO button
Then system should display the tabel headers as "DCN,STATUS,TIME STAMP,SENDER,LABEL"
Then Click on profile picture
And logout
@Yes
Scenario: To check columns showing on page once browser refresh/ page refresh activity happened after saving the preferences for particular user
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
When click on drop down arrow "Customize" 
When   select drop down option as "LABEL"
Then click on save preference
Then system should display the custom message "Do you want to save this preference for next login?"
Then click on YES button
Then system should display the tabel headers as "DCN,STATUS,TIME STAMP,SENDER,LABEL"
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "CLIENTADMIN"
Then click OK button
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then system should display the tabel headers as "DCN,STATUS,TIME STAMP,SENDER,LABEL"
When click on drop down arrow "Customize" 
Then deselect the dropdown "LABEL"
Then click on save preference
Then click on YES button
Then Click on profile picture
And logout
@Yes
Scenario: To check whether user is able to see search option for quick search in Audit Log Report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Audit Log Report"
Then search user "septClient sept2020"
And select the user "septClient sept2020"
Then verify system displays "septClient sept2020" records in the table
Then Click on profile picture
And logout


@Yes
Scenario: Verify client admin is able to add role and Edit role functionality for Client Admin
	Then click on toggle menu
	Then click on left pane menu "Role Setup"
	Then filter the role name "TestRole"
	And delete it
	When   click on add role button
	When   Enter Rolename as "TestRole" 
	
	When click on drop down arrow "Role Type*" 
	When   select drop down option as "Mail User"
	When click on drop down arrow "Product*" 
	When   select drop down option as "DMR"
	When   click on save button 
	Then filter the role name "TestRole"
	When   click on edit.
	When click on edit role headers "Role-Menu Assignment"
	When    check the checkbox of menus from  Role menu assignment tab as "Dashboard (dmr-dashboard)" and "Inbox (mail-user-inbox)"
	When   Click on assign button
    	Then User should get success msg as "Menus has been added Successfully"
    	When click on edit role headers "Role-Project Assignment"
   	 #When click on "Role-Project Assignment" role option
   	When click on drop down arrow "Select Project*" 
	When   select drop down option as "septClient_project"
	When    check the project queue as "Default"
	When   click on assign
    	Then User should get success msg as "Project queue access updated Successfully"
    	When click on edit role headers "Role-Shared-Mailbox Assignment"
	When   Check the shared mail box as "Testing shared mailbox" from role shared mailbox assignment tab.
	Then User should get success msg as "Shared Mailbox assigned to role"
	
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
Scenario: Add doctype name with blank
Then click on toggle menu
	Then click on left pane menu "Project Setup"
	Then filter the project name "septClient_project"
When click on edit.
Then click on doctype setup
Then click on adddoc type
When click on ADD button
Then User should get error msg as "DocType Name is required"

@Yes
Scenario: Add doctype name with Alphanumeric value
Then click on toggle menu
	Then click on left pane menu "Project Setup"
	Then filter the project name "septClient_project"
When click on edit.
Then click on doctype setup
	Then filter the name "A123"
	And delete it
Then click on adddoc type
When Enter value "A123"
When click on ADD button
Then User should get success msg as "DocType added successfully !"
Then filter the name "A123"
	And delete it


@Yes
Scenario: Add doctype description with blank
Then click on toggle menu
Then click on left pane menu "Project Setup"
Then filter the project name "septClient_project"
When click on edit.
Then click on doctype setup
Then filter the name "Doc1"
And delete it
Then click on adddoc type
When Enter on Add DocType as "Doc1"
When click on ADD button
Then User should get success msg as "DocType added successfully !"
Then filter the name "Doc1"
And delete it

@Yes
Scenario: Add doctype description with Alphanumeric value
Then click on toggle menu
Then click on left pane menu "Project Setup"
Then filter the project name "septClient_project"
When click on edit.
Then click on doctype setup
Then filter the name "Doc1"
And delete it
Then click on adddoc type
When Enter on Add DocType as "Doc1"
When Enter DocType Description as "DocDesc123"
When click on ADD button
Then User should get success msg as "DocType added successfully !"
Then filter the name "Doc1"
And delete it

@Yes
Scenario: Add blank value in retention period

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
When Enter Retention period " "
When click on ADD button
Then User should get error msg as "Input maximum 4 digit number."

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
	
@Yespraveen
Scenario: To check that only 10 records are displayed by default and can change to 25, 50 or 100
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Reconciliation Report"
Then filter the received date as "09/14/2020"
Then click on volume received count
Then by default system should display "10" records as selected
Then system should display the record options as "10,25,50,100"
Then user selects "25" as option then system should display "25" records
Then user selects "50" as option then system should display "50" records
Then user selects "100" as option then system should display "100" records
Then user clicks on Next/Right arrow key then system should display next "101 - 200" records
Then click on download icon
Then Click on profile picture
And logout
@Yes
Scenario: To check that report drill down logic changes when user opens report with data more than 100
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Reconciliation Report"
Then filter the received date as "09/14/2020"
Then click on volume received count
Then user selects "100" as option then system should display "100" records
Then user clicks on Next/Right arrow key then system should display next "101 - 200" records
Then Click on profile picture
And logout

@Yes
Scenario: To check all user with Mail User role can see All Projects as a dropdown option.

	Then Click on profile picture
	Then Click on SwitchTo option
	Then Switch to "Mail Admin(Mail User)"
  	Then click OK button	
  	Then click on left pane menu "Inbox"
  	And "Select Project" dropdown should be present
	Then Click on profile picture
    And logout

@Yes
Scenario: To check all user with Mail User role can see projects only that are assigned to him in the select Project dropdown option

	
	Then Click on profile picture
	Then Click on SwitchTo option
	Then Switch to "Mail Admin(Mail User)"
  	Then click OK button	
  	Then click on left pane menu "Inbox"
  	And "Select Project" dropdown should be present
  	When click on drop down arrow "Select Project"
  	When   select drop down option as "septClient_project"
  	Then Click on profile picture
    And logout

@Yes
Scenario: To check all user with Mail User role can see mails to that specific project which is selected in the dropdown

	
	Then Click on profile picture
	Then Click on SwitchTo option
	Then Switch to "Mail Admin(Mail User)"
  	Then click OK button	
  	Then click on left pane menu "Inbox"
  	And "Select Project" dropdown should be present
  	When click on drop down arrow "Select Project"
  	When   select drop down option as "septClient_project"
  	Then Click on profile picture
    And logout


@Yes
Scenario: To verify client admin can provide access to each report separately in DMR for a role

	Then click on toggle menu
	Then click on left pane menu "Role Setup"
	Then filter the role name "TestRole"
	When   click on edit.
	Then it should display the headers as " Information , Role-Menu Assignment , Role-Project Assignment , Role-Shared-Mailbox Assignment , Role-Metadata Access "
	When click on edit role headers "Role-Menu Assignment"
	And click "Reports (no-link)" mainmenu arrow
	And it should show the sub menus as: "Action Summary Report (reports/action-summary-report), Active User Report (reports/active-user-report), Audit Log Report (reports/audit-logs-report), Audit Report (reports/audit-report), Blocked Senders Report (reports/blocked-senders-report), Chain of Custody Report (reports/chain-of-custody-report), Inventory Report (reports/inventory-report), Reconciliation Report (reports/reconciliation-report), Report Scheduler (reports/report-scheduler), Retention Aging Report (reports/retention-aging-report), Volume By Source Report (reports/volume-by-source-report), Volume Report (reports/volume-report)"
 	When check the checkbox of menus from  Role menu assignment tab as "Reports (no-link)"
	When Click on assign button
    Then User should get Success msg as "Menus has been added Successfully"
	Then Click on profile picture
    And logout

@Yes
Scenario: To verify client admin can see the Dashboard items with displaying  Total Mail count, Total Processed Images, Total Processed Pages, Total Users in top grid

	Then click on toggle menu
	Then click on left pane menu "Dashboard"
	And Dashboard items should be displaying "Total Mail,Total Processed Images,Total Processed Pages,Total Users"
	And "Total Users" count should be the active user count that should be fetched from active user report "8"
	Then "Select Department" dropdown should be added in dashboard
	And In select engagement if there is only one engagement then it should get displayed by default as "Select Engagement"
	Then By default dashboard should display "Last 90 Days" data
	Then Click on profile picture
    And logout


@Yes
Scenario: Verify that as a Client Admin user can search DCN Number from entire inventory in Chain of Custody report

	Then click on toggle menu
	Then click on left pane menu "Reports"
	And It should display the following Reports: "Volume Report,Action Summary Report,Chain of Custody Report,Reconciliation Report,Retention Aging Report,Blocked Senders Report,Inventory Report,Volume By Source Report,Audit Report,Report Scheduler,Audit Log Report,Active User Report"
	Then click on the report "Chain of Custody Report"
	And "Chain of Custody Report" should gets displayed with data
	Then report should display "7" days data by default
	When select from date as "01/01/2021" and to date as "02/15/2021"
	Then System should throw a toggle message as "Date Range cannot be more than 31 days period"
	When click on advanced search
	Then enter DCN as "20210128112111T"
	Then It should check the entire inventory of the customer to search for this DCN record "20210128112111T"
	Then Click on profile picture
    And logout
	

@Yes
Scenario: To verify Chain of custody report for selected range of clients mail

	Then click on toggle menu
	Then click on left pane menu "Reports"
	And It should display the following Reports: "Volume Report,Action Summary Report,Chain of Custody Report,Reconciliation Report,Retention Aging Report,Blocked Senders Report,Inventory Report,Volume By Source Report,Audit Report,Report Scheduler,Audit Log Report,Active User Report"
	Then click on the report "Chain of Custody Report"
	And "Chain of Custody Report" should gets displayed with data
	Then report should display "7" days data by default
	When select from date as "01/01/2021" and to date as "02/15/2021"
	Then System should throw a toggle message as "Date Range cannot be more than 31 days period"
	And Verify server side pagination and records
	Then select No of pages as "100"
	And Verify page displayed per "100" pages
	Then click on download icon
	Then Click on profile picture
    And logout


@Yes
Scenario: To verify Inventory report for selected range of clients mail

	Then click on toggle menu
	Then click on left pane menu "Reports"
	Then click on the report "Inventory Report"
	And "Inventory Report" should gets displayed with data
	Then report should display "7" days data by default
	When select from date as "01/01/2021" and to date as "02/15/2021"
	Then System should throw a toggle message as "Date Range cannot be more than 31 days period"
	And Verify server side pagination and records
	Then select No of pages as "100"
	Then click on download icon
	Then Click on profile picture
    And logout


@Yes
Scenario: To check whether the report drill down logic changes when user opens report with data more than 100 records
	
	Then click on toggle menu
	Then click on left pane menu "Reports"
	Then click on the report "Volume Report"
	And "Volume Report" should gets displayed with data
	And Verify server side pagination and records
	Then select No of pages as "100"
	Then Click on profile picture
    And logout


@Yes
Scenario: To check whether Total should show the Total Unique user's for the selected date range
	
	Then click on toggle menu
	Then click on left pane menu "Reports"
	Then click on the report "Active User Report"
	When select from date as "01/01/2020"
	Then Click on the total count 
	Then User should be able to see Total count as Total Unique users for the selected date range
	Then Click on profile picture
    And logout


@Yes
Scenario: To check whether detailed report displays  information about Date, First name, Last name, Email address, Project and Location/site, department. Project would be based on the Role and Location/site from his Profile
	
	Then click on toggle menu
	Then click on left pane menu "Reports"
	Then click on the report "Active User Report"
	When select from date as "01/01/2020"
	Then Click on the total count 
	And User should be able to see detailed report displays " DATE/TIME, FIRST NAME, LAST NAME, EMAIL ADDRESS"
	Then Click on profile picture
    And logout

@Yespraveen
Scenario: To check whether when user logs in every day for the month his entry for the grand total will be only 1 count and not 30 counts

	Then click on toggle menu
	Then click on left pane menu "Reports"
	Then click on the report "Active User Report"
	When select from date as "02/01/2021"
	Then enter date in filter as "02-21-2021"
	And Verify page displayed per "1" pages
	Then Click on profile picture
    And logout


@Yes
Scenario: To check whether user is able to see the changes made in Email Recepients, Email Recepient Group, Assign Action, Shared Mailbox in Edit client section is displayed in the Audit Log Report
	Then click on toggle menu
	Then click on left pane menu "Client Setup" 
	When  click on edit.
	Then click on tab " Email Recipients "
	Then enter the firstname in filter as "Testing"
	And delete it
	Then click Add Recipients
	And click option as "Manual Add"
	Then enter the firstname as "Testing" and lastname as "testing123" and email as "testing@mail.com"
	Then click the add button
	Then click on left pane menu "Reports"
	Then click on the report "Audit Log Report"
	Then enter the username in filter as "septClient sept2020"
	Then filter the date with current date
	Then Table header Ascending for " Date"
	Then enter the module in filter as "email"
	And verify the module is updated in table "Email Recipient"
	Then Click on profile picture
    And logout



@Yes
Scenario: To check whether user is able to see the changes made in Update mail template functionality is displayed in Audit Log Report
	
	Then click on toggle menu
	Then click on left pane menu "ReachOut"
	Then click on the Reachout "Mail Template"
	Then enter action name as "Not My Mail"
	When  click on edit.
	When    edit content subject as "Testing"
	When   click on save button
	Then enter action name as "Not My Mail"
	When  click on edit.
	When    edit content subject as "Edited Digital Mail - Re-Route Notification"
	When   click on save button
	Then click on left pane menu "Reports"
	Then click on the report "Audit Log Report"
	Then enter the username in filter as "septClient sept2020"
	Then enter the module in filter as "Add Update Template"
	Then filter the date with current date
	And verify the module is updated in table "Add Update Template"
	Then Click on profile picture
    And logout

@Yes
Scenario: To check whether user is able to see the changes made in Report Scheduler is displayed in Audit Log Report

	Then click on toggle menu
	Then click on left pane menu "Reports"
	Then click on the report "Report Scheduler"
	Then enter the recipientname in filter as "Test test123"
	When  click on edit.
	When click on drop down arrow "Scheduler Type*"
	When   select drop down option as " Weekly "
	When   click on save button
	Then click on the report "Audit Log Report"
	Then enter the username in filter as "septClient sept2020"
	Then enter the module in filter as "Report"
	Then filter the date with current date
	Then Table header Ascending for " Date"
	And verify the module is updated in table "Report Scheduler"
	Then Click on profile picture
    And logout
	
	

@Yes
Scenario: To check whether user is able to see the changes made in other tabs in Audit Log Report


 	Then click on toggle menu
	Then click on left pane menu "Pulse Setup"
	Then filter the graph name "TestGraph"
	And delete it	
	When   click on Add new
	When   enter Graph name as "TestGraph"
	When click on drop down arrow "Service Name*" 
	When   select drop down option as "Volume by Location/Site"
	 When click on drop down arrow "Graph Type*" 
	When   select drop down option as "Donut Chart"
	When click on drop down arrow "Animation Name*" 
	When   select drop down option as "easeInQuad"
	When   click on pulse setup add
	Then   client admin should  get success msg as "Added successfully!"
	Then click on left pane menu "Reports"
	Then click on the report "Audit Log Report"
	Then enter the username in filter as "septClient sept2020"
	Then enter the module in filter as "Pulse"
	Then filter the date with current date
	Then Table header Ascending for " Date"
	And verify the module is updated in table "Pulse Setup"
	Then Click on profile picture
    And logout

	@Yespraveen
Scenario: Check whether the fields like sender company,Department,Keyword,scanning location  are available in metadata
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then double click to open the email
Then click on extended info
Then click on metadata
Then system should display the meta data options "Conversion, Inventory Management, MailSorterUID, Metadata Profile ID, Metadata Profile Name, Records Management, SLADate, SLATime, Unique Barcode, User Defined05, User Defined06, User Defined07, User Defined08, User Defined09, User Defined10, User_Defined_04"
Then Click on profile picture
    And logout