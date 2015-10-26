package com.positivos;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Test {
  private WebDriver driver;
  private String baseUrl;

  @BeforeTest
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://10.11.230.81:81/MasProteccionCRM/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }


  public void testAfiliadoNuevo() throws Exception {
    driver.get(baseUrl + "/AutenticadorWEB/Autenticacion.jsp?cGFyYW1z=LeOx0iwqGnYmV_3ogAitS95Xx_fk7UfqAa2UMCif6QRDtaIJ4fUJHfywnTgXRgfKYFgPSmfhNIHAPYMUx7Z_VoPY2Nl5Bf2y_XtfbK-TEATlchp9ZfIbKgsCzPQuyRdVYejsC3xzdFK4qAp_dlM4Jw2");
    driver.findElement(By.name("IdNovell")).clear();
    driver.findElement(By.name("IdNovell")).sendKeys("lpuerta");
    driver.findElement(By.name("send")).click();
    driver.findElement(By.name("numIdentificacion")).clear();
    driver.findElement(By.name("numIdentificacion")).sendKeys("4556453344");
    driver.findElement(By.name("enviar")).click();
    new Select(driver.findElement(By.id("departamentoExpedicion"))).selectByVisibleText("AMAZONAS");
    new Select(driver.findElement(By.id("departamentoNacimiento"))).selectByVisibleText("ATLÁNTICO");
    new Select(driver.findElement(By.id("departamentoResidencia"))).selectByVisibleText("ATLÁNTICO");
    new Select(driver.findElement(By.id("nacionalidad"))).selectByVisibleText("ARABIA SAUDITA");
    new Select(driver.findElement(By.id("ciudadExpedicion"))).selectByVisibleText("LA VICTORIA");
    new Select(driver.findElement(By.name("ciudadNacimiento"))).selectByVisibleText("LURUACO");
    new Select(driver.findElement(By.id("ciudadResidencia"))).selectByVisibleText("MALAMBO");
    driver.findElement(By.id("primerApellido")).clear();
    driver.findElement(By.id("primerApellido")).sendKeys("asd");
    driver.findElement(By.id("segundoApellido")).clear();
    driver.findElement(By.id("segundoApellido")).sendKeys("asd");
    driver.findElement(By.id("primerNombre")).clear();
    driver.findElement(By.id("primerNombre")).sendKeys("qwe");
    driver.findElement(By.id("segundoNombre")).clear();
    driver.findElement(By.id("segundoNombre")).sendKeys("asd");
    driver.findElement(By.id("sexoM")).click();
    driver.findElement(By.xpath("//form[@id='vinculacionMasProteccion']/div[2]/div[3]/div/div[2]/label")).click();
    driver.findElement(By.name("dirResidencia")).click();
    new Select(driver.findElement(By.name("via"))).selectByVisibleText("Diagonal");
    driver.findElement(By.name("numVia")).clear();
    driver.findElement(By.name("numVia")).sendKeys("1");
    driver.findElement(By.id("numero")).clear();
    driver.findElement(By.id("numero")).sendKeys("2");
    driver.findElement(By.name("inter")).clear();
    driver.findElement(By.name("inter")).sendKeys("3");
    driver.findElement(By.linkText("Aceptar")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("eduwin.fuentes@outlook.com");
    driver.findElement(By.id("telefono")).clear();
    driver.findElement(By.id("telefono")).sendKeys("2342342");
    driver.findElement(By.id("celular")).clear();
    driver.findElement(By.id("celular")).sendKeys("8767567453");
    driver.findElement(By.id("nit")).clear();
    driver.findElement(By.id("nit")).sendKeys("1");
    driver.findElement(By.id("valorAporte")).clear();
    driver.findElement(By.id("valorAporte")).sendKeys("60000");
    new Select(driver.findElement(By.id("entidadFinanciera"))).selectByVisibleText("BANCO AGRARIO");
    driver.findElement(By.id("numeroCuenta")).clear();
    driver.findElement(By.id("numeroCuenta")).sendKeys("395843948503");
    driver.findElement(By.id("ingresos")).clear();
    driver.findElement(By.id("ingresos")).sendKeys("1000000");
    driver.findElement(By.id("egresos")).clear();
    driver.findElement(By.id("egresos")).sendKeys("200000");
    driver.findElement(By.id("totalActivos")).clear();
    driver.findElement(By.id("totalActivos")).sendKeys("1");
    driver.findElement(By.id("totalPasivos")).clear();
    driver.findElement(By.id("totalPasivos")).sendKeys("1");
    driver.findElement(By.id("condiciones")).click();
    driver.findElement(By.id("controlActivos")).click();
    driver.findElement(By.id("habeasData")).click();
    driver.findElement(By.id("fechaExpedicion")).clear();
    driver.findElement(By.id("fechaExpedicion")).sendKeys("10/07/2008");
    driver.findElement(By.id("fechaNacimiento")).clear();
    driver.findElement(By.id("fechaNacimiento")).sendKeys("05/07/1990");
    driver.findElement(By.cssSelector("input.center")).click();
    driver.findElement(By.linkText("Cerrar")).click();
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();

  }
}
