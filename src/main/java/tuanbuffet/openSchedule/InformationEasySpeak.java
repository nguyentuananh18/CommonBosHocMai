package tuanbuffet.openSchedule;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static tuanbuffet.common.Login.login;
import static tuanbuffet.common.WebUI.*;

public class InformationEasySpeak implements Runnable{
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
    private int step;
    private int locator;
    private int numberDayRun1;
    private String daystart1;
    private String productNeedRun;
    private int distance;
    public InformationEasySpeak(int locator,int step,int numberDayRun1,String daystart1,String productNeedRun,int distance){
        this.step = step;
        this.locator = locator;
        this.numberDayRun1 =numberDayRun1;
        this.daystart1 = daystart1;
        this.productNeedRun = productNeedRun;
        this.distance = distance;
    }

    public Date getDateStart(String daystart) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(daystart);
    }
    public void runEsOld(String daystart, int numberDayRun) throws InterruptedException, ParseException {
        try {
            calendar.setTime(getDateStart(daystart1));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        openURL("https://spu.bos.hocmai.com/setting/class-time");
        clickElement(addNewOrUpdateButton);
        for (int i = 0; i < numberDayRun1 ; i++){
            for (int j = locator ; j < productData.EasySpeak.length; j+=step) {
                System.out.println("Mở ca ngày: " + dateFormat.format(calendar.getTime()) + " " + productData.EasySpeak[j][0] + " gói: " + productData.productES + " "+ locator);
                try {
                    EnterInformationES(productData.productES, dateFormat.format(calendar.getTime()), productData.EasySpeak[j][0], productData.EasySpeak[j][1], productData.EasySpeak[j][2]);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            calendar.add(Calendar.DATE,1);
        }

    }
    public void runEsNew(String daystart, int numberDayRun) throws InterruptedException, ParseException {
        try {
            calendar.setTime(getDateStart(daystart1));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        openURL("https://spu.bos.hocmai.com/setting/class-time");
        clickElement(addNewOrUpdateButton);

        for (int i = 0; i < numberDayRun1 ; i++){
            for (int j = locator ; j < productData.EasySpeak.length; j+=step) {
                System.out.println("Mở ca ngày: " + dateFormat.format(calendar.getTime()) + " " + productData.ESP24FAMX_EasySpeakForAdultsMix[j][0] + " gói: " + productData.productESMix + " "+ locator);
                try {
                    EnterInformationES(productData.productESMix, dateFormat.format(calendar.getTime()), productData.ESP24FAMX_EasySpeakForAdultsMix[j][0], productData.ESP24FAMX_EasySpeakForAdultsMix[j][1], productData.ESP24FAMX_EasySpeakForAdultsMix[j][2]);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            calendar.add(Calendar.DATE,1);
        }
    }
    public void EnterInformationES (String product,String dayOpenStudy,String timeStudy, String numberStudy, String numberCredit) throws InterruptedException {
        enterText(dateInput, dayOpenStudy);
        enterText(timeInput,timeStudy);
        try {
            clickElement(By.xpath("//*[@id=\"mui-7-option-0\"]"));
        }
        catch (Exception e){
            clearText(timeInput);
            enterText(timeInput,timeStudy);
            clickElement(By.xpath("//*[@id=\"mui-7-option-0\"]"));
        }
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

    @Override
    public void run() {
        if (productNeedRun.contains("Old")){
            try {
                openBrowserSize(500,850,distance);
                login("hocmai","Hocmai@1234");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                runEsOld("abc",10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            closeBrowser();
        }
        else if (productNeedRun.contains("New")){
            try {
                openBrowserSize(500,850,distance);
                login("hocmai","Hocmai@1234");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                runEsNew("abc",123);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            closeBrowser();
        }
        else {
            try {
                openBrowserSize(500,850,distance);
                login("hocmai","Hocmai@1234");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                runEsOld("abc",10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            try {
                runEsNew("abc",123);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            closeBrowser();
        }
    }


    public static void main(String[] args) {
        /*Thread thread1 = new Thread(new InformationEasySpeak(0,3,5,"16/05/2024","Old")) ;
        Thread thread2 = new Thread(new InformationEasySpeak(1,3,5,"16/05/2024","Old")) ;
        Thread thread3 = new Thread(new InformationEasySpeak(2,3,5,"16/05/2024","New")) ;
        thread1.start();
        thread2.start();
        thread3.start();*/

    }
}
