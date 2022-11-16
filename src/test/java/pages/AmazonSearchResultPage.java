package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AmazonSearchResultPage extends BaseHelper {

    WebDriver driver;
    public AmazonSearchResultPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (className = "s-search-results")
    WebElement searchResultContainer;

    @FindBy (id = "low-price")
    WebElement lowPriceRange;

    @FindBy (id = "high-price")
    WebElement highPriceRange;

    @FindBy (id = "a-autoid-1")
    WebElement priceRangeButton;

    @FindBy(id = "s-refinements")
    WebElement refinementsCont;





    private void inputLowPriceRnge(String lowPrice){
        lowPriceRange.sendKeys(lowPrice);
    }

    private void inputHighPrice(String highPrice){
        highPriceRange.sendKeys(highPrice);
    }

    private void clickToFilterPriceRange(){
        priceRangeButton.click();
    }

    private  void selectMemorySize(String memory){

        List<WebElement> memoryList = refinementsCont.findElements(By.className("a-list-item"));
        for (WebElement list:memoryList){
            if (list.getText().toLowerCase().contains(memory.toLowerCase())){
                list.click();
                break;
            }
        }

    }


    public void inputPriceRangeAndFilterCategory(String lowPrice, String highPrice,String memory) throws InterruptedException {
        inputLowPriceRnge(lowPrice);
        inputHighPrice(highPrice);
        clickToFilterPriceRange();
        Thread.sleep(3000);
        selectMemorySize(memory);
    }
}
