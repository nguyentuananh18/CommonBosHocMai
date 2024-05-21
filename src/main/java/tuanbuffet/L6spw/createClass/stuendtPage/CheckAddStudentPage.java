package tuanbuffet.L6spw.createClass.stuendtPage;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import static tuanbuffet.common.WebUI.*;
import static tuanbuffet.L6spw.commonL6.BybyCommon.*;
import static tuanbuffet.common.WebUI.getTextElement;


public class CheckAddStudentPage {
    By listStudentAdded = By.xpath("//legend[contains(text(),'Học Viên Đã Thêm')]//following-sibling::div//tbody/tr");
    By errorAddStudentText = By.xpath("//legend[contains(text(),'Học Viên Đã Thêm')]//following-sibling::div//tbody/tr[i]/td/span");

    String errorSession = "Student đã tham gia vào một session khác ở thời điểm này";

    By saveAndContinueButton = By.xpath("//button[contains(text(),'Lưu Và Tiếp Tục')]");


    StudentData studentData;
    public CheckAddStudentPage(StudentData studentData){
        this.studentData = studentData;
    }

    public String AcceptanceAddStudent(){
        StringBuilder acceptance = new StringBuilder();
        if (getTextElement(notifyMessage).contains(errorSession) || errorSession.contains(getTextElement(notifyMessage))){
            for (int i = 1 ; i<= listElements(listStudentAdded) ; i++){
                String textError = getTextElement("//legend[contains(text(),'Học Viên Đã Thêm')]//following-sibling::div//tbody/tr[" + i + "]/td/span" );
                //nếu học viên có text báo bị lỗi
                if (textError.contains(errorSession)){
                    //gỡ hv đó ra

                    //Lấy id của HV đang bị lỗi
                    String textID = getTextElement(By.xpath("//legend[contains(text(),'Học Viên Đã Thêm')]//following-sibling::div//tbody/tr[" + i + "]/td[1]/p"));
                    System.out.println(StringUtils.right(textID,9));
                        acceptance.append(textID);
                    clickElement(By.xpath("//legend[contains(text(),'Học Viên Đã Thêm')]//following-sibling::div//tbody/tr["+i+"]/td[3]/div"));
                }
            }
            clickElement(saveAndContinueButton);
        }
        else acceptance.append(" ");
        return acceptance.toString();
    }

}
