package orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;


public class AdminPage {

    By AdminTap = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");

    By RecordCount = By.xpath("//span[@class='oxd-text oxd-text--span']");
    By AddButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");

    By UserRole = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div");
    By EmployeeName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    By Status = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]");
    By UserName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    By Password = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    By ConfirmPass = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");

    public int NumberOfRecords;

    By SelectUser = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-container > div > div.oxd-table-body > div:nth-child(1) > div > div:nth-child(1) > div > div > label > span > i");
    By DeleteBtn = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/button");
    By ConfirmDel = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]");


    By SearchField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
    By SearchButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");


    public WebDriver driver;
    public AdminPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void AdminTap()
    {
        driver.findElement(AdminTap).click();

    }

    public int GetNumberOfRecords()
    {
        String NumOfRecords = driver.findElement(RecordCount).getText();
        char RecordsCounter = NumOfRecords.charAt(1);
            System.out.println(RecordsCounter);
            NumberOfRecords= Integer.parseInt(String.valueOf(RecordsCounter));
        return NumberOfRecords;
    }

    public void ClickAddButton()
    {
        driver.findElement(AddButton).click();
    }

    public void AddNewUser(String userRole,String employeeName,String status,String userName,String password,String confirmPass) throws InterruptedException {
        WebElement RoleDrop = driver.findElement(UserRole);
        RoleDrop.click();

        RoleDrop.sendKeys("Admin");
        Thread.sleep(500);
        RoleDrop.sendKeys(Keys.TAB);


        driver.findElement(EmployeeName).click();
        driver.findElement(EmployeeName).sendKeys(employeeName);


        WebElement StatusDrop = driver.findElement(Status);
        StatusDrop.click();
        StatusDrop.sendKeys(status);

        driver.findElement(UserName).sendKeys(userName);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(ConfirmPass).sendKeys(confirmPass);


    }

    public void SearchUser(String UserName){
        driver.findElement(SearchField).sendKeys(UserName);
        driver.findElement(SearchButton).click();
    }

    public void DeleteUser(String UserN){

        SearchUser(UserN);

        driver.findElement(SelectUser).click();
        driver.findElement(DeleteBtn).click();
        driver.findElement(ConfirmDel).click();
    }



}
