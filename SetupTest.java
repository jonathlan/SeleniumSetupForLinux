// Configure Selenium in Ubuntu:
// https://tecadmin.net/setup-selenium-chromedriver-on-ubuntu/

// Hints in case you have issues configuring chromedriver:
// https://stackoverflow.com/questions/48897286/chrome-webdriver-cant-be-resolved-to-a-type-error-eclipse-and-java/48898627

/* Chrome Webdriver can't be resolved to a type error eclipse and java
 * 
 * This type of error occurs when you have added the external jars in the ModulePath. 
 * To resolve this issue, you can remove the external jars from the node "Modulepath".
 * Select the node "Classpath" then add the external jars.
 * Review that all the jars are under the node "Classpath"
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SetupTest {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://google.com");

        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        if (driver.getPageSource().contains("Google")) {
                System.out.println("Pass");
        } else {
                System.out.println("Fail");
        }
        driver.quit();

	}

}
