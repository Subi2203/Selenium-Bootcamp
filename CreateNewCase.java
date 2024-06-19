package bootCamp;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewCase {

	public static void main(String[] args) throws InterruptedException {
		
		/*Test Steps:
			1) Launch the app
			2) Click Login
			3) Login with the credentials
			4) Click on Global Actions SVG icon
			5) Click on New Case
			6) Choose Contact Name from the dropdown
			7) Select Case origin as email
			8) Select status as Escalated
			9) Enter Subject as 'Testing' and description as 'Dummy'
			10) Click 'Save' and verify the message
			Expected Result:New Case should be created successfullyStep */
		
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Launch the application
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		//Enter credentials
		driver.findElement(By.id("username")).sendKeys("bootcamp_2024@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		driver.findElement(By.id("Login")).click();
		
		//Click Global icon
		Thread.sleep(10000);
		driver.findElement(By.className("slds-icon-waffle")).click();
		
		//Click View All
		//Thread.sleep(10000);
		//driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
		//Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@href='/lightning/app/06mdM000001oohVQAQ\']")).click();
		
		//Click More
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='More']")).click();
		
		//Click Cases
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement cases = driver.findElement(By.xpath("//a[@href='/lightning/o/Case/home'][@role='menuitem']/span[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", cases);
		
		//Click New
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		//Click Contact Name text field
		driver.findElement(By.xpath("//label[text()='Contact Name']/following::input[1]")).click();
		
		//Choose name from the dropdown
		driver.findElement(By.xpath("//span[text()='Anand Kumar']")).click();
		
		//Click Status dropdown
		driver.findElement(By.xpath("//label[text()='Status']/following::button[1]")).click();
		
		//Select Escalated from dropdown
		driver.findElement(By.xpath("//span[text()='Escalated']")).click();


	}

}
