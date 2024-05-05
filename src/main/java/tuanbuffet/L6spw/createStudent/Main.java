package tuanbuffet.L6spw.createStudent;

import tuanbuffet.L6spw.addPackage.ConfigurationPage;
import tuanbuffet.L6spw.addPackage.addPackageAndConfiurationData;
import tuanbuffet.L6spw.addPackage.PackagePage;
import tuanbuffet.L6spw.createClass.curriculumPage.CurriculumData;
import tuanbuffet.L6spw.createClass.curriculumPage.CurriculumPage;
import tuanbuffet.L6spw.createClass.generalpage.ClassName;
import tuanbuffet.L6spw.createClass.generalpage.GeneralData;
import tuanbuffet.L6spw.createClass.generalpage.GeneralPage;
import tuanbuffet.L6spw.createClass.schedulePage.Curriculum;
import tuanbuffet.L6spw.createClass.schedulePage.ScheduleData;
import tuanbuffet.L6spw.createClass.schedulePage.SchedulePage;
import tuanbuffet.L6spw.createClass.stuendtPage.StudentData;
import tuanbuffet.L6spw.createClass.stuendtPage.StudentPage;
import tuanbuffet.L6spw.commonL6.Product;

import static tuanbuffet.common.Login.*;

public class Main {
    static String[][] information = {
            {"abc", "Nguyễn Đức Minh 20", "Tranthanhhiep2954@gmail.com", "984570017", "123", "SPU 1:2", "Thứbảy:18:35-19:05Chủnhật:18:35-19:06", "Kelly 3", "Kid's Box Beginners (48)", "ST096532"},
            {"abc", "Nguyễn Đức Minh 21", "Tranthanhhiep2954@gmail.com", "984570017", "123", "SPU 1:1", "Thứbảy:18:35-19:05Chủnhật:18:35-19:07", "Kelly 4", "Kid's Box Beginners (48)", "ST096533"},
            {"abc", "Nguyễn Đức Minh 22", "Tranthanhhiep2954@gmail.com", "984570017", "123", "SPU 1:4", "Thứbảy:18:35-19:05Chủnhật:18:35-19:08", "Kelly 5", "Kid's Box Beginners (48)", "ST096534"},
            {"abc", "Nguyễn Đức Minh 23", "Tranthanhhiep2954@gmail.com", "984570017", "123", "SPU 1:5", "Thứbảy:18:35-19:05Chủnhật:18:35-19:09", "Kelly 6", "Kid's Box Beginners (48)", "ST096535"},
            {"abc", "Nguyễn Đức Minh 24", "Tranthanhhiep2954@gmail.com", "984570017", "123", "SPU 1:6", "Thứbảy:18:35-19:05Chủnhật:18:35-19:10", "Kelly 7", "Kid's Box Beginners (48)", "ST096536"},
            {"abc", "Nguyễn Đức Minh 25", "Tranthanhhiep2954@gmail.com", "984570017", "123", "SPU 1:7", "Thứbảy:18:35-19:05Chủnhật:18:35-19:11", "Kelly 8", "Kid's Box Beginners (48)", "ST096537"},
            {"abc", "Nguyễn Đức Minh 26", "Tranthanhhiep2954@gmail.com", "984570017", "123", "SPU 1:8", "Thứbảy:18:35-19:05Chủnhật:18:35-19:12", "Kelly 9", "Kid's Box Beginners (48)", "ST096538"},
    };

    public static void main(String[] args) throws InterruptedException {

        RunCreateStudentPage entry = new RunCreateStudentPage();
        addPackageAndConfiurationData addPackageAndConfiurationData;
        PackagePage packagePage;
        ConfigurationPage configurationPage;
        /*openBrowser();*/
        login("ctvanhnt2", "anhnt216836");
        for (String[] information : information) {

            /*Tạo Account ClassIn*/
            String idbos = entry.RunCreateStudent(information[1], information[2], information[4]);

            /*Nếu như id bos bị trùng TK*/
            if (idbos.contains("Trùng TK") || idbos.isEmpty()) {
                /*sẽ điền chữ trùng TK vào ô classIn*/
                information[3] = idbos;
            }

            /*Ngược lại nếu như ra id bos, thì sẽ điền zô ô ID BOS*/
            else information[9] = idbos;

            /*Duyệt vòng lặp để in ra tất cả các thông tin từ idST đến ô id Bos*/
            for (int j = 0; j < 10; j++) {
                if (j < 9) {
                    System.out.print(information[j] + "|");
                } else System.out.println(information[j]);
            }

            /*Add Package and open schedule*/
            addPackageAndConfiurationData = new addPackageAndConfiurationData(information[9], information[5], information[7]);
            packagePage = new PackagePage(addPackageAndConfiurationData);
            packagePage.enterInformationPackage();

            configurationPage = new ConfigurationPage(addPackageAndConfiurationData);
            configurationPage.OpenTeachAll();


        }


        /*Tạo lớp học L6*/
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

        StudentPage studentPage;
        for (int i = 0; i < information.length; i++) {
            createStudentData = new CreateStudentData(information[i][1], information[i][2], information[i][4]);
            createStudentPage = new CreateStudentPage(createStudentData);
            createStudentPage.EnterInformation();
            Product product = new Product(information[i][5], information[i][7]);
            if (i < information.length - 1) {
                className = new ClassName(information[i][1], information[i][5], information[i][6], information[i][7], information[i][8], information[i + 1][1], information[i + 1][5], information[i + 1][6], information[i + 1][7], information[i + 1][8]);
            } else {
                className = new ClassName(information[i][1], information[i][5], information[i][6], information[i][7], information[i][8], "", "", "", "", "");
            }
            GeneralData generalData = new GeneralData(product, className);

            /*Nếu tên lớp được xác định là có tên tuổi*/
            if (!className.getClassName().isEmpty()) {
                generalPage.Enterinformation(generalData);
                curriculum = new Curriculum(information[i][8]);
                scheduleData = new ScheduleData(curriculum);
                schedule = new SchedulePage();
                schedule.Enterinformation(scheduleData);
                if (i < information.length - 1) {
                    studentData = new StudentData(information[i][9], information[i + 1][9]);
                } else {
                    studentData = new StudentData(information[i][9], "");
                }
                studentPage = new StudentPage();
                studentPage.Enterinformation(studentData);
                curriculumData = new CurriculumData(information[i][8]);
                curriculumPage = new CurriculumPage(curriculumData);
                curriculumPage.Enterinformation();
            }
        }


    }
}
