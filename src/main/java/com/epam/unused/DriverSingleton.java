package com.epam.unused;

import com.epam.datasource.DriverProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {

   /* private static Map<Long, WebDriver> driverMap = new HashMap<>();


    public static WebDriver driver;

    private DriverSingleton (){}

    public static WebDriver createDriver (long threadId){
        DriverProperties driverProperties = new DriverProperties();
        System.setProperty(driverProperties.getChromeDriver(), driverProperties.getUrl());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driverMap.put(threadId, driver);
        System.out.println(String.format("Thread.currentThread().getId() %d",Thread.currentThread().getId()));
        return  driver;

    }


    public static WebDriver getInstance (){
        long threadId = Thread.currentThread().getId();
        System.out.println(String.format("In getInstance method %d", threadId));
        return driverMap.containsKey(threadId)
                ? driverMap.get(threadId)
                : createDriver(threadId);

    }

    public static void stopDriver() {
        WebDriver driver = driverMap.get(Thread.currentThread().getId());
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }*/

    public static WebDriver driver;

    public static WebDriver createDriver (){
        DriverProperties driverProperties = new DriverProperties();
        System.setProperty(driverProperties.getChromeDriver(), driverProperties.getUrl());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return  driver;

    }

      public static WebDriver getInstance() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

/*public static WebDriver getInstance (){
        WebDriver driver = driverMap.get(Thread.currentThread().getId());
    System.out.println("In getInstance method");
        if (driver == null){
            driver = createDriver();
        }
        return driver;
}*/



    /*private static WebDriver driver  = new ChromeDriver();
    static ThreadLocal<WebDriver> localDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getInstance ()
    {
        localDriver.set(driver);
        return localDriver.get();
    }*/

}
