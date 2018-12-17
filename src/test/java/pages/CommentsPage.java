package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import models.CommentClass;

public class CommentsPage extends BasePage {
	
	@FindBy(partialLinkText="Crear")
	private WebElement buttonCrear;
	
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
	
	@FindBy(xpath = "//div[@class='container body-content']/ul[2]/div/div[@class='comment-box']/div[@class='comment-content']")
	private WebElement contenido;
	
	@FindBy(xpath = "//div[@class='container body-content']/ul[2]/div/div[@class='comment-box']/div[@class='comment-head']/div/span[1]")
	private WebElement buttonEditar;
	
	@FindBy(xpath = "//div[@class='container body-content']/ul[2]/div/div[@class='comment-box']/div[@class='comment-head']/div/span[2]")
	private WebElement buttonEliminar;
	
	@FindBy(xpath="//h4[1]")
	private WebElement pageTitle;
	
	public CommentsPage(WebDriver driver) {
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
		this.content.sendKeys(content);
	}
	
	public CommentsPage createComment(CommentClass comment, WebDriver driver) {
		//EXITE OTRA FORMA DE SCROLLEAR LA PAGINA O ESTA BIEN ASI?
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonCreate);
		buttonCrear.click();
		isElementPresent(5, this.modalWindowHeader);
		selectType(comment.isTipo());
		fillContent(comment.getComentario());
		buttonSubmit.click();
		return new CommentsPage(driver);
	}
	
	public String getLastComment() {
		//CAUL ES LA MANERA CORRECTA DE ESPERAR QUE LA PAGINA RECARGUE
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.navigate().refresh();
		//isElementPresent(5, this.pageTitle);
		return contenido.getText();
	}
	
	public DeleteCommentPage clickDeleteButton(WebDriver driver) {
		buttonEliminar.click();
		return new DeleteCommentPage(driver);
	}
	
	public EditCommentPage clickEditButton(WebDriver driver) {
		buttonEditar.click();
		return new EditCommentPage(driver);
	}
	
	public String getHeadingText() {
		return pageTitle.getText();
	}
}