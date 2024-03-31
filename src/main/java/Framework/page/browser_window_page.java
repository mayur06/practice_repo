package Framework.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Framework.base.TestsBases;

public class browser_window_page extends TestsBases {

	@FindBy(xpath="//*[contains(text(),'Forms')]")
	WebElement forms_page;
	
	@FindBy(xpath="//span[contains(text(),'Practice Form')]")
	WebElement practice_form;
	
	@FindBy(xpath="//input[@id='dateOfBirthInput']")
	WebElement dob;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	WebElement month_select;
	
	@FindBy(xpath="//button[contains(text(),'Previous Month')]")
	WebElement dec_select;
	
	@FindBy(xpath="//div[contains(text(),'17')]")
	WebElement date_seventeen;
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']")
	WebElement year_select;
	
	public browser_window_page() {
		PageFactory.initElements(driver, this);
	}
	
	public void browser_window_page_first() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(1000);
		forms_page.click();
		Thread.sleep(1000);
		practice_form.click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(1000);
		dob.click();
		Thread.sleep(1000);
		month_select.click();
		month_select.sendKeys("December");
		month_select.click();
		Thread.sleep(2000);
		//dec_select.click();
		//date_fourteen.click();
		year_select.click();
		year_select.sendKeys("1996");
		year_select.click();
		date_seventeen.click();
	}
	
}
