package pages;

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

    public ResultPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String checkMainTitle(){

        wait = new WebDriverWait(driver, 1);
        wait.until(visibilityOf(mainTitle));
        return mainTitle.getText();
    }


}
