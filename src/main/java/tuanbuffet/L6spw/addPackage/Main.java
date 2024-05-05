package tuanbuffet.L6spw.addPackage;
import static tuanbuffet.common.Login.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        addPackageAndConfiurationData packageData = new addPackageAndConfiurationData("ST112826","1:2","Thúy Huê");
        PackagePage packagePage = new PackagePage(packageData);
        login("ctvanhnt2","anhnt216836");
        /*packagePage.enterInformationPackage();*/
        ConfigurationPage configurationPage = new ConfigurationPage(packageData);
        configurationPage.OpenTeachAll();
    }
}
