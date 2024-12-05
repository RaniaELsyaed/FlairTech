package orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

     By UserNameField = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
     By PasswordField = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
     By LoginButton = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");

    public LoginPage(WebDriver driver) {

        this.driver = driver;

    }

    public void EnterUserName(String UserName) {
        driver.findElement(UserNameField).sendKeys(UserName);

    }

    public void EnterPassword(String Password){
        driver.findElement(PasswordField).sendKeys(Password);

    }
    public void ClickLoginButton(){
        driver.findElement(LoginButton).click();
    }


}
