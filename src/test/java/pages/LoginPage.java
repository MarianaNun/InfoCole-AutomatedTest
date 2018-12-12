package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import models.UserClass;

public class LoginPage extends BasePage {
	
	@FindBy(id ="Email")
	private WebElement Email;
	
	@FindBy(id ="Password")
	private WebElement Password;
	
	@FindBy(id= "RememberMe")
	private WebElement rememberMe;
	
	@FindBy(id = "IniciarSesion")
	private WebElement buttonIniciarSesion;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void fillEmail(String email){
		isElementPresent(5, this.Email);
		this.Email.sendKeys(email);
	}
	
	public void fillPassword(String password){
		this.Password.sendKeys(password);
	}
	
	public HomePage login(UserClass usuario, WebDriver driver) {
		fillEmail(usuario.getEmail());
		fillPassword(usuario.getPassword());
		buttonIniciarSesion.click();
		return new HomePage(driver);
	}
	
}