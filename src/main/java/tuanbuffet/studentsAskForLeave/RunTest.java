package tuanbuffet.studentsAskForLeave;
import static tuanbuffet.common.WebUI.*;
import static tuanbuffet.common.Login.*;
import tuanbuffet.controlExcelFile.ExcelHelper;
import tuanbuffet.studentsAskForLeave.deleteByClassList.DeleteByClassListPage;
import tuanbuffet.studentsAskForLeave.deleteByOverView.DeleteByOverviewPage;

public class RunTest{

    public static void main(String[] args) throws InterruptedException {
        StudentLeaveData studentLeaveData;
        DeleteByClassListPage deleteByClassListPage;
        DeleteByOverviewPage deleteByOverviewPage;
        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("C:\\dataAutoBos\\deleteHV.xlsx", "Sheet1");
        openBrowser();
        login("ctvanhnt2", "anhnt216836");
        for (int i = 1 ; ;i++){
            String name = excel.getCell("name",i);
            String idBosST = excel.getCell("idbos",i);
            String reason = excel.getCell("reason",i);
            String schedule = excel.getCell("schedule",i);
            String classType = excel.getCell("classType",i);
            String teacher = excel.getCell("teacher",i);
            if (name.isEmpty()) break;
            studentLeaveData = new StudentLeaveData(idBosST,name,reason,schedule,classType,teacher);
            deleteByClassListPage = new DeleteByClassListPage(studentLeaveData);
            deleteByOverviewPage = new DeleteByOverviewPage(studentLeaveData);
            System.out.println("Đang tìm kiếm lớp học:" + name);
            if (deleteByClassListPage.SearchByClass()){
                //xử lý phần xóa lớp
                deleteByClassListPage.SelectClass();
            }
            else {
                if (deleteByOverviewPage.SearchClass()){
                    //xử lý phần xóa lớp dạng 2
                    System.out.println("Đã thấy lớp học, đang tìm lớp đúng thông tin");
                }
                else {
                    // => tìm cả 2 cách đều k thấy lớp
                }
            }
        }
    }
}
