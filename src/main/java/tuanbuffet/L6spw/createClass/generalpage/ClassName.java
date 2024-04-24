package tuanbuffet.L6spw.createClass.generalpage;

public class ClassName {
    private String studentName1;
    private String classType1;
    private String schedule1;
    private String teacherName1;
    private String curriculum1;
    private String studentName2;
    private String classType2;
    private String schedule2;
    private String teacherName2;
    private String curriculum2;

    public ClassName(String studentName1, String classType1, String schedule1, String teacherName1, String curriculum1, String studentName2, String classType2, String schedule2, String teacherName2, String curriculum2) {
        this.studentName1 = studentName1;
        this.classType1 = classType1;
        this.schedule1 = schedule1;
        this.teacherName1 = teacherName1;
        this.curriculum1 = curriculum1;
        this.studentName2 = studentName2;
        this.classType2 = classType2;
        this.schedule2 = schedule2;
        this.teacherName2 = teacherName2;
        this.curriculum2 = curriculum2;
    }

    public String getClassName() {
        if (classType1.contains("1:1")) {
            return studentName1;
        } else {
            if (classType1.equals(classType2) && schedule1.equals(schedule2) && teacherName1.equals(teacherName2) && curriculum1.equals(curriculum2)) {
                return studentName1 + " + " + studentName2;
            } else return "";
        }
    }
}