package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateProcessPage extends HomePage {

    public CreateProcessPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Name")
    private WebElement nameTxt;

    @FindBy(linkText = "Back to List")
    private WebElement backToListBtn;

    @FindBy(css = "input[type=submit]")
    private WebElement createBtn;

    @FindBy(css = ".field-validation-error[data-valmsg-for=Name]")
    private WebElement nameError;

    public CreateProcessPage typeName(String processName) {
        nameTxt.clear();
        nameTxt.sendKeys(processName);

        return this;
    }

    public CreateProcessPage submitCreateWithFailure() {
        createBtn.click();

        return this;
    }

    public CreateProcessPage assertProcessNameError(String expError) {
        Assert.assertEquals(nameError.getText(), expError);

        return this;
    }
}
