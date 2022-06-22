package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProcessesPage extends HomePage {
    protected WebDriver driver;

    public ProcessesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".page-title h3")
    private WebElement pageHeaderElm;

    public ProcessesPage assertProcessesUrl(String expUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), expUrl);
        return this;
    }

    public ProcessesPage assertProcessesHeader() {
        Assert.assertTrue(pageHeaderElm.isDisplayed());
        Assert.assertEquals(pageHeaderElm.getText(), "Processes");
        return this;

    }

}
