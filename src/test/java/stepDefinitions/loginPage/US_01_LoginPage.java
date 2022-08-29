package stepDefinitions.loginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.RegisterPage;
import pages.loginPage.LoginPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.stream.Collectors;

import static utilities.Driver.driver;

public class US_01_LoginPage {
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @Given("the user goes to Home Page")
    public void theUserGoesToHomePage() {
        driver.get(ConfigurationReader.getProperty("url"));
    }

    @Then("the user verifies that the page is {string}")
    public void theUserVerifiesThatThePageIs(String url) {
        Assert.assertEquals(url, Driver.getDriver().getCurrentUrl());
    }

    @Then("the user verifies that the page title is {string}")
    public void theUserVerifiesThatThePageTitleIs(String message) {
        BrowserUtilities.waitForPageToLoad(2);
        Assert.assertEquals(message, loginPage.loginPageText.getText());
    }

    @When("the user clicks on the link Neu anmelden")
    public void theUserClicksOnTheLinkNeuAnmelden() {
        BrowserUtilities.myClickMethod(loginPage.neueAnmeldenLink);
    }

    @When("the user inputs in a valid data {string},{string},{string},{string},{string},{string},{string} input box")
    public void theUserInputsInAValidDataInputBox(String anrede, String title, String vorname, String nachname, String telefon, String zusatzTelefon, String email) {
        BrowserUtilities.mySendKeysMethod(registerPage.anredeInput, anrede);
        BrowserUtilities.mySendKeysMethod(registerPage.titelInput, title);
        BrowserUtilities.mySendKeysMethod(registerPage.vornameInput, vorname);
        BrowserUtilities.mySendKeysMethod(registerPage.nachnameInput, nachname);
        BrowserUtilities.mySendKeysMethod(registerPage.telefonInput, telefon);
        BrowserUtilities.mySendKeysMethod(registerPage.zusatzTelefonInput, zusatzTelefon);
        BrowserUtilities.mySendKeysMethod(registerPage.emailInput, email);
    }

    @When("the user inputs in a valid data {string},{string},{string},{string} input box")
    public void theUserInputsInAValidDataInputBox(String firmaName, String strasseNr, String plzOrt, String ort) {
        BrowserUtilities.mySendKeysMethod(registerPage.firmaNameInput, firmaName);
        BrowserUtilities.mySendKeysMethod(registerPage.strasseNrInput, strasseNr);
        BrowserUtilities.mySendKeysMethod(registerPage.plzOrtInput, plzOrt);
        BrowserUtilities.mySendKeysMethod(registerPage.ortInput, ort);
    }

    @When("the user checks the on umsatzsteuerpflichtig check box")
    public void theUserChecksTheOnUmsatzsteuerpflichtigCheckBox() {
        BrowserUtilities.myClickMethod(registerPage.umsatzsteuerpflichtigCheckInput);
    }

    @When("the user inputs in a valid data {string},{string},{string} input box")
    public void theUserInputsInAValidDataInputBox(String steuernummer, String kirchlicherTraeger, String leistungsbereich) {
        BrowserUtilities.mySendKeysMethod(registerPage.steuernummerInput, steuernummer);
        BrowserUtilities.mySendKeysMethod(registerPage.kirchlicherTraegerInput, kirchlicherTraeger);
        BrowserUtilities.mySendKeysMethod(registerPage.leistungsbereichInput, leistungsbereich);
    }

    @When("the user inputs in a valid data {string},{string},{string} input box login")
    public void theUserInputsInAValidDataInputBoxLogin(String loginName, String passwortnew, String passwortwiederholen) {
        BrowserUtilities.mySendKeysMethod(registerPage.loginNameInput, loginName);
        BrowserUtilities.mySendKeysMethod(registerPage.passwortnewInput, passwortnew);
        BrowserUtilities.mySendKeysMethod(registerPage.passwortwiederholenInput, passwortwiederholen);
    }

    @When("the user inputs in a valid data {string} input box")
    public void theUserInputsInAValidDataInputBox(String gutscheinCode) {
        BrowserUtilities.mySendKeysMethod(registerPage.gutscheincodeInput, gutscheinCode);
    }

    boolean flag;

    @When("the user clicks on the Jetz testen button and the result is {int}")
    public void theUserClicksOnTheJetzTestenButton(int status) {
        BrowserUtilities.waitFor(2);
        BrowserUtilities.scrollToElement(registerPage.jetzTestenButton);
        BrowserUtilities.myClickMethod(registerPage.jetzTestenButton);
        if (status > 0) {
            flag = false;
            System.out.println(registerPage.errorBoxes.size());
            Assert.assertTrue(registerPage.errorBoxes.stream().filter(e -> e.isDisplayed()).collect(Collectors.toList()).size() == status);
            BrowserUtilities.myClickMethod(registerPage.loginButton);
        } else {
            flag = true;
        }
    }

    @Then("the user verfies that the {string} message is visible")
    public void theUserVerfiesThatTheMessageIsVisible(String expextedMassage) {
        if (flag) {
            BrowserUtilities.waitForVisibility(registerPage.kundennummerText, 2);
        }
    }

    @Then("the user verifies that the register page title is {string}")
    public void theUserVerifiesThatTheRegisterPageTitleIs(String message) {
        BrowserUtilities.waitForPageToLoad(5);
        Assert.assertEquals(message, registerPage.registerPageKontrolText.getText());
    }
}

