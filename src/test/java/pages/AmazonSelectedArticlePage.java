package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonSelectedArticlePage extends BaseHelper {
    WebDriver driver;
    public AmazonSelectedArticlePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (id = "nav-cart-count")
    WebElement cartCount;
    @FindBy (id = "add-to-cart-button")
    WebElement addToTheCartButton;

    @FindBy (className = "attach-warranty-button-row")
    WebElement buttonsContainer;

    @FindBy(className = "attach-checkout-button") //"proceedToRetailCheckout" old class name of button in popup window
    WebElement proceedBtn;
   @FindBy (className = "attach-warranty-button-row" )
    WebElement popUp;

    private void setQty(String desiredQty, String desiredColor) throws InterruptedException{
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("quantity")));
        wdWait.until(ExpectedConditions.elementToBeClickable(By.name("quantity")));
        WebElement colorCont = driver.findElement(By.id("variation_color_name"));
        WebElement colorName = colorCont.findElement(By.className("a-row"));
        if (colorName.getText().contains(desiredColor)) {
            Select selectQty = new Select(driver.findElement(By.name("quantity")));
            selectQty.selectByValue(desiredQty);
            Thread.sleep(2000);
        }
    }

    private void setColor(String desiredColor) throws InterruptedException {
        WebElement colorCont = driver.findElement(By.id("variation_color_name"));
        WebElement clrCont = colorCont.findElement(By.className("swatchesSquare"));
        List<WebElement>listOfColors = clrCont.findElements(By.tagName("img"));
        List<WebElement> listOfButtons = clrCont.findElements(By.className("a-button-text"));

        int i = 0;
        for (WebElement list:listOfColors){
            String colorName = listOfColors.get(i).getAttribute("alt");
            if (desiredColor.toLowerCase().contains(colorName.toLowerCase())){
                listOfButtons.get(i).click();
                break;
            }
            i++;

        }
        Thread.sleep(2000);
    }
    private void clickOnAddToTheCartButton(){
        addToTheCartButton.click();
    }

    private void warrantyPopUp() throws InterruptedException {
        // MARK: THIS IS ONLY DISPLAYED ONCE, AND YOUR ACCOUNT REMEMBERS YOUR PREFERENCES
       // WebElement popUp = driver.findElement(By.className("attach-warranty-button-row"));
        if (popUp.isDisplayed()) {
            wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("attach-warranty-button-row")));
            List<WebElement> buttonList = buttonsContainer.findElements(By.className("a-button-inner"));
           wdWait.until(ExpectedConditions.elementToBeClickable(buttonList.get(1)));
            buttonList.get(1).click();


        }
    }

    private void proceedToCheckout(){
        //wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("sw-atc-confirmation"))); old version of popup window
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("attach-primary-atc-confirm-box")));
       wdWait.until(ExpectedConditions.elementToBeClickable(proceedBtn));
        proceedBtn.click();
    }

    public void addToTheCart(String desiredQty,String desiredColor) throws InterruptedException{
        setColor(desiredColor);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("quantity")));//Thread.sleep(2000);
        wdWait.until(ExpectedConditions.elementToBeClickable(By.name("quantity")));
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("quantity")));
        wdWait.until(ExpectedConditions.elementToBeClickable(addToTheCartButton));
        setQty(desiredQty,desiredColor);
        clickOnAddToTheCartButton();
        Thread.sleep(2000);
        warrantyPopUp();
        proceedToCheckout();
    }
}
