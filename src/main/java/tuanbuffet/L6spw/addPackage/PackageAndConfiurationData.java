package tuanbuffet.L6spw.addPackage;


import tuanbuffet.L6spw.commonL6.TeacherData;
import static tuanbuffet.common.StringProcessing.*;

public class PackageAndConfiurationData {
    private String idBos;
    private String classType;
    private String teacher;
    private String curriculum;

    public PackageAndConfiurationData(String idBos, String classType, String teacher,String curriculum) {
        this.idBos = idBos;
        this.classType = classType;
        this.teacher = teacher.toLowerCase();
        this.curriculum = removeAccentAndSpace(curriculum);
    }

    public String getIdBos() {
        return idBos;
    }

    public String getClassType() {
        return classType;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setIdBos(String idBos) {
        this.idBos = idBos;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }
}
