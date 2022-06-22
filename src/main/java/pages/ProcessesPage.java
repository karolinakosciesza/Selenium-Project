package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProcessesPage extends HomePage {


    public ProcessesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Add new process")
    private WebElement addProcessBtn;

    @FindBy(css = ".page-title h3")
    private WebElement pageHeader;



    public CreateProcessPage clickAddProcess() {
        addProcessBtn.click();

        return new CreateProcessPage(driver);
    }

    public ProcessesPage assertProcessesHeader() {
        Assert.assertEquals(pageHeader.getText(), "Processes");

        return this;
    }

    public ProcessesPage assertProcessesUrl(String pageUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl);

        return this;
    }
}

