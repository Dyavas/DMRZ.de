package pages.loginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.commonPage.CommonPage;


public class LoginPage extends CommonPage {
    @FindBy(xpath = "//div[text()='DMRZ.de – Login']")
    public WebElement loginPageText;

    @FindBy(id = "tbLogin")
    public WebElement usernameInput;

    @FindBy(id = "tbLogin")
    public WebElement passwordInput;

    @FindBy(css = ".adxButtonCmdText")
    public WebElement loginButton;

    @FindBy(linkText = "Neu anmelden")
    public WebElement neueAnmeldenLink;
}
