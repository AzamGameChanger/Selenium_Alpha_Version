package com.codewithazam;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class MultipleWindows {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/codewithazam/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //Switching windows
        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parent = it.next();
        String child = it.next();

        driver.switchTo().window(child);
        driver.get("https://rahulshettyacademy.com/#/index");
        String text = driver.findElements(By.cssSelector("[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();

        driver.switchTo().window(parent);
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(text);

        //Screenshot
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("logo.png"));

        //Get Height and Width
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
    }
}
