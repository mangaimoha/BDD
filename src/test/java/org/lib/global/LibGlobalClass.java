package org.lib.global;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobalClass {

	// below is default specifier (can be accessed within package)
	// to access driver from other package then change static to public static 
	public static WebDriver driver; // Static variable can be called within static method
	public static Robot r;
	public static Actions a;
	public static JavascriptExecutor js;
	public static Alert alert;
	public static Select select;

//1
	public static void openChrome() { // can access this static method from other class without creatin obj
		// Browser Configuration -Instead of System.setProperty
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

//2
	public static void launchUrl(String url) {
		driver.get(url);
	}

//3
	public static void closeBrowser() {
		driver.quit();
	}

//4
	public static void closeTab() {
		driver.close();
	}

//5
	public static void toRefresh() {
		driver.navigate().refresh();
	}

//6
	public static void maxWindow() {
		driver.manage().window().maximize();
	}

//7
	public static void toFetchTitle() {
		String title = driver.getTitle();
		System.out.println(title);

	}

//8
	public static String toFetchCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;

	}

//9
	public static void toFillTextBox(WebElement element, String data) {
		element.sendKeys(data);
	}

//10	
	public static void toClick(WebElement element) {
		element.click();
	}

//11	
	public static void toCopy() throws AWTException {
		r = new Robot(); // cannot create obj in class level bcoz method is called from child class so
							// method level exe start
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);

	}

//12	
	public static void toPaste() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

	}

//13	
	public static void toDragAndDrop(WebElement src, WebElement tgt) {
		a = new Actions(driver);
		a.dragAndDrop(src, tgt).perform();
	}

//14	
	public static void toMouseHover(WebElement element) {
		a = new Actions(driver);
		a.moveToElement(element).perform();
	}

//15	
	public static void toTakeSnap(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("C:\\Users\\HP\\eclipse_SeleniumFramework\\MavenProject\\Screenshot\\" + imgName + ".png");
		FileUtils.copyFile(src, dst);

	}

//16	
	public static void getParentWindowId() {
		String windowId = driver.getWindowHandle();
		System.out.println(windowId);

	}

//17	
	public static void getAllWindowsId() {
		Set<String> allIds = driver.getWindowHandles();
		System.out.println(allIds);
	}

//18
	public static void toRightClick(WebElement element) {
		a = new Actions(driver);
		a.contextClick(element).perform();
	}

//19
	public static void toDoubleClick(WebElement element) {
		a = new Actions(driver);
		a.doubleClick(element).perform();
	}

//20
	public static void toPressTab() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

	}

//21
	public static void toEnter() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

//22
	public static void toClickDown() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

	}

//23
	public static void toCut() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);

	}

//24
	public static void pressShift() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyRelease(KeyEvent.VK_SHIFT);

	}

//25	
	public static void setAttribute(WebElement element, String data) {
		js = (JavascriptExecutor) driver;
		String arg1 = "arguments[0].setAttribute('value','" + data + "')";
		js.executeScript(arg1, element);
	}

//26
	public static void getAttribute(WebElement element) {
		js = (JavascriptExecutor) driver;
		Object data = js.executeScript("return arguments[0].getAttribute('value')", element);
		System.out.println(data);

	}

//27
	public static void toScrollUp(WebElement element) {
		js = (JavascriptExecutor) driver;
		String arg1 = "arguments[0].scrollIntoView(false)";
		js.executeScript(arg1, element);
	}

//28
	public static void toScrollDown(WebElement element) {
		js = (JavascriptExecutor) driver;
		String arg1 = "arguments[0].scrollIntoView(true)";
		js.executeScript(arg1, element);

	}

//29
	public static void toElementClick(WebElement element) {
		js = (JavascriptExecutor) driver;
		String arg1 = "arguments[0].click()";
		js.executeScript(arg1, element);
	}

	// 30
	public static void acceptAlert() {
		alert = driver.switchTo().alert();
		alert.accept();
	}

//31	
	public static void dismisssAlert() {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}

