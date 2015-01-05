package com.appium.apidemo.test;

import io.appium.java_client.AppiumDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;




public class Android_ApiDemo {
	int port=4723;
	int timeOut=60;
	private AppiumDriver wd;
	private Appium_ApiDemo_Utils apiDemo_Utils;
	private WebElement gestureView;

	@Before
	public void setUp()  throws Exception {

	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("appium-version", "v1.3.4");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "18");
		capabilities.setCapability("automationName","Appium");
		capabilities.setCapability("address","127.0.0.1");
		//capabilities.setCapability("fullReset",true);
		//capabilities.setCapability("logNoColors",true);
		capabilities.setCapability("deviceName", "xiaomi-hm_1s-fa8edc4c");
		//capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("app", "D:\\Android_Testing_Tools\\APPIUM\\SampleAPKs\\ApiDemos.apk");
		capabilities.setCapability("appPackage", "com.example.android.apis");
		try {
			System.out.println(capabilities.toString());
			wd = new AppiumDriver(new URL("http://127.0.0.1:"+port+"/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		wd.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		apiDemo_Utils=new Appium_ApiDemo_Utils(wd);
	}



	@Test
    public void Android_ApiDemo_Tour(){

	//***************************       Accessibility      ******************************

		wd.findElement(By.xpath("//android.widget.TextView[@text='Accessibility']")).click();
		wd.findElement(By.xpath("//android.widget.TextView[@text='Accessibility Node Provider']")).click();
		wd.navigate().back();
		wd.findElement(By.xpath("//android.widget.TextView[@text='Accessibility Node Querying']")).click();
		List<WebElement> Accessibility_ListView = wd.findElements(By.xpath("//android.widget.ListView[1]//android.widget.LinearLayout"));
		WebElement Accessibility_element= Accessibility_ListView.get(0);
		Accessibility_element.findElement(By.id("com.example.android.apis:id/tasklist_finished")).click();
		Accessibility_element= Accessibility_ListView.get(1);
		Accessibility_element.findElement(By.id("com.example.android.apis:id/tasklist_finished")).click();
		Accessibility_element= Accessibility_ListView.get(2);
		Accessibility_element.findElement(By.id("com.example.android.apis:id/tasklist_finished")).click();
		Accessibility_element= Accessibility_ListView.get(3);
		gestureView=wd.findElement(By.id("android:id/list"));
		apiDemo_Utils.ViewSwipUp(gestureView,50,1000);
		apiDemo_Utils.ViewSwipDown(gestureView,50,1000);
		Accessibility_element.findElement(By.id("com.example.android.apis:id/tasklist_finished")).click();
		Accessibility_element= Accessibility_ListView.get(4);
		Accessibility_element.findElement(By.id("com.example.android.apis:id/tasklist_finished")).click();
		wd.navigate().back();
		wd.navigate().back();

		//***********************************           Animation           ***************************

		wd.findElement(By.xpath("//android.widget.TextView[@text='Animation']")).click();
		wd.findElement(By.xpath("//android.widget.TextView[@text='Bouncing Balls']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wd.navigate().back();
		wd.findElement(By.xpath("//android.widget.TextView[@text='Cloning']")).click();
		wd.findElement(By.id("com.example.android.apis:id/startButton")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wd.navigate().back();
		wd.findElement(By.xpath("//android.widget.TextView[@text='Default Layout Animations']")).click();
		wd.findElement(By.id("com.example.android.apis:id/addNewButton")).click();
		wd.findElement(By.id("com.example.android.apis:id/addNewButton")).click();
		wd.findElement(By.id("com.example.android.apis:id/addNewButton")).click();
		wd.findElement(By.id("com.example.android.apis:id/addNewButton")).click();
		wd.findElement(By.id("com.example.android.apis:id/addNewButton")).click();
		wd.findElement(By.id("com.example.android.apis:id/addNewButton")).click();
		wd.findElement(By.id("com.example.android.apis:id/addNewButton")).click();
		wd.findElement(By.xpath("//android.widget.Button[@text='1']")).click();
		wd.findElement(By.xpath("//android.widget.Button[@text='3']")).click();
		wd.findElement(By.xpath("//android.widget.Button[@text='5']")).click();
		wd.findElement(By.xpath("//android.widget.Button[@text='7']")).click();
		wd.navigate().back();
		wd.findElement(By.xpath("//android.widget.TextView[@text='Events']")).click();
		wd.findElement(By.id("com.example.android.apis:id/startButton")).click();
		wd.findElement(By.id("com.example.android.apis:id/endCB")).click();
		wd.navigate().back();
		wd.findElement(By.xpath("//android.widget.TextView[@text='Hide-Show Animations']")).click();
		wd.findElement(By.id("com.example.android.apis:id/customAnimCB")).click();
		wd.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
		wd.findElement(By.id("com.example.android.apis:id/addNewButton")).click();
		wd.navigate().back();
		wd.findElement(By.xpath("//android.widget.TextView[@text='Seeking']")).click();
		gestureView=wd.findElement(By.id("com.example.android.apis:id/seekBar"));
		apiDemo_Utils.ViewSwipLeft(gestureView,80,1000);
		apiDemo_Utils.ViewSwipRight(gestureView,80,1000);
		wd.navigate().back();
		wd.navigate().back();

		//**************************************      Views     **************************

		wd.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		wd.findElement(By.xpath("//android.widget.TextView[@text='Auto Complete']")).click();
		wd.findElement(By.xpath("//android.widget.TextView[@text='1. Screen Top']")).click();
		wd.findElement(By.id("com.example.android.apis:id/edit")).sendKeys("india");
		wd.navigate().back();
		wd.navigate().back();
		wd.navigate().back();
		wd.findElement(By.xpath("//android.widget.TextView[@text='2. Screen Bottom']")).click();
		wd.findElement(By.id("com.example.android.apis:id/edit")).sendKeys("india");
		wd.navigate().back();
		wd.navigate().back();
		wd.navigate().back();
		wd.findElement(By.xpath("//android.widget.TextView[@text='3. Scroll']")).click();
		wd.navigate().back();
		wd.navigate().back();
		wd.findElement(By.xpath("//android.widget.TextView[@text='Controls']")).click();
		wd.findElement(By.xpath("//android.widget.TextView[@text='1. Light Theme']")).click();
		wd.findElement(By.id("com.example.android.apis:id/edit")).sendKeys("Appium");
		wd.navigate().back();
		wd.findElement(By.id("com.example.android.apis:id/check1")).click();
		wd.findElement(By.id("com.example.android.apis:id/check2")).click();
		wd.findElement(By.id("com.example.android.apis:id/spinner1")).click();
		wd.findElement(By.xpath("//android.widget.CheckedTextView[@text='Venus']")).click();
		wd.findElement(By.id("com.example.android.apis:id/spinner1")).click();
		wd.findElement(By.xpath("//android.widget.CheckedTextView[@text='Uranus']")).click();
		wd.findElement(By.id("com.example.android.apis:id/radio1")).click();
		wd.findElement(By.id("com.example.android.apis:id/radio2")).click();
		wd.findElement(By.id("com.example.android.apis:id/star")).click();
		wd.findElement(By.id("com.example.android.apis:id/toggle1")).click();
		wd.findElement(By.id("com.example.android.apis:id/toggle2")).click();
		wd.navigate().back();

		wd.findElement(By.xpath("//android.widget.TextView[@text='5. Custom Theme']")).click();
		wd.findElement(By.id("com.example.android.apis:id/edit")).sendKeys("Appium");
		wd.navigate().back();
		wd.findElement(By.id("com.example.android.apis:id/check1")).click();
		wd.findElement(By.id("com.example.android.apis:id/check2")).click();
		wd.findElement(By.id("com.example.android.apis:id/spinner1")).click();
		wd.findElement(By.xpath("//android.widget.CheckedTextView[@text='Venus']")).click();
		wd.findElement(By.id("com.example.android.apis:id/spinner1")).click();
		wd.findElement(By.xpath("//android.widget.CheckedTextView[@text='Uranus']")).click();
		wd.findElement(By.id("com.example.android.apis:id/radio1")).click();
		wd.findElement(By.id("com.example.android.apis:id/radio2")).click();
		wd.findElement(By.id("com.example.android.apis:id/star")).click();
		wd.findElement(By.id("com.example.android.apis:id/toggle1")).click();
		wd.findElement(By.id("com.example.android.apis:id/toggle2")).click();
		wd.navigate().back();

		wd.findElement(By.xpath("//android.widget.TextView[@text='6. Holo or Old Theme']")).click();
		wd.findElement(By.id("com.example.android.apis:id/edit")).sendKeys("Appium");
		wd.navigate().back();
		wd.findElement(By.id("com.example.android.apis:id/check1")).click();
		wd.findElement(By.id("com.example.android.apis:id/check2")).click();
		wd.findElement(By.id("com.example.android.apis:id/spinner1")).click();
		wd.findElement(By.xpath("//android.widget.CheckedTextView[@text='Venus']")).click();
		wd.findElement(By.id("com.example.android.apis:id/spinner1")).click();
		wd.findElement(By.xpath("//android.widget.CheckedTextView[@text='Uranus']")).click();
		wd.findElement(By.id("com.example.android.apis:id/radio1")).click();
		wd.findElement(By.id("com.example.android.apis:id/radio2")).click();
		wd.findElement(By.id("com.example.android.apis:id/star")).click();
		wd.findElement(By.id("com.example.android.apis:id/toggle1")).click();
		wd.findElement(By.id("com.example.android.apis:id/toggle2")).click();
		wd.navigate().back();
		wd.navigate().back();
		wd.navigate().back();

		//***************************************   Date Widgets  **********************************

		wd.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		wd.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
		wd.findElement(By.xpath("//android.widget.TextView[@text='1. Dialog']")).click();
		wd.findElement(By.xpath("//android.widget.Button[@text='change the date']")).click();
		apiDemo_Utils.AutomateTestDate("15","Nov","2026");
		wd.findElement(By.xpath("//android.widget.Button[@text='change the time']")).click();
		apiDemo_Utils.AutomateTestTime("4","45","AM");
		wd.navigate().back();
		wd.navigate().back();



    }



	@After
    public void tearDown() throws Exception {
        wd.quit();
    }


}
