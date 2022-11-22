package helpers;

public class LILGUNS {

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

}
