package tuanbuffet.L6spw.createClass.schedulePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static  tuanbuffet.common.StringProcessing.*;
import  static  tuanbuffet.common.WebUI.*;
import  static  tuanbuffet.L6spw.commonL6.BybyCommon.*;


public class SchedulePage {
    private final By nameCourseInput = By.xpath("//input[@placeholder=\"Khóa Học\"]");
    private final  By startDay = By.xpath("//input[@placeholder=\"ngày/tháng/năm\"]");
    private final  By numberDurationInput = By.xpath("//input[@placeholder=\"Số Buổi\"]");
    private final  By scheduleInput = By.xpath("//input[@placeholder=\"Lịch Học\"]");
    private final  By submitCreateButton = By.xpath("//button[contains(text(),'Tạo Và Sang Bước Kế')]");

    private By plusScheduleButton = By.xpath("//b[contains(text(),'Lịch Học')]/parent::div/following-sibling::div//div[contains(text(),'Lịch Học')]/parent::div/parent::div/parent::div//following-sibling::button");
    private By ScheduleInputs = By.xpath("//b[contains(text(),'Lịch Học')]/parent::div/following-sibling::div//div[contains(text(),'Lịch Học')]/parent::div/parent::div/parent::div/div[1]//input[@placeholder=\"Lịch Học\"]");
    
    ScheduleData scheduleData;
    public SchedulePage(ScheduleData scheduleData){
        this.scheduleData = scheduleData;
    }
    public void Enterinformation() {
        String nameCourse = scheduleData.getCurriculum();
        /*enterText(nameCourseInput,nameCourse);*/
        clickElement(nameCourseInput);
        List<WebElement> listCourse = ListElements(listOption);
        for(WebElement course : listCourse){
            try {
                if (course.getText().equals(nameCourse)){
                    course.click();
                    break;
                }
            }
            catch (Exception ignored){
            }
        }
        sleep(1);
        enterText(startDay,"10102025");
        sleep(1);
        enterText(numberDurationInput,"1");
        sleep(0.5);
        enterText(scheduleInput,"08:25 - 08:55");
        sleep(0.5);
        clickElement(firstOption);
        clickElement(submitCreateButton);
        waitForPageLoaded();
    }
    public void EnterSchedule(){

    }

}
