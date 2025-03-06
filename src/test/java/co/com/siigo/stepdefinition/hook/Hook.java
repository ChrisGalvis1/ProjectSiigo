package co.com.siigo.stepdefinition.hook;

import co.com.siigo.pages.LoginPage;
import co.com.siigo.utils.LoginConfig;
import io.cucumber.java.en.Given;

public class Hook {

    LoginPage loginPage;
    LoginConfig loginConfig;

    @Given("abre la plataforma de Siigo")
    public void abreLaPlataformaDeSiigo() {
        String baseUrl = loginConfig.getBaseUrl();
        loginPage.openAt(baseUrl);
    }

    @Given("se loguea con usuario y contrasena")
    public void seLogueaConUsuarioYContrasena() {
        String username = loginConfig.getUsername();
        String password = loginConfig.getPassword();
        loginPage.ingresaUsuario(username);
        loginPage.ingresaContrasena(password);
        loginPage.darClicContinuar();
    }
}
