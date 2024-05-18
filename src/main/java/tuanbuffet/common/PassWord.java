package tuanbuffet.common;

import org.openqa.selenium.By;

import static tuanbuffet.common.WebUI.*;

public class PassWord {
    String url ="https://2fa.live/";
    By TextInput = By.xpath("//textarea[@id='listToken']");
    By submitButton = By.xpath("//a[@id='submit']");
    By TextOutPut = By.xpath("//textarea[@id='output']");
    public String CheckPassWord(){
        HideBrowers();
        openURL(url);
        enterText(TextInput, "NTA");
        clickElement(submitButton);
        String pass;
        try {
            pass = getAttributeElement(TextOutPut,"value").substring(5);
        }
        catch (Exception e){
            pass = getAttributeElement(TextOutPut,"value").substring(5);
        }

        closeBrowser();
        return pass;

    }

    public static void main(String[] args) throws InterruptedException {
        PassWord passWord = new PassWord();
        passWord.CheckPassWord();
    }
}
