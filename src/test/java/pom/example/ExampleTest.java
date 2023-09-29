package pom.example;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pom.WebBrowser;

public class ExampleTest extends TestCase {

    //declarar el web driver
    WebBrowser web;

    //declarar las paginas

    @Before
    public void setUp(){
        web = new WebBrowser(false);
        //instanciar la page
    }

    @Test
    public void test(){
        // agregar test
        assertTrue(true);
    }

    @After
    public void tearDown(){
        web.quitWebWindow();
    }

}