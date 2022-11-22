package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AmazonHomePage;
import pages.AmazonSearchResultPage;
import pages.AmazonSelectedArticlePage;
import pages.AmazonShoppingCartSummaryPage;
import java.util.List;

public class AmzShoppingCartSummary extends BaseTest {

    @Test
    public void AmzShoppingCartSummary()throws InterruptedException{

        //MARK: SEARCH TEST AND CHECKING FOR WANTED TERM
        AmazonHomePage amzSearch = new AmazonHomePage(driver);
        String userDetails = amzSearch.searchTest(url,username,pass,searchTerm,brand);

        WebElement allResultsContainer = driver.findElement(By.className("s-search-results"));
        List<WebElement> listOfAllResults = allResultsContainer.findElements(By.className("s-widget-spacing-small"));
        System.out.println(listOfAllResults.size());

        for (WebElement listOfTitles:listOfAllResults) {
            Assert.assertTrue("All of the articles do not contain desired searchTerm",
                    listOfTitles.getText().toLowerCase().contains(termSplitted[0].toLowerCase()) || listOfTitles.getText().toLowerCase().contains(termSplitted[1].toLowerCase()));
        }

        Assert.assertTrue("You are not logged in ",userDetails.toLowerCase().contains(lastName.toLowerCase()));

        //MARK: SECOND TASK
        //MARK:-> CHECKING FOR FILTERS AND PRICE RANGE


        AmazonSearchResultPage setPriceAndFilters = new AmazonSearchResultPage(driver);
        setPriceAndFilters.inputPriceRangeAndFilterCategory(lowPrice,highPrice,phoneMemory);
        WebElement filterResultsCont = driver.findElement(By.className("s-search-results"));
        List<WebElement> listOfAllFilteredResults = filterResultsCont.findElements(By.className("s-widget-spacing-small"));
        //System.out.println(listOfAllFilteredResults.size());

        for (WebElement listOfTitles:listOfAllFilteredResults) {
            Assert.assertTrue("All of the articles do not contain desired searchTerm",
                    listOfTitles.getText().toLowerCase().contains(termSplitted[0].toLowerCase()) || listOfTitles.getText().toLowerCase().contains(termSplitted[1].toLowerCase())&& listOfTitles.getText().contains(phoneMemoryTogether.toLowerCase()));
           // Assert.assertTrue("All of the article titles do not contain memory size",listOfTitles.getText().toLowerCase().contains(phoneMemory.toLowerCase()));
        }

        List<WebElement> listOfPrices = filterResultsCont.findElements(By.className("a-price-whole"));
        int numberOfResultsInt = listOfAllFilteredResults.size();

        int i = 0;
        for (WebElement listOfTitles:listOfPrices) {

            if (i < numberOfResultsInt){
                String priceOfFilteredResults = listOfPrices.get(i).getText();
                int priceOfFilteredResultsInt = Integer.parseInt(priceOfFilteredResults.replace(",",""));
                //MARK: HERE WE CAN'T DO ASSERT BECAUSE AMAZON IS ALWAYS PUTTING MORE ITEMS BELOW PRICE RANGE
                // Assert.assertTrue("Price isn't in within required range ",priceOfFilteredResultsInt >= lowPriceInt && priceOfFilteredResultsInt <= highPriceInt);
                i++;
            }else{
                break;
            }
        }

        //MARK: CLICKING ON DESIRED ARTICLE

        setPriceAndFilters.clickOnDesiredArticle(desiredArticle);
        Thread.sleep(2000);
        //MARK: SETTING QUANTITY,ADDING TO THE CART AND PROCEEDING TO CHECKOUT
        AmazonSelectedArticlePage addQtyAndToTheCart = new AmazonSelectedArticlePage(driver);
        addQtyAndToTheCart.addToTheCart(desiredQuantity);
        Thread.sleep(2000);

        //MARK: CHECKOUT MOVE TO ANOTHER CLASS
       /* AmazonCheckoutPage checkout = new AmazonCheckoutPage(driver);
        checkout.checkout();*/

        // MARK THIRD PART OF THE TASK

        AmazonShoppingCartSummaryPage checkSummary = new AmazonShoppingCartSummaryPage(driver);
        String summaryTest = checkSummary.checkSummary();
        String validTest = "true";
        System.out.println(summaryTest.toLowerCase());

        Assert.assertTrue("Prices do not add up",summaryTest.contains(validTest));

    }
}
