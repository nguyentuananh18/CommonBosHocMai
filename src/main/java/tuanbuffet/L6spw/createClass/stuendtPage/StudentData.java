package tuanbuffet.L6spw.createClass.stuendtPage;

public class StudentData {
    String idBos1;
    String idBos2;
    String note1;
    String note2;

    public StudentData(String idBos1, String idBos2,String note1,String note2) {
        this.idBos1 = idBos1;
        this.idBos2 = idBos2;
        this.note1 = note1;
        this.note2 = note2;
    }

    public String getIdBos1() {
        return idBos1;
    }

    public String getIdBos2() {
        return idBos2;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

    public void setNote2(String note2) {
        this.note2 = note2;
    }
    public String getNote1(){
        return note1;
    }
    public String getNote2(){
        return note2;
    }
}
