package com.codewithazam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class RelativeLocators {

    public static void main(String[] args) {
	// write your code here
        System.setProperty("webdriver.chrome.driver","/Users/codewithazam/Downloads/chromedriver");
        WebDriver driver =  new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement nameBox = driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(withTagName("label").above(nameBox)).getText());

        WebElement birth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(withTagName("input").below(birth)).sendKeys("02/02/2020");

        WebElement check = driver.findElement(By.xpath("//*[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(withTagName("input").toLeftOf(check)).click();

        WebElement radio = driver.findElement(By.cssSelector("[id='inlineRadio1']"));
        System.out.println(driver.findElement(withTagName("label").toRightOf(radio)).getText());
    }
}
