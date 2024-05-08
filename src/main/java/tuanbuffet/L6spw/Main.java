package tuanbuffet.L6spw;

import tuanbuffet.L6spw.createClass.curriculumPage.CurriculumData;
import tuanbuffet.L6spw.createClass.curriculumPage.CurriculumPage;
import tuanbuffet.L6spw.createClass.generalpage.ClassName;
import tuanbuffet.L6spw.createClass.generalpage.GeneralData;
import tuanbuffet.L6spw.createClass.generalpage.GeneralPage;
import tuanbuffet.L6spw.createStudent.CreateStudentData;
import tuanbuffet.L6spw.createStudent.CreateStudentPage;
import tuanbuffet.L6spw.commonL6.Product;
import tuanbuffet.L6spw.createClass.schedulePage.Curriculum;
import tuanbuffet.L6spw.createClass.schedulePage.ScheduleData;
import tuanbuffet.L6spw.createClass.schedulePage.SchedulePage;
import tuanbuffet.L6spw.createClass.stuendtPage.StudentData;
import tuanbuffet.L6spw.createClass.stuendtPage.StudentPage;
import tuanbuffet.controlExcelFile.ExcelHelper;

public class Main {
    public static String[][] information = {
            {"IdST","TestDemo", "phamthithuthao19071981@gmail.com", "396670435", "SPU 1:2", "Thứ sáu : 19:10-19:40 Thứ bảy : 19:10-19:40", "Trishamae", "Kid's Box Movers 1", "ST111810"},
            {"IdST","Lê Bảo Nam 3","phamthithuao71981@gmail.com","3966435","SPU 1:1","Thứ sáu : 19:10-19:40 Thứ bảy : 19:10-19:40","Trishamae","Kid's Box Movers 1","ST111810"},
            {"IdST","Kangdokyun","dothihued@gmail.com","821073130995","SPU 1:1","Thứ hai: 14:00-14:30 Thứ ba: 14:00-14:30 Thứ tư: 14:00-14:30 Thứ sáu: 14:00-14:30","Yến Nhi 7","Kid's Box Movers","ST096531"},
            {"IdST","Kangdokyun2","dothihued@gmail.com","821073130995","SPU 1:1","Thứ hai: 14:00-14:30 Thứ ba: 14:00-14:30 Thứ tư: 14:00-14:30 Thứ sáu: 14:00-14:30","Yến Nhi 7","Kid's Box Movers","ST096531"},
    };

    public static void main(String[] args) throws Exception {
        CreateStudentData createStudentData;
        CreateStudentPage createStudentPage;
        GeneralPage generalPage = new GeneralPage();
        ClassName className;
        StudentData studentData;
        Curriculum curriculum;
        ScheduleData scheduleData;
        SchedulePage schedule;
        CurriculumData curriculumData;
        CurriculumPage curriculumPage;
        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("./L6SpeakWell.xlsx", "Sheet1");

        for (int i = 1; i < information.length; i++) {
            createStudentData = new CreateStudentData(excel.getCell("NAME",i),excel.getCell("MAIL",i),excel.getCell("PHONE",i));
            createStudentPage = new CreateStudentPage(createStudentData);
            createStudentPage.EnterInformation();
            Product product = new Product(excel.getCell("CLASS TYPE",i),excel.getCell("TEACHER",i));
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