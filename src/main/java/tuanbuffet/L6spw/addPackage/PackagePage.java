package tuanbuffet.L6spw.addPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tuanbuffet.L6spw.commonL6.Teacher;
import tuanbuffet.L6spw.commonL6.Product;

import java.util.List;

import static tuanbuffet.common.WebUI.*;
import static  tuanbuffet.common.StringProcessing.*;
import static tuanbuffet.L6spw.commonL6.BybyCommon.*;
public class PackagePage {

    String URl = "https://spu.bos.hocmai.com/students/";
    By addPackageButton = By.xpath("//button[normalize-space()='Thêm Gói']");
    By selectProductButton = By.xpath("(//label[contains(text(),'Chọn Sản Phẩm')])[1]//following-sibling::div/input");
    By selectPackageButton = By.xpath("(//label[contains(text(),'Chọn Gói')])[1]//following-sibling::div/input");
    By creditEasySpeakInput = By.xpath("//input[@placeholder='Số Lượng Credit']");
    By addButton = By.xpath("//button[normalize-space()='Thêm']");

    PackageAndConfiurationData packageData;
    Product product;
    List<Teacher> listTeacher;

    public PackagePage(PackageAndConfiurationData packageData, List<Teacher> listTeacher) {
        this.packageData = packageData;
        this.listTeacher = listTeacher;
    }
    public boolean addPackage() {
        product = new Product(packageData.getClassType(), packageData.getTeacher(),packageData.getCurriculum(), listTeacher);
        sleep(2);
        openURL(URl + packageData.getIdBos().substring(2) + "/package");
        InputProduct();
        InputPackage();
        sleep(1);
        clickElement(addButton);
        sleep(1);
        return getTextElement(notifyMessage).contains("Tạo Gói Mới Thành Công");
    }
    public void InputProduct(){
        String productName = product.getProductCourseName();
        System.out.println(productName);
        clickElement(addPackageButton);
        clickElement(selectProductButton);
        List<WebElement> listProductPackage =ListElements(listOption);
        for (WebElement productPackage : listProductPackage){
            try {
                if (productPackage.getText().equals(productName)){
                    productPackage.click();
                    break;
                }
            }
            catch (Exception ignored){

            }
        }
    }
    public void InputPackage(){
        product = new Product(packageData.getClassType(), packageData.getTeacher(),packageData.getCurriculum(), listTeacher);
        String productName = product.getProductCourseName();
        try {
            if (productName.equals("EasySpeak")){
                enterText(selectPackageButton, "Gói EasySpeak Plus" );
                clickElement(firstOption);
                clearText(creditEasySpeakInput);

                enterText(creditEasySpeakInput,"999999");
            }
            else {
                enterText(selectPackageButton, "320" );
                clickElement(firstOption);
            }

        }
        catch (Exception e){
            clearText(selectPackageButton);
            if (productName.equals("EasySpeak")){
                enterText(selectPackageButton, "Gói EasySpeak Plus" );
                clickElement(firstOption);
                clearText(creditEasySpeakInput);
                enterText(creditEasySpeakInput,"999999");
            }
            else {
                enterText(selectPackageButton, "320" );
                clickElement(firstOption);
            }

        }
    }
}
