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

public class TCSimuladorMujer {
	private WebDriver driver;
	private String baseUrl;

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://10.11.230.3/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testMujerSimulador() throws Exception {

		driver.get(baseUrl + "/wps/portal/proteccion/masproteccion/home/afiliado/");
		assertEquals("Afiliado", driver.getTitle());

		driver.findElement(By.linkText("Descubre cuánto es +")).click();

		Select selectGenero = new Select(driver.findElement(By.name("soy")));
		selectGenero.selectByValue("F");
		Select selectEdad = new Select(driver.findElement(By.name("edad")));
		selectEdad.selectByValue("25");

		// new Select(driver.findElement(By.id("soy"))).selectByValue("M");
		// new Select(driver.findElement(By.id("edad"))).selectByVisibleText("25
		// años");

		driver.findElement(By.id("salario")).clear();
		driver.findElement(By.id("salario")).sendKeys("3500000");

		driver.findElement(By.name("simular")).click();

		assertEquals("$96.000",
				driver.findElement(By.xpath("//div[@id='section1']/div/div/div/div[5]/div/div[2]/div[2]")).getText());

		assertEquals("$367.991", driver
				.findElement(By.xpath("//div[@id='section1']/div/div/div/div[5]/div[3]/div[2]/div[2]")).getText());

		assertEquals("$300.000+",
				driver.findElement(By.xpath("//div[@id='section1']/div/div/div/div[6]/div/div/div/div[2]")).getText());

		assertEquals("$67.991", driver
				.findElement(By.xpath("//div[@id='section1']/div/div/div/div[6]/div/div/div[2]/div[2]")).getText());

	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();

	}
}
