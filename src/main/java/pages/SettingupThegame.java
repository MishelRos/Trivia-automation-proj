package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingupThegame {
	//Props
	private WebDriver driver;
	//locators 
	@FindBy(xpath="//button[contains(text(),'Start')]")WebElement startBTN;
	@FindBy(xpath="//input[@placeholder ='Type here your question?']")WebElement Q;
	@FindBy(xpath="//button[@onclick ='navigate(1)' and contains(text(),'next')]")WebElement next_q_BTN;
	@FindBy(xpath="//button[@onclick ='navigate(0)' and contains(text(),'Back')]")WebElement goBackBTN;
	@FindBy(xpath="//input[@placeholder ='first answer']")WebElement firstA;
	@FindBy(xpath="//*[@id=\"answers\"]/div[1]/div[1]/input")WebElement firstRadioBTN;
	@FindBy(xpath="//input[@placeholder ='seconde answer']")WebElement secondA;
	@FindBy(xpath="//*[@id=\"answers\"]/div[2]/div[1]/input")WebElement secondRadioBTN;
	@FindBy(xpath="//input[@placeholder ='thierd answer']")WebElement thirdA;
	@FindBy(xpath="//*[@id=\"answers\"]/div[3]/div[1]/input")WebElement thirdRadioBTN;
	@FindBy(xpath="//input[@type ='text' and @placeholder='forth answer']")WebElement fourthA;
	@FindBy(xpath="//*[@id=\"answers\"]/div[4]/div[1]/input")WebElement fourthRadioBTN;
	//Constructor
	public SettingupThegame (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Functions 
	public boolean onlyQ(String q) {
		Q.sendKeys(q);
		return true;
	}
	public boolean QandA(String q,String A1,String A2,String A3,String A4) {
		Q.sendKeys(q);
		next_q_BTN.click();
		firstA.sendKeys(A1);
		secondA.sendKeys(A2);
		thirdA.sendKeys(A3);
		fourthA.sendKeys(A4);
		return true;
	}

	public boolean firstRadioBTN(String q,String A1,String A2,String A3,String A4) {
		Q.sendKeys(q);
		next_q_BTN.click();
		firstA.sendKeys(A1);
		secondA.sendKeys(A2);
		thirdA.sendKeys(A3);
		fourthA.sendKeys(A4);
		firstRadioBTN.click();
		return true;
	}
	public boolean secondRadioBTN(String q,String A1,String A2,String A3,String A4) {
		Q.sendKeys(q);
		next_q_BTN.click();
		firstA.sendKeys(A1);
		secondA.sendKeys(A2);
		thirdA.sendKeys(A3);
		fourthA.sendKeys(A4);
		secondRadioBTN.click();
		return true;
	}
	public boolean thirdRadioBTN(String q,String A1,String A2,String A3,String A4) {
		Q.sendKeys(q);
		next_q_BTN.click();
		firstA.sendKeys(A1);
		secondA.sendKeys(A2);
		thirdA.sendKeys(A3);
		fourthA.sendKeys(A4);
		thirdRadioBTN.click();
		return true;
	}

	public boolean fourthRadioBTN(String q,String A1,String A2,String A3,String A4) {
		Q.sendKeys(q);
		next_q_BTN.click();
		firstA.sendKeys(A1);
		secondA.sendKeys(A2);
		thirdA.sendKeys(A3);
		fourthA.sendKeys(A4);
		fourthRadioBTN.click();
		return true;
	}
	public boolean startThegame() {
		startBTN.click();
		return true;
	}
	public boolean previousQ() {
		try {
			goBackBTN.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean nextQ () {
		next_q_BTN.click();
		return true;
	}
}
