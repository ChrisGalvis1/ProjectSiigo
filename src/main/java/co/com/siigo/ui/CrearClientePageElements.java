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

    public WebElement getIngresarIdentificacionCliente(){
        WebElement txtIdentificacionCliente = (WebElement) js.executeScript(
                "return document.querySelector('siigo-identification-input-web').shadowRoot.querySelector('input.mdc-text-field__input');");
        return txtIdentificacionCliente;
    }

    public WebElement getSeleccionarCampoCiudadCliente(){
        WebElement txtSeleccionarCampoCiudadCliente = (WebElement) js.executeScript(
                "return document.querySelector('siigo-autocomplete-web').shadowRoot.querySelector('#labelAutocompleteSelectItemcity');");
        return txtSeleccionarCampoCiudadCliente;
    }

    public WebElement getIngresarCiudadCliente(){
        WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("siigo-autocomplete-web")));
        WebElement txtCiudadCliente = (WebElement) js.executeScript(
                "return arguments[0].shadowRoot.querySelector('#inputAutocompletecity');", shadowHost);
        js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", txtCiudadCliente);
        /*WebElement txtCiudadCliente = (WebElement) js.executeScript(
                "return document.querySelector('siigo-autocomplete-web').shadowRoot.querySelector('#inputAutocompletecity');");*/
        return txtCiudadCliente;
    }
}
