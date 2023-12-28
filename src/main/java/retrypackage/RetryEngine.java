package retrypackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class RetryEngine implements IRetryAnalyzer, IAnnotationTransformer{

	int retry = 0;
	
	//below method is implemented from IRetryAnalyzer
	public boolean retry(ITestResult result) {
		if(retry<2) {
			retry++;
			return true;
		}
		return false;
	}
	
	//below method is implemented from IAnnotationTransformer
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryEngine.class);
	}

}
