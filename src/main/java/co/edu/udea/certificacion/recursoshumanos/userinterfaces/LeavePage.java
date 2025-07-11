package co.edu.udea.certificacion.recursoshumanos.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LeavePage {

    public static final Target SEARCH_PANEL = Target.the("panel de busqueda")
            .located(By.xpath("//*[@id='app']"));

}