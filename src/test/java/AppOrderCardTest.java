import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AppOrderCardTest {

    private WebDriver driver;

    @BeforeAll //запускается 1 раз
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach //перед каждым тестом
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
      // driver = new ChromeDriver();
    }
//закрытие браузера, очистка за собой
    @AfterEach //после каждого теста
    public void teardown() {
        driver.quit();
        driver = null;
        //if (driver != null) {
          //  driver.quit();
        }

    @Test
    public void shouldSendApplication() {
        driver.get("http://localhost:9999");
        System.out.println();

    }
}
