package Framework.test;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Framework.base.TestsBases;
import Framework.page.butt_page;


public class butt_test extends TestsBases {
	butt_page btp;
	
	@BeforeClass
	public void butt_test_second() throws IOException {
		setup();
		btp=new butt_page();
	}
	
	@Test (priority = 1)
	public void butt_test_third() throws InterruptedException {
		btp.butt_page_first();
	}
	
	@Test (priority = 2)
	public void butt_test_fourth() {
		List<String> click_response=btp.click_me_response();
		
		String actual_click_resp=click_response.get(0);
		
		String expected_click_resp="You have done a dynamic click";
		
		Assert.assertEquals(actual_click_resp, expected_click_resp);
	}
	
	@Test (priority = 3)
	public void butt_test_fifth() throws InterruptedException {
		btp.butt_page_second();
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
}