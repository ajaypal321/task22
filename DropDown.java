package com.task.twenty.two;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown {

	public static void main(String[] args) {
		//set the path a the chromediver
		System.setProperty("webdriver.chrome.driver","D://Driver//chromedriver.exe");	
// instance of chromedriver 
		WebDriver driver = new ChromeDriver();
		// wait
		//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		
		// time manage
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		// navigate to  phptravels
		driver.get(" https://phptravels.com/demo/");
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		

		 WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='first_name']")));
		firstName.sendKeys("Monu");
		
		WebElement lastName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='last_name']")));
		lastName.sendKeys("Pal");
		
		WebElement businessName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='business_name']")));
		businessName.sendKeys("Ram");
		
		WebElement email= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='email']")));
		email.sendKeys("Monu@gmail.com");	
		WebElement num1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numb1")));
		WebElement num2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numb2")));
		//
   String a =  num1.getText();
   String b =  num2.getText();
   // string to number
   int x= Integer.parseInt(a);
   int y= Integer.parseInt(b);
   int c= (x+y);
   // converting int to string
   String sum=Integer.toString(c);
   WebElement result=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("number")));
   result.sendKeys(sum);
   
	WebElement submitbtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo")));
	submitbtn.click();
		// Wait for the success message to be displayed
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[normalize-space()='Thank you!']")));
      System.out.println("Form submitted successfully: " + successMessage.getText());
    // step 1 convert webdriver to take ss
		TakesScreenshot ss=((TakesScreenshot)driver);
		// step2 call get ss as method to create image
		File scr = ss.getScreenshotAs(OutputType.FILE);
	File dest =new File("D:\\javaconcept\\ajay\\src\\main\\java\\com\\test\\ScreenShot\\Screenshot\\ss2.png");
		try {
			FileUtils.copyFile(scr, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

