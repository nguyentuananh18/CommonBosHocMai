package tuanbuffet.L6spw.createStudent;

import static tuanbuffet.common.Login.login;

public class RunCreateStudentPage {
    public String RunCreateStudent(String name, String mail, String phone) {
        String messageMailExist = "Email đã tồn tại";
        String messageClassIn = "ClassIn Phone đã tồn tại";
        String phoneAndName = "Họ tên và số điện thoại liên lạc đã tồn tại";
        String success = "Tạo học viên thành công";
        String idBos = "";
        CreateStudentData data = new CreateStudentData(name, mail, phone);
        CreateStudentPage createStudentPage = new CreateStudentPage(data);
        SearchStudentPage searchStudentPage = new SearchStudentPage(data);
        ExceptionOfCreateStudent exception = new ExceptionOfCreateStudent(data, createStudentPage, searchStudentPage);
        createStudentPage.EnterInformation();
        //Trường hợp web có bắn ra message Notification:
        if (exception.CheckNotifyMessage()) {
            if (exception.getTextNotify().contains(success)) {
                //Giải quyết xong phần id bos
                idBos = searchStudentPage.getInformationIdBos();
            }
            else if (exception.getTextNotify().contains(messageClassIn) || exception.getTextNotify().contains(phoneAndName)) {
                idBos = searchStudentPage.getInformationIdBosExist();

                //Thông báo mail đã tồn tại
            }
            else if (exception.getTextNotify().contains(messageMailExist)) {
                    /*for (int j = 1 ; j<10; j++){
                        data.setMail(data.getPhone() + "@SpeakWell.com" + i);

                        createStudentPage.EnterInformation();
                        if (exception.CheckNotifyMessage()){
                            if (exception.getTextNotify().contains(messageMailExist)){
                                j++;
                            }
                        }
                        else{
                            //Giải quyết xong phần id bos
                            searchStudentPage.getInformationIdBos();
                            break;
                        };
                    }*/
                for (int j = 1; j < 10; j++) {
                    data.setMail(data.getPhone() + "@" + j + "SpeakWell.com");
                    createStudentPage.EnterInformation();

                    //Thông báo đăng kí tài khoản thành công
                    if (exception.getTextNotify().contains(success)) {
                        idBos = searchStudentPage.getInformationIdBos();
                        break;


                        //Thông báo phone classin đã dược đăng kí trước đó
                    } else if (exception.getTextNotify().contains(messageClassIn) || exception.getTextNotify().contains(phoneAndName)) {

                        idBos = searchStudentPage.getInformationIdBosExist();
                        break;
                    }
                }
            }
        }

        //Trường hợp không thấy web bắn ra message Notification:
        else {
            //Mặc định nó là đang lỗi mail:)))
            for (int j = 1; j < 100; j++) {
                if (exception.getTextCommonError().contains("Mail")) {
                    data.setMail(data.getPhone() + "@" + j + "SpeakWell.com");
                    createStudentPage.EnterInformation();
                    if (exception.CheckNotifyMessage()) {
                        if (exception.getTextNotify().contains(success)) {
                            //Giải quyết xong phần id bos
                            idBos = searchStudentPage.getInformationIdBos();
                            break;
                        } else if (exception.getTextNotify().contains(messageClassIn) || exception.getTextNotify().contains(phoneAndName)) {
                            //Giải quyết xong phần id bos
                            idBos = searchStudentPage.getInformationIdBosExist();
                            break;
                        } else if (exception.getTextNotify().contains(messageMailExist)) {
                            for (int k = j + 1; k < j + 10; k++) {
                                data.setMail(data.getPhone() + "@" + k + "SpeakWell.com");
                                createStudentPage.EnterInformation();
                                if (exception.getTextNotify().contains(success)) {

                                    //Giải quyết xong phần id bos
                                    idBos = searchStudentPage.getInformationIdBos();
                                    break;
                                } else if (exception.getTextNotify().contains(messageClassIn) || exception.getTextNotify().contains(phoneAndName)) {
                                    //Giải quyết xong phần id bos
                                    idBos = searchStudentPage.getInformationIdBosExist();
                                    break;
                                } else {
                                    k++;
                                }
                            }
                            break;
                        }
                    } else {
                        j++;
                    }

                }
            }

        }


        return idBos;
    }
}


