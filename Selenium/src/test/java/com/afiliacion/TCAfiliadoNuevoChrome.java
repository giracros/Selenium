package com.afiliacion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TCAfiliadoNuevoChrome {

	private WebDriver driver;
	private String baseUrl;

	/*
	 * Los xPath
	 */
	By mujer = By.cssSelector("div.campo.border > div.campo.width50 > label");
	By hombre = By.xpath("//form[@id='vinculacionMasProteccion']/div[2]/div[3]/div/div[2]/label");
	By habeasData1 = By.xpath("//form[@id='vinculacionMasProteccion']/div[11]/div[3]/label");
	By habeasData2 = By.xpath("//form[@id='vinculacionMasProteccion']/div[9]/div[2]/label");
	By habeasData3 = By.cssSelector("div.campo.aceptacion > label");
	By registrarAfiliado = By.xpath("/html/body/div[1]/div[3]/form/div[13]/input");

	/*
	 * Los Id`s
	 * 
	 */
	By fechaExpedicion = By.id("fechaExpedicion");
	By primerApellido = By.id("primerApellido");
	By segundoApellido = By.id("segundoApellido");
	By primerNombre = By.id("primerNombre");

	@BeforeTest
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		baseUrl = "https://10.11.230.81:81/";
	}

	@Test
	public void tcAfiliadoNuevo() throws Exception {

		loginPortal();
		Thread.sleep(30000);
		driver.findElement(By.name("numIdentificacion")).clear();
		driver.findElement(By.name("numIdentificacion")).sendKeys("1324354658");
		driver.findElement(By.name("enviar")).click();

		// Timeout que espera 30seg a que cargue el servicio de Departamentos
		Thread.sleep(60000);
		new Select(driver.findElement(By.id("departamentoExpedicion"))).selectByVisibleText("ANTIOQUIA");
		Thread.sleep(10000);
		new Select(driver.findElement(By.id("ciudadExpedicion"))).selectByVisibleText("ANGOSTURA");

		driver.findElement(fechaExpedicion).clear();
		driver.findElement(fechaExpedicion).sendKeys("01/01/2005");

		driver.findElement(primerApellido).clear();
		driver.findElement(primerApellido).sendKeys("DeLasCasas");
		driver.findElement(segundoApellido).clear();
		driver.findElement(segundoApellido).sendKeys("Hernandez");
		driver.findElement(primerNombre).clear();
		driver.findElement(primerNombre).sendKeys("Lina");

		driver.findElement(By.id("segundoNombre")).clear();
		driver.findElement(By.id("segundoNombre")).sendKeys("Marcela");
		driver.findElement(By.id("fechaNacimiento")).clear();
		driver.findElement(By.id("fechaNacimiento")).sendKeys("01/01/1985");
		driver.findElement(mujer).click();
		driver.findElement(hombre).click();

		new Select(driver.findElement(By.id("nacionalidad"))).selectByVisibleText("COLOMBIA");

		driver.findElement(By.id("ingresos")).clear();
		driver.findElement(By.id("ingresos")).sendKeys("2800000");
		driver.findElement(By.id("egresos")).clear();
		driver.findElement(By.id("egresos")).sendKeys("1200000");
		driver.findElement(By.id("totalActivos")).clear();
		driver.findElement(By.id("totalActivos")).sendKeys("10000");
		driver.findElement(By.id("totalPasivos")).clear();
		driver.findElement(By.id("totalPasivos")).sendKeys("5000");
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
		driver.findElement(By.name("dirResidencia")).click();

		new Select(driver.findElement(By.name("via"))).selectByVisibleText("Carretera");

		driver.findElement(By.name("numVia")).clear();
		driver.findElement(By.name("numVia")).sendKeys("23");
		driver.findElement(By.name("inter")).clear();
		driver.findElement(By.name("inter")).sendKeys("43");
		driver.findElement(By.id("numero")).clear();
		driver.findElement(By.id("numero")).sendKeys("45");
		driver.findElement(By.linkText("Aceptar")).click();

		new Select(driver.findElement(By.id("entidadFinanciera"))).selectByVisibleText("BANCOLOMBIA");

		driver.findElement(By.id("numeroCuenta")).clear();
		driver.findElement(By.id("numeroCuenta")).sendKeys("57493759837");

		new Select(driver.findElement(By.id("departamentoNacimiento"))).selectByVisibleText("CUNDINAMARCA");

		Thread.sleep(3000);
		new Select(driver.findElement(By.id("departamentoResidencia"))).selectByVisibleText("HUILA");
		Thread.sleep(3000);
		new Select(driver.findElement(By.id("ciudadResidencia"))).selectByVisibleText("IQUIRA");
		Thread.sleep(3000);
		new Select(driver.findElement(By.name("ciudadNacimiento"))).selectByVisibleText("CAPELLANÍA");
		driver.findElement(habeasData1).click();
		driver.findElement(habeasData2).click();
		driver.findElement(habeasData3).click();
		driver.findElement(registrarAfiliado).click();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("input.center")).click();
		Thread.sleep(10000);
		driver.findElement(By.linkText("Cerrar")).click();

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

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}
