package pom.vuelos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

public class VuelosPage extends BasePage {

    // declarar los localizadores, todos los que necesites
    By origenInput = By.xpath("//input[@placeholder='Ingresa desde dónde viajas']");
    By destinoInput = By.xpath("//input[@placeholder='Ingresa hacia dónde viajas']");

    By fechaInicioInput = By.xpath("//input[contains(@placeholder, 'Ida')]");

    By dia30Btn = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[2]/div/div[1]/div[3]/div[30]");
    By dia3Btn = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[2]/div/div[2]/div[3]/div[3]");
    By aplicarBtn = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[3]/button");

    By messagePreciosInDisplay = By.xpath("//*[@id=\"toolbox-tabs-position\"]/toolbox-tabs/div/tabs/div/div[1]/div/ul/li[1]");


    public VuelosPage(WebDriver driver) {
        super(driver);
    }

    // funcionalidades de nuestra pagina
    private void buscar(String text1, String text2, By locator){
        waitForSeconds(1);
        clearInput(locator);
        type(text1, locator);
        waitForSeconds(1);
        type(text2, locator);
        waitForSeconds(1);
        pressEnter(locator);
    }
    public void agendarVuelo() {
        buscar("Montevideo", " Uruguay", origenInput);
        buscar("Buenos", " Aires", destinoInput);

        click(fechaInicioInput);
        waitForSeconds(1);
        click(dia30Btn);

        waitForSeconds(1);
        click(dia3Btn);
        waitForSeconds(3);
        click(aplicarBtn);
    }

    public boolean messageIsDisplay() {
        waitForSeconds(7);
        return isDisplayed(messagePreciosInDisplay);
    }
}
