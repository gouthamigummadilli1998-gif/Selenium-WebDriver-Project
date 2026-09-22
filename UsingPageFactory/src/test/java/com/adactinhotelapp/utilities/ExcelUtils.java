package com.adactinhotelapp.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private static Workbook workbook;
    private static Sheet sheet;

    // =====================================================
    // Set Excel File
    // =====================================================

    public static void setExcelFile(String filePath, String sheetName)
            throws IOException {

        FileInputStream fis = new FileInputStream(filePath);

        workbook = new XSSFWorkbook(fis);

        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            fis.close();

            throw new IOException(
                "Sheet '" + sheetName + "' not found in Excel file."
            );
        }
    }

    // =====================================================
    // Get Row Count
    // =====================================================

    public static int getRowCount() {

        return sheet.getPhysicalNumberOfRows();
    }

    // =====================================================
    // Get Column Count
    // =====================================================

    public static int getColumnCount() {

        if (sheet.getRow(0) == null) {
            return 0;
        }

        return sheet.getRow(0).getLastCellNum();
    }

    // =====================================================
    // Get Cell Data
    // =====================================================

    public static String getCellData(int rowNum, int colNum) {

        if (sheet == null) {
            throw new IllegalStateException(
                "Excel file is not initialized. Call setExcelFile() first."
            );
        }

        if (sheet.getRow(rowNum) == null) {
            return "";
        }

        if (sheet.getRow(rowNum).getCell(colNum) == null) {
            return "";
        }

        DataFormatter formatter = new DataFormatter();

        return formatter.formatCellValue(
            sheet.getRow(rowNum).getCell(colNum)
        );
    }

    // =====================================================
    // Close Excel
    // =====================================================

    public static void closeExcel() throws IOException {

        if (workbook != null) {

            workbook.close();

            workbook = null;
            sheet = null;
        }
    }
}