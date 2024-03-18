package Framework.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Framework.base.TestsBases;

public class checkBoxs_page extends TestsBases {
	
	@FindBy(xpath="//li[@id='item-1']")
	WebElement check_box;
	
	@FindBy(xpath="//button[@title='Expand all']")
	WebElement plus_icon;
	
	@FindBy(xpath="//button[@title='Collapse all']")
	WebElement minus_icon;
	
	@FindBy(xpath="(//span[@class='rct-checkbox'])[1]")
	WebElement all_checkbox;
	
	public checkBoxs_page() {
		PageFactory.initElements(driver, this);
	}
	
	public textBoxs_page checkboxs_page() throws InterruptedException {
		check_box.click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		plus_icon.click();
		Thread.sleep(3000);
		all_checkbox.click();
		//Thread.sleep(1000);
		//minus_icon.click();
		
		return new textBoxs_page();
	}
}