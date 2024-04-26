package tuanbuffet.L6spw.createStudent;

import java.text.Normalizer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    static String[][] information = {
            /*{"ST35344","Nguyễn Ngọc Bảo Hân9","tuyetlehthl@gmail.3com","946656779","","Kelly 2","Kid's Box Beginners (48)",""},
            {"ST35345","Đinh Thuỳ Minh","nguyenbichyb@2gmail.com","912915815","","Hồng Thủy","Kid's Box Movers",""},*/
            {"ST35346","Đinh Thu","nguyenbichyb@gmail.com","978244777","","Kim Phương","Kid's Box Movers",""},
    };

    public static void main(String[] args) throws InterruptedException {
        Entry entry = new Entry();
        for (int i = 0 ; i< information.length; i++ ){
            System.out.println(entry.RunCreateStudent(information[i][1],information[i][2],information[i][3]));
        }

    }
}
