package com.negativos.tiposcampo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TCTiposCamposContactos {

	private WebDriver driver;
	private String baseUrl;
	String campoAlfabetico = "Campo alfab�tico";
	String campoInvalido = "Correo inv�lido";
	String campoNumerico = "Campo num�rico";
	String campoRequerido = "Campo requerido";
	String campoInvalidoPorcentaje = "Valor % inv�lido";


	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://10.11.230.81:81/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void tiposCampoContactos() throws Exception {

		loginPortal();

		AssertJUnit.assertEquals("", driver.getTitle());

		driver.findElement(By.cssSelector("a[title=\"Contacto\"] > span")).click();

		AssertJUnit.assertEquals("", driver.getTitle());

		driver.findElement(By.id("nit")).clear();
		driver.findElement(By.id("nit")).sendKeys("dsa");
		driver.findElement(By.id("nombreCompleto")).clear();
		driver.findElement(By.id("nombreCompleto")).sendKeys("123");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("123");
		driver.findElement(By.id("cargo")).clear();
		driver.findElement(By.id("cargo")).sendKeys("321");
		driver.findElement(By.id("celular")).clear();
		driver.findElement(By.id("celular")).sendKeys("asd");
		driver.findElement(By.id("telefono")).clear();
		driver.findElement(By.id("telefono")).sendKeys("asd");
		driver.findElement(By.id("aporteAhorroEmpleado")).clear();
		driver.findElement(By.id("aporteAhorroEmpleado")).sendKeys("asd");
		driver.findElement(By.name("enviar")).click();

		AssertJUnit.assertEquals(campoAlfabetico, driver.findElement(By.id("nombreCompleto-error")).getText());
		AssertJUnit.assertEquals(campoAlfabetico, driver.findElement(By.id("cargo-error")).getText());
		AssertJUnit.assertEquals(campoInvalido, driver.findElement(By.id("email-error")).getText());
		AssertJUnit.assertEquals(campoNumerico, driver.findElement(By.id("nit-error")).getText());
		AssertJUnit.assertEquals(campoNumerico, driver.findElement(By.id("celular-error")).getText());
		AssertJUnit.assertEquals(campoNumerico, driver.findElement(By.id("telefono-error")).getText());
		AssertJUnit.assertEquals(campoInvalidoPorcentaje,
				driver.findElement(By.id("aporteAhorroEmpleado-error")).getText());
		AssertJUnit.assertEquals(campoRequerido, driver.findElement(By.id("razonSocial-error")).getText());
		driver.findElement(By.cssSelector("span")).click();
		AssertJUnit.assertEquals("", driver.getTitle());
	}

	public void loginPortal() {
		By idNovell = By.name("IdNovell");
		By name = By.name("Clave");
		String url = "/AutenticadorWEB/Autenticacion.jsp?cGFyYW1z=RUUgvh5-hG0lTPgl3AxJR9CVi4MmnLXXUgX5JEDKHpI8rPbU6fugBI6cKeYKrPsusqo8B4ngcWYH6rPQeJbLa4qxZmnDywcBAyKUIZH3wDsOPj6AUqoA4bAA9iLzq8eKijCEySGMz9L-Fe_u8ypORQ2";
		driver.get(baseUrl + url);
		AssertJUnit.assertEquals("Protecci�n - Login", driver.getTitle());
		new Select(driver.findElement(By.name("TipoUsuario"))).selectByVisibleText("Empleado Protecci�n");
		driver.findElement(idNovell).clear();
		driver.findElement(idNovell).sendKeys("lpuerta");
		driver.findElement(name).sendKeys("Proteccion2015");
		driver.findElement(By.name("send")).click();
	}


	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}
