package com.cybertek.test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;

    @Test
    public void excel_writing_test() throws IOException {
        // path to our Excel sheet
        String path = "Employees.xlsx";
        // to be able to read from Excel file, we need to load it into FileInputStream object
        FileInputStream fileInputStream = new FileInputStream(path);

        // hierarchy workbook > sheet > row > cell

        workbook = new XSSFWorkbook(fileInputStream);

        // get the sheet
        sheet = workbook.getSheet("Employees");

        //king's row
        row = sheet.getRow(1);


        //king's cell

        cell = row.getCell(1);


        //create and store AdamsCell
        XSSFCell madamCell = sheet.getRow(2).getCell(0);
        System.out.println("Before: " + madamCell);

        // this method will override existing cell
        madamCell.setCellValue("Jorge");

        System.out.println("After: " + madamCell);

        // TODO: CHANGE STEVEN'S NAME TO TOM
        for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Steven")) {
                sheet.getRow(rowNum).getCell(0).setCellValue("Tom");
            }


            //================================================================

            //use fileOutputStream to push changes -> load the file to fileOutputStream
            FileOutputStream fileOutputStream = new FileOutputStream(path);

            workbook.write(fileOutputStream);
            fileInputStream.close();
            fileOutputStream.close();
            workbook.close();


        }
    }
}
