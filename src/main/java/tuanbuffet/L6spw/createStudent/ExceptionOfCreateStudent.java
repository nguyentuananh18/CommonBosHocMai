package tuanbuffet.L6spw.createStudent;

import static tuanbuffet.common.WebUI.*;

import org.openqa.selenium.By;

public class ExceptionOfCreateStudent {
    String messageMailExist = "Email đã tồn tại";
    String messageClassIn = "ClassIn Phone đã tồn tại";
    String phoneAndName = "Họ tên và số điện thoại liên lạc đã tồn tại";
    String success = "Tạo học viên thành công";
    By messageErrorFullNameText = By.xpath("//div[contains(text(),'Tên Đầy Đủ')]//parent::legend//parent::div/following-sibling::div//p");
    By messageErrorPhoneText = By.xpath("//div[contains(text(),'Số Liên H')]//parent::legend//parent::div/following-sibling::div//p");
    By messageErrorEmailText = By.xpath("//div[contains(text(),'Email')]//parent::legend//parent::div/following-sibling::div//p");
    By messageErrorClassInText = By.xpath("//div[contains(text(),'Số ClassIn')]//parent::legend//parent::div/following-sibling::div//p");
    By notifyMessage = By.xpath("//div[@id='notistack-snackbar']");

    //
    private final By nameInput = By.xpath("//input[@name=\"fullName\"]");
    private final By mailInput = By.xpath("//input[@name=\"email\"]");

    public boolean CheckMassageErrorFullName() {
        return verifyElementIsDisplay(messageErrorFullNameText,1);
    }

    public boolean CheckMassageErrorPhone() {
        return verifyElementIsDisplay(messageErrorPhoneText,1);
    }

    public boolean CheckMessageErrorEmail() {
        return verifyElementIsDisplay(messageErrorEmailText,1);
    }

    public boolean CheckMessageErrorClassIn() {
        return verifyElementIsDisplay(messageErrorClassInText,1);
    }

    CreateStudentData data;
    CreateStudentPage createStudentPage;
    SearchStudentPage searchStudentPage;

    public ExceptionOfCreateStudent(CreateStudentData createStudentData,CreateStudentPage createStudentPage, SearchStudentPage searchStudentPage) {
        this.data = createStudentData;
        this.createStudentPage =createStudentPage;
        this.searchStudentPage = searchStudentPage;
    }

    public String getTextCommonError() {
        String massage = "";
        if (CheckMassageErrorFullName()) {
            massage = massage + "FullName ";
        }
        if (CheckMassageErrorPhone()) {
            massage = massage + "Phone ";
        }
        if (CheckMessageErrorEmail()) {
            massage = massage + "Mail ";
        }
        if (CheckMessageErrorClassIn()) {
            massage = massage + "ClassIn";
        }
        return massage;
    }

    public boolean CheckNotifyMessage() {
        return verifyElementIsDisplay(notifyMessage);
    }


    public String getTextNotify() {
        return getTextElement(notifyMessage);
    }

    public void fixMailExist() {
        if (getTextNotify().contains(messageMailExist)){
            for (int i = 1 ; i<10; i++){
                data.setMail(data.getPhone() +"@"+ i + "SpeakWell.com");
                /*exception.fixNotifyMailExist();*/
                createStudentPage.EnterInformation();
                if (CheckNotifyMessage()){
                    if (getTextNotify().contains(messageMailExist)){
                        i++;
                    }
                }
                //Trường hợp nhập lại báo classin phone đã tồn tại
                else if (getTextNotify().contains(messageClassIn)||getTextNotify().contains(phoneAndName)){
                    fixClassInPhoneExist();
                }
                else {
                    //Giải quyết xong phần id bos
                    searchStudentPage.getInformationIdBos();
                    break;
                }
            }
        }
    }
    public void fixClassInPhoneExist(){
        searchStudentPage.getInformationIdBosExist();
    }


    public void fixMessageError() {
        for (int i = 1 ; i <10; i++){
            if (getTextCommonError().contains("Mail")) {
                data.setMail(data.getPhone()+"@"+ i + "SpeakWell.com" );
            }
        }
    }
}
