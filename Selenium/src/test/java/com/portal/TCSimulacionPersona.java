package com.portal;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TCSimulacionPersona {
	private WebDriver driver;
	private String baseUrl;

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://10.11.230.3/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testSimulacionAporte() throws Exception {
		driver.get(baseUrl + "/wps/portal/proteccion/masproteccion/home/");
		assertEquals("Home", driver.getTitle());
		driver.findElement(By.linkText("Soy Persona")).click();
		driver.findElement(By.linkText("Soy Persona")).click();
		assertEquals("Afiliado", driver.getTitle());
		assertEquals("Afiliado", driver.getTitle());
		driver.findElement(By.linkText("Descubre cuánto es +")).click();
		driver.findElement(By.linkText("Descubre cuánto es +")).click();
		assertEquals("Afiliado", driver.getTitle());
		assertEquals("Afiliado", driver.getTitle());
		new Select(driver.findElement(By.id("soy"))).selectByVisibleText("Hombre");
		new Select(driver.findElement(By.id("soy"))).selectByVisibleText("Hombre");
		new Select(driver.findElement(By.id("edad"))).selectByVisibleText("25 años");
		new Select(driver.findElement(By.id("edad"))).selectByVisibleText("25 años");
		driver.findElement(By.id("salario")).clear();
		driver.findElement(By.id("salario")).sendKeys("3500000");
		driver.findElement(By.id("salario")).clear();
		driver.findElement(By.id("salario")).sendKeys("3500000");
		driver.findElement(By.name("simular")).click();
		driver.findElement(By.name("simular")).click();
		assertEquals("$66.000",
				driver.findElement(By.xpath("//div[@id='section1']/div/div/div/div[5]/div/div[2]/div[2]")).getText());
		assertEquals("$380.277", driver
				.findElement(By.xpath("//div[@id='section1']/div/div/div/div[5]/div[3]/div[2]/div[2]")).getText());
		assertEquals("$300.000+",
				driver.findElement(By.xpath("//div[@id='section1']/div/div/div/div[6]/div/div/div/div[2]")).getText());
		assertEquals("$80.277", driver
				.findElement(By.xpath("//div[@id='section1']/div/div/div/div[6]/div/div/div[2]/div[2]")).getText());
		driver.findElement(By.linkText("Enviar simulación a mi correo")).click();
		driver.findElement(By.linkText("Enviar simulación a mi correo")).click();
		new Select(driver.findElement(By.name("tipoId"))).selectByVisibleText("CC");
		new Select(driver.findElement(By.name("tipoId"))).selectByVisibleText("CC");
		driver.findElement(By.id("numIdentificacion")).clear();
		driver.findElement(By.id("numIdentificacion")).sendKeys("1018436098");
		driver.findElement(By.id("numIdentificacion")).clear();
		driver.findElement(By.id("numIdentificacion")).sendKeys("1018436098");
		driver.findElement(By.id("primerNombre")).clear();
		driver.findElement(By.id("primerNombre")).sendKeys("Daniel Fuentes");
		driver.findElement(By.id("primerNombre")).clear();
		driver.findElement(By.id("primerNombre")).sendKeys("Daniel Fuentes");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("eduwin.fuentes@outlook.com");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("eduwin.fuentes@outlook.com");
		driver.findElement(By.cssSelector("button.custom-btn")).click();
		driver.findElement(By.cssSelector("button.custom-btn")).click();
		assertEquals("El correo ha sido enviado exitosamente.",
				driver.findElement(By.cssSelector("p.confirmation")).getText());
		driver.findElement(By.cssSelector("div.exito-view > a.custom-btn")).click();
		driver.findElement(By.cssSelector("div.exito-view > a.custom-btn")).click();
		assertEquals("$0",
				driver.findElement(By.xpath("//div[@id='section1']/div/div/div/div[5]/div/div[2]/div[2]")).getText());
		assertEquals("$0", driver.findElement(By.xpath("//div[@id='section1']/div/div/div/div[5]/div[3]/div[2]/div[2]"))
				.getText());
		assertEquals("$0",
				driver.findElement(By.xpath("//div[@id='section1']/div/div/div/div[6]/div/div/div/div[2]")).getText());
		assertEquals("$0", driver
				.findElement(By.xpath("//div[@id='section1']/div/div/div/div[6]/div/div/div[2]/div[2]")).getText());
		assertTrue(driver.findElement(By.id("soy")).getText().matches("^exact:[\\s\\S]*Soy Hombre Mujer$"));
		assertTrue(driver.findElement(By.id("edad")).getText().matches(
				"^exact:[\\s\\S]*Mi edad es 18 años19 años20 años21 años22 años23 años24 años25 años26 años27 años28 años29 años30 años31 años32 años33 años34 años35 años36 años37 años38 años39 años40 años41 años42 años43 años44 años45 años46 años47 años48 años49 años50 años51 años52 años53 años54 años55 años56 años57 años58 años59 años60 años61 años62 años$"));
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();

	}

}
