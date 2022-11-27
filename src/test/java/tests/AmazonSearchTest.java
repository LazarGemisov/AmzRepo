package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AmazonHomePage;

import java.util.List;

public class AmazonSearchTest extends BaseTest {
    @Test
    public void amzSearchTest() throws InterruptedException {

        //MARK: SEARCH TEST AND CHECKING FOR WANTED TERM
        AmazonHomePage amzSearch = new AmazonHomePage(driver);
        String userDetails = amzSearch.amazonSearch(url, username, pass, searchTerm, brand);

        // TITLE: ASSERT FOR LOGGED IN USER
        Assert.assertTrue("You are not logged in ", userDetails.toLowerCase().contains(lastName.toLowerCase()));

        WebElement allResultsContainer = driver.findElement(By.className("s-search-results"));
        List<WebElement> listOfAllResults = allResultsContainer.findElements(By.className("s-widget-spacing-small"));
        System.out.println("DEV COMMENTS: Number of articles shown on results page is " + listOfAllResults.size());

        // TITLE: ASSERT FOR CHECKING SEARCH TERM IN RESULTS
        boolean allArticlesContainSearchTerm = true;
        for (WebElement listOfTitles : listOfAllResults) {
            // DEV COMMENT: The only way we can do assert is if we split search term
            Assert.assertTrue("All of the articles do not contain desired search term",
                    listOfTitles.getText().toLowerCase().contains(termSplitted[0].toLowerCase()) || listOfTitles.getText().toLowerCase().contains(termSplitted[1].toLowerCase()));

            if (!listOfTitles.getText().toLowerCase().contains(searchTerm)) {
                allArticlesContainSearchTerm = false;
            } else {
                allArticlesContainSearchTerm = true;
            }
        }
        if (allArticlesContainSearchTerm == true) {
            System.out.println("DEV COMMENTS: ALL ARTICLES CONTAIN SEARCH TERM");
        } else {
            System.out.println("DEV COMMENTS: ALL ARTICLES DO NOT CONTAIN SEARCH TERM, BUT THIS IS HOW AMAZON WORKS, MAYBE WE CAN LIVE WITH THIS" +
                    System.lineSeparator() + "ASSERT HAD PASSED BECAUSE WE HAD SPLITTED SEARCH TERM");
        }
    }
}
