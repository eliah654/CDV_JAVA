import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchFormClicks;

import java.util.concurrent.TimeUnit;

public class SearchTrainTest {
    public WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.firefox.driver", "/geckodriver/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void testSearchTrain(){
        driver.get("https://portalpasazera.pl");
        String pageTitle = driver.getTitle();

        SearchFormClicks cookieDismiss = new SearchFormClicks(driver);

        Assert.assertEquals(pageTitle,"Wyszukiwarka rozkładu jazdy pociągów PKP PLK S.A. - Portal Pasażera - PKP Polskie Linie Kolejowe S.A.");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        cookieDismiss.setCookieAgree();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);





    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
