package infoColeTest;

import static org.testng.Assert.assertEquals;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import models.CommentClass;
import models.NewsClass;
import models.UserClass;
import pages.CommentsPage;
import pages.CreateAccountPage;
import pages.CreateNewsPage;
import pages.DeleteCommentPage;
import pages.DeleteNewsPage;
import pages.DetailNewsPage;
import pages.EditCommentPage;
import pages.EditNewsPage;
import pages.HomePage;
import pages.ListUserPage;
import pages.LoginPage;
import pages.NewsPage;

public class ComentarioTest extends BaseTest {
	
	String userName= "usuario"+RandomStringUtils.randomAlphanumeric(4);
	String cuenta = userName+"@gmail.com";
	UserClass usuario = new UserClass(cuenta, userName, "Usuario1!");
	
	UserClass admin = new UserClass("sebastianbazterrica@outlook.com", "sebastianbazterrica@outlook.com", "#Abc123" );
	
	String contenido= userName +" comentario de prueba";
	CommentClass comentario= new CommentClass(false, contenido);

	CommentClass comentarioEdited= new CommentClass(true, contenido+" Editado");	
	
	String descripcion= "Noticia de prueba "+RandomStringUtils.randomAlphanumeric(10);
	NewsClass noticia= new NewsClass("Noticia de prueba",descripcion, "linkdenoticiadeprueba.com", "linkdenoticiadeprueba.com");
	
	String edicion= "Edicion de noticia de prueba "+RandomStringUtils.randomAlphanumeric(10);
	NewsClass noticia2= new NewsClass("Noticia de prueba EDITED",edicion, "linkdenoticiadepruebaEDITED", "linkdenoticiadepruebaEDITED");
	
	
	//CASO DE PRUEBA: 
	@Test
	public void authenticationUser(){
		
		HomePage homePage= new HomePage(driver);		
		CreateAccountPage createAccountPage = homePage.clickSignIn(driver);
		HomePage successfulPage= createAccountPage.createAccount(usuario, driver);
		assertEquals(successfulPage.getInitHeadingText(), "Hola "+usuario.getUserName()+"!");
		HomePage closeSessionPage= successfulPage.clickSignOff(driver);
		assertEquals(closeSessionPage.getClosedSessionHeadingText(), "Registrarse");
	}
	
	//CASO DE PRUEBA:	
	@Test
	public void authenticationUserWithoutUserName(){
		
		HomePage homePage= new HomePage(driver);
		CreateAccountPage createAccountPage = homePage.clickSignIn(driver);
		CreateAccountPage errorMessagePage= createAccountPage.emptyFieldUserName(usuario, driver);
		assertEquals(errorMessagePage.getErrorMessage(), "El campo Nombre de Usuario es obligatorio.");
	}
	
	//CASO DE PRUEBA:	
	@Test
	public void authenticationUserWithoutEmail(){
		
		HomePage homePage= new HomePage(driver);
		CreateAccountPage createAccountPage = homePage.clickSignIn(driver);
		CreateAccountPage errorMessagePage= createAccountPage.emptyFieldEmail(usuario, driver);
		assertEquals(errorMessagePage.getErrorMessage(), "El campo Correo electrónico es obligatorio.");
	}

	//CASO DE PRUEBA:	
	@Test(dependsOnMethods = { "authenticationUser" })
	public void createComments() {
		
		HomePage homePage= new HomePage(driver);
		LoginPage loginPage= homePage.clickLogin(driver);
		HomePage sucessfulLoginPage = loginPage.login(usuario, driver);
		assertEquals(sucessfulLoginPage.getInitHeadingText(), "Hola "+usuario.getUserName()+"!");
		CommentsPage commentsPage = sucessfulLoginPage.clickCommunityButton(driver);
		CommentsPage commentCreatedPage = commentsPage.createComment(comentario, driver);
		assertEquals(commentCreatedPage.getLastComment(), comentario.getComentario());
	}

	//CASO DE PRUEBA:	
	@Test(dependsOnMethods= {"createComments"})
	public void editComment() {
		
		HomePage homePage= new HomePage(driver);
		LoginPage loginPage= homePage.clickLogin(driver);
		HomePage sucessfulLoginPage = loginPage.login(usuario, driver);
		assertEquals(sucessfulLoginPage.getInitHeadingText(), "Hola "+usuario.getUserName()+"!");
		CommentsPage commentsPage = sucessfulLoginPage.clickCommunityButton(driver);
		EditCommentPage editPage = commentsPage.clickEditButton(driver);
		CommentsPage commentEditedPage = editPage.editComment(comentarioEdited, driver);
		assertEquals(commentEditedPage.getLastComment(), comentarioEdited.getComentario());
	}

