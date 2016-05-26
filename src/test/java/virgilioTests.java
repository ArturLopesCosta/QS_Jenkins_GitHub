import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

public class virgilioTests {
    private WebDriver driver;
    private String baseUrl;
    private String searchTerm;



    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver();
        //http://www.arturcosta.com/qs/
        baseUrl = "http://www.arturcosta.com/qs/"; //baseUrl for the online version
        //baseUrl = "http://localhost:8080/team/"; //baseUrl for the local version
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
        //driver.findElement(By.linkText("Formador")).click();
        //Assert.assertEquals("ISLA Santarém",driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }


}