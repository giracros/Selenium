package com.negativos.tiposcampo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TCTiposCamposAfiliado {

	private WebDriver driver;
	private String baseUrl;

	By habeasData1 = By.xpath("//form[@id='vinculacionMasProteccion']/div[11]/div[3]/label");
	By habeasData2 = By.xpath("//form[@id='vinculacionMasProteccion']/div[9]/div[2]/label");
	By habeasData3 = By.cssSelector("div.campo.aceptacion > label");
	By registrarAfiliado = By.xpath("/html/body/div[1]/div[3]/form/div[13]/input");

	String campoObligatorio = "Campo alfabético";

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		baseUrl = "https://10.11.230.81:81/";
	}

	@Test
	public void tiposCampoAfiliado() throws Exception {

		loginPortal();

		Thread.sleep(3000);

		driver.findElement(By.name("numIdentificacion")).clear();

		driver.findElement(By.name("numIdentificacion")).sendKeys("131323454");

		driver.findElement(By.name("enviar")).click();

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

		driver.findElement(habeasData1).click();
		driver.findElement(habeasData2).click();
		driver.findElement(habeasData3).click();

		driver.findElement(registrarAfiliado).click();

		Assert.assertEquals(campoObligatorio, driver.findElement(By.id("primerApellido-error")).getText());

		Assert.assertEquals(campoObligatorio, driver.findElement(By.id("segundoApellido-error")).getText());

		Assert.assertEquals(campoObligatorio, driver.findElement(By.id("primerNombre-error")).getText());

		Assert.assertEquals(campoObligatorio, driver.findElement(By.id("segundoNombre-error")).getText());

		Assert.assertEquals("Valor inválido, máximo 15 caracteres",
				driver.findElement(By.id("totalPasivos-error")).getText());

		Assert.assertEquals("Valor inválido, máximo 15 caracteres",
				driver.findElement(By.id("totalActivos-error")).getText());

		Assert.assertEquals("Valor inválido, máximo 15 caracteres",
				driver.findElement(By.id("egresos-error")).getText());

		Assert.assertEquals("Valor inválido, máximo 15 caracteres",
				driver.findElement(By.id("ingresos-error")).getText());

		Assert.assertEquals("Campo numérico", driver.findElement(By.id("telefono-error")).getText());

		Assert.assertEquals("Campo numérico", driver.findElement(By.id("celular-error")).getText());

		Assert.assertEquals("Campo numérico", driver.findElement(By.id("nit-error")).getText());

		Assert.assertEquals("Valor inválido, máximo 15 caracteres",
				driver.findElement(By.id("valorAporte-error")).getText());

		Assert.assertEquals("Campo numérico", driver.findElement(By.id("numeroCuenta-error")).getText());

		Assert.assertEquals("Fecha inválida", driver.findElement(By.id("fechaNacimiento-error")).getText());

		Assert.assertEquals("Fecha inválida", driver.findElement(By.id("fechaDebito-error")).getText());

		Thread.sleep(3000);
	}

	private void loginPortal() {
		By idNovell = By.name("IdNovell");
		By name = By.name("Clave");
		String url = "/AutenticadorWEB/Autenticacion.jsp?cGFyYW1z=RUUgvh5-hG0lTPgl3AxJR9CVi4MmnLXXUgX5JEDKHpI8rPbU6fugBI6cKeYKrPsusqo8B4ngcWYH6rPQeJbLa4qxZmnDywcBAyKUIZH3wDsOPj6AUqoA4bAA9iLzq8eKijCEySGMz9L-Fe_u8ypORQ2";
		driver.get(baseUrl + url);
		Assert.assertEquals("Protección - Login", driver.getTitle());
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
