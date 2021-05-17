package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ResultPageObjects {

    WebDriver driver;
    WebDriverWait wait ;

    @FindBy(xpath = "//h2[@class='inline-center']")
    WebElement mainTitle;

    @FindBy(xpath = "//a[contains(text(),'Nowe wyszukiwanie')]")
    WebElement newSearchLink;

    @FindBy(xpath = "//a[@class ='btn btn--outline btn--color-fourth txlc loadScr'][contains(text(),'Zmień kryteria')]")
    WebElement changeCriteria;

    @FindBy(xpath = "/body[@ data-fixed='188']/div[@ id='accessible-body']/div[@ class ='main box']/div[@ class ='search-results box']/div[@ class ='search-results__container']/div[1]")
    WebElement firstResult;

    @FindBy(xpath = "// body[@ data-fixed='188'] / div[@ id='accessible-body'] / div[ @class ='main box'] / div[@ class ='search-results box'] / div[@ class ='search-results__container'] / div[1] / div[1] / button[1]")
    WebElement transition1;

    @FindBy(xpath = "// body[@ data-fixed='188'] / div[@ id='accessible-body'] / div[@ class ='main box'] / div[@ class ='search-results box'] / div[@ class ='search-results__container'] / div[2] / div[1] / button[1]")
    WebElement transition2;

    @FindBy(xpath = "// body[@ data-fixed='188'] / div[@ id='accessible-body'] / div[@ class ='main box'] / div[@ class ='search-results box'] / div[@ class ='search-results__container'] / div[3] / div[1] / button[1]")
    WebElement transition3;

    @FindBy(xpath = "// body[@ data-fixed='188'] / div[@ id='accessible-body'] / div[@ class ='main box'] / div[@ class ='search-results box'] / div[@ class ='search-results__container'] / div[4] / div[1] / button[1]")
    WebElement transition4;

    @FindBy(xpath = "// body[@ data-fixed='188'] / div[@ id='accessible-body'] / div[@ class ='main box'] / div[@ class ='search-results box'] / div[@ class ='search-results__container'] / div[5] / div[1] / button[1]")
    WebElement transition5;

    @FindBy(xpath = "//h3[@class='inline-center abt-focusable']")
    WebElement noConnection;





    public ResultPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String checkMainTitle(){

        wait = new WebDriverWait(driver, 1);
        wait.until(visibilityOf(mainTitle));
        return mainTitle.getText();
    }

    public String checkTrainName(String trainName, String nameType){
        String trainNameCheck = "UPPSS";
        WebElement trainNameOnPage;

        switch (nameType){
            case "0":
                trainNameOnPage = driver.findElement(By.xpath("//p[contains(text(),'" + trainName + "')]"));
                return trainNameOnPage.getText();
            case "1":
                trainNameOnPage = driver.findElement(By.xpath("//span[contains(text(),'" + trainName + "')]"));
                return trainNameOnPage.getText();

            case "2":
                trainNameOnPage = driver.findElement(By.xpath("//div[@class ='search-results__item row abt-focusable search-results__item--expanded']//div[@ class ='col-9 col-12--phone relative']//div[@ class ='row row-station box--flex block-phone']//div[@ class ='col-3 col-12--phone inline-center box--flex--column']//p[@ class ='item-label'][contains(text(), 'osobowy')]"));
                                                               //body[@data-fixed='188']/div[@id='accessible-body']/div[@class='main box']/div[@class='search-results box']/div[@class='search-results__container']/div[5]/div[1]/div[1]/div[3]/p[3]
                return trainNameOnPage.getText();

            case "3":
                trainNameOnPage = driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[3]/p[3]"));
                return trainNameOnPage.getText();
                //"/html[1]/body[1]/div[6]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[3]/p[4]/span[2]"
        }

        return trainNameCheck;
    }

    public String checkTrainNumber(String trainNumber){
        WebElement trainNumberOnPage;
        //String numberOnPage = null;
        wait = new WebDriverWait(driver, 1);
        trainNumberOnPage = driver.findElement(By.xpath("//p[contains(text(),'"+trainNumber+"')]"));
        wait.until(visibilityOf(trainNumberOnPage));
        return trainNumberOnPage.getText();
    }

    publick String[][] check_przesiadki(String pociag,String numer,String ifnazwa,String prze1A,String prze1B,String prze1C,String prze2A,String prze2B,String prze2C,
                                        String prze3A,String prze3B,String prze3C,String prze4A,String prze4B,
                                        String prze4C){

    sprawdzenie = []

            assert self.verification(ifnazwa, pociag, numer) == "OK"
            sprawdzenie.append("OK")

            if prze1A != "0":
            assert self.verification(prze1C, prze1A, prze1B) == "OK"
            sprawdzenie.append("OK")

    elif prze2A != "0":
            assert self.verification(prze2C, prze2A, prze2B) == "OK"
            sprawdzenie.append("OK")

    elif prze3A != "0":
            assert self.verification(prze3C, prze3A, prze3B) == "OK"
            sprawdzenie.append("OK")

    elif prze4A != "0":
            assert self.verification(prze4C, prze4A, prze4B) == "OK"
            sprawdzenie.append("OK")

            else:
            sprawdzenie.append("NOT")

            return sprawdzenie
}
