//Signup page automation using xpath with generic method
//of drop down selection with Junit
package apps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class YahooSignUp {
	private ChromeDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chiranjeevi&Shyamala\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.yahoo.com/account/create");
		Options op = driver.manage();
		Window w = op.window();
		w.maximize();
	}

	@Test
	public void SignUp() throws InterruptedException {
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstName']"));
		firstname.sendKeys("Shyamala");

		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastName' and @id='usernamereg-lastName']"));
		lastname.sendKeys("Student");

		WebElement email = driver.findElement(By.xpath("//input[@autocomplete='username' or @id='usernamereg-yid']"));
		email.sendKeys("shyamalastudent");

		WebElement passWord = driver.findElement(By.xpath("//input[@id='usernamereg-password']"));
		passWord.sendKeys("ghyrdse");

		WebElement shortCountryCode = driver.findElement(By.xpath("//select[@name='shortCountryCode']"));
		dropDownSelectionByValue(shortCountryCode, "AL");

		WebElement phoneNumber = driver.findElement(By.xpath("//*[@id='usernamereg-phone']"));
		phoneNumber.sendKeys("1234567891");

		WebElement month = driver.findElement(By.xpath("//*[@id='usernamereg-month']"));
		dropDownSelectionByValue(month, "10");

		WebElement day = driver.findElement(By.xpath("//*[@id='usernamereg-day']"));
		day.sendKeys("19");

		WebElement year = driver.findElement(By.xpath("//*[@id='usernamereg-year']"));
		year.sendKeys("2010");
		Thread.sleep(6000);

	}

	private void dropDownSelectionByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	@After
	public void browserCode() {
		driver.close();
		System.out.println("Test Cases are sucessfully executed");
	}

}
