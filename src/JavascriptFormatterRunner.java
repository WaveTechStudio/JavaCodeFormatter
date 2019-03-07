import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Waheed Nazir
 */
public class JavascriptFormatterRunner {

    /**
     * Scanner
     */
    private static Scanner input = new Scanner(System.in);
    /**
     *
     */
    private static JavascriptFormatter jssFormatter = new JavascriptFormatter();
    /**
     *
     */
    private static String output = "";


    private static String folderpath = "../JavaScriptFormatter/src/testingFiles/";

    /**
     * Driver class, Execution starts from main method
     *
     * @param args Array strings
     */
    public static void main(String[] args) {
        String fileName = "";
        File file = null;

        System.out.print("Welcome to Javascript Formatter!");

        do {
            System.out.print("\n" + "Please enter a file name: ");
            try {
                fileName = input.nextLine();
                file = new File(folderpath + fileName);
                if (!file.exists()) {
                    System.out.println("File " + fileName + " does not exist.");
                }
            } catch (Exception e) {
                fileName = "";
            }
        } while (fileName.equals("") || !file.exists());

        if (!fileName.equals("")) {
            readFile(fileName);
        }
    }

    /**
     * @param fileName Read data from file and send it for formatting
     */
    public static void readFile(String fileName) {
        File file = new File(folderpath + fileName);
        if (!file.exists()) {
            System.out.println("File " + fileName + " does not exist.");
            return;
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            char readChar;
            while (fis.available() > 0) {
                if (JavascriptFormatter.closeDueToError) {
                    break;
                }
                readChar = (char) fis.read();
                if (readChar == '\n') {
                    continue;
                }
                if (readChar == ' ' || readChar == '{' || readChar == ';' || readChar == '}' || readChar == ')'
                        || readChar == '(') {
                    output = jssFormatter.format(output, "" + readChar);
                } else {
                    output = output + readChar;
                }
            }
            System.out.println("\n----------- Properly formatted program ---------------");
            System.out.print("\n" + output + "\n\n---------Thank you for making your code readable!--------");
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
