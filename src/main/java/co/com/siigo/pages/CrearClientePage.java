package co.com.siigo.pages;

import co.com.siigo.ui.CrearClientePageElements;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class CrearClientePage extends PageObject {

    CrearClientePageElements crearClientePageElements;

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
        waitFor(2).seconds();
    }

    public void ingresarApellidoCliente(String apellidoCliente) {
        WebElement txtApellidoCliente = crearClientePageElements.getIngresarApellidoCliente();
        txtApellidoCliente.sendKeys(apellidoCliente);
        waitFor(2).seconds();
    }

    public void ingresarIdentificacionCliente(String identificacionCliente) {
        WebElement txtIdentificacionCliente = crearClientePageElements.getIngresarIdentificacionCliente();
        txtIdentificacionCliente.sendKeys(identificacionCliente);
        waitFor(2).seconds();
    }

    public void ingresarCiudadCliente(String ciudadCliente) {
        WebElement txtSeleccionarCampoCiudadCliente = crearClientePageElements.getSeleccionarCampoCiudadCliente();
        WebElement txtCiudadCliente = crearClientePageElements.getIngresarCiudadCliente();
        txtSeleccionarCampoCiudadCliente.click();
        waitFor(5).seconds();
        txtCiudadCliente.sendKeys(ciudadCliente);
        waitFor(5).seconds();
    }

    public void ingresarNombreContactoCliente(String nombreContactoCliente) {
    }
}
