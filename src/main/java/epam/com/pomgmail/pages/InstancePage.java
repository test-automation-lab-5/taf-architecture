package epam.com.pomgmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InstancePage {

    private static WebDriver driver;

    private InstancePage(){

    }

    public static void openBrowser(){
        driver = new ChromeDriver();
    }

    public static WebDriver getInstance(){
        if(driver == null){
            openBrowser();
        }
        return driver;
    }
}
