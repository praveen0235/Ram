Feature: Verify functioanltiy present on User Profile Page
Background: User is Logged In
 	Given navigate to given URL "https://dmr-qa.exela.global/#/login"
	Then enter username as "testclient10"
	Then click on next button
	Then enter Password as "Test@321"
	And click on signin button

@Yes
Scenario: Verify functionality of Delegate Inbox for client admin
	Then Click on profile picture
	Then   Click on Myprofile 
	When   click on Settings
	When   on the toggle setting of "Delegate Inbox"
	When   select from date as "01/20/2021" and to date as "01/22/2021"
	When   enter email id as "testclient20@yopmail.com" to whom you want to delegate the inbox 
	When   click on save button and get success msg as "Delegate user information saved successfully"
	Then Click on profile picture
    And logout
    Then navigate to yopmail URL "http://www.yopmail.com/en/"
	Then enter yopmail id as "testclient20@yopmail.com"
	When click on check inbox
	Then system should display "Delegate Inbox Notification" email
@Yes
Scenario: Verify User is able to create routing rule on move to folder action
	Then Click on profile picture
	When click on Routing rule
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "client005_project"
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
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "client005_project"
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
	Then enter recepient as "testclient20@yopmail.com" and select it
	When   click on Send
	When   click on save button
	Then User should get success msg as "Auto routing details added successfully"
	Then filter the rule name "TestRule12"
	And delete it
@Yes
Scenario: Verify User is able to create routing rule on Re-route action
	Then Click on profile picture
	When click on Routing rule
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "client005_project"
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
	Then enter re-route recepient as "testclient20@yopmail.com" and select it
	When   click on Send
	When   click on save button
	Then User should get success msg as "Auto routing details added successfully"
	Then filter the rule name "TestRule13"
	And delete it
@Yes
Scenario: Verify User is able to create routing rule on Delete action
	Then Click on profile picture
	When click on Routing rule
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "client005_project"
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
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "client005_project"
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
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "client005_project"
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
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "client005_project"
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
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "client005_project"
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
	Then enter re-route recepient as "testclient20@yopmail.com" and select it
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
	When   select drop down option as "client005_project"
	When    check the project queue as "Default"
	When   click on assign
    Then User should get success msg as "Project queue access updated Successfully"
    When click on edit role headers "Role-Shared-Mailbox Assignment"
	When   Check the shared mail box as "Testing shared mailbox" from role shared mailbox assignment tab.
	Then click on left pane menu "User Setup"
	Then filter login name "testclient20"
	When   click on edit.
	When click on drop down arrow "Assign Roles*" 
	When   select drop down option as "TestRole"
	When   click on SAVE button
	Then Click on profile picture
	And logout
	Then enter username as "testclient20"
	Then click on next button
	Then enter Password as "Test@1234"
	And click on signin button
	Then click on toggle menu
	Then left pane should consists of "Dashboard,Inbox"
	Then Click on profile picture
	And logout
	Then enter username as "testclient10"
	Then click on next button
	Then enter Password as "Test@321"
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
	Then User should see selected action present the actions dropdown as "Completed, Delete, Junk Mail, Manage Label, Manage Physical delivery, Move To Folder, Not My Mail, Re-Route, Select Action, Send For Drysign, Send To"
	
@Yes
Scenario: Verify functionality of toggle of New Mail notification
	
	Then Click on profile picture
	When    click on My Profile
	When   click on Settings
	When   Off the toggle of "New Mail Notification Active" New Mail Notification option
	Then navigate to given URL "http://www.yopmail.com/en/"
	Then enter yopmail id as "testclient10@yopmail.com"
	When click on check inbox
	Then Check the "New Mail Notification" value is "false"
	#Then User should not receive the Notification
@Yes
Scenario: Verify functionality of toggle of Not My Mail notification
	Then Click on profile picture
	When   click on My Profile
	When   click on Settings
	When   Off the toggle of "Not My Mail Notification Active" Not My Mail Notification option
	Then navigate to given URL "http://www.yopmail.com/en/"
	Then enter yopmail id as "testclient10@yopmail.com"
	When click on check inbox
	Then Check the "Not My Mail Notification" value is "false"
	#Then User should not receive the Notification
