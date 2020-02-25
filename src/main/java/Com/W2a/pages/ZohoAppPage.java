package Com.W2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Com.W2a.Base.Page;
import Com.W2a.pages.crm.CRMHomePage;

public class ZohoAppPage extends Page{

	
	public void SalesHQ() {
		driver.findElement(By.xpath("//*[@id=\"zl-category-2\"]/div/ul/li[8]/div/a/p")).click();
	}
	
public CRMHomePage gotoCRM() {
		driver.findElement(By.xpath("//*[@id=\"zl-myapps\"]/div[1]/div[7]/div/a/span")).click();
		return new CRMHomePage();
		
	}
public void Chat() {
	driver.findElement(By.xpath("//*[@id=\"zl-myapps\"]/div[1]/div[4]/div/a/span")).click();
}
}
