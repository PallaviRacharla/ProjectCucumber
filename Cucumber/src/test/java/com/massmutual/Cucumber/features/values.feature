Feature: Verify all the test cases

Background:
        Given Launch the Login Page
        
  @regression
  Scenario Outline: Verification of lables and text box values count
    Given Login to the application "<UserName>" , "<Password>"
    Then verify count of lables and text boxes values

    Examples: 
      | UserName | Password |
      | Username | Password |

  @regression
  Scenario Outline: Verification of text box value greater than zero
    Given Login to the application "<UserName>" , "<Password>"
    Then verify text box value great than zero

    Examples: 
      | UserName | Password |
      | Username | Password |

  @regression
  Scenario Outline: Verification of total balance with values listed on the screen
    Given Login to the application "<UserName>" , "<Password>"
    Then verify total balance with values listed on the screen

    Examples: 
      | UserName | Password |
      | Username | Password |

  @regression
  Scenario Outline: Verification the values are formatted as currencies
    Given Login to the application "<UserName>" , "<Password>"
    Then verify text box content format

    Examples: 
      | UserName | Password |
      | Username | Password |

  @regression
  Scenario Outline: Verification total balance matches with sum of values
    Given Login to the application "<UserName>" , "<Password>"
    Then verify total balance

    Examples: 
      | UserName | Password |
      | Username | Password |
