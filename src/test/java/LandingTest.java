import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pom.HomePage;
import pom.LandingPage;
import pom.WebBrowser;

public class LandingTest extends TestCase {

    //declarar el web driver
    WebBrowser web;

    //declarar las paginas
    LandingPage landingPage;
    @Before
    public void setUp(){
        web = new WebBrowser(false);
        //instanciar la page
        landingPage = new LandingPage(web.getDriver());
    }

    @Test
    public void test(){
        // agregar test
        landingPage.visit("https://sendcuba-client-next-pwa-x6xn32iivq-uc.a.run.app/");
        landingPage.getIn();

    }
    @After
        public void tearDown(){
//        web.quitWebWindow();
    }

}
