package wikipedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Links extends Challenge {
	public static void verifyExternalLinks(WebDriver driver) {

		WebElement link1 = driver.findElement(By.xpath("//a[@href='http://www.periodicvideos.com/videos/034.htm']"));
		if (link1.isEnabled())
			System.out.println("Link 1 is working");
		else
			System.out.println("Link 1 is not working");

		WebElement link2 = driver.findElement(By.xpath("//a[@href='http://ods.od.nih.gov/factsheets/selenium.asp']"));
		if (link2.isEnabled())
			System.out.println("Link 2 is working");
		else
			System.out.println("Link 2 is not working");

		WebElement link3 = driver
				.findElement(By.xpath("//a[@href='http://www.sas-centre.org/assays/trace_metals/selenium.html']"));
		if (link3.isEnabled())
			System.out.println("Link 3 is working");
		else
			System.out.println("Link 3 is not working");

		WebElement link4 = driver.findElement(By.xpath("//a[@href='http://www.atsdr.cdc.gov/toxprofiles/tp92.html']"));
		if (link4.isEnabled())
			System.out.println("Link 4 is working");
		else
			System.out.println("Link 4 is not working");

		WebElement link5 = driver.findElement(By.xpath("//a[@href='https://www.cdc.gov/niosh/npg/npgd0550.html']"));
		if (link5.isEnabled())
			System.out.println("Link 5 is working");
		else
			System.out.println("Link 5 is not working");

		WebElement link6 = driver
				.findElement(By.xpath("//a[@href='http://elements.vanderkrogt.net/element.php?sym=Se']"));
		if (link6.isEnabled())
			System.out.println("Link 6 is working");
		else
			System.out.println("Link 6 is not working");
	}

}
