package Com.W2a.testcase;

import org.testng.annotations.AfterSuite;

import Com.W2a.Base.Page;

public class BaseTest {

	
	@AfterSuite
	public void tearDown() {
		Page.Quit();
	}
}
