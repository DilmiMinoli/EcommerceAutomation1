package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
    private final WebDriver driver;
    
//Locators
    private final By username =
            By.id("user-name");

    private final By password =
            By.id("password");

    private final By loginButton =
            By.id("login-button");

    private final By errorMessage =
            By.cssSelector("[data-test='error']");

 // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

 // Enter Username
    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }
    
 // Enter password
    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    //Click LoginButton
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // Complete login
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}

