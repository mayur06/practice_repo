package Framework.test;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Framework.base.TestsBases;
import Framework.page.checkBoxs_page;
import Framework.page.textBoxs_page;

public class checkBoxs_test extends TestsBases {
	textBoxs_page tbp;
	checkBoxs_page cbp;
	
	public checkBoxs_test() {
		super();
	}
	
	@BeforeClass
	public void checkbox_test_second() throws InterruptedException, IOException {
		setup();	
		tbp = new textBoxs_page();
		cbp=new checkBoxs_page();
	}
	
	@Test
	public void checkbox_test_third() throws InterruptedException {
		test = extent.createTest("Test cases 3","Check the checkboxes is clickable or not");
		tbp=cbp.checkboxs_page();
	}
	
	@AfterClass
	public void teardown() {
		extent.flush();
		driver.close();
		
	}
}