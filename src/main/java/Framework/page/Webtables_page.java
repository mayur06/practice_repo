package Framework.page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Framework.base.TestsBases;

public class Webtables_page extends TestsBases {
	
	@FindBy(xpath="//li[@id='item-3']")
	WebElement web_tables;
	
	@FindBy(xpath="//button[@id='addNewRecordButton']")
	WebElement add_button;
	
	//Registration form
	@FindBy(xpath="//input[@id='firstName']")
	WebElement first_name;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement last_name;
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement user_email;
	
	@FindBy(xpath="//input[@id='age']")
	WebElement user_age;
	
	@FindBy(xpath="//input[@id='salary']")
	WebElement user_salary;
	
	@FindBy(xpath="//input[@id='department']")
	WebElement user_department;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement sub_butt;
	
	//search record
	@FindBy(xpath="//input[@id='searchBox']")
	WebElement search_box;
	
	//search entered data
	@FindBy(xpath="(//div[@class='rt-td'])[1]")
	WebElement resp_first_name;
	
	@FindBy(xpath="(//div[@class='rt-td'])[2]")
	WebElement resp_last_name;
	
	@FindBy(xpath="(//div[@class='rt-td'])[3]")
	WebElement resp_age;
	
	@FindBy(xpath="(//div[@class='rt-td'])[4]")
	WebElement resp_email;
	
	@FindBy(xpath="(//div[@class='rt-td'])[5]")
	WebElement resp_salary;
	
	@FindBy(xpath="(//div[@class='rt-td'])[6]")
	WebElement resp_department;
	
	//edit the data
	@FindBy(xpath="//span[@title='Edit']")
	WebElement edit_button;
	
	//delete the data
	@FindBy(xpath="//span[@title='Delete']")
	WebElement delete_button;
	
	public Webtables_page() {
		PageFactory.initElements(driver, this);
	}
	
	public void wetables_page_first() throws InterruptedException {
		web_tables.click();
		Thread.sleep(1000);
		add_button.click();
		Thread.sleep(1000);
		first_name.sendKeys("test first name");
		last_name.sendKeys("new test last name");
		user_email.sendKeys("abc@gmail.com");
		user_age.sendKeys("21");
		user_salary.sendKeys("100000000");
		user_department.sendKeys("test department");
		sub_butt.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		search_box.sendKeys("test first name");
		Thread.sleep(5000);
	}
	
	public List<String> wetables_page_second(){
		List<String> list=new ArrayList<String>();
		
		String validate_first_name=resp_first_name.getText();
		list.add(validate_first_name);
		
		String validate_last_name=resp_last_name.getText();
		list.add(validate_last_name);
		
		String validate_age=resp_age.getText();
		list.add(validate_age);
		
		String validate_email=resp_email.getText();
		list.add(validate_email);
		
		String validate_salary=resp_salary.getText();
		list.add(validate_salary);
		
		String validate_department=resp_department.getText();
		list.add(validate_department);
		
		return list;
	}
	
	public void edit_form_data() throws InterruptedException {
		edit_button.click();
		Thread.sleep(2000);
		
		first_name.clear();
		first_name.sendKeys("vijay");
		
		last_name.clear();
		last_name.sendKeys("singh");
		
		user_email.clear();
		user_email.sendKeys("newemail@gmail.com");
		
		user_age.clear();
		user_age.sendKeys("20");
		
		user_salary.clear();
		user_salary.sendKeys("50000");
		
		user_department.clear();
		user_department.sendKeys("test department");
		
		sub_butt.click();
		
		Thread.sleep(2000);
		search_box.clear();
		search_box.sendKeys("vijay");
		
		Thread.sleep(3000);
	}
	
	public List<String> validate_edited_form_data(){
		List<String> list=new ArrayList<String>();
		String edited_first_name =resp_first_name.getText();
		list.add(edited_first_name);
		
		String edited_last_name= resp_last_name.getText();
		list.add(edited_last_name);
		
		String edited_age=resp_age.getText();
		list.add(edited_age);
		
		String edited_email=resp_email.getText();
		list.add(edited_email);
		
		String edited_salary=resp_salary.getText();
		list.add(edited_salary);
		
		String edited_department=resp_department.getText();
		list.add(edited_department);
		
		return list;
	}
	
	public void delete_record() throws InterruptedException {
		Thread.sleep(1000);
		delete_button.click();
		Thread.sleep(3000);
	}
}