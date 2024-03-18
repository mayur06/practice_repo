package Framework.test;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import Framework.base.TestsBases;
import Framework.page.checkBoxs_page;
import Framework.page.textBoxs_page;

public class textBoxs_test extends TestsBases {
	textBoxs_page tbp;
	checkBoxs_page cbp;
	
	public textBoxs_test() {
		super();
	}

	@BeforeClass
	public void textboxs_test_second() throws IOException {
		setup();
		tbp = new textBoxs_page();
		cbp = new checkBoxs_page();
	}

	@Test(priority = 1)
	public void textboxs_test_third() throws InterruptedException {
		test = extent.createTest("Test cases 1", "Test cases for the form data");
		cbp=tbp.textBoxs_page_first();

	}

	@Test(priority = 2)
	public void textboxs_test_fourth() {
		test = extent.createTest("Test cases 2", "Validate the response of the form");
		List<String> form_validation = tbp.textBoxs_page_second();
		String actual_full_name = form_validation.get(0);
		String actual_email = form_validation.get(1);
		String actual_current_add = form_validation.get(2);
		String actual_perm_add = form_validation.get(3);

		String expected_full_name = "Name:test123";
		String expected_email = "Email:abc@gmail.com";
		String expected_current_add = "Current Address :This is current address";
		String expected_perm_add = "Permananet Address :This is permanent address";

		Assert.assertEquals(actual_full_name, expected_full_name);
		Assert.assertEquals(actual_email, expected_email);
		Assert.assertEquals(actual_current_add, expected_current_add);
		Assert.assertEquals(actual_perm_add, expected_perm_add);
	}

	@AfterClass
	public void teardown() {
		extent.flush();
		driver.close();
	}

}