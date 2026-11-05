
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    private final WebDriver driver;

    private final By backpackButton =
            By.id("add-to-cart-sauce-labs-backpack");

    private final By cartBadge =
            By.className("shopping_cart_badge");

    private final By cartLink =
            By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBackpackToCart() {

        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(15)
        );

        WebElement backpackButton = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("add-to-cart-sauce-labs-backpack")
            )
        );

        backpackButton.click();
    }

    public String getCartCount() {
        return driver.findElement(cartBadge).getText();
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }
}
