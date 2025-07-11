package co.edu.udea.certificacion.recursoshumanos.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.questions.Text;

import static co.edu.udea.certificacion.recursoshumanos.userinterfaces.DashboardPage.USER_PROFILE_DROPDOWN;

public class UserProfile {


    public static Question<Boolean> isVisible() {
        return Question.about("user profile dropdown visibility")
                .answeredBy(actor -> Visibility.of(USER_PROFILE_DROPDOWN).answeredBy(actor));
    }

}