package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import models.UserClass;


public class CreateAccountPage extends BasePage{
	@FindBy(id="Email")
	private WebElement email;
	
	@FindBy(id="UserName")
	private WebElement userName;
	
	@FindBy(id = "Password")
	private WebElement password;
	
	@FindBy(id= "ConfirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(xpath= "//div[@class= 'validation-summary-errors']/ul/li")
	private WebElement errorMessage;
	
	@FindBy(id = "submitAccount")
	private WebElement submitButton;
	
	public void fillEmail(String email){
		isElementPresent(5, this.email);
		this.email.sendKeys(email);
	}
	
	public void fillUserName(String userName){
		this.userName.sendKeys(userName);
	}
	
	public void fillPassword(String password){
		this.password.sendKeys(password);
	}
	
	public void fillConfirmPassword(String password){
		this.confirmPassword.sendKeys(password);
	}
	
	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage createAccount(UserClass usuario, WebDriver driver) {
		fillEmail(usuario.getEmail());
		fillUserName(usuario.getUserName() );
		fillPassword(usuario.getPassword());
		fillConfirmPassword(usuario.getPassword());
		submitButton.click();
		return new HomePage(driver);
	}
	
	public CreateAccountPage emptyFieldUserName(UserClass usuario, WebDriver driver) {
		fillEmail(usuario.getEmail());
		fillPassword(usuario.getPassword());
		fillConfirmPassword(usuario.getPassword());
		submitButton.click();
		return new CreateAccountPage(driver);
	}
	
	public CreateAccountPage emptyFieldEmail(UserClass usuario, WebDriver driver) {
		fillUserName(usuario.getUserName() );
		fillPassword(usuario.getPassword());
		fillConfirmPassword(usuario.getPassword());
		submitButton.click();
		return new CreateAccountPage(driver);
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}

}

