package Framework.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Framework.base.TestsBases;

public class radio_butt_page extends TestsBases {

	@FindBy(xpath = "//li[@id='item-2']")
	WebElement radio_butt;

	@FindBy(xpath = "//label[@for='yesRadio']")
	WebElement yes;

	@FindBy(xpath = "//label[@for='impressiveRadio']")
	WebElement impressive;

	// validate response
	@FindBy(xpath = "//span[@class='text-success']")
	WebElement yes_response;
	
	@FindBy(xpath = "//span[@class='text-success']")
	WebElement impressive_response;

	public radio_butt_page() {
		PageFactory.initElements(driver, this);
	}

	public void radio_butt_page_first() throws InterruptedException {
		radio_butt.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(2000);
		yes.click();
	}

	public List<String> radio_butt_page_second() {
		List<String> list = new ArrayList<String>();

		String yes_data = yes_response.getText();
		list.add(yes_data);

		return list;
	}

	public void radio_butt_page_third() throws InterruptedException {
		Thread.sleep(2000);
		impressive.click();
	}
	
	public List<String> radio_butt_page_fourth() {
		List<String> list=new ArrayList<String>();
		
		String impressive_data = impressive_response.getText();
		list.add(impressive_data);
				
		return list;
	}
}