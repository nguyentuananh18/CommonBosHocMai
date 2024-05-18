package tuanbuffet.studentsAskForLeave;
import static tuanbuffet.common.WebUI.*;
import static tuanbuffet.common.Login.*;
import tuanbuffet.controlExcelFile.ExcelHelper;

public class RunTest{

    public static void main(String[] args) throws InterruptedException {
        StudentLeaveData studentLeaveData;
        DeleteStudentLeavePage deleteStudentLeavePage;
        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("C:\\dataAutoBos\\deleteHV.xlsx", "Sheet1");
        openBrowser();
        login("ctvanhnt2", "anhnt216836");
        for (int i = 1 ; ;i++){
            String name = excel.getCell("name",i);
            String idbos = excel.getCell("idbos",i);
            String reason = excel.getCell("reason",i);
            String schedule = excel.getCell("schedule",i);
            String classType = excel.getCell("classType",i);
            String teacher = excel.getCell("teacher",i);
            if (name.isEmpty()){
                break;
            }
            studentLeaveData = new StudentLeaveData(idbos,name,reason,schedule,classType,teacher);
            deleteStudentLeavePage = new DeleteStudentLeavePage(studentLeaveData);
            if (deleteStudentLeavePage.SearchByClass()){
                deleteStudentLeavePage.SelectClass();
            }

        }

    }
}
