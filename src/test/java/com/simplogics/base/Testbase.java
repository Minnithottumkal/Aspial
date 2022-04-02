package com.simplogics.base;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.simplogics.utilities.ExtentManager;
import com.simplogics.utilities.TestUtil;
import com.simplogics.utilities.excelreader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	/* initialize variables here */

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties testfield = new Properties();
	public static FileInputStream fis;
	public static FileInputStream testfielddata;
	public static String browser;
	public static WebDriverWait wait;
	public static ExtentReports extent;
	public static Logger log = Logger.getLogger("devpinoyLogger");

	private static final String EXCEL_PATH = "\\src\\test\\resources\\excel\\testdata.xlsx";
//	 private static final String EXCEL_PATH = "\\Docs\\excel\\testdata.xlsx";

	 private static final String CONFIG_PATH = "\\src\\test\\resources\\properties\\Config.properties";
//	private static final String CONFIG_PATH = "\\Docs\\properties\\Config.properties";

	 private static final String TEST_FIELD_PATH = "\\src\\test\\resources\\properties\\TestfieldData.properties";
//	private static final String TEST_FIELD_PATH = "\\Docs\\properties\\TestfieldData.properties";

	public static final String EXCEL_UPLOAD = "\\src\\test\\resources\\excel\\";
//	public static final String EXCEL_UPLOAD = "\\Docs\\excel\\";

//	public static final String Bulk_Details_Gold = "\\src\\test\\resources\\excel\\Bulk_Details_Gold.xlsx";
	// public static final String EXCEL_UPLOAD_GoldBulk =
	// "\\Docs\\excel\\Bulk_Details_Gold.xlsx";
//	public static final String Bulk_Details_Jewellery = "\\src\\test\\resources\\excel\\Bulk_Details_Jewellery.xlsx";
	// public static final String EXCEL_UPLOAD_JewelleryBulk =
	// "\\Docs\\excel\\Bulk_Details_Jewellery.xlsx";

	public static excelreader excel = new excelreader(System.getProperty("user.dir") + EXCEL_PATH);
	static String messageBody;
	
	public static String bulkNumber;
	public String newBulkNumber;
	public String transferNumber;
	public static ArrayList<String> itemNo = new ArrayList<String>();
	public static String Model;
	public static String Version;
	public static String Config;

