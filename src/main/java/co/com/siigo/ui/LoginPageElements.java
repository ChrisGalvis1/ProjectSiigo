package co.com.siigo.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPageElements extends PageObject {

    @FindBy(xpath = "//input[@id='siigoSignInName']")
    public WebElementFacade txtUsuario;

    @FindBy(xpath = "//input[@id='siigoPassword']")
    public WebElementFacade txtContrasena;

    @FindBy(xpath = "//button[@id='siigoNext']")
    public WebElementFacade btnContinuar;
}
