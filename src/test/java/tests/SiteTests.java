package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SiteTests extends BaseTests {
    @Test
    public void testLogInPositive() throws InterruptedException {
        driver.get("https://demoqa.com/elements");

        WebElement btnButtons = driver.findElement(By.id("item-4"));
        btnButtons.click();

        WebElement btnClickMe = driver.findElement(By.xpath("//button[text()='Click Me']"));
        btnClickMe.click();

        WebElement btnText = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertEquals("You have done a dynamic click", btnText.getText());

        driver.close();
    }



    @Test
    public void testPositive2()throws InterruptedException{
        driver.get("https://demoqa.com/webtables");
        WebElement btnAdd = driver.findElement(By.id("addNewRecordButton"));
        btnAdd.click();

        WebElement inputFirstName = driver.findElement(By.id("firstName"));
        inputFirstName.sendKeys("Mariana");
        WebElement inputLastName = driver.findElement(By.id("lastName"));
        inputLastName.sendKeys("K");
        WebElement inputEmail = driver.findElement(By.id("userEmail"));
        inputEmail.sendKeys("mariana@test.com");
        WebElement inputAge = driver.findElement(By.id("age"));
        inputAge.sendKeys("90");
        WebElement inputSalary = driver.findElement(By.id("salary"));
        inputSalary.sendKeys("1000000");
        WebElement inputDep = driver.findElement(By.id("department"));
        inputDep.sendKeys("IT");

        WebElement btnSubmit = driver.findElement(By.id("submit"));
        btnSubmit.click();


        WebElement lineNewFirstNameCheck = driver.findElement(By.xpath("//div[@class='rt-td']/preceding-sibling::div[contains(text(), 'Mariana')]"));
        Assert.assertEquals("Mariana", lineNewFirstNameCheck.getText());


        WebElement btnEdit = driver.findElement(By.xpath("//*[@id='edit-record-4']"));
        btnEdit.click();
        WebElement inputFirstNameUpdate = driver.findElement(By.id("firstName"));
        inputFirstNameUpdate.clear();
        inputFirstNameUpdate.sendKeys("Marianna");
        WebElement btnSubmit2 = driver.findElement(By.id("submit"));
        btnSubmit2.click();

        WebElement lineNewFirstNameCheckUpdate = driver.findElement(By.xpath("//div[@class='rt-td']/preceding-sibling::div[contains(text(), 'Marianna')]"));
        Assert.assertEquals("Marianna", lineNewFirstNameCheckUpdate.getText());

        driver.close();
    }

}

