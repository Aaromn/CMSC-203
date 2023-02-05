import java.util.Scanner;

public class WiFiDiagnosis {

	public static void main(String[] args) {
		System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work.\n");
		System.out.println("First step: reboot the computer and try to connect.");
		Fixed("Rebooting your computer seemed to work!");
		System.out.println("Second step: reboot the router and try to connect.");
		Fixed("Rebboting the router seemed to work!");
		System.out.println("Thrid step: make sure the cables connecting the router are firmly plugged in and power is getting to the router.");
		Fixed("Checking the router's cables seemed to work!");
		System.out.println("Fourth step: move the computer closer to the router and try to connect.");
		Fixed("Moving the computer closer to the router seemed to work!");
		System.out.println("Fifth step: contact your ISP. \nMake sure your ISP is hooked up to your router.");
		
		

	}
	public static void Fixed(String statement) {
		//Scanner
		Scanner input = new Scanner(System.in);
		
		//logic
		System.out.println("Now you able to connect with the internet? (yes or no)");
		String string = input.nextLine();
		if (string.equals("yes") || string.equals("Yes") || string.equals("YES")) {
			System.out.println(statement);
			input.close();
			System.exit(0);
		}
		else if(string.equals("no") || string.equals("No") || string.equals("NO")){
			return;
		}
		else {
			System.out.println("Please enter yes or no.");
			Fixed(statement);
		}
	}

}
