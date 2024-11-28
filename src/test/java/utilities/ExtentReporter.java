package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;

public class ExtentReporter implements ITestListener {
    public static   ExtentReports extent;
    public static  ExtentSparkReporter sparkReporter;
    public static   ExtentTest test;
    static String reportName;

    public void onStart(ITestContext testContext) {
       
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            reportName = "Test-Report-" + timeStamp + ".html";
            String reportPath = System.getProperty("user.dir") + "\\reports\\" + reportName;

            sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setDocumentTitle("FrameWork Test Report");
            sparkReporter.config().setReportName("Test Execution Summary");
            sparkReporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Application", "framework");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("User", System.getProperty("user.name"));
            
            String os = testContext.getCurrentXmlTest().getParameter("os");

            extent.setSystemInfo("Operating System", os);

            String browser = testContext.getCurrentXmlTest().getParameter("browser");

            extent.setSystemInfo("Browser", browser);

            List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();

            if(!includedGroups.isEmpty()) {

            extent.setSystemInfo("Groups", includedGroups.toString());

        
            }
    }

   // @Override
   /* public void onTestSuccess(ITestResult result) {
        String suiteName = context.getSuite().getName();
        ExtentTest suiteNode = getExtentInstance().createTest(suiteName);
        testSuiteMap.put(context.getName(), suiteNode);

        suiteNode.info("Suite started: " + suiteName);
        suiteNode.assignCategory("Suite: " + suiteName);

        getExtentInstance().setSystemInfo("OS", context.getCurrentXmlTest().getParameter("os"));
        getExtentInstance().setSystemInfo("Browser", context.getCurrentXmlTest().getParameter("browser"));
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest suiteNode = testSuiteMap.get(result.getTestContext().getName());
        ExtentTest methodNode = suiteNode.createNode(result.getMethod().getMethodName());
        methodNode.assignCategory(result.getTestContext().getName());
        testNode.set(methodNode);
    }*/

    @Override
    public void onTestSuccess(ITestResult result) {
       test = extent.createTest(result.getTestClass().getName());
       test.assignCategory(result.getMethod().getGroups());
       test.log(Status.PASS, result.getName() + " Succcessful execution.");
       
      

    }

    @Override
    public void onTestFailure(ITestResult result) {
    	test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        
        test.log(Status.FAIL, result.getMethod().getMethodName() + " failed.");
        test.log(Status.INFO, result.getThrowable().getMessage());

        try {

        	String imgPath = new BaseClass().captureScreen(result.getName()) ;
        	test.addScreenCaptureFromPath(imgPath);

        	} catch (Exception e1) {

        	e1.printStackTrace();

        	}
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        
        test.log(Status.SKIP, result.getName() + " Skipped.");
        test.log(Status.INFO, result.getThrowable().getMessage());

    }

    @Override
    public void onFinish(ITestContext context) {
    	extent.flush();

    	String pathofExtentReport = System.getProperty("user.dir")+"\\reports\\"+reportName;
    	File extentReport = new File(pathofExtentReport);
    
    	try {
    	Desktop.getDesktop().browse(extentReport.toURI());


    	} catch (IOException e) {


    	e.printStackTrace();
    	}
    	
    	
    	
    	/*try {
    		URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+reportName);

    			// Create the email message
    		ImageHtmlEmail email=  new ImageHtmlEmail();

    			email.setDataSourceResolver(new DataSourceUrlResolver(url));

    			email.setHostName("smtp.googlemail.com");

    			email.setSmtpPort(465);

    			email.setAuthenticator(new DefaultAuthenticator("pavanoltraining@gmail.com","password"));

    			email.setSSLOnConnect(true);

    			email.setFrom("pavanoltraining@gmail.com"); //Sender

    			email.setSubject("Test Results");

    			email.setMsg("Please find Attached Report....");

    			email.addTo("pavankumar.busyqa@gmail.com"); //Receiver

    			email.attach(url, "extent report", "please check report...");

    			email.send(); // send the email

    			}

    			catch(Exception e) { 
    				e.printStackTrace();
    			
    			}*/

    	}
}

   /* private void openReport() {
        try {
            File reportFile = new File(System.getProperty("user.dir") + "\\reports\\" + reportName);
            Desktop.getDesktop().browse(reportFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String captureScreenshot(String testName) throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotPath = System.getProperty("user.dir") + "\\screenshots\\" + testName + "_" + timestamp + ".png";
        File sourceFile = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
        File targetFile = new File(screenshotPath);
        sourceFile.renameTo(targetFile);
        return screenshotPath;
    }

    private long getExecutionTime(ITestResult result) {
        return result.getEndMillis() - result.getStartMillis();
    }*/

