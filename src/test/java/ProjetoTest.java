import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ProjetoTest {
    private WebDriver driver;
    private String baseUrl;
    private String searchTerm;



    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver();
        //http://www.arturcosta.com/qs/
        baseUrl = "http://www.arturcosta.com/qs/";
        //baseUrl = "http://localhost:8080/team/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    //
    @Test
    public void testJavaTeste() throws Exception {
        driver.get(baseUrl + "/");
        //driver.findElement(By.linkText("Web page profissional")).click();
        //Assert.assertTrue("erro no link",driver.getTitle().matches(""));
        //Assert.assertEquals("Wrong page title","ALC Computer - Hardware, Software, Assistência Técnica, Redes, Web Design e Cartões PVC | Página Inicial",driver.getTitle());
        driver.findElement(By.linkText("Moodle profissional")).click();
        Assert.assertEquals("Artur Costa",driver.getTitle());
        //driver.findElement(By.linkText("Formador")).click();
        //Assert.assertEquals("ISLA Santarém",driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }


}