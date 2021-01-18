package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Finish {
	//Props
	private WebDriver driver;
	//locators 
	@FindBy(id ="fackBook2")WebElement shareBTN;
	@FindBy(xpath="//button[@onclick=\"open(location, '_self').close();\"]")WebElement quitBTN;
	@FindBy(xpath="//button[@onclick=\"playScreen()\"and contains(text(),'Try again')]")WebElement tryAgainBTN;
	@FindBy(id="mark")WebElement finalScore;
	//Constructor
	public Finish (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Functions 
	public boolean result(String a) {
		finalScore.getText().equals("a");
		return true;
	}
	public boolean clickTryagain() {
		try {
			tryAgainBTN.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean closeThegame() {
		try {
			quitBTN.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean shareOnfacebook() {
		try {
			shareBTN.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
