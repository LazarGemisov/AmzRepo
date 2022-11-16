package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AmazonHomePage;
import pages.AmazonSearchResultPage;

import java.util.List;

public class AmazonSearchTest extends BaseTest {



    @Test
    public void amzSearchTest() throws InterruptedException {


        AmazonHomePage amzSearch = new AmazonHomePage(driver);
        amzSearch.searchTest(url,username,pass,searchTerm,brand);

        WebElement allResulutsContainer = driver.findElement(By.className("s-search-results"));
        List<WebElement> listOfAllResults = allResulutsContainer.findElements(By.className("s-widget-spacing-small"));
        System.out.println(listOfAllResults.size());

        for (WebElement listOfTitles:listOfAllResults) {
            Assert.assertTrue("All of the articles do not contain desired searchTerm",
                    listOfTitles.getText().toLowerCase().contains(termSplitted[0].toLowerCase()) || listOfTitles.getText().toLowerCase().contains(termSplitted[1].toLowerCase()));
        }

        //MARK:-> CHECKING FOR FILTERS

        AmazonSearchResultPage setPriceAndFilters = new AmazonSearchResultPage(driver);
        setPriceAndFilters.inputPriceRangeAndFilterCategory(lowPrice,highPrice,phoneMemory);
        WebElement filterResultsCont = driver.findElement(By.className("s-search-results"));
        List<WebElement> listOfAllFilteredResults = filterResultsCont.findElements(By.className("s-widget-spacing-small"));
        System.out.println(listOfAllFilteredResults.size());

        for (WebElement listOfTitles:listOfAllFilteredResults) {
            Assert.assertTrue("All of the articles do not contain desired searchTerm",
                    listOfTitles.getText().toLowerCase().contains(termSplitted[0].toLowerCase()) || listOfTitles.getText().toLowerCase().contains(termSplitted[1].toLowerCase())&& listOfTitles.getText().contains(phoneMemoryTogether.toLowerCase()));
        }



        Thread.sleep(100000);
    }


}
