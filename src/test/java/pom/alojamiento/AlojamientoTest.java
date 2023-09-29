package pom.alojamiento;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pom.WebBrowser;
import pom.home.HomePage;

public class AlojamientoTest extends TestCase {

    //declarar el web driver
    WebBrowser web;

    //declarar las paginas
    AlojamientoPage alojamientoPage;
    HomePage homePage;

    @Before
    public void setUp(){
        web = new WebBrowser(false);
        //instanciar la page
        homePage = new HomePage(web.getDriver());
        homePage.visit("https://www.despegar.com.uy/");
        alojamientoPage = new AlojamientoPage(web.getDriver());

    }

    @Test
    public void test(){
        // agregar test
        homePage.goToAlojamiento();
        homePage.quitAllPopups();
        alojamientoPage.agendarAlojamiento();
        assertTrue(alojamientoPage.orderSelectIsDisplay());
    }

    @After
    public void tearDown(){
        web.quitWebWindow();
    }

}