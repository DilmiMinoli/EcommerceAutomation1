
package test;

import base.BaseTest;
import pages.LoginPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
            driver.getCurrentUrl().contains("inventory.html"),
            "User should navigate to the inventory page"
        );
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("invalid_user", "wrong_password");

        String actualMessage = loginPage.getErrorMessage();

        Assert.assertTrue(
            actualMessage.contains(
                "Username and password do not match"
            ),
            "Expected login error was not displayed"
        );
    }
    
    @Test
    public void EmptyUserNameAndPasswordTest() {
    	LoginPage loginPage = new LoginPage(driver);

    	   // Click login without entering username or password
        loginPage.clickLogin();

        String actualMessage = loginPage.getErrorMessage();
        
        Assert.assertTrue(
            actualMessage.contains(
                "Username is required"
            ),
            "Expected username validation message was not displayed"
        );
    	
    }
}
