package Framework.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Framework.base.TestsBases;
import Framework.page.practice_form_page;

public class practice_form_test extends TestsBases {
	practice_form_page pfp;
	
	@BeforeTest
	public static void practice_form_test_first() throws IOException {
		practice_form_test.setup();
	}
	
	@BeforeMethod
	public void practice_form_test_second() {
		pfp=new practice_form_page();
	}
	
	@Test (priority = 1)
	public void practice_form_test_third() throws InterruptedException {
		pfp.practice_form_page_first();
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
	
}