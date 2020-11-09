package p1;

import java.util.List;
import java.util.ArrayList;

public class DataResourceList {
	
	List<DataResource> resourceList;
	DataResource dr;
	
	DataResourceList(){
		resourceList = new ArrayList<DataResource>();
	}
	
	DataResourceList(String title, String filename){
		dr = new DataResource (title, filename);
		resourceList.add(dr);
	}
	
	public void addDataResource(DataResource dr) {
		resourceList.add(dr);
	}

}
