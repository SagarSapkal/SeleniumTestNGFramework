package BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	
	private ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();
	private String browser;
	
	public WebDriverFactory(String browser) {
		this.browser = browser.toLowerCase();
	}

	public WebDriver Createdriver() {
		
		  String bw = browser.toLowerCase();
		  
		  
		  switch(bw){
			  
		case "chrome":
			  WebDriverManager.chromedriver().setup(); 
			  drivers.set(new ChromeDriver());
			
			  break;
		case "edge":
			  WebDriverManager.edgedriver().setup(); 
			  drivers.set(new EdgeDriver());
			  
			  break; 
		default:
			  WebDriverManager.chromedriver().setup(); 
			  drivers.set(new ChromeDriver());

			}
	return drivers.get();
	
	  
	}
}