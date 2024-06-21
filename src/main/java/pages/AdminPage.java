package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class AdminPage {
    private WebDriver driver;
    private By RecordsLocator = By.xpath("//span[@class='oxd-text oxd-text--span']");
    private By AddButtonLocator = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private By SelectRoleLocator = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
    private By Select = By.xpath("(//div[@role='listbox']//child::div)[2]");
    private By EmployeeNameLocator = By.xpath("//input[@placeholder='Type for hints...']");
    private By SelectStatusLocator = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");
    private By UsernameLocator = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By PasswordLocator = By.xpath("(//input[@type='password'])[1]");
    private By PasswordConfirmLocator = By.xpath("(//input[@type='password'])[2]");
    private By SaveButtonLocator = By.xpath("//button[@type='submit']");
    private By SearchUserLocator = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By ConfirmSearchButton = By.xpath("//button[@type='submit']");
    private By DeleteIconLocator = By.xpath("//i[@class='oxd-icon bi-trash']");
    private By DeleteConfirmLocator = By.xpath("//i[@class='oxd-icon bi-trash oxd-button-icon']");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public int GetRecordsNumbers(){
        String RecordsNumber = driver.findElement(RecordsLocator).getText();
        List<Integer> numbers = new ArrayList<>();

        // Regular expression to find all numbers in the text
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(RecordsNumber);
        if (matcher.find()) {
            String numberStr = matcher.group();
            return Integer.parseInt(numberStr);
        }
        return -1;
    }

    public void AddUser(String name, String password) {
        driver.findElement(AddButtonLocator).click();
        driver.findElement(SelectRoleLocator).click();
        driver.findElement(Select).click();
        driver.findElement(EmployeeNameLocator).sendKeys("a");
        driver.findElement(Select).click();
        driver.findElement(SelectStatusLocator).click();
        driver.findElement(Select).click();
        driver.findElement(UsernameLocator).sendKeys(name);
        driver.findElement(PasswordLocator).sendKeys(password);
        driver.findElement(PasswordConfirmLocator).sendKeys(password);
        driver.findElement(SaveButtonLocator).click();
    }

    public void SearchForUser(String name){
        driver.findElement(SearchUserLocator).sendKeys(name);
        driver.findElement(ConfirmSearchButton).click();

    }

    public void DeleteUser(){
        driver.findElement(DeleteIconLocator).click();
        driver.findElement(DeleteConfirmLocator).click();
        driver.findElement(RelativeLocator.with(By.tagName("button")).toLeftOf(ConfirmSearchButton)).click();
    }

}


