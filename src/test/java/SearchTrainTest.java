import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ResultPageObjects;
import pages.SearchFormClicks;
import tools.CSVReader;
import java.io.IOException;

public class SearchTrainTest {
    public WebDriver driver;
    public  int counterT = 0;

    public void slowDown(int howLong){

        try{Thread.sleep(howLong);}
        catch(InterruptedException e){System.out.println("fghdfd");}
    }

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.firefox.driver", "/geckodriver/geckodriver");
        //System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver");
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test(dataProvider="testData1", dataProviderClass=CSVReader.class)
    public void testSearchTrain1(String godzinka, String dzien, String odjazd, String przyjazd, String trainName, String trainNumber, String nameType) {

        if(godzinka != null){
            driver.get("https://portalpasazera.pl");

            this.slowDown(500);
            SearchFormClicks cookieDismiss = new SearchFormClicks(driver);
            cookieDismiss.setCookieAgree(counterT);
            counterT++;

            this.slowDown(500);
            SearchFormClicks clickDirect = new SearchFormClicks(driver);
            clickDirect.directConnections();

            this.slowDown(500);
            SearchFormClicks insertOdjazd = new SearchFormClicks(driver);
            insertOdjazd.wyjazdInput(odjazd);

            this.slowDown(500);
            SearchFormClicks insertPrzyjazd = new SearchFormClicks(driver);
            insertPrzyjazd.przyjazdInput(przyjazd);

            this.slowDown(500);
            SearchFormClicks insertData = new SearchFormClicks(driver);
            insertData.dataInput(dzien);

            this.slowDown(500);
            SearchFormClicks insertGodzina = new SearchFormClicks(driver);
            insertGodzina.godzinaInput(godzinka);

            this.slowDown(500);
            SearchFormClicks clickSzukaj = new SearchFormClicks(driver);
            clickSzukaj.searchButton();

            this.slowDown(3000);
            ResultPageObjects checkResultMainTitle = new ResultPageObjects(driver);
            ResultPageObjects checkResultTrainNumber = new ResultPageObjects(driver);
            ResultPageObjects checkResultTrainName = new ResultPageObjects(driver);
            ResultPageObjects test = new ResultPageObjects(driver);

            String titleReturn = test.checkMainTitle();
            Assert.assertEquals(titleReturn, "Wyniki wyszukiwania");

            String trainNameReturn = test.checkTrainName(trainName, nameType);
            Assert.assertTrue(trainNameReturn.contains(trainName));

            String trainNumberReturn = test.checkTrainNumber(trainNumber);
            Assert.assertTrue(trainNumberReturn.contains(trainNumber));
        }


    }

    @Test(dataProvider="testData2", dataProviderClass=CSVReader.class)
    public void testSearchTrain2(String godzinka, String dzien, String odjazd, String przyjazd, String trainName, String trainNumber, String nameType, String changes,
                                 String cheng1A, String cheng1B, String cheng1C, String cheng2A, String cheng2B, String cheng2C,
                                 String cheng3A, String cheng3B, String cheng3C, String cheng4A, String cheng4B, String cheng4C){

            driver.get("https://portalpasazera.pl");

            this.slowDown(500);
            SearchFormClicks cookieDismiss = new SearchFormClicks(driver);
            cookieDismiss.setCookieAgree(counterT);
            counterT++;

    }

    @AfterClass
    public void tearDown()  {

        //this.slowDown(2000);
        driver.quit();
    }

}
