package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFormClicks {

    WebDriver driver;

    @FindBy(xpath = "//button[@id='cookieman-save-btn']")
    WebElement cookieAgree;

    public SearchFormClicks(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setCookieAgree() {
        cookieAgree.click();
    }
}
