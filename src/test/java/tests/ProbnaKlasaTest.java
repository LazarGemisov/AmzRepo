package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProbnaKlasaTest extends BaseTest
{
    @Test
    public void proba() throws InterruptedException {


        String term = "Iphone 13" ;
        String[] split = term.split(" ");



       // driver.get("https://www.amazon.com/s?k=lightsaber&sprefix=lightsaber%2Caps%2C212&ref=nb_sb_ss_pltr-ranker-24hours_2_10");
        driver.get("https://www.amazon.com/s?k=Iphone+13&i=mobile&rh=n%3A7072561011%2Cp_89%3AApple%2Cp_n_feature_twelve_browse-bin%3A14674911011%2Cp_36%3A80000-130000&dc&crid=1W3T5Y2X1QWAP&qid=1668521482&rnid=14674871011&sprefix=iphone+13%2Caps%2C184&ref=sr_nr_p_36_1");
        WebElement filterResultsCont = driver.findElement(By.className("s-search-results"));
        WebElement numberOfResults = driver.findElement(By.className("s-breadcrumb"));
        List<WebElement> listOfAllFilteredResults = filterResultsCont.findElements(By.className("s-widget-spacing-small"));
        System.out.println(listOfAllFilteredResults.size());
        List<WebElement> listOfPrices = filterResultsCont.findElements(By.className("a-price-whole"));



        int numberOfResultsInt = listOfAllFilteredResults.size();

        System.out.println(listOfPrices.size());


        int i = 0;
       for (WebElement listOfTitles:listOfPrices) {

           if (i < numberOfResultsInt-1){
               System.out.println(listOfPrices.get(i).getText());

               i++;
           }else{
               break;
           }



        }




        Thread.sleep(8000);
    }
}