//32	
	public static void sendTextToAlert(String value) {
		alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

//33
	public static void getAlertText() {
		alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
	}

//34
	public static void switchToWindow(String windowID) {
		driver.switchTo().window(windowID);
	}

//35
	public static void selectByText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

//36
	public static void selectByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

//37
	public static void selectByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

//38
	public static List<WebElement> getOptions(WebElement element) {
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;

	}

//39
	public static List<WebElement> getSelectedOptions(WebElement element) {
		select = new Select(element);
		List<WebElement> options = select.getAllSelectedOptions();
		return options;
	}

//40]
	public static void getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

//41 
	public static String readDataFromExcel(String workbookName, String sheetName, int rowNum, int cellNum)
			throws IOException {

		String result = "";
		String location = "C:\\Users\\HP\\eclipse_SeleniumFramework\\MavenProject\\ExternalFiles\\" + workbookName
				+ ".xlsx";

		File f = new File(location);
		FileInputStream fs = new FileInputStream(f); // throws FileNotFoundException
		Workbook wb = new XSSFWorkbook(fs); // throws IO Exception
		Sheet sheet = wb.getSheet(sheetName);

		Cell cell = sheet.getRow(rowNum).getCell(cellNum);
		int cellType = cell.getCellType();

		if (cellType == 1) {
			result = cell.getStringCellValue();
		}

		else if (DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMMM-yyyy");
			result = sdf.format(date);
		}

		else {
			double decimal = cell.getNumericCellValue();
			long number = (long) decimal;
			result = String.valueOf(number);
		}
		return result;

	}

	public static int getTotalNumberOfRows(String workbookName, String sheetName) throws IOException {
		String location = "C:\\Users\\HP\\eclipse_SeleniumFramework\\MavenProject\\ExternalFiles\\" + workbookName
				+ ".xlsx";
		File f = new File(location);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;

	}

	public static int getTotalNumberOfCells(String workbookName, String sheetName) throws IOException {
		String location = "C:\\Users\\HP\\eclipse_SeleniumFramework\\MavenProject\\ExternalFiles\\" + workbookName
				+ ".xlsx";
		File f = new File(location);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = 0;
		for (int i = 0; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			int cellPerRowCount = row.getPhysicalNumberOfCells();
			cellCount = cellPerRowCount + cellCount;
		}
		return cellCount;

	}

	public static void getAllDataFromExcel(String workbookName, String sheetName) throws IOException {
		String location = "C:\\Users\\HP\\eclipse_SeleniumFramework\\MavenProject\\ExternalFiles\\" + workbookName
				+ ".xlsx";
		File f = new File(location);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetName);
		String result = "";
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				if (cellType == 1) {
					result = cell.getStringCellValue();
					System.out.print(result + " ");
				} else if (DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMMM-yyyy");
					result = sdf.format(date);
					System.out.print(result + " ");

				} else {
					double numeric = cell.getNumericCellValue();
					long longVal = (long) numeric;
					result = String.valueOf(longVal);
					System.out.println(result + " ");
				}
			}
			System.out.println();
		}

	}

	public static void addSheetToExcel(String workbookName, String sheetName, int rowNo, int cellNo, String cellValue)
			throws IOException {

		String location = "C:\\Users\\HP\\eclipse_SeleniumFramework\\MavenProject\\ExternalFiles\\" + workbookName
				+ ".xlsx";
		File f = new File(location);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.createSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(cellValue);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

	public static void addRowToExcel(String workbookName, String sheetName, int rowNo, int cellNo, String cellValue)
			throws IOException {

		String location = "C:\\Users\\HP\\eclipse_SeleniumFramework\\MavenProject\\ExternalFiles\\" + workbookName
				+ ".xlsx";
		File f = new File(location);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(cellValue);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

	public static void addCellToExcel(String workbookName, String sheetName, int rowNo, int cellNo, String cellValue)
			throws IOException {

		String location = "C:\\Users\\HP\\eclipse_SeleniumFramework\\MavenProject\\ExternalFiles\\" + workbookName
				+ ".xlsx";
		File f = new File(location);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(cellValue);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

}
