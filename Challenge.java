package wikipedia;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Challenge {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:/Users/kogul_s/Downloads/jar/geckodriver.exe");

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);

		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("marionette", false);
		
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://en.wikipedia.org/wiki/Selenium");
		driver.manage().window().maximize();
		
		Links.verifyExternalLinks(driver);
		
		driver.findElement(By.xpath("//a[@href='/wiki/Oxygen']")).click();
		
		Oxygen.checkFeatured(driver);
		
		Oxygen.screenshot(driver);
		
		Oxygen.countPDFlinks(driver);
		
		Oxygen.checkSuggestion(driver);	
	}	
}
