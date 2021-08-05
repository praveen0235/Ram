Feature: Verify functioanltiy present on User Profile Page
Background: User is Logged In
 	Given navigate to given URL "https://dmr.exela.global/#/login" 
	Then enter username as "chitratest"
	Then click on next button
	Then enter Password as "Pa$$w0rd"
	And click on signin button

@Prodo
Scenario: Verify functionality of Delegate Inbox for client admin
	Then Click on profile picture
	Then   Click on Myprofile 
	When   click on Settings
	When   on the toggle setting of "Delegate Inbox"
	When   select from date as today and to date is additional of two days of today
	When   enter email id as "chitramailuser1@yopmail.com" to whom you want to delegate the inbox 
	When   click on save button and get success msg as "Delegate user information saved successfully"
	Then Click on profile picture
    And logout
    Then navigate to yopmail URL "http://www.yopmail.com/en/"
	Then enter yopmail id as "chitramailuser1@yopmail.com"
	When click on check inbox
	Then system should display "Delegate Inbox Notification" email
	
@Prodo
Scenario: Verify User is able to create routing rule on move to folder action
	Then Click on profile picture
	When click on Routing rule
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "Regression testing_project"
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
	When   select folder as "AutoSharedBox"
	Then click OK button
	When   click on save button
	Then User should get success msg as "Auto routing details added successfully"
	Then filter the rule name "TestRule1"
	And delete it
@Prodo
Scenario: Verify User is able to create routing rule on Send To action
	Then Click on profile picture
	When click on Routing rule
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "Regression testing_project"
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
	Then enter recepient as "testroleprod@yopmail.com" and select it
	When   click on Send
	When   click on save button
	Then User should get success msg as "Auto routing details added successfully"
	Then filter the rule name "TestRule12"
	And delete it
@Prod
Scenario: Verify User is able to create routing rule on Re-route action
	Then Click on profile picture
	When click on Routing rule
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "Regression testing_project"
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
	Then enter re-route recepient as "chitramailadmin1@yopmail.com" and select it
	When   click on Send
	When   click on save button
	Then User should get success msg as "Auto routing details added successfully"
	Then filter the rule name "TestRule13"
	And delete it
@Prodo
Scenario: Verify User is able to create routing rule on Delete action
	Then Click on profile picture
	When click on Routing rule
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "Regression testing_project"
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
@Prod
Scenario: Verify User is able to create routing rule on Assign label action
	Then Click on profile picture
	When click on Routing rule
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "Regression testing_project"
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
@Prod
Scenario: Verify User is able to create routing rule on Deliver Physicallly and Digitally action
	Then Click on profile picture
	When click on Routing rule
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "Regression testing_project"
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
@Prod
Scenario: Verify User is able to create routing rule on mark as junk action
	Then Click on profile picture
	When click on Routing rule
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "Regression testing_project"
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
@Prod
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
@Prod
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

@Prod
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
@Prod
Scenario:  Verify Client admin is able to create routing rule via NQube-routing rule
	Then click on toggle menu
	Then click on left pane menu "nQube"
	When click on "Routing Rule" nQube options
	When   click on add button
	When click on drop down arrow "project code" 
	When   select drop down option as "Regression testing_project"
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
	Then enter re-route recepient as "chitramailadmin1@yopmail.com" and select it
	When   click on save button
	Then User should get success msg as "Auto routing details added successfully"
	Then filter the rule name "TestRule16"
	And delete it

@Prod
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
	Then enter action name as "Not My Mail"
	When    User should see selected templates as "Not My Mail"
	When    edit content subject as "Edited Digital Mail - Re-Route Notification"
	When   click on save button
	Then User should get success msg as "Action Template updated successfully"
	Then enter action name as "Not My Mail"
	When    User should see selected templates as "Not My Mail"
	When    edit content subject as "Digital Mail - Re-Route Notification"
	When   click on save button
@Prod
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
@No
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
	When   select drop down option as "Regression testing_project"
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
	Then enter username as "varsha001"
	Then click on next button
	Then enter Password as "Pa$$w0rd"
	And click on signin button
	Then click on toggle menu
	Then left pane should consists of "Dashboard,Inbox"
	Then Click on profile picture
	And logout
	Then enter username as "chitra"
	Then click on next button
	Then enter Password as "Pa$$w0rd"
	And click on signin button
	Then click on toggle menu
	Then click on left pane menu "Role Setup"
	Then filter the role name "TestRole"
	And delete it
	

@Prod
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
	
	@Prod
Scenario: Verify functionality of toggle of New Mail notification
	
	Then Click on profile picture
	When    click on My Profile
	When   click on Settings
	When   Off the toggle of "New Mail Notification Active" New Mail Notification option
	Then navigate to given URL "http://www.yopmail.com/en/"
	Then enter yopmail id as "chitratestprod@yopmail.com"
	When click on check inbox
	Then Check the "New Mail Notification" value is "false"
	#Then User should not receive the Notification
@Prod
Scenario: Verify functionality of toggle of Not My Mail notification
	Then Click on profile picture
	When   click on My Profile
	When   click on Settings
	When   Off the toggle of "Not My Mail Notification Active" Not My Mail Notification option
	Then navigate to given URL "http://www.yopmail.com/en/"
	Then enter yopmail id as "chitratestprod@yopmail.com"
	When click on check inbox
	Then Check the "Not My Mail Notification" value is "false"
	#Then User should not receive the Notification
@Prod
Scenario: Verify functionality of toggle of Re-route notification
 	Then Click on profile picture
	When   click on My Profile
	When   click on Settings
	When   Off the toggle of "Re-route Notification Active" Re-route Notification option
	Then navigate to given URL "http://www.yopmail.com/en/"
	Then enter yopmail id as "chitratestprod@yopmail.com"
	When click on check inbox
	Then Check the "Reroute Notification" value is "false"
	#Then User should not receive the Notification
@Prod
Scenario: Verify functionality of Out of office for client admin
	Then Click on profile picture
	When   click on My Profile
	When   click on Settings
	When   on the toggle of "Re-route Notification Deactive" option
	When   select From date as today and to date is additional of two days of today
	#When   Select start date as today and end date as two day from today
 	When   click on save button
	Then System should throw a toggle message as "Out of office settings saved successfully"
	Then Click on profile picture
	And logout
	
@Prod
Scenario: Verify client admin is able to Delegate Other User's Inbox 
	Then Click on profile picture
	Then  Click on Myprofile 
	When  click on Settings
	When   on the toggle setting of "Delegate Inbox"
	When   Checked the delegate other user inbox checkbox
	When   Enter the User one's mail id as "chitramailadmin1@yopmail.com" whose inbox you want to delegate 
	When   select from date as today and to date is additional of two days of today
	When   enter email id as "chitramailuser1@yopmail.com" of User two you want to delegate the inbox 
	When   click on save button
	Then navigate to given URL "http://www.yopmail.com/en/"
	Then enter yopmail id as "chitramailuser1@yopmail.com"
	When click on check inbox
	Then User two mailadminauto@yopmail.com  whom we delegate the inbox should be copied in emails of User one mailuserauto@yopmail.com.
	
