Feature:Reset API Hited Threshold Count 
Scenario: To check after hit API ,API hit count get reset to zero 
Given Reset Count API Payload
When user hit "AxisAPI" with "POST" method 
Then user get Status code 200
And User get "success" msg "true"
And  "msg" should be  "Threshold reseted successfully."