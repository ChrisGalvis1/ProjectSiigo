package co.com.siigo.pages;

import co.com.siigo.ui.CrearClientePageElements;
import co.com.siigo.utils.Helpers;
import co.com.siigo.utils.SelectorElements;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class CrearClientePage extends PageObject {

    CrearClientePageElements crearClientePageElements;
    SelectorElements selectorElements;
    Helpers helpers;
    private int numeroAleatorio;
    private String tipoCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String identificacionCliente;
    private String ciudadCliente;

    public CrearClientePage() {
        this.crearClientePageElements = new CrearClientePageElements(getDriver());
        selectorElements = new SelectorElements(getDriver());
    }

    public void seleccionarTipoCliente(String tipoCliente) {
        waitFor(3).seconds();
        crearClientePageElements.getSeleccionarTipoPersona();
        this.tipoCliente = tipoCliente;
        waitFor(5).seconds();
    }

    public void ingresarNombreCliente(String nombreCliente) {
        waitFor(7).seconds();
        WebElement txtNombreCliente = crearClientePageElements.getIngresarNombreCliente();
        txtNombreCliente.sendKeys(nombreCliente);
        this.nombreCliente = nombreCliente;
        waitFor(1).seconds();
    }

    public void ingresarApellidoCliente(String apellidoCliente) {
        WebElement txtApellidoCliente = crearClientePageElements.getIngresarApellidoCliente();
        txtApellidoCliente.sendKeys(apellidoCliente);
        this.apellidoCliente = apellidoCliente;
        waitFor(1).seconds();
    }

    public void ingresarIdentificacionCliente(String identificacionCliente) {
        WebElement txtIdentificacionCliente = crearClientePageElements.getIngresarIdentificacionCliente();
        numeroAleatorio = helpers.generarNumeroAleatorio();
        String capuraNumeroAleatorio = String.valueOf(numeroAleatorio);
        String numeroConcatenadoIdentificacion = identificacionCliente+capuraNumeroAleatorio;
        txtIdentificacionCliente.sendKeys(numeroConcatenadoIdentificacion);
        this.identificacionCliente = numeroConcatenadoIdentificacion;
        waitFor(1).seconds();
    }

    public void ingresarCiudadCliente(String ciudadCliente) {
        WebElement txtSeleccionarCampoCiudadCliente = crearClientePageElements.getSeleccionarCampoCiudadCliente();
        txtSeleccionarCampoCiudadCliente.click();
        waitFor(1).seconds();
        crearClientePageElements.getIngresarCiudadCliente(ciudadCliente);
        waitFor(5).seconds();
        crearClientePageElements.getSeleccionarCiudadRetornada();
        this.ciudadCliente = ciudadCliente;
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

    public String getTipoCliente() {
        return tipoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public String getIdentifacionCliente() {
        return identificacionCliente;
    }

    public String getCiudadCliente() {
        return ciudadCliente;
    }

}
