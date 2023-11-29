package Swag;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EvenOrOdd {
	
	WebDriver driver= new ChromeDriver();

	
@BeforeTest
public void SetUp() {
	
	driver.get("https://www.saucedemo.com/v1/") ;
	
}

@Test()
public void myTest() {
	 WebElement User=driver.findElement(By.id("user-name"));
	 User.sendKeys("standard_user");
	 WebElement Password=driver.findElement(By.id("password"));
	 Password.sendKeys("secret_sauce");
	 
	 WebElement Login=driver.findElement(By.id("login-button"));
	 Login.click();
	 
	 
	 List<WebElement> ItemsToAdd= driver.findElements(By.className("btn_inventory"));
	 List<WebElement> ItemsName= driver.findElements(By.className("inventory_item_name"));
	 List<WebElement> ItemsPrice= driver.findElements(By.className("inventory_item_price"));
	 
	 for(int i=0 ; i< ItemsName.size() ; i++) {
		 
		ItemsToAdd.get(i).click();
		 
		String mYitems = ItemsName.get(i).getText();
		String  pricefirst=ItemsPrice.get(i).getText();
		String editPrice= pricefirst.replace("$" ," ");
		double  therealPrice=Double.parseDouble(editPrice);
		double  Tax=therealPrice*0.10 ;
		double finalprice=therealPrice+Tax ;
		int intprice = (int)finalprice;

		
		if  ( intprice %2 ==0 ) {
			
			System.out.println( "my item is" + mYitems +" and Its Price is  " + finalprice +" **the final price is an Even number ** ");

		}else {
			
			System.out.println( "my item is" + mYitems +" and Its Price is  " + finalprice +"** the final price is an odd number ** ");
		}
		 }

}
 
@AfterTest 
public void PostTesting() {}


}
