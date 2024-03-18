package Framework.page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Framework.base.TestsBases;

public class textBoxs_page extends TestsBases {
	
	@FindBy(xpath="//li[@id='item-0']")
	WebElement textbox;
	
	//form data
	@FindBy(xpath="//input[@id='userName']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement useremail;
	
	@FindBy(xpath="//textarea[@id='currentAddress']")
	WebElement current_add;
	
	@FindBy(xpath="//textarea[@id='permanentAddress']")
	WebElement perm_add;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement submit_button;
	
	//form submit data
	@FindBy(xpath="//p[@id='name']")
	WebElement entered_form_data;
	
	@FindBy(xpath="//p[@id='email']")
	WebElement entered_email_data;
	
	@FindBy(xpath="//p[@id='currentAddress']")
	WebElement entered_current_address;
	
	@FindBy(xpath="//p[@id='permanentAddress']")
	WebElement entered_perm_add;
	
	public textBoxs_page() {
		PageFactory.initElements(driver, this);
	}
	
	public checkBoxs_page textBoxs_page_first() throws InterruptedException {
		textbox.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		username.sendKeys("test123");
		useremail.sendKeys("abc@gmail.com");
		current_add.sendKeys("This is current address");
		perm_add.sendKeys("This is permanent address");
		submit_button.click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,250)", "");
		return new checkBoxs_page();
	}
	
	public List<String> textBoxs_page_second(){
		List<String> list=new ArrayList<String>();
		
		String validate_enter_value=entered_form_data.getText();
		list.add(validate_enter_value);
		
		String Validate_email_data=entered_email_data.getText();
		list.add(Validate_email_data);
		
		String Validate_curr_add=entered_current_address.getText();
		list.add(Validate_curr_add);
		
		String Validate_perm_add=entered_perm_add.getText();
		list.add(Validate_perm_add);
		
		return list;
	}
}