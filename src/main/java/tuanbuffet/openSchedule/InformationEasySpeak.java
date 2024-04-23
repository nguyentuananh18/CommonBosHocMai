package tuanbuffet.openSchedule;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.time.temporal.ChronoUnit;
import tuanbuffet.common.WebUI;

import static tuanbuffet.common.WebUI.*;
import static tuanbuffet.common.Login.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class InformationEasySpeak{
    String[][] EasySpeak ={
            {"18:00 - 18:30","10","10"},
            {"18:35 - 19:05","10","10"},
            {"19:10 - 19:40","10","10"},
            {"19:45 - 20:15","10","15"},
            {"20:20 - 20:50","10","15"},
            {"20:55 - 21:25","10","15"},
            {"21:30 - 22:00","10","10"},
    };
    String[][] ESP24FAMX_EasySpeakForAdultsMix = {
            {"18:00 - 18:30","10","20"},
            {"18:35 - 19:05","10","20"},
            {"19:10 - 19:40","10","20"},
            {"19:45 - 20:15","10","20"},
            {"20:20 - 20:50","10","20"},
            {"20:55 - 21:25","10","20"},
            {"21:30 - 22:00","10","20"},
    };
    String[] timeStudy = {"18:00 - 18:30", "18:35 - 19:05", "19:10 - 19:40", "19:45 - 20:15", "20:20 - 20:50", "20:55 - 21:25", "21:30 - 22:00"};
    String productName = "ESP24FAMX - Easy Speak For Adults Mix";
    String productES = "ESP - EasySpeak";
    String configPort = "Student Portal";
    private final By addNewOrUpdateButton = By.xpath("//button[contains(text(),'Thêm mới hoặc cập nhật')]");
    private final  By dateInput = By.xpath("//input[@placeholder=\"ngày/tháng/năm\"]");
    private final  By timeInput = By.xpath("/html/body/div/div/main/div[2]/div[2]/form/div[2]/div[2]/div/div/div/div/input");
    private final  By productInput = By.xpath("/html/body/div/div/main/div[2]/div[2]/form/div[3]/div[2]/div/div/div/div/input");
    private final  By numberOfStudy = By.xpath("/html/body/div/div/main/div[2]/div[2]/form/div[4]/div[2]/div/div/input");
    private final  By configInput = By.xpath("/html/body/div/div/main/div[2]/div[2]/form/div[5]/div[2]/div/div/div/div/input");
    private final  By creditCostInput = By.xpath("/html/body/div/div/main/div[2]/div[2]/form/div[6]/div[2]/div/div/div/input");
    private final  By submitButton = By.xpath("//button[@type='submit']");
    private final  By dateLastText = By.xpath("//tbody/tr[1]/td[3]/div/p\n");
    WebUI webUI;
    ProductData productData = new ProductData();
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);
    public void setWebUI( WebUI webUI){
        this.webUI = webUI;
    }
    /*public Date getDateLast() throws ParseException, InterruptedException {
        openURL("https://spu.bos.hocmai.com/setting/class-time");
        Thread.sleep(1000);
        String dateLast = getTextElement(dateLastText);
        return new SimpleDateFormat("dd/MM/yyyy").parse(dateLast);
    }*/
    public Date getDateNow() throws ParseException {
        // Lấy ngày hiện tại
        LocalDate today = LocalDate.now();
        // Tạo một định dạng ngày mới
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateNow = today.format(formatter);
        /*return today.format(formatter);*/
        return new SimpleDateFormat("dd/MM/yyyy").parse(dateNow);
    }
    public Date getDateStart() throws ParseException {
        System.out.println("Nhập ngày bạn muốn chạy : ");
        return new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
    }
    public void run() throws InterruptedException, ParseException {
        int numberDayRun;
        int numberDayStart;
        calendar.setTime(getDateStart());
        System.out.println("Điền số ngày bạn cần chạy: ");
        numberDayRun = sc.nextInt();
        login("hocmai","Hocmai@1234");
        openURL("https://spu.bos.hocmai.com/setting/class-time");
        clickElement(addNewOrUpdateButton);
        for (int i = 1; i < numberDayRun ; i++){
            for (String[] information : EasySpeak) {
                EnterInformationES(productES, dateFormat.format(calendar.getTime()), information[0], information[1], information[2]);
                System.out.println("Mở ca ngày: " + dateFormat.format(calendar.getTime()) + " " + information[0]);
            }
            calendar.add(Calendar.DATE,1);
        }
    }
    public void EnterInformationES (String product,String dayOpenStudy,String timeStudy, String numberStudy, String numberCredit) throws InterruptedException {
        setText(dateInput, dayOpenStudy);
        Thread.sleep(1000);
        setText(timeInput,timeStudy);
        Thread.sleep(1000);
        try {
            clickElement(By.xpath("//*[@id=\"mui-7-option-0\"]"));
        }
        catch (Exception e){
            clickElement(By.xpath("//*[@id=\"mui-7-option-0\"]"));
        }
        setText(productInput,product + Keys.DOWN+ Keys.ENTER);
        setText(numberOfStudy,numberStudy);
        setText(configInput,configPort + Keys.DOWN + Keys.ENTER);
        setText(creditCostInput,numberCredit);
        clickElement(submitButton);
        if (getTextElement(By.xpath("//div[@id='notistack-snackbar']")).equals("Schedule Shift ?� tồn tại")){
            openURL("https://spu.bos.hocmai.com/setting/class-time");
            clickElement(addNewOrUpdateButton);
        }
        Thread.sleep(1000);
    }
}
