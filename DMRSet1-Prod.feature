Feature: DMR Regression Suite

Background:
Given navigate to given URL "https://dmr.exela.global/#/login"
@Yes
Scenario: Login Verification with valid credentials
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then titile of the page should be "Exela DMR"
Then Click on profile picture
And logout
@Yes
Scenario: Login Verification with Invalid credentials
Then enter username as "chitra1"
Then click on next button
Then enter Password as "Pa$$w0rd11"
And click on signin button
Then System should throw a toggle message as "Invalid username/password"
@Yes
Scenario: Validate with Invalid password
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd11"
And click on signin button
Then System should throw a toggle message as "Invalid username/password"
@Yes
Scenario: Validate with Incorrect Username
Then enter username as "chitra1"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then System should throw a toggle message as "Invalid username/password"
@Yes
Scenario: Ensure show Password icon in Login screen
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
Then Click on show password icon
Then password should be visible
@Yes
Scenario: Validate details under the Dashboard
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Dashboard"
Then total mail should be enabled
Then opened mail should be enabled
Then un opened mail should be enabled
Then Click on profile picture
And logout
@Yes
Scenario: View Mail action distribution graph under Dashboard
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Dashboard"
When click on "Mail Action Distribution" dropdown option
Then system should display graph filter options as "All, Last 15 Days, Last 30 Days, Last 90 Days, Last Week"
Then Click on profile picture
And logout
@Yes
Scenario: View Aging Summary graph under Dashboard
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Dashboard"
#When click on "Aging Summary" dropdown option
#Then system should display graph filter options as "Chitra Test, Chitra mailadmin, Chitra mailuser, Deactivated User, Not My Mail, Undeliverable Mail, User"
Then Click on profile picture
And logout
@Yes
Scenario: Top ten recipients under Dashboard
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Dashboard"
When click on "Top 10 Recipients" dropdown option
Then system should display graph filter options as "All, Last 15 Days, Last 30 Days, Last 90 Days, Last Week"
Then Click on profile picture
And logout
@Yes
Scenario: View Top ten Senders under Dashboard
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Dashboard"
When click on "Top 10 Senders" dropdown option
Then system should display graph filter options as "All, Last 15 Days, Last 30 Days, Last 90 Days, Last Week"
Then Click on profile picture
And logout
@Yes
Scenario: Validate Re-route action is working
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
#Then select an email
#Then select action as "Re-Route"
#Then enter receipient as "Chitra.test@yopmail.com" and select it
#When click on send button
Then Move the document from Inbox to AutoSharedBox user box
Then System should throw a toggle message as "Document moved successfully"
Then click on AutoSharedBox user box
Then Move the document from AutoSharedBox box to Inbox box
Then System should throw a toggle message as "Document moved successfully"
Then Click on profile picture
And logout
@Yes
Scenario: Validate Send to action is working
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then select action as "Send To"
Then enter recepient as "testroleprod@yopmail.com" and select it
When click on send butn
Then click on send mail button
Then System should throw a toggle message as "Digital Mail Sent successfully"
Then Click on profile picture
And logout
Then navigate to yopmail URL "http://www.yopmail.com/en/"
Then enter yopmail id as "testroleprod@yopmail.com"
When click on check inbox
#Then system should display "Digital Mail - Send Notification" email
@No
Scenario: Validate Label Action is working
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then Click on profile picture
Then Click on SwitchTo option
Then Switch to "Mail Admin(Mail User)"
Then click OK button
Then select an email
Then select action as "Manage Label"
Then select label "label 1"
When click on Assign Label
Then System should throw a toggle message as "Label Assigned Successfully"
Then click on close button
Then Click on profile picture
And logout
@Yes
Scenario: Open Volume Report
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Volume Report"
Then select from date as "09/14/2020"
Then click on download icon
Then Click on profile picture
And logout
@Yes
Scenario: Open Action summary Report
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Action Summary Report"
Then select from date as "09/14/2020"
Then click on download icon
Then Click on profile picture
And logout
@Yes
Scenario: Open Chain of Custody 
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Chain of Custody Report"
Then select from date as "09/14/2020"
Then click on download icon
Then Click on profile picture
And logout
@Yes
Scenario: Open Recon Report 
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Reconciliation Report"
Then select from date as "09/14/2020"
Then click on download icon
Then Click on profile picture
And logout
@Yes
Scenario: Open Retention Report 
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Retention Aging Report"
Then click on download icon
Then Click on profile picture
And logout
@Yes
Scenario: Open Blocked sender Report 
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Blocked Senders Report"
Then click on download icon
Then Click on profile picture
And logout
@Yes
Scenario: Open Inventory Report 
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Inventory Report"
Then select from date as "09/14/2020"
Then click on download icon
Then Click on profile picture
And logout
@Yes
Scenario: Open Volume by Source  
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Volume By Source Report"
Then select from date as "09/14/2020"
Then click on download icon
Then Click on profile picture
And logout
@Yes
Scenario: Open Audit Report
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Audit Report"
Then select from date as "09/14/2020"
Then click on download icon
Then Click on profile picture
And logout

@Yes
Scenario: Health Check with client admin
Then enter username as "Chitratest"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then redirect the page to "https://dmr.exela.global/#/admin/health"
Then DMR core & DB, Ingester ,Exela auth & DB and eFirst-Archive status should be in "Connected" status
Then Click on profile picture
And logout







