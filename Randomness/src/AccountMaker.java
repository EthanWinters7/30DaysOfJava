import java.util.Scanner;

public class AccountMaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		boolean running = true;
		
		String username = "";
		String password = "";
		
		int size = 0; // max 20
		Account[] account = new Account[20];
		for (int i = 0; i < account.length; i++) {
			account[i] = new Account(username, password);  // not really efficient and a waste of storage
		}
		
		// the main loop
		PROGRAM:
		while (running) {
			System.out.println("Press 1 to sign-in and press 2 to sign-up");
			System.out.println("And press 0 to exit program");
			int sign = scan.nextInt();
			while(sign != 1 && sign != 2 && sign != 0) {
				System.out.println("\nYour only option is 1, 2, or 0");
				System.out.print("Please select again: ");
				sign = scan.nextInt();
			}
			
			// Sign in
			if (sign == 1) {
				if (size == 0) {
					System.out.println("\nNo account is stored\n\n");
					continue PROGRAM;
				}
				else {
					boolean match = false;
					boolean exist = false;
					FIND:
					while (match == false) {
						System.out.print("\nusername: ");
						scan.nextLine();
						username = scan.nextLine();
						System.out.print("password: ");
						password = scan.nextLine();
						for (int i = 0; i < size; i++) {
							if (account[i].getUsername().equals(username)) {
								if (!account[i].getPassword().equals(password)) {
									System.out.println("Incorrect password, please try again");
									continue FIND;
								}else {
									match = true;
									exist = true;
								}
							}
						}
						if (exist == false) {
							System.out.println("The account does not exist\n\n");
							// continue to main loop
							continue PROGRAM;
						}
					}
					match = false;
					exist = false;
				}
			}
			// Sign up
			else if (sign == 2) {
				if (size == 20) {
					System.out.println("\nSorry, you cannot create anymore account.\n\n");
					// continue to main loop
					continue PROGRAM;
				}
				System.out.println("\nPlease choose a username and password");
				System.out.print("username: ");
				scan.nextLine();
				username = scan.nextLine();
				System.out.print("password: ");
				password = scan.nextLine();
				boolean available = true;
				for (int i = 0; i < size; i++) {
					if (account[i].getUsername().equals(username)) {
						System.out.println("Sorry, username is already taken.\n\n");
						available = false;
					}
				}
				if (available == true) {
					size++;
					for (int i = 0; i < size; i++) {
						// when slot is empty
						if (account[i].getUsername().equals("")) {
							account[i].setUsername(username);
							account[i].setPassword(password);
							break;
						}
					}
				}else {
					continue PROGRAM;
				}
			}
			else {
				System.out.println("\n\nBye bye!");
				// break the main loop
				running = false;
				continue PROGRAM;
			}
			
			// Content of the program
			Account current = null;
			String bio;
			for (int i = 0; i < size; i++) {
				if (account[i].getUsername().equals(username)) {
					current = account[i];
					break;
				}
			}
			INSIDE:
			while (true) {
				System.out.println("\nWhat would you like to do?\n");
				System.out.println("\t1. Add bio");
				System.out.println("\t2. Edit bio");
				System.out.println("\t3. View profile");
				System.out.println("\t4. Change password");
				System.out.println("\t5. Sign out\n");
				
				System.out.print("-> ");
				int act = scan.nextInt();
				
				while (act < 1 || act > 5) {
					System.out.println("plaese only select 1 through 5");
					act = scan.nextInt();
				}
				
				switch (act) {
					case 1:
						System.out.println("Add bio to your profile:");
						scan.nextLine();
						bio = scan.nextLine();
						current.setBio(bio);
						break;
					case 2:
						System.out.println("Edit your existing bio:");
						scan.nextLine();
						bio = scan.nextLine();
						current.editBio(bio);
						break;
					case 3:
						System.out.println("\nYour profile:");
						System.out.println(current.getInfo());
						break;
					case 4:
						int counter = 0;
						System.out.print("current password: ");
						scan.nextLine();
						String temp = scan.nextLine();
						System.out.print("new password: ");
						String newPass = scan.nextLine();
						while (!current.getPassword().equals(temp)) {
							counter++;
							System.out.println("\nYour current password was incorrect, please try again");
							System.out.println("(You have " + (3 - counter) + " attemp left)");
							System.out.print("current password: ");
							temp = scan.nextLine();
							System.out.print("new password: ");
							newPass = scan.nextLine();
							if (counter == 3) {
								System.out.println("\nYou have used up all of your attemps, you will be redirected...");
								continue INSIDE;
							}
						}
						current.changePass(newPass);
						System.out.println("Password is successfully changed");
						break;
					case 5:
						System.out.println("signing out...\n\n\n");
						continue PROGRAM;
					default:
						System.out.println("Invalid input");
				}
			}
		}
		scan.close();
	}

}
