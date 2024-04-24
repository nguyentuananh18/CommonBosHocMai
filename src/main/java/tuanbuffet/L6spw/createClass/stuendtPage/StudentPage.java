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
    WebUI webUI;
    StudentData studentInformationData;
    public void setWebUI(WebUI webUI){
        this.webUI = webUI;
    }
    public void Enterinformation(StudentData studentData) throws InterruptedException {
        EnterIdBos(studentData.getIdBos1());
        if (checkClassType() ==  2){
            EnterIdBos(studentData.getIdBos2());
        }
        clickElement(saveAndContinueButton);
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
