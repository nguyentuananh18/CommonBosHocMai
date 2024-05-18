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
import tuanbuffet.L6spw.createClass.stuendtPage.CheckAddStudentPage;
import tuanbuffet.L6spw.createClass.stuendtPage.StudentData;
import tuanbuffet.L6spw.createClass.stuendtPage.StudentPage;
import tuanbuffet.L6spw.commonL6.Product;
import tuanbuffet.L6spw.createStudent.ChangeStudentInformationData;
import tuanbuffet.L6spw.createStudent.ChangeStudentInformationPage;
import tuanbuffet.L6spw.createStudent.RunCreateStudentPage;
import tuanbuffet.controlExcelFile.ExcelHelper;
import static tuanbuffet.common.Login.*;

public class RunL6 {
    ExcelHelper excel = new ExcelHelper();
    RunCreateStudentPage runCreateStudentPage = new RunCreateStudentPage();
    addPackageAndConfiurationData addPackageAndConfiurationData;
    PackagePage packagePage;
    ConfigurationPage configurationPage;
    ChangeStudentInformationData changeStudentInformationData;
    ChangeStudentInformationPage changeStudentInformationPage;

    public static void main(String[] args) throws InterruptedException {
        openBrowser();
        login("ctvanhnt2", "anhnt216836");
        RunL6 runL6 = new RunL6();
        runL6.ChangeStudentName();
    }
    public void ChangeStudentName(){
        for (int i = 1; ; i++) {
            /*Add Package and open schedule*/
            excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
            if (excel.getCell("ID", i).isEmpty() || excel.getCell("NAME", i).isEmpty()) {
                break;
            }
            if (!excel.getCell("IDBOS", i).isEmpty()){
                changeStudentInformationData = new ChangeStudentInformationData(excel.getCell("IDBOS", i),excel.getCell("NAME", i),excel.getCell("MAIL", i),excel.getCell("PHONE", i));
                changeStudentInformationPage = new ChangeStudentInformationPage(changeStudentInformationData);
                System.out.println(changeStudentInformationPage.ChangeNameStudent());
            }
        }
    }

    public void CreateStudent() {
        excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
        for (int i = 1; ; i++) {
            if (excel.getCell("ID", i).isEmpty() || excel.getCell("NAME", i).isEmpty()) {
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
            excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
            if (excel.getCell("ID", i).isEmpty() || excel.getCell("NAME", i).isEmpty()) {
                break;
            }
            if (!excel.getCell("IDBOS", i).isEmpty()){
                changeStudentInformationData = new ChangeStudentInformationData(excel.getCell("IDBOS", i),excel.getCell("NAME", i),excel.getCell("MAIL", i),excel.getCell("PHONE", i));
                changeStudentInformationPage = new ChangeStudentInformationPage(changeStudentInformationData);
                System.out.println(changeStudentInformationPage.ChangeNameStudent());
            }
        }
    }

    public void AddPackageAndOpenSchedule() {
        for (int i = 1; ; i++) {
            /*Add Package and open schedule*/
            excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
            if (excel.getCell("ID", i).isEmpty() || excel.getCell("NAME", i).isEmpty()) {
                break;
            }
            if (!excel.getCell("IDBOS", i).isEmpty()) {
                addPackageAndConfiurationData = new addPackageAndConfiurationData(excel.getCell("IDBOS", i), excel.getCell("CLASS TYPE", i), excel.getCell("TEACHER", i));
                packagePage = new PackagePage(addPackageAndConfiurationData);
                excel.setCell(String.valueOf(packagePage.enterInformationPackage()), "NOTE CHECK PACKAGE", i);
                configurationPage = new ConfigurationPage(addPackageAndConfiurationData);
                excel.setCell(String.valueOf(configurationPage.OpenTeachAll()), "NOTE CHECK OPEN SCHEDULE", i);
            }
        }
    }


    public void Setup() throws InterruptedException {
        openBrowser();
        login("ctvanhnt2", "anhnt216836");
    }

    public void QuitProgram() {
        closeBrowser();
    }

    public void CreateClass() throws InterruptedException {
        excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
        GeneralPage generalPage;
        ClassName className;
        StudentData studentData;
        StudentPage studentPage;
        CheckAddStudentPage checkAddStudentPage;
        Curriculum curriculum;
        ScheduleData scheduleData;
        SchedulePage schedule;
        CurriculumData curriculumData;
        CurriculumPage curriculumPage;
        for (int i = 1; ; i++) {

            if (excel.getCell("NAME", i).isEmpty()) {
                break;
            }
            Product product = new Product(excel.getCell("CLASS TYPE", i), excel.getCell("TEACHER", i));
            if (!excel.getCell("NAME", i).isEmpty()) {
                className = new ClassName(excel.getCell("NAME", i), excel.getCell("CLASS TYPE", i), excel.getCell("SCHEDULE", i), excel.getCell("TEACHER", i), excel.getCell("CURRICULUM", i), excel.getCell("NAME", i + 1), excel.getCell("CLASS TYPE", i + 1), excel.getCell("SCHEDULE", i + 1), excel.getCell("TEACHER", i + 1), excel.getCell("CURRICULUM", i + 1));
                GeneralData generalData = new GeneralData(product, className);
                generalPage = new GeneralPage(generalData);
                if (!className.getClassName().isEmpty()) {
                    generalPage.Enterinformation();

                    curriculum = new Curriculum(excel.getCell("CURRICULUM", i));
                    scheduleData = new ScheduleData(curriculum);
                    schedule = new SchedulePage();
                    schedule.Enterinformation(scheduleData);
                    if (!excel.getCell("ID", i + 1).isEmpty()) {
                        studentData = new StudentData(excel.getCell("IDBOS", i), excel.getCell("IDBOS", i + 1));
                    } else {
                        studentData = new StudentData(excel.getCell("IDBOS", i));
                    }
                    studentPage = new StudentPage(studentData);
                    studentPage.Enterinformation();

                    checkAddStudentPage = new CheckAddStudentPage(studentData);
                    String errorAddST = checkAddStudentPage.AcceptanceAddStudent();
                    if (errorAddST.contains(excel.getCell("IDBOS", i))) {
                        excel.setCell("Cancel", "NOTE ADD ID TO CLASS", i);
                    } else {
                        excel.setCell("Done", "NOTE ADD ID TO CLASS", i);
                    }
                    if (errorAddST.contains(excel.getCell("IDBOS", i + 1))) {
                        excel.setCell("Cancel", "NOTE ADD ID TO CLASS", i + 1);
                    } else {
                        excel.setCell("Done", "NOTE ADD ID TO CLASS", i + 1);
                    }

                    curriculumData = new CurriculumData(excel.getCell("CURRICULUM", i));
                    curriculumPage = new CurriculumPage(curriculumData);
                    curriculumPage.Enterinformation();
                }
            }
        }
    }
}
