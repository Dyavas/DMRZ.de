package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.commonPage.CommonPage;

import java.util.List;

public class RegisterPage extends CommonPage {

    @FindBy(xpath = "//div[text()='Neuanmeldung bei DMRZ.de']")
    public WebElement registerPageKontrolText;

    @FindBy(css = "input[xrfm='APAnrede']")
    public WebElement anredeInput;

    @FindBy(css = "a[onclick^='cDSForm']")
    public WebElement loginButton;

    @FindBy(css = "div.errortext")
    public List<WebElement> errorBoxes;

    @FindBy(css = "input[xdf='TitelBez']")
    public WebElement titelInput;

    @FindBy(css = "input[xdf='APVorname']")
    public WebElement vornameInput;

    @FindBy(css = "input[xdf='APNachname']")
    public WebElement nachnameInput;

    @FindBy(css = "input[xdf='Telefon1']")
    public WebElement telefonInput;

    @FindBy(css = "input[xdf='Telefon1Zusatz']")
    public WebElement zusatzTelefonInput;

    @FindBy(css = "input[xdf='EMail1']")
    public WebElement emailInput;


    @FindBy(css = "input[xdf='Name1']")
    public WebElement firmaNameInput;

    @FindBy(css = "input[xdf='Strasse']")
    public WebElement strasseNrInput;

    @FindBy(css = "input[xdf='PLZOrt']")
    public WebElement plzOrtInput;

    @FindBy(css = "input[xdf='Ort']")
    public WebElement ortInput;

    @FindBy(id = "cbHatMwst")
    public WebElement umsatzsteuerpflichtigCheckInput;

    @FindBy(css = "input[xdf='Steuernummer']")
    public WebElement steuernummerInput;

    @FindBy(css = "input[xdf='KirchlicherTraegerBez']")
    public WebElement kirchlicherTraegerInput;

    @FindBy(css = "input[xdf='Leistungsbereich']")
    public WebElement leistungsbereichInput;


    @FindBy(css = "input[xdf='isvrLogin']")
    public WebElement loginNameInput;

    @FindBy(css = "input[xdf='isvrPasswort']")
    public WebElement passwortnewInput;

    @FindBy(css = "input[xdf='isvrPasswort2']")
    public WebElement passwortwiederholenInput;

    @FindBy(css = "input[xdf='Gutscheincode']")
    public WebElement gutscheincodeInput;

    @FindBy(css = "div[xcaption='Jetzt testen »']")
    public WebElement jetzTestenButton;

    @FindBy(css = "span[xdf='Kundennummer']")
    public WebElement kundennummerText;


}
