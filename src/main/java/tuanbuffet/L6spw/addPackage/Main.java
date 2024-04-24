package tuanbuffet.L6spw.addPackage;
import static tuanbuffet.common.Login.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Data packageData = new Data("ST112826","1:2","Thúy Huê");
        PackagePage packagePage = new PackagePage(packageData);
        login("ctvanhnt2","anhnt216836");
        packagePage.enterInformationPackage();
    }
}
