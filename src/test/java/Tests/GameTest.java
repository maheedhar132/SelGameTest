package Tests;

import org.openqa.selenium.chrome.ChromeOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.concurrent.TimeUnit;

public class GameTest {
    WebDriver driver;


    @Given("User is on Home Page")
    public void user_is_on_Home_Page() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                //chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-gpu");
         driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get(System.getProperty("url"));
    }

    @When("User Clicks on Team LeaderBoard")
    public void user_Clicks_on_Team_LeaderBoard() {
        driver.findElement(By.xpath("//*[@id='root']/div/div/div[1]/div/a[2]/span")).click();

    }

    @Then("User is redirected to Team LeaderBoard page")
    public void user_is_redirected_to_Team_LeaderBoard_page() {
        Assert.assertTrue(driver.getCurrentUrl().equals(System.getProperty("url")+"teamDashBoard"));
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println( "Sealights " + entry.getLevel() + " " + entry.getMessage());
            //do something useful with the data
        }
        driver.close();
    }

    @When("User Clicks on Individual LeaderBoard")
    public void user_Clicks_on_Individual_LeaderBoard() {

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/a[3]/span")).click();
    }

    @Then("User is redirected to Individual LeaderBoard page")
    public void user_is_redirected_to_Individual_LeaderBoard_page() {
        Assert.assertTrue(driver.getCurrentUrl().equals(System.getProperty("url")+"individualDashBoard"));
                LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println( "Sealights " + entry.getLevel() + " " + entry.getMessage());
            //do something useful with the data
        }
        driver.close();
    }

    @When("User Clicks on Team Rules")
    public void user_Clicks_on_Team_Rules() {

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/a[4]/span")).click();
    }

    @Then("User is redirected to Team Rules page")
    public void user_is_redirected_to_Team_Rules_page() {
        Assert.assertTrue(driver.getCurrentUrl().equals(System.getProperty("url")+"teamRules"));
                LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println( "Sealights " + entry.getLevel() + " " + entry.getMessage());
            //do something useful with the data
        }
        driver.close();
    }

    @Then("User is redirected to Individual Rules page")
    public void user_is_redirected_to_Individual_Rules_page() {
        Assert.assertTrue(driver.getCurrentUrl().equals(System.getProperty("url")+"individualRules"));
                LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println( "Sealights " + entry.getLevel() + " " + entry.getMessage());
            //do something useful with the data
        }
        driver.close();
    }

    @When("User Clicks on Add Rule")
    public void user_Clicks_on_Add_Rule() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div[2]/button[1]")).click();
        Thread.sleep(1000);
    }
    @When("User enters Mandatory details")
    public void user_enters_Mandatory_details() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/div[8]/div/button[1]")).click();
       Thread.sleep(2000);

    }

    @Then("Message is displayed {string}")
    public void message_is_displayed(String string) {

        String msg = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[4]/div/div/div[1]")).getText();
        System.out.println(msg+"---"+string);
        Assert.assertEquals(msg,string);
                LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println( "Sealights " + entry.getLevel() + " " + entry.getMessage());
            //do something useful with the data
        }
        driver.close();
    }

    @When("User clicks on Reset Rule")
    public void user_clicks_on_Reset_Rule() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div[2]/button[2]")).click();
        Thread.sleep(2000);
    }

    @When("User Clicks on Individual Rules")
    public void user_Clicks_on_Individual_Rules() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/a[5]/span")).click();

    }
}
