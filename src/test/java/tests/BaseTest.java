package tests;

import helpers.BaseHelper;
import org.junit.After;
import org.junit.Before;


public class BaseTest extends BaseHelper {
    String url = "https://www.amazon.com/";
    String username ="lazargemisov@gmail.com";
    String lastName = "Gemišov";
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
    String desiredColor = "Graphite";
    String desiredQuantity = "3";
    String validTest = "true";
    String category = "Electronics";
    String subCategory = "Cell Phones & Accessories";

    String devSummary = "DEV SUMMARY: WHILE TESTING DEPARTMENTS I HAD OBSERVED THAT WHEN WE ENTER CellPhone&Accessories DEPARTMENT " +
                         "THERE IS A LACK OF FILTER"+System.lineSeparator()+
                        "FOR SEARCHING PHONES, LIKE THERE IS WHEN YOU SEARCH ALL DEPARTMENTS I WOULD RAISE A BUG FOR THAT, " +
                        "ALSO WHILE MANUALLY"+System.lineSeparator()+
                        "TESTING ON MOBILE BROWSER I HAD NOTICED DIFFERENT CellPhone&Accessories HOME PAGE " +
                         "SCREENSHOT IS ATTACHED IN THIS PROJECT"+System.lineSeparator()+
                            "DEV SUMMARY: END";
        // driver clear cash // chrome options
        // task 2 iz filtera categorija
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