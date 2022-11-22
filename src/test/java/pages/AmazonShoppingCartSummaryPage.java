package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonShoppingCartSummaryPage extends BaseHelper {

    WebDriver driver;
    public AmazonShoppingCartSummaryPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (className = "break-word")
    WebElement addressLine;
    @FindBy (id = "shipToThisAddressButton")
    WebElement shipAddressButton;
    @FindBy (xpath = "//*[@id=\"subtotals-marketplace-table\"]/table/tbody/tr[1]/td[2]")
    WebElement itemPrice;
    @FindBy (xpath = "//*[@id=\"subtotals-marketplace-table\"]/table/tbody/tr[2]/td[2]")
            WebElement shippingPrice;
    @FindBy (xpath = "//*[@id=\"subtotals-marketplace-table\"]/table/tbody/tr[4]/td[2]")
            WebElement totalBeforeTax;
    @FindBy (xpath = "//*[@id=\"subtotals-marketplace-table\"]/table/tbody/tr[5]/td[2]")
            WebElement estimatedTax;
    @FindBy (xpath = "//*[@id=\"subtotals-marketplace-table\"]/table/tbody/tr[6]/td[2]")
            WebElement importFeeDeposit;
    @FindBy(xpath = "//*[@id=\"subtotals-marketplace-table\"]/table/tbody/tr[8]/td[2]")
            WebElement orderTotal;

    private void clickOnAddressButton(){
        wdWait.until(ExpectedConditions.elementToBeClickable(shipAddressButton));
        shipAddressButton.click();
    }

    private String checkCart () throws InterruptedException {
    Thread.sleep(3000);
    Float itemPriceFloat = Float.parseFloat(itemPrice.getText().replace("$","").replace(",",""));
    Float shippingPriceFloat = Float.parseFloat(shippingPrice.getText().replace("$",""));
    Float totalBeforeTaxFloat = Float.parseFloat(totalBeforeTax.getText().replace("$","").replace(",",""));
    Float estimatedTaxFloat = Float.parseFloat(estimatedTax.getText().replace("$",""));
    Float importFeeFloat = Float.parseFloat(importFeeDeposit.getText().replace("$",""));
    Float orderTotalFloat = Float.parseFloat(orderTotal.getText().replace("$","").replace(",",""));
    String summary ="";

    if (itemPriceFloat+shippingPriceFloat+estimatedTaxFloat+importFeeFloat == orderTotalFloat){
         summary = "true";
        return summary;
    }else {
         summary = "false";
        return summary;
    }

}

public String checkSummary() throws InterruptedException {
        clickOnAddressButton();
        checkCart();
        String summary = checkCart();
        return summary;
    }
}
