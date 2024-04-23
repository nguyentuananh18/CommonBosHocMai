package tuanbuffet.controlExcelFile;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ReadFileExcel {
    public static void main(String[] args) {
        try {
            //Trỏ đến file cần đọc
            FileInputStream excelFile = new FileInputStream(new File("Demo-ApachePOI-Excel.xlsx"));
            //Vào file trên
            Workbook workbook = new XSSFWorkbook(excelFile);

            //điều hướng đên sheet cần thao tác
            Sheet datatypeSheet = workbook.getSheetAt(0);


            DataFormatter fmt = new DataFormatter();

            //duyệt tất cả các hàng trong sheet
            Iterator<Row> iterator = datatypeSheet.iterator();
            //đến dòng đầu tiên
            Row firstRow = iterator.next();

            //đến ô đầu tiên của dòng đầu tiên
            Cell firstCell = firstRow.getCell(0);


            System.out.println(firstCell.getStringCellValue());

            List<ClassInformation> listOfClassInformation = new ArrayList<ClassInformation>();

            //duyệt data trên excel, rồi add vô listOfClassInformation
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                ClassInformation classInformation = new ClassInformation();
                classInformation.setIdST(currentRow.getCell(0).getStringCellValue());
                classInformation.setName(currentRow.getCell(1).getStringCellValue());
                classInformation.setEmail(currentRow.getCell(2).getStringCellValue());
                classInformation.setPhone(currentRow.getCell(3).getStringCellValue());
                classInformation.setClassType(currentRow.getCell(4).getStringCellValue());
                classInformation.setTeacher(currentRow.getCell(5).getStringCellValue());
                classInformation.setSchedule(currentRow.getCell(6).getStringCellValue());
                classInformation.setCurriculum(currentRow.getCell(7).getStringCellValue());
                classInformation.setIdBOS(currentRow.getCell(8).getStringCellValue());
                listOfClassInformation.add(classInformation);
            }


            //chạy thử xem có đúng data k:)))
            for (ClassInformation classInformation : listOfClassInformation) {
                System.out.print("ID: " + classInformation.getIdST());
                System.out.print(" EMAIL: " +classInformation.getEmail());
                System.out.print(" NAME: " +classInformation.getName());
                System.out.print(" PHONE: " +classInformation.getPhone());
                System.out.print(" CLASS TYPE: " +classInformation.getClassType());
                System.out.print(" TEACHER: " +classInformation.getTeacher());
                System.out.print(" SCHEDULE: " +classInformation.getSchedule());
                System.out.print(" CURRICULUM: " +classInformation.getCurriculum());
                System.out.println(" ID BOS: " +classInformation.getIdBOS());
                Thread.sleep(30);
            }
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
