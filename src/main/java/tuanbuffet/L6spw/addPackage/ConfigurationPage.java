package tuanbuffet.L6spw.addPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import tuanbuffet.common.Product;

import static tuanbuffet.common.WebUI.*;

public class ConfigurationPage {
    String URL = "https://spu.bos.hocmai.com/students/";
    By teachAllButton = By.xpath("//p[contains(.,'Dạy Tất Cả')]/following-sibling::span");
    By saveButton = By.xpath("//button[contains(text(),'Lưu Lại')]");
    Data data;
    public ConfigurationPage(Data data){
        this.data = data;
    }
    public  void OpenTeachAll(){
        openURL(URL + data.getIdBos().substring(2) + "/configurationPage");
        clickElement(teachAllButton);
        /*clickElement(saveButton);*/
    }
}
