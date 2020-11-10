package p1;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;

public class DataResource {
	String dir, dirName;
	List<File> fileList;
	File file;

	DataResource() {
		Scanner sc  = new Scanner(System.in);
		createDirectory();
		addFile();
		int i = 0;
		while (i!=3){
			if(i == 1)
				addFile();
			if(i == 2)
				removeFile();
			
			// Add another or go back to main menu
			System.out.println("Press (1) to add another file. Press (2) to remove a file. Press (3) to return to Main Menu.");
			i = sc.nextInt();
		}

	}

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
			b = f.mkdir();
			if (!b)
				System.out.println("Unable to create a Data Resource with this name. Try another: ");
		}

		System.out.println("Data Resource successfully created!");
		// save directory/name
		this.dirName = dirName;
		this.dir = dir;

	}

	public void addFile(){
		// Get file to add to Data Resource
		Scanner sc = new Scanner(System.in);
		String filepath;
		System.out.println("Enter the pathname of the file you would like to add to your Data Resource: ");
		filepath = sc.nextLine();
		File f = new File(filepath);
		while (!f.exists() || f.isDirectory()) {
			System.out.println("File does not exist or pathname is invalid. Try again: ");
			filepath = sc.nextLine();
			f = new File(filepath);
		}
		
		f.renameTo(new File(this.dir+"\\"+f.getName()));

	}
	
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
		}
	}

}
