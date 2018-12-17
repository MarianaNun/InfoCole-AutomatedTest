package infoColeTest;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeSuite
	public void getDriver(){
		System.out.println("Gettting browser driver.");
		ChromeDriverManager.getInstance().forceCache().setup();
		FirefoxDriverManager.getInstance().setup();
	}

	@BeforeMethod(enabled= false)
	public void abrirNavegador(){
		System.out.println("Opening browser.");
		System.setProperty("webdriver.gecko.driver","D:\\Firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://localhost:44349/");
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void openBrowser(String browser) throws Exception{
		if(StringUtils.isBlank(browser)) {
			browser= "Chrome";
		}
		System.out.println("Opening "+browser+" browser.");
		if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\Firefox\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://localhost:44349/");	
		}
		else if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://localhost:44349/");
		}else{
			throw new Exception("Browser is not correct");
		}
	}
	
	@AfterMethod
	public void cerrarNavegador(){
		System.out.println("Closing browser.");
		if(null != driver){
    		driver.quit();
    	}
	}

}
