package com.cybertek.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {
    /*
     In this method we will help us read from Excel file step by step
     */
    @Test
    public void readFromExcelFile() throws IOException {
        /*
         I'm missing my excel file only. once i get it just copy the path.
         To be able to read from excel file, we need to load it into FileInputStream
         */
        //path of my Excel file
        String path = "Employees.xlsx";

        // To be able to read from Excel file, we need to load it into FileInputStream
        FileInputStream fileInputStream = new FileInputStream(path);

        // this is the hierarchy to work with an Excel sheet --> workbook > sheet > row > cell
        //1. Create workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //2. We need to get the specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        //3. Select the row and cell
        //Print out Steven's cell
        //Indexes start from 0
        System.out.println("sheet.getRow(1).getCell(0) = " + sheet.getRow(1).getCell(0));

        // print out singer from the sheet
        System.out.println("sheet.getRow(3).getCell(2) = " + sheet.getRow(3).getCell(2));

        //Return the count of used cells only
        //If there are cells not used, they will not be counted
        //It will not count empty rows or cells
        //Starts counting from 1
        int usedRows = sheet.getPhysicalNumberOfRows();

        //returns the number from the top cell to bottom cell
        //It does not care if there are any empty cell or not in between names
        //Starts counting from 0
        int lasUsedRow = sheet.getLastRowNum();

        //TODO: 1- CREATE A LOGIC TO PRINT OUT NEENA'S NAME DYNAMICALLY
        //for this logic we will need a forLoop to implement the logic we trying to create
       // for (int i = 0; i < ; i++) then we change it for row cuz we are reading for rows
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            if(sheet.getRow(rowNum).getCell(0).toString().equals("Neena")){
                System.out.println("Current cell= " + sheet.getRow(rowNum).getCell(0));
            }

        }
// TODO: 2-  CREATE A LOGIC TO PRINT OUT STEVEN KING'S JOB ID
//TODO!! CHECK FOR STEVEN'S NAME, IF ITS STEVEN --> PRINT OUT JOB ID

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            if (sheet.getRow(rowNum).getCell(0).toString().equals("Steven")){
                System.out.println("Steven's JOB ID: "+ sheet.getRow(rowNum).getCell(2).toString());
            }

        }


    }
}
