package co.edu.udea.certificacion.recursoshumanos.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SideMenu {

    public static Target option(String name) {
        return Target.the("Menu option " + name)
                .located(By.xpath("//span[text()='" + name + "']"));
    }
}
