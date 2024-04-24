package tuanbuffet.L6spw.createStudent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static tuanbuffet.common.WebUI.*;

public class StudentPage {
    private String URL = "https://spu.bos.hocmai.com/students/create";
    By nameInput = By.xpath("//input[@name=\"fullName\"]");
    By codePhoneButton = By.xpath("//div[contains(text(),'Số Liên Hệ')]//parent::legend//parent::div//following-sibling::div//input[@value=\"+84\"]");
    By codePhoneInput2 = By.xpath("//div[contains(text(),'Số Liên Hệ')]//parent::legend//parent::div//following-sibling::div//input[@value=\"+84 Vietnam\"]");
    By phoneInput = By.xpath("//input[@name=\"phone\"]");
    By mailInput = By.xpath("//input[@name=\"email\"]");
    By representative = By.xpath("//input[@name='representative']//parent::span");
    By CKSHInput = By.xpath("//input[@placeholder=\"Chọn CKSH\"]");
    By codeClassInButton = By.xpath("//div[contains(text(),'Số ClassIn')]//parent::legend//parent::div//following-sibling::div//input[@value=\"+84\"]");
    By codeClassInInput = By.xpath("//div[contains(text(),'Số ClassIn')]//parent::legend//parent::div//following-sibling::div//input[@value=\"+84 Vietnam\"]");
    By classInPhoneInput = By.xpath("//input[@name=\"classInPhone\"]");
    StudentData studentData;
    public StudentPage(StudentData studentData){
        this.studentData = studentData;
    }
    public void EnterInformation(){
        openURL(URL);
        enterText(nameInput, studentData.getName());
        clickElement(codePhoneButton);
        sleep(0.5);
        enterText(codePhoneInput2,Keys.CLEAR + getAreaCode() + Keys.DOWN + Keys.ENTER);
        enterText(phoneInput,LastPhone());
        enterText(mailInput,studentData.getMail());
        clickElement(representative);
        enterText(CKSHInput,"(cs) - ( CS Default )" + Keys.DOWN + Keys.ENTER);
        clickElement(codeClassInButton);
        sleep(0.5);
        enterText(codeClassInInput,Keys.CLEAR + getAreaCode() + Keys.DOWN + Keys.ENTER);
        enterText(classInPhoneInput,LastPhone());
    }
    public String LastPhone(){
        String lastPhone ="";
        if (getAreaCode().equals("+81 Japan") || getAreaCode().equals("+82 Korea, Republic of South Korea")){
            lastPhone = studentData.getPhone().substring(2);
        }
        else  if (getAreaCode().equals("+420 Czech Republic")){
            lastPhone = studentData.getPhone().substring(3);
        }
        else lastPhone = studentData.getPhone();
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
        }
        else{
            areaCode = "+84 Vietnam";
        }
        return areaCode;
    }
}
