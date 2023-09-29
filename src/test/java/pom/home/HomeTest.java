package pom.home;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
        homePage.visit("https://www.despegar.com.uy/");
    }

    @Test
    public void test(){
        // agregar test
        homePage.quitGooglePopup();
        homePage.quitEntendiPopups();
        homePage.navegarEnElSitioDe();

        assertEquals("https://www.despegar.cl/",homePage.getUrl());
    }

    @After
    public void tearDown(){
        web.quitWebWindow();
    }

}