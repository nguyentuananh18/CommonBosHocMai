package tuanbuffet.L6spw.addPackage;
import org.openqa.selenium.By;
import static tuanbuffet.common.WebUI.*;
public class ConfigurationPage {
    String URL = "https://spu.bos.hocmai.com/students/";
    By contentPage = By.xpath("//p[normalize-space()='08:25 - 08:55']");
    By teachAllCheckBox = By.xpath("//p[contains(.,'Dạy Tất Cả')]/following-sibling::span/input");

    //MuiCheckbox-root MuiCheckbox-colorPrimary MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root css-1iswrpk

    //MuiCheckbox-root MuiCheckbox-colorPrimary MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root Mui-checked css-1iswrpk
    By teachAllButton = By.xpath("//p[contains(.,'Dạy Tất Cả')]/following-sibling::span");
    By saveButton = By.xpath("//button[contains(text(),'Lưu Lại')]");
    By notifyMessageText = By.xpath("//div[@id='notistack-snackbar']");
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
            if (!getAttributeElement(teachAllButton,"class").contains("Mui-checked")){
                clickElement(teachAllButton);
                sleep(1);
                clickElement(saveButton);
                return getTextElement(notifyMessageText).contains("Cập nhật ca học thành công!");
            }
            else{
                clickElement(saveButton);
                return getTextElement(notifyMessageText).contains("Cập nhật ca học thành công!");
            }
        }

    }
}
