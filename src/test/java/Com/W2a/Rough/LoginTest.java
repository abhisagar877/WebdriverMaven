package Com.W2a.Rough;

import Com.W2a.Base.Page;
import Com.W2a.pages.HomePages;
import Com.W2a.pages.LoginPage;
import Com.W2a.pages.ZohoAppPage;
import Com.W2a.pages.crm.CRMHomePage;
import Com.W2a.pages.crm.accounts.Accountspage;
import Com.W2a.pages.crm.accounts.CreateAccountpage;

public class LoginTest {

	public static void main(String[] args)  {
		
	

		
		HomePages Home= new HomePages();
		LoginPage lp=Home.goToLogin();
		ZohoAppPage Zp=lp.doLogin("apapathak3@gmail.com", "Zoho@1987");
		Zp.gotoCRM();
		Page.menu.gotoAccounts();
		Accountspage account=Page.menu.gotoAccounts();
		account.gotocreateAccounts();
		CreateAccountpage cap=account.gotocreateAccounts();
		cap.creatAccount("Abhishek");
		
		
		
		

	}

}
