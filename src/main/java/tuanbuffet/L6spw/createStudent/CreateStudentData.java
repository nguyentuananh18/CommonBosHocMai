package tuanbuffet.L6spw.createStudent;

import static tuanbuffet.common.StringProcessing.*;

public class CreateStudentData {
    private String name;
    private String mail;
    private String phone;

    public CreateStudentData(String name, String mail, String phone) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }
    public String getPhoneAfterEditing() {
        String lastPhone = "";
        switch (getAreaCode()) {
            case "+81 Japan", "+82 Korea, Republic of South Korea", "+33 France","+49 Germany": {
                lastPhone = getPhone().substring(2);
            }
            break;
            case "+420 Czech Republic","+886 Taiwan": {
                lastPhone = getPhone().substring(3);
            }
            break;
            default: {
                lastPhone = getPhone();
            }
        }
        /*if (getAreaCode().equals("+81 Japan") || getAreaCode().equals("+82 Korea, Republic of South Korea")||getAreaCode().equals("+33 France")){
            lastPhone = studentData.getPhone().substring(2);
        }
        else  if (getAreaCode().equals("+420 Czech Republic")){
            lastPhone = studentData.getPhone().substring(3);
        }

        else lastPhone = studentData.getPhone();*/
        return lastPhone;
    }

    public String getAreaCode() {
        String areaCode = "";
        if (getPhone().length() > 10) {
            if (getPhone().startsWith("81")) {
                areaCode = "+81 Japan";
            } else if (getPhone().startsWith("82")) {
                areaCode = "+82 Korea, Republic of South Korea";
            } else if (getPhone().startsWith("420")) {
                areaCode = "+420 Czech Republic";
            } else if (getPhone().startsWith("886")){
                areaCode ="+886 Taiwan";
            }
            else if (getPhone().startsWith("33")) {
                areaCode = "+33 France";
            } else if (getPhone().startsWith("49")){
                areaCode = "+49 Germany";
            }
            else areaCode = "+84 Vietnam";
        } else {
            areaCode = "+84 Vietnam";
        }
        return areaCode;
    }

    public String getName() {
        return name.trim();
    }

    public String getPhone() {
        return DeleteSpecialCharacters(extractNumbers(phone.trim()));
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
