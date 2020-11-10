package p1;

import java.io.File;
import java.util.Scanner;

public class MainMenu {
	

	public static void main(String[] args) {
		
		//normally this would load in a list. if a list doesnt exist, create a new list
		//for now, just create a new list
		DataResourceList drl = new DataResourceList();
		
		Scanner sc = new Scanner(System.in);
		
		//Menu Loop that exists when the User selects 4.
		while (true) {
			//add try catch in case they enter something invalid
			System.out.println("What would you like to do?\n(1) Create a Data Resource.\n(2) Remove a Data Resource.\n(3) Edit an existing Data Resource.\n(4) Exit.");
			int n = sc.nextInt();
			switch (n) {
			
			//Create a Data Resource
			case 1:
				//Create a Data Resource through the DataResourceList object
				drl.createDataResource();
				break;
				
			//Remove a Data Resource
			case 2:
				
				//check if list is empty. if empty, break
				if(drl.size == 0) {
					System.out.println("There are no Data Resources. Try adding a Data Resource!");
					break;
				}
				
				//List the Data Resources. User selects the one they want to remove.
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
				
			//Edit an existing Data Resource
			case 3:
				
				//check if list is empty. if empty, break
				if(drl.size == 0) {
					System.out.println("There are no Data Resources. Try adding a Data Resource!");
					break;
				}
				
				//List the Data Resources. User selects the one they want to edit.
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
			
			//Exit the program
			case 4:
				//System.out.println("Saving....");
				System.out.println("Exiting...");
				System.exit(0);
				break;
			
			//Request valid input
			default:
				System.out.println("Please enter a valid input.");
				n = sc.nextInt();
				break;
			}
		}

	}

}
