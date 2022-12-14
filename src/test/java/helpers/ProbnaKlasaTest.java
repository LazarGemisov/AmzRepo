package helpers;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

public class ProbnaKlasaTest extends BaseTest
{
    @Test
    public void proba() throws InterruptedException {

        String term = "Iphone 13" ;
        String[] split = term.split(" ");
        driver.get("https://www.amazon.com/iPhone-Pro-128GB-Sierra-Blue/dp/B0BGY8SNQQ/ref=sr_1_1?crid=27K83XRUW99S4&keywords=iphone%2B13&qid=1669507020&refinements=p_89%3AApple%2Cp_36%3A80000-130000&rnid=2491154011&s=wireless&sprefix=iphone%2B13%2Caps%2C294&sr=1-1&th=1");
        WebElement test = driver.findElement(By.id("sellYoursHere_feature_div"));
        WebElement test2=test.findElement(By.className("sdpText"));
        System.out.println(test2.getText());
        /* driver.get("https://www.amazon.com/s?k=iphone+13&i=electronics&rh=n%3A2811119011%2Cp_36%3A80000-130000&qid=1669293338&rnid=386442011&ref=sr_nr_p_36_4");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("s-result-list")));
        WebElement categoryAndFilterCont = driver.findElement(By.className("s-result-list"));
        List<WebElement> listOfResults = categoryAndFilterCont.findElements(By.className("s-card-container"));
        List<WebElement>listOfTitels = categoryAndFilterCont.findElements(By.className("a-size-base-plus"));
        System.out.println(listOfResults.size());
        System.out.println("Titla ima "+listOfTitels.size());

        WebElement resultNoCont = driver.findElement(By.className("template=RESULT_INFO_BAR"));
        //WebElement resultNo = resultNoCont.findElement(By.className("a-spacing-top-small"));
        WebElement resultNo = resultNoCont.findElement(By.tagName("span"));
        System.out.println(resultNo.getText());
        int no = Integer.parseInt(resultNo.getText().replace("results for","").replace(" ",""));
        System.out.println("broj je "+no);

        int i = 0;
        for (WebElement list:listOfTitels){
            String confirmForPresenceOfTermInArticle = "";
            if (i<no && listOfTitels.get(i).getText().toLowerCase().contains(term.toLowerCase())) {
                System.out.println("WE HAD FOUND THAT ARTICLE No."+i+" TITLES CONTAIN SEARCH TERM");

            }
            i++;

        }


        for (WebElement list:listOfTitels){

            Assert.assertTrue("ALL ARTICLES DONT CONTAIN SEARCH TERM",
                    list.getText().toLowerCase().contains(term.toLowerCase()));

        }



        WebElement alDepResults = driver.findElement(By.className("sg-row"));
        WebElement allDepartmentsCont = driver.findElement(By.className("s-result-item"));
        //  WebElement allDepartmentSize = allDepartmentsCont.findElement(By.className("s-underline-text"));
        WebElement test = categoryAndFilterCont.findElement(By.className("widgetId=sparse-category-correction"));
        List<WebElement>testList = test.findElements(By.className("s-result-item"));


        WebElement testSize = testList.get(0).findElement(By.className("s-underline-link-text"));

        int sizeForAllDepartments = Integer.parseInt(testSize.getText().replace("See all ","").replace(" results",""));

        System.out.println("broj u svim departmentima je "+sizeForAllDepartments);



       // driver.get("https://www.amazon.com/iPhone-Pro-128GB-Sierra-Blue/dp/B0BGYF4CZF/ref=sr_1_1?crid=23RWZOQJUNU07&keywords=iphone%2B13&qid=1668606384&refinements=p_89%3AApple%2Cp_36%3A80000-130000%2Cp_n_feature_twelve_browse-bin%3A14674911011&rnid=14674904011&s=wireless&sprefix=iphone%2B13%2Caps%2C195&sr=1-1&th=1");
      //  WebElement colorCont = driver.findElement(By.id("variation_color_name"));// BLIZU 1
       // List<WebElement> listOfColors = colorCont.findElements(By.className("a-row")); BLIZU 1
        //List<WebElement> listOfColors = colorCont.findElements(By.className("selection"));


       // for (WebElement list:listOfColors){
      //      System.out.println(list.getText());
      //  }/*

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


      /* driver.get("https://www.amazon.com/iPhone-Pro-128GB-Sierra-Blue/dp/B0BGYF4CZF/ref=sr_1_1?crid=2P8FQB2MNTD3S&keywords=iphone%2B13&qid=1669206395&s=wireless&sprefix=%2Cmobile%2C251&sr=1-1&th=1");
        String desiredColor = "Silver";
        WebElement colorCont = driver.findElement(By.id("variation_color_name"));
        WebElement clrCont = colorCont.findElement(By.className("swatchesSquare"));
        List<WebElement>listOfColors = clrCont.findElements(By.tagName("img"));
        List<WebElement> listOfButtons = clrCont.findElements(By.className("a-button-text"));
        WebElement colorNameTag = colorCont.findElement(By.className("a-row"));
        System.out.println("naziv boje je"+colorNameTag.getText());
        System.out.println("buttons "+listOfButtons.size());
        System.out.println(listOfColors.size());
        listOfButtons.get(1).click();
        int i = 0;
        for (WebElement list:listOfColors){
            String colorName = listOfColors.get(i).getAttribute("alt");
            System.out.println(colorName);
            if (desiredColor.toLowerCase().contains(colorName.toLowerCase())){
                listOfButtons.get(i).click();
                System.out.println("naziv boje posle  "+colorNameTag.getText());
                break;
            }
            i++;

        }
*/


        Thread.sleep(5000);
    }
}
