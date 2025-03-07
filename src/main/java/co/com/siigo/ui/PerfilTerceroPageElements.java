package co.com.siigo.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class PerfilTerceroPageElements extends PageObject {

    @FindBy(xpath = "//span[contains(@class, 'text green')]")
    WebElementFacade lblEstadoCliente;

    @FindBy(xpath = "//label[text()='Tipo']//following-sibling::p")
    WebElementFacade lblTipoCliente;

    @FindBy(xpath = "(//label[text()='Nombres']//following-sibling::p)[1]")
    WebElementFacade lblNombreCliente;

    @FindBy(xpath = "(//label[text()='Apellidos']//following-sibling::p)[1]")
    WebElementFacade lblApellidoCliente;

    @FindBy(xpath = "(//label[text()='# Identificación']//following-sibling::p)[1]")
    WebElementFacade lblIdentificacionCliente;

    @FindBy(xpath = "(//label[text()='Ciudad']//following-sibling::p)[1]")
    WebElementFacade lblCiudadCliente;


    public WebElement getlblEstadoCliente(){
        return lblEstadoCliente;
    }

    public WebElement getlblTipoCliente(){
        return lblTipoCliente;
    }

    public WebElement getlblNombreCliente(){
        return lblNombreCliente;
    }

    public WebElement getlblApellidoCliente(){
        return lblApellidoCliente;
    }

    public WebElement getlblIdentificacionCliente(){
        return lblIdentificacionCliente;
    }

    public WebElement getlblCiudadCliente(){
        return lblCiudadCliente;
    }
}
