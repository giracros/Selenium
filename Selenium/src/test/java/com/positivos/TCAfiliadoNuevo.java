package com.positivos;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TCAfiliadoNuevo {
	private WebDriver driver;
	private String baseUrl;

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://10.11.230.81:81/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void tcAfiliadoNuevo() throws Exception {

		driver.findElement(By.name("numIdentificacion")).clear();
		driver.findElement(By.name("numIdentificacion")).sendKeys("3948983");
		driver.findElement(By.name("enviar")).click();
		driver.findElement(By.id("primerApellido")).clear();
		driver.findElement(By.id("primerApellido")).sendKeys("Rico");
		driver.findElement(By.id("segundoApellido")).clear();
		driver.findElement(By.id("segundoApellido")).sendKeys("Herrera");
		driver.findElement(By.id("primerNombre")).clear();
		driver.findElement(By.id("primerNombre")).sendKeys("Martin");
		driver.findElement(By.id("segundoNombre")).clear();
		driver.findElement(By.id("segundoNombre")).sendKeys("Elias");
		driver.findElement(By.id("fechaNacimiento")).clear();
		driver.findElement(By.id("fechaNacimiento")).sendKeys("01/01/1985");
		new Select(driver.findElement(By.id("nacionalidad"))).selectByVisibleText("COLOMBIA");
		driver.findElement(By.id("sexoM")).click();
		driver.findElement(By.xpath("//form[@id='vinculacionMasProteccion']/div[2]/div[3]/div/div[2]/label")).click();
	    driver.findElement(By.name("dirResidencia")).click();
	    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Diagonal");
	   driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("eduwin.fuentes@outlook.com");
		driver.findElement(By.id("telefono")).clear();
		driver.findElement(By.id("telefono")).sendKeys("3948759");
		driver.findElement(By.id("celular")).clear();
		driver.findElement(By.id("celular")).sendKeys("2347293874");
		driver.findElement(By.id("nit")).clear();
		driver.findElement(By.id("nit")).sendKeys("800248194");
		driver.findElement(By.id("valorAporte")).clear();
		driver.findElement(By.id("valorAporte")).sendKeys("50000");
		new Select(driver.findElement(By.id("entidadFinanciera"))).selectByVisibleText("BANCOLOMBIA");
		driver.findElement(By.id("numeroCuenta")).clear();
		driver.findElement(By.id("numeroCuenta")).sendKeys("57493759837");
		driver.findElement(By.id("ingresos")).clear();
		driver.findElement(By.id("ingresos")).sendKeys("2800000");
		driver.findElement(By.id("egresos")).clear();
		driver.findElement(By.id("egresos")).sendKeys("1200000");
		driver.findElement(By.id("totalActivos")).clear();
		driver.findElement(By.id("totalActivos")).sendKeys("10000");
		driver.findElement(By.id("totalPasivos")).clear();
		driver.findElement(By.id("totalPasivos")).sendKeys("5000");
		driver.findElement(By.id("condiciones")).click();
		driver.findElement(By.id("controlActivos")).click();
		driver.findElement(By.id("habeasData")).click();
		driver.findElement(By.name("dirResidencia")).click();

		new Select(driver.findElement(By.name("via"))).selectByVisibleText("Carretera");

		driver.findElement(By.name("numVia")).clear();
		driver.findElement(By.name("numVia")).sendKeys("23");
		driver.findElement(By.name("inter")).clear();
		driver.findElement(By.name("inter")).sendKeys("43");
		driver.findElement(By.id("numero")).clear();
		driver.findElement(By.id("numero")).sendKeys("45");
		driver.findElement(By.linkText("Aceptar")).click();

		new Select(driver.findElement(By.id("departamentoExpedicion"))).selectByVisibleText("ANTIOQUIA");
		new Select(driver.findElement(By.id("departamentoNacimiento"))).selectByVisibleText("CUNDINAMARCA");
		new Select(driver.findElement(By.id("departamentoResidencia"))).selectByVisibleText("HUILA");
		new Select(driver.findElement(By.id("ciudadResidencia"))).selectByVisibleText("IQUIRA");
		new Select(driver.findElement(By.name("ciudadNacimiento"))).selectByVisibleText("CAPELLANÍA");
		new Select(driver.findElement(By.id("ciudadExpedicion"))).selectByVisibleText("ANGOSTURA");

		driver.findElement(By.id("fechaExpedicion")).clear();
		driver.findElement(By.id("fechaExpedicion")).sendKeys("01/01/2005");

		driver.findElement(By.cssSelector("div.divVinculacion")).click();

		driver.findElement(By.cssSelector("input.center")).click();
		
		assertEquals(
				"La solicitud de vinculación fue registrada exitosamente en AFPCore con el código 510226 , felicitaciones por tu nuevo producto.",
				driver.findElement(By.cssSelector("div.result-susc > span")).getText());

		driver.findElement(By.linkText("Cerrar")).click();

	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
		System.exit(0);

	}
}
