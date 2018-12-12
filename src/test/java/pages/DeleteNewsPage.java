package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import models.NewsClass;

public class DeleteNewsPage extends BasePage {
	
	@FindBy(xpath= "//dd[1]")
	private WebElement title;
	
	@FindBy(xpath= "//dd[2]")
	private WebElement content;
	
	@FindBy(xpath= "//dd[3]")
	private WebElement linkNoticia;
	
	@FindBy(xpath= "//dd[4]")
	private WebElement linkImagen;
	
	@FindBy(xpath ="//input[@class='btn btn-default']")
	private WebElement buttonEliminar;
	
	public DeleteNewsPage(WebDriver driver) {
		super(driver);
	}
	
	public NewsClass getNewsDetails() {
		NewsClass noticia= new NewsClass(title.getText(), content.getText(), linkNoticia.getText(), linkImagen.getText());
		return noticia;
	}
	
	public NewsPage deleteNews(WebDriver driver) {
		buttonEliminar.click();
		return new NewsPage(driver);
	}
}

