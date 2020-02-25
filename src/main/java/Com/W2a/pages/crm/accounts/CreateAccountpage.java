package Com.W2a.pages.crm.accounts;

import org.openqa.selenium.By;

import Com.W2a.Base.Page;


public class CreateAccountpage  extends Page {

	public void creatAccount(String accountName) {
		
		driver.findElement(By.xpath("//*[@id=\"Crm_Accounts_ACCOUNTNAME\"]")).sendKeys(accountName);
	}
	
	
	
}
