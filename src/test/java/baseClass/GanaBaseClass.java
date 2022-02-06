package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GanaBaseClass {
	
	public static WebDriver driver;

	public void createCellandInsertValue(String Sheetname, int Rowno, int Cellno, String data) throws IOException {

		File file = new File("C:\\Users\\Elanchezhiyan\\eclipse-workspace\\Maven\\ExcelSheet\\GANA12.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(Sheetname);
		Row row = sheet.getRow(Rowno);
		Cell createCell = row.createCell(Cellno);
		createCell.setCellValue(data);
		FileOutputStream stream1 = new FileOutputStream(file);
		workbook.write(stream1);
	}

	public String getCellValueFromXL(String SheetName, int RowNo, int CellNo) throws IOException {

		String data = null;
		File file = new File("C:\\Users\\Elanchezhiyan\\eclipse-workspace\\Maven\\ExcelSheet\\GANA12.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(RowNo);
		Cell cell = row.getCell(CellNo);
		int code = cell.getCellType();
		if (code == 1) {
			data = cell.getStringCellValue();
		}
		if (code == 0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM-dd-yy");
				data = dateFormat.format(date);
			} else {
				double d = cell.getNumericCellValue();
				long l = (long) d;
				data = String.valueOf(l);
			}
		}
		return data;
	}

	private String getPageSource() {

		String pageSource = driver.getPageSource();
		return pageSource;

	}

	public boolean boolea(String text, String text1) {
		boolean b = text.contains(text1);
		return b;

	}

	public void assertion(String message, boolean condition) {

		Assert.assertTrue(message, condition);

	}

	public void sysout(String data) {

		System.out.println(data);

	}

	// 1
	public static void getDriverChrome() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
	}
	
	

	// 2
	public static void loadUrl(String url) {

		driver.get(url);

	}

	// 3
	public void typeText(WebElement element, String data) {

		element.sendKeys(data);

	}

	// 4
	public void click(WebElement element) {

		element.click();

	}

	// 5
	public String getTitle() {

		String title = driver.getTitle();
		return title;

	}

	// 6
	public String getUrl(String data) {

		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	// 7
	public String getText(WebElement element) {

		String data = element.getText();
		return data;

	}

	// 8
	public WebElement findElementById(String attributeValue) {

		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	// 9
	public WebElement findElementByName(String attributeValue) {

		WebElement element = driver.findElement(By.name(attributeValue));
		return element;

	}

	// 10
	public WebElement findElementByClassName(String attributeValue) {

		WebElement element = driver.findElement(By.className(attributeValue));
		return element;

	}

	// 11
	public WebElement findElementByXpath(String xpathExpression) {

		WebElement element = driver.findElement(By.xpath(xpathExpression));
		return element;

	}

	// 12
	public String getAttribute(WebElement element, String attributeName) {

		String data = element.getAttribute(attributeName);
		return data;

	}

	// 13
	public String getAttribute(WebElement element) {

		String data = element.getAttribute("value");
		return data;

	}

	// 14
	public void selectByText(WebElement element, String text) {

		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	// 15
	public void selectByAttribute(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);

	}

	// 16
	public void selectByIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);

	}

	// 17
	public void jsTypeText(WebElement element, String data) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

	}

	// 18
	public void alert() {

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	// 19
	public void alertCancel() {

		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

	// 20
	public static void maxWindow() {

		driver.manage().window().maximize();

	}

	// 21
	public void minWindow() {

		driver.manage().window().minimize();

	}

	// 22
	public void closeWindow() {

		driver.close();

	}

	// 23
	public static void quitWindow() {

		driver.quit();

	}

	// 24
	public void switchWindowByText(String data) {

		driver.switchTo().window(data);

	}

	// 25
	public void sleep(long millis) throws InterruptedException {

		Thread.sleep(millis);

	}

	// 26
	public void navigateTo(String url) {

		driver.navigate().to(url);

	}

	// 27
	public void navigateForward() {

		driver.navigate().forward();

	}

	// 28
	public void navigateback() {

		driver.navigate().back();

	}

	// 29
	public void navigateRef() {

		driver.navigate().refresh();

	}

	// 30
	public void actions(WebElement element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	// 31
	public void dragAndDrop(WebElement s, WebElement d) {

		Actions actions = new Actions(driver);
		actions.dragAndDrop(s, d).perform();

	}

	// 32
	public void rightClick(WebElement element) {

		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();

	}

	// 33
	public void doubleClick(WebElement element) {

		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();

	}

	// 34
	public void alertWithText(String data) {

		Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);
		alert.accept();

	}

	// 35
	public void clickJavaScript(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}

	// 36
	public void jsScrollDown(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	// 37
	public void jsScrollUp(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);

	}

	// 38
	public String jsGetAttribute(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String data = js.executeScript("return arguments[0].getAttribute('value')", element).toString();
		return data;

	}

	// 39
	public void getDriverFirefox() {

		WebDriverManager.firefoxdriver().setup();

		driver = new FirefoxDriver();
	}

	// 40
	public void grtDriverIE() {

		WebDriverManager.iedriver().setup();

		driver = new InternetExplorerDriver();
	}

	// 41
	public void getDriverEdge() {

		WebDriverManager.edgedriver().setup();

		driver = new EdgeDriver();
	}

	// 42
	public void grtDriverSafari() {

		WebDriverManager.safaridriver().setup();

		driver = new SafariDriver();
	}

	// 43
	public void deselectByIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	// 44
	public void deselectByAttribute(WebElement element, String value) {

		Select select = new Select(element);
		select.deselectByValue(value);

	}

	// 45
	public void deselectByText(WebElement element, String text) {

		Select select = new Select(element);
		select.deselectByVisibleText(text);

	}

	// 46
	public void deselect(WebElement element) {

		Select select = new Select(element);
		select.deselectAll();

	}

	// 47
	public void switchFrameByIndex(int index) {

		driver.switchTo().frame(index);

	}

	// 48
	public void switchFrameByString(String data) {

		driver.switchTo().frame(data);

	}

	// 49
	public void switchFrameByWebElementReff(WebElement element) {

		driver.switchTo().frame(element);

	}

	// 50
	private void switchFrameToWindow() {

		driver.switchTo().defaultContent();

	}

	// 51
	public void switchToParentFrame() {

		driver.switchTo().parentFrame();

	}

	// 52
	public File screenShot() {

		TakesScreenshot ss = (TakesScreenshot) driver;
		File screenshotAs = ss.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}

	public void transferScreenShot(File source, String name) throws IOException {
	
		FileUtils.copyFile(source, new File(name));

	}
}
