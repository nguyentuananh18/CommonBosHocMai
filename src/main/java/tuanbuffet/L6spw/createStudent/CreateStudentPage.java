package tuanbuffet.L6spw.createStudent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static tuanbuffet.common.WebUI.*;
import static  tuanbuffet.common.StringProcessing.*;
import static tuanbuffet.L6spw.commonL6.BybyCommon.*;

public class CreateStudentPage {
    private String URL = "https://spu.bos.hocmai.com/students/create";

    private final By nameInput = By.xpath("//input[@name=\"fullName\"]");
    private final By codePhoneButton = By.xpath("//div[contains(text(),'Số Liên Hệ')]//parent::legend//parent::div//following-sibling::div//input[@value=\"+84\"]");
    private final By codePhoneInput2 = By.xpath("//div[contains(text(),'Số Liên Hệ')]//parent::legend//parent::div//following-sibling::div//input[@value=\"+84 Vietnam\"]");
    private final By phoneInput = By.xpath("//input[@name=\"phone\"]");
    private final By mailInput = By.xpath("//input[@name=\"email\"]");
    private final By birthDayInput = By.xpath("//input[@placeholder=\"ngày/tháng/năm\"]");
    private final By representativeButton = By.xpath("//input[@name='representative']//parent::span");
    private final By CKSHInput = By.xpath("//input[@placeholder=\"Chọn CKSH\"]");
    private final By codeClassInButton = By.xpath("//div[contains(text(),'Số ClassIn')]//parent::legend//parent::div//following-sibling::div//input[@value=\"+84\"]");
    private final By codeClassInInput = By.xpath("//div[contains(text(),'Số ClassIn')]//parent::legend//parent::div//following-sibling::div//input[@value=\"+84 Vietnam\"]");
    private final By classInPhoneInput = By.xpath("//input[@name=\"classInPhone\"]");
    private final By submitButton = By.xpath("//button[@type='submit']");


    CreateStudentData createStudentData;

    public CreateStudentPage(CreateStudentData data) {
        this.createStudentData = data;
    }

    public void EnterInformation() {
        openURL(URL);

        EnterData();
        clickElement(submitButton);
    }

    public void EnterData() {
        enterText(nameInput, createStudentData.getName());
        clickElement(codePhoneButton);
        sleep(0.5);
        enterText(codePhoneInput2, Keys.CLEAR + createStudentData.getAreaCode() + Keys.DOWN + Keys.ENTER);
        enterText(phoneInput, createStudentData.getPhoneAfterEditing());
        enterText(mailInput, createStudentData.getMail());
        enterText(birthDayInput, "01/01/2024");
        clickElement(representativeButton);
        enterText(CKSHInput, "(cs) - ( CS Default )");
        clickElement(firstOption);
        clickElement(codeClassInButton);
        sleep(0.5);
        enterText(codeClassInInput, Keys.CLEAR + createStudentData.getAreaCode() + Keys.DOWN + Keys.ENTER);
        enterText(classInPhoneInput, createStudentData.getPhoneAfterEditing());
    }

}
