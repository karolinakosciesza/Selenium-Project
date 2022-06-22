import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class Lab1_ValidRegisterTest extends SeleniumBaseTest {
    String randomEmail = UUID.randomUUID().toString().substring(0, 10);
    String randomPassword = UUID.randomUUID().toString().substring(0, 10);

    @Test
    public void validRegistrationTest() {
        new LoginPage(driver)
                .goToRegister()
                .typeEmail(randomEmail)
                .typePassword(randomPassword)
                .typeConfirmPassword(randomPassword)
                .submitRegister();
    }
}
