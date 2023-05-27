package honeyPot;

import java.util.*;
import java.io.*;
//M
//G E T I H N 
public class Main {
	
	//static char letters = 'i';//ArrayList of letters to check//Testing as one
	
	static char a,b,c,d,e,f;
	static char key = 'a';
	static int matchCount = 0;
	static int xRefCount = 0;

	public static void main(String[] args) throws IOException{
		System.out.println("...Beginning file read...");
		//readFileTotal();
		readFileSelect();
		//collectLetters();
		//checkDictionary();
		System.out.println("...End file read...");
	}
	
	static public void readFileTotal() throws IOException {
		try {
			//File inputFile = new File("Family.txt");
			File inputFile = new File("Dictionary.txt");
		    Scanner myReader = new Scanner(inputFile);
			inputFile.createNewFile();
			
			      while (myReader.hasNextLine()) {
			    	  String word = myReader.nextLine();
			    	  System.out.println(word);
			      }
			myReader.close();	
		}
	    catch (FileNotFoundException e) {
	    	System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
	
	static public void readFileSelect() throws IOException {
		
		System.out.println("Printing all words with " + key);
		try {
			File inputFile = new File("Dictionary.txt");
		    Scanner myReader = new Scanner(inputFile);
			inputFile.createNewFile();
			
			      while (myReader.hasNextLine()) {
			    	  String word = myReader.nextLine();
			    	  makeHoney(word);
			      }
			myReader.close();	
		}
	    catch (FileNotFoundException e) {
	    	System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
	
	public static void collectLetters() {

		String tempKey = "";
		String auxLetters = "";
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the key Letter");
		tempKey = in.nextLine();
		key = tempKey.charAt(0);
		System.out.println("Enter the remaining 6 letters:");
		auxLetters = in.nextLine();
		a = auxLetters.charAt(0);
		b = auxLetters.charAt(1);
		c = auxLetters.charAt(2);
		d = auxLetters.charAt(3);
		e = auxLetters.charAt(4);
		f = auxLetters.charAt(5);
		
		in.close();
		
	}
	
	static public void checkDictionary() throws IOException {
		
		int xRefCount = 0; //TESTING
		
		System.out.println("Printing all words with " + key);
		try {
			File inputFile = new File("Dictionary2.txt");
		    Scanner fileReader = new Scanner(inputFile);
			inputFile.createNewFile();
			
			      while (fileReader.hasNextLine()) {
			    	  String word = fileReader.nextLine();
			    	  makeHoney(word);
			    	  
			      }
			fileReader.close();	
		}
	    catch (FileNotFoundException e) {
	    	System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
	
	/*
	static public void testCheckDictionary() throws IOException {
		System.out.println("Testing dictionary check...");
		try {
			File inputFile = new File("Dictionary.txt");
			System.out.println("Input file found...: " + inputFile.getPath());
			
			Scanner fileReader = new Scanner(inputFile);
			System.out.println("File Scanner created...: " + "fileReader");
			
			while (fileReader.hasNextLine()) {
				
				String word  = fileReader.nextLine();
				makeHoney(word);
			}
			fileReader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("An error occurred...");
			e.printStackTrace();
		}
	
	}
	*/
	
	public static void makeHoney(String word) {
		if(boolChecker(word)) {
			System.out.println("Found!-----> " + matchCount + ": " + word);
			matchCount++;
		}	
	}
		
	public static boolean boolChecker(String word) {
		if (check1(word) && check2(word) && check3(word)){
			return true;
		}
		else {
			return false;
		}
	}
		
	public static boolean check1(String word) {
		if (word.length()>3) {
			return true;
		}
		return false;
	}
	
	public static boolean check2(String word) {
		for (int i = 0; i < word.length();i++) {
			if(word.charAt(i) == key) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean check3(String word) {
			int i = 0;
			while (i < word.length()) {
				if (word.charAt(i) == a || word.charAt(i) == b || word.charAt(i) == c || word.charAt(i) == d || word.charAt(i) == e || word.charAt(i) == f || word.charAt(i) == key) {
					i++;
				} else {
					return false;
				}
			}
			return true;
	}
		
}
