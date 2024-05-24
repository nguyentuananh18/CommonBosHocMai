package tuanbuffet.L6spw.createClass.stuendtPage;

import org.openqa.selenium.By;
import tuanbuffet.L6spw.addPackage.ConfigurationPage;
import tuanbuffet.L6spw.addPackage.PackageAndConfiurationData;
import tuanbuffet.L6spw.addPackage.PackagePage;

import static tuanbuffet.common.WebUI.*;

public class StudentPage {
    private final By informationStudentInput = By.xpath("//input[@placeholder=\"Tìm Kiếm Theo Mã, SĐT Và Tên Học Viên\"]");
    private final By searchButton = By.xpath("//form/div/div//button[contains(text(),'Tìm ')]");
    private final By nameStudentText = By.xpath("//*[@id=\"root\"]/div/main/form/div[2]/div[1]/div[2]/div[2]/div[1]/table/tbody/tr/td[1]");
    private final By addStudentButton = By.xpath("//tbody/tr/td//button[text()='Thêm']");
    private final By saveAndContinueButton = By.xpath("//button[contains(text(),'Lưu Và Tiếp Tục')]");
    private final By courseInformationText = By.xpath("//form//legend[contains(text(),'SPEAKWELL - GV')]");

    By notifyMessage = By.xpath("//div[@id='notistack-snackbar']");

    By listStudentAdded = By.xpath("//legend[contains(text(),'Học Viên Đã Thêm')]//following-sibling::div//tbody/tr");
    By errorAddStudentText = By.xpath("//legend[contains(text(),'Học Viên Đã Thêm')]//following-sibling::div//tbody/tr[i]/td/span");
    String addHvSuccess = "Lưu Thành Công";
    String addHvErrorNotAvailable = "Student không có đủ available sessions";
    String addHVErrorPackage = "Gói của học viên đã hết hạn";
    String addTotalSuccess = "Lưu Thành Công";
    String errorSession = "Student đã tham gia vào một session khác ở thời điểm này";
    StudentData studentData;
    PackageAndConfiurationData packageAndConfiurationData;
    PackagePage packagePage;
    ConfigurationPage configurationPage;

    public StudentPage(StudentData studentData, PackageAndConfiurationData packageAndConfiurationData) {
        this.studentData = studentData;
        this.packageAndConfiurationData = packageAndConfiurationData;
    }

    public String Enterinformation() {
        String noteErrorId = "";
        if (!studentData.getIdBos1().isEmpty()){
            if (EnterIdBos(studentData.getIdBos1())) {
                noteErrorId += studentData.getIdBos1();
            }
        }
        if (checkClassType() == 2) {
            if (!studentData.getIdBos2().isEmpty()){
                if (EnterIdBos(studentData.getIdBos2())) {
                    noteErrorId += studentData.getIdBos2();
                }
            }
        }
        clickElement(saveAndContinueButton);
        return noteErrorId;

    }

    public boolean EnterIdBos(String idBos) {
        enterText(informationStudentInput, idBos);
        sleep(1);
        clickElement(searchButton);
        sleep(5);
        //Nếu như có thấy HV
        if (verifyElementIsDisplay(addStudentButton)) {
            clickElement(addStudentButton);
            sleep(3);
            //Nếu như HV được add thành công
            if (getTextElement(notifyMessage).contains(addHvSuccess)) {
                sleep(2);
                return true;
            } else {
                ReAddPackageAndOpenSchedule();
                sleep(2);
                clickElement(addStudentButton);
                sleep(3);
                if (getTextElement(notifyMessage).contains(addHvSuccess)) {
                    sleep(5);
                    return true;
                } else return false;
            }
        } else {
            // ngược lại nếu không thấy học viên, thì sẽ add gói và mở lịch, sau đó tìm lại
            ReAddPackageAndOpenSchedule();
            sleep(1);
            clearText(informationStudentInput);
            enterText(informationStudentInput, idBos.substring(1));
            sleep(1);
            clickElement(searchButton);
            sleep(3);
            if (verifyElementIsDisplay(addStudentButton)) {
                clickElement(addStudentButton);
                System.out.println("Đã tìm thấy Học viên và add vào lớp");
                sleep(3);
                if (getTextElement(notifyMessage).contains(addHvSuccess)) {
                    sleep(5);
                    return true;
                } else return false;
            } else {
                System.out.print("lỗi add " + idBos + " vào lớp! |");
                return false;
            }
        }
    }

    public void ReAddPackageAndOpenSchedule() {
        System.out.println("Không tìm thấy Học viên, đang add lại gói và mở full lịch");
        newWindow();
        packagePage = new PackagePage(packageAndConfiurationData);
        configurationPage = new ConfigurationPage(packageAndConfiurationData);
        packagePage.enterInformationPackage();
        configurationPage.OpenTeachAll();
        closeWindow();
        switchToWindows(0);
    }

    public int checkClassType() {
        if (getTextElement(courseInformationText).contains("1:2")) {
            return 2;
        } else return 1;
    }
}
