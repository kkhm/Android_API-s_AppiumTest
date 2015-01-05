package com.appium.apidemo.test;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class Appium_ApiDemo_Utils {
	AppiumDriver wd;
	
	public Appium_ApiDemo_Utils(AppiumDriver driver) {
		this.wd=driver;
	}
	
	public void ViewSwipLeft(WebElement view,int percentage,int duration){
		Point point=view.getLocation();
		Dimension viewDimension=view.getSize();
   	    ((AppiumDriver) wd).swipe((point.getX()),
   	    		(point.getY()+(viewDimension.getHeight()/2)),
   	    		(point.getX()+((viewDimension.getWidth()/100))*percentage),
   	    		(point.getY()+(viewDimension.getHeight()/2)),
   	    		duration);
	}
	
	public void ViewSwipRight(WebElement view,int percentage, int duration){
		Point point=view.getLocation();
		Dimension viewDimension=view.getSize();
   	    ((AppiumDriver) wd).swipe((point.getX()+((viewDimension.getWidth()/100))*percentage),
 	    		(point.getY()+(viewDimension.getHeight()/2)),
 	    		(point.getX()),
   	    		(point.getY()+(viewDimension.getHeight()/2)),
   	    		duration);
	}

	
	public void ViewSwipDown(WebElement view,int percentage,int duration){
		Point point=view.getLocation();
		Dimension viewDimension=view.getSize();
   	    ((AppiumDriver) wd).swipe((viewDimension.getWidth()/2),
 	    		(point.getY()),
   	    		(viewDimension.getWidth()/2),
   	    		(point.getY()+((viewDimension.getWidth()/100)*percentage)),
   	    		duration);
	}
	
	public void ViewSwipUp(WebElement view,int percentage,int duration){
		Point point=view.getLocation();
		Dimension viewDimension=view.getSize();
   	    ((AppiumDriver) wd).swipe((viewDimension.getWidth()/2),
	   	    		(point.getY()+((viewDimension.getWidth()/100)*percentage)),
	   	    		(viewDimension.getWidth()/2),
	   	    		(point.getY()),
	   	    		duration);
}
	
	
	public void AutomateTestDate(String dateSet, String monthSet, String yearSet){
		Calendar calendar = Calendar.getInstance(); 

		WebElement DateWidgets_element=wd.findElement(By.xpath("//android.widget.NumberPicker[@index='0']"));
		for (int i = 1; i <= 31; i++) {
			int currentDate=Integer.parseInt(DateWidgets_element.findElement(By.id("android:id/numberpicker_input")).getText());
			if(currentDate>Integer.parseInt(dateSet)){
				int tmp1=currentDate;
				String res= (--tmp1 < 10 ? "0" : "") + tmp1;
				wd.findElement(By.xpath("//android.widget.Button[@text='"+res+"']")).click();
			}else if(currentDate<Integer.parseInt(dateSet)){
				int tmp1=currentDate;
				String res= (++tmp1 < 10 ? "0" : "") + tmp1;
				wd.findElement(By.xpath("//android.widget.Button[@text='"+res+"']")).click();
			} if(currentDate==Integer.parseInt(dateSet)){
				break;
			}
		}
	
		DateWidgets_element=wd.findElement(By.xpath("//android.widget.NumberPicker[@index='1']"));
		int  currentMonthNumber=calendar.get(Calendar.MONTH);
		for (int i = currentMonthNumber ;;) {
			String currentMonthName=DateWidgets_element.findElement(By.id("android:id/numberpicker_input")).getText();
			if(currentMonthName.equalsIgnoreCase(monthSet)){
				break;
			}else{
				wd.findElement(By.xpath("//android.widget.Button[@text='"+new DateFormatSymbols().getMonths()[++i].substring(0,3)+"']")).click();
			}
		}
		DateWidgets_element=wd.findElement(By.xpath("//android.widget.NumberPicker[@index='2']"));
		String currentyear=DateWidgets_element.findElement(By.id("android:id/numberpicker_input")).getText();
		for (int i = Integer.parseInt(currentyear); i < Integer.parseInt(yearSet);) {
			wd.findElement(By.xpath("//android.widget.Button[@text='"+""+ ++i+"']")).click();
		}
		for (int i = Integer.parseInt(currentyear); i > Integer.parseInt(yearSet);) {
			wd.findElement(By.xpath("//android.widget.Button[@text='"+""+ --i+"']")).click();
		}
		wd.findElement(By.xpath("//android.widget.Button[@text='Done']")).click();

		
		
	}
	
	public void AutomateTestTime(String HourSet, String MinutSet, String Am_Pm){
		WebElement TimeWidgets_element=wd.findElement(By.xpath("//android.widget.NumberPicker[@index='0']"));
		int currentHour=Integer.parseInt(TimeWidgets_element.findElement(By.id("android:id/numberpicker_input")).getText());
		for (int i = currentHour; i < Integer.parseInt(HourSet);) {
			wd.findElement(By.xpath("//android.widget.Button[@text='"+ ++i+"']")).click();
		}
		for (int i = currentHour; i > Integer.parseInt(HourSet);) {
			wd.findElement(By.xpath("//android.widget.Button[@text='"+ --i+"']")).click();
		}
			
		TimeWidgets_element=wd.findElement(By.xpath("//android.widget.NumberPicker[@index='2']"));
		int currentMinut=Integer.parseInt(TimeWidgets_element.findElement(By.id("android:id/numberpicker_input")).getText());
		for (int i = currentMinut; i < Integer.parseInt(MinutSet);) {
			int tmp1=currentMinut;
			String res= (++tmp1 < 10 ? "0" : "") + ++i;
			wd.findElement(By.xpath("//android.widget.Button[@text='"+res+"']")).click();
		}
		for (int i = currentMinut; i > Integer.parseInt(MinutSet);) {
			int tmp1=currentMinut;
			String res= (--tmp1 < 10 ? "0" : "") + --i;
			wd.findElement(By.xpath("//android.widget.Button[@text='"+res+"']")).click();
		}
		
		TimeWidgets_element=wd.findElement(By.xpath("//android.widget.NumberPicker[@index='1']"));
		TimeWidgets_element.findElement(By.name(Am_Pm)).click();
		wd.findElement(By.xpath("//android.widget.Button[@text='Done']")).click();
	}
}
