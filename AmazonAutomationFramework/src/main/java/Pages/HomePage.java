package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	 WebDriver driver;	 

 public  HomePage(WebDriver driver) {
	this.driver=driver;

	PageFactory.initElements(driver, this);
}

	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement accountListLink;
		
	
	public void goTo()
	{
	
		driver.get("https://www.amazon.in/");
	}
	
	public void goToSignInButton()
	{
		accountListLink.click();
	}

	
	public String getSignedInUserName(){
      String userName= accountListLink.getText();
	  return userName; 
	}
	 
}


