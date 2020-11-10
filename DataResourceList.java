package p1;

import java.util.List;
import java.util.ArrayList;

public class DataResourceList {
	
	List<DataResource> resourceList;
	DataResource dr;
	int size;
	
	DataResourceList(){
		resourceList = new ArrayList<DataResource>();
		this.size = 0;
	}
	
	public void createDataResource() {
		this.dr = new DataResource();
		resourceList.add(this.dr);
		size++;
	}
	
	//list names of Data Resources in list
	public void listDataResources() {
		int i = 0;
		while(i < resourceList.size()) {
			System.out.println(i+1+": "+resourceList.get(i).dirName);
			i++;
		}
	}
	
	
	//remove Data Resource by number
	public void removeDataResource(int num) {
		resourceList.remove(num);
		size--;
	}
	
	public void editDataResource(int num) {
		resourceList.get(num).editMenu();
	}
	
	
}
