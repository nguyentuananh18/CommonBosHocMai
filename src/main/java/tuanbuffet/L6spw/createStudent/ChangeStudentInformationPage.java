package tuanbuffet.L6spw.createStudent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static tuanbuffet.L6spw.commonL6.BybyCommon.firstOption;
import static tuanbuffet.L6spw.commonL6.BybyCommon.notifyMessage;
import static tuanbuffet.common.WebUI.*;
public class ChangeStudentInformationPage {
    String URL = "https://spu.bos.hocmai.com/students/";
    String messageChangeSucces ="Cập nhật học viên thành công!";
    private final By nameChangeInput = By.xpath("//input[@name=\"fullName\"]");
    private final By representativeButton = By.xpath("//input[@name='representative']//parent::span");
    private final By CKSHInput = By.xpath("//input[@placeholder=\"Chọn CKSH\"]");
    private final By updateButton = By.xpath("//h6[contains(text(),'Cập Nhật')]");

    ChangeStudentInformationData changeStudentInformationData;
    public ChangeStudentInformationPage(ChangeStudentInformationData changeStudentInformationData){
        this.changeStudentInformationData = changeStudentInformationData;
    }
    public boolean ChangeNameStudent(){
        openURL(URL + changeStudentInformationData.getIdbos().substring(2) + "/general");
        clearText(nameChangeInput);
        enterText(nameChangeInput, changeStudentInformationData.getName());
        if (getAttributeElement(representativeButton,"class").contains(" Mui-checked")){
            clickElement(representativeButton);
            clickElement(representativeButton);
        }
        else {
            clickElement(representativeButton);
        }
        clearText(CKSHInput);
        enterText(CKSHInput, "(cs) - ( CS Default )");
        clickElement(firstOption);
        clickElement(updateButton);
        return getTextElement(notifyMessage).contains(messageChangeSucces);
    }

}
