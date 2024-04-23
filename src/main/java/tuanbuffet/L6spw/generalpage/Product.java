package tuanbuffet.L6spw.generalpage;
import tuanbuffet.common.ListTeacherName;

public class Product {
    ListTeacherName listTeacherName = new ListTeacherName();
    /*public ClassType classType;
    public TeacherType teacherType;
    public  Product(ClassType classType, TeacherType teacherType){
        this.classType = classType;
        this.teacherType = teacherType;
    }


    public String getClassType() {
        return classType.getValue();
    }

    public String getTeacherType() {
        return teacherType.getValue();
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public void setTeacherType(TeacherType teacherType) {
        this.teacherType = teacherType;
    }
    public String getProduct(){
        return getTeacherType() + " " + getClassType();
    }*/
    String classType;
    String teacherName;
    boolean status = false;

    public Product(String classTypes, String teacherName) {
        this.classType = classTypes;
        this.teacherName = teacherName;
    }

    public ListTeacherName getListTeacherName() {
        return listTeacherName;
    }

    public String getClassType() {
        return classType;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String checkClassType() {
        if (getClassType().contains("1:1")) {
            return "1:1";
        } else if (getClassType().contains("1:2")) {
            return "1:2";
        } else return "1:3";
    }
    public boolean checkTeacherType(String[] teacherType) {
        for (String s : teacherType) {
            if (s.contains(getTeacherName()) || getTeacherName().contains(s)) {
                status = true;
                break;
            }
        }
        return status;
    }

    public String getProductCourseName() {
        if (checkClassType().equals("1:1")) {
            if (checkTeacherType(listTeacherName.teacherVietNam)) {
                return "SPEAKWELL - GV Việt Nam 1:1";
            } else if (checkTeacherType(listTeacherName.teacherPhilippines)) {
                return "SPEAKWELL - GV Philippines 1:1";
            } else if (checkTeacherType(listTeacherName.teacherNamPhi)) {
                return "SPEAKWELL - GV Nam Phi 1:1";
            } else return "SPEAKWELL - GV US/UK 1:1";
        } else if (checkClassType().equals("1:2")) {
            if (checkTeacherType(listTeacherName.teacherVietNam)) {
                return "SPEAKWELL - GV Việt Nam 1:2";
            } else if (checkTeacherType(listTeacherName.teacherPhilippines)) {
                return "SPEAKWELL - GV Philippines 1:2";
            } else if (checkTeacherType(listTeacherName.teacherNamPhi)) {
                return "SPEAKWELL - GV Nam Phi 1:2";
            } else return "SPEAKWELL - GV US/UK 1:2";
        } else {
            if (checkTeacherType(listTeacherName.teacherVietNam)) {
                return "SPEAKWELL - GV Việt Nam 1:3";
            } else if (checkTeacherType(listTeacherName.teacherPhilippines)) {
                return "SPEAKWELL - GV Philippines 1:3";
            } else if (checkTeacherType(listTeacherName.teacherNamPhi)) {
                return "SPEAKWELL - GV Nam Phi 1:3";
            } else return "SPEAKWELL - GV US/UK 1:3";
        }
    }
}


