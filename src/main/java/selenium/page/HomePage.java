package selenium.page;

import org.openqa.selenium.WebDriver;
import selenium.element.Header;


public class HomePage extends BasePage{
    private final Header header;

    public HomePage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
    }

    public Header getHeader() {
        return header;
    }
}
