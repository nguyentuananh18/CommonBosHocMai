package tuanbuffet.studentsAskForLeave;
import static tuanbuffet.common.StringProcessing.*;

public class StudentLeaveData {

    private String studentID;
    private String studentName;
    private String reason;
    private String schedule;
    private String classType;
    private String teacher;

    public StudentLeaveData(String studentID, String studentName, String reason, String schedule, String classType, String teacher) {
        this.studentID = studentID;
        this.studentName = studentName;
        if (reason.contains("HV xin nghỉ đúng quy định")){
            this.reason = "Học Viên Xin Nghỉ Đúng Quy Định";
        }
        else {
            this.reason = "Học Viên Xin Nghỉ Không Đúng Quy Định";
        }
        this.schedule = removeAccent(schedule).toLowerCase().replaceAll("\\s+", "");

        this.classType = classType;
        this.teacher = teacher;
    }
    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getReason() {
        return reason;
    }

    public String getClassType() {
        return classType;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getTeacher() {
        return teacher;
    }
}