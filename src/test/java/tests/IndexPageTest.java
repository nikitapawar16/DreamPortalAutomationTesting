package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IndexPageTest {

    @Test
    public void testDreamPortal() throws InterruptedException {
        // ✅ Set path to chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DSNK\\Documents\\Software Testing\\Ecommerce_Website_Testing_Project\\AutomationTesting\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://arjitnigam.github.io/myDreams/");

        // ✅ Validate page title
        String expectedTitle = "Dream Portal";
        String actualTitle = driver.getTitle();
        System.out.println("Title: " + actualTitle);

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("✅ Title validation passed.");
        } else {
            System.out.println("❌ Title validation failed.");
        }

        // ✅ Wait for animation to finish
        Thread.sleep(5000); // optional wait

        // ✅ Click the "My Dreams" button
        driver.findElement(By.xpath("//button[contains(text(), 'My Dreams')]")).click();

        Thread.sleep(4000); // wait for page change

        // ✅ Validate Dream Summary page
        String summaryHeading = driver.findElement(By.xpath("//h1")).getText();
        System.out.println("Heading found: " + summaryHeading);

        if (summaryHeading.toLowerCase().contains("dream")) {
            System.out.println("✅ Page changed: Dream Summary loaded.");
        } else {
            System.out.println("❌ Page did not change correctly.");
        }

        // ✅ Close browser
        driver.quit();
    }
}
