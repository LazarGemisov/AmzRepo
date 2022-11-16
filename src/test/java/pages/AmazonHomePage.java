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
    WebElement dontChangeShipingAdressButton;


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




    private void navigateToHomePage(String url){
        driver.get(url);
    }
    private void shipping(){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("glow-toaster-footer")));
        wdWait.until(ExpectedConditions.elementToBeClickable(By.className("glow-toaster-button-dismiss")));

        dontChangeShipingAdressButton.click();
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

    public void searchTest (String url, String username,String pass,String term, String brand){
        navigateToHomePage(url);
        shipping();
        clickOnSingIn();
        enterUsername(username);
        enterPass(pass);
        inputSearchTerm(term);
        selectBrand(brand);

    }

}
