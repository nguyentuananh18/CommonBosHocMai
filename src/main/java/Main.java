import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Locale;
import static tuanbuffet.common.StringProcessing.*;
public class Main {
    public static void main(String[] args) {
        // Chuỗi mẫu lịch
        String schedule = "Thứ tư:20:55-22:00Thứ nắm: 20:55-22:00 ";


        // Lấy ngày hiện tại và xác định thứ trong tuần của ngày đó
        DayOfWeek today = LocalDate.now().getDayOfWeek();

        // Chuyển đổi từ tiếng Anh sang tiếng Việt
        String vietnameseDay = removeAccent(today.getDisplayName(
                java.time.format.TextStyle.FULL_STANDALONE,
                new Locale("vi")
        ).toLowerCase().replaceAll("\\s+", ""));
        System.out.println(vietnameseDay);

        // Chuyển đổi chuỗi sang chữ thường để so sánh dễ dàng hơn
        String lowerCaseSchedule = removeAccent(schedule.toLowerCase());

        // Nếu chuỗi chứa ngày hiện tại
        if (lowerCaseSchedule.replaceAll("\\s+", "").contains(vietnameseDay)) {

            System.out.println(lowerCaseSchedule.replaceAll(" ","").substring(lowerCaseSchedule.indexOf("thutu")+ 7, lowerCaseSchedule.indexOf("thutu")+ 18));
        }
        else System.out.println("Không chứa");
    }
}