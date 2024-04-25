package tuanbuffet.L6spw.createStudent;

import org.openqa.selenium.By;
import static tuanbuffet.common.WebUI.*;

public class SearchStudentPage {
    private String URl = "https://spu.bos.hocmai.com/students";
    By searchInput = By.xpath("//input[@name=\"nameOrPhoneOrCode\"]");
    By searchButton = By.xpath("//button[contains(text(),'Tìm Kiếm')]");

    By listStudentData = By.xpath("//tbody/tr");

    StudentData studentData;
    public SearchStudentPage(StudentData studentData){
        this.studentData = studentData;
    }


    public String getInformationHV(){
        openURL(URl);
        enterText(searchInput,studentData.getPhone());
        clickElement(searchButton);
        String idBos = null;
        for (int i = 1; i<=listElements(listStudentData) ; i++){
            String classInOnWeb = getTextElement(By.xpath("//tbody/tr["+ i +"]/td[4]"));
            String idBosOnWeb = getTextElement("//tbody/tr["+ i +"]/td[1]");
            if (classInOnWeb.contains(studentData.getPhone())){
                idBos = idBosOnWeb;
                break;
            }
        }
        return idBos;
    }
}
