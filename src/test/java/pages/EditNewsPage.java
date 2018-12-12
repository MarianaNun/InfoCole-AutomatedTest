package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import models.NewsClass;

public class EditNewsPage extends BasePage {
	
	@FindBy(id= "Titulo")
	private WebElement title;
	
	@FindBy(id= "Descripcion")
	private WebElement content;
	
	@FindBy(id= "LinkNoticia")
	private WebElement linkNoticia;
	
	@FindBy(id= "LinkImagen")
	private WebElement linkImagen;
	
	@FindBy(xpath= "//div[@class='col-md-offset-2 col-md-10']/input")
	private WebElement buttonGuardar;
	
	public EditNewsPage(WebDriver driver) {
		super(driver);
	}
	
	public void fillTitle(String title){
		isElementPresent(5, this.title);
		this.title.clear();
		this.title.sendKeys(title);
	}
	
	public void fillDescription(String content){
		this.content.clear();
		this.content.sendKeys(content);
	}
	
	public void fillLinkNoticia(String linkNoticia){
		this.linkNoticia.clear();
		this.linkNoticia.sendKeys(linkNoticia);
	}
	
	public void fillLinkImagen(String linkImagen){
		this.linkImagen.clear();
		this.linkImagen.sendKeys(linkImagen);
	}
	
	public NewsPage editNews(NewsClass news, WebDriver driver) {
		fillTitle(news.getTitulo());
		fillDescription(news.getDescripcion());
		fillLinkNoticia(news.getLinkNoticia());
		fillLinkImagen(news.getLinkImagen());
		buttonGuardar.click();
		return new NewsPage(driver);
	}

}

