package automation.hrm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVDemo {

	public static void main(String[] args) {
		String fileName = System.getProperty("user.dir") + "\\TestData\\oscar_age_male.csv";
		String fileName2 = System.getProperty("user.dir") + "\\TestData\\FL_insurance_sample.csv";
		
//		
//
//		FileReader fr;
//		try {
//			fr = new FileReader(fileName2);
//			CSVReader reader = new CSVReader(fr);
//
//			String[] line;
//
//			while ((line = reader.readNext()) != null) {
//				System.out.println(">>>"+Arrays.toString(line));
//				
////				System.out.println("Index("+line[0]+") Year ("+line[1]+ ") Age ("+line[2]+") Name ("+line[3]+") Movie ("+line[4]+")");
//				
//
//			}
//
//		} catch (CsvValidationException | IOException e) {
//
//			e.printStackTrace();
//		}
		
		CSVReader reader = Base.readCSVFile(fileName);
		
		for(int i =1; i<11; i++) {
			try {
				String[] line = reader.readNext();
				System.out.println(Arrays.toString(line));
				
			} catch (CsvValidationException | IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
		

	}

}
