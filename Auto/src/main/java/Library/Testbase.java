package Library;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Testbase {

	public static WebDriver driver;
	public static Properties config=new Properties();
	public static FileInputStream fis;


	@BeforeMethod
	public void setup() throws IOException {
		
		if(driver==null) {
		
		fis=new FileInputStream("/Users/narendra/eclipse-workspace/Auto/src/main/java/Config.properties");
		config.load(fis);
		
		}
		if(config.getProperty("browser").equalsIgnoreCase("safari")) {
			//System.setProperty("webdriver.gecko.driver","firefox.exe");
			driver=new SafariDriver();
		}
			else if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","/Users/narendra/Downloads/chromedriver 18");
				driver=new ChromeDriver();
	}
		driver.get(config.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implict.wait")),TimeUnit.SECONDS);
	}
	
	
	public void findElementAndSendKeys(String element,String locators,String word) {
		
		if(locators.equalsIgnoreCase("xpath")) {
		
			WebElement ele=driver.findElement(By.xpath(element));
			ele.sendKeys(word);
			ele.sendKeys(Keys.ENTER);
		}
			else if(locators.equalsIgnoreCase("css")) {
				WebElement ele=driver.findElement(By.cssSelector(element));
				ele.sendKeys(word);
				ele.sendKeys(Keys.ENTER);
		}
			else if(locators.equalsIgnoreCase("id")) {
				WebElement ele=driver.findElement(By.id(element));
				ele.sendKeys(word);
				ele.sendKeys(Keys.ENTER);
		}
			else if(locators.equalsIgnoreCase("classname")) {
				WebElement ele=driver.findElement(By.className(element));
				ele.sendKeys(word);
				ele.sendKeys(Keys.ENTER);
		}
			else if(locators.equalsIgnoreCase("linktext")) {
				WebElement ele=driver.findElement(By.linkText(element));
				ele.sendKeys(word);
				ele.sendKeys(Keys.ENTER);
		}
			else if(locators.equalsIgnoreCase("name")) {
				WebElement ele=driver.findElement(By.name(element));
				ele.sendKeys(word);
				ele.sendKeys(Keys.ENTER);
		}
			else if(locators.equalsIgnoreCase("partiallinktext")) {
				WebElement ele=driver.findElement(By.partialLinkText(element));
				ele.sendKeys(word);
				ele.sendKeys(Keys.ENTER);
		
			}	
		
			else if(locators.equalsIgnoreCase("tagname")) {
				WebElement ele=driver.findElement(By.tagName(element));
				ele.sendKeys(word);
				ele.sendKeys(Keys.ENTER);
			}
	}
	
     public void FindElementAndClick(String locators,String element) {
    	 
    	 if(locators.equalsIgnoreCase("xpath")) {
    			
 			WebElement ele=driver.findElement(By.xpath(element));
 			ele.click();
 		}
 			else if(locators.equalsIgnoreCase("css")) {
 				WebElement ele=driver.findElement(By.cssSelector(element));
 				ele.click();
 			}
 			else if(locators.equalsIgnoreCase("id")) {
 				WebElement ele=driver.findElement(By.id(element));
 				ele.click();
 		}
 			else if(locators.equalsIgnoreCase("classname")) {
 				WebElement ele=driver.findElement(By.className(element));
 				ele.click();
 		}
 			else if(locators.equalsIgnoreCase("linktext")) {
 				WebElement ele=driver.findElement(By.linkText(element));
 				ele.click();
 		}
 			else if(locators.equalsIgnoreCase("name")) {
 				WebElement ele=driver.findElement(By.name(element));
 				ele.click();
 		}
 			else if(locators.equalsIgnoreCase("partiallinktext")) {
 				WebElement ele=driver.findElement(By.partialLinkText(element));
 				ele.click();
 			}	
 		
 			else if(locators.equalsIgnoreCase("tagname")) {
 				WebElement ele=driver.findElement(By.tagName(element));
 				ele.click();
 			}
     }
    	 
    	 public String FindElementAndGetText(String locators,String element) {
        	 
        	 if(locators.equalsIgnoreCase("xpath")) {
        			
        		  //return driver.findElement(By.xpath(element)).getText();
     			WebElement ele=driver.findElement(By.xpath(element));
     			return ele.getText();
     			
     		}
     			else if(locators.equalsIgnoreCase("css")) {
     				WebElement ele=driver.findElement(By.cssSelector(element));
     				return ele.getText();
     			}
     			else if(locators.equalsIgnoreCase("id")) {
     				WebElement ele=driver.findElement(By.id(element));
     				return ele.getText();
     		}
     			else if(locators.equalsIgnoreCase("classname")) {
     				WebElement ele=driver.findElement(By.className(element));
     				return ele.getText();
     		}
     			else if(locators.equalsIgnoreCase("linktext")) {
     				WebElement ele=driver.findElement(By.linkText(element));
     				return ele.getText();
     		}
     			else if(locators.equalsIgnoreCase("name")) {
     				WebElement ele=driver.findElement(By.name(element));
     				return ele.getText();
     		}
     			else if(locators.equalsIgnoreCase("partiallinktext")) {
     				WebElement ele=driver.findElement(By.partialLinkText(element));
     				return ele.getText();
     			}	
     		
     			else if(locators.equalsIgnoreCase("tagname")) {
     				WebElement ele=driver.findElement(By.tagName(element));
     				return ele.getText();
     			}
			return element;
		
    	 
    	 
    	 
    	 
     }
	
	
	
	//Webelements start from here.............
	
	public static String searchbtn="//input[@type='text']";
	
	
	public static String Textassert1="//*[@id='kp-wp-tab-overview']/div[1]/div/div/div/div/div[2]/div/div/div/span[2]/a";
	////*[@id="mh_tsuid203"]/div/div/div[2]/h2/span
	public static String Textassert2="//*[@id='topstuff']/div/div/ul/li[1]";
	
	
	
	@AfterMethod
	public void quit() {
		
		
		driver.quit();
	}
	
}