@Yes
Scenario: Verify functionality of toggle of Re-route notification
 	Then Click on profile picture
	When   click on My Profile
	When   click on Settings
	When   Off the toggle of "Re-route Notification Active" Re-route Notification option
	Then navigate to given URL "http://www.yopmail.com/en/"
	Then enter yopmail id as "testclient10@yopmail.com"
	When click on check inbox
	Then Check the "Reroute Notification" value is "false"
	#Then User should not receive the Notification
@Yes
Scenario: Verify functionality of Out of office for client admin
	Then Click on profile picture
	When   click on My Profile
	When   click on Settings
	When   on the toggle of "Set Out of Office" option
	When   Select start date as "01/23/2021" aand end date as "01/25/2021"
 	When   click on save button
	Then System should throw a toggle message as "Out of office settings saved successfully"
	Then Click on profile picture
	And logout
	Given navigate to given URL "https://dmr-qa.exela.global/#/login"
	Then enter username as "testclient20"
	Then click on next button
	Then enter Password as "Test@1234"
	And click on signin button
	Then select an email
	Then select action as "Send To"
	Then enter recepient as "testclient21@yopmail.com" and select it
	When click on send butn
	Then click on send mail button
	
@Yes
Scenario: Verify client admin is able to Delegate Other User's Inbox 
	Then Click on profile picture
	Then  Click on Myprofile 
	When  click on Settings
	When   on the toggle setting of "Delegate Inbox"
	When   Checked the delegate other user inbox checkbox
	When   Enter the User one's mail id as "testclient21@yopmail.com" whose inbox you want to delegate 
	When select from date as "01/29/2021" and to date as "01/30/2021"
	When   enter email id as "testclient20@yopmail.com" of User two you want to delegate the inbox 
	When   click on save button
	Then navigate to given URL "http://www.yopmail.com/en/"
	Then enter yopmail id as "testclient20@yopmail.com"
	When click on check inbox
	Then User two testclient20@yopmail.com  whom we delegate the inbox should be copied in emails of User one testclient21@yopmail.com.
	
