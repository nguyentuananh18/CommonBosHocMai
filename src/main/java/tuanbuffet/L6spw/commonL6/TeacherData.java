package tuanbuffet.L6spw.commonL6;

import org.openqa.selenium.By;
import tuanbuffet.controlExcelFile.ExcelHelper;


import static tuanbuffet.common.WebUI.*;
import static  tuanbuffet.common.StringProcessing.*;
import static tuanbuffet.L6spw.commonL6.BybyCommon.*;
import static tuanbuffet.common.Login.*;
public class TeacherData implements Runnable{
    ExcelHelper excel = new ExcelHelper();
    static String url = "https://spu.bos.hocmai.com/teachers";
    String productVietNam = "SPEAKWELL - GV Việt Nam 1:1";
    String proPhil = "SPEAKWELL - GV Philippines 1:1";
    String proNamPhi = "SPEAKWELL - GV Nam Phi 1:1";
    String proUSUK = "SPEAKWELL - GV US/UK 1:1";
    By selectProduct = By.xpath("//input[@placeholder=\"Chọn Sản Phẩm\"]");
    By searchButton = By.xpath("//button[contains(text(),'Tìm Kiếm')]");
    By nextButton = By.xpath("//button[@title='Go to next page']//*[name()='svg']");

    public TeacherData(){
    }

    public void UpTeacherOnFile() throws InterruptedException {
        TeacherData listTeacherName = new TeacherData();
        excel.setExcelFile("C:\\dataAutoBos\\ListTeacher.xlsx", "Sheet1");
        openBrowser();
        login("ctvanhnt2", "anhnt216836");
        try {
            listTeacherName.runGetListGV(listTeacherName.productVietNam, "GVVN");

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            listTeacherName.runGetListGV(listTeacherName.proNamPhi, "GVNP");

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            listTeacherName.runGetListGV(listTeacherName.proPhil,"GVPHIL");

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            listTeacherName.runGetListGV(listTeacherName.proUSUK,"GVUSUK");

        } catch (Exception e) {
            e.printStackTrace();
        }
        closeBrowser();

    }

    public void runGetListGV(String product, String columTeacherName){
//        for (int i =0; i<4;i++){
//            openURL(url);
//            verifyElementIsDisplay(By.xpath("//h4[normalize-space()='Danh Sách Giáo Viên']"));
//            sleep(2);
//            enterText(selectProduct, product);
//            sleep(1);
//            clickElement(firstOption);
//            String textFirst = getTextElement(numberOfPage);
//            System.out.println(textFirst);
//            clickElement(searchButton);
//            sleep(2);
//
//            for (int j = 0; j<1; j++){
//                String textLast = getTextElement(numberOfPage);
//                if (!textLast.equals(textFirst) && !textLast.contains("0–0 of 0")){
//                    System.out.println(textFirst);
//                    System.out.println(textLast + "::::" + textFirst + "Mong muốn");
//                    textFirst = getTextElement(numberOfPage);
//                    break;
//                }
//                else{
//                    sleep(1);
//                    System.out.println(textLast);
//                    j = 0;
//                }
//            }
//
//
//
//            for (int j = 0; j < 15; j++) {
//                for (int k = 1; k <=50; k++) {
//                    excel.setExcelFile("C:\\dataAutoBos\\ListTeacher.xlsx", "Sheet1");
//                    excel.setCell(getTextElement(By.xpath("//table/tbody/tr[" + j + "]/td[2]")), columTeacherName, j+i*50);
//                }
//                System.out.println(getAttributeElement(nextButton,"class").contains("disabled"));
//                if (getAttributeElement(nextButton,"class").contains("disabled")){
//                    break;
//                }
//                else {
//                    clickElement(nextButton);
//                    for (int k =0; k<5; k++){
//                        if (!getTextElement(numberOfPage).equals(textFirst)){
//                            textFirst = getTextElement(numberOfPage);
//                            break;
//                        }
//                        else sleep(1);
//                    }
//                }
//
//            }
//        }
        openURL(url);
        verifyElementIsDisplay(By.xpath("//h4[normalize-space()='Danh Sách Giáo Viên']"));
        if (verifyElementIsDisplay(selectProduct,5)){
            enterText(selectProduct, product);
        }
        else {
            clickElement(searchCommonButton);
            sleep(2);
            enterText(selectProduct, product);
        }

        sleep(1);
        clickElement(firstOption);
        String textFirst = getTextElement(numberOfPage);
        System.out.println(textFirst);

        clickElement(searchButton);
        sleep(2);
        for (int i = 0; i<1; i++){
            String textLast = getTextElement(numberOfPage);
            if (!textLast.equals(textFirst) && !textLast.contains("0–0 of 0")){
                System.out.println(textFirst);
                System.out.println(textLast + "::::" + textFirst + "Mong muốn");
                textFirst = getTextElement(numberOfPage);
                break;
            }
            else{
                sleep(1);
                System.out.println(textLast);
                i = 0;
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 1; j <=50; j++) {
                excel.setExcelFile("C:\\dataAutoBos\\ListTeacher.xlsx", "Sheet1");
                excel.setCell(getTextElement(By.xpath("//table/tbody/tr[" + j + "]/td[2]")), columTeacherName, j+i*50);
            }
            System.out.println(getAttributeElement(nextButton,"class").contains("disabled"));
            if (getAttributeElement(nextButton,"class").contains("disabled")){
                break;
            }
            else {
                clickElement(nextButton);
                for (int k =0; k<5; k++){
                    if (!getTextElement(numberOfPage).equals(textFirst)){
                        textFirst = getTextElement(numberOfPage);
                        break;
                    }
                    else sleep(1);
                }
            }

        }
    }

    @Override
    public void run() {

    }
}
