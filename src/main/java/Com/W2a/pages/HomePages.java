package Com.W2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Com.W2a.Base.Page;

public class HomePages extends Page {
	
	public static void main(String[] args) {
		
	}
	
public void goToSupport (){
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/a[2]")).click();
	}
	public void goToSignUp (){
		driver.findElement(By.cssSelector("#block-block-3 > div > div > div.zgh-utilities > div.zgh-accounts > a.zgh-signup")).click();
	}
	
public LoginPage goToLogin (){
	
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/a[4]")).click();
		return new LoginPage();
	}

public void goToZohoEdu (){
	
}

public void ValidateFooterLinks (){
	
}

}
