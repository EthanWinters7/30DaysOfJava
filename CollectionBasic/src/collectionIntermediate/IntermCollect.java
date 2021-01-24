package collectionIntermediate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class IntermCollect {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		// the file
		Scanner scan = new Scanner(new File("entry.txt"));
		
		
		// stack
//		Stack<String> number = new Stack<String>();
//		
//		while (scan.hasNextLine()) {
//			number.push(scan.nextLine());
//		}
//		
//		int container = number.size();
//		
//		for (int i = 0; i < container; i++) {
//			System.out.println("entry number: " + number.pop());
//		}
		
//		System.out.println("is it empty: " + number.isEmpty());
		
		
		
		// queue
		Queue<String> number = new PriorityQueue<String>();
		
		while (scan.hasNextLine()) {
			number.add(scan.nextLine());
		}
		
		int container = number.size();
		
		for (int i = 0; i < container; i++) {
			System.out.println("entry number: " + number.poll()); 
		}
		
		System.out.println("is it done: " + number.isEmpty());
		
		
		
		
		scan.close();
	}

}
