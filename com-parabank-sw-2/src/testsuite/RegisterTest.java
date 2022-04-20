package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    //1.verifyThatSigningUpPageDisplay
    public void signingUpPageDisplay() {
        //click to register link
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        String actualText = driver.findElement(By.xpath("//h1[text()='Signing up is easy!']")).getText();
        //Verify the text ‘Signing up is easy!’
        String expactedText = "Signing up is easy!";
        Assert.assertEquals("verify text ", expactedText, actualText);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        //click on the ‘Register’ link
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        //* Enter First name
        driver.findElement(By.id("customer.firstName")).sendKeys("priya");
        //* Enter Last name
        driver.findElement(By.id("customer.lastName")).sendKeys("patel");
        //Enter Address
        driver.findElement(By.id("customer.address.street")).sendKeys("16 london road");
        // enter city
        driver.findElement(By.id("customer.address.city")).sendKeys("sheffild");
        //Enter State
        driver.findElement(By.id("customer.address.state")).sendKeys("southyourkshire");
        //Enter Zip Code
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("s7 out");
        // Enter Phone
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("7658937475");
        //Enter SSN
        driver.findElement(By.id("customer.ssn")).sendKeys("23456");
        //Enter Username
        driver.findElement(By.id("customer.username")).sendKeys("abha");
        //* Enter Password
        driver.findElement(By.id("customer.password")).sendKeys("12345");
        //* Enter Confirm
        driver.findElement(By.id("repeatedPassword")).sendKeys("12345");
        //* Click on REGISTER button
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        //erify the text 'Your account was created successfully. You are now logged in.’
        String actualText = driver.findElement(By.xpath("//p[starts-with(text(),'Your account')]")).getText();
        String expactedText = "Your account was created successfully. You are now logged in.";
        Assert.assertEquals("verify text ", expactedText, actualText);
    }
    @After
    public void tearDown(){
        closingBrowser();
    }
}