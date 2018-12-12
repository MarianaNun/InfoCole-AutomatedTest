package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	@FindBy(name="Registrarse")
	private WebElement buttonRegistrarse;
	
	@FindBy(partialLinkText="Iniciar")
	private WebElement buttonIniciarSesion;
	
	@FindBy(partialLinkText="Cerrar")
	private WebElement buttonCerrarSesion;
	
	@FindBy(xpath ="//div[@id='login']/ul/li/a")
	private WebElement heading;
	
	@FindBy(linkText ="Comunidad")
	private WebElement buttonComunidad;
	
	@FindBy(linkText="Usuarios")
	private WebElement buttonUsuarios;
	
	@FindBy(linkText="Noticias")
	private WebElement buttonNoticias;
	
	public HomePage (WebDriver driver) {
		super(driver);
	}
	
	public CreateAccountPage clickSignIn(WebDriver driver) {
		buttonRegistrarse.click();
		return new CreateAccountPage(driver);
	}
	
	public String getInitHeadingText() {
		return heading.getText();
	}
		
	public HomePage clickSignOff(WebDriver driver)  {
		isElementPresent(5, this.buttonCerrarSesion);
		buttonCerrarSesion.click();
		return new HomePage(driver);
	}
	
	public String getClosedSessionHeadingText() {
		return buttonRegistrarse.getText();
	}
	
	public LoginPage clickLogin(WebDriver driver) {
		buttonIniciarSesion.click();
		return new LoginPage(driver);
	}
	
	public CommentsPage clickCommunityButton(WebDriver driver) {
		buttonComunidad.click();
		return new CommentsPage(driver);
	}
	
	public ListUserPage clickUsersButton(WebDriver driver) {
		buttonUsuarios.click();
		return new ListUserPage(driver);
	}
	public NewsPage clickNewsButton(WebDriver driver) {
		buttonNoticias.click();
		return new NewsPage(driver);
	}
}

