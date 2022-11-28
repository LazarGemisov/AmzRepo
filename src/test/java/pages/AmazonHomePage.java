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

    @FindBy(className = "glow-toaster-content")
    WebElement shippingContainer;

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
    @FindBy (id = "nav-hamburger-menu" )
    WebElement hamburgerMenuBtn;
    @FindBy (id = "hmenu-content" )
    WebElement hamburgerMenuCont;
    @FindBy (className = "hmenu-translateX")
    WebElement subCategoryCont;

   /* @FindBy(id = "auth-warning-message-box")
    WebElement warningForSignIn;*/

    private void deleteAllCookies()  {
        driver.manage().deleteAllCookies();
    }
    private void navigateToHomePage(String url){
        driver.get(url);
    }
    private void shipping(){
            wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("glow-toaster-footer")));
            wdWait.until(ExpectedConditions.elementToBeClickable(By.className("glow-toaster-button-dismiss")));
            dontChangeShippingAddressButton.click();
    }

    private void clickOnSingIn(){
      wdWait.until(ExpectedConditions.elementToBeClickable(singInButton));
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

    /*private void confirmIdentity() throws InterruptedException {
        if (warningForSignIn.isDisplayed()) {
            Thread.sleep(15000);
        }
    }*/
    private String checkForUser(){
        String checkForUserName = userName.getText().replace("Hello","")
                                  .replace(",","").replace(" ","");
        System.out.println("DEV CHECK:Name of  logged in user is - "+checkForUserName);
        return checkForUserName;
    }
    private void checkForCartItems(){
        int cartDefaultValue = 0;
        int cartCurrentValue = Integer.parseInt(cartCount.getText());

        if (cartCurrentValue > cartDefaultValue){
            System.out.println("DEV CHECK: WE HAVE SOMETHING IN SHOPPING CART");
        }else {
            System.out.println("DEV CHECK: SHOPPING CART IS EMPTY ");
        }
    }
    private void clearShoppingCart(){
        cartButton.click();
        wdWait.until(ExpectedConditions.elementToBeClickable(deleteCart));
        deleteCart.click();homePageLogo.click();
        System.out.println("DEV CHECK: WE HAD DELETED EVERYTHING IN THE CART !!!");
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


    private void clickOnCategoryMenu(){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-hamburger-menu")));
        hamburgerMenuBtn.click();
    }
    private void clickOnCategory (String category) {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("hmenu-content")));
        List<WebElement> listOfCategories = hamburgerMenuCont.findElements(By.className("hmenu-item"));
        for (WebElement list:listOfCategories){
            if (list.getText().contains(category)) {
                list.click();
                break;
            }
        }
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("hmenu-translateX")));
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("hmenu-item")));
    }
    private void clickOnSubCategory(String subCategory){
        List<WebElement> listOfSubCategories = subCategoryCont.findElements(By.className("hmenu-item"));
        for (WebElement list:listOfSubCategories){
            if (list.getText().contains(subCategory)) {
                list.click();
                break;
            }
        }
    }



    public String amazonSearch(String url, String username, String pass, String term, String brand) throws InterruptedException {
        deleteAllCookies();
        navigateToHomePage(url);

        if (shippingContainer.isDisplayed()) {
            shipping();
        }

        if (userName.getText().contains(signInMessage)){
            clickOnSingIn();
            enterUsername(username);
            enterPass(pass);
        }
        //Thread.sleep(30000);//confirmAccount();
        checkForCartItems();

        String userDetails = checkForUser();
        int cartDefaultValue = 0;
        int cartCurrentValue = Integer.parseInt(cartCount.getText());
        if (cartCurrentValue>cartDefaultValue){
            clearShoppingCart();
        }
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));
        inputSearchTerm(term);
        selectBrand(brand);
        return userDetails;
    }

    //MARK: THIS FUNCTION IS FOR AMZ SEARCH THROUGH DEPARTMENTS TEST---------------------------------------------
    public String amzForDepartments(String url, String username, String pass, String category, String subCategory) throws InterruptedException {
        navigateToHomePage(url);
        if (dontChangeShippingAddressButton.isDisplayed()) {
            shipping();
        }
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
        Thread.sleep(1000);
        clickOnCategoryMenu();
        clickOnCategory(category);
        clickOnSubCategory(subCategory);
        return userDetails;
    }
}
