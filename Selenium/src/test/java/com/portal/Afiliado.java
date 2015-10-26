package com.portal;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Afiliado {
	private WebDriver driver;
	private String baseUrl;

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://10.11.230.3/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testSoyPersonaJ() throws Exception {

		driver.get(baseUrl + "/wps/portal/proteccion/masproteccion/home");
		assertEquals("Home", driver.getTitle());

		driver.findElement(By.linkText("Soy Persona")).click();

		assertEquals("Afiliado", driver.getTitle());

		assertEquals("Porque s�lo un poco hoy, puede hacer una gran diferencia ma�ana.",
				driver.findElement(By
						.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div[1]/div/div/section/div[2]/div[2]/div[1]/div/div[1]/div/div/div[1]/div/div/div/div/p[2]/span"))
				.getText());

		driver.findElement(By.linkText("Quiero conocer +")).click();

		driver.findElement(By.linkText("�Para qu� sirve + Protecci�n?")).click();

		assertEquals("Para construir y recibir m�s ingreso en tu etapa de jubilaci�n.",
				driver.findElement(By.id("preguntas-dudas-respuesta")).getText());

		driver.findElement(By.linkText("�C�mo hacerlo?")).click();

		assertEquals(
				"Es muy f�cil, vinc�late al producto en pocos pasos y autoriza el d�bito autom�tico mensual a tu cuenta de ahorros. No tienes que ser cliente actual de Protecci�n para hacerlo. Recuerda que siempre puedes dar m�s, por eso en cualquier momento puedes hacer aportes extraordinarios.",

				driver.findElement(By.id("preguntas-dudas-respuesta")).getText());

		driver.findElement(By.linkText("�Cu�nto debo ahorrar?")).click();
		assertEquals(
				"Puedes ahorrar desde $25.000 mensuales que se incrementaran cada a�o en IPC+3%. Te sugerimos tu ahorro ideal, seg�n tu edad, salario y g�nero.",
				driver.findElement(By.id("preguntas-dudas-respuesta")).getText());

		driver.findElement(By.linkText("�Durante cu�nto tiempo debo ahorrar?")).click();
		assertEquals(
				"Puedes ahorrar el tiempo que quieras. Para alcanzar el ingreso adicional, te sugerimos hacerlo desde este mismo momento y hasta que cumplas 62 a�os, si eres hombre y 57 a�os si eres mujer.",
				driver.findElement(By.id("preguntas-dudas-respuesta")).getText());

		driver.findElement(By.linkText("�Qu� es el beneficio +Protecci�n?")).click();
		assertTrue(driver.findElement(By.id("preguntas-dudas-respuesta")).getText().matches(
				"^exact:Proteccion quiere aportar a esa construcci�n de tu futuro, por eso quiere motivarte a que seas constante y no realices ning�n retiro durante la etapa de ahorro\\. Como incentivo a tu buen comportamiento Proteccion devolver� hasta el 60% de la comisi�n cobrada asi: Cada a�o obtendr�s un beneficio anual con una devoluci�n del 40% esta y cada 5 a�os un beneficio extra con una devoluci�n del 20% de la comisi�n cobrada durante este tiempo\\. Con esto obtendr�s aumentar tu ahorro, obtener un mayor ingreso en el futuro para mantener tu calidad de vida\\. [\\s\\S]*La comisi�n cobrada por Protecci�n ser� del 2\\.5% anual liquidado diariamente sobre el saldo acumulado en tu cuenta\\.$"));
		driver.findElement(By.linkText("�C�mo disfruto mi ahorro?")).click();
		assertEquals(
				"Lo puedes disfrutar como un pago mensual, una suma �nica a partir de los 62 a�os si eres hombre o 57 a�os si eres mujer, complementando as� tu mesada pensional hasta los 85 a�os.",
				driver.findElement(By.id("preguntas-dudas-respuesta")).getText());
		driver.findElement(By.linkText("Volver")).click();
		driver.findElement(By.linkText("+ Para ti")).click();
		assertEquals("Afiliado", driver.getTitle());
		assertEquals(
				"Eso es +Protecci�n, es ese poco + que les da tranquilidad a sus vidas y que les permitir� vivir un mejor ma�ana, es ese + que les cambia el hoy y les da felicidad, es ese + que desde el presente les ayuda a transformar su futuro.",
				driver.findElement(By.xpath("//div[@id='slide3']/div/div/div/div/div/div/div/p[2]")).getText());
		driver.findElement(By.xpath("(//a[contains(text(),'Quiero conocer +')])[2]")).click();
		assertEquals("Siempre que puedas ahorra +", driver
				.findElement(By.xpath("//div[@id='slide4']/div/div/div/div/div/div/div/div/div/div/h3")).getText());
		driver.findElement(By.cssSelector("div.text > a.more.back-slide")).click();
		driver.findElement(By.linkText("+ Ayuda")).click();
		driver.findElement(By.linkText("�Este producto es de Pensi�n voluntaria?")).click();
		assertEquals(
				"Si.  +Proteccion hace parte del fondo de Pensiones Voluntarias, lo que implica los mismos beneficios que obtienes hoy en este producto m�s los beneficios adicionales de +Protecci�n.",
				driver.findElement(By.xpath("//div[@id='collapse1']/div/p[2]")).getText());
		driver.findElement(
				By.linkText("�Debo estar afiliado en alg�n producto de Protecci�n para afiliarme a + Protecci�n?"))
				.click();
		assertEquals("No.  No tienes que ser cliente actual para protecci�n para vincularte a +Protecci�n",
				driver.findElement(By.xpath("//div[@id='collapse2']/div/p[2]")).getText());
		driver.findElement(By.linkText("�C�mo puedo ahorrar en +Protecci�n?")).click();
		assertEquals(
				"Es muy f�cil,  vinc�late al producto en pocos pasos y autoriza el d�bito autom�tico mensual a tu cuenta de ahorros.  No tienes que ser cliente actual de Protecci�n para hacerlo.",
				driver.findElement(By.xpath("//div[@id='collapse3']/div/p[2]")).getText());
		driver.findElement(By.linkText("�C�mo quedar� conformado mi ahorro?")).click();
		assertEquals(
				"En tu ahorro +Protecci�n, tendr�s 3 cuentas. Aqu� estar�n los aportes que t� haces, el reconocimiento que te da +Protecci�n como premio al buen comportamiento con tu ahorro y el aporte que podr� hacerte un tercero.",
				driver.findElement(By.xpath("//div[@id='collapse4']/div/p[2]")).getText());
		driver.findElement(By.xpath("(//a[contains(text(),'�Cu�nto debo ahorrar?')])[2]")).click();
		assertEquals(
				"Puedes ahorrar desde $25.000 mensuales que se incrementaran cada a�o en IPC+3%. Te sugerimos tu ahorro ideal, seg�n tu edad, salario y g�nero.",
				driver.findElement(By.xpath("//div[@id='collapse5']/div/p[2]")).getText());
		driver.findElement(By.linkText("�Qu� pasa si me aumenta el salario?")).click();
		assertEquals("Debes calcular de nuevo el monto sugerido a ahorrar en el simulador",
				driver.findElement(By.linkText("Debes calcular de nuevo el monto sugerido a ahorrar en el simulador"))
						.getText());
		driver.findElement(
				By.linkText("�Por qu� se debe tener en cuenta la edad, salario y el g�nero para el monto del ahorro?"))
				.click();
		assertEquals(
				"Porque +Proteccion busca complementar el ingreso por pensi�n en un % que te permita mantener tu calidad de vida en el futuro.  Para esto debemos tener en cuenta tu g�nero y as� saber a qu� edad te pensionas, tu edad para saber cu�nto tiempo tienes para ahorrar y tu salario para calcular el beneficio futuro adecuado seg�n tu ingreso.",
				driver.findElement(By.xpath("//div[@id='collapse7']/div/p[2]")).getText());
		driver.findElement(By.xpath("(//a[contains(text(),'�Durante cu�nto tiempo debo ahorrar?')])[2]")).click();
		assertEquals(
				"Puedes ahorrar el tiempo que quieras. Para alcanzar el ingreso adicional, te sugerimos hacerlo desde este mismo momento y hasta que cumplas  62 a�os, si eres hombre y 57 a�os si eres  mujer. Y disfrutarlo hasta que cumplas los 85 a�os.",
				driver.findElement(By.xpath("//div[@id='collapse8']/div/p[2]")).getText());
		driver.findElement(
				By.linkText("Si quiero que el ahorro me dure por m�s tiempo, m�s de los 85 a�os �Qu� puedo hacer?"))
				.click();
		assertEquals(
				"En este caso debes incrementar tu ahorro mensual y cuando llegue tu edad de pensi�n calculamos como ser�a el beneficio futuro seg�n el tiempo que lo desees recibir",
				driver.findElement(By.xpath("//div[@id='collapse9']/div/p[2]")).getText());
		driver.findElement(By.linkText(
				"�Qu� pasa con el ingreso adicional en la etapa de jubilaci�n si fallezco? hay un beneficiario?"))
				.click();
		assertEquals(
				"En caso de fallecimiento los herederos que acrediten su calidad ante Protecci�n ocuparan la posici�n contractual del afiliado en el producto.  De esta manera posterior al juicio de sucesi�n y sujeto a las condiciones de ley los herederos podr�n reclamar los dineros definiendo si desean una transferencia en la cuenta bancaria definida o un nuevo ahorro en Pensiones Voluntarias.",
				driver.findElement(By.xpath("//div[@id='collapse10']/div/p[2]")).getText());
		driver.findElement(By.linkText("�En qu� portafolio estar� invertido mi ahorro en +Protecci�n?")).click();
		assertEquals("El portafolio en el que se invertir� tu ahorro ser� Balanceado Moderado Protecci�n",
				driver.findElement(By.xpath("//div[@id='collapse11']/div/p[2]")).getText());
		driver.findElement(By.linkText("�Qu� comisi�n cobra +Protecci�n?")).click();
		assertEquals(
				"La comisi�n cobrada por Protecci�n ser� del 2.5% anual liquidado diariamente sobre el saldo acumulado en tu cuenta.  Recuerda que con el Beneficio +Proteccion te devolveremos hasta un 60% de la comisi�n cobrada si ahorras constantemente y no retiras.",
				driver.findElement(By.xpath("//div[@id='collapse12']/div/p[2]")).getText());
		driver.findElement(By.linkText("�Puedo hacer retiros?")).click();
		assertEquals("Los aportes que hagas puedes retirarlos despu�s de un a�o de permanencia en la cuenta.",
				driver.findElement(By.xpath("//div[@id='collapse13']/div/p[2]")).getText());
		assertEquals("Chat Protecci�n",
				driver.findElement(By.xpath("//div[@id='section4']/div/div/div/div[2]/div/div/h3")).getText());
		assertEquals("Asesor Virtual",
				driver.findElement(By.xpath("//div[@id='section4']/div/div/div/div[2]/div[2]/div/h3")).getText());
		assertEquals("L�nea de Servicio",
				driver.findElement(By.xpath("//div[@id='section4']/div/div/div/div[2]/div[3]/div/h3")).getText());
		driver.findElement(By.cssSelector("img.img-responsive.center-block")).click();
		assertEquals("Home", driver.getTitle());
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}
