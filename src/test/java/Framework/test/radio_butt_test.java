package Framework.test;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Framework.base.TestsBases;
import Framework.page.radio_butt_page;


public class radio_butt_test extends TestsBases {
	radio_butt_page rbt;
	
	public radio_butt_test() {
		super();
	}
	
	@BeforeClass
	public void radio_butt_test_second() throws IOException {
		setup();
		rbt=new radio_butt_page();
	}
	
	@Test(priority = 1)
	public void radio_butt_test_third() throws InterruptedException {
		test=extent.createTest("Test case 4","click on the yes radio button");
		rbt.radio_butt_page_first();
	}
	
	@Test(priority = 2)
	public void radio_butt_test_fourth() {
		test=extent.createTest("Test case 5","validate the response of the radio button yes");
		List<String> radio_response=rbt.radio_butt_page_second();
		
		String actual_yes_data=radio_response.get(0);
		
		String expected_yes_data="Yes";
		
		Assert.assertEquals(actual_yes_data, expected_yes_data);
	}
	
	@Test(priority = 3)
	public void radio_butt_test_fifth() throws InterruptedException {
		test=extent.createTest("Test case 6","click on the impressive radio button");
		rbt.radio_butt_page_third();
	}
	
	@Test(priority = 4)
	public void radio_butt_test_six() {
		test=extent.createTest("Test case 7","Validate the response of the impressive");
		List<String> impre_response=rbt.radio_butt_page_fourth();
		String actual_imp_data=impre_response.get(0);
		
		String expected_imp_data="Impressive";
		
		Assert.assertEquals(actual_imp_data, expected_imp_data);
	}
	
	@AfterClass
	public void teardown() {
		extent.flush();
		driver.close();
	}
}