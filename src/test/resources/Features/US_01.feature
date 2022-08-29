#US_001	As a user I should be able to access the home page
#http://pflege.dmrz.info
#The home page must be accessible when the URL is entered
#by Davut Yavas
@regression
Feature: US_01 As a user I should be able to access the home page


  Scenario Outline: US_001_TC_01_the user registers with valid credentials
    Given the user goes to Home Page
    Then the user verifies that the page is "http://pflege.dmrz.info/"
    Then the user verifies that the page title is "DMRZ.de – Login"
    When the user clicks on the link Neu anmelden
    Then the user verifies that the register page title is "Neuanmeldung bei DMRZ.de"
    When the user inputs in a valid data "<anrede>","<title>","<vorname>","<nachname>","<telefon>","<zusatzTelefon>","<email>" input box
    When the user inputs in a valid data "<firmaName>","<strasseNr>","<plzOrt>","<ort>" input box
    When the user checks the on umsatzsteuerpflichtig check box
    When the user inputs in a valid data "<steuernummer>","<kirchlicherTraeger>","<leistungsbereich>" input box
    When the user inputs in a valid data "<loginName>","<passwortnew>","<passwortwiederholen>" input box login
#    When the user inputs in a valid data "<gutscheinCode>" input box
    When the user clicks on the Jetz testen button and the result is <status>
    Then the user verfies that the "<email>" message is visible
    Examples:
      | anrede | title | vorname | nachname | telefon       | zusatzTelefon | email                   | firmaName | strasseNr           | plzOrt | ort      | steuernummer | kirchlicherTraeger | leistungsbereich | loginName     | passwortnew | passwortwiederholen | gutscheinCode | status |
      |        | Dr    | Alis1   | Müller1  | +491744712344 | +495424255854 | alismulluer10@gmail.com | db1 GmbH  | mueller Strasse 100 | 44623  | Dortmund | 123456       | Sonstige           | Augenärzte       | AlisMueller3  | Aa-123456   | Aa-123456           | DMRZ10        | 1      |
      | Frau   | Dr    | Alis1   | Müller1  | +491744712344 | +495424255854 | alismulluer15@gmail.com | db1 GmbH  | mueller Strasse 100 | 44623  | Dortmund | 123456       | Sonstige           | Augenärzte       | AlisMueller15 | Aa-123456   | Aa-123456           | DMRZ10        | 0      |