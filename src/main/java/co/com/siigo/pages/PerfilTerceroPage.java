package co.com.siigo.pages;

import co.com.siigo.ui.PerfilTerceroPageElements;
import co.com.siigo.utils.SelectorElements;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class PerfilTerceroPage extends PageObject {

    PerfilTerceroPageElements perfilTerceroPageElements;
    SelectorElements selectorElements;
    //CrearClientePage crearClientePage;
    CrearClientePage crearClientePage = new CrearClientePage();
    String tipoCliente = crearClientePage.getTipoCliente();
    String nombreCliente = crearClientePage.getNombreCliente();
    String apellidoCliente = crearClientePage.getApellidoCliente();
    String identificacionCliente = crearClientePage.getIdentifacionCliente();
    String ciudadCliente = crearClientePage.getCiudadCliente();

    public PerfilTerceroPage(){
        this.perfilTerceroPageElements = new PerfilTerceroPageElements();
        selectorElements = new SelectorElements(getDriver());
    }

    public void validarClienteCreado() {
        WebElement lblEstadoCliente = perfilTerceroPageElements.getlblEstadoCliente();
        String capturarEstado = lblEstadoCliente.getText();
        Assert.assertTrue(capturarEstado.equals("Activo"));
        selectorElements.bordearElemento((WebElementFacade) lblEstadoCliente);
    }

    public void validarCamposDiligenciados() {
        WebElement lblTipoCliente = perfilTerceroPageElements.getlblTipoCliente();
        WebElement lblNombreCliente = perfilTerceroPageElements.getlblNombreCliente();
        WebElement lblApellidoCliente = perfilTerceroPageElements.getlblApellidoCliente();
        WebElement lblIdentificacionCliente = perfilTerceroPageElements.getlblIdentificacionCliente();
        WebElement lblCiudadCliente = perfilTerceroPageElements.getlblCiudadCliente();
        String capturaTipoCliente = lblTipoCliente.getText();
        String capturaNombreCliente = lblNombreCliente.getText();
        String capturaApellidoCliente = lblApellidoCliente.getText();
        String capturaIdentiicacionCliente = lblIdentificacionCliente.getText();
        String capturaCiudadCliente = lblCiudadCliente.getText();
        Assert.assertTrue(tipoCliente.equals(capturaTipoCliente));
        selectorElements.bordearElemento((WebElementFacade) lblTipoCliente);
        Assert.assertTrue(nombreCliente.equals(capturaNombreCliente));
        selectorElements.bordearElemento((WebElementFacade) lblNombreCliente);
        Assert.assertTrue(apellidoCliente.equals(capturaApellidoCliente));
        selectorElements.bordearElemento((WebElementFacade) lblApellidoCliente);
        Assert.assertTrue(identificacionCliente.equals(capturaIdentiicacionCliente));
        selectorElements.bordearElemento((WebElementFacade) lblIdentificacionCliente);
        Assert.assertTrue(ciudadCliente.equals(capturaCiudadCliente));
        selectorElements.bordearElemento((WebElementFacade) lblCiudadCliente);
    }
}
