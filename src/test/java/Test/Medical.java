package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


     public class Medical{  
       @Test
      public void Medical_Records() throws InterruptedException{
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
	//login info and login
	driver.get(" https://demo.openemr.io/a/openemr");
	driver.findElement(By.name("authUser")).sendKeys("admin");
	driver.findElement(By.name("clearPass")).sendKeys("pass");
	driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[3]/div[1]/div[5]/button")).click();
	//mouse over to new patient na dmove to new frame
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu_logo\"]/div/div/span[5]/div/div"))).perform();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"menu_logo\"]/div/div/span[5]/div/ul/li[2]/div")).click();
	driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div/div[5]/div/div[3]/iframe")));
	Thread.sleep(2000);
	//start filling the form
	Select name=new Select(driver.findElement(By.name("form_title")));
	name.selectByIndex(2);
	driver.findElement(By.xpath("//*[@id=\"form_fname\"]")).sendKeys("Monali");
	driver.findElement(By.xpath("//*[@id=\"form_lname\"]")).sendKeys("Sawant");	
	driver.findElement(By.xpath("//*[@id=\"form_DOB\"]")).click();
	Thread.sleep(2000);
	driver.findElement(By.className("xdsoft_today")).click();
	Select gender=new Select(driver.findElement(By.name("form_sex")));
	gender.selectByIndex(1);
	driver.findElement(By.name("create")).click();
	driver.switchTo().defaultContent();
	//new patient confirm
	driver.switchTo().frame(driver.findElement(By.id("modalframe")));
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/center/input")).click();
	driver.switchTo().defaultContent();
	Thread.sleep(2000);
	//working with alert
	System.out.println(driver.switchTo().alert().getText());
	driver.switchTo().alert().accept();
	//switch to happy birthday frame
	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"modalframe\"]")));
	System.out.println(driver.findElement(By.xpath("/html/body/div/p")).getText());
	Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/p")).getText(),"Happy Birthday");
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//*[@id=\"bdayreminder\"]/div/div/div[1]")).click();
	//mouse over to billy
	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"username\"]/span[2]"))).perform();
	driver.findElement(By.xpath("//*[@id=\"username\"]/div/ul/li[4]")).click();
	
	driver.close();	
}
  }