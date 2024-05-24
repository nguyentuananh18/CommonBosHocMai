package tuanbuffet.L6spw.createStudent;

import org.openqa.selenium.By;

import static tuanbuffet.common.WebUI.*;
import static tuanbuffet.common.StringProcessing.*;

public class SearchStudentPage {
    private String URl = "https://spu.bos.hocmai.com/students";
    By searchInput = By.xpath("//input[@name=\"nameOrPhoneOrCode\"]");
    By searchButton = By.xpath("//button[contains(text(),'Tìm Kiếm')]");
    By listStudentData = By.xpath("//tbody/tr");
    By listPackage = By.xpath("//tbody/tr");
    By packageButton = By.xpath("//button[ @type=\"button\" and  contains(text(),'Gói')]");
    CreateStudentData createStudentData;

    public SearchStudentPage(CreateStudentData data) {
        this.createStudentData = data;
    }

    public String getInformationIdBos() {
        enterText(searchInput, createStudentData.getPhone());
        clickElement(searchButton);
        String idBos = "TK success";
        for (int i = 1; i <= listElements(listStudentData); i++) {
            String classInOnWeb = getTextElement(By.xpath("//tbody/tr[" + i + "]/td[4]"));
            String idBosOnWeb = getTextElement("//tbody/tr[" + i + "]/td[1]");
            if (classInOnWeb.contains(createStudentData.getPhone())) {
                idBos = idBosOnWeb;
                break;
            } else if (i == listElements(listStudentData)) {
                idBos = "Trùng TK";
            }
        }
        return idBos;
    }

    public String getInformationIdBosExist() {
        openURL(URl);
        enterText(searchInput, createStudentData.getPhone());
        clickElement(searchButton);
        String idBos = "Trùng TK";
        for (int i = 1; i <= listElements(listStudentData); i++) {
            String classInOnWeb = getTextElement(By.xpath("//tbody/tr[" + i + "]/td[4]"));
            String idBosOnWeb = getTextElement("//tbody/tr[" + i + "]/td[1]");
            String nameOnWeb = getTextElement("//tbody/tr[" + i + "]/td[2]");
            if (classInOnWeb.equals(createStudentData.getAreaCode().substring(0, 3) + createStudentData.getPhoneAfterEditing()) || classInOnWeb.equals("+" + createStudentData.getPhone())) {
                if (removeAccent(nameOnWeb.toLowerCase()).contains(removeAccent(createStudentData.getName().toLowerCase())) || removeAccent(createStudentData.getName().toLowerCase()).contains(removeAccent(nameOnWeb.toLowerCase()))) {
                    idBos = idBosOnWeb;
                    break;
                } else {
                    clickElement(By.xpath("//tbody/tr[\" + i + \"]/td[2]"));
                    sleep(0.5);
                    switchToWindows(1);
                    clickElement(packageButton);
                    sleep(1);
                    if (getTextElement(By.xpath("//tbody/tr/td/p[1]")).contains("Không Có Dữ Liệu")) {
                        closeWindow();
                        switchToWindows(0);
                        idBos = idBosOnWeb;
                        break;
                    } else {
                        int numberPackage = listElements(listPackage);
                        for (int j = 1; j <= numberPackage; j++) {
                            if (getTextElement(By.xpath("//tbody/tr[" + j + "]/td[3]/span")).contains("Official")) {
                                closeWindow();
                                switchToWindows(0);
                                break;
                            } else {
                                if (j == numberPackage) {
                                    idBos = idBosOnWeb;
                                    closeWindow();
                                    switchToWindows(0);
                                    break;
                                }
                            }
                        }
                    }

                }
            }
        }
        return idBos;
    }

}
