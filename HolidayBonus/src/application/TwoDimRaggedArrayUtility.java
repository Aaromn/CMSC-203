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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

    // Change return type to two dim array
    public static double[][] readFile(java.io.File file) throws java.io.FileNotFoundException{
        
        // Creating final Array
        String[][] tempArray = new String[10][10];
        for (int i = 0; i < tempArray.length; i++) {
            for (int j = 0; j < tempArray[i].length; j++) {
                tempArray[i][j] = null;
            }
        }
        
        // File class
        Scanner scanner = new Scanner(file);
        
        // Add numbers to tempArray
        int columns = 0;
        int rows = 0;
        String[] tempArrayTemp;
        // Use the .split() method or the string tekenizer class to seperate the String
        while (scanner.hasNext()) {
            tempArrayTemp = scanner.nextLine().split(" ", -1);
            for (int i = 0; i < tempArrayTemp.length; i++) {
                tempArray[rows][columns] = tempArrayTemp[i];
                columns++;
            }
            rows++;
            columns = 0;
                
        }
        
        // Creating the final array
        int[] array1 =  new int[tempArray.length];
        for (int i = 0; i < tempArray.length; i++) {
            array1[i] = 0;
            for (int j = 0; j < tempArray[i].length; j++) {
                if (tempArray[i][j] != null){
                    array1[i] += 1;
                }
            }
        }

        
        double[][] finalArray = new double[rows][];
        for (int i = 0; i < rows; i++){
            double[] array2 = new double[array1[i]];
            finalArray[i] = new double[array1[i]];
            for (int j = 0; j < array1[i]; j++) {
                if (tempArray[i][j] != null){
                    array2[j] = Double.parseDouble(tempArray[i][j]);
                }
            }
            for(int h = 0; h < array1[i]; h++){
            }
            finalArray[i] = array2;
        }
        
        scanner.close();
        
        return finalArray;
    }
    
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException{
    	// Create the PrintWriter
    	PrintWriter writer = new PrintWriter(outputFile);
    	
    	for (int i = 0; i < data.length; i++) {
		    for (int j = 0; j < data[i].length; j++) {
		        writer.print(data[i][j] + " ");
		    }
		    writer.println();
		}
    	writer.close();
    }
    
    public static double getTotal(double[][] data) {
    	// Variable to add up total
    	double total = 0;
    	
    	for (int i = 0; i < data.length; i++) {
		    for (int j = 0; j < data[i].length; j++) {
		        total += data[i][j];
		    }
		}
    	return total;
    }
    
    public static double getAverage(double[][] data) {
    	// Variable to get the average
    	double total = 0;
    	int totalNums = 0;
    	
    	for (int i = 0; i < data.length; i++) {
    		totalNums += data[i].length;
		    for (int j = 0; j < data[i].length; j++) {
		        total += data[i][j];
		    }
		}
    	
    	// Final Product
    	double finalProduct = total / totalNums;
    	return finalProduct;
    }
    
    public static double getRowTotal(double[][] data, int row) {
    	// Variable to get the total
    	double total = 0;
    	
    	for (int i = 0; i < data[row].length; i++) {
		    total += data[row][i];
		}
    	
    	return total;
    }
    
    public static double getColumnTotal(double[][] data, int col) {
    	// Variable to get the total
    	double total = 0;
    	
    	for (int i = 0; i < data.length; i++) {
    		try {
    			total += data[i][col];
    		}
    		catch(Exception e) {
    			total += 0;
    		}
		}
    	
    	return total;
    }
    
    public static double getHighestInRow(double[][] data, int row) {
    	// Variable to get the highest value
    	double highest = 0;
    	
    	for (int i = 0; i < data[row].length; i++) {
    		if (data[row][i] > highest) {
	        	highest = data[row][i];
	        }
		}
    	
    	return highest;
    }
    
    public static int getHighestInRowIndex(double[][] data, int row) {
    	// Variable to get the highest value
    	double highest = 0;
    	int index = 0;
    	
    	for (int i = 0; i < data[row].length; i++) {
    		if (data[row][i] > highest) {
	        	highest = data[row][i];
	        	index = i;
	        }
		}
    	
    	return index;
    }
    
    public static double getLowestInRow(double[][] data, int row) {
    	// Variable to get the lowest value
    	double lowest = data[row][0];
    	
    	for (int i = 0; i < data[row].length; i++) {
    		if (data[row][i] < lowest) {
    			lowest = data[row][i];
	        }
		}
    	
    	return lowest;
    }
    
    public static int getLowestInRowIndex(double[][] data, int row) {
    	// Variable to get the lowest value
    	double lowest = data[row][0];
    	int index = 0;
    	
    	for (int i = 0; i < data[row].length; i++) {
    		if (data[row][i] < lowest) {
    			lowest = data[row][i];
    			index = i;
	        }
		}
    	
    	return index;
    }
    
    public static double getHighestInColumn(double[][] data, int col) {
    	// Variable to get the highest
    	double highest = 0;
    	
    	for (int i = 0; i < data.length; i++) {
    		try {
    			if (highest < data[i][col]) {
    				highest = data[i][col];
    			}
    		}
    		catch(Exception e) {
    			highest += 0;
    		}
		}
    	
    	return highest;
    }
    
    public static int getHighestInColumnIndex(double[][] data, int col) {
    	// Variable to get the highest
    	int index = 0;
    	double highest = 0;
    	
    	for (int i = 0; i < data.length; i++) {
    		try {
    			if (highest < data[i][col]) {
    				highest = data[i][col];
    				index = i;
    			}
    		}
    		catch(Exception e) {
    			index += 0;
    		}
		}
    	
    	return index;
    }
    
    public static double getLowestInColumn(double[][] data, int col) {
    	// Variable to get the lowest
    	double lowest = 100000000;
    	
    	for (int i = 0; i < data.length; i++) {
    		try {
    			if (lowest > data[i][col]) {
    				lowest = data[i][col];
    			}
    		}
    		catch(Exception e) {
    			lowest += 0;
    		}
		}
    	
    	return lowest;
    }
    
    public static int getLowestInColumnIndex(double[][] data, int col) {
    	// Variable to get the lowest
    	double lowest = 999999999;
    	int index = 0;
    	
    	for (int i = 0; i < data.length; i++) {
    		try {
    			if (lowest > data[i][col]) {
    				lowest = data[i][col];
    				index = i;
    			}
    		}
    		catch(Exception e) {
    			lowest += 0;
    		}
		}
    	
    	return index;
    }
    
    public static double getHighestInArray(double[][] data) {
    	// Variable to get the highest value
    	double highest = 0;
    	
    	for (int i = 0; i < data.length; i++) {
		    for (int j = 0; j < data[i].length; j++) {
		        if (data[i][j] > highest) {
		        	highest = data[i][j];
		        }
		    }
		}
    	
    	return highest;
    }
    
    public static double getLowestInArray(double[][] data) {
    	// Variable to get the lowest value
    	double lowest = data[0][0];
    	
    	for (int i = 0; i < data.length; i++) {
		    for (int j = 0; j < data[i].length; j++) {
		        if (data[i][j] < lowest) {
		        	lowest = data[i][j];
		        }
		    }
		}
    	
    	return lowest;
    }
    
}