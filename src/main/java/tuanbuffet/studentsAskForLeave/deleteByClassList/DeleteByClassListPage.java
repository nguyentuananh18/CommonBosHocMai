package tuanbuffet.studentsAskForLeave.deleteByClassList;

import org.openqa.selenium.By;
import tuanbuffet.studentsAskForLeave.StudentLeaveData;
import static  tuanbuffet.common.StringProcessing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static tuanbuffet.common.Login.*;

public class DeleteByClassListPage {
    By firstOption = By.xpath("//*[contains(@id,'-option-0')]");
    String URL = "https://spu.bos.hocmai.com/classes";
    By searchClassInput = By.xpath("//*[@name=\"classKeyword\"]");
    By selectClassStatusInput = By.xpath("//input[@placeholder=\"Chọn Trạng Thái Lớp\"]");
    By selectClassTypeInput = By.xpath("//input[@placeholder=\"Chọn Loại Lớp \"]");
    By searchTeacherInput = By.xpath("//input[@placeholder=\"Tìm theo tên, mã giáo viên\"]");
    By searchStudentInput = By.xpath("//input[@placeholder=\"Tìm theo tên, mã học sinh\"]");
    By searchButton = By.xpath("//button[contains(text(),'Tìm Kiếm')]");
    By foundClass = By.xpath("//tbody/tr[1]/td[1]/p[contains(text(),'SPU')]");

    By scheduleStudyButton = By.xpath("//button[contains(text(),'Lịch Học')]");
    By selectStatusClassInput = By.xpath("//legend/div[contains(text(),'Trạng Thái Buổi Học')]//parent::legend//parent::div//following-sibling::div//input");
    By searchScheduleButton = By.xpath("//button[contains(text(),'Tìm Kiếm')]");
    By foundSchedule = By.xpath("//tbody/tr/td/p[1]");
    By cancelClassButton = By.xpath("//button[contains(text(),'Hủy Buổi Học')]");
    By reasonInput = By.xpath("//input[@placeholder=\"Chọn Danh Mục Lý Do\"]");
    By reasonDetailInput = By.xpath("//input[@placeholder=\"Chọn Lý Do\"]");

    StudentLeaveData studentLeaveData;

    public DeleteByClassListPage(StudentLeaveData studentLeaveData) {
        this.studentLeaveData = studentLeaveData;
    }

    public boolean SearchByClass() {
        sleep(1);
        openURL(URL);
        enterText(searchClassInput, studentLeaveData.getStudentName());
        enterText(selectClassStatusInput, "Đang học");
        clickElement(firstOption);
        enterText(selectClassTypeInput, "Chính Thức");
        clickElement(firstOption);
        enterText(searchTeacherInput, studentLeaveData.getTeacher());
        enterText(searchStudentInput, studentLeaveData.getStudentID());
        clickElement(searchButton);
        waitForPageLoaded();
        return verifyElementIsDisplay(foundClass);
    }

    public void SelectClass() {
        int numberClass = listElements(By.xpath("//tbody/tr"));
        System.out.println("Đang tìm buổi học hôm nay!");
        for (int i = 1; i <= numberClass; i++) {
            clickElement(By.xpath("//tbody/tr[" + i + "]"));
            switchToWindows(1);
            clickElement(scheduleStudyButton);
            enterText(selectStatusClassInput, "Chưa Học");
            clickElement(firstOption);
            clickElement(searchScheduleButton);
            CancelClass();
            closeWindow();
            switchToWindows(0);
        }
    }
    public void CancelClass(){
        if (getTextElement(foundSchedule).contains("SPU")) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String NowDay = String.valueOf(formatter.format(date));
            for (int j = 1; j < listElements(By.xpath("//tbody/tr/td[1]/span")); j++) {
                //Nếu ngày trên lịch trùng với ngày hiện tại
                if (getTextElement("//tbody/tr[" + j + "]/td[11]/div/p[1]").equals(NowDay)) {
                    System.out.println("Đã tìm thấy buổi học hôm nay");

                    //Nếu như lịch ca học giống nhau nữa nhé:)))
                    System.out.println("Đang thực hiện thao tác hủy buổi học");
                    clickElement(By.xpath("//tbody/tr[" + j + "]/td[1]/span"));
                    clickElement(cancelClassButton);
                    enterText(reasonInput, "Học viên");
                    clickElement(firstOption);
                    enterText(reasonDetailInput, studentLeaveData.getReason());
                    clickElement(firstOption);
                    j = 1;
                    System.out.println("Đã hủy buổi học!");
                }
            }
        }
    }
}
