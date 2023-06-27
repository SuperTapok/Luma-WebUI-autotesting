package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Settings {
    public static final WebDriver driver = new ChromeDriver();
    public static final WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(1));
    public static final Actions actions = new Actions(driver);
}
