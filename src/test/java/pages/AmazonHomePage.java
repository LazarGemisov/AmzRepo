package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AmazonHomePage extends BaseHelper {

    WebDriver driver;
    public AmazonHomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy (className = "glow-toaster-button-dismiss")
    WebElement dontChangeShippingAddressButton;
    @FindBy (id="nav-link-accountList")
    WebElement singInButton;

    @FindBy (id = "ap_email")
    WebElement emailTxtField;
    @FindBy(id = "continue")
    WebElement emailContinueButton;

    @FindBy (id = "ap_password")
    WebElement passTxtField;
    @FindBy (id = "signInSubmit")
    WebElement submitSignIn;

    @FindBy (id = "twotabsearchtextbox")
    WebElement searchTxtFiled;

    @FindBy (className = "nav-search-submit")
    WebElement loupe;

    @FindBy (id="brandsRefinements")
    WebElement brandsContainer;
    @FindBy (className = "a-list-item")
    List<WebElement> listOfBrands;
    @FindBy (id = "nav-link-accountList-nav-line-1")
    WebElement userName;

    @FindBy (id = "nav-cart-count")
    WebElement cartCount;

    @FindBy (id = "nav-cart" )
    WebElement cartButton;
   @FindBy (className = "a-color-link" )
    WebElement deleteCart;

   @FindBy(id = "nav-logo-sprites" )
   WebElement homePageLogo;
   String signInMessage = "Hello, sign in";


    private void navigateToHomePage(String url){
        driver.get(url);
    }
    private void shipping(){
        if (dontChangeShippingAddressButton.isDisplayed() == true) {
            wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("glow-toaster-footer")));
            wdWait.until(ExpectedConditions.elementToBeClickable(By.className("glow-toaster-button-dismiss")));
            dontChangeShippingAddressButton.click();
        }
    }

    private void clickOnSingIn(){

      singInButton.click();

    }
    private void enterUsername(String username){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("auth-workflow")));
        emailTxtField.sendKeys(username);
        emailContinueButton.click();


    }
    private void enterPass (String pass){
        passTxtField.sendKeys(pass);
        submitSignIn.click();

    }
    private String checkForUser(){
        String checkForUserName = userName.getText();
        System.out.println("Ime logovanog korisnika je "+userName.getText());
        return checkForUserName;
    }

    private void checkForCartItems(){
        int cartDefaultValue = 0;
        int cartCurrentValue = Integer.parseInt(cartCount.getText());

        if (cartCurrentValue > cartDefaultValue){
            System.out.println("MISHKO BRAKEEEE WE HAVE SOMETHING IN SHOPPING CART");
        }else {
            System.out.println("DRIVE MISHKO CART IS NULL");
        }

    }
    private void clearShoppingCart()throws InterruptedException{
        //WebElement cartCount = driver.findElement(By.id("nav-cart-count"));
        System.out.println(cartCount.getText());
        //WebElement cartButton = driver.findElement(By.id("nav-cart"));
        cartButton.click();
        Thread.sleep(2000);
       // WebElement deleteCart = driver.findElement(By.className("a-color-link"));
        deleteCart.click();
        //WebElement homePageLogo = driver.findElement(By.id("nav-logo-sprites"));
        homePageLogo.click();
        System.out.println("MISHKO DRIVE WE HAD DELETE IT !!!");
    }

    private void inputSearchTerm (String term){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));
        searchTxtFiled.sendKeys(term);
        loupe.click();
    }

    private void selectBrand (String brand){

        for (WebElement list:listOfBrands){
            if (list.getText().toLowerCase().contains(brand.toLowerCase())){
               list.click();
               break;
            }

        }
    }



    public String searchTest (String url, String username,String pass,String term, String brand)throws InterruptedException{
        navigateToHomePage(url);
        shipping();

        if (userName.getText().contains(signInMessage)){
            clickOnSingIn();
            enterUsername(username);
            enterPass(pass);
        }
        checkForCartItems();

        String userDetails = checkForUser();
        int cartDefaultValue = 0;
        int cartCurrentValue = Integer.parseInt(cartCount.getText());
        if (cartCurrentValue>cartDefaultValue){
            clearShoppingCart();
        }
        Thread.sleep(2000);

        inputSearchTerm(term);
        selectBrand(brand);

        return userDetails;

    }



}
