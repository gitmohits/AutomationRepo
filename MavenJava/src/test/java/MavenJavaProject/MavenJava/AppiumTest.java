package MavenJavaProject.MavenJava;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AppiumTest {
	ExtentReports extent;
	
	@BeforeSuite
	public void extentConfig() {
		
		String path = System.getProperty("user.dir")+"//reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Extent DEmo Report");
		reporter.config().setDocumentTitle("Doc Title");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester","Mohit Singh");
		
		
	}
	
	@Test
	public void test1() {
		
		ExtentTest test = extent.createTest("Test1");
		System.out.println("test1");
		System.out.println("test for Jenkins");
		test.fail("Results mismatch");
		extent.flush();
	}
}
