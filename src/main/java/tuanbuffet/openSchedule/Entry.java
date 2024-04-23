package tuanbuffet.openSchedule;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Entry {
    public static void main(String[] args) {
        // Định nghĩa hai ngày
        LocalDate date1 = LocalDate.of(2024, 4, 23);
        LocalDate date2 = LocalDate.of(2024, 5, 23);

        // Tính khoảng cách giữa hai ngày
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);

        System.out.println("Khoảng cách giữa hai ngày là: " + daysBetween + " ngày");

    }
}