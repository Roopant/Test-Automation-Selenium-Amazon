package testassignment;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import org.testng.Assert;
import Pages.CheckOutPage;
import Pages.SearchProductPage;
import Pages.SignInPage;
import testcomponents.BaseTest;
import testcomponents.ExcelUtil;

public class AmazonTest extends BaseTest{
	
	
	@DataProvider
	public Object [] getData() throws IOException {
		return ExcelUtil.getDataFromExcel();	
	}
	
	
	//Data Parameterization
	@Test(dataProvider="getData")
	public void buyProduct1(HashMap<String,String>input) throws InterruptedException, IOException {
		SignInPage signinpage= new SignInPage(driver);
		SearchProductPage searchProductPage= new SearchProductPage(driver);
		CheckOutPage checkOutPage= new CheckOutPage(driver);
		Thread.sleep(3000);
		homepage.goToSignInButton();
		signinpage.signInApplication(input.get("email"),input.get("pwd"));
		Assert.assertTrue(homepage.getSignedInUserName().contains(input.get("user")),"Sign In Failed");
		searchProductPage.searchProduct("ipad pro");
		searchProductPage.clickSearchedProduct();
		searchProductPage.buyProduct();
		Assert.assertTrue(checkOutPage.validateCheckOutPageIsPresent(),"User is not on Checkout Page");
		
	}


}