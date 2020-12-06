package it.unibo.oop.lab.mvc;

import java.util.List;

/**
 * A controller that prints strings and has memory of the strings it printed.
 */
public interface Controller {

    /*
     * This interface must model a simple controller responsible of I/O access. It
     * considers only the standard output, and it is able to print on it.
     * 
     * Write the interface and implement it in a class in such a way that it
     * includes:
     * 
     * 1) A method for setting the next string to print. Null values are not
     * acceptable, and an exception should be produced
     * 
     * 2) A method for getting the next string to print
     * 
     * 3) A method for getting the history of the printed strings (in form of a List
     * of Strings)
     * 
     * 4) A method that prints the current string. If the current string is unset,
     * an IllegalStateException should be thrown
     * 
     */
    /**
     * 1) A method for setting the next string to print. Null values are not
     * acceptable, and an exception should be produced
     * @param s String to be set as nextString
     * @throws NullPointerException
     */
    void setNextString(String s);
    /**
     * A method for getting the next string to print.
     * @return String
     */
    String getNextString();
    /**
     * A method for getting the history of the printed strings (in form of a List
     * of Strings).
     * 
     * @return List<String>
     */
    List<String> getHistoryString();
    /**
     * A method that prints the current string. If the current string is unset,
     * an IllegalStateException should be thrown.
     * @throws IllegalStateException
     */
    void printString();

}
