/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author pache
 */
public class TestPageConversion {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void celsiusToFahrenheit() {
        driver.get("http://localhost:8080/ConversionPoject/");
        driver.manage().window().setSize(new Dimension(516, 708));
        driver.findElement(By.name("option")).click();
        driver.findElement(By.name("n")).click();
        driver.findElement(By.name("n")).sendKeys("100");
        driver.findElement(By.name("conversion")).click();
        driver.findElement(By.cssSelector("html")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is("Result: 212.0"));
    }

    @Test
    public void fahrenheitToCelsius() {
        driver.get("http://localhost:8080/ConversionPoject/");
        driver.manage().window().setSize(new Dimension(516, 519));
        driver.findElement(By.name("n")).click();
        driver.findElement(By.name("n")).sendKeys("212");
        driver.findElement(By.name("option")).click();
        {
            WebElement dropdown = driver.findElement(By.name("option"));
            dropdown.findElement(By.xpath("//option[. = 'celsius']")).click();
        }
        driver.findElement(By.name("conversion")).click();
        driver.findElement(By.cssSelector("h2")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is("Result: 100.0"));
    }
}
