package tuanbuffet.L6spw.createClass.curriculumPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

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
    public void Enterinformation() throws InterruptedException {
        enterText(chon_Giao_Trinh_Input,curriculumData.getCourseName() + Keys.ENTER);
        enterText(chon_Bai_Hoc_Input,curriculumData.getLesson() + Keys.ENTER);
        Thread.sleep(10000);
        clickElement(saveButton);
    }
}
