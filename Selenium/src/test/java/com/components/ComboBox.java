package com.components;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ComboBox {
	public WebDriver driver;
	public String baseURL;

	@BeforeTest
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		baseURL = "http://hscripts.com/tutorials/html/form-combobox.php";
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testSelectOption() throws InterruptedException {
		
		driver.get(baseURL);

		WebElement select = driver.findElement(By.xpath(".//form[1]/select"));
		WebElement multiSelect = driver.findElement(By.xpath(".//form[3]/select"));
		List<WebElement> selectedValues = new ArrayList<>();

		Select dropdown = new Select(select);
		dropdown.deselectAll();
		dropdown.selectByValue("two");
		selectedValues = dropdown.getAllSelectedOptions();
		for (WebElement value : selectedValues) {
			System.out.println("Selected Value: " + value.getText());
		}
		Thread.sleep(3000);

		dropdown = new Select(multiSelect);
		dropdown.deselectAll();
		dropdown.selectByValue("three");
		dropdown.selectByValue("four");
		selectedValues = dropdown.getAllSelectedOptions();
		for (WebElement value : selectedValues) {
			System.out.println("Selected Value: " + value.getText());
		}
		Thread.sleep(3000);
		dropdown.deselectAll();
		Thread.sleep(3000);
	}
}