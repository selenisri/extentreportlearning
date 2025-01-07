package TestCases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExecutionControlListener implements ITestListener {
	
	  public static boolean stopExecution = false; // Shared across classes

    @Override
    public void onStart(ITestContext context) {
        // Check the global flag before starting any test
        if (UpdateFields.stopExecution) {
            System.out.println("Stopping execution of subsequent test classes.");
            context.getCurrentXmlTest().getXmlClasses().clear(); // Remove remaining classes from execution
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Optional: Log test start
        System.out.println("Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) 
     {
       ITestContext context = result.getTestContext();
        
        // Clear all remaining classes from execution
        context.getCurrentXmlTest().getXmlClasses().clear();
         }
    

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test execution finished.");
    }
}