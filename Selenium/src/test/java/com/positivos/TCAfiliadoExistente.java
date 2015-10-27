package com.positivos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
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
	public void tcAfiliadoExistente() throws Exception {

		loginPortal();

		Thread.sleep(3000);
		driver.findElement(By.name("numIdentificacion")).clear();
		driver.findElement(By.name("numIdentificacion")).sendKeys("71746592");
		driver.findElement(By.name("enviar")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("celular")).clear();
		driver.findElement(By.id("celular")).sendKeys("3291029301");
		driver.findElement(By.id("valorAporte")).clear();
		driver.findElement(By.id("valorAporte")).sendKeys("450000");

		new Select(driver.findElement(By.id("entidadFinanciera"))).selectByVisibleText("BANCOLOMBIA");
		
		driver.findElement(By.id("numeroCuenta")).clear();
		driver.findElement(By.id("numeroCuenta")).sendKeys("19823749283");
		driver.findElement(By.id("ingresos")).clear();
		driver.findElement(By.id("ingresos")).sendKeys("4500000");
		driver.findElement(By.id("condiciones")).click();
		driver.findElement(By.id("controlActivos")).click();
		driver.findElement(By.id("habeasData")).click();
		driver.findElement(By.linkText("Editar")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("eduwin.fuentes@outlook.com");
		driver.findElement(By.name("dirResidencia")).click();
		Thread.sleep(3000);
		new Select(driver.findElement(By.name("via"))).selectByVisibleText("Vereda");
		driver.findElement(By.id("dirComplemento")).clear();
		driver.findElement(By.id("dirComplemento")).sendKeys("VeredaPaloSanto");
		driver.findElement(By.linkText("Aceptar")).click();
		Thread.sleep(3000);
		new Select(driver.findElement(By.id("departamentoResidencia"))).selectByVisibleText("ANTIOQUIA");
		new Select(driver.findElement(By.id("ciudadResidencia"))).selectByVisibleText("MEDELLÍN");
		driver.findElement(By.cssSelector("input.center")).click();
		Thread.sleep(3000);
		
		AssertJUnit.assertEquals(
				"La solicitud de vinculación fue registrada exitosamente en AFPCore con el código 510225 , felicitaciones por tu nuevo producto.",

				driver.findElement(By.cssSelector("div.result-susc > span")).getText());

		driver.findElement(By.linkText("Cerrar")).click();
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

	@AfterTest
	public void despuesTest() throws Exception {
		
		driver.quit();
		
	}

}
