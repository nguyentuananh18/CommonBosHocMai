package tuanbuffet.L6spw.createStudent;

import static tuanbuffet.common.Login.login;

public class RunCreateStudentPage {
    public String RunCreateStudent(String name, String mail, String phone) throws InterruptedException {
        String messageMailExist = "Email đã tồn tại";
        String messageClassIn = "ClassIn Phone đã tồn tại";
        String phoneAndName = "Họ tên và số điện thoại liên lạc đã tồn tại";
        String success = "Tạo học viên thành công";

        String idBos = "";
        CreateStudentData data = new CreateStudentData(name, mail, phone);
        CreateStudentPage createStudentPage = new CreateStudentPage(data);
        SearchStudentPage searchStudentPage = new SearchStudentPage(data);
        ExceptionOfCreateStudent exception = new ExceptionOfCreateStudent(data, createStudentPage, searchStudentPage);
        login("ctvanhnt2", "anhnt216836");
        createStudentPage.EnterInformation();


        //Trường hợp web có bắn ra message Notification:
        if (exception.CheckNotifyMessage()) {
            if (exception.getTextNotify().contains(success)) {
                //Giải quyết xong phần id bos
                idBos = searchStudentPage.getInformationIdBos();
            } else if (exception.getTextNotify().contains(messageClassIn) || exception.getTextNotify().contains(phoneAndName)) {
                idBos = searchStudentPage.getInformationIdBosExist();

                //Thông báo mail đã tồn tại
            } else if (exception.getTextNotify().contains(messageMailExist)) {
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
                    } else if (exception.getTextNotify().contains(messageClassIn)
                            ||
                            exception.getTextNotify().contains(phoneAndName)) {

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
    static String[][] information = {
            {"abc","Nguyễn Đức Minh 20","Tranthanhhiep2954@gmail.com","984570017","123","SPU 1:2","Thứbảy:18:35-19:05Chủnhật:18:35-19:06","Kelly 3","Kid's Box Beginners (48)","ST096532"},
            {"abc","Nguyễn Đức Minh 21","Tranthanhhiep2954@gmail.com","984570017","123","SPU 1:1","Thứbảy:18:35-19:05Chủnhật:18:35-19:07","Kelly 4","Kid's Box Beginners (48)","ST096533"},
            {"abc","Nguyễn Đức Minh 22","Tranthanhhiep2954@gmail.com","984570017","123","SPU 1:4","Thứbảy:18:35-19:05Chủnhật:18:35-19:08","Kelly 5","Kid's Box Beginners (48)","ST096534"},
            {"abc","Nguyễn Đức Minh 23","Tranthanhhiep2954@gmail.com","984570017","123","SPU 1:5","Thứbảy:18:35-19:05Chủnhật:18:35-19:09","Kelly 6","Kid's Box Beginners (48)","ST096535"},
            {"abc","Nguyễn Đức Minh 24","Tranthanhhiep2954@gmail.com","984570017","123","SPU 1:6","Thứbảy:18:35-19:05Chủnhật:18:35-19:10","Kelly 7","Kid's Box Beginners (48)","ST096536"},
            {"abc","Nguyễn Đức Minh 25","Tranthanhhiep2954@gmail.com","984570017","123","SPU 1:7","Thứbảy:18:35-19:05Chủnhật:18:35-19:11","Kelly 8","Kid's Box Beginners (48)","ST096537"},
            {"abc","Nguyễn Đức Minh 26","Tranthanhhiep2954@gmail.com","984570017","123","SPU 1:8","Thứbảy:18:35-19:05Chủnhật:18:35-19:12","Kelly 9","Kid's Box Beginners (48)","ST096538"},
    };
}


