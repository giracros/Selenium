package com.portal;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TCSimuladorHombre {
	private WebDriver driver;
	private String baseUrl;

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://10.11.230.3/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testSimulacion1() throws Exception {

		driver.get(baseUrl + "/wps/portal/proteccion/masproteccion/home/");

		assertEquals("Home", driver.getTitle());

		driver.findElement(By.linkText("Soy Persona")).click();

		driver.findElement(By.linkText("Descubre cu�nto es +")).click();

		new Select(driver.findElement(By.id("soy"))).selectByValue("M");

		new Select(driver.findElement(By.id("edad"))).selectByVisibleText("18 a�os");

		driver.findElement(By.id("salario")).clear();

		driver.findElement(By.id("salario")).sendKeys("1000000");

		driver.findElement(By.name("simular")).click();

		assertEquals("$16.000",
				driver.findElement(By.xpath("//div[@id='section1']/div/div/div/div[5]/div/div[2]/div[2]")).getText());
		assertEquals("$131.478", driver
				.findElement(By.xpath("//div[@id='section1']/div/div/div/div[5]/div[3]/div[2]/div[2]")).getText());
		assertEquals("$100.000+",
				driver.findElement(By.xpath("//div[@id='section1']/div/div/div/div[6]/div/div/div/div[2]")).getText());
		assertEquals("$31.478", driver
				.findElement(By.xpath("//div[@id='section1']/div/div/div/div[6]/div/div/div[2]/div[2]")).getText());

		driver.findElement(By.cssSelector("img.img-responsive.center-block")).click();

		assertEquals("Home", driver.getTitle());
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

}
