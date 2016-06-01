import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

public class virgilioTests {
    private WebDriver driver;
    //private HtmlUnitDriver driver;
    private String baseUrl;
    private String searchTerm;



    @Before
    public void setUp() throws Exception {

        driver = new HtmlUnitDriver();


        //driver = new FirefoxDriver();
        //http://www.arturcosta.com/qs/
        //baseUrl = "http://www.arturcosta.com/qs/"; //baseUrl for the online version
        baseUrl = "http://localhost:8080/team/"; //baseUrl for the local version
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    //
    @Test
    public void testJavaTeste() throws Exception {
        driver.get(baseUrl + "/");
        //driver.findElement(By.linkText("Web page profissional")).click();
        //Assert.assertTrue("erro no link",driver.getTitle().matches(""));
        //Assert.assertEquals("Wrong page title","ALC Computer - Hardware, Software, Assistência Técnica, Redes, Web Design e Cartões PVC | Página Inicial",driver.getTitle());
        driver.findElement(By.linkText("Profile Virgilio Reis")).click();
        Assert.assertEquals("Virgilio Reis",driver.getTitle());
        driver.findElement(By.id("address")).getText();
        driver.findElement(By.id("education")).getText();



        String data = driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[5]/td[1]")).getText();

        System.out.println("The data extracted is " + data);

        String data2 = driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[8]/td[1]")).getText();

        System.out.println("The data extracted is " + data2);

        WebElement fotoProfile = driver.findElement(By.xpath("//img[contains(@id,'foto')]"));

        Assert.assertEquals(true, fotoProfile.isEnabled());

        driver.findElement(By.linkText("My Facebook")).click();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }


}