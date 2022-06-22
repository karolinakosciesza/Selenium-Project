package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LoginPage {
    public static String assertLoginErrorIsShown;
    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(id = "Password")
    private WebElement passwordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement loginBtn;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;

    @FindBy(css = "a[href*=Register]")
    private WebElement registerBtn;

    public CreateAccountPage goToRegister() {
        registerBtn.click();
        return new CreateAccountPage(driver);
    }

    public LoginPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);

        return this;
    }

    public LoginPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);

        return this;
    }

    public HomePage submitLogin() {
        loginBtn.click();
        return new HomePage(driver);
    }

    public LoginPage submitLoginWithFailure() {
        loginBtn.click();
        return this;
    }

    public LoginPage assertLoginErrorIsShown(String errorText) {
        boolean doesErrorExists = false;

        for (WebElement loginError : loginErrors) {
            if (loginError.getText().equals(errorText)) {
                doesErrorExists = true;
                break;
            }
        }
        Assert.assertTrue(doesErrorExists);
        return this;
    }
}

