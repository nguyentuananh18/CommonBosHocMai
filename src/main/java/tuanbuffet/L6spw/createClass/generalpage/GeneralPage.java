package tuanbuffet.L6spw.createClass.generalpage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static tuanbuffet.common.WebUI.*;

public class GeneralPage {
    private By selectProductInput = By.xpath("//input[@placeholder=\"Chọn Sản Phẩm\"]");
    private By nameClassInput = By.xpath("//input[@placeholder=\"Nhập Tên Lớp\"]");
    private By numberStudentInput = By.xpath("//input[@placeholder=\"Chọn Số Lượng Tối Đa Học Viên\"]");
    private By typeClassInput = By.xpath("//input[@placeholder=\"Chọn Loại Lớp\"]");
    private By CSKHInput = By.xpath("//input[@placeholder=\"Chọn CKSH\"]");
    private By submitButton = By.xpath("//button[contains(text(),'Tiếp Tục')]");

    //nhap thong tin
    public void Enterinformation(GeneralData data) throws InterruptedException {
        openURL("https://spu.bos.hocmai.com/classes/create");
        sleep(2);
        enterText(selectProductInput, data.product.getProductCourseName() + Keys.DOWN + Keys.ENTER);
        sleep(1);
        enterText(nameClassInput, data.className.getClassName() + Keys.DOWN + Keys.ENTER);
        sleep(1);
        enterText(numberStudentInput, "5" + Keys.DOWN + Keys.ENTER);
        sleep(0.5);
        enterText(typeClassInput, "Chính Thức" + Keys.DOWN + Keys.ENTER);
        sleep(0.5);
        enterText(CSKHInput, "(cs) - ( CS Default )" + Keys.DOWN + Keys.ENTER);
        sleep(0.5);
        clickElement(submitButton);
        sleep(2);
    }
}
