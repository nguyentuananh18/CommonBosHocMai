package tuanbuffet.L6spw.commonL6;

import java.util.List;
import static tuanbuffet.common.StringProcessing.*;

public class Product {
    String classType;
    String teacherName;
    String curriculum;
    List<Teacher> listTeacher;
    boolean status = false;

    public Product(String classTypes, String teacherName,String curriculum, List<Teacher> listTeacher){
        this.classType = classTypes;
        this.teacherName = teacherName.toLowerCase();
        this.listTeacher = listTeacher;
        this.curriculum = removeAccentAndSpace(curriculum);
    }

    public String getCurriculum() {
        return curriculum;
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
        } else return "1:8";
    }
    public String checkTeacherType() {
        String GV = "";
        for (Teacher teacher : listTeacher) {
            if (teacher.getGVNamPhi() != null && teacher.getGVNamPhi().trim().toLowerCase().equals(getTeacherName())) {
                GV = "NAMPHI";
                break;
            } else if (teacher.getGVUSUK() != null && teacher.getGVUSUK().trim().toLowerCase().equals(getTeacherName())) {
                GV = "USUK";
                break;
            } else if (teacher.getGVVN() != null && teacher.getGVVN().trim().toLowerCase().equals(getTeacherName())) {
                GV = "VN";
                break;
            } else {
                GV = "PHIL";
            }
        }
        return GV;
    }

    public String getProductCourseName(){
        String classType = checkClassType();
        String teacherType = checkTeacherType();
        String country;
        String curriculum = getCurriculum();
        if(curriculum.contains("easy")){
            return "EasySpeak";
        }

        if (teacherType.equals("VN")) {
            country = "Việt Nam";
        } else if (teacherType.equals("USUK")) {
            country = "US/UK";
        } else if (teacherType.equals("NAMPHI")) {
            country = "Nam Phi";
        } else {
            country = "Philippines";
        }

        return String.format("SPEAKWELL - GV %s %s", country, classType);
    }
}


