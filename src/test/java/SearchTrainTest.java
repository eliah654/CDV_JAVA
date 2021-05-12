import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchFormClicks;

public class SearchTrainTest {
    public WebDriver driver;

    public void slowDown(int howLong){

        try{Thread.sleep(howLong);}
        catch(InterruptedException e){System.out.println("fghdfd");}
    }

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.firefox.driver", "/geckodriver/geckodriver");
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://portalpasazera.pl");
    }

    @Test
    public void testSearchTrain(){

//        String pageTitle = driver.getTitle();
//        Assert.assertEquals(pageTitle,"Wyszukiwarka rozkładu jazdy pociągów PKP PLK S.A. - Portal Pasażera - PKP Polskie Linie Kolejowe S.A.");

        this.slowDown(1000);
        SearchFormClicks cookieDismiss = new SearchFormClicks(driver);
        cookieDismiss.setCookieAgree();

        this.slowDown(1000);
        SearchFormClicks insertOdjazd = new SearchFormClicks(driver);
        insertOdjazd.wyjazdInput(cellOdjazd);

        this.slowDown(1000);
        SearchFormClicks insertPrzyjazd = new SearchFormClicks(driver);
        insertPrzyjazd.przyjazdInput(cellPrzyjazd);

        this.slowDown(1000);
        SearchFormClicks insertData = new SearchFormClicks(driver);
        insertData.dataInput(cellData);

        this.slowDown(1000);
        SearchFormClicks insertGodzina = new SearchFormClicks(driver);
        insertGodzina.godzinaInput(cellGodzina);

        this.slowDown(1000);
        SearchFormClicks clickSzukaj = new SearchFormClicks(driver);
        clickSzukaj.searchButton();

        //this.slowDown(8000);

    }

    @AfterClass

    public void tearDown()  {

        this.slowDown(5000);
        driver.quit();
    }

}
