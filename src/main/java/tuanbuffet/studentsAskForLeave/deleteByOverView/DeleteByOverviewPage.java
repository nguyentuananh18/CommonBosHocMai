package tuanbuffet.studentsAskForLeave.deleteByOverView;
import static tuanbuffet.common.WebUI.*;

import org.openqa.selenium.By;
import tuanbuffet.studentsAskForLeave.StudentLeaveData;
import static tuanbuffet.L6spw.commonL6.BybyCommon.*;
import static tuanbuffet.common.StringProcessing.*;

public class DeleteByOverviewPage {

    String URL = "https://spu.bos.hocmai.com/";
    By searchInput = By.xpath("//input[@name=\"keyWord\"]");
    By selectTeacherInput = By.xpath("//input[@placeholder=\"Chọn Giáo Viên\"]");
    By selectClassType = By.xpath("//input[@placeholder=\"Chọn Loại Lớp \"]");
    By selectStatusClassInput = By.xpath("//legend/div[contains(text(),'Trạng Thái Buổi Học')]//parent::legend//parent::div//following-sibling::div//input");
    By searchButton = By.xpath("//button[contains(text(),'Tìm Kiếm')]");
    By foundClass = By.xpath("//tbody/tr[1]/td[2]/button[contains(text(),'SPU')]");
    StudentLeaveData studentLeaveData;


    public DeleteByOverviewPage(StudentLeaveData studentLeaveData){
        this.studentLeaveData = studentLeaveData;
    }
    public boolean SearchClass(){
        String studentName = studentLeaveData.getStudentName();
        String teacherName = studentLeaveData.getTeacher();
        openURL(URL);
        enterText(searchInput,studentName);
        enterText(selectTeacherInput,teacherName);
        int numberTeacher = listElements(listOption);
        for (int i =1; i<= numberTeacher ; i++){
            String nameOnWeb = getTextElement(By.xpath("//*[contains(@id,'-option-\" + i + \"')]"));
            if (nameOnWeb.contains("(" +teacherName + ")" )){
                clickElement(By.xpath("//*[contains(@id,'-option-\" + i + \"')]"));
            }
        }
        enterText(selectClassType,"Chính Thức");
        clickElement(firstOption);
        clickElement(searchButton);
        sleep(3);
        waitForPageLoaded();
        return verifyElementIsDisplay(foundClass,5);
    }
    public void SelectLesson(){
        if (studentLeaveData.getSchedule().contains(getDateOfWeek())) {
            int numberClass = listElements(By.xpath("//tbody/tr"));
            System.out.println("Đang tìm buổi học hôm nay!");
            for (int i = 1; i <= numberClass; i++) {
                String scheduleText = getTextElement(By.xpath("//tbody/tr[\" + i + \"]/td[11]/div/p[2]"));
                String timeStudy = scheduleText.substring(scheduleText.indexOf("(") + 1, scheduleText.indexOf(")")).replaceAll("\\s+", "");
                if (getDateOfWeek().equals("thuba")||getDateOfWeek().equals("thutu")){
                    if (timeStudy.equals(scheduleText.substring(scheduleText.indexOf("thuba")+7,scheduleText.indexOf("thuba")+18))
                    || timeStudy.equals(scheduleText.substring(scheduleText.indexOf("thutu")+7,scheduleText.indexOf("thutu")+18))){
                        //==> đúng là nó rồi:)))
                        clickElement(By.xpath("//tbody/tr[\" + i + \"]"));
                        //vào lớp rồi thực hiện thao tác tiếp!
                    }
                }
                if (getDateOfWeek().equals("thuhai")||getDateOfWeek().equals("thunam")||getDateOfWeek().equals("thusau")||getDateOfWeek().equals("thubay")){
                    if (timeStudy.equals(scheduleText.substring(scheduleText.indexOf("thuhai")+8,scheduleText.indexOf("thuhai")+19))
                            || timeStudy.equals(scheduleText.substring(scheduleText.indexOf("thunam")+8,scheduleText.indexOf("thunam")+19))
                            || timeStudy.equals(scheduleText.substring(scheduleText.indexOf("thusau")+8,scheduleText.indexOf("thusau")+19))
                            || timeStudy.equals(scheduleText.substring(scheduleText.indexOf("thubay")+8,scheduleText.indexOf("thubay")+19))){
                        //==> đúng là nó rồi:)))
                        clickElement(By.xpath("//tbody/tr[\" + i + \"]"));
                        //vào lớp rồi thực hiện thao tác tiếp!
                    }
                }
                if (getDateOfWeek().equals("chunhat")){
                    if (timeStudy.equals(scheduleText.substring(scheduleText.indexOf("chunhat")+9,scheduleText.indexOf("chunhat")+20))){
                        //==> đúng là nó rồi:)))
                        clickElement(By.xpath("//tbody/tr[\" + i + \"]"));
                        //vào lớp rồi thực hiện thao tác tiếp!
                    }
                }


                clickElement(By.xpath("//tbody/tr[" + i + "]"));

            }
        }
        else {
            System.out.println("Lịch trên sheet không có hôm nay!");
        }
    }

    public static void main(String[] args) {
        String schedule = "nguyễn Tuấn ANh(191192) ok chưa nhỉ";

        System.out.println(removeAccent(schedule.toLowerCase()));
    }
}
