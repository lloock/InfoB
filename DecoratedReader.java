package Blatt8;

import java.io.IOException;
import java.io.Reader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.LineNumberReader;

public class DecoratedReader extends LineNumberReader{

    private String searchPattern;
    private int counter;


    public DecoratedReader(Reader in, String searchPattern) {
        super(in);
        this.searchPattern = searchPattern;


        this.counter = 0;
    }

    @Override
    public String readLine() throws IOException {
        // Reset counter
        this.counter = 0;
        String readLine = super.readLine();
        Pattern p = Pattern.compile(searchPattern);

        try {
            if(readLine != null) {
                Matcher m = p.matcher(readLine);
                while(m.find()) {
                    counter = counter + 1;
                }
            }
        } catch(NullPointerException e) {
            System.out.println(" You did not enter a valid regular expression");
        }
        return readLine;
    }

    @Override
    public int getLineNumber() {
        return super.getLineNumber();
    }

    public int getAmountOfMatches() {
        return this.counter;
    }

}
