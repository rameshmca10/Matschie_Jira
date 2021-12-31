Feature: Create New Issue
  
  Scenario: Create a new issue with description
	Given enable logs
	And issue details are added in body './data/Issue.json' 
	Then the status code is 201
	And response includes the following
	#json Path of the key|		Value
	|result.sys_created_by|admin|
	|result.sys_class_name|incident|