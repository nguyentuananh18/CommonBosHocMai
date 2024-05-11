package tuanbuffet.L6spw;

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
import tuanbuffet.L6spw.createStudent.RunCreateStudentPage;
import tuanbuffet.controlExcelFile.ExcelHelper;

import static tuanbuffet.common.Login.*;

public class RunL6 {
    ExcelHelper excel = new ExcelHelper();
    RunCreateStudentPage runCreateStudentPage = new RunCreateStudentPage();
    addPackageAndConfiurationData addPackageAndConfiurationData;
    PackagePage packagePage;
    ConfigurationPage configurationPage;

    public void CreateStudent() {
        excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
        for (int i = 1; ; i++) {
            if (excel.getCell("ID", i).isEmpty() && excel.getCell("NAME", i).isEmpty()) {
                break;
            }
            String idbos = runCreateStudentPage.RunCreateStudent(excel.getCell("NAME", i), excel.getCell("MAIL", i), excel.getCell("PHONE", i));
            /*Nếu như id bos bị trùng TK*/
            if (idbos.contains("Trùng TK") || idbos.isEmpty()) {
                /*sẽ điền chữ trùng TK vào ô classIn*/
                excel.setCell(idbos, "CLASSIN", i);
            } else {
                /*Ngược lại nếu như ra id bos, thì sẽ điền zô ô ID BOS*/
                excel.setCell(idbos, "IDBOS", i);
            }
        }
    }
    public void AddPackageAndOpenSchedule() {
        for (int i = 1; ; i++) {
            /*Add Package and open schedule*/
            excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
            if (!excel.getCell("IDBOS", i).isEmpty()) {
                addPackageAndConfiurationData = new addPackageAndConfiurationData(excel.getCell("IDBOS", i), excel.getCell("CLASS TYPE", i), excel.getCell("TEACHER", i));
                packagePage = new PackagePage(addPackageAndConfiurationData);
                excel.setCell(String.valueOf(packagePage.enterInformationPackage()),"NOTE CHECK PACKAGE",i);
                configurationPage = new ConfigurationPage(addPackageAndConfiurationData);
                excel.setCell(String.valueOf(configurationPage.OpenTeachAll()),"NOTE CHECK OPEN SCHEDULE",i);
            }
        }
    }
    public void RUN() throws InterruptedException {
        excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
        openBrowser();
        login("ctvanhnt2", "anhnt216836");
        for (int i = 1; ; i++) {
            if (excel.getCell("ID", i).isEmpty() && excel.getCell("NAME", i).isEmpty()) {
                break;
            }
            String idbos = runCreateStudentPage.RunCreateStudent(excel.getCell("NAME", i), excel.getCell("MAIL", i), excel.getCell("PHONE", i));
            /*Nếu như id bos bị trùng TK*/
            if (idbos.contains("Trùng TK") || idbos.isEmpty()) {
                /*sẽ điền chữ trùng TK vào ô classIn*/
                excel.setCell(idbos, "CLASSIN", i);
            } else {
                /*Ngược lại nếu như ra id bos, thì sẽ điền zô ô ID BOS*/
                excel.setCell(idbos, "IDBOS", i);
            }
            /*Add Package and open schedule*/
            if (!excel.getCell("IDBOS", i).isEmpty()) {
                addPackageAndConfiurationData = new addPackageAndConfiurationData(excel.getCell("IDBOS", i), excel.getCell("CLASS TYPE", i), excel.getCell("TEACHER", i));
                packagePage = new PackagePage(addPackageAndConfiurationData);
                packagePage.enterInformationPackage();

                configurationPage = new ConfigurationPage(addPackageAndConfiurationData);
                configurationPage.OpenTeachAll();
            }
        }
        for (int i = 1; ; i++) {
            GeneralPage generalPage = new GeneralPage();
            ClassName className;
            StudentData studentData;
            StudentPage studentPage;
            Curriculum curriculum;
            ScheduleData scheduleData;
            SchedulePage schedule;
            CurriculumData curriculumData;
            CurriculumPage curriculumPage;
            if (excel.getCell("NAME", i).isEmpty()) {
                break;
            }
            Product product = new Product(excel.getCell("CLASS TYPE", i), excel.getCell("TEACHER", i));
            if (!excel.getCell("NAME", i).isEmpty()) {
                className = new ClassName(excel.getCell("NAME", i), excel.getCell("CLASS TYPE", i), excel.getCell("SCHEDULE", i), excel.getCell("TEACHER", i), excel.getCell("CURRICULUM", i), excel.getCell("NAME", i + 1), excel.getCell("CLASS TYPE", i + 1), excel.getCell("SCHEDULE", i + 1), excel.getCell("TEACHER", i + 1), excel.getCell("CURRICULUM", i + 1));
                GeneralData generalData = new GeneralData(product, className);
                if (!className.getClassName().isEmpty()) {
                    generalPage.Enterinformation(generalData);
                    curriculum = new Curriculum(excel.getCell("CURRICULUM", i));
                    scheduleData = new ScheduleData(curriculum);
                    schedule = new SchedulePage();
                    schedule.Enterinformation(scheduleData);

                    if (!excel.getCell("ID", i + 1).isEmpty()) {
                        studentData = new StudentData(excel.getCell("IDBOS", i), excel.getCell("IDBOS", i + 1));
                    } else {
                        studentData = new StudentData(excel.getCell("IDBOS", i), "");
                    }
                    studentPage = new StudentPage();
                    studentPage.Enterinformation(studentData);
                    curriculumData = new CurriculumData(excel.getCell("CURRICULUM", i));
                    curriculumPage = new CurriculumPage(curriculumData);
                    curriculumPage.Enterinformation();
                }
            }
        }

//        for (String[] information : information) {
//
//            /*Tạo Account ClassIn*/
//            String idbos = entry.RunCreateStudent(information[1], information[2], information[4]);
//
//            /*Nếu như id bos bị trùng TK*/
//            if (idbos.contains("Trùng TK") || idbos.isEmpty()) {
//                /*sẽ điền chữ trùng TK vào ô classIn*/
//                information[3] = idbos;
//            }
//
//            /*Ngược lại nếu như ra id bos, thì sẽ điền zô ô ID BOS*/
//            else information[9] = idbos;
//
//            /*Duyệt vòng lặp để in ra tất cả các thông tin từ idST đến ô id Bos*/
//            for (int j = 0; j < 10; j++) {
//                if (j < 9) {
//                    System.out.print(information[j] + "|");
//                } else System.out.println(information[j]);
//            }
//
//            /*Add Package and open schedule*/
//            addPackageAndConfiurationData = new addPackageAndConfiurationData(information[9], information[5], information[7]);
//            packagePage = new PackagePage(addPackageAndConfiurationData);
//            packagePage.enterInformationPackage();
//
//            configurationPage = new ConfigurationPage(addPackageAndConfiurationData);
//            configurationPage.OpenTeachAll();
//
//
//        }
    }

