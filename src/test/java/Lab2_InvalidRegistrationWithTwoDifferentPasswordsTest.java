import org.testng.annotations.Test;
import pages.LoginPage;

public class Lab2_InvalidRegistrationWithTwoDifferentPasswordsTest extends SeleniumBaseTest{

    @Test
    public void InvalidRegistrationWithTwoDifferentPasswords(){
        new LoginPage(driver)
                .goToRegister()
                .typeEmail("Test1@wp.pl")
                .typePassword("Testtest1..")
                .typeConfirmPassword("Testtesst1...")
                .submitRegisterWithFailure()
                .assertConfirmationErrorIsShown();
    }
}
