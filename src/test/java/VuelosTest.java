import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pom.VuelosPage;
import pom.WebBrowser;
import pom.HomePage;

public class VuelosTest extends TestCase {

    //declarar el web driver
    WebBrowser web;

    //declarar las paginas
    HomePage homePage;

    VuelosPage vuelosPage;

    @Before
    public void setUp(){
        web = new WebBrowser(false);
        //instanciar la page
        homePage = new HomePage(web.getDriver());
        homePage.visit("https://www.despegar.com.uy/");
        vuelosPage = new VuelosPage(web.getDriver());
    }

    @Test
    public void test(){
        // agregar test
        homePage.goToVuelos();
        homePage.quitAllPopups();
        vuelosPage.agendarVuelo();
        assertTrue(vuelosPage.messageIsDisplay());
    }

    @After
    public void tearDown(){
        web.quitWebWindow();
    }

}