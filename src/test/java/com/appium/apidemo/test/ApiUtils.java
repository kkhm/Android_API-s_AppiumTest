package com.appium.apidemo.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ApiUtils {

	
	 private RemoteWebDriver wd;

	    @Before
	    public void setUp() throws Exception {
		    DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("appium-version", "1.0");
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
			capabilities.setCapability(CapabilityType.PLATFORM, Platform.ANDROID);
		    capabilities.setCapability("appium-version", "1.3.4.1");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "4.4");
			capabilities.setCapability("deviceName", "xiaomi-hm_1s-fa8edc4c");
			capabilities.setCapability("app", "D:\\Android\\AllWorkSpace\\Automation_Selinium\\AndroidNative\\bin\\AndroidNative.apk");
			capabilities.setCapability("appPackage", "com.krishna.nativep");
			try {
				wd = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
	    
	    @After
	    public void tearDown() throws Exception {
	       wd.quit();
	    }

	    @Test
	    public void Simple_Fort_Walk(){
	    	
	    	wd.findElement(By.id("com.krishna.nativep:id/EditText_1")).sendKeys("25");
	    	wd.findElement(By.id("com.krishna.nativep:id/EditText_2")).sendKeys("50");
	    	wd.findElement(By.id("com.krishna.nativep:id/Button_Add")).click();
	    	wd.navigate().back();
	    	wd.findElement(By.id("com.krishna.nativep:id/Button_Intent")).click();

	    }
}
