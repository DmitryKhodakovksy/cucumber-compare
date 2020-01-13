Feature: Cucumber compare feature

  Background: Background
#    enum?
    Given I open HTML home page
#    regular
    When I click 'HTML Table' link

  @TestCaseId("example-1")
  Scenario: Example-1
#    convert to List<Object>
    Then I should see table with columns
      | Company | Contact | Country |

  @TestCaseId("example-2")
  Scenario: Example-2
#    alternative text
#    convert to List<String>
    Then I should see values in column 'Country'
      | Germany |
      | Mexico  |
      | Austria |
      | UK      |
      | Canada  |
      | Italy   |

  @TestCaseId("example-3")
  Scenario: Example-3
#    optional text
    Then I have 6 records in customers table
#    convert to List<Custom type>
    And  I should see table with parameters
      | Company                      | Contact          | Country |
      | Alfreds Futterkiste          | Maria Anders     | Germany |
      | Centro comercial Moctezuma   | Francisco Chang  | Mexico  |
      | Ernst Handel                 | Roland Mendel    | Austria |
      | Island Trading               | Helen Bennett    | UK      |
      | Laughing Bacchus Winecellars | Yoshi Tannamuri  | Canada  |
      | Magazzini Alimentari Riuniti | Giovanni Rovelli | Italy   |

  @TestCaseId("example-4")
  Scenario: Example-4
#    convert to List<Map<String, String>>
    Then table should contain records with values
      | Company                      |
      | Ernst Handel                 |
      | Magazzini Alimentari Riuniti |