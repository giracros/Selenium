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
		driver.findElement(By.linkText("¿Cómo funciona?")).click();
		driver.findElement(By.linkText("¿Cómo funciona?")).click();
		assertEquals(
				"El ahorro voluntario para construir un ingreso adicional para la jubilación con la contribución de:",
				driver.findElement(By.cssSelector("h3")).getText());
		driver.findElement(By.linkText("¿Cómo ayuda mi aporte?")).click();
		driver.findElement(By.linkText("¿Cómo ayuda mi aporte?")).click();
		assertEquals(
				"Este es un ejemplo de cómo tu aporte puede ayudar a mantener la calidad de vida en el momento de la jubilación para tus empleados.",
				driver.findElement(By.cssSelector("div.text.empContenido > p")).getText());
		assertEquals(
				"Eso es + Protección, es ese poco + que les da tranquilidad a sus vidas y que les permitirá vivir un mejor mañana, es ese + que les cambia el hoy y les da felicidad, es ese + que desde el presente les ayuda a transformar su futuro.",
				driver.findElement(By.xpath("//div[@id='slide5']/div/div/div/div/div/p[2]")).getText());
		driver.findElement(By.linkText("Quiero conocer +")).click();
		driver.findElement(By.linkText("Quiero conocer +")).click();
		assertEquals(
				"Economía envejecida para el año 2034, esto significa que los recursos económicos consumidos por las personas mayores excederán los consumidos por los niños y jóvenes.",
				driver.findElement(By.xpath("//div[@id='paraTifullpage']/div/div/div/div/div/div[2]/ul/li")).getText());
		assertEquals("+ Beneficios para todos", driver
				.findElement(By.xpath("//div[@id='paraTifullpage']/div[2]/div/div/div/div/div/div/h4")).getText());
		assertEquals("Facilidad en tus Aportes", driver
				.findElement(By.xpath("//div[@id='paraTifullpage']/div[3]/div/div/div/div/div/div/h4")).getText());
		driver.findElement(By.linkText("¿Este producto es de Pensión voluntaria?")).click();
		driver.findElement(By.linkText("¿Este producto es de Pensión voluntaria?")).click();
		driver.findElement(
				By.linkText("¿Debo estar afiliado en algún producto de Protección para afiliarme a + Protección?"))
				.click();
		driver.findElement(
				By.linkText("¿Debo estar afiliado en algún producto de Protección para afiliarme a + Protección?"))
				.click();
		driver.findElement(By.linkText("¿Cómo puedo ahorrar en +Protección?")).click();
		driver.findElement(By.linkText("¿Cómo puedo ahorrar en +Protección?")).click();
		driver.findElement(By.linkText("¿Cómo quedará conformado mi ahorro?")).click();
		driver.findElement(By.linkText("¿Cómo quedará conformado mi ahorro?")).click();
		driver.findElement(By.linkText("¿Cuánto debo ahorrar?")).click();
		driver.findElement(By.linkText("¿Cuánto debo ahorrar?")).click();
		driver.findElement(By.linkText("¿Qué pasa si me aumenta el salario?")).click();
		driver.findElement(By.linkText("¿Qué pasa si me aumenta el salario?")).click();
		driver.findElement(
				By.linkText("¿Por qué se debe tener en cuenta la edad, salario y el género para el monto del ahorro?"))
				.click();
		driver.findElement(
				By.linkText("¿Por qué se debe tener en cuenta la edad, salario y el género para el monto del ahorro?"))
				.click();
		driver.findElement(By.linkText("¿Durante cuánto tiempo debo ahorrar?")).click();
		driver.findElement(By.linkText("¿Durante cuánto tiempo debo ahorrar?")).click();
		driver.findElement(
				By.linkText("Si quiero que el ahorro me dure por más tiempo, más de los 85 años ¿Qué puedo hacer?"))
				.click();
		driver.findElement(
				By.linkText("Si quiero que el ahorro me dure por más tiempo, más de los 85 años ¿Qué puedo hacer?"))
				.click();
		driver.findElement(By.linkText(
				"¿Qué pasa con el ingreso adicional en la etapa de jubilación si fallezco? hay un beneficiario?"))
				.click();
		driver.findElement(By.linkText(
				"¿Qué pasa con el ingreso adicional en la etapa de jubilación si fallezco? hay un beneficiario?"))
				.click();
		driver.findElement(By.linkText("¿En qué portafolio estará invertido mi ahorro en +Protección?")).click();
		driver.findElement(By.linkText("¿En qué portafolio estará invertido mi ahorro en +Protección?")).click();
		driver.findElement(By.linkText("¿Qué comisión cobra +Protección?")).click();
		driver.findElement(By.linkText("¿Qué comisión cobra +Protección?")).click();
		driver.findElement(By.linkText("¿Puedo hacer retiros?")).click();
		driver.findElement(By.linkText("¿Puedo hacer retiros?")).click();
		driver.findElement(By.linkText("¿Puedo hacer retiros?")).click();
		driver.findElement(By.linkText("¿Puedo hacer retiros?")).click();
		driver.findElement(By.linkText("Conoce + Protección")).click();
		driver.findElement(By.linkText("Conoce + Protección")).click();
		assertEquals("Empresas", driver.getTitle());
		assertEquals("Empresas", driver.getTitle());
		driver.findElement(By.linkText("Cómo dar +")).click();
		driver.findElement(By.linkText("Cómo dar +")).click();
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
