package com.kayak.POMSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightsRegistration {
	private static WebElement origin= null;
	private static WebElement destination= null;
	private static WebElement calenderStart= null;
	private static WebElement calenderEnd= null;
	private static WebElement startDate= null;
	private static WebElement returnDate= null;
	private static WebElement nearbyOrigin= null;
	private static WebElement selectNone= null;
	private static WebElement nearbyDest= null;
	
	private static WebElement search= null;
	
	public static WebElement getOrigin(WebDriver driver){
		{
			origin = driver.findElement(By.xpath("//input[@id='origin']"));
			return origin;
		}
	}
		public static WebElement getDestination(WebDriver driver){
			{
				destination = driver.findElement(By.xpath("//input[@id='destination']"));
				return destination;
			}
		}
		public static WebElement getCalenderStart(WebDriver driver){
			{
				calenderStart = driver.findElement(By.xpath("//div[@id='travel_dates-start-wrapper']/span[1]"));
				return calenderStart;
			}
	}
			
		public static WebElement getStartDate(WebDriver driver){
				{
					startDate = driver.findElement(By.xpath("//div[@id='datepicker']/div[3]/span[2]/span[2]/span[2]/span[2]/span"));
					return startDate;
				}
		}
		
		public static WebElement getCalenderEnd(WebDriver driver){
			{
				calenderEnd = driver.findElement(By.xpath("//div[@id='departreturn']/div[2]/div/div/span[2]"));
				return calenderEnd;
			}
	}
		
		
		public static WebElement getReturnDate(WebDriver driver){
			{
				returnDate = driver.findElement(By.xpath("//div[@id='datepicker']/div[4]/span[2]/span[2]/span[4]/span[3]/span"));
				return returnDate;
			}
}

		public static WebElement getNearByOrigin(WebDriver driver){
			{
				nearbyOrigin = driver.findElement(By.xpath("//div[@class='fieldBlock fieldBlockAirport fieldBlockOrigin']/div/div/div/span/a"));
				return nearbyOrigin;
			}
}
		
		public static WebElement getNearByDest(WebDriver driver){
			{
				nearbyDest = driver.findElement(By.xpath("//div[@class='fieldBlock fieldBlockAirport fieldBlockDestination']/div/div/div/span/a"));
				return nearbyDest;
			}
}
		public static WebElement getselectNone(WebDriver driver){
			{
				selectNone = driver.findElement(By.xpath("//div[@class='title comparetoTitle']/span/span/span[3]"));
				return selectNone;
			}
}
		
		
		public static WebElement getSearch(WebDriver driver){
					{
						search = driver.findElement(By.xpath("//div[@class='fieldBlock fieldBlockSubmitButton']/button"));
						return search;
					}
		}
		
}