@Yes
Scenario: Check whether the fields like sender company,Department,Keyword,scanning location  are available while creating rule condition in routing rule.
Then Click on profile picture
	When click on Routing rule
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "client005_project"
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
Then select from date as "04/01/2020"
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
Then filter scan date "09-25-2020"
Then click on the "OPENED" link count
Then system should display the tabel headers as "SCAN DATE,INGESTION DATE,RECIPIENT,SENDER NAME,SENDER COMPANY,STATUS,CURRENT USER,SOURCE,PAGE COUNT,IMAGE COUNT,BATCH CLASS,LOCATION/SITE,DOC TYPE,SCANNING LOCATION,DCN"
Then the count should match between opened link count and detailed report count
Then Click on profile picture
And logout
@Yes
Scenario: Check whether the user is able to see the new filters added in Volume Report
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Volume Report"
When click on advanced search
Then select from date as "09/01/2020"
When click on drop down arrow "Source" 
When  select drop down option as "SCAN"
Then click on search button
Then the number of volume records should be "1"
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
Then select from date as "04/01/2020"
Then select to date as "11/01/2020"
Then total count should be "9"
Then Click on profile picture
And logout
@Yes
Scenario: Check whether the user is able to see the action summary report with action name and total count
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Action Summary Report"
Then select from date as "04/01/2020"
Then select to date as "11/01/2020"
When click on advanced search
When click on drop down arrow "Action" 
When select drop down option as "All"
When filter Action "Move To Folder"
Then total count should be "3"
Then Click on profile picture
And logout
@Yes
Scenario: Verify that Mail user is able to redact some content of pdf document
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then double click to open the email
Then click on PDF "Redaction" option
Then redact the PDF at X-axis "380" and at Y-axis "80"
Then check redaction rectangle is displayed
Then Click on profile picture
And logout
#Hold
Scenario: Verify that redacted mail content is not visible to next mail recipient
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then double click to open the email
Then click on PDF "Redaction" option
Then redact the PDF at X-axis "380" and at Y-axis "80"
Then click on redact save
Then select action as "Send To"
Then enter recepient as "testclient20@yopmail.com" and select it
When click on send butn
Then click on send mail button
Then System should throw a toggle message as "Digital Mail Sent successfully"
Then Click on profile picture
And logout
Then enter username as "testclient20"
Then click on next button
Then enter Password as "Test@1234"
And click on signin button
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then double click to open the email
Then click on PDF "Redaction" option
Then check redaction rectangle is notdisplayed
Then Click on profile picture
And logout
@Yes
Scenario: Verify that redaction rectangle is solid black fill with no border and no transparency
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then double click to open the email
Then click on PDF "Redaction" option
Then redact the PDF at X-axis "380" and at Y-axis "80"
Then color of redaction should be black
Then Click on profile picture
And logout
@Yes	
Scenario: Verify that size of redaction tool is customizable
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then double click to open the email
Then click on PDF "Redaction" option
Then redact the PDF at X-axis "370" and at Y-axis "90"
Then check redaction rectangle is displayed
Then Click on profile picture
And logout
@Yes
Scenario: Verify that user can delete the redaction triangle before saving
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then double click to open the email
Then click on PDF "Redaction" option
Then redact the PDF at X-axis "380" and at Y-axis "80"
Then delete the drawn redaction
Then check redaction rectangle is notdisplayed
Then Click on profile picture
And logout
@Yes
Scenario: Verify that user cannot delete the redaction triangle after saving it
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then double click to open the email
Then click on PDF "Redaction" option
Then redact the PDF at X-axis "380" and at Y-axis "80"
Then save the drawn redaction
Then check redaction delete option should not be displayed
Then Click on profile picture
And logout
@Yes
Scenario: Verify that user can make multiple redacts on pdf mail
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then double click to open the email
Then click on PDF "Redaction" option
Then redact the PDF at X-axis "380" and at Y-axis "80"
Then save the drawn redaction
Then redact the PDF at X-axis "280" and at Y-axis "80"
Then Click on profile picture
And logout
@Yes
Scenario: Verify that user view redacted mails in chain of custody report as well
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then double click to open the email
Then click on PDF "Redaction" option
Then redact the PDF at X-axis "380" and at Y-axis "80"
Then save the drawn redaction
Then check redaction rectangle is displayed
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "CLIENTADMIN"
Then click OK button
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Chain of Custody Report"
When filter the previous the redated DCN
Then system should display redated DCN in chain of custody report
Then Click on profile picture
And logout
@Yes
Scenario: Verify that user can add annotation to PDF content of email
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then double click to open the email
Then click on PDF "Annotation" option
Then redact the PDF at X-axis "380" and at Y-axis "80"
Then the annotation text as "testing"
Then check annotation rectangle is displayed
Then Click on profile picture
And logout
@Yes
Scenario: Verify that annotation gets saved
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then double click to open the email
Then click on PDF "Annotation" option
Then redact the PDF at X-axis "380" and at Y-axis "80"
Then the annotation text as "testing"
Then save the drawn annotation
Then check annotation rectangle is displayed
Then Click on profile picture
And logout

@Yes
Scenario: Verify that user can add multiple annotation and they get saved
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then double click to open the email
Then click on PDF "Annotation" option
Then redact the PDF at X-axis "380" and at Y-axis "80"
Then the annotation text as "testing"
Then save the drawn annotation
Then redact the PDF at X-axis "180" and at Y-axis "80"
Then the Annotation text as "testing2"
Then save the drawn annotation
Then Click on profile picture
And logout

@Yes
Scenario: Verify that user can delete annotation that is not saved
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then double click to open the email
Then click on PDF "Annotation" option
Then redact the PDF at X-axis "380" and at Y-axis "80"
Then the annotation text as "testing"
Then delete the drawn annotation
Then check annotation rectangle is not displayed
Then Click on profile picture
And logout

