package tuanbuffet.L6spw.addPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import tuanbuffet.common.Product;

import static tuanbuffet.common.WebUI.*;

public class PackagePage {

    String URl = "https://spu.bos.hocmai.com/students/";
    By addPackageButton = By.xpath("//button[normalize-space()='Thêm Gói']");
    By selectProductButton = By.xpath("(//label[contains(text(),'Chọn Sản Phẩm')])[1]//following-sibling::div/input");
    By selectPackageButton = By.xpath("(//label[contains(text(),'Chọn Gói')])[1]//following-sibling::div/input");
    By addButton = By.xpath("//button[normalize-space()='Thêm']");

    Data packageData;

    public PackagePage(Data packageData){
        this.packageData = packageData;
    }
    public void enterInformationPackage(){
        Product product = new Product(packageData.getClassType(),packageData.getTeacher());
        openURL(URl +packageData.getIdBos().substring(2) + "/package" );
        System.out.println(product.getProductCourseName());
        clickElement(addPackageButton);
        enterText(selectProductButton,product.getProductCourseName() + Keys.DOWN + Keys.ENTER);
        enterText(selectPackageButton,"320"  + Keys.DOWN + Keys.ENTER);
        /*clickElement(addButton);*/
    }

}
