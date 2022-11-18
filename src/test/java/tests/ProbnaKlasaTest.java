package tests;


import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.AmazonSelectedArticlePage;

import java.util.List;

public class ProbnaKlasaTest extends BaseTest
{
    @Test
    public void proba() throws InterruptedException {

        String term = "Iphone 13" ;
        String[] split = term.split(" ");


       // driver.get("https://www.amazon.com/iPhone-Pro-128GB-Sierra-Blue/dp/B0BGYF4CZF/ref=sr_1_1?crid=23RWZOQJUNU07&keywords=iphone%2B13&qid=1668606384&refinements=p_89%3AApple%2Cp_36%3A80000-130000%2Cp_n_feature_twelve_browse-bin%3A14674911011&rnid=14674904011&s=wireless&sprefix=iphone%2B13%2Caps%2C195&sr=1-1&th=1");
      //  WebElement colorCont = driver.findElement(By.id("variation_color_name"));// BLIZU 1
       // List<WebElement> listOfColors = colorCont.findElements(By.className("a-row")); BLIZU 1
        //List<WebElement> listOfColors = colorCont.findElements(By.className("selection"));


       // for (WebElement list:listOfColors){
      //      System.out.println(list.getText());
      //  }

       /* driver.get("https://www.amazon.com/iPhone-Pro-128GB-Sierra-Blue/dp/B0BGYF4CZF/ref=sr_1_1?crid=2S3961EYSRHOZ&keywords=iphone%2B13&qid=1668681109&refinements=p_89%3AApple%2Cp_36%3A80000-130000%2Cp_n_feature_twelve_browse-bin%3A14674911011&rnid=14674904011&s=wireless&sprefix=iphone%2B13%2Caps%2C181&sr=1-1&th=1");
        WebElement cartCount = driver.findElement(By.id("nav-cart-count"));
        WebElement button = driver.findElement(By.id("add-to-cart-button"));

        Select selectQty = new Select(driver.findElement(By.name("quantity")));
        System.out.println(selectQty.getOptions());
        selectQty.selectByValue("3");


        System.out.println(cartCount.getText());
        Thread.sleep(2000);
        button.click();
        //wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("attach-warranty-button-row")));
        //WebElement cont = driver.findElement(By.className("attach-warranty-button-row"));
        //List<WebElement> but =cont.findElements(By.className("a-button-inner"));
        //System.out.println(but.size());

     //wdWait.until(ExpectedConditions.elementToBeClickable(but.get(1)));
     //but.get(1).click();*/


       driver.get("https://www.amazon.com/");








        Thread.sleep(50000);
    }
}
