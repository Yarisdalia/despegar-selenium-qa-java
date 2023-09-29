package pom.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

public class HomePage extends BasePage {

    // declarar los localizadores, todos los que necesites
    By botonLogin = By.id("loginButton");
    By tabAlojamiento = By.xpath("//a[contains(@title, 'Alojamientos')]");
    By tabVuelos = By.xpath("//a[contains(@title, 'Vuelos')]");

    By noQuiroBeneficiosBtn = By.xpath("//div[@class='login-incentive--button login-incentive--button-close shifu-3-btn-ghost']");

    By ahoraNoNotificationBtn = By.xpath("//p[@class='eva-3-link tooltip-web-push--not-now']");

    By entendiBtn = By.xpath("//div[@class='lgpd-banner--button shifu-3-btn -white -md']");
    By tabOfertas = By.xpath("//a[contains(@title, 'Ofertas')]");
    By cambiarDePais = By.id("eva-country");



    public void quitEntendiPopups(){
        waitElementAndClick(entendiBtn);
    }

    public void quitNotificationPopups(){
        waitElementAndClick(ahoraNoNotificationBtn);
    }

    public void quitGooglePopup(){
        waitElementAndClick(noQuiroBeneficiosBtn);
    }

    public void quitAllPopups () {
        quitGooglePopup();
        quitNotificationPopups();
        quitEntendiPopups();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // funcionalidades de nuestra pagina
    public void goToLogin() {
        click(botonLogin);
    }

    public void goToAlojamiento() {
        click(tabAlojamiento);
    }

    public void goToVuelos() {
        click(tabVuelos);
    }

    public void goToOfertas() {
        click(tabOfertas);
    }
    public void navegarEnElSitioDe(){
        scroll(10000);
        type("Chile",cambiarDePais);
    }
    public String getUrl(){
        return getBrowserUrl();
    }
}
