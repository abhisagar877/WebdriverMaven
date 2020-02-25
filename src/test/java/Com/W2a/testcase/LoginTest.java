package Com.W2a.testcase;

import java.util.Hashtable;

import org.testng.annotations.Test;

import Com.W2a.Base.Page;
import Com.W2a.pages.HomePages;
import Com.W2a.pages.LoginPage;
import Com.W2a.pages.ZohoAppPage;
import utilities.Utilities1;

public class LoginTest extends BaseTest {

	@Test(dataProviderClass=Utilities1.class,dataProvider = "dp")
	public void logintest(Hashtable<String,String> data) {
		
		HomePages Home= new HomePages();
		LoginPage lp=Home.goToLogin();
		ZohoAppPage Zp=lp.doLogin(data.get("Username"),data.get("Password") );
	}
}
