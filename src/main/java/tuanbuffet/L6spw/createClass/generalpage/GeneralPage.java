package tuanbuffet.L6spw.createClass.generalpage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import static tuanbuffet.common.WebUI.*;
import static tuanbuffet.L6spw.commonL6.BybyCommon.*;

public class GeneralPage {
    private By selectGroupProducInput = By.xpath("//input[@placeholder=\"Chọn Nhóm Sản Phẩm\"]");
    private By selectProductInput = By.xpath("//input[@placeholder=\"Chọn Sản Phẩm\"]");
    private By nameClassInput = By.xpath("//input[@placeholder=\"Nhập Tên Lớp\"]");
    private By numberStudentInput = By.xpath("//input[@placeholder=\"Chọn Số Lượng Tối Đa Học Viên\"]");
    private By typeClassInput = By.xpath("//input[@placeholder=\"Chọn Loại Lớp\"]");
    private By CSKHInput = By.xpath("//input[@placeholder=\"Chọn CKSH\"]");
    private By submitButton = By.xpath("//button[contains(text(),'Tiếp Tục')]");

    GeneralData generalData;
    public GeneralPage(){

    }
    public GeneralPage(GeneralData generalData){
        this.generalData = generalData;
    }

    //nhap thong tin
    public void Enterinformation(){
        openURL("https://spu.bos.hocmai.com/classes/create");
        String productName = generalData.product.getProductCourseName();
        String className = generalData.className.getClassName();
        enterText(selectGroupProducInput,productName);
        sleep(1);
        clickElement(firstOption);
        enterText(selectProductInput,productName);
        clickElement(firstOption);
        enterText(nameClassInput,className);
        System.out.println(className);
        sleep(1);
        enterText(numberStudentInput, "5");
        sleep(1);
        enterText(typeClassInput, "Chính Thức");
        sleep(1);
        clickElement(firstOption);
        enterText(CSKHInput, "(cs) - ( CS Default )");
        sleep(1);
        clickElement(firstOption);
        clickElement(submitButton);
        sleep(1);
    }

}
