package com.trycloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver{

    private static WebDriver object;

    private Driver(){

    }
    public static WebDriver getDriver(){
        String browserName = ConfigReader.read("browser");
        if (object == null){
            switch (browserName){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    object = new ChromeDriver();
                    object.manage().window().maximize();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    object = new EdgeDriver();
                    object.manage().window().maximize();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    object = new OperaDriver();
                    object.manage().window().maximize();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    object = new FirefoxDriver();
                    object.manage().window().maximize();
                    break;

                default:
                    object=null;
                    System.out.println("Enter a valid browser name!");
            }
            return object;
        } else {
            return object;
        }
    }

    public static void closeDriver(){
        if (object != null){
            object.quit();
            object= null;
        }
    }

}
