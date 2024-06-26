package tuanbuffet.L6spw.createStudent;
import static  tuanbuffet.common.StringProcessing.*;

public class StudentData {
    private String name;
    private String phone;
    private String mail;

    public StudentData(String name, String phone, String mail) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }

    public String getName() {
        return name.trim();
    }

    public String getPhone() {
        return  DeleteSpecialCharacters(extractNumbers(phone.trim()));
    }

    public String getMail() {
        return mail.trim();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
