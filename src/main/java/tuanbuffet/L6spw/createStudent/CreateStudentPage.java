package tuanbuffet.L6spw.createStudent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static tuanbuffet.common.WebUI.*;

public class CreateStudentPage {
    private String URL = "https://spu.bos.hocmai.com/students/create";
    private final By nameInput = By.xpath("//input[@name=\"fullName\"]");
    private final By codePhoneButton = By.xpath("//div[contains(text(),'Số Liên Hệ')]//parent::legend//parent::div//following-sibling::div//input[@value=\"+84\"]");
    private final By codePhoneInput2 = By.xpath("//div[contains(text(),'Số Liên Hệ')]//parent::legend//parent::div//following-sibling::div//input[@value=\"+84 Vietnam\"]");
    private final By phoneInput = By.xpath("//input[@name=\"phone\"]");
    private final By mailInput = By.xpath("//input[@name=\"email\"]");
    private final By birthDayInput = By.xpath("//input[@placeholder=\"ngày/tháng/năm\"]");
    private final By representative = By.xpath("//input[@name='representative']//parent::span");
    private final By CKSHInput = By.xpath("//input[@placeholder=\"Chọn CKSH\"]");
    private final By codeClassInButton = By.xpath("//div[contains(text(),'Số ClassIn')]//parent::legend//parent::div//following-sibling::div//input[@value=\"+84\"]");
    private final By codeClassInInput = By.xpath("//div[contains(text(),'Số ClassIn')]//parent::legend//parent::div//following-sibling::div//input[@value=\"+84 Vietnam\"]");
    private final By classInPhoneInput = By.xpath("//input[@name=\"classInPhone\"]");
    private final By submitButton = By.xpath("//button[@type='submit']");

    StudentData studentData;
    public CreateStudentPage(StudentData studentData){
        this.studentData = studentData;
    }
    public void EnterInformation(){
        openURL(URL);
        EnterData();
        clickElement(submitButton);
        sleep(0.5);
    }
    public void EnterData(){
        enterText(nameInput, studentData.getName());
        clickElement(codePhoneButton);
        sleep(0.5);
        enterText(codePhoneInput2,Keys.CLEAR + getAreaCode() + Keys.DOWN + Keys.ENTER);
        enterText(phoneInput, getPhoneAfterEditing());
        enterText(mailInput,studentData.getMail());
        enterText(birthDayInput,"01/01/2024");
        clickElement(representative);
        enterText(CKSHInput,"(cs) - ( CS Default )" + Keys.DOWN + Keys.ENTER);
        clickElement(codeClassInButton);
        sleep(0.5);
        enterText(codeClassInInput,Keys.CLEAR + getAreaCode() + Keys.DOWN + Keys.ENTER);
        enterText(classInPhoneInput, getPhoneAfterEditing());
    }
    public String getPhoneAfterEditing(){
        String lastPhone ="";

        switch (getAreaCode()){
            case "+81 Japan", "+82 Korea, Republic of South Korea","+33 France":{
                lastPhone = studentData.getPhone().substring(2);
            }
            break;
            case "+420 Czech Republic" :{
                lastPhone = studentData.getPhone().substring(3);
            }
            break;
            default: {
                lastPhone = "+84 Vietnam";
            }

        }
        /*if (getAreaCode().equals("+81 Japan") || getAreaCode().equals("+82 Korea, Republic of South Korea")||getAreaCode().equals("+33 France")){
            lastPhone = studentData.getPhone().substring(2);
        }
        else  if (getAreaCode().equals("+420 Czech Republic")){
            lastPhone = studentData.getPhone().substring(3);
        }

        else lastPhone = studentData.getPhone();*/
        return lastPhone;
    }
    public String getAreaCode(){
        String areaCode = "";
        if (studentData.getPhone().length() > 10){
           if (studentData.getPhone().startsWith("81")){
               areaCode = "+81 Japan";
           }
           else if (studentData.getPhone().startsWith("82")){
               areaCode = "+82 Korea, Republic of South Korea";
           }
           else if (studentData.getPhone().startsWith("420")){
               areaCode = "+420 Czech Republic";
           }
           else if (studentData.getPhone().startsWith("33")){
               areaCode ="+33 France";
           }
           else areaCode = "+84 Vietnam";
        }
        else{
            areaCode = "+84 Vietnam";
        }
        return areaCode;
    }
}
