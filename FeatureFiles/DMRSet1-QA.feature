Feature: DMR Regression Suite Set-1

Background:
Given navigate to given URL "https://dmr-qa.exela.global/#/"
@Yes
Scenario: Login Verification with valid credentials
Then enter username as "septclient"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then titile of the page should be "Exela DMR"
Then Click on profile picture
And logout
@Yestes
Scenario: Login Verification with Invalid credentials
Then enter username as "septclien"
Then click on next button
Then enter Password as "test@12"
And click on signin button
Then System should throw a toggle message as "Invalid username/password"
@Yestes
Scenario: Validate with Invalid password
Then enter username as "septclien"
Then click on next button
Then enter Password as "test@124"
And click on signin button
Then System should throw a toggle message as "Invalid username/password"
@Yestes
Scenario: Validate with Incorrect Username
Then enter username as "testcli10"
Then click on next button
Then enter Password as "Test@321"
And click on signin button
Then System should throw a toggle message as "Invalid username/password"
@Yestes
Scenario: Ensure show Password icon in Login screen
Then enter username as "septclient"
Then click on next button
Then enter Password as "Pa$$w0rd"
Then Click on show password icon
Then password should be visible
@Yes
Scenario: Validate details under the Dashboard
Then enter username as "septclient"
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
@Yestes
Scenario: View Mail action distribution graph under Dashboard
Then enter username as "septclient"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Dashboard"
When click on "Mail Action Distribution" dropdown option
Then system should display graph filter options as "All, Last Week, Last 15 Days, Last 30 Days, Last 90 Days"
Then Click on profile picture
And logout
@Yes
Scenario: View Aging Summary graph under Dashboard
Then enter username as "septclient"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Dashboard"
When "Aging Summary" graph should be displayed
Then Click on profile picture
And logout
@Yes
Scenario: Top ten recipients under Dashboard
Then enter username as "septclient"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Dashboard"
When click on "Top 10 Recipients" dropdown option
Then system should display graph filter options as "All, Last Week, Last 15 Days, Last 30 Days, Last 90 Days"
Then Click on profile picture
And logout
@Yes
Scenario: View Top ten Senders under Dashboard
Then enter username as "septclient"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Dashboard"
When click on "Top 10 Senders" dropdown option
Then system should display graph filter options as "All, Last Week, Last 15 Days, Last 30 Days, Last 90 Days"
Then Click on profile picture
And logout

@Yes
Scenario: Open Volume Report
Then enter username as "septclient"
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
Then enter username as "septclient"
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
Then enter username as "septclient"
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
Then enter username as "septclient"
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
Then enter username as "septclient"
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
Then enter username as "septclient"
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
Then enter username as "septclient"
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
Then enter username as "septclient"
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
Then enter username as "septclient"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then click on toggle menu
Then click on left pane menu "Reports"
Then click on the report "Audit Log Report"
Then select from date as "09/14/2020"
Then click on download icon
Then Click on profile picture
And logout

@Yes
Scenario: Health Check with client admin
Then enter username as "septclient"
Then click on next button
Then enter Password as "Pa$$w0rd"
And click on signin button
Then redirect the page to "https://dmr-qa.exela.global/#/admin/health"
Then DMR core & DB, Ingester ,Exela auth & DB and eFirst-Archive status should be in "Connected" status
Then Click on profile picture
And logout

