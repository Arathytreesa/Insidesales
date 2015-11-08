package com.kayak.POMSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private static WebElement flight = null;
	 
	public static WebElement getFlights(WebDriver driver){
	 
		flight = driver.findElement(By.xpath("//a[@id='flights-link']"));
	 
	    return flight;
	 
	    }
	 
	}