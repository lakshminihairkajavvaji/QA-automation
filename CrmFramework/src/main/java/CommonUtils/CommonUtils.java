package CommonUtils;


import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;

import com.crm.config.Configuration;


public class CommonUtils extends Configuration{
//	public static void validatePage(String title,WebDriver wd) {
//		Assert.assertEquals(title, wd.getTitle());
//	}
	public static void clickLink(String identifiedBy,String locator,WebDriver wd) {
		if(identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		}
		else if (identifiedBy.equalsIgnoreCase("link")) {
			wd.findElement(By.linkText(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("plink")) {
			wd.findElement(By.partialLinkText(locator)).click();
		}
		
		
	}
	
	//method to click a button
	
	public static void clickButton(String identifiedBy,String locator,WebDriver wd) {
		if(identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		}
		
	}
	//method to click Radio Button
	public static void clickRadioButton(String identifiedBy,String locator,WebDriver wd) {
		if(identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		}
	}
	
	//method to accept alert
	public static void acceptAlert(WebDriver wd) {
		Alert alert = wd.switchTo().alert();
		alert.accept();
	}
	
	//method to insert text into textbox
	public static void insertText(String identifiedBy,String locator,String text,WebDriver wd) {
		if(identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).sendKeys(text);
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).sendKeys(text);
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath("xpath")).sendKeys(text);
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).sendKeys(text);
		}
	}	
	 
	//method to handle dropdown
		public static void selectDropDownItem(String identifiedBy,String locator,String itemType,String value,WebDriver wd) {
			WebElement element = null;
			//first identify the element by using locator
			if (identifiedBy.equalsIgnoreCase("id")) {
				element=wd.findElement(By.id(locator));
			}
			else if (identifiedBy.equalsIgnoreCase("name")) {
				element=wd.findElement(By.name(locator));
			}
			else if (identifiedBy.equalsIgnoreCase("xpath")) {
				element=wd.findElement(By.xpath(locator));
			}
			else if (identifiedBy.equalsIgnoreCase("css")) {
				element=wd.findElement(By.cssSelector(locator));
			}
			//create select class for the element
			Select selectobj=new Select(element);
			//select the desired item 
			if(itemType.equalsIgnoreCase("value")) {
				selectobj.selectByValue(value);
			}
			else if(itemType.equalsIgnoreCase("index")) {
				selectobj.selectByIndex(Integer.parseInt(value));
			}
			else if(itemType.equalsIgnoreCase("text")) {
				selectobj.selectByVisibleText(value);
			}
		}
		
		
		//method to navigate backward
		public static void pageNavigateBack(WebDriver wd) {
			wd.navigate().back();
		}
		//method to navigate forward
		public static void pageNavigateForward(WebDriver wd) {
			wd.navigate().forward();
		}
		//method to refresh
		public static void pageRefresh(WebDriver wd) {
			wd.navigate().refresh();
		}
		
		
		//method to get text from textbox
		public static String getText(String identifiedBy,String locator,WebDriver wd) {
			String text = null;
			if(identifiedBy.equalsIgnoreCase("id")) {
				text = wd.findElement(By.id(locator)).getText();			
			}
			else if(identifiedBy.equalsIgnoreCase("name")) {
				text = wd.findElement(By.name(locator)).getText();			
			}
			else if(identifiedBy.equalsIgnoreCase("xpath")) {
				text = wd.findElement(By.xpath(locator)).getText();			
			}
			else if(identifiedBy.equalsIgnoreCase("css")) {
				text = wd.findElement(By.cssSelector(locator)).getText();			
			}
			return text;
		}
		
		//method to know element is getting displayed
		public static Boolean elementDisplayed(String identifiedBy,String locator,WebDriver wd) {
			Boolean result = null; 
			if(identifiedBy.equalsIgnoreCase("id")) {
				result = wd.findElement(By.id(locator)).isDisplayed();
			}
			else if(identifiedBy.equalsIgnoreCase("name")) {
				result = wd.findElement(By.name(locator)).isDisplayed();
			}
			else if(identifiedBy.equalsIgnoreCase("xpath")) {
				result = wd.findElement(By.id(locator)).isDisplayed();
			}
			else if(identifiedBy.equalsIgnoreCase("css")) {
				result = wd.findElement(By.cssSelector(locator)).isDisplayed();
			}
			return result;
		}
		//method to get entered text
		public static String enteredText(String identifiedBy,String locator,WebDriver wd) {
			String txt = null;
			if(identifiedBy.equalsIgnoreCase("id")) {
				txt = wd.findElement(By.id(locator)).getAttribute("value");
			}
			else if(identifiedBy.equalsIgnoreCase("name")) {
				txt = wd.findElement(By.name(locator)).getAttribute("value");
			}
			else if(identifiedBy.equalsIgnoreCase("xpath")) {
				txt = wd.findElement(By.xpath(locator)).getAttribute("value");
			}
			else if(identifiedBy.equalsIgnoreCase("css")) {
				txt = wd.findElement(By.cssSelector(locator)).getAttribute("value");
			}
			
			return txt;
		}
		
		//method for wait
		public static void wait(int timeout) throws InterruptedException {
			int timeoutVal = timeout * 1;
			for(int second = 0;second < timeoutVal; second++) {
				Thread.sleep(1000);
			}
		}
		public static void takeScreenShot(WebDriver wd) {
			try {
				int count = 0;
				String NewFileNamePath;
				File directory = new File(".");
				DateFormat dateformat = new SimpleDateFormat("dd_MMM_YYYY_hh_mm_ssaa");
				Date date = new Date();
				
				NewFileNamePath = "C:\\Users\\Harika\\Desktop\\ScreenShots\\"+dateformat.format(date)+"_"+".png";
				BufferedImage screenCapture = new Robot().createScreenCapture(new Rectangle(968,1009));
				
				File file = new File(NewFileNamePath);
				ImageIO.write(screenCapture, "png", file);
				count++;
				
				File screenshot = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File(NewFileNamePath));
				
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	

}
