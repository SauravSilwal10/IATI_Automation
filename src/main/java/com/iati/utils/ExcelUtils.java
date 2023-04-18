package com.iati.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ExcelUtils {
    public static final String path = "./src/test/resources/testdata/Registration_DataSet.xlsx";
    public static Workbook workbook;
    public static Sheet sheet;

    public static Object[][] getExcelData(String SheetName) {
        Object[][] data = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(SheetName);
            data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                    data[i][j]= (sheet.getRow(i+1).getCell(j).toString());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }


}
