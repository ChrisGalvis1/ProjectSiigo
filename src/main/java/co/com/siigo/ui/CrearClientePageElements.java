package co.com.siigo.ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CrearClientePageElements extends PageObject {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public CrearClientePageElements(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void getSeleccionarTipoPersona() {
        // Accede al Shadow DOM del dropdown
        WebElement shadowHost = getDriver().findElement(By.tagName("siigo-dropdownlist-web"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        // Ubica el elemento que abre el dropdown
        WebElement dropdown = shadowRoot.findElement(By.cssSelector("div.mdc-select__anchor"));

        // Hacer scroll hasta el elemento
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", dropdown);

        // Intentar hacer clic con JavaScript
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", dropdown);

        // Verificar si el dropdown se abrió correctamente
        boolean isDropdownOpen = dropdown.getAttribute("aria-expanded").equals("true");
        if (!isDropdownOpen) {
            System.out.println("⚠️ El dropdown NO se abrió, intentando nuevamente...");
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", dropdown);
        }
    }

    public WebElement getIngresarNombreCliente(){
        WebElement txtNombreCliente = (WebElement) js.executeScript(
                "return document.querySelectorAll('siigo-textfield-web')[1].shadowRoot.querySelector('input.mdc-text-field__input');");
        return txtNombreCliente;
    }

    public WebElement getIngresarApellidoCliente(){
        WebElement txtApellidoCliente = (WebElement) js.executeScript(
                "return document.querySelectorAll('siigo-textfield-web')[2].shadowRoot.querySelector('input.mdc-text-field__input');");
        return txtApellidoCliente;
    }

}
