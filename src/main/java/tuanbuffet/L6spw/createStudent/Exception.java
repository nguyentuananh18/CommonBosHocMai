package tuanbuffet.L6spw.createStudent;
import static tuanbuffet.common.WebUI.*;
import org.openqa.selenium.By;

public class Exception {
    By messageErrorFullNameText = By.xpath("//div[contains(text(),'Tên Đầy Đủ')]//parent::legend//parent::div/following-sibling::div//p");
    By messageErrorPhoneText = By.xpath("//div[contains(text(),'Số Liên H')]//parent::legend//parent::div/following-sibling::div//p");
    By messageErrorEmailText = By.xpath("//div[contains(text(),'Email')]//parent::legend//parent::div/following-sibling::div//p");
    By messageErrorClassInText = By.xpath("//div[contains(text(),'Số ClassIn')]//parent::legend//parent::div/following-sibling::div//p");
    By notifyMessage = By.xpath("//div[@id='notistack-snackbar']");


    String messageMail = "Email đã tồn tại";
    String messageClassIn = "ClassIn Phone đã tồn tại";

    public boolean CheckMassageErrorFullName(){
        return verifyElementIsDisplay(messageErrorFullNameText);
    }
    public boolean CheckMassageErrorPhone(){
        return verifyElementIsDisplay(messageErrorPhoneText);
    }
    public boolean CheckMessageErrorEmail(){
        return verifyElementIsDisplay(messageErrorEmailText);
    }
    public boolean CheckMessageErrorClassIn(){
        return verifyElementIsDisplay(messageErrorClassInText);
    }
    public String getTextCommonError(){
        String massage = "";
        if (CheckMassageErrorFullName()){
            massage = massage + "FullName ";
        }if (CheckMassageErrorPhone()){
            massage = massage + "Phone ";
        }
        if (CheckMessageErrorEmail()){
            massage = massage + "Mail ";
        }
        if (CheckMessageErrorClassIn()){
            massage = massage + "ClassIn";
        }
        return massage;
    }
    public void ErrorHandling(){
        //
    }

    public String getNotifyMessage(){
        if (veryElementIsDisplay(notifyMessage,2)){
            return getTextElement(notifyMessage);
        }
        else return "";
    }
}
