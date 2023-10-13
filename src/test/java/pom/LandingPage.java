package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class LandingPage extends HomePage {


    By botonEntrar = By.xpath("/html/body/div[2]/nav/header/ul[4]/li[1]/a");
    By imputEmail = By.id("identifierId");


    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void getIn() {
        click(botonEntrar);
        waitForSeconds(2);
        changeToSecondWindowContext();
        waitForSeconds(2);
        type("yarisdaliahinojosapadilla2001@gmail.com", imputEmail);

    }

}





