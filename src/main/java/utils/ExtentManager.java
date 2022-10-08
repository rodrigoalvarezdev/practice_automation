package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	protected static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;
	
	public static void initReport() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Spark.html");
		extent.attachReporter(spark);
	}
	
	public static void closeReport() {
		extent.flush();
	}
}
