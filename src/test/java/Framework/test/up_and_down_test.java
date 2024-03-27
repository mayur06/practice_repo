package Framework.test;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Framework.base.TestsBases;
import Framework.page.up_and_down_page;

public class up_and_down_test extends TestsBases {
	up_and_down_page udp;
	
	public up_and_down_test() {
		super();
	}
	
	@BeforeClass
	public void up_and_down_test_second() throws IOException {
		setup();
		udp=new up_and_down_page();
	}
	
	@Test (priority = 1)
	public void up_and_down_test_third() throws InterruptedException {
		test=extent.createTest("Test Cases 16","The file is downloaded");
		udp.up_and_down_page_first();
	}
	
	@Test (priority = 2)
	public void up_and_down_test_fourth() {
		test=extent.createTest("Test Cases 17","The file is uploaded");
		udp.up_and_down_page_second();
	}
	
	@AfterClass
	public void teardown() {
		extent.flush();
		driver.close();
	}
}