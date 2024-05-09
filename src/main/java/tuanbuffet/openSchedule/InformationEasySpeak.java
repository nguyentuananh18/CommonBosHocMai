package tuanbuffet.openSchedule;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static tuanbuffet.common.WebUI.*;
import static tuanbuffet.common.Login.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class InformationEasySpeak{
    String configPort = "Student Portal";
    private final By addNewOrUpdateButton = By.xpath("//button[contains(text(),'Thêm mới hoặc cập nhật')]");
    private final  By dateInput = By.xpath("//input[@placeholder=\"ngày/tháng/năm\"]");
    private final  By timeInput = By.xpath("/html/body/div/div/main/div[2]/div[2]/form/div[2]/div[2]/div/div/div/div/input");
    private final  By productInput = By.xpath("/html/body/div/div/main/div[2]/div[2]/form/div[3]/div[2]/div/div/div/div/input");
    private final  By numberOfStudy = By.xpath("/html/body/div/div/main/div[2]/div[2]/form/div[4]/div[2]/div/div/input");
    private final  By configInput = By.xpath("/html/body/div/div/main/div[2]/div[2]/form/div[5]/div[2]/div/div/div/div/input");
    private final  By creditCostInput = By.xpath("/html/body/div/div/main/div[2]/div[2]/form/div[6]/div[2]/div/div/div/input");
    private final  By submitButton = By.xpath("//button[@type='submit']");
    ProductData productData = new ProductData();
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);
    public Date getDateStart(String daystart) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(daystart);
    }
    public void runEsOld(String daystart, int numberDayRun) throws InterruptedException, ParseException {
        calendar.setTime(getDateStart(daystart));
        openBrowser();
        login("hocmai","Hocmai@1234");
        openURL("https://spu.bos.hocmai.com/setting/class-time");
        clickElement(addNewOrUpdateButton);

        for (int i = 1; i < numberDayRun ; i++){
            for (String[] information : productData.EasySpeak) {
                System.out.println("Mở ca ngày: " + dateFormat.format(calendar.getTime()) + " " + information[0] + " gói: " + productData.productES);
                EnterInformationES(productData.productES, dateFormat.format(calendar.getTime()), information[0], information[1], information[2]);
            }

            for (String[] information : productData.ESP24FAMX_EasySpeakForAdultsMix) {
                System.out.println("Mở ca ngày: " + dateFormat.format(calendar.getTime()) + " " + information[0] + " gói: " + productData.productESMix);
                EnterInformationES(productData.productESMix, dateFormat.format(calendar.getTime()), information[0], information[1], information[2]);
            }

            calendar.add(Calendar.DATE,1);
        }
    }
    public void runEsNew(String daystart, int numberDayRun) throws InterruptedException, ParseException {
        calendar.setTime(getDateStart(daystart));
        openBrowser();
        login("hocmai","Hocmai@1234");
        openURL("https://spu.bos.hocmai.com/setting/class-time");
        clickElement(addNewOrUpdateButton);

        for (int i = 1; i < numberDayRun ; i++){
            for (String[] information : productData.ESP24FAMX_EasySpeakForAdultsMix) {
                System.out.println("Mở ca ngày: " + dateFormat.format(calendar.getTime()) + " " + information[0] + " gói: " + productData.productESMix);
                EnterInformationES(productData.productESMix, dateFormat.format(calendar.getTime()), information[0], information[1], information[2]);
            }

            calendar.add(Calendar.DATE,1);
        }
    }
    public void EnterInformationES (String product,String dayOpenStudy,String timeStudy, String numberStudy, String numberCredit) throws InterruptedException {
        enterText(dateInput, dayOpenStudy);
        enterText(timeInput,timeStudy);
        clickElement(By.xpath("//*[@id=\"mui-7-option-0\"]"));
        enterText(productInput,product + Keys.DOWN+ Keys.ENTER);
        enterText(numberOfStudy,numberStudy);
        enterText(configInput,configPort + Keys.DOWN + Keys.ENTER);
        enterText(creditCostInput,numberCredit);
        clickElement(submitButton);
        if (getTextElement(By.xpath("//div[@id='notistack-snackbar']")).equals("Schedule Shift ?� tồn tại")){
            openURL("https://spu.bos.hocmai.com/setting/class-time");
            clickElement(addNewOrUpdateButton);
        }
    }
}