	//CASO DE PRUEBA:	
	@Test(dependsOnMethods= {"createComments"})
	public void deleteComment(){
		
		HomePage homePage= new HomePage(driver);
		LoginPage loginPage= homePage.clickLogin(driver);
		HomePage sucessfulLoginPage = loginPage.login(usuario, driver);
		assertEquals(sucessfulLoginPage.getInitHeadingText(), "Hola "+usuario.getUserName()+"!");
		CommentsPage commentsPage = sucessfulLoginPage.clickCommunityButton(driver);
		DeleteCommentPage deletePage = commentsPage.clickDeleteButton(driver);
		assertEquals(deletePage.getContent(), comentarioEdited.getComentario());
		CommentsPage commentDeletedPage = deletePage.deleteComment(driver);
		assertEquals(commentDeletedPage.getHeadingText(), "De lo que se está hablando");
	}
	
	//CASO DE PRUEBA:	
	@Test
	public void authenticationAdmin() {
		
		HomePage homePage= new HomePage(driver);
		LoginPage loginPage= homePage.clickLogin(driver);
		HomePage sucessfulLoginPage = loginPage.login(admin, driver);
		assertEquals(sucessfulLoginPage.getInitHeadingText(), "Hola "+admin.getUserName()+"!");
		HomePage closeSessionPage= sucessfulLoginPage.clickSignOff(driver);
		assertEquals(closeSessionPage.getClosedSessionHeadingText(), "Registrarse");
	}
	
	//CASO DE PRUEBA:
	@Test(dependsOnMethods = {"authenticationAdmin"})
	public void deleteUser() {
		
		HomePage homePage= new HomePage(driver);
		LoginPage loginPage= homePage.clickLogin(driver);
		HomePage sucessfulLoginPage = loginPage.login(admin, driver);
		ListUserPage userPage = sucessfulLoginPage.clickUsersButton(driver);
		boolean state = userPage.getUserState();
		ListUserPage disableUser = userPage.disableUser(driver);
		assertEquals(disableUser.getUserState(), !state);
	}
	
	//CASO DE PRUEBA:	
	@Test(dependsOnMethods = {"authenticationAdmin"})
	public void createNews() {
		
		HomePage homePage= new HomePage(driver);
		LoginPage loginPage= homePage.clickLogin(driver);
		HomePage sucessfulLoginPage = loginPage.login(admin, driver);
		NewsPage newsPage = sucessfulLoginPage.clickNewsButton(driver);
		CreateNewsPage createNewsPage = newsPage.clickCreateNewsButton(driver);
		NewsPage newsCreatedPage = createNewsPage.createNews(noticia, driver);
		assertEquals(newsCreatedPage.getMessage(), "LA NOTICIA SE CREO CON EXITO");
		
		DetailNewsPage detailNewsPage = newsCreatedPage.clickDetailNewsButton(driver);
		assertEquals(detailNewsPage.getNewsDetails().getTitulo(), noticia.getTitulo());
		assertEquals(detailNewsPage.getNewsDetails().getDescripcion(), noticia.getDescripcion());
		assertEquals(detailNewsPage.getNewsDetails().getLinkNoticia(), noticia.getLinkNoticia());
		assertEquals(detailNewsPage.getNewsDetails().getLinkImagen(), noticia.getLinkImagen());
	}
	
	//CASO DE PRUEBA:	
	@Test(enabled = true, dependsOnMethods = {"createNews"})
	public void editNews() {
		
		HomePage homePage= new HomePage(driver);
		LoginPage loginPage= homePage.clickLogin(driver);
		HomePage sucessfulLoginPage = loginPage.login(admin, driver);
		
		NewsPage newsPage = sucessfulLoginPage.clickNewsButton(driver);
		EditNewsPage editPage = newsPage.clickEditNewsButton(driver);
		NewsPage newsEditedPage = editPage.editNews(noticia2, driver);
		assertEquals(newsEditedPage.getMessage(), "LA NOTICIA SE EDITO CON EXITO");
		
		DetailNewsPage detailNewsPage = newsEditedPage.clickDetailNewsButton(driver);
		assertEquals(detailNewsPage.getNewsDetails().getTitulo(), noticia2.getTitulo());
		assertEquals(detailNewsPage.getNewsDetails().getDescripcion(), noticia2.getDescripcion());
		assertEquals(detailNewsPage.getNewsDetails().getLinkNoticia(), noticia2.getLinkNoticia());
		assertEquals(detailNewsPage.getNewsDetails().getLinkImagen(), noticia2.getLinkImagen());
		
		NewsPage returnNewsPage= detailNewsPage.clickBackButton(driver);
		DeleteNewsPage deleteNewsPage = returnNewsPage.clickDeleteNewsButton(driver);
		assertEquals(deleteNewsPage.getNewsDetails().getTitulo(), noticia2.getTitulo());
		assertEquals(deleteNewsPage.getNewsDetails().getDescripcion(), noticia2.getDescripcion());
		assertEquals(deleteNewsPage.getNewsDetails().getLinkNoticia(), noticia2.getLinkNoticia());
		assertEquals(deleteNewsPage.getNewsDetails().getLinkImagen(), noticia2.getLinkImagen());
		
		NewsPage newsDeletedPage = deleteNewsPage.deleteNews(driver);
		assertEquals(newsDeletedPage.getMessage(), "LA NOTICIA SE ELIMINO CON EXITO");
	}
	
}
