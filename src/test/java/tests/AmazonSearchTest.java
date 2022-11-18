package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AmazonHomePage;
import pages.AmazonSearchResultPage;

import java.util.List;

public class AmazonSearchTest extends BaseTest {
    @Test
    public void amzSearchTest() throws InterruptedException {

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


        // DONJI DEO KODA BRISEMO

        //MARK:-> CHECKING FOR FILTERS AND PRICE RANGE

        /*AmazonSearchResultPage setPriceAndFilters = new AmazonSearchResultPage(driver);
        setPriceAndFilters.inputPriceRangeAndFilterCategory(lowPrice,highPrice,phoneMemory);
        WebElement filterResultsCont = driver.findElement(By.className("s-search-results"));
        List<WebElement> listOfAllFilteredResults = filterResultsCont.findElements(By.className("s-widget-spacing-small"));
        System.out.println(listOfAllFilteredResults.size());

        for (WebElement listOfTitles:listOfAllFilteredResults) {
            Assert.assertTrue("All of the articles do not contain desired searchTerm",
                    listOfTitles.getText().toLowerCase().contains(termSplitted[0].toLowerCase()) || listOfTitles.getText().toLowerCase().contains(termSplitted[1].toLowerCase())&& listOfTitles.getText().contains(phoneMemoryTogether.toLowerCase()));
        }



        List<WebElement> listOfPrices = filterResultsCont.findElements(By.className("a-price-whole"));


        int numberOfResultsInt = listOfAllFilteredResults.size();

        System.out.println(listOfPrices.size());


        int i = 0;
        for (WebElement listOfTitles:listOfPrices) {

            if (i < numberOfResultsInt){
                System.out.println(listOfPrices.get(i).getText());
                String priceOfFilteredResults = listOfPrices.get(i).getText();
                int priceOfFilteredResultsInt = Integer.parseInt(priceOfFilteredResults.replace(",",""));

                Assert.assertTrue("Price isn't in within required range ",priceOfFilteredResultsInt >= lowPriceInt && priceOfFilteredResultsInt <= highPriceInt);


                i++;
            }else{
                break;
            }



        }*/



        Thread.sleep(3000);
    }


}
