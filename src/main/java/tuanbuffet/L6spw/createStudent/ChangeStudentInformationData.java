package tuanbuffet.L6spw.createStudent;

public class ChangeStudentInformationData {
    private String idbos;
    private String name;
    private String mail;
    private String phone;

    public ChangeStudentInformationData(String idbos, String name, String mail, String phone) {
        this.idbos = idbos;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
    }

    public String getIdbos() {
        return idbos;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }
}
