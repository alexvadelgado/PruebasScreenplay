package co.edu.udea.certificacion.recursoshumanos.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.edu.udea.certificacion.recursoshumanos.userinterfaces.DashboardPage.MAIN_MENU;

public class MainMenu {

    public static Question<Boolean> hasOption(String optionText) {
        return Question.about("the presence of the menu option: " + optionText)
                .answeredBy(actor -> Visibility.of(MAIN_MENU.of(optionText)).answeredBy(actor));
    }
}
