package automation.hrm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDemo {

	public static void main(String[] args) {

		String fileName = System.getProperty("user.dir") + "\\TestData\\Data.xlsx"; // only path

		File f = new File(fileName); // read as a file
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);

			// if xlsx -> xssf
			// if xls -> hssf -> HSSFWorkbook
 
			// new XSSFWorkbook(new FileInputStream(new File("xlsx file abs path")))

			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			XSSFSheet sheet1 = workbook.getSheetAt(1);

			XSSFRow row1 = sheet1.getRow(0);
//			System.out.println("Max Rows: "+sheet1.getLastRowNum());
//			System.out.println("Max cells in Row0"+row1.getLastCellNum());
			XSSFCell cell1 = row1.getCell(0);

//			System.out.println("Row: 0 | Cell : 0 (" + cell1.getRawValue() + ")");
			
			for(int row = 0; row <= sheet1.getLastRowNum(); row++) {
				XSSFRow r =  sheet1.getRow(row);
				for(int c = 0; c < r.getLastCellNum(); c++) {
					String v =  r.getCell(c).toString();
					System.out.print("|"+v);
				}
				System.out.println("");
			}

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
