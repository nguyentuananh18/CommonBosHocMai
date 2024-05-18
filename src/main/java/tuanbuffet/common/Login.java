package tuanbuffet.common;

import org.openqa.selenium.By;

import java.util.Scanner;

public class Login extends WebUI {
    private static String URL = "https://spu.bos.hocmai.com/auth/login";

    private static final By accountInput = By.xpath("//input[@name=\"username\"]");
    private static final By passwordInput = By.xpath("//input[@name=\"password\"]");
    private static final By loginButton = By.xpath("//button[contains(text(),'Login')]");
    private final By notificationTextFail = By.xpath("//form/p");
    private static final By titlePageText = By.xpath("//h4[text()='Tổng Quan']");
    Scanner sc = new Scanner(System.in);

    public static boolean login(String username, String password) throws InterruptedException {
        openURL(URL);
        enterText(accountInput, username);
        enterText(passwordInput, password);
        clickElement(loginButton);
        return verifyElementIsDisplay(titlePageText);
    }
}