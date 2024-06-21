package StepDefinition;

import Setup.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class TaskStepDefinition extends Setup {
    LoginPage loginPage;
    HomePage homePage;
    MainPage mainPage;
    AdminPage adminPage;
    public int RecordBeforeAdd;
    public int RecordAfterAdd;
    public int RecordAfterDelete;
    public int flag = 0;

    @Given("Login page is displayed")
    public void LoginPageIsDisplayed(){
        homePage = new HomePage(driver);
        homePage.LoginPageIsDisplayed();
    }

    @When("The user enters valid login credentials username {string} and password {string}")
    public void Login(String username, String password){
        loginPage = new LoginPage(driver);
        loginPage.Login(username, password);
    }

    @Then("Admin main page is displayed")
    @When("The user logged in")
    public void ValidateLogin(){
        loginPage = new LoginPage(driver);
        loginPage.Validate();
    }

    @Then("Navigate to Admin Screen")
    public void AdminScreen(){
        mainPage = new MainPage(driver);
        mainPage.navigateToAdminPage();
    }

    @Then("Get Records Number")
    public void GetRecords(){
        adminPage = new AdminPage(driver);
        int Records = adminPage.GetRecordsNumbers();
        System.out.println(Records);

        if (flag == 0){
            RecordBeforeAdd = Records;
        }
        if (flag == 1){
            RecordAfterAdd = Records;
        }
        if (flag == 2){
            RecordAfterDelete = Records;
        }
    }

    @Then("Add User with username {string} and password {string}")
    public void AddUser(String name, String password){
        adminPage = new AdminPage(driver);
        adminPage.AddUser(name, password);
        flag++;
    }

    @Then("Validate Records After Add")
    public void ValidateRecords(){
        Assert.assertEquals(RecordBeforeAdd+1, RecordAfterAdd);
    }

    @Then("Search for the user with {string}")
    public void Search(String name){
        adminPage = new AdminPage(driver);
        adminPage.SearchForUser(name);
    }

    @Then("Delete the new user")
    public void DeleteUser(){
        adminPage = new AdminPage(driver);
        adminPage.DeleteUser();
        flag++;
    }

    @Then("Validate Records After Delete")
    public void ValidateRecordsAfterDelete(){
        Assert.assertEquals(RecordAfterDelete+1, RecordAfterAdd);
    }

}
