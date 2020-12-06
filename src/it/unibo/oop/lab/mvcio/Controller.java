package it.unibo.oop.lab.mvcio;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 */
public class Controller {
    private static final String FILENAME = "Output.txt";
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String PATH = System.getProperty("user.home");
    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file
     */
    private File currentFile;
    public Controller() {
        currentFile = new File(PATH + SEPARATOR + FILENAME); 
    }
    /**
     *Method that set currentFile using the argument path.
     * 
     * @param path Is the path of new file to set how currentFile
     */
    public void setFile(final String path) {
        this.currentFile = new File(path);
    }
    /* 2) A method for getting the current File
     */
    /** 
     * Get the current file.
     * @return currentFile
     */
    public File getFile() {
        return this.currentFile;
    }
    /*3) A method for getting the path (in form of String) of the current File
     */
    /**
     * @return the path of currentFile
     */
    public String getPath() {
        return this.currentFile.getAbsolutePath();
    }
    /* 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     */
    /**
     * This method write on file the string passed by argument.
     * @param s
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void saveStringOnFile(final String s) throws FileNotFoundException, IOException {
    try (DataOutputStream output = new DataOutputStream(
            new FileOutputStream(this.getPath()));) {
        output.writeBytes(s);
        }
    }
    /* 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */

}
