package p1;

import java.io.File;
import java.util.Scanner;

public class MainMenu {
	

	public static void main(String[] args) {
		
		//load existing list (doesn't actually load anything at the moment)
		//DataResourceList drl = new DataResourceList();
		
		// add try catch in case they enter something stupid
		System.out.println(
				"What would you like to do?\n(1) Create a Data Resource.\n(2) Remove a Data Resource.\n(3) Edit an existing Data Resource.\n(4) Exit.");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		while (true) {
			switch (n) {
			case 1:
				//Create Data Resource
				DataResource dr = new DataResource();

				break;
			case 2:
				System.out.println("You picked 2");
				break;
			case 3:
				System.out.println("You picked 3");
				break;
			case 4:
				//System.out.println("Saving....");
				System.out.println("Exiting...");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a valid input.");
				n = sc.nextInt();
				break;
			}
		}

	}

}
