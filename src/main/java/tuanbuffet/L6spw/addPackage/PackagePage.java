package tuanbuffet.L6spw.addPackage;

import org.openqa.selenium.By;
import tuanbuffet.L6spw.commonL6.Product;

import static tuanbuffet.common.WebUI.*;

public class PackagePage {

    String URl = "https://spu.bos.hocmai.com/students/";
    By addPackageButton = By.xpath("//button[normalize-space()='Thêm Gói']");
    By selectProductButton = By.xpath("(//label[contains(text(),'Chọn Sản Phẩm')])[1]//following-sibling::div/input");
    By selectPackageButton = By.xpath("(//label[contains(text(),'Chọn Gói')])[1]//following-sibling::div/input");
    By addButton = By.xpath("//button[normalize-space()='Thêm']");
    By firstOption = By.xpath("//*[contains(@id,'-option-0')]");
    By notifyMessageText = By.xpath("//div[@id='notistack-snackbar']");

    PackageAndConfiurationData packageData;
    Product product;

    public PackagePage(PackageAndConfiurationData packageData) {
        this.packageData = packageData;
    }
    public boolean enterInformationPackage() {
        product = new Product(packageData.getClassType(), packageData.getTeacher());
        openURL(URl + packageData.getIdBos().substring(2) + "/package");
        String productName = product.getProductCourseName();
        System.out.println(productName);
        clickElement(addPackageButton);
        enterText(selectProductButton, productName);
        clickElement(firstOption);
        enterText(selectPackageButton, "320" );
        clickElement(firstOption);
        clickElement(addButton);
        return getTextElement(notifyMessageText).contains("Tạo Gói Mới Thành Công");
    }
}
