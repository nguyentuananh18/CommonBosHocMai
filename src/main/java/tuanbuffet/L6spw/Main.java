package tuanbuffet.L6spw;

import tuanbuffet.L6spw.curriculumPage.CurriculumData;
import tuanbuffet.L6spw.curriculumPage.CurriculumPage;
import tuanbuffet.L6spw.generalpage.ClassName;
import tuanbuffet.L6spw.generalpage.GeneralData;
import tuanbuffet.L6spw.generalpage.GeneralPage;
import tuanbuffet.L6spw.generalpage.Product;
import tuanbuffet.L6spw.schedulePage.Curriculum;
import tuanbuffet.L6spw.schedulePage.ScheduleData;
import tuanbuffet.L6spw.schedulePage.SchedulePage;
import tuanbuffet.L6spw.stuendtPage.StudentData;
import tuanbuffet.L6spw.stuendtPage.StudentPage;
import tuanbuffet.common.Login;

public class Main {
    public static String[][] information = {
            {"TestDemo", "phamthithuthao19071981@gmail.com", "396670435", "SPU 1:2", "Thứ sáu : 19:10-19:40 Thứ bảy : 19:10-19:40", "Trishamae", "Kid's Box Movers 1", "ST111810"},
            /*{"Lê Bảo Nam 3","phamthithuao71981@gmail.com","3966435","SPU 1:1","Thứ sáu : 19:10-19:40 Thứ bảy : 19:10-19:40","Trishamae","Kid's Box Movers 1","ST111810"},
            {"Kangdokyun","dothihued@gmail.com","821073130995","SPU 1:1","Thứ hai: 14:00-14:30 Thứ ba: 14:00-14:30 Thứ tư: 14:00-14:30 Thứ sáu: 14:00-14:30","Yến Nhi 7","Kid's Box Movers","ST096531"},
            {"Kangdokyun2","dothihued@gmail.com","821073130995","SPU 1:1","Thứ hai: 14:00-14:30 Thứ ba: 14:00-14:30 Thứ tư: 14:00-14:30 Thứ sáu: 14:00-14:30","Yến Nhi 7","Kid's Box Movers","ST096531"},*/
    };

    public static void main(String[] args) throws InterruptedException {
        Login login = new Login();
        login.login("ctvanhnt2","anhnt216836");
        GeneralPage generalPage = new GeneralPage();
        ClassName className;
        StudentData studentData;
        Curriculum curriculum;
        ScheduleData scheduleData;
        SchedulePage schedule;
        CurriculumData curriculumData;
        CurriculumPage curriculumPage;

        for (int i = 0; i < information.length; i++) {
            Product product = new Product(information[i][3], information[i][5]);
            if (i < information.length - 1) {
                className = new ClassName(information[i][0], information[i][3], information[i][4], information[i][5], information[i][6], information[i + 1][0], information[i + 1][3], information[i + 1][4], information[i + 1][5], information[i + 1][6]);
            } else {
                className = new ClassName(information[i][0], information[i][3], information[i][4], information[i][5], information[i][6], "", "", "", "", "");

            }
            GeneralData generalData = new GeneralData(product, className);
            if (!className.getClassName().isEmpty()) {
                generalPage.Enterinformation(generalData);
                curriculum = new Curriculum(information[i][6]);
                scheduleData = new ScheduleData(curriculum);
                schedule = new SchedulePage();
                schedule.Enterinformation(scheduleData);
                if (i < information.length - 1) {
                    studentData = new StudentData(information[i][7], information[i + 1][7]);
                } else {
                    studentData = new StudentData(information[i][7], "");
                }
                StudentPage studentPage = new StudentPage();
                studentPage.Enterinformation(studentData);
                curriculumData = new CurriculumData(information[i][6]);
                curriculumPage = new CurriculumPage(curriculumData);
                curriculumPage.Enterinformation();
            }
        }

    }
}