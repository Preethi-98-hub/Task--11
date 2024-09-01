package Seleniumwindowhandles.windowhandles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class nestedframes {

	 public static void main(String[] args) {
	        // Set the path to your chromedriver
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver();
	        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            // Open the URL
            driver.get("https://the-internet.herokuapp.com/nested_frames");

            // Switch to the top frame
            driver.switchTo().frame("frame-top");

            // Verify that there are three frames on the page
            List<WebElement> frames = driver.findElements(By.tagName("frame"));
            if (frames.size() == 3) {
                System.out.println("Verified: There are three frames in the top frame.");
            } else {
                System.out.println("Failed: Expected 3 frames but found " + frames.size());
            }

            // Switch to the left frame and verify text
            driver.switchTo().frame("frame-left");
            String leftText = driver.findElement(By.tagName("body")).getText();
            if ("LEFT".equals(leftText)) {
                System.out.println("Verified: Left frame has text 'LEFT'.");
            } else {
                System.out.println("Failed: Left frame text is " + leftText);
            }

            // Switch back to the top frame and then to the middle frame
            driver.switchTo().parentFrame(); // back to top frame
            driver.switchTo().frame("frame-middle");
            String middleText = driver.findElement(By.id("content")).getText();
            if ("MIDDLE".equals(middleText)) {
                System.out.println("Verified: Middle frame has text 'MIDDLE'.");
            } else {
                System.out.println("Failed: Middle frame text is " + middleText);
            }

            // Switch back to the top frame and then to the right frame
            driver.switchTo().parentFrame(); // back to top frame
            driver.switchTo().frame("frame-right");
            String rightText = driver.findElement(By.tagName("body")).getText();
            if ("RIGHT".equals(rightText)) {
                System.out.println("Verified: Right frame has text 'RIGHT'.");
            } else {
                System.out.println("Failed: Right frame text is " + rightText);
            }

            // Switch back to the main content and then to the bottom frame
            driver.switchTo().defaultContent(); // back to main content
            driver.switchTo().frame("frame-bottom");
            String bottomText = driver.findElement(By.tagName("body")).getText();
            if ("BOTTOM".equals(bottomText)) {
                System.out.println("Verified: Bottom frame has text 'BOTTOM'.");
            } else {
                System.out.println("Failed: Bottom frame text is " + bottomText);
            }

            // Switch back to the main content and verify the page title
            driver.switchTo().defaultContent(); // back to main content
            String pageTitle = driver.getTitle();
            if ("Frames".equals(pageTitle)) {
                System.out.println("Verified: Page title is 'FRAMES'.");
            } else {
                System.out.println("Failed: Page title is " + pageTitle);
            }

        } finally {
            // Close the browser
            driver.quit();
        }
    }


	}


