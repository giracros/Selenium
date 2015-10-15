package com.negativos.mandatorios;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TCCamposMandatoriosPromotor {

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	String campoRequerido = "Campo requerido";
	String nombrePromotor = "LINA MARCELA PUERTA CARMONA";
	String cedulaPromotor = "43205954";
	
	By nit = By.id("nit-error");
	By razonSocial = By.id("razonSocial-error");
	By tipoPatrocinio = By.id("tipoPatrocinio-error");;
	By tipoAporte = By.id("tipoAporte-error");
	By periocidad = By.id("periodicidad-error");
	By otraPeriocidad = By.id("otraPeriodicidad-error");
	By valorTope = By.id("valorTope-error");
	By cantidadEmpleado = By.id("cantidadEmpleadosPrograma-error");
	By paginaPatrocinio = By.cssSelector("a[title=\"Patrocinio de empleados\"] > span");
	By cedulaPromotorLocator = By.id("cedulaPromotor");
	By nombrePromotorLocator = By.id("nombrePromotor");
	@BeforeTest
	public void beforeTest() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://10.11.230.81:81/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void camposMandatoriosPromotor() throws Exception {
		loginPortal();
		assertEquals("", driver.getTitle());
		driver.findElement(paginaPatrocinio).click();
		Thread.sleep(3000);
		try {
			assertEquals(cedulaPromotor, driver.findElement(cedulaPromotorLocator).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(nombrePromotor, driver.findElement(nombrePromotorLocator).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.name("enviar")).click();
		Thread.sleep(3000);
		assertEquals(campoRequerido, driver.findElement(nit).getText());
		assertEquals(campoRequerido, driver.findElement(razonSocial).getText());
		assertEquals(campoRequerido, driver.findElement(tipoPatrocinio).getText());
		assertEquals(campoRequerido, driver.findElement(tipoAporte).getText());
		assertEquals(campoRequerido, driver.findElement(periocidad).getText());
		assertEquals(campoRequerido, driver.findElement(otraPeriocidad).getText());
		assertEquals(campoRequerido, driver.findElement(valorTope).getText());
		assertEquals(campoRequerido, driver.findElement(cantidadEmpleado).getText());
		driver.findElement(By.cssSelector("span")).click();
		Thread.sleep(3000);
		assertEquals("", driver.getTitle());
	}

	public void loginPortal() {
		By idNovell = By.name("IdNovell");
		By name = By.name("Clave");
		String url = "/AutenticadorWEB/Autenticacion.jsp?cGFyYW1z=RUUgvh5-hG0lTPgl3AxJR9CVi4MmnLXXUgX5JEDKHpI8rPbU6fugBI6cKeYKrPsusqo8B4ngcWYH6rPQeJbLa4qxZmnDywcBAyKUIZH3wDsOPj6AUqoA4bAA9iLzq8eKijCEySGMz9L-Fe_u8ypORQ2";
		driver.get(baseUrl + url);
		assertEquals("Protección - Login", driver.getTitle());
		new Select(driver.findElement(By.name("TipoUsuario"))).selectByVisibleText("Empleado Protección");
		driver.findElement(idNovell).clear();
		driver.findElement(idNovell).sendKeys("lpuerta");
		driver.findElement(name).sendKeys("Proteccion2015");
		driver.findElement(By.name("send")).click();
	}

	@AfterTest
	public void afterTest() throws Exception {
		driver.quit();
	}
}
