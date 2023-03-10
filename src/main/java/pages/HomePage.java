package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".profile_info>h2")
    public WebElement welcomeElm;

    @FindBy(css = ".menu-workspace")
    private WebElement wrokspaceNav;

    @FindBy(css = ".menu-home")
    private WebElement HomeNav;

    @FindBy (linkText = "Dashboard")
    private WebElement DashboardMenu;

    @FindBy(css = "a[href$=Projects]")
    private WebElement processesMenu;

    @FindBy(css = "a[href$=Characteristics]")
    private WebElement characteristicsMenu;

    private boolean isParentExpanded(WebElement menuLink){
        WebElement parent = menuLink.findElement(By.xpath("./.."));

        return parent.getAttribute("class").contains("active");
    }
    public ProcessesPage goToProcesses(){
        if(!isParentExpanded(wrokspaceNav)) {
            wrokspaceNav.click();
        }
        processesMenu.click();
        return new ProcessesPage(driver);
    }
    public CharacteristicsPage goToCharacteristics(){
        if(!isParentExpanded(wrokspaceNav)) {
            wrokspaceNav.click();
        }
        characteristicsMenu.click();
        return new CharacteristicsPage(driver);
    }

    public DashboardPage goToDashboard() {
        if (!isParentExpanded(HomeNav)) {
            HomeNav.click();
        }
        DashboardMenu.click();
        return new DashboardPage(driver);
    }
}
