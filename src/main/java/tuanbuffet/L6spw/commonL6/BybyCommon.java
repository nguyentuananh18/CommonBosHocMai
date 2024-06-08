package tuanbuffet.L6spw.commonL6;

import org.openqa.selenium.By;

public class BybyCommon {
    public static By firstOption = By.xpath("//*[contains(@id,'-option-0')]");
    public static By listOption = By.xpath("//*[contains(@id,'-option-')]");
    public static By notifyMessage = By.xpath("//div[@id='notistack-snackbar']");
    public static By closeNotifyMessage = By.xpath("//div[@id='notistack-snackbar']//following-sibling::div/button");
    public static By numberOfPage = By.xpath("//p[contains(text(),'Số dòng trên 1 trang :')]//parent::div//p[2]");
    public static By searchCommonButton = By.xpath("//button[normalize-space()='Tìm kiếm']");
}

///html/body/div/div[1]/div/div