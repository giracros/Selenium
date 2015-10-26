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

		assertEquals("Porque sólo un poco hoy, puede hacer una gran diferencia mañana.",
				driver.findElement(By
						.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div[1]/div/div/section/div[2]/div[2]/div[1]/div/div[1]/div/div/div[1]/div/div/div/div/p[2]/span"))
				.getText());

		driver.findElement(By.linkText("Quiero conocer +")).click();

		driver.findElement(By.linkText("¿Para qué sirve + Protección?")).click();

		assertEquals("Para construir y recibir más ingreso en tu etapa de jubilación.",
				driver.findElement(By.id("preguntas-dudas-respuesta")).getText());

		driver.findElement(By.linkText("¿Cómo hacerlo?")).click();

		assertEquals(
				"Es muy fácil, vincúlate al producto en pocos pasos y autoriza el débito automático mensual a tu cuenta de ahorros. No tienes que ser cliente actual de Protección para hacerlo. Recuerda que siempre puedes dar más, por eso en cualquier momento puedes hacer aportes extraordinarios.",

				driver.findElement(By.id("preguntas-dudas-respuesta")).getText());

		driver.findElement(By.linkText("¿Cuánto debo ahorrar?")).click();
		assertEquals(
				"Puedes ahorrar desde $25.000 mensuales que se incrementaran cada año en IPC+3%. Te sugerimos tu ahorro ideal, según tu edad, salario y género.",
				driver.findElement(By.id("preguntas-dudas-respuesta")).getText());

		driver.findElement(By.linkText("¿Durante cuánto tiempo debo ahorrar?")).click();
		assertEquals(
				"Puedes ahorrar el tiempo que quieras. Para alcanzar el ingreso adicional, te sugerimos hacerlo desde este mismo momento y hasta que cumplas 62 años, si eres hombre y 57 años si eres mujer.",
				driver.findElement(By.id("preguntas-dudas-respuesta")).getText());

		driver.findElement(By.linkText("¿Qué es el beneficio +Protección?")).click();
		assertTrue(driver.findElement(By.id("preguntas-dudas-respuesta")).getText().matches(
				"^exact:Proteccion quiere aportar a esa construcción de tu futuro, por eso quiere motivarte a que seas constante y no realices ningún retiro durante la etapa de ahorro\\. Como incentivo a tu buen comportamiento Proteccion devolverá hasta el 60% de la comisión cobrada asi: Cada año obtendrás un beneficio anual con una devolución del 40% esta y cada 5 años un beneficio extra con una devolución del 20% de la comisión cobrada durante este tiempo\\. Con esto obtendrás aumentar tu ahorro, obtener un mayor ingreso en el futuro para mantener tu calidad de vida\\. [\\s\\S]*La comisión cobrada por Protección será del 2\\.5% anual liquidado diariamente sobre el saldo acumulado en tu cuenta\\.$"));
		driver.findElement(By.linkText("¿Cómo disfruto mi ahorro?")).click();
		assertEquals(
				"Lo puedes disfrutar como un pago mensual, una suma única a partir de los 62 años si eres hombre o 57 años si eres mujer, complementando así tu mesada pensional hasta los 85 años.",
				driver.findElement(By.id("preguntas-dudas-respuesta")).getText());
		driver.findElement(By.linkText("Volver")).click();
		driver.findElement(By.linkText("+ Para ti")).click();
		assertEquals("Afiliado", driver.getTitle());
		assertEquals(
				"Eso es +Protección, es ese poco + que les da tranquilidad a sus vidas y que les permitirá vivir un mejor mañana, es ese + que les cambia el hoy y les da felicidad, es ese + que desde el presente les ayuda a transformar su futuro.",
				driver.findElement(By.xpath("//div[@id='slide3']/div/div/div/div/div/div/div/p[2]")).getText());
		driver.findElement(By.xpath("(//a[contains(text(),'Quiero conocer +')])[2]")).click();
		assertEquals("Siempre que puedas ahorra +", driver
				.findElement(By.xpath("//div[@id='slide4']/div/div/div/div/div/div/div/div/div/div/h3")).getText());
		driver.findElement(By.cssSelector("div.text > a.more.back-slide")).click();
		driver.findElement(By.linkText("+ Ayuda")).click();
		driver.findElement(By.linkText("¿Este producto es de Pensión voluntaria?")).click();
		assertEquals(
				"Si.  +Proteccion hace parte del fondo de Pensiones Voluntarias, lo que implica los mismos beneficios que obtienes hoy en este producto más los beneficios adicionales de +Protección.",
				driver.findElement(By.xpath("//div[@id='collapse1']/div/p[2]")).getText());
		driver.findElement(
				By.linkText("¿Debo estar afiliado en algún producto de Protección para afiliarme a + Protección?"))
				.click();
		assertEquals("No.  No tienes que ser cliente actual para protección para vincularte a +Protección",
				driver.findElement(By.xpath("//div[@id='collapse2']/div/p[2]")).getText());
		driver.findElement(By.linkText("¿Cómo puedo ahorrar en +Protección?")).click();
		assertEquals(
				"Es muy fácil,  vincúlate al producto en pocos pasos y autoriza el débito automático mensual a tu cuenta de ahorros.  No tienes que ser cliente actual de Protección para hacerlo.",
				driver.findElement(By.xpath("//div[@id='collapse3']/div/p[2]")).getText());
		driver.findElement(By.linkText("¿Cómo quedará conformado mi ahorro?")).click();
		assertEquals(
				"En tu ahorro +Protección, tendrás 3 cuentas. Aquí estarán los aportes que tú haces, el reconocimiento que te da +Protección como premio al buen comportamiento con tu ahorro y el aporte que podrá hacerte un tercero.",
				driver.findElement(By.xpath("//div[@id='collapse4']/div/p[2]")).getText());
		driver.findElement(By.xpath("(//a[contains(text(),'¿Cuánto debo ahorrar?')])[2]")).click();
		assertEquals(
				"Puedes ahorrar desde $25.000 mensuales que se incrementaran cada año en IPC+3%. Te sugerimos tu ahorro ideal, según tu edad, salario y género.",
				driver.findElement(By.xpath("//div[@id='collapse5']/div/p[2]")).getText());
		driver.findElement(By.linkText("¿Qué pasa si me aumenta el salario?")).click();
		assertEquals("Debes calcular de nuevo el monto sugerido a ahorrar en el simulador",
				driver.findElement(By.linkText("Debes calcular de nuevo el monto sugerido a ahorrar en el simulador"))
						.getText());
		driver.findElement(
				By.linkText("¿Por qué se debe tener en cuenta la edad, salario y el género para el monto del ahorro?"))
				.click();
		assertEquals(
				"Porque +Proteccion busca complementar el ingreso por pensión en un % que te permita mantener tu calidad de vida en el futuro.  Para esto debemos tener en cuenta tu género y así saber a qué edad te pensionas, tu edad para saber cuánto tiempo tienes para ahorrar y tu salario para calcular el beneficio futuro adecuado según tu ingreso.",
				driver.findElement(By.xpath("//div[@id='collapse7']/div/p[2]")).getText());
		driver.findElement(By.xpath("(//a[contains(text(),'¿Durante cuánto tiempo debo ahorrar?')])[2]")).click();
		assertEquals(
				"Puedes ahorrar el tiempo que quieras. Para alcanzar el ingreso adicional, te sugerimos hacerlo desde este mismo momento y hasta que cumplas  62 años, si eres hombre y 57 años si eres  mujer. Y disfrutarlo hasta que cumplas los 85 años.",
				driver.findElement(By.xpath("//div[@id='collapse8']/div/p[2]")).getText());
		driver.findElement(
				By.linkText("Si quiero que el ahorro me dure por más tiempo, más de los 85 años ¿Qué puedo hacer?"))
				.click();
		assertEquals(
				"En este caso debes incrementar tu ahorro mensual y cuando llegue tu edad de pensión calculamos como sería el beneficio futuro según el tiempo que lo desees recibir",
				driver.findElement(By.xpath("//div[@id='collapse9']/div/p[2]")).getText());
		driver.findElement(By.linkText(
				"¿Qué pasa con el ingreso adicional en la etapa de jubilación si fallezco? hay un beneficiario?"))
				.click();
		assertEquals(
				"En caso de fallecimiento los herederos que acrediten su calidad ante Protección ocuparan la posición contractual del afiliado en el producto.  De esta manera posterior al juicio de sucesión y sujeto a las condiciones de ley los herederos podrán reclamar los dineros definiendo si desean una transferencia en la cuenta bancaria definida o un nuevo ahorro en Pensiones Voluntarias.",
				driver.findElement(By.xpath("//div[@id='collapse10']/div/p[2]")).getText());
		driver.findElement(By.linkText("¿En qué portafolio estará invertido mi ahorro en +Protección?")).click();
		assertEquals("El portafolio en el que se invertirá tu ahorro será Balanceado Moderado Protección",
				driver.findElement(By.xpath("//div[@id='collapse11']/div/p[2]")).getText());
		driver.findElement(By.linkText("¿Qué comisión cobra +Protección?")).click();
		assertEquals(
				"La comisión cobrada por Protección será del 2.5% anual liquidado diariamente sobre el saldo acumulado en tu cuenta.  Recuerda que con el Beneficio +Proteccion te devolveremos hasta un 60% de la comisión cobrada si ahorras constantemente y no retiras.",
				driver.findElement(By.xpath("//div[@id='collapse12']/div/p[2]")).getText());
		driver.findElement(By.linkText("¿Puedo hacer retiros?")).click();
		assertEquals("Los aportes que hagas puedes retirarlos después de un año de permanencia en la cuenta.",
				driver.findElement(By.xpath("//div[@id='collapse13']/div/p[2]")).getText());
		assertEquals("Chat Protección",
				driver.findElement(By.xpath("//div[@id='section4']/div/div/div/div[2]/div/div/h3")).getText());
		assertEquals("Asesor Virtual",
				driver.findElement(By.xpath("//div[@id='section4']/div/div/div/div[2]/div[2]/div/h3")).getText());
		assertEquals("Línea de Servicio",
				driver.findElement(By.xpath("//div[@id='section4']/div/div/div/div[2]/div[3]/div/h3")).getText());
		driver.findElement(By.cssSelector("img.img-responsive.center-block")).click();
		assertEquals("Home", driver.getTitle());
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}
