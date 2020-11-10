package p1;

import java.io.File;
import java.util.Scanner;

public class MainMenu {
	

	public static void main(String[] args) {
		
		//normally this would load in a list. if a list doesnt exist, create a new list
		DataResourceList drl = new DataResourceList();
		
		Scanner sc = new Scanner(System.in);

		while (true) {
			//add try catch in case they enter something invalid
			System.out.println("What would you like to do?\n(1) Create a Data Resource.\n(2) Remove a Data Resource.\n(3) Edit an existing Data Resource.\n(4) Exit.");
			int n = sc.nextInt();
			switch (n) {
			case 1:
				//Create Data Resource
				drl.createDataResource();
				break;
			case 2:
				//check if list is empty
				if(drl.size == 0) {
					System.out.println("There are no Data Resources. Try adding a Data Resource!");
					break;
				}
				drl.listDataResources();
				int i = 0;
				while(i<=0 || i> drl.size) {
					System.out.println("Select the number of the Data Resource you wish to remove: ");
					i = sc.nextInt();
					if(i<=0 || i> drl.size)
						System.out.println("Invalid selection.");
				}
				drl.removeDataResource(i-1);
				break;
			case 3:
				//check if list is empty
				if(drl.size == 0) {
					System.out.println("There are no Data Resources. Try adding a Data Resource!");
					break;
				}
				drl.listDataResources();
				int j = 0;
				while(j<=0 || j> drl.size) {
					System.out.println("Select the number of the Data Resource you wish to edit: ");
					j = sc.nextInt();
					if(j<=0 || j> drl.size)
						System.out.println("Invalid selection.");
				}
				
				drl.editDataResource(j-1);
				
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
