package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Finish;

public class Playing {
	//Props
	private WebDriver driver;
	//locators 
	@FindBy(xpath="//button[@onclick='playScreen()' and contains(text(),'Play')]")WebElement playBTN;
	@FindBy(xpath="//button[@onclick='quitBtn()' and contains(text(),'Quit')]")WebElement quitBTN;
	@FindBy(id="btnnext")WebElement nextBTN;
	@FindBy(id="btnback")WebElement backBTN;
	//first page
	@FindBy(xpath="//div[@id='2']//h3[@class='userdata']")WebElement firstQ;
	@FindBy(xpath="//*[@id=\"2\"]/input[1]")WebElement firstRadioBTN1;
	@FindBy(xpath="//*[@id=\"2\"]/input[2]")WebElement secondRadioBTN1;
	@FindBy(xpath="//*[@id=\"2\"]/input[3]")WebElement thirdRadioBTN1;
	@FindBy(xpath="//*[@id=\"2\"]/input[4]")WebElement fourthRadioBTN1;
	//Second page
	@FindBy(xpath="//div[@id='1']//h3[@class='userdata']")WebElement secondQ;
	@FindBy(xpath="//*[@id=\"1\"]/input[1]")WebElement firstRadioBTN2;
	@FindBy(xpath="//*[@id=\"1\"]/input[2]")WebElement secondRadioBTN2;
	@FindBy(xpath="//*[@id=\"1\"]/input[3]")WebElement thirdRadioBTN2;
	@FindBy(xpath="//*[@id=\"1\"]/input[4]")WebElement fourthRadioBTN2;
	//Third page
	@FindBy(xpath="//div[@id='0']//h3[@class='userdata']")WebElement thirdQ;
	@FindBy(xpath="//*[@id=\"0\"]/input[1]")WebElement firstRadioBTN3;
	@FindBy(xpath="//*[@id=\"0\"]/input[2]")WebElement secondRadioBTN3;
	@FindBy(xpath="//*[@id=\"0\"]/input[3]")WebElement thirdRadioBTN3;
	@FindBy(xpath="//*[@id=\"0\"]/input[4]")WebElement fourthRadioBTN3;

	//Constructor
	public Playing (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean algo(String a,String b, String c) {
		int counter = 0;
		Finish f = new Finish(driver);
		String [] Qarr = new String[9];
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;

		while (counter<3) {
			int i = 0;
			while (i < 3) {
				while (firstQ.isDisplayed()) {
					Qarr[i+(3*counter)]=firstQ.getText();
					i++;
					if (firstQ.getText().equals(a)) {
						firstRadioBTN1.click();
						nextBTN.click();
					}
					else if(firstQ.getText().equals(b)) {
						secondRadioBTN1.click();
						nextBTN.click();
					}
					else if (firstQ.getText().equals(c)) {
						thirdRadioBTN1.click();
						nextBTN.click();
					}
					else {
						fourthRadioBTN1.click();
						nextBTN.click();
					}
				}
				while (secondQ.isDisplayed()) {
					Qarr[i+(3*counter)]=secondQ.getText();
					i++;
					if (secondQ.getText().equals(a)) {
						firstRadioBTN2.click();
						nextBTN.click();
					}
					else if(secondQ.getText().equals(b)) {
						secondRadioBTN2.click();
						nextBTN.click();
					}
					else if (secondQ.getText().equals(c)) {
						thirdRadioBTN2.click();
						nextBTN.click();
					}
					else {
						fourthRadioBTN2.click();
						nextBTN.click();
					}
				}
				while (thirdQ.isDisplayed()) {
					Qarr[i+(3*counter)]=thirdQ.getText();
					i++;
					if (thirdQ.getText().equals(a)) {
						firstRadioBTN3.click();
						nextBTN.click();
					}
					else if(thirdQ.getText().equals(b)) {
						secondRadioBTN3.click();
						nextBTN.click();
					}
					else if (thirdQ.getText().equals(c)) {
						thirdRadioBTN3.click();
						nextBTN.click();
					}
					else {
						fourthRadioBTN3.click();
						nextBTN.click();
					}
				}

			}
			if(counter<2) {
				f.clickTryagain();}
			counter ++;

		}
		if (Qarr[0].equals(Qarr[3]) && Qarr[3].equals(Qarr[6])) {
			flag1 = true;
		}
		if (Qarr[1].equals(Qarr[4]) && Qarr[4].equals(Qarr[7])) {
			flag2 = true;
		}
		if (Qarr[2].equals(Qarr[5]) && Qarr[5].equals(Qarr[8])) {
			flag3 = true;
		}
		if (flag1==true && flag2==true && flag3==true) {
			return false;
		}
		return true;
	}
	//Functions 
	public boolean answerPage(String a,String b, String c) {
		while (firstQ.isDisplayed()) {
			if (firstQ.getText().equals(a)) {
				firstRadioBTN1.click();
				nextBTN.click();
			}
			else if(firstQ.getText().equals(b)) {
				secondRadioBTN1.click();
				nextBTN.click();
			}
			else if (firstQ.getText().equals(c)) {
				thirdRadioBTN1.click();
				nextBTN.click();
			}
			else {
				fourthRadioBTN1.click();
				nextBTN.click();
			}

		}
		while(secondQ.isDisplayed()) {
			if (secondQ.getText().equals(a)) {
				firstRadioBTN2.click();
				nextBTN.click();
			}
			else if(secondQ.getText().equals(b)) {
				secondRadioBTN2.click();
				nextBTN.click();
			}
			else if (secondQ.getText().equals(c)) {
				thirdRadioBTN2.click();
				nextBTN.click();
			}
			else {
				fourthRadioBTN2.click();
				nextBTN.click();
			}
		}
		while(thirdQ.isDisplayed()) {
			if (thirdQ.getText().equals(a)) {
				firstRadioBTN3.click();
				nextBTN.click();
			}
			else if(thirdQ.getText().equals(b)) {
				secondRadioBTN3.click();
				nextBTN.click();
			}
			else if (thirdQ.getText().equals(c)) {
				thirdRadioBTN3.click();
				nextBTN.click();
			}
			else {
				fourthRadioBTN2.click();
				nextBTN.click();
			}
		}
		return true;
	}
	public boolean previousQ() {
		try {
			backBTN.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean nextQ() {
		try {
			nextBTN.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean clickPlay() {
		playBTN.click();
		return true;
	}
	public boolean quitGame() {
		quitBTN.click();
		return true;
	}
}
