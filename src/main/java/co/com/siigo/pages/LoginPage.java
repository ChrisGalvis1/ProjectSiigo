package co.com.siigo.pages;

import co.com.siigo.ui.LoginPageElements;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends LoginPageElements {


    public void ingresaUsuario(String username) {
        try {
            waitFor(7).seconds();
            txtUsuario.sendKeys(username);
        }catch (NoSuchElementException e){
            Assert.fail();
        }
    }

    public void ingresaContrasena(String password) {
        try {
            txtContrasena.sendKeys(password);
        }catch (NoSuchElementException e){
            Assert.fail();
        }
    }

    public void darClicContinuar() {
        try {
            btnContinuar.click();
        }catch (NoSuchElementException e){
            Assert.fail();
        }
    }
}
