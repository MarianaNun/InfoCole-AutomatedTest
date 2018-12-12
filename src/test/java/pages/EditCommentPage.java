package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import models.CommentClass;

public class EditCommentPage extends BasePage {
	
	@FindBy(id="exampleModalLabel")
	private WebElement modalWindowHeader;
	
	@FindBy(id="Tipo")
	private WebElement radioButton1;
	
	@FindBy(id="Tipo")
	private WebElement radioButton2;
	
	@FindBy(id="Contenido")
	private WebElement content;
	
	@FindBy(id="btnSubmit")
	private WebElement buttonSubmit;
	
	public EditCommentPage(WebDriver driver) {
		super(driver);		
	}
	
	public void selectType(boolean tipo){
		if(tipo) {
			this.radioButton1.click();
		}
		else {
			this.radioButton2.click();
		}
	}
	
	public void fillContent(String content){
		this.content.clear();
		this.content.sendKeys(content);
	}
	
	public CommentsPage editComment(CommentClass comment, WebDriver driver) {
		isElementPresent(5, this.modalWindowHeader);
		selectType(comment.isTipo());
		fillContent(comment.getComentario());
		buttonSubmit.click();
		return new CommentsPage(driver);
	}

}
