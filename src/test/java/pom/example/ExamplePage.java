package pom.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

public class ExamplePage extends BasePage {

    // declarar los localizadores, todos los que necesites
    By txtFirstName = By.name("firstName");
    By btnEnviar = By.name("submit");

    public ExamplePage(WebDriver driver) {
        super(driver);
    }

    // funcionalidades de nuestra pagina
    public void registerUser() {
        type("agustin", txtFirstName);
        findElement(By.xpath(""));

        click(btnEnviar);
    }
}
