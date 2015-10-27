package com.positivos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TCPromotor {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://10.11.230.81:81/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void tcPromotor() throws Exception {

		loginPortal();

		driver.findElement(By.cssSelector("a[title=\"Patrocinio de empleados\"] > span")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("nit")).clear();
		driver.findElement(By.id("nit")).sendKeys("811035741");
		driver.findElement(By.id("tipoPatrocinio")).click();
		Thread.sleep(3000);
		new Select(driver.findElement(By.id("tipoPatrocinio"))).selectByVisibleText("Apoyo para motivar el ahorro");
		driver.findElement(By.xpath("//option[@value='APOYOMOTIVARAHORRO']")).click();
		driver.findElement(By.id("observaciones")).clear();
		driver.findElement(By.id("observaciones")).sendKeys("Apoyo Zenu");
		driver.findElement(By.name("enviar")).click();
		Thread.sleep(3000);
		AssertJUnit.assertEquals("El registro de patrocinio fue almacenado exitosamente.",
				driver.findElement(By.cssSelector("div.result-susc > span")).getText());
		driver.findElement(By.linkText("Cerrar")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span")).click();
		driver.findElement(By.cssSelector("a[title=\"Patrocinio de empleados\"] > span")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("nit")).clear();
		driver.findElement(By.id("nit")).sendKeys("811035741");
		Thread.sleep(3000);
		try {
			AssertJUnit.assertEquals("Apoyo Zenu", driver.findElement(By.id("observaciones")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			AssertJUnit.assertEquals("INDUSTRIA DE ALIMENTOS ZENU S.A.S",
					driver.findElement(By.id("razonSocial")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			AssertJUnit.assertEquals("LINA MARCELA PUERTA CARMONA",
					driver.findElement(By.id("nombrePromotor")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			AssertJUnit.assertEquals("43205954", driver.findElement(By.id("cedulaPromotor")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.cssSelector("span")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("a[title=\"Salida Segura\"] > span")).click();
		Thread.sleep(3000);
	}

	private void loginPortal() {
		By idNovell = By.name("IdNovell");
		By name = By.name("Clave");
		String url = "/AutenticadorWEB/Autenticacion.jsp?cGFyYW1z=RUUgvh5-hG0lTPgl3AxJR9CVi4MmnLXXUgX5JEDKHpI8rPbU6fugBI6cKeYKrPsusqo8B4ngcWYH6rPQeJbLa4qxZmnDywcBAyKUIZH3wDsOPj6AUqoA4bAA9iLzq8eKijCEySGMz9L-Fe_u8ypORQ2";
		driver.get(baseUrl + url);
		AssertJUnit.assertEquals("Protección - Login", driver.getTitle());
		new Select(driver.findElement(By.name("TipoUsuario"))).selectByVisibleText("Empleado Protección");
		driver.findElement(idNovell).clear();
		driver.findElement(idNovell).sendKeys("lpuerta");
		driver.findElement(name).sendKeys("Proteccion2015");
		driver.findElement(By.name("send")).click();

	}

	@AfterMethod
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}
