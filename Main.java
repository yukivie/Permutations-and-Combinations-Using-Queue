import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	static Scanner input = new Scanner(System.in);
	
	//Queue
	static Queue<String> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		
		int choice;
		
		do {
			System.out.println("\\n===== PERMUTATION AND COMBINATION =====");
			System.out.println("[1] Add Elements to Queue");
            System.out.println("[2] Display Queue");
            System.out.println("[3] Generate Permutations");
            System.out.println("[4] Generate Combinations");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");
            
            choice = input.nextInt();
            
            switch (choice) {
            
            	case 1:
            		addElements();
            		break;
            		
            	case 2: 
            		displayQueue();
            		break;
            		
            	case 3:
            		generatePermutations();
            		break;
            		
            	case 4: 
            		generateCombinations();
            		break;
            		
            	case 5: 
            		System.out.println("Program terminated.");
            		break;
            		
            	default:
            		System.out.println("Invalid choice!");
            }
            
		}while (choice != 5);
	}
	
	static void addElements() {
		System.out.println("Enter how many elements to add: ");
		int n = input.nextInt();
		
		for (int i = 0; i < n; i++) {
			
			System.out.println("Enter element " + (i + 1) + ": ");
			String element = input.next();
			
			queue.add(element);
			
            }
		
		System.out.println("Elements successfully added!");
		}
	
	static void displayQueue() {
		if(queue.isEmpty()) {
		System.out.println("Queue is empty!");
		}else {
			System.out.println("Queue: " + queue);
		}
	}



	static void dequeueTwo() {
		if (queue.size() < 2) {
			System.out.println("Not enough elements in the Queue");
		}else {
			System.out.println("Removed: " + queue.poll());
			System.out.println("Removed: " + queue.poll());
			
			System.out.println("Updated Queue: " + queue);
		}
	}
	
	static void generatePermutations() {
		if (queue.isEmpty()) {
			System.out.println("Queue is empty!");
			return;
		}
		ArrayList<String>elements = new ArrayList<>(queue);
		
		System.out.println("Enter number of elements to arrange: ");
		int r = input.nextInt();
		
		if (r <= 0 || r > elements.size()) {
			System.out.println("Invalid number of elements");
			return;
		}
		
		int[] count = {0};
		
		boolean[] used = new boolean[elements.size()];
		
		generatePerm(elements, "", used, r, count);
		System.out.println("\nTotal Permutations: " + count[0]);
		
	}
	
	static void generatePerm(ArrayList<String> elements, String result, boolean[] used, int r, int[] count) {
		
		if(result.length() == r) {
			System.out.println(result);
			count[0] ++;
			return;
		}
		
		for(int i = 0; i < elements.size(); i++) {
			 if(!used[i]) {
				 used[i] = true;
				 
				 generatePerm(elements, result + elements.get(i), used, r, count);
				 
				 used[i] = false;
			 }
		}
	}
	static void generateCombinations() {
		
		if(queue.isEmpty()) {
			System.out.println("Queue is empty");
			return;
			 }
		ArrayList<String> elements = new ArrayList<>(queue);
		System.out.println("Enter how manyelements to select: ");
		int r = input.nextInt();
		
		if(r <= 0 || r> elements.size()) {
			System.out.println("Invalid number of elements");
			return;
			
		}
		
		int[] count = {0};
		
		generateComb(elements, "", 0,r, count);
		
		System.out.println("\nTotal Combinations: " + count[0]);
	}
	
	static void generateComb(ArrayList<String> elements, String result, int start, int r, int[] count) {
		if(result.length() == r) {
			System.out.println(result);
 			count[0]++;
 			return;
		}
		
		for (int i = start; i < elements.size(); i++) {
			generateComb(elements,result + elements.get(i), i + 1, r, count);
		}
	
			
	}
}


			

