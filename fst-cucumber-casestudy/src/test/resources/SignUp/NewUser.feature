Feature: To validate New user sign up and send email functionality


Scenario: New user sign-up
    Given I should be in login page
    When I click on signup link
   	And I enter First name as "Tejas"
   	And I enter Last name as "SDET"
   	And I enter email id as "a@a.com"
   	And I enter username as "sdettrain"
   	And I enter password as "testing123"
   	And I enter confirmpass as "testing123"
   	And I click on Register button
   	Then I should see the confirmation message:
   	"""
   	Dear Tejas SDET,

		Your personal settings have been registered.
		"""

Scenario: Send email after registration
		Given User is successfully registered
		When I click on profile option
		And I click on inbox option
		And I click on compose button
		And I enter name as "User61"
		And I enter subject as "Hi For Testing" in subject box
		And I enter body of the message:
		"""
		Hello Mr.Test,
		 This is for Testing
		
		From,
		Test
		"""
		And I click on send button
		Then I should see confirmation message as "The message has been sent to Test User61 (testing989)"