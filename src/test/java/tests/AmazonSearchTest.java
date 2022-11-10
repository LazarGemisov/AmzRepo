package tests;

import org.junit.Test;
import pages.AmazonHomePage;

public class AmazonSearchTest extends BaseTest{

    @Test
    public void amzSearchTest() throws InterruptedException {

        String url = "https://www.amazon.com/";
        String username ="lazargemisov@gmail.com";
        String pass = "Laki123456";
        String term = "Lightsaber";

        AmazonHomePage amzSearch = new AmazonHomePage(driver);

        amzSearch.searchTest(url,username,pass,term);


        Thread.sleep(5000);
    }


}
