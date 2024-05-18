package tuanbuffet.L6spw.createClass.curriculumPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static tuanbuffet.L6spw.commonL6.BybyCommon.*;

import static tuanbuffet.common.WebUI.*;
public class CurriculumPage {
    By chon_Giao_Trinh_Input = By.xpath("//input[@placeholder=\"Chọn Giáo Trình\"]");
    By chooseCurriculum = By.xpath("//input[@placeholder=\"Choose Curriculum\"]");
    By chon_Bai_Hoc_Input = By.xpath("//input[@placeholder=\"Chọn Bài Học\"]");
    By chooseLesson = By.xpath("//input[@placeholder=\"Choose Lesson\"]");
    By saveButton = By.xpath("//button[contains(text(),'Lưu Lại')]");

    CurriculumData curriculumData;
    public CurriculumPage(CurriculumData curriculumData){
        this.curriculumData = curriculumData;
    }
    public void Enterinformation() {
        enterText(chon_Giao_Trinh_Input,curriculumData.getCourseName());
        clickElement(firstOption);
        enterText(chon_Bai_Hoc_Input,curriculumData.getLesson());
        sleep(2);

        //kiểm tra xem có bao nhiêu tùy chọn
        int numberLesson = listElements(listOption);
        //lấy cái cuối cùng (-1 là vì bắt đầu từ 0)
        numberLesson -= 1;
        clickElement(By.xpath("//*[contains(@id,'-option-" + numberLesson + "')]"));
        clickElement(saveButton);

    }
}
