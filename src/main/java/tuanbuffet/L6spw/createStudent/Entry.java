package tuanbuffet.L6spw.createStudent;

import static tuanbuffet.common.Login.*;

public class Entry {

    public static void main(String[] args) throws InterruptedException {
        StudentData studentData;
        CreateStudentPage createStudentPage;
        studentData = new StudentData("Nguyễn Tuấn Anh","9022781922","Tuanbuffet123@gmail.commmm       ");
        createStudentPage = new CreateStudentPage(studentData);
        Exception exception = new Exception();

        login("ctvanhnt2", "anhnt216836");
        createStudentPage.EnterInformation();
        System.out.println(exception.getNotifyMessage());

    }
}
