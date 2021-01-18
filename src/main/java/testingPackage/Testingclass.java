package testingPackage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SettingupThegame;
import pages.Finish;
import pages.Playing;

public class Testingclass {
	private WebDriver driver;
	private SettingupThegame SUTG;
	private Playing p;
	private Finish f;
	@BeforeMethod
	public void BeforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://shemsvcollege.github.io/Trivia/");
		driver.manage().window().maximize();
		SUTG = new SettingupThegame(driver);
		p = new Playing (driver);
		f = new Finish (driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("---New Test---");
	}
	@Test// Sanity
	public void sanity() {
		SUTG.startThegame();
		SUTG.firstRadioBTN("a", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.secondRadioBTN("b", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.thirdRadioBTN("c","1","2","3","4");
		SUTG.nextQ();
		p.clickPlay();
		p.answerPage("a","b","c");
		assertEquals(true, f.result("Sucsses"));
	}
	//Functionality
	@Test // Checking fourth radio button works.
	public void fourthRadioBTN() {
		SUTG.startThegame();
		SUTG.fourthRadioBTN("d", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.secondRadioBTN("b", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.thirdRadioBTN("c","1","2","3","4");
		SUTG.nextQ();
		p.clickPlay();
		p.answerPage("d","b","c");
		assertEquals(true, f.result("Sucsses"));
	}
	@Test // Checking to see Try again button works.
	public void tryAgainBTN() {
		SUTG.startThegame();
		SUTG.firstRadioBTN("a", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.secondRadioBTN("b", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.thirdRadioBTN("c","1","2","3","4");
		SUTG.nextQ();
		p.clickPlay();
		p.answerPage("a","b","c");
		f.clickTryagain();
		assertTrue(driver.getPageSource().contains("Test"));
	}
	@Test// Checking to see quit button after setting up the game works.
	public void quitFirstBTN() {
		SUTG.startThegame();
		SUTG.firstRadioBTN("a", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.secondRadioBTN("b", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.thirdRadioBTN("c","1","2","3","4");
		SUTG.nextQ();
		p.quitGame();
		assertEquals(false, driver.getPageSource().contains("You finished to build the test - lets play!!"));
	}
	@Test//Checking to see close game button works.
	public void closeGameBtn() {
		SUTG.startThegame();
		SUTG.firstRadioBTN("a", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.secondRadioBTN("b", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.thirdRadioBTN("c","1","2","3","4");
		SUTG.nextQ();
		p.clickPlay();
		p.answerPage("a","b","c");
		f.closeThegame();
		assertEquals(false, driver.getPageSource().contains("Quit"));
	}
	@Test//Pressing back in questions - Question number 1
	public void Q_back_V1() {
		SUTG.startThegame();
		SUTG.firstRadioBTN("a", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.onlyQ("b");
		SUTG.previousQ();
		SUTG.previousQ();
		assertTrue(driver.getPageSource().contains("question number: 1"));
	}
	@Test//Pressing back in questions - Question number 2
	public void Q_back_V2() {
		SUTG.startThegame();
		SUTG.firstRadioBTN("a", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.secondRadioBTN("b","1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.onlyQ("c");
		SUTG.previousQ();
		SUTG.previousQ();
		assertTrue(driver.getPageSource().contains("question number: 2"));
	}
	//Boundary values
	@Test// Insert 50 chars to  question field.
	public void Boundary_values1 () {
		SUTG.startThegame();
		SUTG.onlyQ("char char char  char  char  char char char char ch");
		SUTG.nextQ();
		assertTrue(driver.getPageSource().contains("question number: 2"));
	}
	@Test//Insert 30 fields into answer field
	public void Boundary_values2() {
		SUTG.startThegame();
		SUTG.firstRadioBTN("a", "This is an answer This is an a", "2", "3", "4");
		SUTG.nextQ();
		assertTrue(driver.switchTo().alert().getText().contains("To many charest in answer number"));

	}
	//Error handling
	@Test// Testing to see that one correct answer is not enough to win 
	public void only1TruAnswer() {
		SUTG.startThegame();
		SUTG.firstRadioBTN("a", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.secondRadioBTN("b", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.thirdRadioBTN("c","1","2","3","4");
		SUTG.nextQ();
		p.clickPlay();
		p.answerPage("a","f","g");
		assertEquals(false, f.result("Sucsses"));

	}
	@Test// Testing to see that two correct answer is not enough to win 
	public void only2TruAnswer() {
		SUTG.startThegame();
		SUTG.firstRadioBTN("a", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.secondRadioBTN("b", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.thirdRadioBTN("c","1","2","3","4");
		SUTG.nextQ();
		p.clickPlay();
		p.answerPage("a","b","g");
		assertEquals(false, f.result("Sucsses"));

	}
	@Test//Checking insertion of numbers into question field.
	public void InsertNumbers() {
		SUTG.startThegame();
		SUTG.onlyQ("1234");
		SUTG.nextQ();
		assertTrue(driver.getPageSource().contains("question number: 1"));

	}
	@Test//Checking that choosing a radio button is required
	public void requiredRadioBTN_v1() {
		SUTG.QandA("a", "1", "2", "3", "4");
		SUTG.nextQ();
		assertTrue(driver.switchTo().alert().getText().contains("you have to fill all the fileds please"));
	}
	@Test// Checking Radio button in the play section are required
	public void requiredRadioBTN_v2() {
		SUTG.startThegame();
		SUTG.firstRadioBTN("a", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.secondRadioBTN("b", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.thirdRadioBTN("c","1","2","3","4");
		SUTG.nextQ();
		p.clickPlay();
		p.nextQ();
		assertTrue(driver.switchTo().alert().getText().contains("You have to mark an answer!!"));
	}
	@Test// Insert 51 chars to  question field.
	public void Insert51 () {
		SUTG.startThegame();
		SUTG.onlyQ("char char char  char  char  char char char char cha");
		SUTG.nextQ();
		assertTrue(driver.getPageSource().contains("question number: 1"));
	}
	//Integration
	@Test //Testing integration withFB
	public void shareOnFB() {
		SUTG.startThegame();
		SUTG.firstRadioBTN("a", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.secondRadioBTN("b", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.thirdRadioBTN("c","1","2","3","4");
		SUTG.nextQ();
		p.clickPlay();
		p.answerPage("a","b","c");
		f.shareOnfacebook();
		assertEquals(true, driver.getCurrentUrl().equals("https://www.facebook.com/"));
	}
	//Algorithmic
	@Test// Testing that the questions are randomized
	public void algorithm () {
		SUTG.startThegame();
		SUTG.firstRadioBTN("a", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.secondRadioBTN("b", "1", "2", "3", "4");
		SUTG.nextQ();
		SUTG.thirdRadioBTN("c","1","2","3","4");
		SUTG.nextQ();
		p.clickPlay();
		assertTrue(p.algo("a","b","c"));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
		System.out.println("--Test Ended--");
	}
}
