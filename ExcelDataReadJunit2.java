//take the values for text boxes using excel file

package com.ms.excel;

import java.io.File;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.After;

public class ExcelDataReadJunit2 {
	private ChromeDriver driver;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chiranjeevi&Shyamala\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Options op = driver.manage();
		Window w = op.window();
		w.maximize();
	}
	@Test
	public void signUp() throws BiffException, IOException {
		File f = new File("C:\\Users\\Chiranjeevi&Shyamala\\Desktop\\shyamalaproject.xls");
		Workbook workbook = Workbook.getWorkbook(f);
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		int columns = sheet.getColumns();
		System.out.println("Total Rows:" + rows);
		System.out.println("Total Columns" + columns);
		for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
			for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
				Cell cell = sheet.getCell(columnIndex, rowIndex);
				System.out.print(cell.getContents());
				System.out.print("\t");
			}
			System.out.println();
		}
		Cell cell = sheet.getCell(0, 1);
		String firstName = cell.getContents();

		cell = sheet.getCell(1, 1);
		String lastName = cell.getContents();

		cell = sheet.getCell(2, 1);
		String mobileNumber = cell.getContents();

		cell = sheet.getCell(3, 1);
		String password = cell.getContents();

		cell = sheet.getCell(4, 1);
		String dobMonth = cell.getContents();

		cell = sheet.getCell(5, 1);
		String dobDay = cell.getContents();

		cell = sheet.getCell(6, 1);
		String dobYear = cell.getContents();

		cell = sheet.getCell(7, 1);
		String gender = cell.getContents();

		WebElement firstNameWE = driver.findElement(By.name("firstname"));
		firstNameWE.sendKeys(firstName);

		WebElement lastNameWE = driver.findElement(By.name("lastname"));
		lastNameWE.sendKeys(lastName);

		WebElement mobileNumberWE = driver.findElement(By.name("reg_email__"));
		mobileNumberWE.sendKeys(mobileNumber);

		WebElement passwordWE = driver.findElement(By.name("reg_passwd__"));
		passwordWE.sendKeys(password);

		WebElement monthWE = driver.findElement(By.cssSelector("select#month"));
		dropDownSelectionByVisisbileText(monthWE, dobMonth);

		WebElement dayWE = driver.findElement(By.cssSelector("select#day"));
		dropDownSelectionByVisisbileText(dayWE, dobDay);

		WebElement yearWE = driver.findElement(By.cssSelector("select#year"));
		dropDownSelectionByVisisbileText(yearWE, dobYear);

		selectGender(gender);

		WebElement websubmit = driver.findElement(By.name("websubmit"));
		websubmit.click();

	}

	private void dropDownSelectionByVisisbileText(WebElement element, String visibleText) {
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}

	private void selectGender(String gender) {
		By by = null;
		if (gender.equalsIgnoreCase("F")) {
			by = By.id("u_0_6");
		} else if (gender.equalsIgnoreCase("M")) {
			by = By.id("u_0_a");
		} else {
			by = By.id("u_0_b");
		}

		WebElement genderWE = driver.findElement(by);
		genderWE.click();
	}

	@After
	public void browserCode() {

		System.out.println("Task Completed!!");
	}

}
