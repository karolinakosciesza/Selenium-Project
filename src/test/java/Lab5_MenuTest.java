import org.testng.annotations.Test;
import pages.LoginPage;

public class Lab5_MenuTest extends SeleniumBaseTest{
    @Test
    public void menuTest() {
        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToProcesses()
                .assertProcessesUrl("http://localhost:4444/Projects")
                .assertProcessesHeader()
                .goToCharacteristics()
                .assertCharacteristicsUrl("http://localhost:4444/Characteristics")
                .assertCharacteristicsHeader()
                .goToDashboard()
                .assertDashboardUrl("http://localhost:4444/")
                .assertDemoProjectIsShown();


    }
}

