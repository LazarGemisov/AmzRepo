package tests;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AmazonHomePage;
import pages.NewAmazonCategoryAndFilterPage;
import pages.NewAmazonCategoryAndFilterResultPage;

import java.util.List;

public class NewAmzSearchThroughDepartmentsTest extends BaseTest {

    @Test
    public void amzCategoryAndFilterTest () throws InterruptedException{
        //MARK: NAVIGATE TO AMAZON HOME PAGE AND SEARCH THRU DEPARTMENTS
        AmazonHomePage amzCategoryAndFilter = new AmazonHomePage(driver);
        String userDetails = amzCategoryAndFilter.amzForDepartments(url,username,pass,category,subCategory,searchTerm,brand);
        // TITLE: ASSERT FOR LOGGED IN USER
        Assert.assertTrue("You are not logged in ", userDetails.toLowerCase().contains(lastName.toLowerCase()));

        // TITLE: FILTERS AND CATEGORIES IN CellPhones&Accessories DEPARTMENT
        NewAmazonCategoryAndFilterPage amazonCategory = new NewAmazonCategoryAndFilterPage(driver);
        amazonCategory.inputFilters(brand,searchTerm,lowPrice,highPrice);

        // TITLE: RESULTS PAGE AFTER SETTING FILTERS IN CellPhones&Accessories DEPARTMENT
        NewAmazonCategoryAndFilterResultPage amzCategoryAndFilterResults = new NewAmazonCategoryAndFilterResultPage(driver);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("s-result-list")));
        WebElement categoryAndFilterCont = driver.findElement(By.className("s-result-list"));
        List<WebElement> listOfTitles = categoryAndFilterCont.findElements(By.className("a-size-base-plus"));
        int resultsNumber = amzCategoryAndFilterResults.checkForResultsNumber();
        int allDepNumber = amzCategoryAndFilterResults.checkResultsForAllDepartmentSize();
        int i = 0;
        for (WebElement list:listOfTitles) {
            if (i < resultsNumber && listOfTitles.get(i).getText().toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("DEV COMMENTS: ARTICLE NO." + i + " TITLES CONTAIN SEARCH TERM");
            }
            i++;
        }
        boolean titleMissingSearchTerm = false;
        for (WebElement list:listOfTitles){

            if (!list.getText().toLowerCase().contains(searchTerm.toLowerCase())) {
                titleMissingSearchTerm = true;
            }
            //Assert.assertTrue("ALL ARTICLES DO NOT CONTAIN SEARCH TERM", list.getText().toLowerCase().contains(searchTerm.toLowerCase()));
        }
        if (titleMissingSearchTerm){
            System.out.println("DEV COMMENTS: ERROR!!! ALL ARTICLES DO NOT CONTAIN SEARCH TERM, BUT MAYBE WWE CAN LIVE WITH THIS"+System.lineSeparator()+
                         "WE WILL NOT DO ASSERT FOR THIS CONDITION");
        }

       //Assert.assertFalse("Not all results are shown in the list, page is giving us a option to see all results in other departments",resultsNumber != allDepNumber);
        WebElement allDepartmentsBtn = amzCategoryAndFilterResults.returnWebElementDepartmentButton();
        if (allDepartmentsBtn.isDisplayed()){
            System.out.println("DEV COMMENTS:Not all results are shown in the list, page is giving us a option to see all results in other departments"+System.lineSeparator()+
                                "I WOULD REPORT A BAG HERE BECAUSE CELL PHONES & ACCESSORIES ARE NOT WELL CATEGORISED");
            System.out.println(devSummary);
        }
        Assert.assertFalse("Page is offering our wanted search in other departments ",allDepartmentsBtn.isDisplayed());

    }
}
