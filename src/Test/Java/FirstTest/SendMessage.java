package FirstTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Nastya Mikhailova on 09.01.2017.
 */
public class SendMessage {

    /**
     * Create and send new message
     *
     * @param driver - driver
     * @param user   - usernaim addressee
     * @param domain - "@" + email domain
     */
    public void inputEmail(WebDriver driver, String user, String domain) {

        driver.findElement(By.cssSelector("[data-name='compose']")).click();
        driver.findElement(By.cssSelector("textarea[class='js-input compose__labels__input']"))
                .sendKeys(user + domain);
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id^=toolkit]")));
        driver.findElement(By.id("tinymce")).sendKeys("This is test");
        driver.switchTo().parentFrame();
        driver.findElement(By.cssSelector("[data-name='send']")).click();

    }
}
