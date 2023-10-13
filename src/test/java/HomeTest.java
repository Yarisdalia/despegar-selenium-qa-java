import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pom.HomePage;
import pom.WebBrowser;

public class HomeTest extends TestCase {

    //declarar el web driver
    WebBrowser web;

    //declarar las paginas
    HomePage homePage;


    @Before
    public void setUp(){
        web = new WebBrowser(false);
        //instanciar la page
        homePage = new HomePage(web.getDriver());
        homePage.visit("https://sendcuba-client-next-pwa-x6xn32iivq-uc.a.run.app/");
    }

    @Test
    public void test(){
        // agregar test
        homePage.quitGooglePopup();
        homePage.quitEntendiPopups();
        homePage.navegarEnElSitioDe();

        assertEquals("https://sendcuba-client-next-pwa-x6xn32iivq-uc.a.run.app/",homePage.getUrl());
    }

    @After
    public void tearDown(){
        web.quitWebWindow();
    }

}