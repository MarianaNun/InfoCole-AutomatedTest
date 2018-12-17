package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteCommentPage extends BasePage {
	
	@FindBy(id="exampleModalLabel")
	private WebElement modalWindowHeader;
	
	@FindBy(xpath="//dl[@class='dl-horizontal']/dd[2]")
	private WebElement content;
	
	@FindBy(id= "cancelButton")
	private WebElement buttonCancelar;
	
	@FindBy(id= "deleteButton")
	private WebElement buttonEliminar;
	
	public DeleteCommentPage(WebDriver driver) {
		super(driver);
	}
	
	public String getContent() {
		isElementPresent(5, this.modalWindowHeader);
		return content.getText();
	}
	
	public CommentsPage deleteComment(WebDriver driver) {
		buttonEliminar.click();
		return new CommentsPage(driver);
	} 

}

