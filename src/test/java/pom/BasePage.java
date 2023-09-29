package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    //declaramos objeto webdriver
    public final WebDriver driver;

    //creamos el contructor de la clase
    public BasePage(WebDriver driver){
        this.driver = driver;
        driver.manage().window().maximize();
    }

    //creamos un envoltorio de los comandos de selenium
    public WebElement findElement( By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    //clase para obtener el texto de un elemento
    public String getText(WebElement element){
        return element.getText();
    }

    //ahora hacemos una sobre carga del metodo para que reciba por localizador
    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    //escribir texto
    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    //click al elemento por localizador
    public void click(By locator){
        driver.findElement(locator).click();
    }

    //metodo para validar si el localizador se encuentra
    public Boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
            //vamos a capturar la excepcion
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    //metodo para ir a una URL
    public void visit(String url){
        driver.get(url);
    }

    // esperara unos segundos
    public void waitForSeconds(int timeoutInSeconds) {
        try {
            Thread.sleep(timeoutInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ir al contexto original
    public void goToDefaultContext() {
        driver.switchTo().defaultContent();
    }

    //borrar un campo de texto
    public void clearInput(By locator){
        WebElement input = driver.findElement(locator);
        input.click();
        waitForSeconds(1);
        input.clear();
    }

    // dar enter a un elemento
    public void pressEnter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    // esperar en pantalla a un elemento
    public void waitElementAndClick(By locator) {
       try {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
           wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
       } catch (NoSuchElementException e){
           // El popup no estaba presente, puedes manejarlo aquí
           System.out.println("El elemento no está presente. Continuando...");
       } catch (TimeoutException e){
           System.out.println("Se acabo el tiempo de espera del elemento. Continuando...");
       }
    }

    // hacer scroll en la pagina
    public void scroll(int cantScroll) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, "+ cantScroll +");");
    }

    // devuelve la Url del navegador
    public String getBrowserUrl(){
        return driver.getCurrentUrl();
    }
}