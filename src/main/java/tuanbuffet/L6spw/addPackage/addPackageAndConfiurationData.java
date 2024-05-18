package tuanbuffet.L6spw.addPackage;


import tuanbuffet.L6spw.commonL6.ListTeacherName;

public class addPackageAndConfiurationData {
    private String idBos;
    private String classType;
    private String teacher;
    ListTeacherName listTeacherName = new ListTeacherName();

    public addPackageAndConfiurationData(String idBos, String classType, String teacher) {
        this.idBos = idBos;
        this.classType = classType;
        this.teacher = teacher;
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
}
