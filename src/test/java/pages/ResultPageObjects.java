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

    public String checkTrainNumber(String trainName, String nameType){
        String trainNameCheck;
        WebElement trainNameOnPage;

        if (nameType == "1"){
            trainNameOnPage = driver.findElement(By.xpath("//span[contains(text(),'" + trainName + "')]"));
            trainNameCheck = trainNameOnPage.getText();
            return trainNameCheck;
        }
        else if (nameType == "0") {
            trainNameOnPage = driver.findElement(By.xpath("//p[contains(text(),'" + trainName + "')]"));
            trainNameCheck = trainNameOnPage.getText();
            return trainNameCheck;
        }
        else if  (nameType == "2") {
            trainNameOnPage = driver.findElement(By.xpath("//div[@class ='search-results__item row abt-focusable search-results__item--expanded']//div[@ class ='col-9 col-12--phone relative']//div[@ class ='row row-station box--flex block-phone']//div[@ class ='col-3 col-12--phone inline-center box--flex--column']//p[@ class ='item-label'][contains(text(), 'osobowy')]"));
            trainNameCheck = trainNameOnPage.getText();
            return trainNameCheck;
        }
        else if  (nameType == "3") {
            trainNameOnPage = driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[3]/p[4]/span[2]"));
            trainNameCheck = trainNameOnPage.getText();

        }

        return trainNameCheck;
    }
}
