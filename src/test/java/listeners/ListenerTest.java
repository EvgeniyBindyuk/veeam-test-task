package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TestCases Started and details are: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TestCases Success and details are: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TestCases Failure and details are: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TestCases Skipped and details are: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext result) {
    }

    @Override
    public void onFinish(ITestContext result) {
    }
}
