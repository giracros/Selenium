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

public class TCCamposMandatoriosContactos {

	private WebDriver driver;
	private String baseUrl;
	By nit = By.id("nit-error");
	By razonSocial = By.id("razonSocial-error");
	By nombreCompleto = By.id("nombreCompleto-error");
	By email = By.id("email-error");
	By cargo = By.id("cargo-error");
	By telefono = By.id("telefono-error");
	By aporteAhorro = By.id("aporteAhorroEmpleado-error");
	By contactoLink = By.cssSelector("a[title=\"Contacto\"] > span");
	By click = By.name("enviar");

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://10.11.230.81:81/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void camposMandatoriosContactos() throws Exception {

		loginPortal();
		assertEquals("", driver.getTitle());
		String campoRequerido = "Campo requerido";
		driver.findElement(contactoLink).click();
		assertEquals("", driver.getTitle());
		driver.findElement(click).click();
		assertEquals(campoRequerido, driver.findElement(nit).getText());
		assertEquals(campoRequerido, driver.findElement(razonSocial).getText());
		assertEquals(campoRequerido, driver.findElement(nombreCompleto).getText());
		assertEquals(campoRequerido, driver.findElement(email).getText());
		assertEquals(campoRequerido, driver.findElement(cargo).getText());
		assertEquals(campoRequerido, driver.findElement(telefono).getText());
		assertEquals(campoRequerido, driver.findElement(aporteAhorro).getText());
		driver.findElement(By.cssSelector("span")).click();
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
	public void cerrarExplorador() throws Exception {
		driver.quit();
	}
}
