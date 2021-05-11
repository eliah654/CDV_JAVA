package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchFormClicks {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(),'Akceptuj wszystkie pliki cookie')]")
    WebElement cookieAgree;

    public SearchFormClicks(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void setCookieAgree() {
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedCondition.elementToBeClickable(cookieAgree));
        cookieAgree.click();
    }
}
