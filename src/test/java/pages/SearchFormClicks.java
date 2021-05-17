package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class SearchFormClicks {

    WebDriver driver;
    WebDriverWait wait ;

    @FindBy(xpath = "//button[contains(text(),'Akceptuj wszystkie pliki cookie')]")
    WebElement cookieAgree;

    @FindBy(xpath = "//button[@class='btn btn--lg btn-start-search txuc']")
    WebElement searchButton;

    @FindBy(xpath = "//input[@id='departureFrom']")
    WebElement wyjazdInput;

    @FindBy(xpath = "//input[@id='arrivalTo']")
    WebElement przyjazdInput;

    @FindBy(xpath = "//input[@id='main-search__dateStart']")
    WebElement dataInput;

    @FindBy(xpath = "//input[@id='main-search__timeStart']")
    WebElement godzinaInput;

    @FindBy(xpath = "//span[@class='label-inside txlc']")
    WebElement directConnections;

    @FindBy(xpath = "//input[@id='dirChck']")
    WebElement dC2;

    @FindBy(xpath = "//button[contains(text(),'Więcej opcji wyszukiwania')]")
    WebElement moreSearchOptions;

    @FindBy(xpath = "//div[@class='main-search__options-close']//button[@type='button']//span[@class='txlc'][contains(text(),'Zamknij opcje wyszukiwania')]")
    WebElement closeSearchOptions;



    public SearchFormClicks(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void ClearField(WebElement pageElement){
        pageElement.sendKeys(Keys.CONTROL, "a");
        pageElement.sendKeys(Keys.BACK_SPACE);
    }

    public void setCookieAgree(int counterT) {

        if(counterT == 0) {
            wait = new WebDriverWait(driver, 1);
            wait.until(elementToBeClickable(cookieAgree));
            cookieAgree.click();
        }
    }


    public void searchButton(){

        wait = new WebDriverWait(driver, 1);
        wait.until(elementToBeClickable(searchButton));
        searchButton.click();
    }

    public void wyjazdInput(String insertTown){

        wait = new WebDriverWait(driver, 1);
        wait.until(elementToBeClickable(wyjazdInput));
        wyjazdInput.click();
        wyjazdInput.sendKeys(insertTown);
    }

    public void przyjazdInput(String insertTown){

        wait = new WebDriverWait(driver, 1);
        wait.until(elementToBeClickable(przyjazdInput));
        przyjazdInput.click();
        przyjazdInput.sendKeys(insertTown);
    }


    public void dataInput(String insertData){

        wait = new WebDriverWait(driver, 1);
        wait.until(elementToBeClickable(dataInput));
        dataInput.click();
        this.ClearField(dataInput);
        dataInput.sendKeys(insertData);
    }

    public void godzinaInput(String insertGodzina){

        wait = new WebDriverWait(driver, 1);
        wait.until(elementToBeClickable(godzinaInput));
        godzinaInput.click();
        this.ClearField(godzinaInput);
        godzinaInput.sendKeys(insertGodzina);
    }

    public void directConnections(){

        wait = new WebDriverWait(driver, 1);
        wait.until(elementToBeClickable(directConnections));
        if(!dC2.isSelected()) {
            directConnections.click();
        }
    }

    public void moreSearchOptions(){

        wait = new WebDriverWait(driver, 1);
        wait.until(elementToBeClickable(moreSearchOptions));
        moreSearchOptions.click();
    }

    public void closeSearchOptions(){

        wait = new WebDriverWait(driver, 1);
        wait.until(elementToBeClickable(closeSearchOptions));
        closeSearchOptions.click();
    }
}
