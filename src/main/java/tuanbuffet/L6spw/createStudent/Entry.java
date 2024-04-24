package tuanbuffet.L6spw.createStudent;

import static tuanbuffet.common.Login.*;

public class Entry {

    public static void main(String[] args) throws InterruptedException {
        StudentData studentData;
        StudentPage studentPage;
        studentData = new StudentData("Nguyễn Tuấn Anh","81902278192","Tuanbuffet123@gmail.com");
        studentPage = new StudentPage(studentData);

        login("ctvanhnt2", "anhnt216836");
        studentPage.EnterInformation();

    }
}
