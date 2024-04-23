package tuanbuffet.controlExcelFile;

public class ClassInformation {
    private String idST;
    private String name;
    private String email;
    private String phone;
    private String classType;
    private String teacher;
    private String schedule;
    private String curriculum;
    private String idBOS;
    public ClassInformation(){
    }

    public ClassInformation(String idST, String name, String email, String phone, String classType, String teacher, String schedule, String curriculum, String idBOS) {
        this.idST = idST;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.classType = classType;
        this.teacher = teacher;
        this.schedule = schedule;
        this.curriculum = curriculum;
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

    public String getPhone() {
        return phone;
    }

    public String getClassType() {
        return classType;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public String getIdBOS() {
        return idBOS;
    }

    public void setIdST(String idST) {
        this.idST = idST;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public void setIdBOS(String idBOS) {
        this.idBOS = idBOS;
    }
    // setter - getter
}
