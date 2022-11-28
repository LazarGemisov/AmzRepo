package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class NewAmazonCategoryAndFilterPage extends BaseHelper {
    WebDriver driver;
    public NewAmazonCategoryAndFilterPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "s-search-results")
    WebElement searchResultContainer;
    @FindBy (id = "low-price")
    WebElement lowPriceRange;
    @FindBy (id = "high-price")
    WebElement highPriceRange;
    @FindBy (id = "a-autoid-1")
    WebElement priceRangeButton;
    @FindBy(id = "s-refinements")
    WebElement refinementsCont;
    @FindBy (className = "a-list-item")
    List<WebElement> listOfBrands;
    @FindBy (id = "twotabsearchtextbox")
    WebElement searchTxtFiled;
    @FindBy (className = "nav-search-submit")
    WebElement loupe;

private void checkForCategories() {
    List<WebElement> memoryList = refinementsCont.findElements(By.className("a-list-item"));
    for (WebElement list:memoryList){
        System.out.println(list.getText());
    }
}
    private void inputLowPriceRange(String lowPrice){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("low-price")));
        js.executeScript("arguments[0].scrollIntoView();",lowPriceRange);
        lowPriceRange.sendKeys(lowPrice);
    }

    private void inputHighPrice(String highPrice){
        highPriceRange.sendKeys(highPrice);
    }

    private void clickToFilterPriceRange(){
        priceRangeButton.click();
    }

    private void inputSearchTerm (String term){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));
        searchTxtFiled.sendKeys(term);
        loupe.click();
    }

    private void selectBrand (String brand){

        for (WebElement list:listOfBrands){
            if (list.getText().toLowerCase().contains(brand.toLowerCase())){
                list.click();
                break;
            }
        }
    }

    public void inputFilters(String term, String lowPrice, String highPrice) throws InterruptedException {

        inputSearchTerm(term);
        inputLowPriceRange(lowPrice);
        inputHighPrice(highPrice);
        clickToFilterPriceRange();


        //Thread.sleep(3000);

    }
}
