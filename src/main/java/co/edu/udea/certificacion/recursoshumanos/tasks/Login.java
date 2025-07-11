package co.edu.udea.certificacion.recursoshumanos.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.edu.udea.certificacion.recursoshumanos.userinterfaces.LoginPage.*;

public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Espera que los campos estén visibles antes de interactuar
                WaitUntil.the(USERNAME_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(PASSWORD_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(username).into(USERNAME_FIELD),
                Enter.theValue(password).into(PASSWORD_FIELD)
                // La validación del dashboard se hace en el StepDefinition
        );
    }

    public static Login withCredentials(String username, String password) {
        return Tasks.instrumented(Login.class, username, password);
    }

    public static Login withValidCredentials() {

        return withCredentials("Admin", "admin123");
    }

    // Para permitir usar el paso: "hago clic en el botón"
    public static Task clickLoginButton() {
        return Tasks.instrumented(ClickLoginButton.class);
    }

    // Clase interna que encapsula solo el clic al botón
    public static class ClickLoginButton implements Task {
        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    WaitUntil.the(LOGIN_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(LOGIN_BUTTON)
            );
        }
    }
}
