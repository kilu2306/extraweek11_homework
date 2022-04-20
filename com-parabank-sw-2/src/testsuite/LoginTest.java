package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    //.userShouldLoginSuccessfullyWithValidCredentials
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter valid username
        driver.findElement(By.name("username")).sendKeys("abha");
        //Enter valid password
        driver.findElement(By.name("password")).sendKeys("12345");
        //Click on ‘LOGIN’ button
        driver.findElement(By.cssSelector("[value='Log In']")).click();
        //to verify account view text is disolayed
        String actualTe=driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]")).getText();
        String expactedText="Accounts Overview";
        Assert.assertEquals("verify text",expactedText,actualTe);
    }
@Test
    //verifyTheErrorMessage
    public void verifyTheErrorMessage(){
        //enter invalid user name and password
    driver.findElement(By.name("username")).sendKeys("abha23");
    //Enter invalid password
    driver.findElement(By.name("password")).sendKeys("12345678");
    //Click on ‘LOGIN’ button
    driver.findElement(By.cssSelector("[value='Log In']")).click();
    //find the error msg and verify text
    String actualText=driver.findElement(By.xpath("//p[starts-with(text(),'An internal error')]")).getText();
    String expactedText="The username and password could not be verified.";
    Assert.assertEquals("verify text",expactedText,actualText);

}
@Test
    //.userShouldLogOutSuccessfully
    public void userShouldLogOutSuccessfully(){
    //Enter valid username
    driver.findElement(By.name("username")).sendKeys("abha");
    //Enter valid password
    driver.findElement(By.name("password")).sendKeys("12345");
    //Click on ‘LOGIN’ button
    driver.findElement(By.cssSelector("[value='Log In']")).click();
    //click on log out
    driver.findElement(By.xpath("//a[starts-with(text(),'Log Out')]")).click();
//verify text customer log in
    String actualText=driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]")).getText();
    String expactedText="Customer Login";
    Assert.assertEquals("verify text",expactedText,actualText);
}
@After
    public void tearDown(){
     //   closingBrowser();
}
}
