package tuanbuffet.L6spw.createClass.stuendtPage;

import org.openqa.selenium.By;
import tuanbuffet.common.WebUI;
import static  tuanbuffet.common.WebUI.*;
public class StudentPage {
    private final By informationStudentInput = By.xpath("//input[@placeholder=\"Tìm Kiếm Theo Mã, SĐT Và Tên Học Viên\"]");
    private final By searchButton = By.xpath("//form/div/div//button[contains(text(),'Tìm ')]");
    private final By nameStudentText = By.xpath("//*[@id=\"root\"]/div/main/form/div[2]/div[1]/div[2]/div[2]/div[1]/table/tbody/tr/td[1]");
    private final By addStudentButton = By.xpath("//tbody/tr/td//button[text()='Thêm']");
    private final By saveAndContinueButton = By.xpath("//button[contains(text(),'Lưu Và Tiếp Tục')]");
    private final By courseInformationText = By.xpath("//form//legend[contains(text(),'SPEAKWELL - GV')]");

    By notifyMessage = By.xpath("//div[@id='notistack-snackbar']");

    By listStudentAdded = By.xpath("//legend[contains(text(),'Học Viên Đã Thêm')]//following-sibling::div//tbody/tr");
    By errorAddStudentText = By.xpath("//legend[contains(text(),'Học Viên Đã Thêm')]//following-sibling::div//tbody/tr[i]/td/span");
    String addHvSuccess = "Lưu Thành Công";
    String addHvErrorNotAvailable = "Student không có đủ available sessions";
    String addHVErrorPackage = "Gói của học viên đã hết hạn";
    String addTotalSuccess = "Lưu Thành Công";
    String errorSession = "Student đã tham gia vào một session khác ở thời điểm này";


    StudentData studentData;
    public StudentPage(StudentData studentData){
        this.studentData = studentData;
    }

    public boolean Enterinformation() throws InterruptedException {
        EnterIdBos(studentData.getIdBos1());
        if (checkClassType() ==  2){
            EnterIdBos(studentData.getIdBos2());
        }
        clickElement(saveAndContinueButton);
        return getTextElement(notifyMessage).contains(addTotalSuccess);

    }
    public void EnterIdBos(String idBos) throws InterruptedException {
        enterText(informationStudentInput,idBos);
        Thread.sleep(1000);
        clickElement(searchButton);
        Thread.sleep(3000);
        if (verifyElementIsDisplay(addStudentButton,5)){
            clickElement(addStudentButton);
            System.out.println("done add " + idBos + " vào lớp! |");
        }
        else {
            System.out.print("lỗi add " + idBos+ " vào lớp! |");
        }
    }
    public int checkClassType(){
        if (getTextElement(courseInformationText).contains("1:2")){
            return 2;
        }
        else return 1;
    }
}
