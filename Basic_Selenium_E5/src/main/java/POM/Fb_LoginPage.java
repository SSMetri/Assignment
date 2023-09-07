package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fb_LoginPage 
{
	//DECLERATION
	//Address of email text field
	@FindBy(id="email")
	private WebElement emailTf;
	
	//Address of Password fiels
	@FindBy(xpath="//input[@id='pass']")
	private WebElement passTf;
	
	//Address of login button
	@FindBy(xpath="//button[@name='login']")
	private WebElement loginBtn;
	
	//INITIALIZATION
	public Fb_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//UTILIZATION
	//All in single method
	public void allMethods(String value1,String value2)
	{
		emailTf.sendKeys(value1);
		passTf.sendKeys(value2);
		loginBtn.click();
	}
	//initializing individually
	public void emailTextField(String value)
	{
		emailTf.sendKeys(value);
	}
	public void passTextField(String value)
	{
		passTf.sendKeys(value);
	}
	public void loginButton()
	{
		loginBtn.click();
	}

	//Generating GETTER & SETTER METHODS

	public WebElement getEmailTf() {
		return emailTf;
	}

	public void setEmailTf(WebElement emailTf) {
		this.emailTf = emailTf;
	}

	public WebElement getPassTf() {
		return passTf;
	}

	public void setPassTf(WebElement passTf) {
		this.passTf = passTf;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(WebElement loginBtn) {
		this.loginBtn = loginBtn;
	}
	
	
	
	
}
