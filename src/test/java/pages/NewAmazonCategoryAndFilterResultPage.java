package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewAmazonCategoryAndFilterResultPage extends BaseHelper {
    public NewAmazonCategoryAndFilterResultPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (className = "s-result-list")
    WebElement resultsContainer;

    public WebElement returnWebElementDepartmentButton(){
        WebElement btnForDepartment = resultsContainer.findElement(By.className("widgetId=sparse-category-correction"));
    return btnForDepartment;
    }

    public int checkResultsForAllDepartmentSize(){
        WebElement resultsInOtherDep = resultsContainer.findElement(By.className("widgetId=sparse-category-correction"));
        List<WebElement>resultsList = resultsInOtherDep.findElements(By.className("s-result-item"));
        WebElement resultsSize = resultsList.get(0).findElement(By.className("s-underline-link-text"));
        int sizeForAllDepartments = Integer.parseInt(resultsSize.getText().replace("See all ","").replace(" results",""));
        System.out.println("DEV COMMENTS:Number of articles for desired term and applied filters in other departments is "+sizeForAllDepartments);
        return sizeForAllDepartments;
    }
    public int checkForResultsNumber(){
        WebElement resultNoCont = driver.findElement(By.className("template=RESULT_INFO_BAR"));
        WebElement resultNo = resultNoCont.findElement(By.tagName("span"));
        int NumberOfResults = Integer.parseInt(resultNo.getText().replace("results for","").replace(" ",""));
        System.out.println("DEV COMMENTS:Number of articles for desired term and applied filters in Cellphone & Accessories department is "
                           +NumberOfResults);
        return NumberOfResults;
    }
}
