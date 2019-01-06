Feature: FreeCRM login feature 

@Sri
Scenario: Validate FreeCRM homepage test 
	Given user is on FreeCRM site 
	When user enters username and password 
	And user is logged in to homepage 
	
@Sri	
Scenario: User clicks on New Deal under deals 
	Given user is logged in and on homepage 
	Then user clicks on new deal 
	And user enters firstname and lastname and company and position
	Then user saves the deal 