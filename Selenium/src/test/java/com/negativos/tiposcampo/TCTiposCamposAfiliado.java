package com.negativos.tiposcampo;

import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TCTiposCamposAfiliado {
	
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	By numIdentificacion = By.name("numIdentificacion");
	By fechaExpedicion = By.id("fechaExpedicion");
	By primerApellido = By.id("primerApellido");
	By segundoApellido = By.id("segundoApellido");
	By primerNombre = By.id("primerNombre");
	By segundoNombre = By.id("segundoNombre");
	By dirResidencia = By.name("dirResidencia");

	@BeforeTest
	public void setUp() throws Exception {

		driver = new FirefoxDriver();
		baseUrl = "https://10.11.230.81:81/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testPantalla1() throws Exception {

		loginPortal();
		
		assertEquals("", driver.getTitle());

		driver.findElement(numIdentificacion).clear();
		driver.findElement(numIdentificacion).sendKeys("83749587394");

		driver.findElement(By.name("enviar")).click();
		assertEquals("", driver.getTitle());

		driver.findElement(fechaExpedicion).clear();
		driver.findElement(fechaExpedicion).sendKeys("22012015");
		driver.findElement(primerApellido).clear();
		driver.findElement(primerApellido).sendKeys("123");
		driver.findElement(segundoApellido).clear();
		driver.findElement(segundoApellido).sendKeys("321");
		driver.findElement(primerNombre).clear();
		driver.findElement(primerNombre).sendKeys("123");
		driver.findElement(segundoNombre).clear();
		driver.findElement(segundoNombre).sendKeys("321");
		driver.findElement(dirResidencia).click();

		new Select(driver.findElement(By.name("via"))).selectByVisibleText("Avenida");

		driver.findElement(By.name("numVia")).clear();
		driver.findElement(By.name("numVia")).sendKeys("a");
		driver.findElement(By.name("inter")).clear();
		driver.findElement(By.name("inter")).sendKeys("d");
		driver.findElement(By.id("numero")).clear();
		driver.findElement(By.id("numero")).sendKeys("a");
		driver.findElement(By.id("dirComplemento")).clear();
		driver.findElement(By.id("dirComplemento")).sendKeys("a");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("a");
		driver.findElement(By.id("telefono")).clear();
		driver.findElement(By.id("telefono")).sendKeys("a");
		driver.findElement(By.id("celular")).clear();
		driver.findElement(By.id("celular")).sendKeys("a");
		driver.findElement(By.id("nit")).clear();
		driver.findElement(By.id("nit")).sendKeys("as");
		driver.findElement(By.id("valorAporte")).clear();
		driver.findElement(By.id("valorAporte")).sendKeys("sa");
		driver.findElement(By.id("numeroCuenta")).clear();
		driver.findElement(By.id("numeroCuenta")).sendKeys("as");
		driver.findElement(By.id("ingresos")).clear();
		driver.findElement(By.id("ingresos")).sendKeys("as");
		driver.findElement(By.id("egresos")).clear();
		driver.findElement(By.id("egresos")).sendKeys("as");
		driver.findElement(By.id("totalActivos")).clear();
		driver.findElement(By.id("totalActivos")).sendKeys("s");
		driver.findElement(By.id("totalPasivos")).clear();
		driver.findElement(By.id("totalPasivos")).sendKeys("s");
		driver.findElement(By.cssSelector("input.center")).click();
		
		assertEquals("Fecha inválida", driver.findElement(By.id("fechaExpedicion-error")).getText());
		assertEquals("Campo alfabético", driver.findElement(By.id("primerApellido-error")).getText());
		assertEquals("Campo alfabético", driver.findElement(By.id("segundoApellido-error")).getText());
		
		try {
			assertEquals("Campo alfabético", driver.findElement(By.id("primerNombre-error")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertEquals("Campo alfabético", driver.findElement(By.id("primerNombre-error")).getText());
		assertEquals("Campo alfabético", driver.findElement(By.id("segundoNombre-error")).getText());
		
		assertTrue(driver.findElement(By.id("numVia-error")).getText().matches("^exact:[\\s\\S]*Número de vía$"));
		assertTrue(driver.findElement(By.id("inter-error")).getText().matches("^exact:[\\s\\S]*Inter$"));
		assertTrue(driver.findElement(By.id("numero-error")).getText().matches("^exact:[\\s\\S]*Número$"));
		
		assertEquals("Correo inválido", driver.findElement(By.id("email-error")).getText());
		
		assertEquals("Campo numérico", driver.findElement(By.id("telefono-error")).getText());
		assertEquals("Campo numérico", driver.findElement(By.id("celular-error")).getText());
		assertEquals("Campo numérico", driver.findElement(By.id("nit-error")).getText());
		
		driver.findElement(By.id("valorAporte")).clear();
		driver.findElement(By.id("valorAporte")).sendKeys("as");
		
		assertEquals("Valor inválido, máximo 15 caracteres", driver.findElement(By.id("valorAporte-error")).getText());
		
		driver.findElement(By.id("valorAporte")).clear();
		driver.findElement(By.id("valorAporte")).sendKeys("aaaasdweddferwa");
		
		assertEquals("Campo numérico", driver.findElement(By.id("numeroCuenta-error")).getText());
		
		assertEquals("Valor inválido, máximo 15 caracteres", driver.findElement(By.id("ingresos-error")).getText());
		assertEquals("Valor inválido, máximo 15 caracteres", driver.findElement(By.id("egresos-error")).getText());
		assertEquals("Valor inválido, máximo 15 caracteres", driver.findElement(By.id("totalActivos-error")).getText());
		assertEquals("Valor inválido, máximo 15 caracteres", driver.findElement(By.id("totalPasivos-error")).getText());
		
		driver.findElement(By.cssSelector("span")).click();
		
		assertEquals("", driver.getTitle());
	}

	private void loginPortal() {
		By idNovell = By.name("IdNovell");
		By name = By.name("Clave");
		String url = "/AutenticadorWEB/Autenticacion.jsp?cGFyYW1z=RUUgvh5-hG0lTPgl3AxJR9CVi4MmnLXXUgX5JEDKHpI8rPbU6fugBI6cKeYKrPsusqo8B4ngcWYH6rPQeJbLa4qxZmnDywcBAyKUIZH3wDsOPj6AUqoA4bAA9iLzq8eKijCEySGMz9L-Fe_u8ypORQ2";
		driver.get(baseUrl+ url);
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
