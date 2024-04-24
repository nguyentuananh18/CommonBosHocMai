package tuanbuffet.common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.Normalizer;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class WebUI {



    public static boolean isNumer(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    public static void switchToWindows(int number){
        Set<String> windows = driver.getWindowHandles();
        String firstWindow = (String)windows.toArray()[number];
        driver.switchTo().window(firstWindow);
    }
    public static void NewTab() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_T);
        Thread.sleep(1000);
    }
    public static boolean veryElementIsDisplay(By by, int timeOut){
        boolean status = false;
        for (int i = 0; i<=timeOut; i++){
            if (driver.findElement(by).isDisplayed()){
                status = true;
                break;
            }
            else {
                sleep(1);
            }
        }
        return status;
    }
    public static String Unsigned(String str){
        switch (str){
            case "đ":
                str = "d";
                break;
            case "ê":
                str = "e";
                break;
            case "ư":
                str = "u";
                break;
            case "ô", "ơ":
                str = "o";
                break;
            case"ă", "â":
                str = "a";
                break;
        }
        return str;
    }

    public static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        temp = pattern.matcher(temp).replaceAll("");
        return temp.replaceAll("đ", "d");
    }
    public static WebDriver driver;
    public static void HideBrowers(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
    }
    public static void clickPartialLinkText(String content){
        By locator = By.partialLinkText(content);
        clickElement(locator);
    }
    public static void openBrowserOption(String numbersProfiles){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users\\Nguyen Tuan Anh\\AppData\\Local\\Google\\Chrome\\User Data\\");
        options.addArguments("--profile-directory=Profile " + numbersProfiles);
        driver = new ChromeDriver(options);
    }
    public static void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    public static void AlertDismiss(){
        driver.switchTo().alert().dismiss();
    }
    public static void AlertAccept(){
        driver.switchTo().alert().accept();
    }
    public static void AlertSendKeys(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    public static String AlertClick(){
        return driver.switchTo().alert().getText();
    }

    private static int EXPLICIT_WAIT_TIMEOUT = 10;
    private static int WAIT_PAGE_LEADED_TIMEOUT = 20;

    public WebUI() {
    }
    public static WebElement getWebElement(By by) {
        return driver.findElement(by);
    }
    public static void logConsole(String message) {
        /*System.out.println(message);*/
    }
    public static void hoverOnElement(By by) {
        waitForElementVisible(by);
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(by));
        logConsole("Hover on element " + by);
    }
    public static WebElement highLightElement(By by) {
        waitForElementVisible(by);
        // Tô màu border ngoài chính element chỉ định - màu đỏ (có thể đổi màu khác)
        /*if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", getWebElement(by));
            sleep(1);
        }*/
        return getWebElement(by);
    }

    public static void rightClickElement(By by) {
        waitForElementVisible(by);
        Actions action = new Actions(driver);
        action.contextClick(getWebElement(by));
        logConsole("Right click on element " + by);
    }

    public static void openURL(String URL) {
        driver.get(URL);
        waitForPageLoaded();
        logConsole("Open URL: " + URL);
    }

    public static String getCurrentUrl() {
        waitForPageLoaded();
        logConsole("Get Current URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public static void clickElement(By by) {
        waitForPageLoaded();
        waitForElementVisible(by);
        highLightElement(by);
        getWebElement(by).click();
        logConsole("Click on element " + by);
        //Report
    }
    public static void clearText(By by){
        waitForPageLoaded();
        waitForElementVisible(by);
        highLightElement(by);
        getWebElement(by).clear();
        logConsole("Click on element " + by);
    }

    public static void enterText(By by, String value) {
        waitForPageLoaded();
        waitForElementVisible(by);
        /*getWebElement(by).clear();*/
        getWebElement(by).sendKeys(value);
    }
    public static void refreshPageWeb(){
        driver.navigate().refresh();
    }

    public static String getTextElement(By by) {
        waitForPageLoaded();
        waitForElementVisible(by);
        logConsole("Get text of element " + by);
        logConsole("==> Text: " + getWebElement(by).getText());
        return getWebElement(by).getText();
    }

    public static String getAttributeElement(By by, String attributeName) {
        waitForElementVisible(by);
        logConsole("Get attribute value of element " + by);
        logConsole("==> Attribute value: " + getWebElement(by).getAttribute(attributeName));
        return getWebElement(by).getAttribute(attributeName);
    }

    public static void scrollToElementWithJS(By by) {
        waitForElementPresent(by);
        //Dùng Actions class
        //Robot class
        //Dùng JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
        logConsole("Scroll to element " + by);
    }
    public static void scrollToElementWithJS(int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + y + ")");
    }

    public static void scrollToElement(By by) {
        //Dùng Actions class

    }
    public static void scrollToElementWithRobot(By by) {
        //Dùng Robot class
    }
    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void waitForElementVisible(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementPresent(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementClickable(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));

        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static boolean verifyElementIsDisplay(By by, int second) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public static boolean verifyElementIsDisplay(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public static int listElements(By by) {
        List<WebElement> listElement = driver.findElements(by);
        return listElement.size();
    }

    public static Boolean checkElementExist(String xpath) {
        List<WebElement> listElement = driver.findElements(By.xpath(xpath));

        if (!listElement.isEmpty()) {
            System.out.println("Element " + xpath + " existing.");
            return true;
        } else {
            System.out.println("Element " + xpath + " NOT exist.");
            return false;
        }
    }
    public static String getTextElement(String xpath){
        return driver.findElement(By.xpath(xpath)).getText();
    }

    /**
     * Wait for Page loaded
     * Chờ đợi trang tải xong (Javascript tải xong)
     */
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_PAGE_LEADED_TIMEOUT));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };


    }
    public static void clickElementJS(By by){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement button = driver.findElement(by);
        js.executeScript("arguments[0].click();", button);
    }
    public static void clickElementJS(String x){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsById('input')[3].click()");
    }
}

