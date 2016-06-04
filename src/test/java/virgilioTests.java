import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class virgilioTests {
    private WebDriver driver;
    //private HtmlUnitDriver driver;
    private String baseUrl;
    private String searchTerm;
    private String personalPage = "VirgilioReis.html";
    private String personalURL ;



    @Before
    public void setUp() throws Exception {

        //driver = new HtmlUnitDriver();
        //driver.setJavascriptEnabled(true);

        driver = new FirefoxDriver();
        //http://www.arturcosta.com/qs/
        baseUrl = "http://www.arturcosta.com/qs/"; //baseUrl for the online version
        //baseUrl = "http://localhost:8080/team/"; //baseUrl for the local version
        personalURL = baseUrl+personalPage;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    //
    @Test
    public void testJavaTeste() throws Exception {
        driver.get(baseUrl);
        //driver.findElement(By.linkText("Web page profissional")).click();
        //Assert.assertTrue("erro no link",driver.getTitle().matches(""));
        //Assert.assertEquals("Wrong page title","ALC Computer - Hardware, Software, Assistência Técnica, Redes, Web Design e Cartões PVC | Página Inicial",driver.getTitle());
        driver.findElement(By.linkText("Profile Virgilio Reis")).click();
        Assert.assertEquals("Virgilio Reis",driver.getTitle());
        driver.findElement(By.id("address")).getText();
        driver.findElement(By.id("education")).getText();

        driver.findElement(By.id("birthdate")).getText();



        String data = driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[5]/td[1]")).getText();

        System.out.println("The data extracted is " + data);

        String data2 = driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[8]/td[1]")).getText();

        System.out.println("The data extracted is " + data2);

        WebElement fotoProfile = driver.findElement(By.xpath("//img[contains(@id,'foto')]"));

        Boolean imageLoaded2 = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", fotoProfile);


        Assert.assertEquals(true, imageLoaded2);



    }

    @Test
    public void testFacebookLink() throws Exception {



        driver.get(personalURL);
        Assert.assertEquals("http://localhost:8080/team/VirgilioReis.html", driver.getCurrentUrl());
        Assert.assertEquals("Virgilio Reis", driver.getTitle());

        //Find and click the url facebook on the personal webpage
        driver.findElement(By.linkText("My Facebook")).click();
        //Check if the page opened it a facebook page
        Assert.assertEquals("Facebook", driver.getTitle());
        //Check if the url page is correct
        Assert.assertEquals("https://www.facebook.com/virgilio.reis.7", driver.getCurrentUrl());
        //Check if the url bellong to the Virgilio Reis facebook web page
        //*[@id="fb-timeline-cover-name"]
        //Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"fb-timeline-cover-name\"]")).getText(), "Virgilio Reis");

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }


}