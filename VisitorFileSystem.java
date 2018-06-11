import java.util.Arrays;
import java.io.File;


public class VisitorFileSystem implements FileVisitable{

    private File file ;
    private boolean recursive;

    public VisitorFileSystem(File filePath, boolean recursive) throws IllegalAccessException {

        try {
            filePath.exists();
            this.file = filePath;
            this.recursive = recursive;

        } catch(Exception e) {
            throw new IllegalAccessException(" The file path " + file.getName() + " does not exist. ");
        }

    }
    @Override
    public int accept(FileVisitor v, File file){
        try{
            file.canRead();
        } catch(SecurityException e) {
            System.out.println ("\t" + file.getName() + " is not readable");
            return v.WEITER;
        }

        int nextMove = -1;
        try{
            file.isDirectory();
            System.out.print("\t" + file.getName());
            if(recursive) {
                System.out.print("| ");
                nextMove =  v.WEITER;
            } else {
                nextMove =  v.STOPPPATH;
            }

            // if the continuation is wanted:
            if(nextMove == 0) {
                File[] fileArray = file.listFiles();
                Arrays.sort(fileArray);
                for(File subFile : fileArray) {
                    if(accept(v, subFile) == v.STOPP) {
                        return v.STOPP;
                    }
                }
                nextMove = v.WEITER;

            }

            return nextMove;

        } catch(SecurityException e) {
            System.out.println ("\t" + file.getName());
            return v.WEITER;
        }
    }

}
