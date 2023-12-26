package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Settings {
    public static String URL = "https://magento.softwaretestingboard.com/";

    public static WebDriver createDriver (){
        return new ChromeDriver();
    }

}
