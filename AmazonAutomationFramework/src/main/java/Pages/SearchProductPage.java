package Pages;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage {
	 WebDriver driver;	 

 public  SearchProductPage(WebDriver driver) {
	this.driver=driver;

	PageFactory.initElements(driver, this);
}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchTextBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;

	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
	WebElement firstSearchedProduct;
	
   @FindBy(id="buy-now-button")
    WebElement buyNowButton;

	public void searchProduct(String product)
	{
		searchTextBox.sendKeys(product);
		searchButton.click();
	}

	public void clickSearchedProduct(){
 
       firstSearchedProduct.click();

	}

	public void buyProduct(){
        //switching between windows
		Set<String> windows=driver.getWindowHandles();
		Iterator<String>it =windows.iterator();
		it.next();
		String childId= it.next();
		driver.switchTo().window(childId); 
		buyNowButton.click();
	}

}


