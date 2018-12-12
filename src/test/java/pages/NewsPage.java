package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsPage extends BasePage{
	
	@FindBy(partialLinkText="NUEVA")
	private WebElement buttonNueva;
	
	@FindBy(xpath= "//tr[2]/td[3]/a[1]")
	private WebElement buttonEditar;
	
	@FindBy(xpath= "//tr[2]/td[3]/a[2]")
	private WebElement buttonDetalle;
	
	@FindBy(xpath= "//tr[2]/td[3]/a[3]")
	private WebElement buttonEliminar;
	
	@FindBy(xpath= "//div[@class='alert alert-success alert-dismissible elements']/h4")
	private WebElement alertMessage;
	
	public NewsPage(WebDriver driver) {
		super(driver);
	}
	
	public CreateNewsPage clickCreateNewsButton(WebDriver drive) {
		buttonNueva.click();
		return new CreateNewsPage(drive);
	}
	
	public DetailNewsPage clickDetailNewsButton(WebDriver drive) {
		buttonDetalle.click();
		return new DetailNewsPage(drive);
	}
	
	public EditNewsPage clickEditNewsButton(WebDriver drive) {
		buttonEditar.click();
		return new EditNewsPage(drive);
	}
	
	public DeleteNewsPage clickDeleteNewsButton(WebDriver drive) {
		buttonEliminar.click();
		return new DeleteNewsPage(drive);
	}
	
	public String getMessage() {
		return alertMessage.getText();
	}

}

