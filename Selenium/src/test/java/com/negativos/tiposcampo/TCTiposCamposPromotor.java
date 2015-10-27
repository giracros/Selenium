package com.negativos.tiposcampo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TCTiposCamposPromotor {

	private WebDriver driver;
	private String baseUrl;
	String campoMaximoCaracteres = "Valor inválido, máximo 15 caracteres";

	By nit = By.id("nit");
	By otraPeriodicidad = By.id("otraPeriodicidad");
	By valorTope = By.id("valorTope");
	By cantidadEmpleadosPrograma = By.id("cantidadEmpleadosPrograma");

	@BeforeMethod
	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://10.11.230.81:81/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void tipoCamposPromotor() throws Exception {

		loginPromotor();

		AssertJUnit.assertEquals("", driver.getTitle());

		driver.findElement(By.cssSelector("a[title=\"Patrocinio de empleados\"] > span")).click();

		AssertJUnit.assertEquals("", driver.getTitle());

		driver.findElement(nit).clear();
		driver.findElement(nit).sendKeys("das");
		driver.findElement(otraPeriodicidad).clear();
		driver.findElement(otraPeriodicidad).sendKeys("21312");
		driver.findElement(valorTope).clear();
		driver.findElement(valorTope).sendKeys("dsasd");
		driver.findElement(cantidadEmpleadosPrograma).clear();
		driver.findElement(cantidadEmpleadosPrograma).sendKeys("dsasd");

		driver.findElement(By.name("enviar")).click();

		AssertJUnit.assertEquals("Campo numérico", driver.findElement(By.id("nit-error")).getText());
		AssertJUnit.assertEquals("Campo requerido", driver.findElement(By.id("razonSocial-error")).getText());
		AssertJUnit.assertEquals("Campo alfabético", driver.findElement(By.id("otraPeriodicidad-error")).getText());
		AssertJUnit.assertEquals("Valor inválido, máximo 15 caracteres",
				driver.findElement(By.id("valorTope-error")).getText());
		AssertJUnit.assertEquals("Campo numérico",
				driver.findElement(By.id("cantidadEmpleadosPrograma-error")).getText());

		driver.findElement(By.id("tipoPatrocinio")).click();

		new Select(driver.findElement(By.id("tipoPatrocinio"))).selectByVisibleText("No interesado");

		driver.findElement(By.cssSelector("option.min-form.no-observation")).click();
		driver.findElement(By.id("tipoPatrocinio")).click();

		new Select(driver.findElement(By.id("tipoPatrocinio"))).selectByVisibleText("Apoyo para motivar el ahorro");
		driver.findElement(By.xpath("//option[@value='APOYOMOTIVARAHORRO']")).click();
		driver.findElement(By.id("tipoPatrocinio")).click();

		new Select(driver.findElement(By.id("tipoPatrocinio"))).selectByVisibleText("Apoyo económico");
		driver.findElement(By.cssSelector("option[value=\"APOYOECONOMICO\"]")).click();
		driver.findElement(By.id("periodicidad")).click();

		new Select(driver.findElement(By.id("periodicidad"))).selectByVisibleText("Mensual");
		driver.findElement(By.xpath("//option[@value='MENSUAL']")).click();
		driver.findElement(By.id("valorTope")).clear();
		driver.findElement(By.id("valorTope")).sendKeys("fds");
		driver.findElement(By.id("periodicidad")).click();
		driver.findElement(By.name("enviar")).click();

		AssertJUnit.assertEquals(campoMaximoCaracteres, driver.findElement(By.id("valorTope-error")).getText());

		driver.findElement(By.id("tipoAporte")).click();

		new Select(driver.findElement(By.id("tipoAporte"))).selectByVisibleText("*Aporte según ahorro empleado (%)");

		driver.findElement(By.cssSelector("option.min-form.fieldAporte")).click();
		driver.findElement(By.id("aporteAhorroEmpleado")).clear();
		driver.findElement(By.id("aporteAhorroEmpleado")).sendKeys("fsdf");
		driver.findElement(By.id("tipoAporte")).click();
		driver.findElement(By.name("enviar")).click();

		new Select(driver.findElement(By.id("tipoAporte"))).selectByVisibleText("*Aporte fijo empleado ($)");

		driver.findElement(By.xpath("//option[@value='aporteFijoEmpleado']")).click();
		driver.findElement(By.id("aporteFijoEmpleado")).clear();
		driver.findElement(By.id("aporteFijoEmpleado")).sendKeys("fddsdf");
		driver.findElement(By.name("enviar")).click();
		driver.findElement(By.cssSelector("span")).click();

		AssertJUnit.assertEquals("", driver.getTitle());
	}

	private void loginPromotor() {
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
	}
}
