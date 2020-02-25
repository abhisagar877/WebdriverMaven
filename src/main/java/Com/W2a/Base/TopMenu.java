package Com.W2a.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Com.W2a.pages.crm.accounts.Accountspage;

public class TopMenu {
/*
 * 
 * TopMenu ISA Page ??
 * 
 * HomePage HASA TopMenu
 * AccontsPage HASA TopMenu
 * 
 * page HASA TopMenu
 */
	WebDriver driver;
	
	public TopMenu(WebDriver driver) {
		this.driver=driver;
		
	}
	public void gotoHome() {
		
	}
	
public void gotoLeads() {
		
	}

public void gotoContact() {
	
}

public Accountspage gotoAccounts()  {
	driver.findElement(By.xpath("//*[@id=\"mainMenuTabDiv\"]/crm-menu/div[1]/crm-tab/div[2]/div[4]/a")).click();
	return new Accountspage();
	
}

public void gotoDeal() {
	
}

public void gotoActivity() {
	
}

public void gotoReports() {
	
}

public void Signout() {
	
}
}
