package tuanbuffet.L6spw;

import tuanbuffet.L6spw.addPackage.ConfigurationPage;
import tuanbuffet.L6spw.addPackage.PackageAndConfiurationData;
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
import tuanbuffet.L6spw.createStudent.DataAcceptance;
import tuanbuffet.L6spw.createStudent.RunCreateStudentPage;
import tuanbuffet.controlExcelFile.ExcelHelper;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.locks.Lock; // Import lớp Lock từ thư viện java.util.concurrent
import java.util.concurrent.locks.ReentrantLock; // Import lớp ReentrantLock từ thư viện java.util.concurrent


import static tuanbuffet.common.Login.*;

public class RunL6 implements Runnable{
    private static final Lock lock = new ReentrantLock();
    ExcelHelper excel = new ExcelHelper();
    RunCreateStudentPage runCreateStudentPage = new RunCreateStudentPage();
    PackageAndConfiurationData packageAndConfiurationData;
    PackagePage packagePage;
    ConfigurationPage configurationPage;
    ChangeStudentInformationData changeStudentInformationData;
    ChangeStudentInformationPage changeStudentInformationPage;

    private int step;
    private int locator;
    private String productNeedRun;
    public RunL6(){

    }
    public RunL6(int locator,int step, String productNeedRun){
        this.locator = locator;
        this.step = step;
        this.productNeedRun = productNeedRun;
    }

    public int getStep() {
        return step;
    }

    public int getLocator() {
        return locator;
    }
    public String getProductNeedRun(){
        return productNeedRun;
    }
    List<DataAcceptance> dataAcceptanceList = new ArrayList<DataAcceptance>();


    public void CreateStudent() throws InterruptedException {

        for (int i = getLocator(); ; i+= getStep()) {
            excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
            if (excel.getCell("ID", i).isEmpty() || excel.getCell("NAME", i).isEmpty()) {
                break;
            }
            String idbos = runCreateStudentPage.RunCreateStudent(excel.getCell("NAME", i), excel.getCell("MAIL", i), excel.getCell("PHONE", i));
            String classin="";
            lock.lock();
            excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
            /*Nếu như id bos bị trùng TK*/
            if (idbos.contains("Trùng TK") || idbos.isEmpty() ) {
                /*sẽ điền chữ trùng TK vào ô classIn*/
                excel.setCell(idbos, "CLASSIN", i);
            } else {
                /*Ngược lại nếu như ra id bos, thì sẽ điền zô ô ID BOS*/
                excel.setCell(idbos, "IDBOS", i);
                excel.setCell(excel.getCell("PHONE",i),"CLASSIN",i);
                classin = excel.getCell("PHONE",i);
            }
            /*excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");*/
            if (excel.getCell("ID", i).isEmpty() || excel.getCell("NAME", i).isEmpty()) {
                break;
            }
            DataAcceptance dataAcceptance = new DataAcceptance();
            dataAcceptance.setId(excel.getCell("ID", i));
            dataAcceptance.setName(excel.getCell("NAME", i));
            dataAcceptance.setClassIn(classin);
            dataAcceptance.setIdBos(idbos);
            dataAcceptanceList.add(dataAcceptance);
            if (!excel.getCell("IDBOS", i).isEmpty()){
                changeStudentInformationData = new ChangeStudentInformationData(excel.getCell("IDBOS", i),excel.getCell("NAME", i),excel.getCell("MAIL", i),excel.getCell("PHONE", i));
                changeStudentInformationPage = new ChangeStudentInformationPage(changeStudentInformationData);
                changeStudentInformationPage.ChangeNameStudent();
            }
            lock.unlock();
        }
    }

