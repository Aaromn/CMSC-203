/*
 * Class: CMSC203 
 * Instructor: Professor Tarek
 * Description: A high and low game where a user can guess to find a random number between 0 and 100.
 * Due: 02/08/2023
 * Platform/compiler: 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Aaron Espana Rubio
*/

import java.util.Scanner;


public class RandomNumberGuess {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Header 
		int nextGuess;
		System.out.println("High and low game by Aaron Espana Rubio. \n");
		
		
		// Initialize random number
		int randNum;
		randNum = RNG.rand();
		
		// Guess checker
		int highGuess = 99, lowGuess = 0;
		String bool;
		boolean tf = false;
		
		while(tf == false) {
			System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
			nextGuess = input.nextInt();
			nextGuess = InputValidation(nextGuess, lowGuess, highGuess);
			if (nextGuess < randNum) {
				System.out.println("Your guess is too low.");
				lowGuess = nextGuess;		
			}
			else if(nextGuess > randNum) {
				System.out.println("Your guess is too high.");
				highGuess = nextGuess;
			}
			else {
				System.out.println("Congragulations, you guessed correctly!");
				System.out.println("Try again? (yes or no)");
				bool = input.nextLine();
				bool = input.nextLine();
				if (bool.contains("yes")) {
					tf = false;
					RNG.resetCount();
					highGuess = 99;
					lowGuess = 0;
					randNum = RNG.rand();
				}
				else {
					tf = true;
				}
			}
			System.out.println("Number of guesses is " + RNG.getCount());
		}
		
		
		
		
		System.out.println("Thanks for playing...");
		input.close();
	}

	
	
	// Validates that input is between two arguments
	public static int InputValidation(int nextGuess, int lowGuess, int highGuess) {
		Scanner input = new Scanner(System.in);
		boolean tf;
		do {
			tf = RNG.inputValidation(nextGuess, lowGuess, highGuess);
			if(tf == false) {
				nextGuess = input.nextInt();
			}
		}
		while(tf == false);
		
		
		return nextGuess;
	}
}
