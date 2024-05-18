package tuanbuffet.L6spw.commonL6;
import org.openqa.selenium.By;

import static tuanbuffet.common.WebUI.*;
import static tuanbuffet.L6spw.commonL6.BybyCommon.*;
import static tuanbuffet.common.Login.*;

public class ListTeacherName {



static String url ="https://spu.bos.hocmai.com/teachers";
    public static void main(String[] args) throws InterruptedException {
        String productVietNam = "SPEAKWELL - GV Việt Nam 1:1";
        String proPhil ="SPEAKWELL - GV Philippines 1:1";
        String proNamPhi ="SPEAKWELL - GV Nam Phi 1:1";
        String proUSUK ="SPEAKWELL - GV US/UK 1:1";
        By selectProduct = By.xpath("//input[@placeholder=\"Chọn Sản Phẩm\"]");
        By searchButton = By.xpath("//button[contains(text(),'Tìm Kiếm')]");
        By nextButton = By.xpath("//button[@title='Go to next page']//*[name()='svg']");
        openBrowser();
        login("ctvanhnt2", "anhnt216836");
        openURL(url);
        verifyElementIsDisplay(By.xpath("//h4[normalize-space()='Danh Sách Giáo Viên']"));
        sleep(2);
        enterText(selectProduct,proUSUK);
        sleep(2);
        clickElement(firstOption);
        clickElement(searchButton);
        sleep(5);
        for (int j =0; j<15;j++ ){
            for (int i =1 ; i<= listElements(By.xpath("//table/tbody/tr")); i++){
                if (i % 25 ==0){
                    System.out.println('"' + getTextElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"))+'"' +",");
                }
                else {
                    System.out.print('"' + getTextElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"))+'"' +",");
                }
            }
            clickElement(nextButton);
            sleep(5);
        }




    }
    public String[] teacherPhilippines = {
            "Cha 3","Thea 3","Mary 5","Janine 2","Arabella","Sachi","Pia 1","Mariel 1","Genalyn","Anrose","Yssa 1","Pau 1","Caryl","Maries","Cha 2","Lovely 4","Han 2","Elle 5","Via 2","Jing 1","Preach","Anj 3","Shierma","Jema","Frances 2",
            "Sunshine 2","Mckoy","Anica 1","Trize","Deia 1","Andre 2","Nova 1","Kami","Vira","Frebie","Joy 16","Pauline 2","Sophia","Regine","Rose 10","Kaye 5","Zel 2","Connie","Lyn 4","Cecilia","Ann 7","Rose 9","Kaye 4","Jess 3","Nel 1",
            "Jo 2","Vanessa 3","Jonnah","Vani","Jill 2","Pali","Glecel","Candy 3","Jonna 2","Jeri 1","Cherry 5","Dimple 2","Aby 1","Janice 2","Aubrey 4","Zyra","Aimee","Ricca","Mae 11","Nelyn 1","Mica","Mitch 3","Mercy","Rubi 1","Mailin",
            "Rona 4","Jhoana 2","Liez 1","Dorie","Liedyll","Ira 3","Yani 1","Rofa","Claudine","Krystal 2","Denvert","Joy 12","Jane 11","Karyll","Rizza","Ra 1","Bell 2","Glad 2","Chem","Jirah","Aldine","Kaize","Shayne","Dhiessa","Joy 11",
            "Stephany","Ana 3","Mikay","Mimi 2","Vil 1","Dan 1","Shy 2","Fey","Rose 7","Mitchi","Mae 10","Wiccan","Lyzie","Res 1","Jes 1","Donnah","Shaina 2","Precious 1","Hanna 2","Leng 1","Marie 3","Tine 3","Stela 1","Je 1","Gil 1",
            "Madel","Clarissa 1","Heart 2","Cathy 4","Angel 11","Meghan","EM 1","Axel 2","Shella 2","Grace 7","Mags","Jur 1","Shiela 3","Dee 1","May 5","Joy 9","Justine 2","Felicity","Hannie","Rachel 4","Ali 1","Cath 1","Jessah","Marjorie 2","Kenia",
            "Lene","Manjie","Corbic","Nelle 1","Trisha 3","Pearl 2","Greg 1","Desiree 2","Joy 6","Lai 1","Jaypee 2","Chelle 1","April 5","Ann 6","Bernadette","Mika 1","Kaye 2","Zy 1","Jane 8","Jackie 2","Keen 1","Niel 1","May 4","Angela 2","Glenda",
            "Wenie","Arlyn 1","Bless","Hazel 5","Cathlene","Juvie 2","Amz 1","Marfe 2","Pres 1","Cess 1","Gem 1","Angie 2","Irene 5","JV 1","Maine 1","Shy 1","Angelo 1","Jeff 2","Mavi 1","Jojie 2","Lee 1","Iza 1","Alis 1","Je Avery","May 3",
            "Dhel","Jones 1","Vhea","Apple 4","Roselyn 1","Yam 1","April 3","Jam 6","Anj 2","Airene 1","Lara 2","Kar 1","Yen 2","Mae 8","Cherry 3","Gen 2","Shaina 1","Riztine","Dawn 2","Kite","Ten 1","Thea 2","Christia 1","Dale","Liza 3",
            "Jem 2","Ejhay","Lorie","Khate","Jeanette 1","Jerf","Charlene 1","Jehan","Jen 6","Gen 1","Ann 4","Liberty","Jane 7","Leslie 3","Lester 1","Janssen","Ella 1","Crystel","Norlhynne","Cel 1","Edralyn","Jopher","Honnie","Rose 5","Jam 4",
            "Argon","Kathy","Gina 2","Joie 2","Kate 6","Lyka 4","Joy 4","Lloyd 1","Gummy","Bien 1","Shiela 2","Tam 1","Amber 2","Eve 3","Nimshi","Carree","Queen 2","Aubrey 3","Yuki","Joe 2","Clyde","Lea 4","Eve 2","Andrea","Elsa 1",
            "Cathy 3","Gypsy","Jacque 1","Gwen","Lori","Mj 1","Mikah","Paula 2","Minerva 3","Say","Shen 1","Roxan 2","Ally 2","Alyssa","Ann 3","Lenie","Mollie","Mayfel","Zen 3","Hannah 2","Mari 1","Jona 1","Cheira","Joyce 1","Lyka 2",
            "Arren 1","Pearly","Manie","Monette","Ranica","Melou","Marfe","Sherie","Jhay Ann","Edjes","MaFe","Jennyline","Kittie","Cherry 1","LaraMia","Glaiza 2","Marianne","Karrel","Jean Grace","Darelyn","Majo","Fhe 1","Kelly 2","Han 1","Jensy",
            "Tesa","Odette","Renia","Marte","Jennifer 2","Maria","Rhi","Jane","MaryKris","Shyla","Cybelle","Katelynn","Ghie 1","Chloe Martin","Maedel","Judy 4","Snow Bear","Gladys","Therese 2","Trishamae","Hannah Xi","Via 1","Ma Yee","Jaci","John",
            "Myrabel","Aileen","Jana","Yamamoto","Macy","Sai","Arya","Jhoanna","Ram 2","Mahry","Gerard","Genmar","Christine 2","Pong","Lou","Fegie","Venia","Tinker Trish","Jo Ann","Ally","Mavis","Ryl 2","Ray 1","Flora","Tines",
            "Mally","Jen 3","Melanie 2","Jill","Everleigh","Hauser","Kate 2","Neski","Shawntel","Blossom","Kirby","Christien Joy","Yhanie"
    };
    public String[] teacherVietNam = {"Hữu Quý","Vân Anh 11","Thủy Tiên 6","Thanh Hiền 2","Tuyết Minh 2","Nguyên Ngọc","Hải Ngọc","Huyền Trân 4","Như Ý 5","Hồ Mai","Ngọc Hân 8","Phương Uyên 12","Thùy Linh 10","Thu Trang 5","Thúy Ngọc","Huyền Trang 7","Thúy Hà","Anh Thư 10","Tuyết Nhi 3","Trọng Nghĩa 4","Thái Bình","Nguyên Kha","Thùy Dương 10","Bảo Hiếu","Thanh Nhường",
            "Bảo Anh","Phương Quỳnh 2","Minh Hằng 4","Anh Tuấn 2","Đức Thịnh","Ngọc Nguyên 2","Nguyên Thủy 2","Huệ Thanh","Hải Yến 9","Khánh Linh 17","Thu Sương","Tiến Dũng","Khả Mân","Mỹ Kha","Hồng Lam","Nguyễn Hương 3","Thiên Trang","Minh Phúc","Kiều Vân","Thanh Lan","Mai Anh 2","Thanh Khuê","Tuyết Ngọc","Phương Nga 4","Đông Dương",
            "Triệu My","Thùy Dung 4","Trúc Quỳnh 3","Bình Dương","Thiên Kim","Anh Thư 9","Tâm Tuyền","Mỹ Duyên 7","Minh Khanh","Khánh Ngọc 3","Thanh Vy 3","Quỳnh Anh 6","An Chinh","Hàn Viên","Kim Loan","Thanh Tú","Hằng Nga 2","Nguyễn Thu 2","Nhật Vy","Anh Thy 2","Uyên Phương","Đăng Khoa 3","Thu Hà 3","Thảo Nguyên 3","Minh Thanh 2",
            "Quang Duy 2","Yến Nhi 8","Ngọc Trinh","Huỳnh Ngân","Minh Thư 3","Hoàng Hiền","Song Phương","Hải Yến 8","Tú Hảo","Linh Kha","Minh Nhật 2","Gia Vi","Thành Hiệp","Như Quỳnh 14","Khả Nhi","Thanh Huyên 3","An Khánh","Kim Tuyến","Ái Như","Hương Quỳnh 2","Võ Nghiệp","Trúc Mai 2","Thanh Thúy 4","Ngọc Diệp","Diễm Châu",
            "Thành Đạt 2","Anh Thư 8","Kiều Yên","Tùng Anh","Linh Chi 4","Nguyễn Hồ","Ngọc Thảo 2","Ánh Tuyết","Như Quỳnh 12","Khánh Hà","Thanh Hương 2","Minh Anh 8","Thanh Tuyền 6","Hoàng Lan 2","Thúy Vy 6","Thanh Trúc 5","Khánh Linh 16","Quỳnh Anh 5","Thảo Vy 2","Vân Anh 9","Tống Nhi","Đạo Tâm","Thùy Dương 8","Lê Hạnh","Thanh Tuyền 5",
            "Bích Thủy","Gia Linh","Kim Thảo","Thanh Tuyền 4","Yến Nhi 7","Chí Cường 2","Hải Triều 3","Đức Thuận","Thanh Uyên","Diễm Trang","Minh Hạnh 2","Bảo Trâm 5","Gia Trân","Uyên Trâm","Diễm Trân 2","Tố Hằng","Quý Đạo","Huyền Thương","Hoàng Ngân","Nhựt Hào","Tường Vi 2","Minh Anh 7","Minh Tiến","Ngọc Yến 2","Huyền Trân 3",
            "Ngọc Trân 2","Hạnh Quyên","Khánh Vân","Hải Yến 7","Minh Thi 2","Kiều Diễm","Anh Thư 6","Thu Phương 4","Thanh Duyên","Thu Thanh","Thúy Huê","Thu Thảo 7","Quỳnh Nhi 2","Ngọc Nga","Thảo Hà","Ngọc Anh 10","Thu Trang 4","Quỳnh Trang 2","Thái My","Hoàng Phương 2","Mỹ Duyên 5","Phương Trâm","Minh Thuận 2","Như Quỳnh 11","Trọng Phúc",
            "Quỳnh Hương 2","Thanh Nhã","Như Hiền","Ngọc Nhi 3","Minh Huy","Lã Huyền","Ngọc Thúy","Thúy Hiền","Ngọc Thanh","Thiên Ân 2","Quỳnh Anh 4","Hồng Anh 2","Thu Thủy 6","Phương Nghi","Nhật Khánh","Lường Hậu","Hồng Hạnh 4","Như Quỳnh 10","Minh Hương","Thiên Duyên","Huyền Trang 5","Minh Thuận","Quỳnh Như 8","Tú Anh 2","Nguyễn Cầm",
            "Thành Lợi","Đình Phượng","Ngọc Yến","Hồng Thủy","Hoàng Nhung","Hương Thảo 2","Kim Thu 2","Yến Nhi 6","Trúc Quỳnh 2","Thảo Nguyên 2","Ngọc Thảo","Thu Quyên","Thanh Vy 2","Thu Thảo 5","Ngọc Ánh 7","Bích Uyên","Minh Anh 6","Linh Na","Ngọc Huyền","Kim Phương","Ngọc Quyên","Anh Thy","Phương Linh 5","Thu Huyền 2","Anh Khoa 2",
            "Phương Dung","Ngọc Nhi 2","Khánh Linh 13","Hoài Trinh","Hồng Nhung 10","Lan Chi","Hoàng Hòa","Hải Vy","Khánh Linh 11","Tường Vy 6","Phan Linh","Tú Oanh","Trà My 4","Trọng Nghĩa","Phương Uyên 9","Quỳnh Hoa 2","Yến Linh 4","Nguyễn Hằng","Thu Hương 5","Thu Duyên","Thùy Linh 9","Ngọc Hậu","Hồng Nhung 9","Thanh Thương 2","Thu Thảo 3",
            "Hương Giang","Diễm Thúy 2","Nguyễn Nhi","Phương Nam","Tuệ Tâm","Thu Thảo 2","Gia Băng","Nguyễn Thủy","Ngọc Linh 2","Hồng Thắm","Châu Giang","Bích Ngọc 6","Thanh Huyền","Mai Linh","Khương Duy","Bích Ngọc 3","Cẩm Tiên","Hồng Nhung 5","Bích Ngọc 4","Nguyễn Quỳnh 2","Mỹ Tiên","Kim Phụng","Icanconnect MRP","Hương Ly 2","Đăng Huyền",
            "Thanh Thảo 3","Thanh Xuân","Mỹ Xuyên","Mai Lý","Thu Hương 2","An Hoà","Trịnh Tùng","Quỳnh Anh","Hoàn Mỹ","Thu Hiền 3","Kim Thư","Yến Linh 2","Thiên Hương","Trúc Ly","Kim Chung","Hồng Gấm","Diễm My 2","Nguyễn Quỳnh","Việt Nam","Thanh Tâm 4","Bích Ngọc 5","Tiến Hùng","Trần Thúy","Hồng Vi","Bùi Huyền",
            "Gia Bảo","Diễm Phương","Hồng Ngọc 6","Thúy Lan","Mỹ Hạnh","Kiều Như","Việt Phương","Đông Nghi","Thúy Duy","Phương Thúy","Hồng Nhung 8","Tố An","Tố Uyên","Ký Tuấn","Ngọc Ánh 4","Hoàng Phụng","Kim Yến 2","Ngọc Châu","Thảo Uyên","Vân Anh 3","Ái Vy","Khánh Duy","Phương Thanh 2","Hồng Vân 2","Phương Nga 2",
            "Bích Trâm","Khiết Như","Mỹ Hằng","Hồng Nhi","Thanh Thúy","Thanh Thúy 2","Lê Nhung","Thảo Nguyên","Chu Hồng","Cẩm Trúc","Cẩm Duyên","Nguyễn Hương 2","Kim Ánh 2","Kim Mai","Chi Mai","Vân Anh 4","Đoan Trang","Hoài Phương","Bảo Trâm 2","Tấn Tiền","Ngọc Hiền","Thúy An","Ngọc Hân 3","Bảo Ngọc 4","Phương Huyền",
            "Trần Phương","Vân Anh","Kim Nguyên","Hoài Thương 3","Hoài Thương","Yên Hà","Thu Thủy 3","Ngọc Hồng","Thúy Qua","Thục Đoan","Thanh Giang","Bảo Châu 2","Trà My 3","Mai Phương 2","Quỳnh Nhi","Bá Quận","Thúy Nga 2"
            };
    public String[] teacherNamPhi = {
            "Bron","Kim 4","Jo Mari","Sharon 2","Terry","Cerilea","Jordan","Monique 2","Joe 3","Blake","Rachel","Liz 1","Morne","Toni","Minette","Deon","Nicole 3","Ari"
    };
    public String[] TeacherUSUK = {
            "Nicci","Christian","Tom","Victoria","Carol 2","Angel 2"
    };

}
