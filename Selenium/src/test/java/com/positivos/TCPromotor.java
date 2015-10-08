package com.positivos;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TCPromotor {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://10.11.230.81:81/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testPatrocinioOk() throws Exception {
		driver.get(baseUrl
				+ "/AutenticadorWEB/Autenticacion.jsp?cGFyYW1z=GyIJfJBgvS0SnDoKEY1jtHSYTGpXpn4SZZSbg6J7zj_gvW0cSSb1iWa1N_CzIfYMtcmgTnMAjNUKEBuGx8v0JqwnXl4WQdMqfmI7q8JztZ7HwzrKA_Cb_2SGt6yed4QgFNXc-BTp14VrtV_nAe3jTw2");
		assertEquals("Protección - Login", driver.getTitle());
		driver.findElement(By.name("Clave")).clear();
		driver.findElement(By.name("Clave")).sendKeys("Proteccion2015");
		driver.findElement(By.name("Clave")).clear();
		driver.findElement(By.name("Clave")).sendKeys("Proteccion2015");
		new Select(driver.findElement(By.name("TipoUsuario"))).selectByVisibleText("Empleado Protección");
		driver.findElement(By.name("IdNovell")).clear();
		driver.findElement(By.name("IdNovell")).sendKeys("lpuerta");
		driver.findElement(By.name("send")).click();
		assertEquals("", driver.getTitle());
		driver.findElement(By.cssSelector("a[title=\"Patrocinio de empleados\"] > span")).click();
		assertEquals("", driver.getTitle());
		driver.findElement(By.id("nit")).clear();
		driver.findElement(By.id("nit")).sendKeys("811035741");
		driver.findElement(By.id("tipoPatrocinio")).click();
		new Select(driver.findElement(By.id("tipoPatrocinio"))).selectByVisibleText("Apoyo para motivar el ahorro");
		driver.findElement(By.xpath("//option[@value='APOYOMOTIVARAHORRO']")).click();
		driver.findElement(By.id("observaciones")).clear();
		driver.findElement(By.id("observaciones")).sendKeys("Apoyo Zenu");
		driver.findElement(By.id("observaciones")).clear();
		driver.findElement(By.id("observaciones")).sendKeys("Apoyo Zenu");
		driver.findElement(By.name("enviar")).click();
		driver.findElement(By.name("enviar")).click();
		assertEquals("El registro de patrocinio fue almacenado exitosamente.",
				driver.findElement(By.cssSelector("div.result-susc > span")).getText());
		driver.findElement(By.linkText("Cerrar")).click();
		driver.findElement(By.linkText("Cerrar")).click();
		driver.findElement(By.cssSelector("span")).click();
		driver.findElement(By.cssSelector("span")).click();
		assertEquals("", driver.getTitle());
		assertEquals("", driver.getTitle());
		driver.findElement(By.cssSelector("a[title=\"Patrocinio de empleados\"] > span")).click();
		driver.findElement(By.cssSelector("a[title=\"Patrocinio de empleados\"] > span")).click();
		assertEquals("", driver.getTitle());
		assertEquals("", driver.getTitle());
		driver.findElement(By.id("nit")).clear();
		driver.findElement(By.id("nit")).sendKeys("811035741");
		driver.findElement(By.id("nit")).clear();
		driver.findElement(By.id("nit")).sendKeys("811035741");
		try {
			assertEquals("Apoyo Zenu", driver.findElement(By.id("observaciones")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("INDUSTRIA DE ALIMENTOS ZENU S.A.S",
					driver.findElement(By.id("razonSocial")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("LINA MARCELA PUERTA CARMONA",
					driver.findElement(By.id("nombrePromotor")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("43205954", driver.findElement(By.id("cedulaPromotor")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.cssSelector("span")).click();
		driver.findElement(By.cssSelector("span")).click();
		assertEquals("", driver.getTitle());
		assertEquals("", driver.getTitle());
		driver.findElement(By.cssSelector("a[title=\"Salida Segura\"] > span")).click();
		assertEquals("Cerrando aplicacion...", driver.getTitle());
		assertEquals("Protección - Login", driver.getTitle());
		driver.findElement(By.name("Clave")).clear();
		driver.findElement(By.name("Clave")).sendKeys("Proteccion2015");
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}
