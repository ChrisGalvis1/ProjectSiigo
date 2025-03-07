package co.com.siigo.stepdefinition;

import co.com.siigo.pages.CrearClientePage;
import co.com.siigo.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class CrearClientesStepDefinition {

    HomePage homePage;
    CrearClientePage crearClientePage;

    @When("ingresa al modulo de crear clientes")
    public void ingresaAlModuloDeCrearClientes() {
        homePage.ingresarModuloCrearCliente();
    }

    @When("digita los datos para realizar el registro del cliente nuevo")
    public void digitaLosDatosParaRealizarElRegistroDelClienteNuevo(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String tipoCliente = row.get("Tipo");
            String nombreCliente = row.get("Nombre");
            String apellidoCliente = row.get("Apellido");
            String identificacionCliente = row.get("Identificacion");
            String ciudadCliente = row.get("Ciudad");
            String nombreContactoCliente = row.get("NombreContacto");
            //crearClientePage.seleccionarTipoCliente(tipoCliente);
            crearClientePage.ingresarNombreCliente(nombreCliente);
            crearClientePage.ingresarApellidoCliente(apellidoCliente);
            crearClientePage.ingresarIdentificacionCliente(identificacionCliente);
            crearClientePage.ingresarCiudadCliente(ciudadCliente);
            crearClientePage.ingresarNombreContactoCliente(nombreContactoCliente);
        }
    }

    @Then("validar la creacion del cliente")
    public void validarLaCreacionDelCliente() {
        crearClientePage.guardarClienteNuevo();
        crearClientePage.validarClienteCreado();
    }

    @Then("identificar tecnica utilizada {string}")
    public void identificarTecnicaUtilizada(String string) {
    }
}
