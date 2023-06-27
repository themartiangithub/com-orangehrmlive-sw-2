package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    //Declaring BaseURL
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find username field and enter username
        driver.findElement(By.name("username")).sendKeys("Admin");
        //find password field and enter password
        driver.findElement(By.name("password")).sendKeys("admin123");
        //click on login button
        driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
        String expected = "Dashboard";
        String actual = driver.findElement(By.xpath("//div[@class = 'oxd-topbar-header-title']//h6[@class = 'oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        Assert.assertEquals(expected,actual);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
