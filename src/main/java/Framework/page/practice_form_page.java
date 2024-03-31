package Framework.page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Framework.base.TestsBases;
import org.openqa.selenium.Keys;

public class practice_form_page extends TestsBases {
	
	@FindBy(xpath="//*[contains(text(),'Forms')]")
	WebElement forms;
	
	@FindBy(xpath="//span[contains(text(),'Practice Form')]")
	WebElement practice_forms;
	
	//forms xpath
	@FindBy(xpath="//input[@id='firstName']")
	WebElement firstname_forms;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lastname_forms;
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement useremail_forms;
	
	@FindBy(xpath="//label[@for='gender-radio-1']")
	WebElement gender_male;
	
	@FindBy(xpath="//input[@id='userNumber']")
	WebElement mobile_number;
	
	@FindBy(xpath="//input[@id='subjectsInput']")
	WebElement subjects_input_form;
	
	@FindBy(xpath="//label[@for='hobbies-checkbox-1']")
	WebElement hobbies_sports;
	
	@FindBy(xpath="//label[@for='hobbies-checkbox-3']")
	WebElement hobbies_music;
	
	@FindBy(xpath="//input[@id='uploadPicture']")
	WebElement select_picture;
	
	@FindBy(xpath="//textarea[@id='currentAddress']")
	WebElement curr_add_form;
	
	@FindBy(xpath="(//div[@class=' css-tlfecz-indicatorContainer'])[1]")
	WebElement state_dropdown;
	
	@FindBy(xpath="//div[contains(text(),'NCR')]")
	WebElement ncr_selected;
	
	@FindBy(xpath="(//div[@class=' css-tlfecz-indicatorContainer'])[2]")
	WebElement city_dropdown;
	
	@FindBy(xpath="//div[@class=' css-1wa3eu0-placeholder']")
	WebElement city_opt;
	
	@FindBy(xpath="//div[contains(text(),'Delhi')]")
	WebElement delhi_selected;
	
	@FindBy(xpath="//button[@id='submit']")	
	WebElement submit_button;
	
	@FindBy(xpath="//input[@id='dateOfBirthInput']")
	WebElement dob;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	WebElement month_select;
	
	@FindBy(xpath="//button[contains(text(),'Previous Month')]")
	WebElement dec_select;
	
	@FindBy(xpath="//div[contains(text(),'14')]")
	WebElement date_fourteen;
	
	@FindBy(xpath="//div[contains(text(),'17')]")
	WebElement date_seventeen;
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']")
	WebElement year_select;
	
	public practice_form_page() {
		PageFactory.initElements(driver, this);
	}
	
	public void practice_form_page_first() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		forms.click();
		Thread.sleep(2000);
		practice_forms.click();
		Thread.sleep(1000);
		firstname_forms.sendKeys("practice first name");
		lastname_forms.sendKeys("practice last name");
		useremail_forms.sendKeys("abc@gmail.com");
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1000);
		gender_male.click();
		mobile_number.sendKeys("1234567890");
		dob.click();
		Thread.sleep(1000);
		//This is date select by moving backward
//		month_select.click();
//		dec_select.click();
//		date_fourteen.click();
		
		//This is date select date of birth 17 dec 1996
		month_select.click();
		month_select.sendKeys("December");
		month_select.click();
		Thread.sleep(2000);
		year_select.click();
		year_select.sendKeys("1996");
		year_select.click();
		date_seventeen.click();
		Thread.sleep(1000);
		subjects_input_form.sendKeys("Maths");
		hobbies_sports.click();
		hobbies_music.click();
		WebElement upload=driver.findElement(By.cssSelector("input[type=file]"));
		upload.sendKeys("C:\\Users\\mayur\\Desktop\\upload file.jpeg");
		js1.executeScript("window.scrollBy(0,250)", "");
		curr_add_form.sendKeys("pune pcmc");
		state_dropdown.click();
		ncr_selected.click();
		Thread.sleep(2000);
		city_opt.click();
		delhi_selected.click();
		submit_button.click();
		Thread.sleep(2000);
	}
	
	
}