package Framework.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Framework.base.TestsBases;
import Framework.page.practice_form_page;

public class practice_form_test extends TestsBases {
	practice_form_page pfp;
	
	public practice_form_test() {
		super();
	}
	
	
	@BeforeClass
	public void practice_form_test_second() throws IOException {
		setup();
		pfp=new practice_form_page();
	}
	
	@Test (priority = 1)
	public void practice_form_test_third() throws InterruptedException {
		test=extent.createTest("Test case 18","Enter all the details in practice forms");
		pfp.practice_form_page_first();
	}
	
	@AfterClass
	public void teardown() {
		extent.flush();
		driver.close();
	}
	
}