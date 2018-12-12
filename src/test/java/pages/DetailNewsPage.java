package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import models.NewsClass;

public class DetailNewsPage extends BasePage{
	
	@FindBy(xpath= "//dd[1]")
	private WebElement title;
	
	@FindBy(xpath= "//dd[2]")
	private WebElement content;
	
	@FindBy(xpath= "//dd[3]")
	private WebElement FechaPublicacion;	
	
	@FindBy(xpath= "//dd[4]")
	private WebElement linkNoticia;
	
	@FindBy(xpath= "//dd[4]")
	private WebElement linkImagen;
	
	@FindBy(partialLinkText="VOLVER")
	private WebElement backButton;
	
	public DetailNewsPage(WebDriver driver) {
		super(driver);
	}
	
	public NewsClass getNewsDetails() {
		NewsClass noticia= new NewsClass(title.getText(), content.getText(),  linkNoticia.getText(), linkImagen.getText());
		return noticia;
	}
	
	public NewsPage clickBackButton(WebDriver driver) {
		backButton.click();
		return new NewsPage(driver);
	}

}

