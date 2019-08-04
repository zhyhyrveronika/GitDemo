package vghjk;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tost {
	private WebDriver driver;

	  @BeforeSuite
	  public void f() {
		  System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		     System.out.println("The setup process is completed");  }

	@BeforeTest
	public void profileSetup() {
	    driver.manage().window().maximize();
	    System.out.println("The profile setup process is completed");
	}

	@BeforeClass
	public void appSetup() {
	    driver.get("https://ksrtc.in");
	    System.out.println("The app setup process is completed");
	}
	@Test
	public void enterData(){
		driver.findElement(By.id("fromPlaceName")).sendKeys("BENG");
		 driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
		 System.out.println(driver.findElement(By.id("fromPlaceName")).getText());
		 
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 String script = "return document.getElementById(\"fromPlaceName\").value";
		 String text = (String) js.executeScript(script);
		 System.out.println(text);
		 int i =0;
		//BENGALURU INTERNATION AIPORT
		while(!text.equalsIgnoreCase("BENGALURU INTATION AIPORT"))
		{
		i++;
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

		text=(String) js.executeScript(script);
		System.out.println(text);
		if(i>10)
		{
		break;
		}

		}

		if(i>10)
		{
		System.out.println("Element not found");
		}
		else
		{
		System.out.println("Element  found");
		}

	}
	}




