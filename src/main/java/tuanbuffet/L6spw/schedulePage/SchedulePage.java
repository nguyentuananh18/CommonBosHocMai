package tuanbuffet.L6spw.schedulePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import  static  tuanbuffet.common.WebUI.*;


public class SchedulePage {
    private final By nameCourseInput = By.xpath("//input[@placeholder=\"Khóa Học\"]");
    private final  By startDay = By.xpath("//input[@placeholder=\"ngày/tháng/năm\"]");
    private final  By numberDurationInput = By.xpath("//input[@placeholder=\"Số Buổi\"]");
    private final  By scheduleInput = By.xpath("//input[@placeholder=\"Lịch Học\"]");
    private final  By submitCreateButton = By.xpath("//button[contains(text(),'Tạo Và Sang Bước Kế')]");
    public void Enterinformation(ScheduleData data) throws InterruptedException {
        setText(nameCourseInput,data.getCurriculum()+ Keys.DOWN + Keys.ENTER);
        Thread.sleep(500);
        setText(startDay,"10102025");
        Thread.sleep(500);
        setText(numberDurationInput,"1");
        Thread.sleep(500);
        setText(scheduleInput,"08:25 - 08:55" + Keys.DOWN + Keys.ENTER );
        Thread.sleep(500);
        clickElement(submitCreateButton);
        waitForPageLoaded();
    }

}
