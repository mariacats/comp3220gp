package p1;

import java.util.List; 
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import static java.nio.file.StandardCopyOption.*;

public class DataResource {
	String dir, dirName;
	List<File> fileList;
	File file;
	List<String> tagList;

	DataResource() {
		Scanner sc  = new Scanner(System.in);
		fileList = new ArrayList<File>();
		tagList = new ArrayList<String>();
		createDirectory();
		addFile();
		addTags();
		int i = 0;
		while (i!=4){
			if(i == 1)
				addFile();
			else if(i == 2)
				removeFile();
			else if(i == 3)
				addTags();
			
			// Add another or go back to main menu
			System.out.println("Press (1) to add another file. Press (2) to remove a file. Press (3) to add more tags. Press (4) to return to Main Menu.");
			i = sc.nextInt();
			sc.nextLine();
		}

	}
	
	/* Function to create a directory to act as the Data Resource
	 * Takes no input
	 * Returns nothing. Creates a directory/Data Resource
	 */
	public void createDirectory() {
		Scanner sc = new Scanner(System.in);

		// Get Data Resource name
		String dirName = "";
		String dir = "";
		boolean b = false;
		while (!b) {
			System.out.println("Enter the name of the Data Resource you would like to create: ");
			dirName = sc.nextLine();
			System.out.println("Enter the directory you'd like it saved in: ");
			dir = sc.nextLine();
			dir = dir + dirName;
			File f = new File(dir);
			this.file = f;
			b = f.mkdir();
			if (!b)
				System.out.println("Unable to create a Data Resource with this name. Try another: ");
		}

		System.out.println("Data Resource successfully created!");
		// save directory/name
		this.dirName = dirName;
		this.dir = dir;

	}
	
	/* Function to list the files in the current Data Resource
	 * Takes no input.
	 * Returns nothing. Lists the files
	 */
	public void listFiles() {
		int i = 0;
		while(i < fileList.size()) {
			System.out.println((i+1)+": "+fileList.get(i).getName());
			i++;
		}
	}
	
	/* Function to open a file
	 * Takes file index in list as input
	 * Returns nothing. Opens the file on the user's desktop
	 */
	public void openFile(int i) throws IOException{  
        Desktop desktop = Desktop.getDesktop();
        
        System.out.println("Trying to open file "+fileList.get(i).getAbsolutePath());
        
        //if it exists, open the file
        if(fileList.get(i).exists()) {
        	System.out.println("Opening file...");
        	desktop.open(fileList.get(i));
        }
       
        //else, file doesn't exist so remove it from the list.
        else {
        	System.out.println("File doesn't exist.");
        }
        	//fileList.remove(i);
	}
	
	
	/* Function to add tags to a Data Resource
	 * Takes no input
	 * Returns nothing. Adds Strings(tags) input by the user to tagList.
	 */
	public void addTags() {
		//add tags to your data resource
		Scanner sc = new Scanner(System.in);
		String tag;
		int i = 0;
		while(i != 2) {
			System.out.println("Enter a tag to add to your Data Resource: ");
			tag = sc.nextLine();
			tagList.add(tag);
			i = 0;
			while(i != 1 && i != 2) {
				System.out.println("Press (1) to add another tag. Press (2) to finish.");
				i = sc.nextInt();
				sc.nextLine();
			}
		}
	}
	
	/* Function to add a file to the Data Resource
	 * Takes no input
	 * Returns nothing. Adds a file to the DR
	 */
	public void addFile(){
		// Get file to add to Data Resource
		Scanner sc = new Scanner(System.in);
		String filepath;
		System.out.println("Enter the pathname of the file you would like to add to your Data Resource: ");
		filepath = sc.nextLine();
		File f1 = new File(filepath);
		while (!f1.exists() || f1.isDirectory()) {
			System.out.println("File does not exist or pathname is invalid. Try again: ");
			filepath = sc.nextLine();
			f1 = new File(filepath);
		}
		
		File f2 = new File(this.dir+"\\"+f1.getName());
		//System.out.println("Renaming file to "+this.dir+"\\"+f.getName());
		f1.renameTo(f2);
		System.out.println("f2 = "+f2.getAbsolutePath());
		fileList.add(f2);

	}
	
	/* Function to remove a file from the Data Resource
	 * Takes no input
	 * Returns nothing. Removes a file from the DR
	 */
	public void removeFile() {
		Scanner sc = new Scanner(System.in);
		int in;
		String filepath, reloc;
		
		printDR();
		System.out.println("Enter the name of the file you would like removed from your Data Resource: ");
		filepath = this.dir + "\\" + sc.nextLine();
		System.out.println("Would you like to (1) Delete, or (2) Refactor?: ");
		in = sc.nextInt();
		sc.nextLine();
		if(in == 1) {
			try {
				File f = new File(filepath);
				if(f.delete()) {
					System.out.println("Your file was successfully deleted");
				} else {
					System.out.println("Your file failed to delete. Check if file exists.");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(in == 2) {
			System.out.println("Where you would like to refactor to?: ");
			reloc = sc.nextLine();
			try {
				File f = new File(filepath);
				if(f.renameTo(new File(reloc+"\\"+f.getName()))) {
					System.out.println("Your file was successfully refactored");
				} else {
					System.out.println("Your file failed to refactor. Check if file exists.");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void printDR() {
		String[] fileNames;
		
		File f = new File(this.dir);
		fileNames = f.list();
		for(String fileName : fileNames) {
			System.out.println(fileName);
		}
	}
	
	/* Function to act as a menu during the edit phase
	 * Takes no input
	 * Returns nothing
	 */
	public void editMenu() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		while (i!=3){
			if(i == 1)
				addFile();
			if(i == 2)
				removeFile();
			
			// Add another or go back to main menu
			System.out.println("Press (1) to add a file. Press (2) to remove a file. Press (3) to return to Main Menu.");
			i = sc.nextInt();
			sc.nextLine();
		}
	}

}
