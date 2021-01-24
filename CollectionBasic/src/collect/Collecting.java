package collect;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Collecting {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("text.txt"));
		
		List<String> word = new ArrayList<String>();
		
		// first we add each line in the List
		while(scan.hasNextLine()) {
			word.add(scan.nextLine());
//			System.out.println(scan.nextLine());
		}
		
		for (int i = 0; i < word.size(); i++) {
			System.out.println("word: " + word.get(i));
		}
		
//		System.out.println("Give size:");
//		int size = scan.nextInt();
//		
//		int[] grades = new int[size];
//		
//		System.out.println("Enter " + size + " numbers, and press enter after each:");
//		for (int i = 0; i < size; i++) {
//			grades[i] = scan.nextInt();
//		}
//		
//		for (int i = 0; i < size; i++) {
//			System.out.println(grades[i]);
//		}
		
		scan.close();
	}

}
