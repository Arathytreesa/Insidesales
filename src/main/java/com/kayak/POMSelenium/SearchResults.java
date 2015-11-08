package com.kayak.POMSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResults {
	private static WebElement select= null;
	public static WebElement getSelect(WebDriver driver){
		{
			select = driver.findElement(By.xpath("//div[@id='content_div']/div[1]/div/div/div[2]/div[3]/span[1]/a/span"));
			
			return select;
		}
	}

	
}

