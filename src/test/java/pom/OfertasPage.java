package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

public class OfertasPage extends BasePage {

    // declarar los localizadores, todos los que necesites

    By origenInput = By.xpath("//input[@placeholder='Ingresa desde dónde viajas']");
    By destinoInput = By.xpath("//input[@placeholder='Ingresa hacia dónde viajas']");

    By fechaInicioInput = By.xpath("//input[contains(@placeholder, 'Ida')]");

    By dia30Btn = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div/div[1]/div[3]/div[30]");
    By dia3Btn = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div/div[2]/div[3]/div[3]");
    By aplicarBtn = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[2]/div[1]/button");

    By buscarBtn = By.xpath("//*[@id=\"searchbox-v2\"]/div/div/div/div/div/div[3]/div[4]/button");


    By messagePaqueteIsDisplay = By.xpath("//h3[contains(text(),'Este es el paquete perfecto para vos. ¡Empezá a vivir tu viaje!')]");
    By messagePaqueteIsDisplay2 = By.xpath("//h3[contains(text(),' Ahorra con este paquete que elegimos para ti ')]");


    //By btnEnviar = By.name("submit");

    public OfertasPage(WebDriver driver) {
        super(driver);
    }

    // funcionalidades de nuestra pagina
    private void buscar(String text1, String text2, By locator){
        waitForSeconds(1);
        clearInput(locator);
        type(text1, locator);
        waitForSeconds(2);
        type(text2, locator);
        waitForSeconds(2);
        pressEnter(locator);
    }

    public void agendarPaqueteTuristico(){
        scroll(2900);
        waitForSeconds(2);

        buscar("Rio de Janeiro" ," Brasil",origenInput);
        buscar("Montevideo", " Uruguay",destinoInput);

        click(fechaInicioInput);
        waitForSeconds(1);
        click(dia30Btn);

        waitForSeconds(1);
        click(dia3Btn);
        waitForSeconds(3);
        click(aplicarBtn);

        waitForSeconds(1);
        click(buscarBtn);

    }

    public boolean messageIsDisplay() {
        waitForSeconds(7);
        return isDisplayed(messagePaqueteIsDisplay) | isDisplayed(messagePaqueteIsDisplay2);
    }
}
