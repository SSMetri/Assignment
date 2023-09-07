package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanCalculationPage 
{
	//Decleration
	@FindBy(id="homeprice")
	private WebElement homepEle;
	
	@FindBy(id="downpayment")
	private WebElement dPaymnet;
	
	@FindBy(id="homeloaninsuranceamount")
	private WebElement homeLInsurance;
	
	@FindBy(xpath="//input[@id='homeloanamount']")
	private WebElement homeLoanAmt;
	
	@FindBy(id="startmonthyear")
	private WebElement startMonth;
	
	@FindBy(xpath="//span[text()='Sep']")
	private WebElement dateEle;
	
	@FindBy(xpath="//td[@id='monthlyprincipalandinterestterm']")
	private WebElement scrollEle;
	//Fine till scroll action
	
	@FindBy(xpath="//td[@id='monthlyprincipalandinterestdef']")
	private WebElement one;
	
	@FindBy(xpath="//td[@id='extraterm']")
	private WebElement two;
	
	@FindBy(xpath="//td[@id='extradef']")
	private WebElement three;
	
	@FindBy(xpath="//td[@id='monthlypropertytaxesterm']")//**
	private WebElement four;
	
	@FindBy(xpath="//td[@id='monthlypropertytaxesdef']")//**
	private WebElement five;
	
	@FindBy(xpath="//td[@id='monthlyhomeinsuranceterm']")//**
	private WebElement six;
	
	@FindBy(xpath="//td[@id='monthlyhomeinsurancedef']")//**
	private WebElement seven;
	
	@FindBy(xpath="//td[@id='monthlymaintenanceexpensesterm']")//**
	private WebElement eight;
	
	@FindBy(xpath="//td[@id='monthlymaintenanceexpensesdef']")
	private WebElement nine;
	
	@FindBy(xpath="//td[@class='col-8 aggregatelabel lastterm']")
	private WebElement ten;
	
	@FindBy(xpath="//td[@id='monthlypayment']")
	private WebElement eleven;	
	
	//AFter SOPL
	@FindBy(xpath="//div[@class='col-6 aggregatelabel lastterm']")
	private WebElement yearTotal;
	
	@FindBy(xpath="//div[@id='totalpayment']")
	private WebElement amt;	
	
	@FindBy(xpath="//div[@id='loanamountslider']//span[@class='ui-slider-handle ui-corner-all ui-state-default']")
	private WebElement pt1;	
	@FindBy(xpath="(//span[@style='left: 50%;'])[1]")
	private WebElement pt2;	
	
	@FindBy(xpath="//div[@id='loaninterestslider']//span[@class='ui-slider-handle ui-corner-all ui-state-default']")
	private WebElement r_int1;
	
	@FindBy(xpath="(//span[@style='left: 50%;'])[2]")
	private WebElement r_int2;	
	
	@FindBy(xpath="//div[@id='loantermslider']//span[@class='ui-slider-handle ui-corner-all ui-state-default']")
	private WebElement trnure;
	
	@FindBy(xpath="(//span[@style='left: 100%;'])[3]")
	private WebElement tenure_months;
	
	//Initialization
	public LoanCalculationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public void homeprice(String value)
	{
		homepEle.sendKeys(value);
	}
	
	public void downpayment(String value)
	{
		dPaymnet.sendKeys(value);
	}
	
	public void homeloaninsuranceamount(String value)
	{
		homeLInsurance.sendKeys(value);
	}
	
	public void homeloanamount(String value)
	{
		homeLoanAmt.sendKeys(value);
	}
	
	public void monthElement()
	{
		startMonth.click();
	}
	
	public void dateElement()
	{
		dateEle.click();
	}

	public WebElement getScrollEle() {
		return scrollEle;
	}
	//1 2 3 4 5......

	public String getOne() 
	{
		return one.getText();
	}

	public String getTwo() {
		return two.getText();
	}
	
	public String getThree() {
		return three.getText();
	}

	public String getFour() {
		return four.getText();
	}

	public String getFive() {
		return five.getText();
	}

	public String getSix() {
		return six.getText();
	}

	public String getSeven() {
		return seven.getText();
	}

	public String getEight() {
		return eight.getText();
	}

	public String getNine() {
		return nine.getText();
	}

	public String getTen() {
		return ten.getText();
	}

	public String getEleven() {
		return eleven.getText();
	}
	
	public String getYearTotal() {
		return yearTotal.getText();
	}

	public String getAmt() {
		return amt.getText();
	}

	public WebElement getPt1() {
		return pt1;
	}

	public WebElement getPt2() {
		return pt2;
	}

	public WebElement getR_int1() {
		return r_int1;
	}

	public WebElement getR_int2() {
		return r_int2;
	}

	public WebElement getTrnure() {
		return trnure;
	}

	public WebElement getTenure_months() {
		return tenure_months;
	}
	
	
	
	
	
	
	
	
	


	
	
	
}
