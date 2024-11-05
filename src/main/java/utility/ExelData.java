package utility;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

public class ExelData {

    static FileInputStream fileInputStream;
    static XSSFWorkbook xssfWorkbook;
    static XSSFSheet sheet;

    public static String getDataFromCell(String path, String sheetName, int row, int coll) {
        String data;
        try {
            fileInputStream = new FileInputStream(path);
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException exception) {
            exception.getMessage();
        }
        sheet = xssfWorkbook.getSheet(sheetName);
        DataFormatter dataFormatter = new DataFormatter();
        data = dataFormatter.formatCellValue(sheet.getRow(row).getCell(coll));
        return data;
    }


    public static void main(String[] args) throws IOException {

//        // dir my exel  file
//        String path = System.getProperty("user.dir") +
//                File.separator + "src" +
//                File.separator + "main" +
//                File.separator + "resources" +
//                File.separator + "testdata.xlsx";
//        // to read from file in java
//        FileInputStream fileInputStream = new FileInputStream(path);
//        // appache poi to use exel document
//        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
//        XSSFSheet sheet = xssfWorkbook.getSheet("login");
//        DataFormatter dataFormatter = new DataFormatter();// return string no matter the cell format
//        String data = dataFormatter.formatCellValue(sheet.getRow(0).getCell(0));
//        System.out.println(data);
//        System.out.println(sheet.getRow(2).getCell(0));
//                String path = System.getProperty("user.dir") +
//                File.separator + "src" +
//                File.separator + "main" +
//                File.separator + "resources" +
//                File.separator + "testdata.xlsx";
//        System.out.println(ExelData.getDataFromCell(path,"login",1,1));
//
//        String path1 = System.getProperty("user.dir") +
//                File.separator + "src" +
//                File.separator + "main" +
//                File.separator + "resources" +
//                File.separator + "test.xlsx";
//        System.out.println(ExelData.getDataFromCell(path1,"data",0,0));


    }
}
