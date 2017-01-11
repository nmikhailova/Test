package FirstTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Nastya Mikhailova on 08.01.2017.
 */
public class LoginService {

    /**
     * Input user data and click on "Login" button
     *
     * @param driver   - driver
     * @param url      - url
     * @param user     - usernaim
     * @param password - password
     * @param domain   - "@" + email domain
     */
    public void loginService(WebDriver driver, String url, String user, String password, String domain) {
        driver.get(url);
        driver.findElement(By.id("mailbox__login")).sendKeys(user);
        driver.findElement(By.id("mailbox__password")).sendKeys(password);
        driver.findElement(By.id("mailbox__auth__button")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

}
