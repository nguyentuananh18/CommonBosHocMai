package tuanbuffet.L6spw.createStudent;

import org.openqa.selenium.By;

public class ErrorHandlingPage {
    String URl = "https://spu.bos.hocmai.com/students/";
    By representativeCheck = By.xpath("//input[@name='representative']//parent::span/input");
    By representativeButton = By.xpath("//input[@name='representative']//parent::span");

    public void ErrorHandlingEmailExits(){

    }

}
