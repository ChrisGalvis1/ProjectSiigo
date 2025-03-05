package co.com.siigo.pages;

import co.com.siigo.ui.HomePageElements;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageObject {

    HomePageElements homePageElements;

    public HomePage(WebDriver driver) {
        super(driver);
        this.homePageElements = new HomePageElements(driver);
    }

    public void ingresarModuloCrearCliente() {
        waitFor(5).seconds();
        WebElement btnCrear = homePageElements.getBotonCrear();
        btnCrear.click();
        waitFor(4).seconds();
        WebElement btnCliente = homePageElements.getOpcionCliente();
        btnCliente.click();
        waitFor(4).seconds();
    }
}
