import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;

public class Lab3_InvalidRegistrationWithInvalidPasswords extends SeleniumBaseTest{

    @DataProvider
    public Object[][] getWrongPasswords() {
        return new Object[][]{
                {"testtest1.", "Passwords must have at least one uppercase ('A'-'Z')."},
                {"Testtest.", "Passwords must have at least one digit ('0'-'9')."},
                {"Testtest9", "Passwords must have at least one non alphanumeric character."},
        };
    }

            @Test(dataProvider = "getWrongPasswords")
            public void invalidPasswordsTest(String wrongPassword, String expectedError) {
                new LoginPage(driver)
                        .goToRegister()
                        .typeEmail("Test1@wp.pl")
                        .typePassword(wrongPassword)
                        .typeConfirmPassword(wrongPassword)
                        .submitRegisterWithFailure()
                        .assertRegisterErrorIsShown(expectedError);
        }
    }





