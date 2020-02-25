package Com.W2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Com.W2a.Base.Page;

public class LoginPage extends Page {
	
	public LoginPage() {
		
	}
	
	public ZohoAppPage doLogin(String username,String password) {
		
		WebElement Email = driver.findElement(By.xpath("//*[@id=\"login_id\"]"));
		type("email_xpath",username);
		click("Next_xpath");
		type("password_xpath",password);
		click("Signbtn_xpath");
		
		return new ZohoAppPage();
		
	}
public void gotoSalesMarketing() {
	
}
}
