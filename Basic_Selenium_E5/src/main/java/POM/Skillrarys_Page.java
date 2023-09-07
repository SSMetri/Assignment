package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Skillrarys_Page 
{
	//Decleration
	//Course elemt
	@FindBy(xpath="//a[@id='course']")
	private WebElement course;
	
	//Selenium element
	@FindBy(xpath="(//a[text()='Selenium Training'])[1]")
	private WebElement selenium;
	
	//Initialization
	public Skillrarys_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Decleration
	public WebElement getCourse() {
		return course;
	}

	public void seleniumElemet()
	{
		selenium.click();
	}
	

}
