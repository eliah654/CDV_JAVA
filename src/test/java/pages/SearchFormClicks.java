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
    private WebElement cookieAgree;

    @FindBy(xpath = "//button[@class='btn btn--lg btn-start-search txuc']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='departureFrom']")
    private WebElement wyjazdInput;

    @FindBy(xpath = "//input[@id='arrivalTo']")
    private WebElement przyjazdInput;

    @FindBy(xpath = "//input[@id='main-search__dateStart']")
    private WebElement dataInput;

    @FindBy(xpath = "//input[@id='main-search__timeStart']")
    private WebElement godzinaInput;

    @FindBy(xpath = "//span[@class='label-inside txlc']")
    private WebElement directConnections;

    @FindBy(xpath = "//input[@id='dirChck']")
    private WebElement dC2;

    @FindBy(xpath = "//button[contains(text(),'Więcej opcji wyszukiwania')]")
    private WebElement moreSearchOptions;

    @FindBy(xpath = "//div[@class='main-search__options-close']//button[@type='button']//span[@class='txlc'][contains(text(),'Zamknij opcje wyszukiwania')]")
    private WebElement closeSearchOptions;



    public SearchFormClicks(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void ClearField(WebElement pageElement){
        pageElement.sendKeys(Keys.CONTROL, "a");
        pageElement.sendKeys(Keys.BACK_SPACE);
    }

    public void setCookieAgree(int counterT) {
        wait = new WebDriverWait(driver, 1);
        if(counterT == 0) {
        //if (cookieAgree.()){
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

    public void directConnections(int testCase){

        wait = new WebDriverWait(driver, 1);
        wait.until(elementToBeClickable(directConnections));

        if(!dC2.isSelected() && testCase == 0) {
            directConnections.click();
        }
        else if(dC2.isSelected() && testCase == 1){
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
