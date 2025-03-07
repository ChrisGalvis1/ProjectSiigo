package co.com.siigo.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
    }

    public WebElement getIngresarNombreCliente() {
        WebElement txtNombreCliente = (WebElement) js.executeScript(
                "return document.querySelectorAll('siigo-textfield-web')[1].shadowRoot.querySelector('input.mdc-text-field__input');");
        return txtNombreCliente;
    }

    public WebElement getIngresarApellidoCliente() {
        WebElement txtApellidoCliente = (WebElement) js.executeScript(
                "return document.querySelectorAll('siigo-textfield-web')[2].shadowRoot.querySelector('input.mdc-text-field__input');");
        return txtApellidoCliente;
    }

    public WebElement getIngresarIdentificacionCliente() {
        WebElement txtIdentificacionCliente = (WebElement) js.executeScript(
                "return document.querySelector('siigo-identification-input-web').shadowRoot.querySelector('input.mdc-text-field__input');");
        return txtIdentificacionCliente;
    }

    public WebElement getSeleccionarCampoCiudadCliente() {
        WebElement txtSeleccionarCampoCiudadCliente = (WebElement) js.executeScript(
                "return document.querySelector('siigo-autocomplete-web').shadowRoot.querySelector('#labelAutocompleteSelectItemcity');");
        return txtSeleccionarCampoCiudadCliente;
    }

    public void getIngresarCiudadCliente(String CiudadCliente) {
        WebElement txtCiudadCliente = (WebElement) js.executeScript(
                "return document.querySelector('siigo-autocomplete-web').shadowRoot.querySelector('input.mdc-text-field__input');");
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", txtCiudadCliente);
        txtCiudadCliente.click();
        txtCiudadCliente.sendKeys(CiudadCliente);
        wait.until(driver -> (Boolean) js.executeScript(
                "return document.querySelector('siigo-autocomplete-web').shadowRoot.querySelector('#tableAutocompletecity tbody tr') !== null;"));
    }

    public void getSeleccionarCiudadRetornada() {
        WebElement autocompleteWeb = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("siigo-autocomplete-web")));

        WebElement firstCityOption = (WebElement) ((JavascriptExecutor) driver).executeScript(
                "let dropdown = document.querySelector('siigo-autocomplete-web').shadowRoot;" +
                        "let rows = dropdown.querySelectorAll('#tableAutocompletecity tbody tr');" +
                        "return rows.length > 0 ? rows[0].querySelector('td') : null;");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", firstCityOption);
        firstCityOption.click();
    }

    public void getSeleccionarMenuContacto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnContactos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.collapsible.closed.card.clickable")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnContactos);
        wait.until(ExpectedConditions.elementToBeClickable(btnContactos)).click();
    }

    public WebElement getIngresarNombreContacto() {
        WebElement txtContactoCliente = (WebElement) js.executeScript(
                "return document.querySelectorAll('siigo-textfield-web')[12].shadowRoot.querySelector('input.mdc-text-field__input');");
        return txtContactoCliente;
    }

    public void getBotonGuardar() {
        WebElement btnGuardar = driver.findElement(By.xpath("//button[contains(text(),'Guardar')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnGuardar);
    }
}
