package Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Google {
	@Test
	public void search_for_selenium() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("selenium"+Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[3]/div[1]/div/div[1]/a/h3")).click();
		String title=driver.getTitle();
		Assert.assertEquals("SeleniumHQ Browser Automation", title);
		
		if(title.contentEquals("SeleniumHQ Browser Automation"))
				{
					System.out.println("Test CAse PAss");
				}
				else
				{
					System.out.println("Test Case Failed");
				}


		driver.quit();
		
		
		
		
		
	}

}
