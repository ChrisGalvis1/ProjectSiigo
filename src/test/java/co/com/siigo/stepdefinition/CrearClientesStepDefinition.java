package co.com.siigo.stepdefinition;

import co.com.siigo.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CrearClientesStepDefinition {

    HomePage homePage;

    @When("ingresa al modulo de crear clientes")
    public void ingresaAlModuloDeCrearClientes() {
        homePage.ingresarModuloCrearCliente();
    }

    @When("digita los datos para realizar el registro del cliente nuevo")
    public void digitaLosDatosParaRealizarElRegistroDelClienteNuevo(io.cucumber.datatable.DataTable dataTable) {
    }

    @Then("validar la creacion del cliente")
    public void validarLaCreacionDelCliente() {
    }

    @Then("identificar tecnica utilizada {string}")
    public void identificarTecnicaUtilizada(String string) {
    }
}
