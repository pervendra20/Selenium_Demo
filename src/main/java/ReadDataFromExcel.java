import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

    public class ExcelUtils {

        // Method to read Excel data
        public static String readExcelData(String filePath, String sheetName, int rowNum, int colNum) {
            String cellValue = null;
            try {
                // Load the Excel file
                FileInputStream file = new FileInputStream(new File(filePath));
                Workbook workbook = new XSSFWorkbook(file);

                // Get the sheet by name
                Sheet sheet = workbook.getSheet(sheetName);

                // Get the row and cell
                Row row = sheet.getRow(rowNum);
                Cell cell = row.getCell(colNum);

                // Get the cell value based on the cell type
                switch (cell.getCellType()) {
                    case STRING:
                        cellValue = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        cellValue = String.valueOf(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        cellValue = String.valueOf(cell.getBooleanCellValue());
                        break;
                    default:
                        cellValue = "";
                }

                // Close the workbook and file input stream
                workbook.close();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return cellValue;
        }

        public static void main(String[] args) {
            // Example usage
            String filePath = "C:\\path\\to\\your\\excel\\file.xlsx";
            String sheetName = "Sheet1";
            int rowNum = 0;
            int colNum = 0;

            String cellData = readExcelData(filePath, sheetName, rowNum, colNum);
            System.out.println("Data from Excel: " + cellData);
        }
    }






}
