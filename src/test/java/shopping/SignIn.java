package shopping;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignIn {

	static WebDriver driver;
	//String ValidColor = "#35b33f";
	String Email = "arpita.archu@gmail.com";
	String fName = "Arpita";
	String LName = "Jain";

	
	@BeforeClass
	 public void setupsuite() {
			
			WebDriverManager.firefoxdriver().setup();//setup the browser driver using webdriver manager
			driver = new FirefoxDriver();	
			driver.manage().window().maximize();
			driver.get("http://automationpractice.com/index.php");
		}
	@Test
    public void createAccount() throws InterruptedException
    {
		
	
    	driver.findElement(By.className("login")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    
    	driver.findElement(By.id("email_create")).sendKeys(Email);
    	driver.findElement(By.id("SubmitCreate")).click();
    }
    	
   @Test
	public void registerNewUser() throws InterruptedException {
    	
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	WebElement radiobutton = driver.findElement(By.id("id_gender2"));
    	boolean result = radiobutton.isEnabled();
    	Assert.assertTrue(result, "Radio button is not present and enabled");
    	radiobutton.click();
    	Assert.assertTrue((radiobutton.isSelected()), "Radio button is not selected");
      	driver.findElement(By.id("customer_firstname")).sendKeys(fName);
    	driver.findElement(By.id("customer_lastname")).sendKeys(LName);
    	WebElement EmailField = driver.findElement(By.id("email"));
        String Semail = EmailField.getAttribute("value");
    	Assert.assertEquals(Email, Semail);
    	//EmailField.click();
    	driver.findElement(By.id("passwd")).sendKeys("Admin");
        Select days = new Select(driver.findElement(By.id("days")));
        days.selectByValue("9");
        Select months = new Select(driver.findElement(By.id("months")));
        months.selectByVisibleText("October ");
        Select years = new Select(driver.findElement(By.id("years")));
        years.selectByValue("1993");
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
      // String firstName = driver.findElement(By.id("firstname")).getAttribute("Value");
        driver.findElement(By.id("address1")).sendKeys("Palk Street");
        driver.findElement(By.id("city")).sendKeys("Delhi");
        Select State = new Select(driver.findElement(By.id("id_state")));
        State.selectByValue("27");
        driver.findElement(By.id("postcode")).sendKeys("10007");
        Select Country = new Select(driver.findElement(By.id("id_country")));
        String DefaultValue =  Country.getFirstSelectedOption().getText();
          if (DefaultValue == null)
             Country.selectByVisibleText("United States");
          else
             System.out.print("\n Default value is already selected" +DefaultValue);
        driver.findElement(By.id("phone_mobile")).sendKeys("9999999999");
        driver.findElement(By.id("alias")).sendKeys("xyz");
        driver.findElement(By.xpath("//button[@id = 'submitAccount']")).click();
 
        
   }
       

    
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
}
