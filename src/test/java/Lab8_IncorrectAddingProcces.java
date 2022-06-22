import org.testng.annotations.Test;
import pages.LoginPage;

public class Lab8_IncorrectAddingProcces extends SeleniumBaseTest  {

    @Test
    public void addProcessWithFailureTest(){
        String tooLongProcessName = "abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        String expErrorMessage = "The field Name must be a string with a minimum length of 3 and a maximum length of 30.";

        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToProcesses()
                .clickAddProcess()
                .typeName(tooLongProcessName)
                .submitCreateWithFailure()
                .assertProcessNameError(expErrorMessage);
    }
}
