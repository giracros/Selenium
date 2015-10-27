package com.positivos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TCAfiliadoProceso {

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

	@Test(priority = 0)
	public void tcAfiliadoEnProceso() throws Exception {
		loginPortal();
		WebElement numIdentificacion = driver.findElement(By.name("numIdentificacion"));
		numIdentificacion.clear();
		numIdentificacion.sendKeys("42893634");
		WebElement btnEnviar = driver.findElement(By.name("enviar"));
		btnEnviar.click();
		WebElement msjNotificacion = driver.findElement(By.cssSelector("td.conTextError"));
		String msjNotificacionText = "Mensaje: Afiliado tiene otra solicitud en proceso";
		try {
			AssertJUnit.assertEquals(msjNotificacionText, msjNotificacion.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		WebElement btnCerrarNotificacion = driver.findElement(By.linkText("Cerrar"));
		btnCerrarNotificacion.click();
		WebElement btnCerrar = driver.findElement(By.cssSelector("span"));
		btnCerrar.click();
	}

	@Test(priority = 1)
	public void tcAfiliadoConProducto() throws Exception {
		loginPortal();
		WebElement numIdentificacion = driver.findElement(By.name("numIdentificacion"));
		numIdentificacion.clear();
		numIdentificacion.sendKeys("1018436098");
		WebElement btnEnviar = driver.findElement(By.name("enviar"));
		btnEnviar.click();
		WebElement msjNotificacion1 = driver.findElement(By.cssSelector("td.conTextError"));
		String msjNotificacionText = "Mensaje:	NEGOCIO: Afiliado tiene solicitud de vinculación en estado finalizado para el mismo producto";
		try {
			Assert.assertEquals(msjNotificacionText, msjNotificacion1.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		WebElement btnCerrarNotificacion = driver.findElement(By.linkText("Cerrar"));
		btnCerrarNotificacion.click();
		WebElement btnCerrar = driver.findElement(By.cssSelector("span"));
		btnCerrar.click();
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
		System.exit(0);
	}
}
