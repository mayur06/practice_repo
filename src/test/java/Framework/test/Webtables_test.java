package Framework.test;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Framework.base.TestsBases;
import Framework.page.Webtables_page;

public class Webtables_test extends TestsBases {
	Webtables_page wtp;
	
	@BeforeClass
	public void Webtables_test_second() throws IOException {
		setup();
		wtp=new Webtables_page();
	}
	
	@Test (priority = 1)
	public void Webtables_test_third() throws InterruptedException {
		test=extent.createTest("Test Cases 8","Validate that the user is able to enter the data in form");
		wtp.wetables_page_first();
	}
	
	@Test (priority = 2)
	public void Webtables_test_fourth() {
		test=extent.createTest("Test Cases 9","Validate the response of form");
		List<String> form_validation=wtp.wetables_page_second();
		String actual_first_name=form_validation.get(0);
		String actual_last_name=form_validation.get(1);
		String actual_age=form_validation.get(2);
		String actual_email=form_validation.get(3);
		String actual_salary=form_validation.get(4);
		String actual_department=form_validation.get(5);
		
		String expected_first_name="test first name";
		String expected_last_name="new test last name";
		String expected_age="21";
		String expected_email="abc@gmail.com";
		String expected_salary="100000000";
		String expected_department="test department1";
		
		Assert.assertEquals(actual_first_name, expected_first_name);
		Assert.assertEquals(actual_last_name, expected_last_name);
		Assert.assertEquals(actual_age, expected_age);
		Assert.assertEquals(actual_email, expected_email);
		Assert.assertEquals(actual_salary, expected_salary);
		Assert.assertEquals(actual_department, expected_department);
	}
	
	@Test (priority = 3)
	public void Webtables_test_fifth() throws InterruptedException {
		test=extent.createTest("Test Cases 10","Valdiate that the user is able to edit the form data");
		wtp.edit_form_data();
	}
	
	@Test(priority = 4)
	public void Webtables_test_sixth() {
		test=extent.createTest("Test Cases 11","Validate the response of edit form data");
		List<String> already_enter_form_data=wtp.validate_edited_form_data(); 
		
		String act_first_name=already_enter_form_data.get(0);
		String act_last_name=already_enter_form_data.get(1);
		String act_age = already_enter_form_data.get(2);
		String act_email = already_enter_form_data.get(3);
		String act_salary = already_enter_form_data.get(4);
		String act_department = already_enter_form_data.get(5);
		
		String expe_first_name="vijay";
		String expe_last_name="singh1";
		String exp_age="20";
		String exp_email="newemail@gmail.com";
		String exp_salary="50000";
		String exp_department="test department";
		
		Assert.assertEquals(act_first_name, expe_first_name);
		Assert.assertEquals(act_last_name,expe_last_name);
		Assert.assertEquals(act_age,exp_age);
		Assert.assertEquals(act_email,exp_email);
		Assert.assertEquals(act_salary,exp_salary);
		Assert.assertEquals(act_department,exp_department);
	}
	
	@Test(priority = 5)
	public void Webtables_test_seventh() throws InterruptedException {
		test=extent.createTest("Test Cases 12","Validate that the user is able to delete the data or not");
		wtp.delete_record();
	}
	
	@AfterClass
	public void teardown() {
		extent.flush();
		driver.close();
	}
	
	
}