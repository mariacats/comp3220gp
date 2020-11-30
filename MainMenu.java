package p1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
	

	public static void main(String[] args) throws IOException{
		
		//normally this would load in a list. if a list doesnt exist, create a new list
		//for now, just create a new list
		DataResourceList drl = new DataResourceList();
		
		Scanner sc = new Scanner(System.in);
		
		//Menu Loop that exists when the User selects 4.
		while (true) {
			//add try catch in case they enter something invalid
			System.out.println("What would you like to do?\n(1) Create a Data Resource.\n(2) Remove a Data Resource.\n(3) Edit an existing Data Resource.\n(4) View Data Resources."
					+ "\n(5) Search for Data Resources. \n(6) Exit.");
			int n = sc.nextInt();
			sc.nextLine();
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
					sc.nextLine();
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
				int j = 0;
				while(j<=0 || j> drl.size) {
					drl.listDataResources();
					System.out.println("Select the number of the Data Resource you wish to edit: ");
					j = sc.nextInt();
					sc.nextLine();
					if(j<=0 || j> drl.size)
						System.out.println("Invalid selection.");
				}
				
				drl.editDataResource(j-1);
				
				break;
			
			//view data resources, view files in data resource, open file
			case 4:
				//check if list is empty. if empty, break
				if(drl.size == 0) {
					System.out.println("There are no Data Resources. Try adding a Data Resource!");
					break;
				}
				//List the Data Resources. User selects the one they want to edit.
				drl.listDataResources();
				int k = 0;
				while(k<=0 || k> drl.size) {
					System.out.println("Select the number of the Data Resource you wish to open: ");
					k = sc.nextInt();
					sc.nextLine();
					if(k<=0 || k> drl.size)
						System.out.println("Invalid selection.");
				}
				
				//display the files within the data resource
				int cond = 0;
				while(cond != 2) {
					System.out.println("Currently viewing Data Resource '"+drl.resourceList.get(k-1).dirName+"'");
					int l = 0;
					while(l <= 0 || l > drl.resourceList.get(k-1).fileList.size()) {
						drl.resourceList.get(k-1).listFiles();
						System.out.println("Select the number of the File you wish to open: ");
						l = sc.nextInt();
						sc.nextLine();
						if(l<=0 || l> drl.resourceList.get(k-1).fileList.size())
							System.out.println("Invalid selection.");
					}
					drl.resourceList.get(k-1).openFile(l-1);
					
					cond = 0;
					while(cond != 1 && cond != 2) {
						System.out.println("Press (1) to open another File. Press (2) to exit.");
						cond = sc.nextInt();
						sc.nextLine();
					}
				}
				break;
			
			//search for data resources
			case 5:
				//check if list is empty. if empty, break
				if(drl.size == 0) {
					System.out.println("There are no Data Resources. Try adding a Data Resource!");
					break;
				}
				//get a search term from the user
				List<Integer> matches;
				String tag;
				System.out.println("Enter the tag you would like to search for: ");
				tag = sc.nextLine();
				
				//search for matches
				matches = drl.searchTags(tag);
				
				if(matches.size() == 0) {
					System.out.println("There were no matches for your search.");
					break;
				}
				//display matches
				System.out.println("The following Data Resources had matching tags: ");
				int m = 0;
				while(m < matches.size()) {
					System.out.println((m+1)+": "+drl.resourceList.get(matches.get(m)).dirName);
					m++;
				}
				
				//get input from user for the data resource they want to open
				int t = 0;
				while(t<1 || t > matches.size()) {
					System.out.println("Enter the number of the Data Resource you wish to open: ");
					t = sc.nextInt();
					sc.nextLine();
					if(t<1 || t>matches.size())
						System.out.println("Invalid Integer.");
				}
				
				//allow the user to open files within the data resource they selected
				int p = 0;
				while(p != 2) {
					System.out.println("Currently viewing Data Resource '"+drl.resourceList.get(matches.get(t-1)).dirName+"'");
					int s = 0;
					while(s <= 0 || s > drl.resourceList.get(matches.get(t-1)).fileList.size()) {
						drl.resourceList.get(matches.get(t-1)).listFiles();
						System.out.println("Select the number of the File you wish to open: ");
						s = sc.nextInt();
						sc.nextLine();
						if(s<=0 || s> drl.resourceList.get(matches.get(t-1)).fileList.size())
							System.out.println("Invalid selection.");
					}
					drl.resourceList.get(matches.get(t-1)).openFile(s-1);
					p=0;
					while(p != 1 && p != 2) {
						System.out.println("Press (1) to open another File. Press (2) to exit.");
						p = sc.nextInt();
						sc.nextLine();
					}
				}
				
				
				
				break;
				
			//Exit the program
			case 6:
				//System.out.println("Saving....");
				System.out.println("Exiting...");
				System.exit(0);
				break;
			
			//Request valid input
			default:
				System.out.println("Please enter a valid input.");
				n = sc.nextInt();
				sc.nextLine();
				break;
			}
		}

	}

}
