package co.edu.udea.certificacion.recursoshumanos.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import co.edu.udea.certificacion.recursoshumanos.userinterfaces.SideMenu;

public class NavigateTo implements Task {

    private final String module;

    public NavigateTo(String module) {
        this.module = module;
    }

    public static NavigateTo module(String module) {
        return Tasks.instrumented(NavigateTo.class, module);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SideMenu.option(module))
        );
    }
}
