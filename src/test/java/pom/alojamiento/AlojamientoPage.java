package pom.alojamiento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

public class AlojamientoPage extends BasePage {

    // declarar los localizadores, todos los que necesites
    By destinoInput = By.xpath("//input[@placeholder='Ingresá una ciudad, alojamiento o punto de interés']");
    By fechaInicioInput = By.xpath("//input[contains(@placeholder, 'Entrada')]");

    By dia30Btn = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div/div[1]/div[3]/div[30]");
    By dia3Btn = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div/div[2]/div[3]/div[3]");
    By aplicarBtn = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[2]/div[1]/button");
    By habitacionesInput  = By.xpath("//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/div[3]");
    By addAdultBtn = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div/button[2]");
    By addMenorBtn = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div/button[2]");
    By addEdadMenorSelect = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[3]/div[2]/div/div/select");
    By aplicarHabitacionBtn = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[2]/a[1]");
    By buscarBtn = By.xpath("/html/body/div[6]/div[1]/div/div/div/div/div/div/div/div[3]/button");

    By orderInfoSelect = By.xpath("//select[@class='select-tag']");

    By sinFechaCheckBox = By.xpath("//span[@class='sbox5-3-switch']");

    By messageHotelesInDisplay = By.xpath("//h2[contains(text(),'Ofertas de Hoteles populares en Montevideo')]");

    public AlojamientoPage(WebDriver driver) {
        super(driver);
    }

    // funcionalidades de nuestra pagina
    private void buscarDestino(){
        waitForSeconds(1);
        clearInput(destinoInput);
        type("Montevideo", destinoInput);
        waitForSeconds(1);
        type(" Uruguay", destinoInput);
        waitForSeconds(1);
        pressEnter(destinoInput);
    }
    public void agendarAlojamiento() {
        buscarDestino();

        click(fechaInicioInput);
        waitForSeconds(1);
        click(dia30Btn);

        waitForSeconds(1);
        click(dia3Btn);
        waitForSeconds(1);
        click(aplicarBtn);

        waitForSeconds(1);
        click(habitacionesInput);

        waitForSeconds(1);
        click(addAdultBtn);

        click(addMenorBtn);

        type("3", addEdadMenorSelect);

        click(aplicarHabitacionBtn);

        waitForSeconds(2);
        click(buscarBtn);
    }

    public boolean orderSelectIsDisplay() {
        return isDisplayed(orderInfoSelect);
    }

    public void agendarAlojamientoSinFecha() {
        buscarDestino();
        waitForSeconds(1);

        click(sinFechaCheckBox);

        click(buscarBtn);

    }

    public boolean messageIsDisplay() {
        return isDisplayed(messageHotelesInDisplay);
    }
}
