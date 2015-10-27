package com.portal;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Empresa {
	private WebDriver driver;
	private String baseUrl;

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://10.11.230.3/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testEmpresa() throws Exception {
		driver.get(baseUrl + "/wps/portal/proteccion/masproteccion/home/");
		assertEquals("Home", driver.getTitle());
		driver.findElement(By.linkText("Soy Empresa")).click();
		driver.findElement(By.linkText("Soy Empresa")).click();
		assertEquals("Empresas", driver.getTitle());
		assertEquals("Empresas", driver.getTitle());
		driver.findElement(By.linkText("�C�mo funciona?")).click();
		driver.findElement(By.linkText("�C�mo funciona?")).click();
		assertEquals(
				"El ahorro voluntario para construir un ingreso adicional para la jubilaci�n con la contribuci�n de:",
				driver.findElement(By.cssSelector("h3")).getText());
		driver.findElement(By.linkText("�C�mo ayuda mi aporte?")).click();
		driver.findElement(By.linkText("�C�mo ayuda mi aporte?")).click();
		assertEquals(
				"Este es un ejemplo de c�mo tu aporte puede ayudar a mantener la calidad de vida en el momento de la jubilaci�n para tus empleados.",
				driver.findElement(By.cssSelector("div.text.empContenido > p")).getText());
		assertEquals(
				"Eso es + Protecci�n, es ese poco + que les da tranquilidad a sus vidas y que les permitir� vivir un mejor ma�ana, es ese + que les cambia el hoy y les da felicidad, es ese + que desde el presente les ayuda a transformar su futuro.",
				driver.findElement(By.xpath("//div[@id='slide5']/div/div/div/div/div/p[2]")).getText());
		driver.findElement(By.linkText("Quiero conocer +")).click();
		driver.findElement(By.linkText("Quiero conocer +")).click();
		assertEquals(
				"Econom�a envejecida para el a�o 2034, esto significa que los recursos econ�micos consumidos por las personas mayores exceder�n los consumidos por los ni�os y j�venes.",
				driver.findElement(By.xpath("//div[@id='paraTifullpage']/div/div/div/div/div/div[2]/ul/li")).getText());
		assertEquals("+ Beneficios para todos", driver
				.findElement(By.xpath("//div[@id='paraTifullpage']/div[2]/div/div/div/div/div/div/h4")).getText());
		assertEquals("Facilidad en tus Aportes", driver
				.findElement(By.xpath("//div[@id='paraTifullpage']/div[3]/div/div/div/div/div/div/h4")).getText());
		driver.findElement(By.linkText("�Este producto es de Pensi�n voluntaria?")).click();
		driver.findElement(By.linkText("�Este producto es de Pensi�n voluntaria?")).click();
		driver.findElement(
				By.linkText("�Debo estar afiliado en alg�n producto de Protecci�n para afiliarme a + Protecci�n?"))
				.click();
		driver.findElement(
				By.linkText("�Debo estar afiliado en alg�n producto de Protecci�n para afiliarme a + Protecci�n?"))
				.click();
		driver.findElement(By.linkText("�C�mo puedo ahorrar en +Protecci�n?")).click();
		driver.findElement(By.linkText("�C�mo puedo ahorrar en +Protecci�n?")).click();
		driver.findElement(By.linkText("�C�mo quedar� conformado mi ahorro?")).click();
		driver.findElement(By.linkText("�C�mo quedar� conformado mi ahorro?")).click();
		driver.findElement(By.linkText("�Cu�nto debo ahorrar?")).click();
		driver.findElement(By.linkText("�Cu�nto debo ahorrar?")).click();
		driver.findElement(By.linkText("�Qu� pasa si me aumenta el salario?")).click();
		driver.findElement(By.linkText("�Qu� pasa si me aumenta el salario?")).click();
		driver.findElement(
				By.linkText("�Por qu� se debe tener en cuenta la edad, salario y el g�nero para el monto del ahorro?"))
				.click();
		driver.findElement(
				By.linkText("�Por qu� se debe tener en cuenta la edad, salario y el g�nero para el monto del ahorro?"))
				.click();
		driver.findElement(By.linkText("�Durante cu�nto tiempo debo ahorrar?")).click();
		driver.findElement(By.linkText("�Durante cu�nto tiempo debo ahorrar?")).click();
		driver.findElement(
				By.linkText("Si quiero que el ahorro me dure por m�s tiempo, m�s de los 85 a�os �Qu� puedo hacer?"))
				.click();
		driver.findElement(
				By.linkText("Si quiero que el ahorro me dure por m�s tiempo, m�s de los 85 a�os �Qu� puedo hacer?"))
				.click();
		driver.findElement(By.linkText(
				"�Qu� pasa con el ingreso adicional en la etapa de jubilaci�n si fallezco? hay un beneficiario?"))
				.click();
		driver.findElement(By.linkText(
				"�Qu� pasa con el ingreso adicional en la etapa de jubilaci�n si fallezco? hay un beneficiario?"))
				.click();
		driver.findElement(By.linkText("�En qu� portafolio estar� invertido mi ahorro en +Protecci�n?")).click();
		driver.findElement(By.linkText("�En qu� portafolio estar� invertido mi ahorro en +Protecci�n?")).click();
		driver.findElement(By.linkText("�Qu� comisi�n cobra +Protecci�n?")).click();
		driver.findElement(By.linkText("�Qu� comisi�n cobra +Protecci�n?")).click();
		driver.findElement(By.linkText("�Puedo hacer retiros?")).click();
		driver.findElement(By.linkText("�Puedo hacer retiros?")).click();
		driver.findElement(By.linkText("�Puedo hacer retiros?")).click();
		driver.findElement(By.linkText("�Puedo hacer retiros?")).click();
		driver.findElement(By.linkText("Conoce + Protecci�n")).click();
		driver.findElement(By.linkText("Conoce + Protecci�n")).click();
		assertEquals("Empresas", driver.getTitle());
		assertEquals("Empresas", driver.getTitle());
		driver.findElement(By.linkText("C�mo dar +")).click();
		driver.findElement(By.linkText("C�mo dar +")).click();
		driver.findElement(By.linkText("+ Para ti")).click();
		driver.findElement(By.linkText("+ Para ti")).click();
		driver.findElement(By.linkText("+ Ayuda")).click();
		driver.findElement(By.linkText("+ Ayuda")).click();
		driver.findElement(By.cssSelector("img.img-responsive.center-block")).click();
		driver.findElement(By.cssSelector("img.img-responsive.center-block")).click();
		assertEquals("Home", driver.getTitle());
		assertEquals("Home", driver.getTitle());
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();

	}

}
