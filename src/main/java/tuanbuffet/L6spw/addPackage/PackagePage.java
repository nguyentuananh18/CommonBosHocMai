package tuanbuffet.L6spw.addPackage;

import org.openqa.selenium.By;
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
    By addButton = By.xpath("//button[normalize-space()='Thêm']");

    PackageAndConfiurationData packageData;
    Product product;
    List<Teacher> listTeacher;

    public PackagePage(PackageAndConfiurationData packageData, List<Teacher> listTeacher) {
        this.packageData = packageData;
        this.listTeacher = listTeacher;
    }
    public boolean addPackage() {
        product = new Product(packageData.getClassType(), packageData.getTeacher(), listTeacher);
        sleep(3);
        openURL(URl + packageData.getIdBos().substring(2) + "/package");
        String productName = product.getProductCourseName();
        System.out.println(productName);
        clickElement(addPackageButton);
        try {
            enterText(selectProductButton, productName);
            clickElement(firstOption);
        }
        catch (Exception e){
            enterText(selectProductButton, productName);
            clickElement(firstOption);
        }
        try {
            enterText(selectPackageButton, "320" );
            clickElement(firstOption);
        }
        catch (Exception e){
            clearText(selectPackageButton);
            enterText(selectPackageButton, "320" );
            clickElement(firstOption);
        }
        sleep(1);
        clickElement(addButton);
        sleep(1);
        return getTextElement(notifyMessage).contains("Tạo Gói Mới Thành Công");
    }
}
