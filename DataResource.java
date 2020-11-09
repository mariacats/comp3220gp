package p1;

import java.awt.List;
import java.io.File;

public class DataResource {
	String title, filename;
	File file;
	
	
	DataResource(String title, String filename){
		this.title = title;
		this.filename = filename;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
}
