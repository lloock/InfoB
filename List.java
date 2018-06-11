import java.io.File;

public class List {


    public static void main(String[] args) {
        boolean recursive = false;
        String directory;

        if(args.length > 0) {
            if (args[0] == "-r") {
                recursive = true;
                directory = args[1];
            } else{
                directory = args[0];
            }

        } else {
            directory = System.getProperty("user.dir");
        }

        File file = new File(directory);

        System.out.println(" List files: " );

        boolean existing = true;
        VisitorFileSystem system = null;
        try {
            system = new VisitorFileSystem(file, recursive);
        } catch (IllegalAccessException e) {
            System.out.println(" The directory" + directory + " is not existing. ");
            existing = false;
        }
        if(existing) {
            FileVisitor<VisitorFileSystem> visit = new FileVisitor<VisitorFileSystem>() {
                @Override
                public boolean Filevisit(VisitorFileSystem s) {
                    System.out.println(s);
                    return true;
                }
            };

            //System.out.println("Visitor created.");
            system.accept(visit, file);
        }
    }


    }
