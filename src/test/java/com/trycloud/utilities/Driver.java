package com.trycloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver{
    /*
     * Singleton is a design pattern to have a class only generate one object
     * in order to achieve Singleton pattern
     * 1. private constructor
     * 2. private static field with data type same as class
     * 3. public getter method for private field
     *       to check if you have already created object
     *       if not -- create object for the first time
     *       if yes -- just use existing objec
     */
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
