package pages;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private By AdminButton = By.xpath("//a[@href=\"/web/index.php/admin/viewAdminModule\"]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAdminPage(){
        driver.findElement(AdminButton).click();
    }

}
