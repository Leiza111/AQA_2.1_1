import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppOrderCardTest {

    private WebDriver driver;

    @BeforeAll //запускается 1 раз
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach //перед каждым тестом
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
        driver = new ChromeDriver();
    }

    //закрытие браузера, очистка за собой
    @AfterEach //после каждого теста
    public void teardown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void shouldSendForm() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Ольга Иванова");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79388758954");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected,text);



//        driver.findElement(By.cssSelector("[data-test-id='name']")).sendKeys("Галина Иванова");
//        driver.findElement(By.cssSelector("[data-test-id='phone']")).sendKeys("+79278327485");
//        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
//        driver.findElement(By.cssSelector("button")).click();
//        String actual = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText().trim();
//        String expected = "Поле обязательно для заполнения";
//        assertEquals(expected, actual);
    }
}