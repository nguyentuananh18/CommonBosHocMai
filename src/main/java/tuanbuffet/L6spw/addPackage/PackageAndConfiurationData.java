package tuanbuffet.L6spw.addPackage;


import tuanbuffet.L6spw.commonL6.TeacherData;

public class PackageAndConfiurationData {
    private String idBos;
    private String classType;
    private String teacher;

    public PackageAndConfiurationData(String idBos, String classType, String teacher) {
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
