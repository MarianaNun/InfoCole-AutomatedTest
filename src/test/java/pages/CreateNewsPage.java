package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import models.NewsClass;

public class CreateNewsPage extends BasePage {
	
	@FindBy(id="Titulo")
	private WebElement titleArea;
	
	@FindBy(id= "Descripcion")
	private WebElement descriptionArea;
	
	@FindBy(id= "LinkNoticia")
	private WebElement linkNoticiaArea;
	
	@FindBy(id= "LinkImagen")
	private WebElement linkImagenArea;
	
	@FindBy(xpath= "//div[@class='col-md-offset-2 col-md-10']/input")
	private WebElement buttonAgregar;
	
	@FindBy(partialLinkText= "VOLVER")
	private WebElement buttonVolver;
	
	public CreateNewsPage(WebDriver driver) {
		super(driver);
	}
	
	public void fillTitle(String title){
		this.titleArea.sendKeys(title);
	}
	
	public void fillDescription(String description){
		this.descriptionArea.sendKeys(description);
	}
	
	public void fillLinkNoticia(String link){
		this.linkNoticiaArea.sendKeys(link);
	}
	
	public void fillLinkImagen(String link){
		this.linkImagenArea.sendKeys(link);
	}
	
	public NewsPage createNews(NewsClass news, WebDriver driver) {
		fillTitle(news.getTitulo());
		fillDescription(news.getDescripcion());
		fillLinkNoticia(news.getLinkNoticia());
		fillLinkImagen(news.getLinkImagen());
		buttonAgregar.click();
		return new NewsPage(driver);
	}

}

