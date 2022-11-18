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

    @FindBy(name = "proceedToRetailCheckout")
    WebElement proceedBtn;

    private void setQty(String desiredQty) throws InterruptedException{
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("quantity")));
        Select selectQty = new Select(driver.findElement(By.name("quantity")));
        System.out.println(selectQty.getOptions());
        selectQty.selectByValue(desiredQty);
        Thread.sleep(5000);
    }
    private void clickOnAddToTheCartButton(){
        addToTheCartButton.click();
    }

    private void warrantyPopUp(){
        WebElement popUp = driver.findElement(By.className("attach-warranty-button-row"));
        if (popUp.isDisplayed()) {
            //wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("attach-warranty-button-row")));
            List<WebElement> buttonList = buttonsContainer.findElements(By.className("a-button-inner"));
            wdWait.until(ExpectedConditions.elementToBeClickable(buttonList.get(1)));
            buttonList.get(1).click();
        }
    }

    private void proceedToCheckout(){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("sw-atc-confirmation")));
        wdWait.until(ExpectedConditions.elementToBeClickable(proceedBtn));
        proceedBtn.click();
    }

    public void addToTheCart(String desiredQty) throws InterruptedException{
        setQty(desiredQty);
        clickOnAddToTheCartButton();
       // warrantyPopUp();
        proceedToCheckout();

    }









}
