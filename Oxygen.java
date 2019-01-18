package wikipedia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Oxygen extends Challenge {
	public static void checkFeatured(WebDriver driver) {
		String expected = "This is a featured article. Click here for more information.";
		WebElement featured = driver.findElement(By.xpath("//a[@href='/wiki/Wikipedia:Featured_articles']"));
		String actual = featured.getAttribute("title");

		if (actual.equals(expected))
			System.out.println("Yes Oxygen page is a featured article");
		else
			System.out.println("No Oxygen page is not a featured article");
	}
	
	public static void screenshot(WebDriver driver) throws IOException {
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		WebElement element=driver.findElement(By.tagName("table"));
		BufferedImage  fullImg = ImageIO.read(screenshot);
		
		Point point = element.getLocation();
		int eleWidth = element.getSize().getWidth();
		int eleHeight = element.getSize().getHeight();
		
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);
		File screenshotLocation = new File("C:\\Users\\karthikeyan_s\\Downloads\\screenshot.png");
		FileUtils.copyFile(screenshot, screenshotLocation);
	}

	public static void countPDFlinks(WebDriver driver) {
        List<WebElement> pdf=driver.findElements(By.xpath("//span[contains(text(),'(PDF)')]"));
        System.out.println("Total number of pdf links in citations = "+pdf.size());
	}
	
	public static void checkSuggestion(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("pluto");
		Thread.sleep(2000);
		String result=driver.findElement(By.xpath("//div[@class='suggestions-results']/a[2]")).getAttribute("title");
		if(result.equalsIgnoreCase("plutonium"))
			System.out.println("Yes The second suggestion is plutonium");
		else
			System.out.println("The second suggestion is not plutonium");
	}
}
