package co.com.siigo.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "co.com.siigo.stepdefinition",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = ""
)
public class RunnerCrearClientes {
}
