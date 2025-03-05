package co.com.siigo.ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageElements extends PageObject{

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePageElements(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getBotonCrear() {
        WebElement shadowHost1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("siigo-header-molecule")));
        SearchContext shadowRoot1 = shadowHost1.getShadowRoot();

        WebElement shadowHost2 = shadowRoot1.findElement(By.cssSelector("siigo-button-atom[data-id='header-create-button']"));
        SearchContext shadowRoot2 = shadowHost2.getShadowRoot();

        return shadowRoot2.findElement(By.cssSelector("button.btn-element"));
    }

    public WebElement getOpcionCliente() {
        WebElement shadowHost1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("siigo-header-molecule")));
        SearchContext shadowRoot1 = shadowHost1.getShadowRoot();

        // Aquí está el menú desplegable, NO está dentro del mismo shadowRoot2 del botón
        WebElement menuDesplegable = shadowRoot1.findElement(By.cssSelector("siigo-header-create-button-dropdown"));

        return menuDesplegable.findElement(By.cssSelector("div.titles-create[data-value='Clientes']"));
    }
}
