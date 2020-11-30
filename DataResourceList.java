package p1;

import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class DataResourceList {
	
	List<DataResource> resourceList;
	DataResource dr;
	int size;
	
	DataResourceList(){
		//Create an empty List with size 0.
		resourceList = new ArrayList<DataResource>();
		this.size = 0;
	}
	
	
	/* Gather a list of Data Resources that had matching tags
	 * Takes the tag the user wishes to search for as input
	 * Returns a list of integers which hold the location of the Data Resource within resouceList.
	 */
	public List<Integer> searchTags(String tag) {
		List<Integer> matches = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while(i < resourceList.size()) {
			while(j < resourceList.get(i).tagList.size()) {
				
				//if a match is found, add the match int to a list of matches
				if(tag.equalsIgnoreCase(resourceList.get(i).tagList.get(j)))
					matches.add(i);
				j++;
			}
			i++;
		}
		
		return matches;
	}
	
	
	/* This function creates a DataResource, adds it to the ArrayList, then increments size.
	 * No input.
	 * Returns nothing.
	 */
	public void createDataResource() {
		this.dr = new DataResource();
		resourceList.add(this.dr);
		size++;
	}
	
	/* This function numerically lists all the names of Data Resources in the ArrayList.
	 * Takes no input.
	 * Returns nothing.
	 */
	public void listDataResources() {
		int i = 0;
		while(i < resourceList.size()) {
			System.out.println(i+1+": "+resourceList.get(i).dirName);
			i++;
		}
	}
	
	
	/* This function removes a Data Resource based on the selected user input, and decrements size.
	 * Takes user input of Data Resource location to be removed.
	 * Returns nothing.
	 */
	public void removeDataResource(int num) {
		Scanner sc = new Scanner(System.in);
		int i=0;
		while(i != 1 && i != 2) {
			System.out.println("Would you like to delete the folder and its contents?\nPress(1) to Delete, (2) to Keep");
			i = sc.nextInt();
			sc.nextLine();
		}
		if(i == 1) {
			deleteFolder(num);
		}
		resourceList.remove(num);
		size--;
	}
	
	/* Function to delete the contents of a folder, then delete the folder itself
	 * Takes the index of the folder to be deleted
	 * Returns nothing. Deletes the folder and its contents
	 */
	private void deleteFolder(int index) {
		String[] contents = resourceList.get(index).file.list();
		for(String s: contents){
		    File currentFile = new File(resourceList.get(index).file.getPath(),s);
		    currentFile.delete();
		}
		resourceList.get(index).file.delete();
	}
	
	/* This function brings up the editMenu of a Data Resource based on the selected user input.
	 * Takes user input of Data Resource location to be edited.
	 * Returns nothing.
	 */
	public void editDataResource(int num) {
		resourceList.get(num).editMenu();
	}
	
	
}
