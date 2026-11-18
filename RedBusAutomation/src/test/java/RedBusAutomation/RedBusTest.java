package RedBusAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class RedBusTest {
	
	    WebDriver driver;
	    WebDriverWait wait;

	    @BeforeMethod
	    public void setup() throws InterruptedException {

	        driver = new ChromeDriver();

	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        driver.get("https://www.redbus.in");
	    //    Thread.sleep(2000);
	    }

	    @Test
	    public void searchSleeperBus() throws InterruptedException {

	        // Source City
	    	WebElement element1 = driver.findElement(By.xpath("//*[@id=\"srcinput\"]"));
	    	element1.sendKeys("Chennai");
	    	wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//div[text()='Koyambedu']"))).click();
	    	  Thread.sleep(5000);
	        
	       
	        // Destination City
	        WebElement destination =
	                driver.findElement(By.xpath("//*[@id=\"destinput\"]"));

	        destination.sendKeys("Salem");
	        
	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//*[contains(text(),'Salem New Bus Stand, Salem')]"))).click();
	      Thread.sleep(5000);
	        // Open Calendar
	        driver.findElement(By.xpath("//button[@aria-label='Search for Tomorrow']")).click();
	        Thread.sleep(5000);
	        // Select Date 17
	        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='25']"))).click();

	        // Search Buses
	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//div[text()='Arvind Travels']")))
	                .click();

	        // Wait for results page
	        Thread.sleep(5000);
	      
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='U18']"))).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Select boarding & dropping points']"))).click();
	        
	        // Select Boarding Point
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bp-point-0\"]/div[3]/div/label[1]"))).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"bp-point-0\"]/div[3]/div/label)[2]"))).click();
	        
	        
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='Phone']"))).sendKeys("8930829199");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Enter your Name\"]"))).sendKeys("Monisha");
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Enter Age\"]"))).sendKeys("27");
	            
	       System.out.println("bus booked successfully");
	    }

	    @AfterMethod
	    public void tearDown() {

	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}