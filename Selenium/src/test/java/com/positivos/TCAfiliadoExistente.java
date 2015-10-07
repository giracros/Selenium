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

public class TCAfiliadoExistente {
	private WebDriver driver;
	private String baseUrl;

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://10.11.230.81:81/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testAfiliadoExistente() throws Exception {
		driver.get(baseUrl
				+ "/AutenticadorWEB/Autenticacion.jsp?cGFyYW1z=ErgFKfZyfwX7S-xijrNYGDam0fB2RJ_pq3FxavbgdLQqCNwydANn-j8aB0H8HQ2Z6qECnHgUc6NIXO-TcswO1CrZqL_SD8BPZt6054PIqd768zuQnxFP-lSsIxTdBh87ynAVMcU5CNJBrAgthg4FWQ2");
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
		driver.findElement(By.name("numIdentificacion")).clear();
		driver.findElement(By.name("numIdentificacion")).sendKeys("4335451");
		driver.findElement(By.name("numIdentificacion")).clear();
		driver.findElement(By.name("numIdentificacion")).sendKeys("4335451");
		driver.findElement(By.name("enviar")).click();
		driver.findElement(By.name("enviar")).click();
		assertEquals("", driver.getTitle());
		assertEquals("", driver.getTitle());
		driver.findElement(By.id("celular")).clear();
		driver.findElement(By.id("celular")).sendKeys("3291029301");
		driver.findElement(By.id("celular")).clear();
		driver.findElement(By.id("celular")).sendKeys("3291029301");
		driver.findElement(By.id("valorAporte")).clear();
		driver.findElement(By.id("valorAporte")).sendKeys("450000");
		driver.findElement(By.id("valorAporte")).clear();
		driver.findElement(By.id("valorAporte")).sendKeys("450000");
		new Select(driver.findElement(By.id("entidadFinanciera"))).selectByVisibleText("BANCOLOMBIA");
		new Select(driver.findElement(By.id("entidadFinanciera"))).selectByVisibleText("BANCOLOMBIA");
		driver.findElement(By.id("numeroCuenta")).clear();
		driver.findElement(By.id("numeroCuenta")).sendKeys("19823749283");
		driver.findElement(By.id("numeroCuenta")).clear();
		driver.findElement(By.id("numeroCuenta")).sendKeys("19823749283");
		driver.findElement(By.id("ingresos")).clear();
		driver.findElement(By.id("ingresos")).sendKeys("4500000");
		driver.findElement(By.id("ingresos")).clear();
		driver.findElement(By.id("ingresos")).sendKeys("4500000");
		driver.findElement(By.id("condiciones")).click();
		driver.findElement(By.id("condiciones")).click();
		driver.findElement(By.id("controlActivos")).click();
		driver.findElement(By.id("controlActivos")).click();
		driver.findElement(By.id("habeasData")).click();
		driver.findElement(By.id("habeasData")).click();
		driver.findElement(By.linkText("Editar")).click();
		driver.findElement(By.linkText("Editar")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("eduwin.fuentes@outlook.com");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("eduwin.fuentes@outlook.com");
		driver.findElement(By.name("dirResidencia")).click();
		new Select(driver.findElement(By.name("via"))).selectByVisibleText("Vereda");
		new Select(driver.findElement(By.name("via"))).selectByVisibleText("Vereda");
		driver.findElement(By.id("dirComplemento")).clear();
		driver.findElement(By.id("dirComplemento")).sendKeys("VeredaPaloSanto");
		driver.findElement(By.id("dirComplemento")).clear();
		driver.findElement(By.id("dirComplemento")).sendKeys("VeredaPaloSanto");
		driver.findElement(By.linkText("Aceptar")).click();
		driver.findElement(By.linkText("Aceptar")).click();
		new Select(driver.findElement(By.id("departamentoResidencia"))).selectByVisibleText("ANTIOQUIA");
		new Select(driver.findElement(By.id("departamentoResidencia"))).selectByVisibleText("ANTIOQUIA");
		new Select(driver.findElement(By.id("ciudadResidencia"))).selectByVisibleText("MEDELLÍN");
		new Select(driver.findElement(By.id("ciudadResidencia"))).selectByVisibleText("MEDELLÍN");
		driver.findElement(By.cssSelector("input.center")).click();
		driver.findElement(By.cssSelector("input.center")).click();
		assertEquals(
				"La solicitud de vinculación fue registrada exitosamente en AFPCore con el código 510225 , felicitaciones por tu nuevo producto.",
				driver.findElement(By.cssSelector("div.result-susc > span")).getText());
		driver.findElement(By.linkText("Cerrar")).click();
		driver.findElement(By.linkText("Cerrar")).click();
		assertEquals("", driver.getTitle());
		assertEquals("", driver.getTitle());
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();

	}

}