//	ExtentHtmlReporter reporter;
//	public static ExtentReports extent;

	// public static final String REPORT_FILE_PATH
	// =System.getProperty("user.dir")+"/Automation_Reports/";

	@BeforeSuite
	public void beforeSuite() {

		// Setting report

		// reporter = new ExtentHtmlReporter(System.getProperty("user.dir") +
		// "\\reports\\Extentreports2.html");
		// reporter.config().setTheme(Theme.DARK);
		// reporter.config().setDocumentTitle("Aspial Automation Report");
		// extent = new ExtentReports();
		// extent.attachReporter(reporter);
		// extent.setSystemInfo("Automation Tester", "Aswathy Jose");
		// extent.setSystemInfo("Organization", "Simplogics Pvt Ltd");
		// extent.setSystemInfo("Build no", "SIMP-1234");
		ExtentManager.setReport();

		/* Setting browser via config.properties file */

		if (driver == null) {

			try {
				fis = new FileInputStream(System.getProperty("user.dir") + CONFIG_PATH);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/* Setting fields data via testfielddata.properties file */
			try {
				testfielddata = new FileInputStream(System.getProperty("user.dir") + TEST_FIELD_PATH);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				testfield.load(testfielddata);
				log.debug("testfieldData file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/* Setting browser. WebDriver manager is used here */
			/* Browser : Chrome, firefox, */

			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				browser = System.getenv("browser");
			} else {

				browser = config.getProperty("browser");

			}

			config.setProperty("browser", browser);

			if (config.getProperty("browser").equals("firefox")) {

				// System.setProperty("webdriver.gecko.driver", "gecko.exe");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("chrome")) {

				WebDriverManager.chromedriver().setup();
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
				driver = new ChromeDriver();
				
			}

			/* Adding testurl via config.properties file */

			driver.get(config.getProperty("testsiteurl"));

			driver.manage().window().maximize();
			// driver.manage().window().setSize(new Dimension(1280, 720));
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5);
			log.debug("opening webiste");
			

		}

	}

	/*    */
	public void click(String locator) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(testfield.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(testfield.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(testfield.getProperty(locator))).click();
		}
		System.out.println("locator = " + locator);
		// Customlisteners.testReport.get().log(Status.INFO, "Clicking on : " +locator);
		ExtentManager.logger.log(Status.INFO, "Clicking on : " + locator);

	}

	public void Keysleft(String locator) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(testfield.getProperty(locator))).sendKeys(Keys.LEFT);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(testfield.getProperty(locator))).sendKeys(Keys.LEFT);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(testfield.getProperty(locator))).sendKeys(Keys.LEFT);
		}

	}

	public void MywaitpresenceOfElementLocated(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 35000);
		if (locator.endsWith("_CSS")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(testfield.getProperty(locator))));
			System.out.println("element located " + locator);
		} else if (locator.endsWith("_XPATH")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(testfield.getProperty(locator))));
			System.out.println("element located " + locator);
		} else if (locator.endsWith("_ID")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(testfield.getProperty(locator))));
			System.out.println("element located " + locator);
		} else if (locator.endsWith("_linkText")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(testfield.getProperty(locator))));
		}
	}

	public void elementtobeclickable(String locator) {
		String fieldname = testfield.getProperty(locator);
		By btn = null;
		if (locator.endsWith("_CSS")) {

			btn = By.cssSelector(fieldname);

		}

		else if (locator.endsWith("_XPATH")) {
			btn = By.xpath(fieldname);
		}
		wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
		System.out.println("Clicked " + locator);
		ExtentManager.logger.log(Status.INFO, "Clicked " + locator);
		log.debug("Clicked " + locator);

	}

	public void Pageup() throws AWTException {

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
	}

	public void presenceOfElementLocated(String locator) {
		String labelname = testfield.getProperty(locator);
		By button = null;
		if (locator.endsWith("_CSS")) {

			button = By.cssSelector(labelname);

		}

		else if (locator.endsWith("_XPATH")) {
			button = By.xpath(labelname);
		}

		else if (locator.endsWith("_ID")) {
			button = By.id(labelname);
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(button)).click();
		System.out.println("Clicked locator = " + locator);
		ExtentManager.logger.log(Status.INFO, "Clicked " + locator);
		log.debug("Clicked " + locator);

	}

	public void doubleclick(String locator) {
		if (locator.endsWith("_CSS")) {
			WebElement element = driver.findElement(By.cssSelector(testfield.getProperty(locator)));
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		} else if (locator.endsWith("_XPATH")) {
			WebElement element = driver.findElement(By.xpath(testfield.getProperty(locator)));
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		} else if (locator.endsWith("_ID")) {
			WebElement element = driver.findElement(By.id(testfield.getProperty(locator)));
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		} else if (locator.endsWith("_linkText")) {
			WebElement element = driver.findElement(By.linkText(testfield.getProperty(locator)));
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		}
		// CustomListeners.test.log(Status.INFO, "Clicking on : " + locator);
	}

	public void MywaitinvisibilityOfElementLocated(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 35000);
		if (locator.endsWith("_CSS")) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(testfield.getProperty(locator))));
		} else if (locator.endsWith("_XPATH")) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(testfield.getProperty(locator))));
		} else if (locator.endsWith("_ID")) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(testfield.getProperty(locator))));
		} else if (locator.endsWith("_linkText")) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(testfield.getProperty(locator))));
		}
	}

	public void mousedown(String locator) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(testfield.getProperty(locator))).sendKeys(Keys.DOWN);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(testfield.getProperty(locator))).sendKeys(Keys.DOWN);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(testfield.getProperty(locator))).sendKeys(Keys.DOWN);
		}

	}

	public void mouseup(String locator) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(testfield.getProperty(locator))).sendKeys(Keys.UP);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(testfield.getProperty(locator))).sendKeys(Keys.UP);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(testfield.getProperty(locator))).sendKeys(Keys.UP);
		}

	}

	public static void AssertEquals(String expected, String actual) throws IOException {
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable t) {

			ExtentManager.logger.log(Status.FAIL, "Verifiation of TestData failed:" + t.getMessage());
			ExtentManager.logger.fail("Please check the below Screenshot :",
					MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtil.getbase64()).build());
		}
	}

	public static void Asserttoast(String expectedtoast, String locator) throws IOException {
		if (locator.endsWith("_CSS")) {
			String appearedtoast = driver.findElement(By.cssSelector(testfield.getProperty(locator))).getText();
			try {
				assertEquals(appearedtoast, expectedtoast);
			} catch (Throwable t) {
				ExtentManager.logger.log(Status.FAIL, "Verifiation Failed::" + t.getMessage());
				ExtentManager.logger.fail("Please check the below Screenshot :",
						MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtil.getbase64()).build());

			}
		} else if (locator.endsWith("_XPATH")) {
			String appearedtoast = driver.findElement(By.xpath(testfield.getProperty(locator))).getText();
			try {
				assertEquals(appearedtoast, expectedtoast);
			} catch (Throwable t) {
				ExtentManager.logger.log(Status.FAIL, "Verifiation Failed::" + t.getMessage());
				ExtentManager.logger.fail("Please check the below Screenshot :",
						MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtil.getbase64()).build());

			}

		} else if (locator.endsWith("_ID")) {
			String appearedtoast = driver.findElement(By.id(testfield.getProperty(locator))).getText();
			try {
				assertEquals(appearedtoast, expectedtoast);
			} catch (Throwable t) {
				ExtentManager.logger.log(Status.FAIL, "Verifiation Failed:" + t.getMessage());
				ExtentManager.logger.fail("Please check the below Screenshot :",
						MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtil.getbase64()).build());

			}

		} else if (locator.endsWith("_linkText")) {
			String appearedtoast = driver.findElement(By.linkText(testfield.getProperty(locator))).getText();
			try {
				assertEquals(appearedtoast, expectedtoast);
			} catch (Throwable t) {
				ExtentManager.logger.log(Status.FAIL, "Verifiation Failed:" + t.getMessage());
				ExtentManager.logger.fail("Please check the below Screenshot :",
						MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtil.getbase64()).build());

			}

		}
	}

	public void Tab(String locator) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(testfield.getProperty(locator))).sendKeys(Keys.TAB);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(testfield.getProperty(locator))).sendKeys(Keys.TAB);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(testfield.getProperty(locator))).sendKeys(Keys.TAB);
		}

	}

	public void timedelay() {

		String waiteTime = testfield.getProperty("wait_timeinsec");
		int timeInSeconds = waiteTime.isEmpty() || waiteTime == null ? 20 : Integer.parseInt(waiteTime);
		new WebDriverWait(driver, timeInSeconds);

	}

	public void rightclick(String locator) {
		if (locator.endsWith("_CSS")) {
			Actions actions = new Actions(driver);
			WebElement btnElement = driver.findElement(By.cssSelector(testfield.getProperty(locator)));
			actions.contextClick(btnElement).perform();
		} else if (locator.endsWith("_XPATH")) {
			Actions actions = new Actions(driver);
			WebElement btnElement = driver.findElement(By.xpath(testfield.getProperty(locator)));
			actions.contextClick(btnElement).perform();
		} else if (locator.endsWith("_ID")) {
			Actions actions = new Actions(driver);
			WebElement btnElement = driver.findElement(By.id(testfield.getProperty(locator)));
			actions.contextClick(btnElement).perform();
		}

	}

	public void MywaitvisibilityOfElementLocated(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 35000);
		if (locator.endsWith("_CSS")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(testfield.getProperty(locator))));
		} else if (locator.endsWith("_XPATH")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(testfield.getProperty(locator))));
		} else if (locator.endsWith("_ID")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(testfield.getProperty(locator))));
		} else if (locator.endsWith("_linkText")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(testfield.getProperty(locator))));
		}
	}

	public void presstab() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);// press tab key of keyboard
	}

	public void type(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(testfield.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(testfield.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(testfield.getProperty(locator))).sendKeys(value);
		}
		System.out.println("locator = " + locator + "  and value = " + value);

		// Customlisteners.testReport.get().log(Status.INFO, "Typing in : " + locator +
		// " entered value as " + value);
		ExtentManager.logger.log(Status.INFO, "Typing in : " + locator + " entered value as " + value);
		log.debug("Typing in : " + locator + " entered value as " + value);
	}
	
	public void Enter(String locator) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(testfield.getProperty(locator))).sendKeys(Keys.ENTER);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(testfield.getProperty(locator))).sendKeys(Keys.ENTER);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(testfield.getProperty(locator))).sendKeys(Keys.ENTER);
		}

	}

	static WebElement dropdown;

	public void select(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(testfield.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(testfield.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(testfield.getProperty(locator)));
		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		System.out.println("locator = " + locator + "  and value = " + value);

		// Customlisteners.testReport.get().log(Status.INFO, "Typing in : " + locator +
		// " entered value as " + value);
		ExtentManager.logger.log(Status.INFO, "Selecting : " + locator + " entered value as " + value);
		log.debug("Selecting  : " + locator + " entered value as " + value);
	}
	
	public void entitySelection(String entity)
	{
		MywaitpresenceOfElementLocated("entitysection_XPATH");
		WebElement e = driver.findElement(By.xpath(testfield.getProperty("entitysection_XPATH")));
		List<WebElement> entities = e.findElements(By.tagName("span"));
		for(WebElement item: entities)
		{
			if(item.getText().startsWith(entity))
			{
				System.out.println("Entity found");
				item.click();
				ExtentManager.logger.log(Status.INFO, "Enity choosed: " + entity);
				Actions action = new Actions(driver);
				action.moveToElement(item).doubleClick().perform();
				break;
			}
		}
	}

	public void SubaccountSelection(String subaccount) {
		MywaitpresenceOfElementLocated("subaccountsection_XPATH");
		WebElement h = driver.findElement(By.xpath(testfield.getProperty("subaccountsection_XPATH")));
		List<WebElement> liItems = h.findElements(By.tagName("span"));
		for (WebElement liItem : liItems) {
			// System.out.println(liItem.getText());
			if (liItem.getText().equals(subaccount)) {
				System.out.println("Found Subaccount");
				liItem.click();
				Actions action1 = new Actions(driver);
				action1.moveToElement(liItem).doubleClick().perform();
				break;
			}
		}
	}

	public boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	@AfterSuite
	public void afterSuite() throws IOException {
		if (driver != null) {
			// driver.quit();
			ExtentManager.endReport();
		}

		/*
		 * log.debug("test execution completed !!!"); SendEmail mail = new SendEmail();
		 * 
		 * messageBody =
		 * "Hi there, Please find the reports of Automation test attached with this mail !!!"
		 * ;
		 * 
		 * try { mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to,
		 * TestConfig.subject, messageBody); } catch (AddressException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch (MessagingException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}
}
