package Framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Framework.base.TestsBases;

public class up_and_down_page extends TestsBases {
	@FindBy(xpath="//li[@id='item-7']")
	WebElement up_down;
	
	@FindBy(xpath="//a[@id='downloadButton']")
	WebElement download_butt;
	
	@FindBy(xpath="//input[@id='uploadFile']")
	WebElement upload_file_button;
	
	public up_and_down_page() {
		PageFactory.initElements(driver, this);
	}
	
	public void up_and_down_page_first() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		up_down.click();
		Thread.sleep(2000);
		download_butt.click();
	}
	
	public void up_and_down_page_second() {
		WebElement upload=driver.findElement(By.cssSelector("input[type=file]"));
		upload.sendKeys("C:\\Users\\mayur\\Desktop\\upload file.jpeg");
	}
	
	
}