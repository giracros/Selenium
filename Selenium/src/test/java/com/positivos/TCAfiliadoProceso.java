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

public class TCAfiliadoProceso {
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
	public void testAfiliadoProceso() throws Exception {
		driver.get(baseUrl
				+ "/AutenticadorWEB/Autenticacion.jsp?cGFyYW1z=DPNbuTgh7qh0B6XEM3g4vSCs66ObNk1eV5suiW7XNWJ1AfzlWp2bVY9B1WL8XCQUJxz4YIi37pRjNFehYhQ3yVPHD-97CB3Hyy-pw6_O94liUqN3LFB_aWgHAVHeOZw1ua7eqqkQp08xYEBclHi1Aw2");
		assertEquals("Protección - Login", driver.getTitle());
		driver.findElement(By.name("Clave")).clear();
		driver.findElement(By.name("Clave")).sendKeys("Proteccion2015");
		driver.findElement(By.name("Clave")).clear();
		driver.findElement(By.name("Clave")).sendKeys("Proteccion2015");
		new Select(driver.findElement(By.name("TipoUsuario"))).selectByVisibleText("Empleado Protección");
		new Select(driver.findElement(By.name("TipoUsuario"))).selectByVisibleText("Empleado Protección");
		driver.findElement(By.name("IdNovell")).clear();
		driver.findElement(By.name("IdNovell")).sendKeys("lpuerta");
		driver.findElement(By.name("IdNovell")).clear();
		driver.findElement(By.name("IdNovell")).sendKeys("lpuerta");
		driver.findElement(By.name("send")).click();
		driver.findElement(By.name("send")).click();
		assertEquals("", driver.getTitle());
		assertEquals("", driver.getTitle());
		driver.findElement(By.name("numIdentificacion")).clear();
		driver.findElement(By.name("numIdentificacion")).sendKeys("42893634");
		driver.findElement(By.name("numIdentificacion")).clear();
		driver.findElement(By.name("numIdentificacion")).sendKeys("42893634");
		driver.findElement(By.name("enviar")).click();
		try {
			assertEquals("Mensaje: Afiliado tiene otra solicitud en proceso",
					driver.findElement(By.cssSelector("td.conTextError")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertEquals("Mensaje: Afiliado tiene otra solicitud en proceso",
				driver.findElement(By.cssSelector("td.conTextError")).getText());
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
