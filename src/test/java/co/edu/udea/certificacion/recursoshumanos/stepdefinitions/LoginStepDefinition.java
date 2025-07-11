package co.edu.udea.certificacion.recursoshumanos.stepdefinitions;

import co.edu.udea.certificacion.recursoshumanos.questions.LeaveSearchPanel;
import co.edu.udea.certificacion.recursoshumanos.tasks.NavigateTo;
import co.edu.udea.certificacion.recursoshumanos.userinterfaces.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

import co.edu.udea.certificacion.recursoshumanos.tasks.Login;
import co.edu.udea.certificacion.recursoshumanos.questions.Dashboard;
import co.edu.udea.certificacion.recursoshumanos.questions.UserProfile;
import co.edu.udea.certificacion.recursoshumanos.questions.MainMenu;

import java.util.List;

public class LoginStepDefinition {

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }

    @Given("que estoy en la pagina de login de OrangeHRM")
    public void queEstoyEnLaPaginaDeLoginDeOrangeHRM() {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
        );
    }


    @When("ingreso el usuario {string} y la contrasena {string}")
    public void ingresoElUsuarioYLaContrasena(String usuario, String contrasena) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(usuario, contrasena)
        );
    }

    @When("hago clic en el boton {string}")
    public void hagoClicEnElBoton(String boton) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.clickLoginButton()
        );
    }

    @Then("debo estar autenticado y ver el dashboard")
    public void deboEstarAutenticadoYVerElDashboard() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("Dashboard should be visible", Dashboard.visibility(), is(true))
        );
    }

    @And("debo ver el nombre de usuario en la esquina superior derecha")
    public void deboVerElNombreDeUsuarioEnLaEsquinaSuperiorDerecha() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("User profile should be displayed", UserProfile.isVisible(), is(true))
        );
    }

    @Given("que el usuario ha iniciado sesion exitosamente en OrangeHRM")
    public void queElUsuarioHaIniciadoSesionExitosamente() {
        OnStage.theActorCalled("Usuario").wasAbleTo(
                Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"),
                Login.withValidCredentials()
        );OnStage.theActorInTheSpotlight().attemptsTo(
                Login.clickLoginButton()
        );
    }



    @When("navega al modulo {string} desde el menu lateral")
    public void navegaAlModuloDesdeElMenuLateral(String modulo) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavigateTo.module(modulo)
        );
    }

    @Then("deberia visualizar el panel de busqueda de solicitudes de permisos")
    public void deberiaVisualizarElPanelDeBusqueda() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("Panel de busqueda visible",
                        LeaveSearchPanel.isVisible(), is(true))
        );
    }

}
