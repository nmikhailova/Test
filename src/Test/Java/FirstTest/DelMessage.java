package FirstTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Nastya Mikhailova on 09.01.2017.
 */
public class DelMessage {

    /**
     * find first letter and delete him
     *
     * @param driver - driver
     * @return remote letters id
     */
    public String controlMessage(WebDriver driver) {

        Assert.assertTrue(driver.findElements(By.className("js-item-checkbox")).size() > 0);
        driver.findElements(By.className("js-item-checkbox")).get(0).click();
        String id = driver.findElements(By.cssSelector(".b-datalist__item.js-datalist-item"))
                .get(0).getAttribute("data-id");
        driver.findElement(By.cssSelector("[data-name='remove']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return id;
    }

}
