package cc1.qes1;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ccclass {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(co);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement user = driver.findElement(By.id("user-name"));
		user.sendKeys("standard_user");
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("secret_sauce");
		WebElement login = driver.findElement(By.id("login-button"));
		login.click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
        String cartCount = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span")).getText();
        
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
        String product = "Sauce Labs Fleece Jacket";
        
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("SANJAY");
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("R");
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("626203");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        
        System.out.println("Name of the product: " + driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div")).getText());
        System.out.println("Price of the product: " + driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div")).getText());
        
    } 
}