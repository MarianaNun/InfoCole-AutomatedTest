package infoColeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeSuite
	public void getDriver(){
		System.out.println("Gettting browser driver.");
		ChromeDriverManager.getInstance().forceCache().setup();
	}

	@BeforeMethod
	public void abrirNavegador(){
		System.out.println("Opening browser.");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://localhost:44349/");
	}
	
	@AfterMethod
	public void cerrarNavegador(){
		System.out.println("Closing browser.");
		if(null != driver){
    		driver.quit();
    	}
	}

}
