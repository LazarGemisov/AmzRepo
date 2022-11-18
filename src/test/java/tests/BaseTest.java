package tests;

import helpers.BaseHelper;
import org.junit.After;
import org.junit.Before;


public class BaseTest extends BaseHelper


{
    String url = "https://www.amazon.com/";
    String username ="lazargemisov@gmail.com";
    String pass = "Laki123456";
    String searchTerm = "Iphone 13";
    String[] termSplitted = searchTerm.split(" ") ;
    String brand = "Apple";

    String lowPrice = "800";
    int lowPriceInt = Integer.parseInt(lowPrice);
    String highPrice = "1300";
    int highPriceInt = Integer.parseInt(highPrice);

    String phoneMemory = "128 GB";
    String phoneMemoryTogether = phoneMemory.replace(" ", "");
    int desiredArticle = 1;

    String desiredQuantity = "3";

    @Before
    public void testInit()
    {
        driver.manage().window().maximize();
    }

    @After
    public void testTearDown() {
        driver.close();
        driver.quit();
    }

}