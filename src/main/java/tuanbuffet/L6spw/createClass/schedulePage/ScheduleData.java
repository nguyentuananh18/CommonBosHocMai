package tuanbuffet.L6spw.createClass.schedulePage;
import static tuanbuffet.common.StringProcessing.*;
public class ScheduleData {
    Curriculum curriculum;
    String ScheduleTotal;
    String dayOfWeek;

    public ScheduleData(Curriculum curriculum,String ScheduleTotal) {
        this.curriculum = curriculum;
        this.ScheduleTotal = ScheduleTotal;
    }

    public String getCurriculum() {
        return curriculum.getCurriculum();
    }

    public String getScheduleTotal() {
        return ScheduleTotal;
    }

    public void setScheduleTotal(String scheduleTotal) {
        ScheduleTotal = scheduleTotal;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String ScheduleTotal) {
        String days = "";
        if (removeAccentAndSpace(ScheduleTotal).contains("thuhai")){
            days += "thuhai";
        }
        if (removeAccentAndSpace(ScheduleTotal).contains("thuba")){
            days += "thuba";
        }
        if (removeAccentAndSpace(ScheduleTotal).contains("thutu")){
            days += "thutu";
        }
        if (removeAccentAndSpace(ScheduleTotal).contains("thunam")){
            days += "thunam";
        }
        if (removeAccentAndSpace(ScheduleTotal).contains("thusau")){
            days += "thusau";
        }
        if (removeAccentAndSpace(ScheduleTotal).contains("thubay")){
            days += "thubay";
        }
        if (removeAccentAndSpace(ScheduleTotal).contains("chunhat")){
            days += "chunhat";
        }
        this.dayOfWeek = days;
    }

    public static void main(String[] args) {
        Curriculum curriculum1 = new Curriculum("Starters");
        ScheduleData scheduleData = new ScheduleData(curriculum1,"abcd");
        System.out.println(scheduleData.getCurriculum());
    }

}
