package webScraper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class TokopediaWebScraper {
	
	public static void main(String[] args) throws IOException {
		String category = "handphone-tablet";
		WebDriver driver;
		DesiredCapabilities cap;
		
		cap = new DesiredCapabilities();
		cap.setJavascriptEnabled(true);
		cap.setCapability("takeScreenShot", false);
		driver = new PhantomJSDriver(cap);
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.tokopedia.com/p/" + category + "/handphone");
		System.out.println(String.format("\nRetreiving details for %s...", category));
		
		int pages = 5;
		int itemPerPage = 20;
		
		String fileText = "Name of Product, Description, Image Link, Price, Rating(out of 5 stars),Name of store or merchant";
		for (int pageCount = 0; pageCount < pages; pageCount++) {
			
		}
		
		
	}

}
