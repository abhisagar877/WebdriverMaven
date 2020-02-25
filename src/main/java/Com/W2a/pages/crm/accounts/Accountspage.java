package Com.W2a.pages.crm.accounts;

import org.openqa.selenium.By;

import Com.W2a.Base.Page;

public class Accountspage  extends Page {
	
	
	public CreateAccountpage  gotocreateAccounts() {
		driver.findElement(By.xpath("//*[@id=\"topRightIcons\"]/span[1]/link-to/button")).click();
		return new CreateAccountpage();
	}
	public void gotoImportAccounts() {
		
	}

}
