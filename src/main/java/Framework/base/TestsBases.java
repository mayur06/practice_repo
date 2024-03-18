package Framework.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.stat.inference.TestUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Framework.report.extentReport;

public class TestsBases {
	public static FileReader fr;
	public static WebDriver driver;
	public static Properties prop=new Properties();
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setup() throws IOException {
		if(driver==null) {
			fr=new FileReader("C:\\Users\\mayur\\eclipse-workspace\\feb_project\\src\\main\\java\\Framework\\config\\config.properties");
			prop.load(fr);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.getProperty("webdriver.chrome.driver", "C:\\chromed\\chromedriver-win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
		}
	}
	
	public void takesscreenshot() {
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(src,new File(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@BeforeSuite
	public void startReport() {
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/testReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		htmlReporter.config().setDocumentTitle("Feb automation report");
		htmlReporter.config().setReportName("Test reporter");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}
	
	/*
	 * @AfterMethod public void getresult(ITestResult result) {
	 * if(result.getStatus()==ITestResult.FAILURE) { test.log(Status.FAIL,
	 * MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	 * test.fail(result.getThrowable()); String
	 * screenshotPath=TestUtils.getScreenshots(driver,result.getName());
	 * test.log(Status.FAIL, result.getThrowable()); } }
	 */
	
	@AfterMethod
	public void getresult(ITestResult result) throws IOException {
		 if(result.getStatus() == ITestResult.FAILURE) {
		        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
		        test.fail(result.getThrowable());
		       
		       
		        String screenshotPath = extentReport.getScreenshotsdata(driver, result.getName());

		    	test.fail("<b><font color=red>"+"Screen shot of failed Test case"+ "</font></b>",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    	
		    }
		    else if(result.getStatus() == ITestResult.SUCCESS) {
		        test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
		    }
		    else {
		        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
		        test.skip(result.getThrowable());
		        
		       
		    }

	}
	
public void takescreenshot(){
		
		Date d= new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ","_")+".png";
		
		 File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try {
		   // now copy the  screenshot to desired location using copyFile method
		  
		  FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
		        }
		  
		 catch (IOException e)
		  
		 {
		  e.printStackTrace();
		 }
		     }
	
	@AfterSuite
	public void teardown() {
		extent.flush();
	}
	
}