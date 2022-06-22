import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Lab4_CorrectLoginTest extends SeleniumBaseTest {
    @Test
    public void correctLoginTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmail("test@test.com");
        loginPage.typePassword("Test1!");
        HomePage homePage = loginPage.submitLogin();

        Assert.assertTrue(homePage.welcomeElm.isDisplayed(), "Welcome element is not shown.");
        Assert.assertTrue(homePage.welcomeElm.getText().contains("Welcome"), "Welcome element text: '" + homePage.welcomeElm.getText() + "' does not contain word 'Welcome'");

    }
}
