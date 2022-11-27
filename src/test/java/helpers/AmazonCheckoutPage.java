package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonCheckoutPage extends BaseHelper {
    WebDriver driver;
    public AmazonCheckoutPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (className = "a-box-group")
    WebElement addressContainer;
    @FindBy (id = "shipToThisAddressButton")
    WebElement shipAddressButton;

    private void clickOnAddressButton(){
        wdWait.until(ExpectedConditions.elementToBeClickable(shipAddressButton));
        shipAddressButton.click();
    }


    public void checkout(){
        clickOnAddressButton();
// ovde stavi wd vait invisibliity of element
    }
}
