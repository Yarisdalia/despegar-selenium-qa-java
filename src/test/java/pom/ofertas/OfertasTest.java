package pom.ofertas;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pom.WebBrowser;
import pom.home.HomePage;
import pom.vuelos.VuelosPage;

public class OfertasTest extends TestCase {

    //declarar el web driver
    WebBrowser web;

    //declarar las paginas
    HomePage homePage;

    OfertasPage ofertasPage;

    @Before
    public void setUp(){
        web = new WebBrowser(false);
        //instanciar la page
        homePage = new HomePage(web.getDriver());
        homePage.visit("https://www.despegar.com.uy/");
        ofertasPage = new OfertasPage(web.getDriver());
    }


    @Test
    public void test(){
        // agregar test
        homePage.goToOfertas();
        homePage.quitGooglePopup();
        homePage.quitEntendiPopups();
        ofertasPage.agendarPaqueteTuristico();
        assertTrue(ofertasPage.messageIsDisplay());
    }

    @After
    public void tearDown(){
        web.quitWebWindow();
    }

}