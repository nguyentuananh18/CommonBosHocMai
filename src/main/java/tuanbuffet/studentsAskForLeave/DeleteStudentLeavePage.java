package tuanbuffet.studentsAskForLeave;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static tuanbuffet.common.Login.*;
import static tuanbuffet.common.WebUI.*;

public class DeleteStudentLeavePage {
    String URL = "https://spu.bos.hocmai.com/classes";
    By searchClassInput = By.xpath("//*[@name=\"classKeyword\"]");
    By selectClassStatusInput = By.xpath("//input[@placeholder=\"Chọn Trạng Thái Lớp\"]");
    By selectClassTypeInput = By.xpath("//input[@placeholder=\"Chọn Loại Lớp \"]");
    By searchStudentInput = By.xpath("//input[@placeholder=\"Tìm theo tên, mã học sinh\"]");
    By searchButton = By.xpath("//button[contains(text(),'Tìm Kiếm')]");


    public DeleteStudentLeavePage(){

    }
    public void SearchForClasses() throws InterruptedException {
        login("ctvanhnt2", "anhnt216836");
        openURL(URL);
        enterText(searchClassInput,"Tên học viên hoặc tên lớp");
        enterText(selectClassStatusInput,"Đang học" + Keys.DOWN + Keys.ENTER);
        enterText(selectClassTypeInput,"Chính Thức" + Keys.DOWN + Keys.ENTER);
        enterText(searchStudentInput, "Nhập tên học sinh");
        clickElement(searchButton);
    }

    public static void main(String[] args) throws InterruptedException {
        DeleteStudentLeavePage deleteStudentLeavePage = new DeleteStudentLeavePage();
        deleteStudentLeavePage.SearchForClasses();

    }

}
