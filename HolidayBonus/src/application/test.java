package application;

import java.io.File;
import java.io.FileNotFoundException;

public class test {

	public static void main(String[] args) throws FileNotFoundException {
		TwoDimRaggedArrayUtility f = new TwoDimRaggedArrayUtility();
		HolidayBonus g = new HolidayBonus();
		double[][] dataSet4 = {{-2.5,-5.3,6.1},{-4.4,8.2},{2.3,-7.5},{-4.2,7.3,-5.9,2.6}};
		
		File pp = new File("C:\\Users\\aaron\\OneDrive\\Desktop\\Java\\HolidayBonus\\src\\Data\\dataSet1.txt");
		
		double[][] bonus = f.readFile(pp);
		
		double bonus2 = g.calculateTotalHolidayBonus(dataSet4,2,0,1);
		
		System.out.print(bonus2);
		
	}

}
