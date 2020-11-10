package p1;

import java.util.List;
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
		resourceList.remove(num);
		size--;
	}
	
	/* This function brings up the editMenu of a Data Resource based on the selected user input.
	 * Takes user input of Data Resource location to be edited.
	 * Returns nothing.
	 */
	public void editDataResource(int num) {
		resourceList.get(num).editMenu();
	}
	
	
}
