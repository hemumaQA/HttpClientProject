package com.ip.httprequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

//BROKEN LINK - is a dead link on a web page that no longer works because of the foll:
//1.improper url entered for the link
//2.destination website removed the linked web page(404-error)
//3.dest.website perm. moved/does not exist-

public class Brokenlink {
    WebDriver driver;

    @Test
    public void brokenlinkfinder() throws InterruptedException, IOException {
        //path or loacation-initiaite the driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemum\\IdeaProjects\\SeleniumMaven\\src\\main\\JUnit\\HTTP client\\src\\main\\resources\\chromedriver.exe");

        //create an object
        driver = new ChromeDriver();
        //maximise
        driver.manage().window();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //get Url
        driver.get("http://demo.guru99.com/test/newtours/ ");
        // driver.get("http://www.whiteboxqa.com/login.php");
        System.out.println(driver.getTitle());

        Thread.sleep(3000);


        //capture links from the web page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        //number of links
        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++) {

            //href is used to get the URL of the required link

            WebElement element = links.get(i);
            String url = element.getAttribute(("href"));

            URL link = new URL(url);
            //**********************************************//
            //create a connection using Url object link
            HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();

            //Thread.sleep(2000);

            httpConn.connect();

            int rescode = httpConn.getResponseCode();// if response code is above 400,they are broken links

            if (rescode >= 400) {
                System.out.println(url + " - " + "is broken link");
            } else
                System.out.println(url + "-" + "is valid link");
        }
        driver.close();
    }

    //adding comments to make changes to get reflected in the github



            }




