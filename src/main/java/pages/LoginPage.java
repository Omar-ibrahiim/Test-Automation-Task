package pages;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[@type= 'submit']");

    private By Validation = By.xpath("//h6[text()= 'Dashboard']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void Login(String username, String password)
    {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void Validate() {
       // driver.findElement(Validation).isDisplayed();
        System.out.print(driver.findElement(Validation).isDisplayed());

        //Assert.assertEquals(true, driver.findElement(Validation).isDisplayed());
    }

}