    public void AddPackageAndOpenSchedule() {
        for (int i = getLocator(); ; i+= getStep()) {
            /*Add Package and open schedule*/
            excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
            if (excel.getCell("ID", i).isEmpty() || excel.getCell("NAME", i).isEmpty()) {
                break;
            }
            if (!excel.getCell("IDBOS", i).isEmpty()) {
                excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
                packageAndConfiurationData = new PackageAndConfiurationData(excel.getCell("IDBOS", i), excel.getCell("CLASS TYPE", i), excel.getCell("TEACHER", i));
                packagePage = new PackagePage(packageAndConfiurationData);
                boolean acceptanceAddPackage = packagePage.enterInformationPackage();
                lock.lock();
                excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
                excel.setCell(String.valueOf(acceptanceAddPackage), "NOTE CHECK PACKAGE", i);
                lock.unlock();
                configurationPage = new ConfigurationPage(packageAndConfiurationData);
                boolean acceptanceOpenSchedule = configurationPage.OpenTeachAll();
                lock.lock();
                excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
                excel.setCell(String.valueOf(acceptanceOpenSchedule), "NOTE CHECK OPEN SCHEDULE", i);
                lock.unlock();
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

    public void CreateClass(){
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
        for (int i = getLocator(); ; i+= getStep()) {
            if (excel.getCell("NAME", i).isEmpty()) {
                break;
            }
            Product product = new Product(excel.getCell("CLASS TYPE", i), excel.getCell("TEACHER", i));
            if (!excel.getCell("NAME", i).isEmpty()) {
                className = new ClassName(excel.getCell("NAME", i), excel.getCell("CLASS TYPE", i), excel.getCell("SCHEDULE", i), excel.getCell("TEACHER", i), excel.getCell("CURRICULUM", i), excel.getCell("NAME", i + 1), excel.getCell("CLASS TYPE", i + 1), excel.getCell("SCHEDULE", i + 1), excel.getCell("TEACHER", i + 1), excel.getCell("CURRICULUM", i + 1));
                lock.lock();
                excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
                excel.setCell(className.getClassName(), "NOTE CHECK CLASS L6",i);
                lock.unlock();
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
                    packageAndConfiurationData = new PackageAndConfiurationData(excel.getCell("IDBOS", i), excel.getCell("CLASS TYPE", i), excel.getCell("TEACHER", i));
                    studentPage = new StudentPage(studentData,packageAndConfiurationData);
                    String acceptanceStudent = studentPage.Enterinformation();
                    lock.lock();

                    excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
                    if (acceptanceStudent.contains(excel.getCell("IDBOS", i))){
                        excel.setCell("Cancel", "NOTE ADD ID TO CLASS", i);
                    }
                    if (acceptanceStudent.contains(excel.getCell("IDBOS", i + 1))){
                        excel.setCell("Cancel", "NOTE ADD ID TO CLASS", i + 1);
                    }
                    lock.unlock();
                    checkAddStudentPage = new CheckAddStudentPage(studentData);
                    String errorAddST = checkAddStudentPage.AcceptanceAddStudent();
                    lock.lock();
                    excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
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
                    lock.unlock();
                    curriculumData = new CurriculumData(excel.getCell("CURRICULUM", i));
                    curriculumPage = new CurriculumPage(curriculumData);
                    curriculumPage.Enterinformation();
                }
            }
        }
    }
    public void InsertData(){
        excel.setExcelFile("C:\\dataAutoBos\\L6SpeakWell.xlsx", "Sheet1");
        for (int i = 0 ;i<dataAcceptanceList.size() ;i++){
            if (dataAcceptanceList.get(i).getId().equals(excel.getCell("ID",i+1))){
                excel.setCell(dataAcceptanceList.get(i).getIdBos(),"IDBOS",i+1);
                excel.setCell(dataAcceptanceList.get(i).getClassIn(),"CLASSIN",i+1);
            }
        }
    }

    @Override
    public void run() {
        if (getProductNeedRun().contains("createStudent")){
            try {
                Setup();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                CreateStudent();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            closeBrowser();
        }
        if (getProductNeedRun().contains("addPackageAndOpenSchedule")){
            try {
                Setup();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            AddPackageAndOpenSchedule();
            closeBrowser();
        }
        if (getProductNeedRun().contains("createClass")){
            try {
                Setup();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            CreateClass();
            closeBrowser();
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 1: " + i);
                synchronized (lock) {
                    lock.notify(); // Thông báo cho luồng 2
                    try {
                        lock.wait(); // Chờ cho đến khi luồng 2 thông báo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    System.out.println("Thread 2: " + i);
                    try {
                        lock.wait(); // Chờ cho đến khi luồng 1 thông báo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify(); // Thông báo cho luồng 1
                }
            }
        });
    }
}
