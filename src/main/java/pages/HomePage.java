package pages;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){

        this.driver = driver;
    }

    public void LoginPageIsDisplayed(){
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //clickLink("Form Authentication");
        //return new LoginPage(driver);
    }

}
