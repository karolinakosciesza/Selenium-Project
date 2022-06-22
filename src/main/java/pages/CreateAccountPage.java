package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CreateAccountPage {
    protected WebDriver driver;

    public CreateAccountPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> registerErrors;

    @FindBy(id = "ConfirmPassword-error")
    private WebElement confirmationError;

    @FindBy(id = "Password")
    private WebElement passwordTxt;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement registerBtn;

    public CreateAccountPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);

        return this;
    }

    public CreateAccountPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);

        return this;
    }

    public CreateAccountPage typeConfirmPassword(String confirmPassword) {
        confirmPasswordTxt.clear();
        confirmPasswordTxt.sendKeys(confirmPassword);
        return this;
    }

    public HomePage submitRegister() {
        registerBtn.click();
        return new HomePage(driver);
    }

    public CreateAccountPage submitRegisterWithFailure() {
        registerBtn.click();
        return this;
    }

    public CreateAccountPage assertRegisterErrorIsShown(String errorText) {
            String getErrorText = registerErrors.get(0).getText();
            Assert.assertEquals(getErrorText, errorText);
            return this;
        }

    public CreateAccountPage assertConfirmationErrorIsShown() {
        Assert.assertTrue(confirmationError.isDisplayed());
        Assert.assertEquals(confirmationError.getText(), "The password and confirmation password do not match.");
        return this;
    }
}