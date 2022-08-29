package pages.commonPage;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class CommonPage {

    public CommonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