    public void Setup() throws InterruptedException {
        openBrowser();
        login("ctvanhnt2", "anhnt216836");
    }
    public void QuitProgram(){
        closeBrowser();
    }
    public void CreateClass() throws InterruptedException {
        excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
        for (int i = 1; ; i++) {
            GeneralPage generalPage = new GeneralPage();
            ClassName className;
            StudentData studentData;
            StudentPage studentPage;
            Curriculum curriculum;
            ScheduleData scheduleData;
            SchedulePage schedule;
            CurriculumData curriculumData;
            CurriculumPage curriculumPage;
            if (excel.getCell("NAME", i).isEmpty()) {
                break;
            }
            Product product = new Product(excel.getCell("CLASS TYPE", i), excel.getCell("TEACHER", i));
            if (!excel.getCell("NAME", i).isEmpty()) {
                className = new ClassName(excel.getCell("NAME", i), excel.getCell("CLASS TYPE", i), excel.getCell("SCHEDULE", i), excel.getCell("TEACHER", i), excel.getCell("CURRICULUM", i), excel.getCell("NAME", i + 1), excel.getCell("CLASS TYPE", i + 1), excel.getCell("SCHEDULE", i + 1), excel.getCell("TEACHER", i + 1), excel.getCell("CURRICULUM", i + 1));
                GeneralData generalData = new GeneralData(product, className);
                if (!className.getClassName().isEmpty()) {
                    generalPage.Enterinformation(generalData);
                    curriculum = new Curriculum(excel.getCell("CURRICULUM", i));
                    scheduleData = new ScheduleData(curriculum);
                    schedule = new SchedulePage();
                    schedule.Enterinformation(scheduleData);
                    if (!excel.getCell("ID", i + 1).isEmpty()) {
                        studentData = new StudentData(excel.getCell("IDBOS", i), excel.getCell("IDBOS", i + 1));
                    } else {
                        studentData = new StudentData(excel.getCell("IDBOS", i), "");
                    }
                    studentPage = new StudentPage();
                    studentPage.Enterinformation(studentData);
                    curriculumData = new CurriculumData(excel.getCell("CURRICULUM", i));
                    curriculumPage = new CurriculumPage(curriculumData);
                    curriculumPage.Enterinformation();
                }
            }
        }
    }
}
