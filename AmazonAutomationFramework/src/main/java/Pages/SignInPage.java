package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	 WebDriver driver;
	 
public  SignInPage(WebDriver driver) {
	
	this.driver=driver;
	
	PageFactory.initElements(driver, this);
}
	@FindBy(id="ap_email")
	WebElement emailOrMobileTextBox;
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	@FindBy(id="ap_password")
	WebElement passwordTextBox;
	
	@FindBy(id="signInSubmit")
	WebElement signInButton;
	
	public void signInApplication(String email,String password)
	{
		emailOrMobileTextBox.sendKeys(email);
		continueButton.click();
		passwordTextBox.sendKeys(password);
		signInButton.click();
	}
}