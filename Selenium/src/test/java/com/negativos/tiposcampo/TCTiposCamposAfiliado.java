package com.negativos.tiposcampo;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TCTiposCamposAfiliado {

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		baseUrl = "https://10.11.230.81:81/";

	}

	@Test
	public void tiposCampoAfiliado() throws Exception {

		loginPortal();

		driver.findElement(By.name("numIdentificacion")).clear();

		driver.findElement(By.name("numIdentificacion")).sendKeys("203928382");

		driver.findElement(By.name("enviar")).click();

		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fechaDebito")));
		driver.findElement(By.id("fechaDebito")).sendKeys("22131232");
		
		
		assertEquals("", driver.getTitle());
		driver.findElement(By.cssSelector("input.center")).click();

		driver.findElement(By.id("habeasData")).click();
		driver.findElement(By.id("controlActivos")).click();
		driver.findElement(By.id("condiciones")).click();

		driver.findElement(By.id("fechaDebito")).clear();
		driver.findElement(By.id("fechaDebito")).sendKeys("1212121212");

		driver.findElement(By.id("fechaNacimiento")).clear();
		driver.findElement(By.id("fechaNacimiento")).sendKeys("1212121212");

		driver.findElement(By.id("fechaAplicacionIncremento")).clear();
		driver.findElement(By.id("fechaAplicacionIncremento")).sendKeys("1212121212");

		driver.findElement(By.id("totalPasivos")).clear();
		driver.findElement(By.id("totalPasivos")).sendKeys("q");

		driver.findElement(By.id("totalActivos")).clear();
		driver.findElement(By.id("totalActivos")).sendKeys("q");

		driver.findElement(By.id("ingresos")).clear();
		driver.findElement(By.id("ingresos")).sendKeys("q");

		driver.findElement(By.id("egresos")).clear();
		driver.findElement(By.id("egresos")).sendKeys("q");

		driver.findElement(By.id("numeroCuenta")).clear();
		driver.findElement(By.id("numeroCuenta")).sendKeys("q");

		driver.findElement(By.id("valorAporte")).clear();
		driver.findElement(By.id("valorAporte")).sendKeys("q");

		driver.findElement(By.id("nit")).clear();
		driver.findElement(By.id("nit")).sendKeys("q");

		driver.findElement(By.id("telefono")).clear();
		driver.findElement(By.id("telefono")).sendKeys("q");

		driver.findElement(By.id("celular")).clear();
		driver.findElement(By.id("celular")).sendKeys("q");

		driver.findElement(By.id("primerApellido")).clear();
		driver.findElement(By.id("primerApellido")).sendKeys("1");

		driver.findElement(By.id("segundoApellido")).clear();
		driver.findElement(By.id("segundoApellido")).sendKeys("1");

		driver.findElement(By.id("primerNombre")).clear();
		driver.findElement(By.id("primerNombre")).sendKeys("1");

		driver.findElement(By.id("segundoNombre")).clear();
		driver.findElement(By.id("segundoNombre")).sendKeys("1");

		assertEquals("Campo alfabético", driver.findElement(By.id("primerApellido-error")).getText());
		assertEquals("Campo alfabético", driver.findElement(By.id("segundoApellido-error")).getText());
		assertEquals("Campo alfabético", driver.findElement(By.id("primerNombre-error")).getText());
		assertEquals("Campo alfabético", driver.findElement(By.id("segundoNombre-error")).getText());
		assertEquals("Valor inválido, máximo 15 caracteres", driver.findElement(By.id("totalPasivos-error")).getText());
		assertEquals("Valor inválido, máximo 15 caracteres", driver.findElement(By.id("totalActivos-error")).getText());
		assertEquals("Fecha inválida", driver.findElement(By.id("fechaDebito-error")).getText());
		assertEquals("Valor inválido, máximo 15 caracteres", driver.findElement(By.id("egresos-error")).getText());
		assertEquals("Valor inválido, máximo 15 caracteres", driver.findElement(By.id("ingresos-error")).getText());
		assertEquals("Campo numérico", driver.findElement(By.id("telefono-error")).getText());
		assertEquals("Campo numérico", driver.findElement(By.id("celular-error")).getText());
		assertEquals("Campo numérico", driver.findElement(By.id("nit-error")).getText());
		assertEquals("Valor inválido, máximo 15 caracteres", driver.findElement(By.id("valorAporte-error")).getText());
		assertEquals("Campo numérico", driver.findElement(By.id("numeroCuenta-error")).getText());
		assertEquals("Fecha inválida", driver.findElement(By.id("fechaNacimiento-error")).getText());

		assertTrue(driver.findElement(By.cssSelector("div.display-error._visible > label")).getText()
				.matches("^exact:Los campos marcados en [\\s\\S]* son obligatorios\\.$"));

		driver.findElement(By.cssSelector("span")).click();

	}

	private void loginPortal() {
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
	public void tearDown() throws Exception {
		driver.quit();
	}
}
