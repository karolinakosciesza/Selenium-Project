package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage {
    protected WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//h2[text()='DEMO PROJECT']")
    private WebElement demoProjectHeader;

    public DashboardPage assertDashboardUrl(String expUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), expUrl);
        return this;
    }

    public DashboardPage assertDemoProjectIsShown() {
        Assert.assertTrue(demoProjectHeader.isDisplayed());
        return this;
    }
}

