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

public class TCCamposMandatoriosAfiliado {

	private WebDriver driver;
	private String baseUrl;
	
	By idNovell = By.name("IdNovell");
	By clave = By.name("Clave");
	
	By habeas = By.id("habeasData-error");
	By controlActivos = By.id("controlActivos-error");
	By condiciones = By.id("condiciones-error");
	By pasivos = By.id("totalPasivos-error");
	By activos = By.id("totalActivos-error");
	By egresos = By.id("egresos-error");
	By ingresos = By.id("ingresos-error");
	By numeroCuenta = By.id("numeroCuenta-error");
	By valorAporte = By.id("valorAporte-error");
	By razonSocial = By.id("razonSocial-error");
	By nit = By.id("nit-error");
	By email = By.id("email-error");
	By telefono = By.id("telefono-error");
	By celular = By.id("celular-error");
	By dirResidencia = By.id("dirResidencia-error");
	By sexo = By.id("sexoSelected-error");
	By primerApellido = By.id("primerApellido-error");
	By primerNombre = By.id("primerNombre-error");
	By fechaNacimiento = By.id("fechaNacimiento-error");
	By fechaExpedicion = By.id("fechaExpedicion-error");
	
	By click = By.cssSelector("span");
	By enviar = By.cssSelector("input.center");
	By nameEnviar = By.name("enviar");
	String campoRequerido = "Campo requerido";
	By numIdentificacion = By.name("numIdentificacion");

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://10.11.230.81:81/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void camposMandotoriosAfiliado() throws Exception {
		loginPortal();
		assertEquals("", driver.getTitle());
		driver.findElement(numIdentificacion).clear();
		driver.findElement(numIdentificacion).sendKeys("1029382984");
		
		driver.findElement(nameEnviar).click();
		
		driver.findElement(enviar).click();
		assertEquals(campoRequerido, driver.findElement(habeas).getText());
		assertEquals(campoRequerido, driver.findElement(controlActivos).getText());
		assertEquals(campoRequerido, driver.findElement(condiciones).getText());
		assertEquals(campoRequerido, driver.findElement(pasivos).getText());
		assertEquals(campoRequerido, driver.findElement(activos).getText());
		assertEquals(campoRequerido, driver.findElement(egresos).getText());
		assertEquals(campoRequerido, driver.findElement(ingresos).getText());
		assertEquals(campoRequerido, driver.findElement(numeroCuenta).getText());
		assertEquals(campoRequerido, driver.findElement(valorAporte).getText());
		assertEquals(campoRequerido, driver.findElement(razonSocial).getText());
		assertEquals(campoRequerido, driver.findElement(nit).getText());
		assertEquals(campoRequerido, driver.findElement(email).getText());
		assertEquals(campoRequerido, driver.findElement(telefono).getText());
		assertEquals(campoRequerido, driver.findElement(celular).getText());
		assertEquals(campoRequerido, driver.findElement(dirResidencia).getText());
		assertEquals(campoRequerido, driver.findElement(sexo).getText());
		assertEquals(campoRequerido, driver.findElement(primerApellido).getText());
		assertEquals(campoRequerido, driver.findElement(primerNombre).getText());
		assertEquals(campoRequerido, driver.findElement(fechaNacimiento).getText());
		assertEquals(campoRequerido, driver.findElement(fechaExpedicion).getText());
		driver.findElement(click).click();
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
	public void afterTest() {
		driver.quit();
	}
}
