package Framework.report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import Framework.base.TestsBases;

public class extentReport extends TestsBases {
	
	public static String reportCapture(WebDriver driver,String screenShotName) throws IOException
	{
	    TakesScreenshot ts = (TakesScreenshot)driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	  String dest1 = System.getProperty("user.dir") +"\\test-output\\practice.html\\"+screenShotName+".png";
	  //  String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+screenShotName+".png";
	    File destination = new File(dest1);
	    FileUtils.copyFile(source, destination);        
	                 
	    return dest1;
	}
	
	public static String getScreenshotsdata(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}