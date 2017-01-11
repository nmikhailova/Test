package FirstTest;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Nastya Mikhailova on 09.01.2017.
 * <p>
 * This main test which check: login, creating and sending new letter
 * and deleting letter
 */
public class EmailTest {

    private static final String URL = "https://mail.ru";
    private static final String USER = "test.webdriver";
    private static final String PASSWORD = "Task_256";
    private static final String DOMAIN = "@mail.ru";

    private WebDriver driver = new ChromeDriver();
    private LoginService logingService;

    @Before
    public void setup() {

        logingService = new LoginService();
    }

    /**
     * Testing of the login
     */
    @Test
    public void firstTestLogin() {
        logingService.loginService(driver, URL, USER, PASSWORD, DOMAIN);
        Assert.assertEquals(USER + DOMAIN, driver.findElement(By.id("PH_user-email")).getText());
    }

    /**
     * Testing the creation of the new message
     */
    @Test
    public void secondTestMessage() {

        logingService.loginService(driver, URL, USER, PASSWORD, DOMAIN);
        SendMessage msg = new SendMessage();
        msg.inputEmail(driver, USER, DOMAIN);
        Assert.assertEquals("Ваше письмо отправлено. Перейти во Входящие",
                driver.findElement(By.className("message-sent__title")).getText());
    }

    /**
     * Testing the deletion of the first letter
     */
    @Test
    public void thirdTestDelMessage() {
        logingService.loginService(driver, URL, USER, PASSWORD, DOMAIN);
        DelMessage msg = new DelMessage();
        String id = msg.controlMessage(driver);
        Assert.assertFalse(driver.findElements(By.cssSelector(".b-datalist__item.js-datalist-item")).get(0)
                .getAttribute("data-id") == id);
    }

    /**
     * Closes driver
     */
    @After
    public void quit() {
        driver.quit();
    }

}
