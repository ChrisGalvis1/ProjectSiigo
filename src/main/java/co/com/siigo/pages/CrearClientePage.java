package co.com.siigo.pages;

import co.com.siigo.ui.CrearClientePageElements;
import co.com.siigo.utils.SelectorElements;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import co.com.siigo.ui.CrearClientePageElements;

public class CrearClientePage extends PageObject {

    CrearClientePageElements crearClientePageElements;
    SelectorElements selectorElements;

    public CrearClientePage() {
        this.crearClientePageElements = new CrearClientePageElements(getDriver());
    }

    public void seleccionarTipoCliente(String tipoCliente) {
        waitFor(3).seconds();
        crearClientePageElements.getSeleccionarTipoPersona();
        waitFor(5).seconds();
    }

    public void ingresarNombreCliente(String nombreCliente) {
        waitFor(7).seconds();
        WebElement txtNombreCliente = crearClientePageElements.getIngresarNombreCliente();
        txtNombreCliente.sendKeys(nombreCliente);
        waitFor(1).seconds();
    }

    public void ingresarApellidoCliente(String apellidoCliente) {
        WebElement txtApellidoCliente = crearClientePageElements.getIngresarApellidoCliente();
        txtApellidoCliente.sendKeys(apellidoCliente);
        waitFor(1).seconds();
    }

    public void ingresarIdentificacionCliente(String identificacionCliente) {
        WebElement txtIdentificacionCliente = crearClientePageElements.getIngresarIdentificacionCliente();
        txtIdentificacionCliente.sendKeys(identificacionCliente);
        waitFor(1).seconds();
    }

    public void ingresarCiudadCliente(String ciudadCliente) {
        WebElement txtSeleccionarCampoCiudadCliente = crearClientePageElements.getSeleccionarCampoCiudadCliente();
        txtSeleccionarCampoCiudadCliente.click();
        waitFor(1).seconds();
        crearClientePageElements.getIngresarCiudadCliente(ciudadCliente);
        waitFor(5).seconds();
        crearClientePageElements.getSeleccionarCiudadRetornada();
        waitFor(1).seconds();
    }

    public void ingresarNombreContactoCliente(String nombreContactoCliente) {
        crearClientePageElements.getSeleccionarMenuContacto();
        waitFor(1).seconds();
        WebElement txtContactoCliente = crearClientePageElements.getIngresarNombreContacto();
        txtContactoCliente.sendKeys(nombreContactoCliente);
        waitFor(1).seconds();
    }

    public void guardarClienteNuevo() {
        crearClientePageElements.getBotonGuardar();
        waitFor(5).seconds();
    }

    public void validarClienteCreado() {
    }
}
