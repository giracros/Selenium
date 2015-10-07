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

public class TCContactos {
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
	public void testContactoOk() throws Exception {
		driver.get(baseUrl
				+ "/AutenticadorWEB/Autenticacion.jsp?cGFyYW1z=FgRWxYWyndACDAp-r6A9TIoav0qVIgBsp3ifo-L7-FXf5XEx9IcnP-3sqqEkTlrlL4wcgm0Nl3Mu6tjrRSzdxP9LzOzfuhbXNKWHBJgS51HCiw0SreNfhSh6otIIdjsYnAady106qPtOFj-6WO9ORw2");
		assertEquals("Protección - Login", driver.getTitle());
		new Select(driver.findElement(By.name("TipoUsuario"))).selectByVisibleText("Empleado Protección");
		new Select(driver.findElement(By.name("TipoUsuario"))).selectByVisibleText("Empleado Protección");
		new Select(driver.findElement(By.name("TipoUsuario"))).selectByVisibleText("Empleado Protección");
		driver.findElement(By.name("IdNovell")).clear();
		driver.findElement(By.name("IdNovell")).sendKeys("lpuerta");
		driver.findElement(By.name("IdNovell")).clear();
		driver.findElement(By.name("IdNovell")).sendKeys("lpuerta");
		driver.findElement(By.name("IdNovell")).clear();
		driver.findElement(By.name("IdNovell")).sendKeys("lpuerta");
		driver.findElement(By.name("send")).click();
		driver.findElement(By.name("send")).click();
		driver.findElement(By.name("send")).click();
		assertEquals("", driver.getTitle());
		assertEquals("", driver.getTitle());
		driver.findElement(By.cssSelector("a[title=\"Contacto\"] > span")).click();
		driver.findElement(By.cssSelector("a[title=\"Contacto\"] > span")).click();
		assertEquals("", driver.getTitle());
		assertEquals("", driver.getTitle());
		driver.findElement(By.id("nit")).clear();
		driver.findElement(By.id("nit")).sendKeys("811035741");
		driver.findElement(By.id("nit")).clear();
		driver.findElement(By.id("nit")).sendKeys("811035741");
		driver.findElement(By.id("nombreCompleto")).clear();
		driver.findElement(By.id("nombreCompleto")).sendKeys("Andres Camilo");
		driver.findElement(By.id("nombreCompleto")).clear();
		driver.findElement(By.id("nombreCompleto")).sendKeys("Andres Camilo");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("andrescamilo@zenu.com.co");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("andrescamilo@zenu.com.co");
		driver.findElement(By.id("cargo")).clear();
		driver.findElement(By.id("cargo")).sendKeys("Auxiliar de Recursos Humanos");
		driver.findElement(By.id("cargo")).clear();
		driver.findElement(By.id("cargo")).sendKeys("Auxiliar de Recursos Humanos");
		driver.findElement(By.id("celular")).clear();
		driver.findElement(By.id("celular")).sendKeys("4309203909");
		driver.findElement(By.id("celular")).clear();
		driver.findElement(By.id("celular")).sendKeys("4309203909");
		driver.findElement(By.id("telefono")).clear();
		driver.findElement(By.id("telefono")).sendKeys("4328309");
		driver.findElement(By.id("telefono")).clear();
		driver.findElement(By.id("telefono")).sendKeys("4328309");
		driver.findElement(By.id("aporteAhorroEmpleado")).clear();
		driver.findElement(By.id("aporteAhorroEmpleado")).sendKeys("5");
		driver.findElement(By.id("aporteAhorroEmpleado")).clear();
		driver.findElement(By.id("aporteAhorroEmpleado")).sendKeys("5");
		driver.findElement(By.id("observaciones")).clear();
		driver.findElement(By.id("observaciones")).sendKeys("Muchas Gracias espero proximos contactos");
		driver.findElement(By.id("observaciones")).clear();
		driver.findElement(By.id("observaciones")).sendKeys("Muchas Gracias espero proximos contactos");
		try {
			assertEquals("INDUSTRIA DE ALIMENTOS ZENU S.A.S",
					driver.findElement(By.id("razonSocial")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.name("enviar")).click();
		driver.findElement(By.name("enviar")).click();
		assertEquals("El registro de contacto fue almacenado exitosamente.",
				driver.findElement(By.cssSelector("div.result-susc > span")).getText());
		driver.findElement(By.linkText("Cerrar")).click();
		driver.findElement(By.linkText("Cerrar")).click();
		driver.findElement(By.cssSelector("span")).click();
		driver.findElement(By.cssSelector("span")).click();
		assertEquals("", driver.getTitle());
		assertEquals("", driver.getTitle());
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}
