package tuanbuffet.L6spw.commonL6;

import tuanbuffet.controlExcelFile.ExcelHelper;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    List<Teacher> ListTeacherData = new ArrayList<>();
    ExcelHelper excel = new ExcelHelper();
    String GVphil;
    String GVVN;
    String GVUSUK;
    String GVNamPhi;
    public Teacher(){}

    public Teacher(String GVphil, String GVVN, String GVUSUK, String GVNamPhi) {
        this.GVphil = GVphil;
        this.GVVN = GVVN;
        this.GVUSUK = GVUSUK;
        this.GVNamPhi = GVNamPhi;
    }


    public void setGVphil(String GVphil) {
        this.GVphil = GVphil;
    }

    public void setGVVN(String GVVN) {
        this.GVVN = GVVN;
    }

    public void setGVUSUK(String GVUSUK) {
        this.GVUSUK = GVUSUK;
    }

    public void setGVNamPhi(String GVNamPhi) {
        this.GVNamPhi = GVNamPhi;
    }

    public String getGVNamPhi() {
        return GVNamPhi;
    }

    public String getGVUSUK() {
        return GVUSUK;
    }

    public String getGVVN() {
        return GVVN;
    }

    public String getGVphil() {
        return GVphil;
    }

    public List<Teacher> getListTeacher() {
        System.out.println("Đang lấy dữ liệu giáo viên");
        for (int j = 1;; j++) {
            Teacher data = new Teacher();
            excel.setExcelFile("C:\\dataAutoBos\\ListTeacher.xlsx", "Sheet1");
            data.setGVVN(excel.getCell("GVVN", j));
            data.setGVUSUK(excel.getCell("GVUSUK",j));
            data.setGVphil(excel.getCell("GVPHIL",j));
            data.setGVNamPhi(excel.getCell("GVNP",j));
            ListTeacherData.add(data);
            if (excel.getCell("GVVN", j).isEmpty()&&excel.getCell("GVUSUK", j).isEmpty()&&excel.getCell("GVPHIL", j).isEmpty()&&excel.getCell("GVNP", j).isEmpty()){
                break;
            }
        }
        System.out.println("Dữ liệu giáo viên đã được lấy xong");
        return ListTeacherData;
    }
}
