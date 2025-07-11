package co.edu.udea.certificacion.recursoshumanos.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = "co.edu.udea.certificacion.recursoshumanos.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class LoginRunner {}