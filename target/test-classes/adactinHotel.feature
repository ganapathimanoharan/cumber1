Feature: validate the login function of adactin application

  Scenario Outline: validate the adactin hotel page
    Given User is on adactinHotel page on chrome browser
    When user enter the "<username>"and"<password>"
    And user click the login button
    And user check search hotel page visible or not
    When user enter the details in search hote page "<location>","<hotels>","<roomtype>","<roomnos>","<adultroom>"and"<childroom>"
    And user click the search button
    And user check select hotel page visible or not
    When user select the hotel and click the search button
    And user check booking page visible or not
    When user enter the details in booking page "<firstName>","<lastName>","<address>","<cardno>","<cardtype>","<expmonth>","<expyear>"and"<cvvno>"
    And user click the booking button
    And user get the PNR code and cancel the booking

    Examples: 
      | username       | password | location | hotels      | roomtype | roomnos | adultroom | childroom | firstName | lastName  | address            | cardno           | cardtype         | expmonth | expyear | cvvno |
      | ganapathi12345 | I280DX   | London   | Hotel Creek | Standard | 1 - One | 3 - Three | 3 - Three | Ganapathi | Manoharan | Greens Techonology | 9988998899889988 | American Express | May      |    2022 |  5566 |
