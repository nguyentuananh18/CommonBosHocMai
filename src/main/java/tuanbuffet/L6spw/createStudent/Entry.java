package tuanbuffet.L6spw.createStudent;

import static tuanbuffet.common.Login.*;

public class Entry {
    public Entry(){

    }
    public String RunCreateStudent(String name, String mail, String phone) throws InterruptedException {
        String messageMailExist = "Email đã tồn tại";
        String messageClassIn = "ClassIn Phone đã tồn tại";
        String phoneAndName = "Họ tên và số điện thoại liên lạc đã tồn tại";
        String success = "Tạo học viên thành công";
        String idBos = "";
        CreateStudentData data;
        CreateStudentPage createStudentPage;
        ExceptionOfCreateStudent exception;
        SearchStudentPage searchStudentPage;
        data = new CreateStudentData(name,mail,phone);
        createStudentPage = new CreateStudentPage(data);
        searchStudentPage = new SearchStudentPage(data);
        exception = new ExceptionOfCreateStudent(data,createStudentPage,searchStudentPage);


        login("ctvanhnt2", "anhnt216836");
            createStudentPage.EnterInformation();
            if (exception.CheckNotifyMessage()){
                if (exception.getTextNotify().contains(success)){
                    System.out.println("Đăng kí thành công!");
                    //Giải quyết xong phần id bos
                    idBos = searchStudentPage.getInformationIdBos();
                }
                else if (exception.getTextNotify().contains(messageClassIn)||exception.getTextNotify().contains(phoneAndName)){
                    System.out.println(exception.getTextNotify());
                    //Giải quyết xong phần id bos
                    idBos = searchStudentPage.getInformationIdBosExist();
                }
                else if (exception.getTextNotify().contains(messageMailExist)){
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
                    System.out.println("Xử Lý lỗi: " + exception.getTextNotify());
                    for (int j = 1 ; j< 10 ; j++){
                        data.setMail(data.getPhone() +"@"+ j + "SpeakWell.com");
                        createStudentPage.EnterInformation();
                        if (exception.getTextNotify().contains(success)){
                            System.out.println("Đăng kí thành công!");
                            //Giải quyết xong phần id bos
                            idBos = searchStudentPage.getInformationIdBos();
                            break;
                        }
                        else if (exception.getTextNotify().contains(messageClassIn)||exception.getTextNotify().contains(phoneAndName)){
                            System.out.println(exception.getTextNotify());
                            //Giải quyết xong phần id bos
                            idBos = searchStudentPage.getInformationIdBosExist();
                            break;
                        }
                    }
                }
            }
            else {
                for (int j = 1 ; j <10; j++){
                    if(exception.getTextCommonError().contains("Mail")){
                        System.out.println("Mail có vấn đề cần fix");
                        data.setMail(data.getPhone()+"@"+ j + "SpeakWell.com" );
                        createStudentPage.EnterInformation();
                        if (exception.CheckNotifyMessage()){
                            if (exception.getTextNotify().contains(success)){
                                System.out.println("Đăng kí thành công!");
                                //Giải quyết xong phần id bos
                                idBos = searchStudentPage.getInformationIdBos();
                                break;
                            }
                            else if (exception.getTextNotify().contains(messageClassIn)||exception.getTextNotify().contains(phoneAndName)){
                                System.out.println(exception.getTextNotify());
                                //Giải quyết xong phần id bos
                                idBos = searchStudentPage.getInformationIdBosExist();
                                break;
                            }
                            else if (exception.getTextNotify().contains(messageMailExist)){
                                for (int k = 1 ; k < 10 ; k++){
                                    data.setMail(data.getPhone() +"@"+ k + "SpeakWell.com");
                                    createStudentPage.EnterInformation();
                                    if (exception.getTextNotify().contains(success)){
                                        System.out.println("Đăng kí thành công!");
                                        //Giải quyết xong phần id bos
                                        idBos = searchStudentPage.getInformationIdBos();
                                        break;
                                    }
                                    else{
                                        System.out.println(exception.getTextNotify());
                                        //Giải quyết xong phần id bos
                                        idBos = searchStudentPage.getInformationIdBosExist();
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    }
                }

            }
        return idBos;
    }
}
