/*
 * Class: CMSC203 
 * Instructor: Professor Tarek
 * Description: A program that calculates bonuses
 * Due: 04/11/2023
 * Platform/compiler: 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Aaron Espana Rubio
*/

package application;

public class HolidayBonus extends java.lang.Object {
	
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		// Variables
		TwoDimRaggedArrayUtility pp = new TwoDimRaggedArrayUtility();
		double[] bonus = new double[data.length];
		
		// Finding the longest row
		int longestRow = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > longestRow) {
				longestRow = data[i].length;
			}
		}
		
		// Finding the lowest performing and highest performing stores
		int num1;
		int num2;
		for (int i = 0; i < longestRow; i++) {
			while (pp.getLowestInColumn(data, i) < 0) {
				data[pp.getLowestInColumnIndex(data, i)][i] = 0;
			}
			
			// Highest performing
			num1 = pp.getHighestInColumnIndex(data, i);
			
			// Lowest performing
			if (pp.getLowestInColumn(data, i) != 0) {
				num2 = pp.getLowestInColumnIndex(data, i);
			}
			else {
				num2  = num1;
			}
			
			if (num1 != num2) {
				bonus[num1] += high;
				bonus[num2] += low;
			}
			else {
				bonus[num1] += high;
			}
			
			for (int j = 0; j < data.length; j++) {
				if (j != num1 && j != num2) {
					try {
						if (data[j][i] != 0) {
							bonus[j] += other;
						}
					}
					catch(Exception e) {
						
					}
				}
			}
		}
		
		return bonus;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		// Variables
		TwoDimRaggedArrayUtility pp = new TwoDimRaggedArrayUtility();
		double total = 0;
		
		// Finding the longest row
		int longestRow = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > longestRow) {
				longestRow = data[i].length;
			}
		}
		
		// Finding the lowest performing and highest performing stores
		int num1;
		int num2;
		for (int i = 0; i < longestRow; i++) {
			
			while (pp.getLowestInColumn(data, i) < 0) {
				data[pp.getLowestInColumnIndex(data, i)][i] = 0;
			}
			
			// Highest performing
			num1 = pp.getHighestInColumnIndex(data, i);
			
			// Lowest performing
			if (pp.getLowestInColumn(data, i) != 0) {
				num2 = pp.getLowestInColumnIndex(data, i);
			}
			else {
				num2  = num1;
			}
			
			if (num1 != num2) {
				total += high;
				total += low;
			}
			else {
				total += high;
			}
			
			for (int j = 0; j < data.length; j++) {
				if (j != num1 && j != num2) {
					try {
						if (data[j][i] != 0) {
							total += other;
						}
					}
					catch(Exception e) {
						
					}
				}
			}
		}
		
		return total;
	}
	
	
	

}
