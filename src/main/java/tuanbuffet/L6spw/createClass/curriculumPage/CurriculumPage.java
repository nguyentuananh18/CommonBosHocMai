package tuanbuffet.L6spw.createClass.curriculumPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static tuanbuffet.L6spw.commonL6.BybyCommon.*;
import static tuanbuffet.common.StringProcessing.*;

import static tuanbuffet.common.WebUI.*;
public class CurriculumPage {
    By chooseCurriculum = By.xpath("//input[@placeholder=\"Chọn Giáo Trình\"]");

    By chooseLesson = By.xpath("//input[@placeholder=\"Chọn Bài Học\"]");

    By saveButton = By.xpath("//button[contains(text(),'Lưu Lại')]");

    CurriculumData curriculumData;
    public CurriculumPage(CurriculumData curriculumData){
        this.curriculumData = curriculumData;
    }
    public void Enterinformation() {
        String course = curriculumData.getCourseName();
        String lesson = curriculumData.getLesson();
        /*enterText(chooseCurriculum,course);
        clickElement(firstOption);*/

        /*phần chọn giáo trình cho học viên:
        * Đầu tiên tôi click vào ô input giáo trình để lấy ra danh sách xem có bao nhiêu giáo trình
        * sau đó tôi điền tên giáo trình vào ô input đó để rút ngắn danh sách giáo trình
        * Tiếp theo tôi duyệt vòng lặp theo danh sách ban đầu, để tìm ra giáo trình mong muốn
        * khi đúng giáo trình thì tôi sẽ click*/

        clickElement(chooseCurriculum);
        sleep(1);
        int numberCourses = listElements(listOption);
        System.out.println("Có " + numberCourses + "giáo trình được nhìn thấy");
        enterText(chooseCurriculum,course);
        sleep(5);
        for (int i = 0; i < numberCourses ; i++){
            try {
                String courseOnWeb = removeAccentAndSpace(getTextElement("//*[contains(@id,'-option-" + i + "')]"));
                System.out.print(getTextElement("//*[contains(@id,'-option-" + i + "')]"));
                if (courseOnWeb.equals(removeAccentAndSpace(course))){
                    System.out.println("||||" + course + " =>  giống, chọn giáo trình này");
                    clickElement(By.xpath("//*[contains(@id,'-option-" + i + "')]"));
                    break;
                }
                else {
                    System.out.println("||||" + course + " => không giống");
                }
            }
            catch (Exception e){
                System.out.println("Lỗi ở vị trí :" + i);
            }

        }

        //Phần này đã ok:)))
        clickElement(chooseLesson);
        sleep(5);
        //kiểm tra xem có bao nhiêu tùy chọn
        for (int j = 0 ; j<=3 ; j++){
            if (verifyElementIsDisplay(firstOption)){
                int numberLesson = listElements(listOption);
                for (int i = numberLesson-1; i>=0 ; i--){
                    try {
                        String lessonOnWeb = getTextElement("//*[contains(@id,'-option-" + i + "')]");
                        if (lessonOnWeb.equals(lesson)){
                            clickElement(By.xpath("//*[contains(@id,'-option-" + i + "')]"));
                            break;
                        }
                    }
                    catch (Exception e){
                        System.out.println("tìm Lesson bị lỗi ở: " +i );
                    }
                }
                break;
            }
        }

        //Phần này đã ok:)))

        clickElement(saveButton);
        getTextElement(notifyMessage);
        sleep(1);
    }
}
