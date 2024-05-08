package tuanbuffet.L6spw.addPackage;
import org.openqa.selenium.By;
import static tuanbuffet.common.WebUI.*;
public class ConfigurationPage {
    String URL = "https://spu.bos.hocmai.com/students/";
    By contentPage = By.xpath("//p[normalize-space()='08:25 - 08:55']");
    By teachAllButton = By.xpath("//p[contains(.,'Dạy Tất Cả')]/following-sibling::span");
    By saveButton = By.xpath("//button[contains(text(),'Lưu Lại')]");
    addPackageAndConfiurationData data;
    public ConfigurationPage(addPackageAndConfiurationData data){
        this.data = data;
    }
    public  void OpenTeachAll(){
        if (data.getIdBos().isEmpty()){
        }
        else {
            openURL(URL + data.getIdBos().substring(2) + "/configuration");
            waitForElementVisible(contentPage);
            clickElement(teachAllButton);
            /*clickElement(saveButton);*/
        }

    }
}
