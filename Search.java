import java.io.File;

/**
 * 
 * @author Louis Loock
 *
 * Possible errors:
 * - Program does not control the input for the directory (form could be incorrect)
 * - Program does not control the input for the pattern (form could be incorrect)
 * - It is possible to write "-p", but then there might be no pattern after it, instead there is directly the file/directory
 * - Program does not check weather the given pattern is allowed
 */
public class Search {

	/**
	 * Wrapper class for the private method printDir (additional arguemnt there: 'space' to indent the next recrusive files/directories 
	 * @param file
	 * @param recursion
	 * @param pattern
	 */
	public static void printDir(File file, boolean recursion, String pattern){
		printDir(file, recursion, pattern, "");
	}
	
	/**
	 * Method printDir is going through a file directory (perhaps recursively) and is looking for a given pattern.
	 * If it is going through recursively, it makes tabs for the subdirectories.
	 * @param file is the given directory where this method is looking for a given pattern (regex)
	 * @param recursion tells weather the the program should work recursively
	 * @param pattern is the regex the method compares with the name of the found files/directories
	 * @param space is doing the tabs
	 * @throw IllegalArgumentException if the given file is neither a file nor a directory 
	 */
	private static void printDir(File file, boolean recursion, String pattern, String space){
		if(!file.isDirectory()){
			if(file.isFile()){								// if the given file is indeed a file
				System.out.println(file.getAbsolutePath()); // print this file
				return;										// but then terminate this method
			}
			throw new IllegalArgumentException("Given file is not a directory!");
		}
		if(pattern.length() == 0) pattern = ".*"; 			// is equivalent to a any pattern
		File[] subFiles = file.listFiles();					// write all files of this directory into a File array
		for(File f : subFiles){								// go through this File array
			if(f.getName().matches(pattern)){				// compare file name with pattern
				System.out.println(space + f.getAbsolutePath()); // if match: print file
			}
			if(recursion && f.isDirectory()){				// if recusion is true and the next file is a directory
				printDir(f,recursion,pattern,space+"  ");	// use this method again
			}
		}
	}
	
	public static void main(String[] args) {		
		
		/* Variable initialization */
		File directory; // default file if no file is inserted
		boolean recursion = false;
		String pattern = "";
		String source = "";
		
		/* Read in arguments */
		if(args.length == 0){
			source = ".";
		}else if(args[0].equals("-r")){
			recursion = true;
			if(args[1].equals("-p")){
				System.out.println("Recursion and Pattern Matching.");
				pattern = args[2];
				source = args[3];
			}else{
				System.out.println("Only Recursion from the current directory");
				source = args[1];
			}
		}else if(args[0].equals("-p")){
			System.out.println("Only Pattern Matching in the current directory.");
			pattern = args[1];
			source = args[2];
		}else{
			System.out.println("Only print the current directory");
			source = args[0];
		}
	
		directory = new File(source);
		
		 /* Exceptions */
		if(!directory.exists()){
			throw new IllegalArgumentException("The given directory or file is incorrect!");
		}
		
		System.out.println("Directory/File exists: " + directory.exists());
		System.out.println("File is directory: " + directory.isDirectory());
		System.out.println("File is a file: " + directory.isFile());
		System.out.println("File name: " + directory.getName());
		System.out.println("Short form of the path: " + directory);
		System.out.println("Print absolute path: " + directory.getAbsolutePath());
		System.out.println("Recursion: " + recursion);
		System.out.println("Pattern: " + pattern);
		System.out.println();
		printDir(directory, recursion, pattern);
		
	}

}
