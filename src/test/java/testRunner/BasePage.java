package testRunner;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.github.javafaker.Faker;


public class BasePage {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		String registerPageTxt=driver.findElement(By.xpath("//h1[normalize-space()='Register']")).getText();
		Assert.assertEquals("Register",registerPageTxt);
		
		driver.findElement(By.id("gender-male")).click();
		//Faker class for generating fake email
		Faker fakeData=new Faker();
		
		String fName=fakeData.name().firstName();
		String lName=fakeData.name().lastName();
		System.out.println(fName);
		System.out.println(lName);

		driver.findElement(By.id("FirstName")).sendKeys(fName);
		driver.findElement(By.id("LastName")).sendKeys(lName);
		
//		To handle static Dropdown 
		WebElement day= driver.findElement(By.name("DateOfBirthDay"));
		Select dropDay=new Select(day);
		dropDay.selectByValue("16");
		
		WebElement month= driver.findElement(By.name("DateOfBirthMonth"));
		Select dropMonth=new Select(month);
		dropMonth.selectByVisibleText("January");
		
		WebElement year= driver.findElement(By.name("DateOfBirthYear"));
		Select dropYear=new Select(year);
		dropYear.selectByVisibleText("2019");
		

		String mail=fakeData.internet().emailAddress();
		System.out.println(mail);
		
		driver.findElement(By.id("Email")).sendKeys(mail);
		
		
		driver.findElement(By.name("Company")).sendKeys("Kumaran Systems Private Limited");
		
		String pass=fakeData.internet().password(6, 18);
		System.out.println(pass);
		
		driver.findElement(By.id("Password")).sendKeys(pass);
		
		
		driver.findElement(By.id("ConfirmPassword")).sendKeys(pass);
		
		driver.findElement(By.id("register-button")).click();
		
		String successRegisterTxt=driver.findElement(By.xpath("//div[@class='result']")).getText();
		System.out.println(successRegisterTxt);
		Assert.assertEquals("Your registration completed", successRegisterTxt);
		
		
	}

}
