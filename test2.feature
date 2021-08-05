Feature: test2

Background: User is Logged In
 	Given navigate to given URL "https://dmr-qa.exela.global/#/login" 
	Then enter username as "septclient"
	Then click on next button
	Then enter Password as "Pa$$w0rd"
	And click on signin button

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
@Yes
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



