package co.edu.udea.certificacion.recursoshumanos.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import co.edu.udea.certificacion.recursoshumanos.userinterfaces.LeavePage;

public class LeaveSearchPanel {

    public static Question<Boolean> isVisible() {
        return actor -> Visibility.of(LeavePage.SEARCH_PANEL).answeredBy(actor);
    }
}

