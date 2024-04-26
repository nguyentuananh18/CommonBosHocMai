package tuanbuffet.common;

public class StudentDataTotal {
    private String idST;
    private String name;
    private String email;
    private String classIn;
    private String phone;
    private String classType;
    private String schedule;
    private String teacher;
    private String curriculum;
    private String idBOS;
    public StudentDataTotal(){

    }

    public StudentDataTotal(String idST, String name, String email, String classIn, String phone, String classType, String schedule, String teacher, String curriculum, String idBOS) {
        this.idST = idST;
        this.name = name;
        this.email = email;
        this.classIn = classIn;
        this.phone = phone;
        this.classType = classType;
        this.schedule = schedule;
        this.teacher = teacher;
        this.curriculum = curriculum;
        this.idBOS = idBOS;
    }

    public void setIdST(String idST) {
        this.idST = idST;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClassIn(String classIn) {
        this.classIn = classIn;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public void setIdBOS(String idBOS) {
        this.idBOS = idBOS;
    }

    public String getIdST() {
        return idST;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getClassIn() {
        return classIn;
    }

    public String getPhone() {
        return phone;
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

    public String getCurriculum() {
        return curriculum;
    }

    public String getIdBOS() {
        return idBOS;
    }
}
