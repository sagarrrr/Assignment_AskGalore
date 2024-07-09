package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.testbase;
import pages.loginpage;

public class logintest extends testbase {
	
	loginpage loginpage;
	public logintest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		
		initiliaze();
		 loginpage  = new loginpage();

		
	}
	
	
	@Test (priority=1,description="Verify that when the tenant enters an invalid business email in the+"
			+ " field box and a valid organisation name, it shows an error message \"Invalid email format \".")
	public void negativeScenario() {
		loginpage.credentials(prop.getProperty("username"), prop.getProperty("password"));
		
		//loginpage.credentials(prop.getProperty("username2"), prop.getProperty("password2"));
		String expectedEmailVAlue = loginpage.emailValue();
		String actualEmailValue="Invalid email format";
		Assert.assertEquals(actualEmailValue,expectedEmailVAlue );


		
	}
	@Test (priority=2,description="Verify that when the tenant clicks on the hyperlink text+"
			+ " \"Sign up\" on the Sign In page, it opens the \"Technical Prerequisites for 3TRADE Registration\" page.")
	public void postiveScenario() {
		
		loginpage.validation();
		 String ExpectedValue= loginpage.textValue();
		String ActualValue="Technical Prerequisites for 3TRADE Registration";
		
		Assert.assertEquals(ActualValue,ExpectedValue );
			
	}
	
	@AfterMethod (enabled=false)
	public void logoff() {
		
		driver.quit();
	}
	
}
