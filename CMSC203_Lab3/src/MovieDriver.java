import java.util.Scanner;

public class MovieDriver {

	public static void main(String[] args) {
		boolean bool = true;
		
		
		while(bool) {
			InputMovie();
			bool = TrueOrFalse();
			
		}
		System.out.println("Done.");
	}


	public static boolean TrueOrFalse() {
		String bool;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Do you want to enter another movie? (Y or N)");
		bool = scanner.nextLine();
		
		if(bool.equals("Y") || bool.equals("y")) {
			return true;
		}
		else if(bool.equals("N") || bool.equals("n")) {
			return false;
		}
		else {
			return false;
		}
	}
		
		
	public static void InputMovie() {
		//Variables
		String title, rating;
		int tickets;
		//Scanner
		Scanner input = new Scanner(System.in);
				
		Movie film = new Movie();
				
		//Enter the title of the movie
		System.out.println("Enter the title of the movie.");
		title = input.nextLine();
		film.setTitle(title);
				
		//Enter the rating of the movie
		System.out.println("Enter the movie's rating.");
		rating = input.nextLine();
		film.setRating(rating);
				
		//Enter the number of tickets sold
		System.out.println("Enter the number of tickets sold for " + title + " at your theather.");
		tickets = input.nextInt();
		film.setSoldTickets(tickets);
				
		//Test
		System.out.println("Test: " + film.toString());
	}

}
