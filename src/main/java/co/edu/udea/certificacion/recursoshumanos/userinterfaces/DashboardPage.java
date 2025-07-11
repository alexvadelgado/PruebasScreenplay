// DashboardPage.java - User Interface
package co.edu.udea.certificacion.recursoshumanos.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage extends PageObject {

    public static final Target DASHBOARD_TITLE = Target.the("Dashboard title")
            .located(By.xpath("//h6[text()='Dashboard']"));

    public static final Target MAIN_MENU = Target.the("Main menu option")
            .locatedBy("//*[@id='app']");

    public static final Target USER_PROFILE_DROPDOWN = Target.the("User profile dropdown")
            .located(By.xpath("//*[@id='app']"));

}