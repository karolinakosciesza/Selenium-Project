package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CharacteristicsPage extends HomePage {

    public CharacteristicsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".page-title h3")
    private WebElement pageHeaderElm;

    public CharacteristicsPage assertCharacteristicsUrl(String expUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), expUrl);
        return this;
    }

    public CharacteristicsPage assertCharacteristicsHeader() {
        Assert.assertTrue(pageHeaderElm.isDisplayed());
        Assert.assertEquals(pageHeaderElm.getText(), "Characteristics");
        return this;

    }
}


