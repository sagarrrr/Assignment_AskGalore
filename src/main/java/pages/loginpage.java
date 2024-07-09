package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.testbase;

public class loginpage extends testbase {
	
	@FindBy(xpath = ("//input[@placeholder='Email']"))
	WebElement email;
	
	@FindBy(xpath = ("//input[@placeholder='Password']"))
	WebElement password;
	
	
	@FindBy(xpath = ("//button[@type='submit']"))
	WebElement submit;
	
	@FindBy(xpath = ("//a[@class='text-indigo-600 hover:underline !text-[#2970FF]']"))
	WebElement signup;
	
	@FindBy(xpath=("//div[@class='flex items-center text-[#121926] dark:text-[#FCFCFD] text-[18px] font-[600] leading-[27px]']"))
	WebElement ActualValue;
	
	@FindBy(xpath=("//div[contains(text(),'Invalid email format')]"))
	WebElement InvalidEmail;
	

	
	
	public loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	public void credentials(String un, String pw) {
		email.sendKeys(un);
		password.sendKeys(pw);
		//email.clear();
		//password.clear();
		submit.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		}
	
	public void validation() {
		signup.click();
		
	}
	
	public String textValue() {
		String	ActualText = ActualValue.getText();
		return ActualText;
		
	}
	
	public String emailValue() {
		String ActualEmail= InvalidEmail.getText();
		return ActualEmail;
	}
	
	
	
	
	
	

}
