package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
    @FindBy (className = "a-list-item")
    List<WebElement> listOfBrands;


    private void selectBrand (String brand){

        for (WebElement list:listOfBrands){
            if (list.getText().toLowerCase().contains(brand.toLowerCase())){
                list.click();
                break;
            }
        }
    }
    private void inputLowPriceRange(String lowPrice){
        js.executeScript("arguments[0].scrollIntoView();",lowPriceRange);
        lowPriceRange.sendKeys(lowPrice);
    }

    private void inputHighPrice(String highPrice){
        highPriceRange.sendKeys(highPrice);
    }

    private void clickToFilterPriceRange(){
        priceRangeButton.click();
        System.out.println("DEV CHECK: PRICE RANGE IS APPLIED");
    }

    private  void selectMemorySize(String memory) throws InterruptedException {

        List<WebElement> memoryList = refinementsCont.findElements(By.className("a-list-item"));
        for (WebElement list:memoryList){

            if (list.getText().toLowerCase().contains(memory.toLowerCase())){
                js.executeScript("arguments[0].scrollIntoView();",list);
                list.click();
                break;
            }
        }
        System.out.println("DEV CHECK: MEMORY SIZE HAVE BEEN SELECTED");
        //Thread.sleep(1000);
    }

    public void inputPriceRangeAndFilterCategory(String lowPrice, String highPrice,String memory) throws InterruptedException {
        selectMemorySize(memory);
        inputLowPriceRange(lowPrice);
        inputHighPrice(highPrice);
        clickToFilterPriceRange();




        Thread.sleep(1000);

    }
    public void clickOnDesiredArticle(int desiredArticle) throws InterruptedException {

        List<WebElement> allSearchResults = searchResultContainer.findElements(By.className("s-widget-spacing-small"));
        int i = 0;

        for (WebElement list:allSearchResults){

            if (i==desiredArticle && allSearchResults.get(i).getText().contains("Ships to Serbia")){
                allSearchResults.get(i).click();


                break;
            } else {
                allSearchResults.remove(desiredArticle);
                allSearchResults.get(desiredArticle).click();
                System.out.println("DEV COMMENT:WE HAD REMOVE ARTICLE WITCH DOSEN'T SHIP TO SERBIA");
                break;
            }

        }
        System.out.println("DEV CHECK: SELECTED ARTICLE WAS CHOSEN");
    }
}
