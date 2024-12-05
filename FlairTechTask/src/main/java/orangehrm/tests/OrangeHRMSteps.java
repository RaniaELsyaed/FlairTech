package orangehrm.tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import orangehrm.pages.AdminPage;
import orangehrm.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class OrangeHRMSteps {
    WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;

String UserName= "Admin";
String Password="admin123";

int RecourdsCounterBefore;
int RecourdsCounterAfter;

    @Given("the user navigates to the OrangeHRM login page")
    public void theUserNavigatesToTheOrangeHRMLoginPage() {
        System.setProperty("webdriver.chrome.", "path_to_chromedriver");
       driver = new ChromeDriver();
       loginPage = new LoginPage(driver);
      loginPage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      loginPage.driver.manage().window().maximize();
      loginPage.driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials() {
       loginPage.EnterUserName(UserName);
        loginPage.EnterPassword(Password);
        loginPage.ClickLoginButton();
    }

    @And("the user navigates to the Admin tab")
    public void theUserNavigatesToTheAdminTab() {
        adminPage = new AdminPage(driver);
        adminPage.AdminTap();
    }

    @Then("the user gets the number of records")
    public void theUserGetsTheNumberOfRecords() {
       RecourdsCounterBefore= adminPage.GetNumberOfRecords();
    }

    @When("the user adds a new user")
    public void theUserAddsANewUser() throws InterruptedException {
      // adminPage.ClickAddButton();
      // adminPage.AddNewUser("ESS","Roberto Mr. Adams","Enabled","Tester","aaqq122!","aaqq122!");
    }

    @Then("the number of records should increase by {int}")
    public void theNumberOfRecordsShouldIncreaseBy(int arg0) {

    }

    @When("the user deletes the new user")
    public void theUserDeletesTheNewUser() {
        RecourdsCounterBefore = adminPage.GetNumberOfRecords();

    adminPage.DeleteUser("Huynh Phuong");
    }

    @Then("the number of records should decrease by {int}")
    public void theNumberOfRecordsShouldDecreaseBy(int arg0) {
        RecourdsCounterAfter = adminPage.GetNumberOfRecords();
        Assert.assertEquals(RecourdsCounterBefore - 1, RecourdsCounterAfter);
    }
}
