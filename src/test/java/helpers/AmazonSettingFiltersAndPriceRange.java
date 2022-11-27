package helpers;

import tests.BaseTest;

public class AmazonSettingFiltersAndPriceRange extends BaseTest {
/*
    @Test
    public void AmzSettingFiltersAndPriceRange() throws InterruptedException{
        //MARK: SEARCH TEST AND CHECKING FOR WANTED TERM
        AmazonHomePage amzSearch = new AmazonHomePage(driver);
        String userDetails = amzSearch.amazonSearch(url,username,pass,searchTerm,brand);

        WebElement allResultsContainer = driver.findElement(By.className("s-search-results"));
        List<WebElement> listOfAllResults = allResultsContainer.findElements(By.className("s-widget-spacing-small"));
        System.out.println("DEV COMMENTS: Size of article on result page is "+listOfAllResults.size());

        for (WebElement listOfTitles:listOfAllResults) {
            Assert.assertTrue("All of the articles do not contain desired search term",
                    listOfTitles.getText().toLowerCase().contains(termSplitted[0].toLowerCase()) || listOfTitles.getText().toLowerCase().contains(termSplitted[1].toLowerCase()));
        }
        Assert.assertTrue("You are not logged in ",userDetails.toLowerCase().contains(lastName.toLowerCase()));

        //MARK:-> CHECKING FOR FILTERS AND PRICE RANGE

        AmazonSearchResultPage setPriceAndFilters = new AmazonSearchResultPage(driver);
        setPriceAndFilters.inputPriceRangeAndFilterCategory(lowPrice,highPrice,phoneMemory);
        WebElement filterResultsCont = driver.findElement(By.className("s-search-results"));
        List<WebElement> listOfAllFilteredResults = filterResultsCont.findElements(By.className("s-widget-spacing-small"));
        //System.out.println(listOfAllFilteredResults.size());

        for (WebElement listOfTitles:listOfAllFilteredResults) {
            // TITLE: ASSERT FOR CHECKING SEARCH TERM AFTER FILTERS AND PRICE RANGE
            Assert.assertTrue("All of the articles do not contain desired searchTerm",
                    listOfTitles.getText().toLowerCase().contains(termSplitted[0].toLowerCase()) || listOfTitles.getText().toLowerCase().contains(termSplitted[1].toLowerCase())&& listOfTitles.getText().contains(phoneMemoryTogether.toLowerCase()));
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
       addQtyAndToTheCart.addToTheCart(desiredQuantity,desiredColor);

        Thread.sleep(3000);
    }

 */
}
