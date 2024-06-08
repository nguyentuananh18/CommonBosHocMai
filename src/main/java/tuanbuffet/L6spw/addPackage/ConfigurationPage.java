package tuanbuffet.L6spw.addPackage;
import org.openqa.selenium.By;
import static tuanbuffet.common.WebUI.*;
import static tuanbuffet.L6spw.commonL6.BybyCommon.*;
import static  tuanbuffet.common.StringProcessing.*;
public class ConfigurationPage {
    String URL = "https://spu.bos.hocmai.com/students/";
    By contentPage = By.xpath("//p[contains(text(),'0')]");
    By teachAllButton = By.xpath("//p[contains(.,'Dạy Tất Cả')]/following-sibling::span");
    By saveButton = By.xpath("//button[contains(text(),'Lưu Lại')]");

    PackageAndConfiurationData confiurationData;
    public ConfigurationPage(PackageAndConfiurationData confiurationData){
        this.confiurationData = confiurationData;
    }
    public  boolean OpenTeachAll(){
        if (confiurationData.getIdBos().isEmpty()){
            return false;
        }
        else {
            openURL(URL + confiurationData.getIdBos().substring(2) + "/configuration");
            waitForElementVisible(contentPage);
            clickElement(teachAllButton);
            sleep(1);
            boolean result =false;
            if (!getAttributeElement(teachAllButton,"class").contains("Mui-checked")){
                clickElement(teachAllButton);
                sleep(2);
                try {
                    clickElement(saveButton);
                    result = getTextElement(notifyMessage).contains("Cập nhật ca học thành công!");
                }
                catch (Exception e){
                    clickElement(saveButton);
                    result = getTextElement(notifyMessage).contains("Cập nhật ca học thành công!");
                }

            }
            else{
                sleep(2);
                try {
                    clickElement(saveButton);
                    result = getTextElement(notifyMessage).contains("Cập nhật ca học thành công!");
                }
                catch (Exception e){
                    clickElement(saveButton);
                    result = getTextElement(notifyMessage).contains("Cập nhật ca học thành công!");
                }
            }
            return result;
        }
    }
}
