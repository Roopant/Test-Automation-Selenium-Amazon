package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	 WebDriver driver;	 

 public  CheckOutPage(WebDriver driver) {
	this.driver=driver;

	PageFactory.initElements(driver, this);
}
	
   @FindBy(xpath ="//div[contains(h1, 'Checkout')]")

   WebElement checkOutTextElement;

	public boolean validateCheckOutPageIsPresent(){
		return checkOutTextElement.isDisplayed();
		
	  }
	
}


