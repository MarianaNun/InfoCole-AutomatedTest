package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListUserPage extends BasePage {
	
	
	@FindBy(xpath="//tr[2]/td[4]/a")
	private WebElement buttonDeshabilitar;
	
	@FindBy(xpath="//tr[2]/td[3]/input")
	private WebElement stateChecbox;
	
	public ListUserPage(WebDriver driver) {
		super(driver);
	}
	
	public ListUserPage disableUser(WebDriver driver) {
		buttonDeshabilitar.click();
		return new ListUserPage(driver);
	}
	
	public boolean getUserState() {
		return stateChecbox.isSelected();
	}

}

