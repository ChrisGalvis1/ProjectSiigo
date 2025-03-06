package co.com.siigo.ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageElements extends PageObject {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePageElements(WebDriver driver) {
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

    public void getOpcionCliente() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Acceder al Shadow DOM del siigo-header-molecule
        WebElement shadowHost1 = driver.findElement(By.cssSelector("siigo-header-molecule"));
        SearchContext shadowRoot1 = shadowHost1.getShadowRoot();

        // Acceder al Shadow DOM del botón "Crear"
        WebElement shadowHost2 = shadowRoot1.findElement(By.cssSelector("siigo-header-create-button-dropdown"));

        // Seleccionar el enlace "Clientes" dentro del dropdown (SIN otro shadowRoot)
        WebElement opcionCliente = shadowHost2.findElement(By.cssSelector("a[data-value='Clientes']"));

        // Desplazar hasta el elemento si es necesario
        js.executeScript("arguments[0].scrollIntoView(true);", opcionCliente);

        // Forzar el clic con JavaScript para evitar bloqueos
        js.executeScript("arguments[0].click();", opcionCliente);
    }
}
