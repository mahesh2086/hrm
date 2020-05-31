package automation.hrm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel {
	// create workbook -> create Sheet -> create Row -> create cell -> setCellValue
	// https://www.codejava.net/coding/how-to-write-excel-files-in-java-using-apache-poi
	public static void main(String[] args) {
		String fileName = System.getProperty("user.dir") + "\\TestData\\Data_Write_1.xlsx"; // only path

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Selenium Demo");
		/*
		 * XSSFRow row_0 = sheet.createRow(0); XSSFCell cell_0 = row_0.createCell(0);
		 * cell_0.setCellValue("Hello!");
		 */

		Font f_white = workbook.createFont();
		f_white.setColor(IndexedColors.WHITE.getIndex());

		CellStyle cs_green = workbook.createCellStyle();
		cs_green.setFont(f_white);
		cs_green.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		cs_green.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		CellStyle cs_red = workbook.createCellStyle();
		cs_red.setFont(f_white);
		cs_red.setFillForegroundColor(IndexedColors.RED.getIndex());
		cs_red.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		CellStyle cs_yellow = workbook.createCellStyle();
		cs_yellow.setFont(f_white);
		cs_yellow.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		cs_yellow.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		for (int i = 0; i < 10; i++) {
			XSSFRow row = sheet.createRow(i);

			for (int j = 0; j < 10; j++) {
				XSSFCell cell = row.createCell(j);
				String s = getRandamUserName(10);
				cell.setCellValue(s);
				if (s.contains("A")) {
					cell.setCellStyle(cs_green);
				} else if (s.contains("y")) {
					cell.setCellStyle(cs_red);
				} else {
					cell.setCellStyle(cs_yellow);
				}

			}
		}

		try {
			FileOutputStream fos = new FileOutputStream(new File(fileName));
			workbook.write(fos);
			fos.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static String getRandamUserName(int n) {
//		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +  "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	public static String getPass(int n) {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);
		sb.append("Pass_");
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	public static String getFail(int n) {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);
		sb.append("Fail_");
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

}
