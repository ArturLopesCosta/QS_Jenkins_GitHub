import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.text;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ArturTests {
    private WebDriver driver;
    private String baseUrl;
    private String searchTerm;



    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        //driver = new HtmlUnitDriver();
        //http://www.arturcosta.com/qs/
        baseUrl = "http://www.arturcosta.com/qs/";
        //baseUrl = "http://localhost:8080/team/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    //

    @Test
    public void testJavaTeste() throws Exception {
        //página inicial do perfil
        driver.get(baseUrl + "/arturcosta.html");
        Assert.assertEquals("Artur Costa",driver.getTitle());
        driver.close();
    }

    @Test
    public void testLinks() throws Exception {

        driver.get(baseUrl + "/arturcosta.html");

        driver.findElement(By.linkText("Site ALC Computer")).click();
        Assert.assertEquals("ALC Computer - Hardware, Software, Assistência Técnica, Redes, Web Design e Cartões PVC | Página Inicial",driver.getTitle());

        driver.get(baseUrl + "/arturcosta.html");
        driver.findElement(By.linkText("Site IEFP")).click();
        Assert.assertEquals("Formação - IEFP, I.P.",driver.getTitle());

        driver.get(baseUrl + "/arturcosta.html");
        driver.findElement(By.linkText("Site ISLA Santarém")).click();
        Assert.assertEquals("ISLA Santarém",driver.getTitle());

        driver.get(baseUrl + "/arturcosta.html");
        driver.findElement(By.linkText("Minhaventura")).click();
        Assert.assertEquals("descer o rio Coura em kayak - MinhAventura",driver.getTitle());
        driver.close();

    }
    @Test
    public void testImagens() throws Exception {
        //foto pessoal
        driver.get(baseUrl + "/arturcosta.html");
        WebElement fotoArtur = driver.findElement(By.xpath("//img[@alt='Foto Artur']"));
        Boolean fotoCarregada = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", fotoArtur);
        Assert.assertEquals(true, fotoCarregada);
        //logo IPL
        driver.get(baseUrl + "/arturcosta.html");
        WebElement image1 = driver.findElement(By.xpath("//img[@alt='Logo IPL']"));
        Boolean imageLoaded1 = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image1);
        Assert.assertEquals(true, imageLoaded1);
        //Logo ESGTS
        WebElement image2 = driver.findElement(By.xpath("//img[@alt='Logo ESGTS']"));
        Boolean imageLoaded2 = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image2);
        Assert.assertEquals(true, imageLoaded2);

        driver.close();

    }
    @Test
    public void testVideos() throws Exception {
        //videos Minhaventura
        driver.get(baseUrl);
        driver.findElement(By.linkText("Profile Artur Costa")).click();
        WebElement videoKayak = driver.findElement(By.id("videoKayak"));
        Assert.assertTrue("video videoKayak não está presente",videoKayak.isDisplayed());
        WebElement videoChallenger = driver.findElement(By.id("videoKayak"));
        Assert.assertTrue("video videoChallenger não está presente",videoChallenger.isDisplayed());

        driver.close();

    }
    @Test
    public void testCSS() throws Exception {
        //http://testautomationarchives.blogspot.pt/2013/12/selenium-webdriver-get-background-color.html
        String text;
        driver.get(baseUrl + "/arturcosta.html");
        WebElement WebElement1 = driver.findElement(By.xpath("//body[@id='main']"));
        text =WebElement1.getCssValue("background-color").toString();
        //Split css value of rgb
        String[] numbers = text.replace("rgba(", "").replace(")", "").split(",");
        int number1=Integer.parseInt(numbers[0]);
        numbers[1] = numbers[1].trim();
        int number2=Integer.parseInt(numbers[1]);
        numbers[2] = numbers[2].trim();
        int number3=Integer.parseInt(numbers[2]);
        String hex = String.format("#%02x%02x%02x", number1,number2,number3);
        Assert.assertTrue("Cor de Fundo incorreta",hex.equals("#d0e4fe"));
        driver.close();
    }
    @Test
    //verificar se há valores nulos na tabela externa
    public void testInscricoes() throws Exception {
        //http://www.softwaretestinghelp.com/selenium-tutorial-18/
        String text;
        driver.get("http://www.descidadocoura.pt/lista-inscricoes-descida.php");
       // WebElement htmltable=driver.findElement(By.xpath("//*[@id='main']/table[1]/tbody"));
        WebElement htmltable=driver.findElement(By.tagName("tbody"));
        int nulos=0;
        List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
        for(int rnum=0;rnum<rows.size();rnum++)
        {
            List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));
            //System.out.println("Number of columns:"+columns.size());
            for(int cnum=0;cnum<columns.size();cnum++)

            {

               if (columns.get(cnum).getText().equals(""))
                nulos++;

            }

        }
        System.out.println(nulos);
        Assert.assertTrue("valores nulos na tabela",nulos==0);
        driver.close();
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}

