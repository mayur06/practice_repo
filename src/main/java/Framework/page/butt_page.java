package Framework.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Framework.base.TestsBases;

public class butt_page extends TestsBases {

	@FindBy(xpath = "//li[@id='item-4']")
	WebElement butt;

	@FindBy(xpath = "(//button[@type='button'])[4]")
	WebElement click_me;
	
	//response alert
	@FindBy(xpath="//p[@id='dynamicClickMessage']")
	WebElement click_me_response;
	
	//double click
	@FindBy(xpath="//button[@id='rightClickBtn']")
	WebElement right_click_butt;

	public butt_page() {
		PageFactory.initElements(driver, this);
	}

	public void butt_page_first() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(1000);
		butt.click();
		Thread.sleep(2000);
		click_me.click();
	}
	
	public List<String> click_me_response(){
		List<String> list=new ArrayList<String>();
		String click_response=click_me_response.getText();
		list.add(click_response);
		return list;
	}
	
	public void butt_page_second() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(1000);
		Actions actions=new Actions(driver);
		actions.contextClick(right_click_butt).click();
//		right_click_butt.click();
		
	}
}