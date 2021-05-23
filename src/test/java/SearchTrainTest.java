import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ResultPageObjects;
import pages.SearchFormClicks;
import tools.CSVReaderFF;

public class SearchTrainTest {
    public WebDriver driver;
    public int counterT = 0;

    public void slowDown(int howLong){

        try{Thread.sleep(howLong);}
        catch(InterruptedException e){System.out.println("fghdfd");}
    }

    public void setAndExcuteSerach(String godzinka, String dzien, String odjazd, String przyjazd, int testCase,
                                   int counterT){

        this.slowDown(500);
        SearchFormClicks cookieDismiss = new SearchFormClicks(driver);
        cookieDismiss.setCookieAgree(counterT);

        this.slowDown(500);
        SearchFormClicks clickDirect = new SearchFormClicks(driver);
        clickDirect.directConnections(testCase);

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
    }



    @BeforeClass
    public void setUp(){
        //System.setProperty("webdriver.firefox.driver", "/geckodriver/geckodriver");
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test(dataProvider="testData1", dataProviderClass= CSVReaderFF.class)
    public void testSearchTrain1(String godzinka, String dzien, String odjazd, String przyjazd, String trainName, String trainNumber, String nameType) {

        if(godzinka != null){
            driver.get("https://portalpasazera.pl");

            this.setAndExcuteSerach(godzinka, dzien, odjazd, przyjazd, 0, counterT);
            counterT++;

            this.slowDown(3000);
            ResultPageObjects checkResults = new ResultPageObjects(driver);

            String titleReturn = checkResults.checkMainTitle();
            Assert.assertEquals(titleReturn, "Wyniki wyszukiwania");

            String trainNameReturn = checkResults.checkTrainName(trainName, nameType);
            Assert.assertTrue(trainNameReturn.contains(trainName));

            String trainNumberReturn = checkResults.checkTrainNumber(trainNumber);
            Assert.assertTrue(trainNumberReturn.contains(trainNumber));
        }


    }

    @Test(dataProvider="testData2", dataProviderClass= CSVReaderFF.class)
    public void testSearchTrain2(String godzinka, String dzien, String odjazd, String przyjazd, String trainName, String trainNumber, String nameType, String changes,
                                 String cheng1A, String cheng1B, String cheng1C, String cheng2A, String cheng2B, String cheng2C,
                                 String cheng3A, String cheng3B, String cheng3C, String cheng4A, String cheng4B, String cheng4C){

        ResultPageObjects checkResults = new ResultPageObjects(driver);
        String[][] checkedResults = new String[5][2];
        if(godzinka != null) {
            driver.get("https://portalpasazera.pl");

            this.setAndExcuteSerach(godzinka, dzien, odjazd, przyjazd, 1, counterT);
            counterT++;

            String titleReturn = checkResults.checkMainTitle();
            Assert.assertEquals(titleReturn, "Wyniki wyszukiwania");

            switch (changes) {
                case "1":
                    checkResults.openTransitions(1);
                   /*
                    checkedResults = checkResults.checkTransition(trainName, trainNumber, nameType,
                            cheng1A, cheng1B, cheng1C, cheng2A, cheng2B, cheng2C, cheng3A, cheng3B, cheng3C, cheng4A, cheng4B,
                            cheng4C);

                    Assert.assertEquals(checkedResults[0][0], trainName);
                    Assert.assertEquals(checkedResults[0][1], cheng1B);

                    Assert.assertEquals(checkedResults[1][0], cheng1A);
                    Assert.assertEquals(checkedResults[1][1], cheng1B);

                    Assert.assertEquals(checkedResults[2][0], cheng2A);
                    Assert.assertEquals(checkedResults[2][1], cheng2B);

                    Assert.assertEquals(checkedResults[3][0], cheng3A);
                    Assert.assertEquals(checkedResults[3][1], cheng3B);

                    Assert.assertEquals(checkedResults[4][0], cheng4A);
                    Assert.assertEquals(checkedResults[4][1], cheng4B);
                   */
                case "2":
                    checkResults.openTransitions(2);
                    /*
                    checkedResults = checkResults.checkTransition(trainName, trainNumber, nameType,
                            cheng1A, cheng1B, cheng1C, cheng2A, cheng2B, cheng2C, cheng3A, cheng3B, cheng3C, cheng4A, cheng4B,
                            cheng4C);

                    Assert.assertEquals(checkedResults[0][0], trainName);
                    Assert.assertEquals(checkedResults[0][1], cheng1B);

                    Assert.assertEquals(checkedResults[1][0], cheng1A);
                    Assert.assertEquals(checkedResults[1][1], cheng1B);

                    Assert.assertEquals(checkedResults[2][0], cheng2A);
                    Assert.assertEquals(checkedResults[2][1], cheng2B);

                    Assert.assertEquals(checkedResults[3][0], cheng3A);
                    Assert.assertEquals(checkedResults[3][1], cheng3B);

                    Assert.assertEquals(checkedResults[4][0], cheng4A);
                    Assert.assertEquals(checkedResults[4][1], cheng4B);
                    */
                case "3":
                    checkResults.openTransitions(3);
                    /*
                    checkedResults = checkResults.checkTransition(trainName, trainNumber, nameType,
                            cheng1A, cheng1B, cheng1C, cheng2A, cheng2B, cheng2C, cheng3A, cheng3B, cheng3C, cheng4A, cheng4B,
                            cheng4C);

                    Assert.assertEquals(checkedResults[0][0], trainName);
                    Assert.assertEquals(checkedResults[0][1], cheng1B);

                    Assert.assertEquals(checkedResults[1][0], cheng1A);
                    Assert.assertEquals(checkedResults[1][1], cheng1B);

                    Assert.assertEquals(checkedResults[2][0], cheng2A);
                    Assert.assertEquals(checkedResults[2][1], cheng2B);

                    Assert.assertEquals(checkedResults[3][0], cheng3A);
                    Assert.assertEquals(checkedResults[3][1], cheng3B);

                    Assert.assertEquals(checkedResults[4][0], cheng4A);
                    Assert.assertEquals(checkedResults[4][1], cheng4B);
                */
                case "4":
                    checkResults.openTransitions(4);
                    /*
                    checkedResults = checkResults.checkTransition(trainName, trainNumber, nameType,
                            cheng1A, cheng1B, cheng1C, cheng2A, cheng2B, cheng2C, cheng3A, cheng3B, cheng3C, cheng4A, cheng4B,
                            cheng4C);

                    Assert.assertEquals(checkedResults[0][0], trainName);
                    Assert.assertEquals(checkedResults[0][1], cheng1B);

                    Assert.assertEquals(checkedResults[1][0], cheng1A);
                    Assert.assertEquals(checkedResults[1][1], cheng1B);

                    Assert.assertEquals(checkedResults[2][0], cheng2A);
                    Assert.assertEquals(checkedResults[2][1], cheng2B);

                    Assert.assertEquals(checkedResults[3][0], cheng3A);
                    Assert.assertEquals(checkedResults[3][1], cheng3B);

                    Assert.assertEquals(checkedResults[4][0], cheng4A);
                    Assert.assertEquals(checkedResults[4][1], cheng4B);
                */
                case "5":
                    checkResults.openTransitions(5);
                    /*
                    checkedResults = checkResults.checkTransition(trainName, trainNumber, nameType,
                            cheng1A, cheng1B, cheng1C, cheng2A, cheng2B, cheng2C, cheng3A, cheng3B, cheng3C, cheng4A, cheng4B,
                            cheng4C);

                    Assert.assertEquals(checkedResults[0][0], trainName);
                    Assert.assertEquals(checkedResults[0][1], cheng1B);

                    Assert.assertEquals(checkedResults[1][0], cheng1A);
                    Assert.assertEquals(checkedResults[1][1], cheng1B);

                    Assert.assertEquals(checkedResults[2][0], cheng2A);
                    Assert.assertEquals(checkedResults[2][1], cheng2B);

                    Assert.assertEquals(checkedResults[3][0], cheng3A);
                    Assert.assertEquals(checkedResults[3][1], cheng3B);

                    Assert.assertEquals(checkedResults[4][0], cheng4A);
                    Assert.assertEquals(checkedResults[4][1], cheng4B);
                */
            }
        }

    }

    @Test(dataProvider="testData3", dataProviderClass= CSVReaderFF.class)
    public void testSearchTrain3(String godzinka, String dzien, String odjazd, String przyjazd){
        if(godzinka != null) {
            driver.get("https://portalpasazera.pl");
            ResultPageObjects checkResults = new ResultPageObjects(driver);
            this.setAndExcuteSerach(godzinka, dzien, odjazd, przyjazd, 0, counterT);
            counterT++;
            Assert.assertEquals(checkResults.checkNoConnection(), "Nie znaleziono połączeń według wskazanych kryteriów wyszukiwania");
        }
    }

    @AfterClass
    public void tearDown()  {

        //this.slowDown(2000);
        driver.quit();
    }

}
