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
            // TITLE: ASSERT FOR CHECKING SEARCH TERM IN RESULTS
            Assert.assertTrue("All of the articles do not contain desired search term",
                    listOfTitles.getText().toLowerCase().contains(termSplitted[0].toLowerCase()) || listOfTitles.getText().toLowerCase().contains(termSplitted[1].toLowerCase()));
        }
        // TITLE: ASSERT FOR LOG IN
        Assert.assertTrue("You are not logged in ",userDetails.toLowerCase().contains(lastName.toLowerCase()));





        Thread.sleep(3000);
    }


}
